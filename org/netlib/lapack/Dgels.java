package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.blas.Lsame;
import org.netlib.util.*;

// DGELS solves overdetermined or underdetermined real linear systems
// involving an M-by-N matrix A, or its transpose, using a QR or LQ
// factorization of A.  It is assumed that A has full rank.
//
// The following options are provided:
//
// 1. If TRANS = 'N' and m >= n:  find the least squares solution of
//    an overdetermined system, i.e., solve the least squares problem
//                minimize || B - A*X ||.
//
// 2. If TRANS = 'N' and m < n:  find the minimum norm solution of
//    an underdetermined system A * X = B.
//
// 3. If TRANS = 'T' and m >= n:  find the minimum norm solution of
//    an underdetermined system A**T * X = B.
//
// 4. If TRANS = 'T' and m < n:  find the least squares solution of
//    an overdetermined system, i.e., solve the least squares problem
//                 minimize || B - A**T * X ||.
//
// Several right hand side vectors b and solution vectors x can be
// handled in a single call; they are stored as the columns of the
// M-by-NRHS right hand side matrix B and the N-by-NRHS solution
// matrix X.
public final class Dgels {

    public static void dgels(String trans, int m, int n, int nrhs, double[] a, int _a_offset, int lda, double[] b,
            int _b_offset, int ldb, double[] work, int _work_offset, int lwork, intW info) {

        info.val = 0;
        int mn = Math.min(m, n);
        boolean lquery = (lwork == -1);
        if (!(Lsame.lsame(trans, "N") || Lsame.lsame(trans, "T"))) {
            info.val = -1;
        } else if (m < 0) {
            info.val = -2;
        } else if (n < 0) {
            info.val = -3;
        } else if (nrhs < 0) {
            info.val = -4;
        } else if (lda < Math.max(1, m)) {
            info.val = -6;
        } else if (ldb < Util.max(1, m, n)) {
            info.val = -8;
        } else if (!lquery && lwork < Math.max(1, mn + Math.max(mn, nrhs))) {
            info.val = -10;
        }

        // Figure out optimal block size
        int wsize = 0;
        boolean tpsd = false;
        if (info.val == 0 || info.val == -10) {
            tpsd = true;
            if (Lsame.lsame(trans, "N")) {
                tpsd = false;
            }
            int nb;
            if (m >= n) {
                nb = Ilaenv.ilaenv(1, "DGEQRF", " ", m, n, -1, -1);
                if (tpsd) {
                    nb = Math.max(nb, Ilaenv.ilaenv(1, "DORMQR", "LN", m, nrhs, n, -1));
                } else {
                    nb = Math.max(nb, Ilaenv.ilaenv(1, "DORMQR", "LT", m, nrhs, n, -1));
                }
            } else {
                nb = Ilaenv.ilaenv(1, "DGELQF", " ", m, n, -1, -1);
                if (tpsd) {
                    nb = Math.max(nb, Ilaenv.ilaenv(1, "DORMLQ", "LT", n, nrhs, m, -1));
                } else {
                    nb = Math.max(nb, Ilaenv.ilaenv(1, "DORMLQ", "LN", n, nrhs, m, -1));
                }
            }
            wsize = Math.max(1, mn + Math.max(mn, nrhs) * nb);
            work[_work_offset] = wsize;
        }
        if (info.val != 0) {
            Xerbla.xerbla("DGELS ", -info.val);
            return;
        }
        if (lquery) {
            return;
        }
        // Quick return if possible
        if (Util.min(m, n, nrhs) == 0) {
            Dlaset.dlaset("Full", Math.max(m, n), nrhs, 0.0, 0.0, b, _b_offset, ldb);
            return;
        }

        // Get machine parameters
        doubleW smlnum = new doubleW(1.0020841800044864E-292);
        doubleW bignum = new doubleW(9.979201547673599E291);
        // Scale A, B if max element outside range [SMLNUM,BIGNUM]
        double[] rwork = new double[1];
        double anrm = Dlange.dlange("M", m, n, a, _a_offset, lda, rwork, 0);
        int iascl = 0;
        if (anrm > 0.0 && anrm < smlnum.val) {
            // Scale matrix norm up to SMLNUM
            Dlascl.dlascl("G", 0, 0, anrm, smlnum.val, m, n, a, _a_offset, lda, info);
            iascl = 1;
        } else if (anrm > bignum.val) {
            // Scale matrix norm down to BIGNUM
            Dlascl.dlascl("G", 0, 0, anrm, bignum.val, m, n, a, _a_offset, lda, info);
            iascl = 2;
        } else if (anrm == 0.0) {
            // Matrix all zero. Return zero solution
            Dlaset.dlaset("F", Math.max(m, n), nrhs, 0.0, 0.0, b, _b_offset, ldb);
            work[_work_offset] = wsize;
            return;
        }
        int brow = m;
        if (tpsd) {
            brow = n;
        }
        double bnrm = Dlange.dlange("M", brow, nrhs, b, _b_offset, ldb, rwork, 0);
        int ibscl = 0;
        if (bnrm > 0.0 && bnrm < smlnum.val) {
            // Scale matrix norm up to SMLNUM
            Dlascl.dlascl("G", 0, 0, bnrm, smlnum.val, brow, nrhs, b, _b_offset, ldb, info);
            ibscl = 1;
        } else if (bnrm > bignum.val) {
            // Scale matrix norm down to BIGNUM
            Dlascl.dlascl("G", 0, 0, bnrm, bignum.val, brow, nrhs, b, _b_offset, ldb, info);
            ibscl = 2;
        }
        int scllen = 0;
        if (m >= n) {
            // compute QR factorization of A
            Dgeqrf.dgeqrf(m, n, a, _a_offset, lda, work, _work_offset, work, mn + _work_offset, lwork - mn, info);
            // workspace at least N, optimally N*NB
            if (!tpsd) {
                // Least-Squares Problem min || A * X - B ||
                // B(1:M,1:NRHS) := Q**T * B(1:M,1:NRHS)
                Dormqr.dormqr("Left", "Transpose", m, nrhs, n, a, _a_offset, lda, work, _work_offset, b, _b_offset, ldb,
                        work, mn + _work_offset, lwork - mn, info);
                // workspace at least NRHS, optimally NRHS*NB
                // B(1:N,1:NRHS) := inv(R) * B(1:N,1:NRHS)
                Dtrtrs.dtrtrs("Upper", "No transpose", "Non-unit", n, nrhs, a, _a_offset, lda, b, _b_offset, ldb, info);
                if (info.val > 0) {
                    return;
                }
                scllen = n;
            } else {
                // Underdetermined system of equations A**T * X = B
                // B(1:N,1:NRHS) := inv(R**T) * B(1:N,1:NRHS)
                Dtrtrs.dtrtrs("Upper", "Transpose", "Non-unit", n, nrhs, a, _a_offset, lda, b, _b_offset, ldb, info);
                if (info.val > 0) {
                    return;
                }
                // B(N+1:M,1:NRHS) = 0
                int j = 1;
                for (int p = nrhs; p > 0; p--) {
                    int i = n + 1;
                    for (int q = m - n; q > 0; q--) {
                        b[(i - 1) + (j - 1) * ldb + _b_offset] = 0.0;
                        i++;
                    }

                    j++;
                }

                // B(1:M,1:NRHS) := Q(1:N,:) * B(1:N,1:NRHS)
                Dormqr.dormqr("Left", "No transpose", m, nrhs, n, a, _a_offset, lda, work, _work_offset, b, _b_offset,
                        ldb, work, mn + _work_offset, lwork - mn, info);
                // workspace at least NRHS, optimally NRHS*NB
                scllen = m;
            }
        } else {
            // Compute LQ factorization of A
            Dgelqf.dgelqf(m, n, a, _a_offset, lda, work, _work_offset, work, mn + _work_offset, lwork - mn, info);
            // workspace at least M, optimally M*NB
            if (!tpsd) {
                // underdetermined system of equations A * X = B
                // B(1:M,1:NRHS) := inv(L) * B(1:M,1:NRHS)
                Dtrtrs.dtrtrs("Lower", "No transpose", "Non-unit", m, nrhs, a, _a_offset, lda, b, _b_offset, ldb, info);
                if (info.val > 0) {
                    return;
                }
                // B(M+1:N,1:NRHS) = 0
                int j = 1;
                for (int p = nrhs; p > 0; p--) {
                    int i = m + 1;
                    for (int q = n - m; q > 0; q--) {
                        b[(i - 1) + (j - 1) * ldb + _b_offset] = 0.0;
                        i++;
                    }

                    j++;
                }

                // B(1:N,1:NRHS) := Q(1:N,:)**T * B(1:M,1:NRHS)
                Dormlq.dormlq("Left", "Transpose", n, nrhs, m, a, _a_offset, lda, work, _work_offset, b, _b_offset, ldb,
                        work, mn + _work_offset, lwork - mn, info);
                // workspace at least NRHS, optimally NRHS*NB
                scllen = n;
            } else {
                // overdetermined system min || A**T * X - B ||
                // B(1:N,1:NRHS) := Q * B(1:N,1:NRHS)
                Dormlq.dormlq("Left", "No transpose", n, nrhs, m, a, _a_offset, lda, work, _work_offset, b, _b_offset,
                        ldb, work, mn + _work_offset, lwork - mn, info);
                // workspace at least NRHS, optimally NRHS*NB
                // B(1:M,1:NRHS) := inv(L**T) * B(1:M,1:NRHS)
                Dtrtrs.dtrtrs("Lower", "Transpose", "Non-unit", m, nrhs, a, _a_offset, lda, b, _b_offset, ldb, info);
                if (info.val > 0) {
                    return;
                }
                scllen = m;
            }
        }

        // Undo scaling
        if (iascl == 1) {
            Dlascl.dlascl("G", 0, 0, anrm, smlnum.val, scllen, nrhs, b, _b_offset, ldb, info);
        } else if (iascl == 2) {
            Dlascl.dlascl("G", 0, 0, anrm, bignum.val, scllen, nrhs, b, _b_offset, ldb, info);
        }
        if (ibscl == 1) {
            Dlascl.dlascl("G", 0, 0, smlnum.val, bnrm, scllen, nrhs, b, _b_offset, ldb, info);
        } else if (ibscl == 2) {
            Dlascl.dlascl("G", 0, 0, bignum.val, bnrm, scllen, nrhs, b, _b_offset, ldb, info);
        }

        work[_work_offset] = wsize;
    }
}

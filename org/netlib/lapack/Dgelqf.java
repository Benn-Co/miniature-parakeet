package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

//DGELQF computes an LQ factorization of a real M-by-N matrix A:
//   A = L * Q.
//
// The matrix Q is represented as a product of elementary reflectors
//
//    Q = H(k) . . . H(2) H(1), where k = min(m,n).
//
// Each H(i) has the form
//
//    H(i) = I - tau * v * v**T
//
// where tau is a real scalar, and v is a real vector with
// v(1:i-1) = 0 and v(i) = 1; v(i+1:n) is stored on exit in A(i,i+1:n),
// and tau in TAU(i).
public final class Dgelqf {

    public static void dgelqf(int m, int n, double[] a, int _a_offset, int lda, double[] tau, int _tau_offset,
            double[] work, int _work_offset, int lwork, intW info) {

        info.val = 0;
        int nb = Ilaenv.ilaenv(1, "DGELQF", " ", m, n, -1, -1);
        int lwkopt = m * nb;
        work[_work_offset] = lwkopt;
        boolean lquery = (lwork == -1);

        if (m < 0) {
            info.val = -1;
        } else if (n < 0) {
            info.val = -2;
        } else if (lda < Math.max(1, m)) {
            info.val = -4;
        } else if (!lquery && lwork < Math.max(1, m)) {
            info.val = -7;
        }

        if (info.val != 0) {
            Xerbla.xerbla("DGELQF", -info.val);
            return;
        }

        if (lquery) {
            return;
        }

        // Quick return if possible
        int k = Math.min(m, n);
        if (k == 0) {
            work[_work_offset] = 1;
            return;
        }

        int nbmin = 2;
        int nx = 0;
        int ldwork = 0;
        int iws = m;
        if (nb > 1 && nb < k) {
            // Determine when to cross over from blocked to unblocked code
            nx = Math.max(0, Ilaenv.ilaenv(3, "DGELQF", " ", m, n, -1, -1));
            if (nx < k) {
                // Determine if workspace is large enough for blocked code
                ldwork = m;
                iws = ldwork * nb;
                if (lwork < iws) {
                    // Not enough workspace to use optimal NB: reduce NB
                    // and determine the minimum value of NB
                    nb = lwork / ldwork;
                    nbmin = Math.max(2, Ilaenv.ilaenv(2, "DGELQF", " ", m, n, -1, -1));
                }
            }
        }
        int i = 0;
        if (nb >= nbmin && nb < k && nx < k) {
            // Use blocked code initially
            i = 1;
            for (int p = (k - nx - 1 + nb) / nb; p > 0; p--) {
                int ib = Math.min(k - i + 1, nb);
                // Compute the LQ factorization of the current block
                // A(i:i+ib-1,i:n)
                Dgelq2.dgelq2(ib, n - i + 1, a, i - 1 + (i - 1) * lda + _a_offset, lda, tau, i - 1 + _tau_offset, work,
                        _work_offset, refInfo);
                if (i + ib <= m) {
                    // Form the triangular factor of the block reflector
                    // H = H(i) H(i+1) . . . H(i+ib-1)
                    Dlarft.dlarft("Forward", "Rowwise", n - i + 1, ib, a, i - 1 + (i - 1) * lda + _a_offset, lda, tau,
                            i - 1 + _tau_offset, work, _work_offset, ldwork);
                    // Apply H to A(i+ib:m,i:n) from the right
                    Dlarfb.dlarfb("Right", "No transpose", "Forward", "Rowwise", m - i - ib + 1, n - i + 1, ib, a,
                            i - 1 + (i - 1) * lda + _a_offset, lda, work, _work_offset, ldwork, a,
                            i + ib - 1 + (i - 1) * lda + _a_offset, lda, work, ib + _work_offset, ldwork);
                }
                i += nb;
            }
        } else {
            i = 1;
        }
        // Use unblocked code to factor the last or only block
        if (i <= k) {
            Dgelq2.dgelq2(m - i + 1, n - i + 1, a, i - 1 + (i - 1) * lda + _a_offset, lda, tau, i - 1 + _tau_offset,
                    work, _work_offset, refInfo);
        }
        work[_work_offset] = iws;
    }

    private static final intW refInfo = new intW(0);
}

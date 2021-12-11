package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

// DGEQRF computes a QR factorization of a real M-by-N matrix A:
//    A = Q * R.
//
// The matrix Q is represented as a product of elementary reflectors
//
//    Q = H(1) H(2) . . . H(k), where k = min(m,n).
//
// Each H(i) has the form
//
//    H(i) = I - tau * v * v'
//
// where tau is a real scalar, and v is a real vector with
// v(1:i-1) = 0 and v(i) = 1; v(i+1:m) is stored on exit in A(i+1:m,i),
// and tau in TAU(i).
public final class Dgeqrf {

    public static void dgeqrf(int m, int n, double[] a, int _a_offset, int lda, double[] tau, int _tau_offset,
            double[] work, int _work_offset, int lwork, intW info) {

        info.val = 0;
        int nb = Ilaenv.ilaenv(1, "DGEQRF", " ", m, n, -1, -1);
        int lwkopt = n * nb;
        work[_work_offset] = lwkopt;
        boolean lquery = (lwork == -1);

        if (m < 0) {
            info.val = -1;
        } else if (n < 0) {
            info.val = -2;
        } else if (lda < Math.max(1, m)) {
            info.val = -4;
        } else if (!lquery && lwork < Math.max(1, n)) {
            info.val = -7;
        }

        if (info.val != 0) {
            Xerbla.xerbla("DGEQRF", -info.val);
            return;
        }

        if (lquery) {
            return;
        }
        int k = Math.min(m, n);
        if (k == 0) {
            work[_work_offset] = 1;
            return;
        }
        int nbmin = 2;
        int ldwork = 0;
        int nx = 0;
        int iws = n;
        if (nb > 1 && nb < k) {
            nx = Math.max(0, Ilaenv.ilaenv(3, "DGEQRF", " ", m, n, -1, -1));
            if (nx < k) {
                ldwork = n;
                iws = ldwork * nb;
                if (lwork < iws) {
                    nb = lwork / ldwork;
                    nbmin = Math.max(2, Ilaenv.ilaenv(2, "DGEQRF", " ", m, n, -1, -1));
                }
            }
        }
        int i = 0;
        if (nb >= nbmin && nb < k && nx < k) {
            i = 1;
            for (int p = (k - nx - 1 + nb) / nb; p > 0; p--) {
                int ib = Math.min(k - i + 1, nb);
                Dgeqr2.dgeqr2(m - i + 1, ib, a, i - 1 + (i - 1) * lda + _a_offset, lda, tau, i - 1 + _tau_offset, work,
                        _work_offset, refInfo);
                if (i + ib <= n) {
                    Dlarft.dlarft("Forward", "Columnwise", (m - i) + 1, ib, a, i - 1 + (i - 1) * lda + _a_offset, lda,
                            tau, i - 1 + _tau_offset, work, _work_offset, ldwork);
                    Dlarfb.dlarfb("Left", "Transpose", "Forward", "Columnwise", m - i + 1, n - i - ib + 1, ib, a,
                            i - 1 + (i - 1) * lda + _a_offset, lda, work, _work_offset, ldwork, a,
                            i - 1 + (i + ib - 1) * lda + _a_offset, lda, work, ib + _work_offset, ldwork);
                }
                i += nb;
            }

        } else {
            i = 1;
        }
        if (i <= k) {
            Dgeqr2.dgeqr2(m - i + 1, n - i + 1, a, i - 1 + (i - 1) * lda + _a_offset, lda, tau, i - 1 + _tau_offset,
                    work, _work_offset, refInfo);
        }
        work[_work_offset] = iws;
    }

    private static final intW refInfo = new intW(0);
}

package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

// DGEHD2 reduces a real general matrix A to upper Hessenberg form H by
// an orthogonal similarity transformation:  Q**T * A * Q = H .
public final class Dgehd2 {

    public static void dgehd2(int n, int ilo, int ihi, double[] a, int _a_offset, int lda, double[] tau,
            int _tau_offset, double[] work, int _work_offset, intW info) {

        info.val = 0;
        if (n < 0)
            info.val = -1;
        else if (ilo < 1 || ilo > Math.max(1, n))
            info.val = -2;
        else if (ihi < Math.min(ilo, n) || ihi > n)
            info.val = -3;
        else if (lda < Math.max(1, n))
            info.val = -5;
        if (info.val != 0) {
            Xerbla.xerbla("DGEHD2", -info.val);
            return;
        }

        int i = ilo;

        doubleW dw1 = new doubleW(0.0);
        doubleW dw2 = new doubleW(0.0);

        for (int k = ihi - ilo; k > 0; k--) {

            // Compute elementary reflector H(i) to annihilate A(i+2:ihi,i)
            dlarfg_adapter(ihi - i, a, i + (i - 1) * lda + _a_offset, a,
                    (Math.min(i + 2, n) - 1) + (i - 1) * lda + _a_offset, 1, tau, (i - 1) + _tau_offset, dw1, dw2);

            double aii = a[i + (i - 1) * lda + _a_offset];

            a[i + (i - 1) * lda + _a_offset] = 1.0;

            // Apply H(i) to A(1:ihi,i+1:ihi) from the right
            Dlarf.dlarf("Right", ihi, ihi - i, a, i + (i - 1) * lda + _a_offset, 1, tau[i - 1 + _tau_offset], a,
                    i * lda + _a_offset, lda, work, _work_offset);

            // Apply H(i) to A(i+1:ihi,i+1:n) from the left
            Dlarf.dlarf("Left", ihi - i, n - i, a, i + (i - 1) * lda + _a_offset, 1, tau[i - 1 + _tau_offset], a,
                    i + i * lda + _a_offset, lda, work, _work_offset);

            a[i + (i - 1) * lda + _a_offset] = aii;
            i++;
        }

    }

    private static void dlarfg_adapter(int i, double[] a, int j, double[] b, int k, int l, double[] c, int m,
            doubleW dw1, doubleW dw2) {
        dw1.val = a[j];
        dw2.val = c[m];
        Dlarfg.dlarfg(i, dw1, b, k, l, dw2);
        a[j] = dw1.val;
        c[m] = dw2.val;
    }
}

package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

// DGELQ2 computes an LQ factorization of a real m by n matrix A:
//    A = L * Q.
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
public final class Dgelq2 {

    public static void dgelq2(int m, int n, double[] a, int _a_offset, int lda, double[] tau, int _tau_offset,
            double[] work, int _work_offset, intW info) {

        info.val = 0;
        if (m < 0) {
            info.val = -1;
        } else if (n < 0) {
            info.val = -2;
        } else if (lda < Math.max(1, m)) {
            info.val = -4;
        }

        if (info.val != 0) {
            Xerbla.xerbla("DGELQ2", -info.val);
            return;
        }

        int k = Math.min(m, n);
        doubleW a1Val = new doubleW(0.0);
        doubleW tauVal = new doubleW(0.0);

        int i = 1;
        for (int p = k; p > 0; p--) {
            // Generate elementary reflector H(i) to annihilate A(i,i+1:n)
            dlarfg_adapter(n - i + 1, a, i - 1 + (i - 1) * lda + _a_offset, a,
                    i - 1 + (Math.min(i + 1, n) - 1) * lda + _a_offset, lda, tau, i - 1 + _tau_offset, a1Val, tauVal);
            if (i < m) {
                // Apply H(i) to A(i+1:m,i:n) from the right
                double aii = a[i - 1 + (i - 1) * lda + _a_offset];
                a[i - 1 + (i - 1) * lda + _a_offset] = 1.0;
                Dlarf.dlarf("Right", m - i, n - i + 1, a, i - 1 + (i - 1) * lda + _a_offset, lda,
                        tau[i - 1 + _tau_offset], a, i + (i - 1) * lda + _a_offset, lda, work, _work_offset);
                a[i - 1 + (i - 1) * lda + _a_offset] = aii;
            }
            i++;
        }
    }

    private static void dlarfg_adapter(int i, double[] a1, int idxA1, double[] a2, int off, int inc, double[] tau,
            int idxTau, doubleW a1Val, doubleW tauVal) {
        a1Val.val = a1[idxA1];
        tauVal.val = tau[idxTau];
        Dlarfg.dlarfg(i, a1Val, a2, off, inc, tauVal);
        a1[idxA1] = a1Val.val;
        tau[idxTau] = tauVal.val;
    }
}

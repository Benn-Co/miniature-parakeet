package org.netlib.blas;

import org.netlib.err.Xerbla;

// DGER performs the rank 1 operation A := alpha*x*y**T + A,
// where alpha is a scalar, x is an m element vector, y is
// an n element vector and A is an m by n matrix.
public final class Dger {

    public static void dger(int m, int n, double alpha, double[] x, int _x_offset, int incx, double[] y, int _y_offset,
            int incy, double[] a, int _a_offset, int lda) {

        int info = 0;
        if (m < 0) {
            info = 1;
        } else if (n < 0) {
            info = 2;
        } else if (incx == 0) {
            info = 5;
        } else if (incy == 0) {
            info = 7;
        } else if (lda < Math.max(1, m)) {
            info = 9;
        }
        if (info != 0) {
            Xerbla.xerbla("DGER  ", info);
            return;
        }
        if ((m == 0 || n == 0) || alpha == 0.0) {
            return;
        }

        int jy = 0;
        if (incy > 0) {
            jy = 1;
        } else {
            jy = 1 - (n - 1) * incy;
        }
        if (incx == 1) {
            int j = 1;
            for (int p = n; p > 0; p--) {
                if (y[jy - 1 + _y_offset] != 0.0) {
                    double temp = alpha * y[jy - 1 + _y_offset];
                    int i = 1;
                    for (int q = m; q > 0; q--) {
                        a[i - 1 + (j - 1) * lda + _a_offset] = a[i - 1 + (j - 1) * lda + _a_offset]
                                + x[i - 1 + _x_offset] * temp;
                        i++;
                    }
                }
                jy += incy;
                j++;
            }
        } else {
            int kx;
            if (incx > 0) {
                kx = 1;
            } else {
                kx = 1 - (m - 1) * incx;
            }
            int j = 1;
            for (int p = n; p > 0; p--) {
                if (y[jy - 1 + _y_offset] != 0.0) {
                    double temp = alpha * y[jy - 1 + _y_offset];
                    int ix = kx;
                    int i = 1;
                    for (int q = m; q > 0; q--) {
                        a[i - 1 + (j - 1) * lda + _a_offset] = a[i - 1 + (j - 1) * lda + _a_offset]
                                + x[ix - 1 + _x_offset] * temp;
                        ix += incx;
                        i++;
                    }

                }
                jy += incy;
                j++;
            }
        }
    }
}

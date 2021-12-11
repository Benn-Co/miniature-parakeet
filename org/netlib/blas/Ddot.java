package org.netlib.blas;

// DDOT forms the dot product of two vectors.
public final class Ddot {

    public static double ddot(int n, double[] dx, int _dx_offset, int incx, double[] dy,
            int _dy_offset, int incy) {

        if (n <= 0) {
            return 0.0;
        }

        double ddot = 0.0;

        // code for unequal increments or equal increments
        // not equal to 1
        if (incx != 1 || incy != 1) {
            int k = 1;
            int l = 1;
            if (incx < 0) {
                k = (-n + 1) * incx + 1;
            }
            if (incy < 0) {
                l = (-n + 1) * incy + 1;
            }

            for (int q = n; q > 0; q--) {
                ddot += dx[k - 1 + _dx_offset] * dy[l - 1 + _dy_offset];
                k += incx;
                l += incy;
            }

            return ddot;
        }

        // code for both increments equal to 1
        for (int i = 0; i < n; ++i) {
            ddot += dx[i + _dx_offset] * dy[i + _dy_offset];
        }
        return ddot;
    }
}

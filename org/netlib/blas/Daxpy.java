package org.netlib.blas;

// constant times a vector plus a vector.
public final class Daxpy {

    public static void daxpy(int n, double da, double[] dx, int _dx_offset, int incx,
            double[] dy, int _dy_offset, int incy) {

        if (n <= 0 || da == 0.0) {
            return;
        }

        if (incx != 1 || incy != 1) {
            // code for unequal increments or equal increments
            // not equal to 1
            int ix = 1;
            int iy = 1;
            if (incx < 0) {
                ix = (-n + 1) * incx + 1;
            }
            if (incy < 0) {
                iy = (-n + 1) * incy + 1;
            }
            for (int k = n; k > 0; k--) {
                dy[(iy - 1) + _dy_offset] = dy[(iy - 1) + _dy_offset] + da * dx[(ix - 1) + _dx_offset];
                ix += incx;
                iy += incy;
            }

            return;
        }

        // code for both increments equal to 1
        for (int j = 0; j < n; ++j) {
            dy[j + _dy_offset] += da * dx[j + _dx_offset];
        }
    }
}

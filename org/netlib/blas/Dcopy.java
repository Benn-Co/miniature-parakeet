package org.netlib.blas;

// DCOPY copies a vector, x, to a vector, y.
public final class Dcopy {

    public static void dcopy(int n, double[] dx, int _dx_offset, int incx, double[] dy, int _dy_offset, int incy) {

        if (n <= 0) {
            return;
        }

        // code for unequal increments or equal increments
        // not equal to 1
        if (incx != 1 || incy != 1) {
            int ix = 1;
            int iy = 1;
            if (incx < 0) {
                ix = (-n + 1) * incx + 1;
            }
            if (incy < 0) {
                iy = (-n + 1) * incy + 1;
            }
            for (int i = n; i > 0; i--) {
                dy[iy - 1 + _dy_offset] = dx[ix - 1 + _dx_offset];
                ix += incx;
                iy += incy;
            }

            return;
        }

        // code for both increments equal to 1
        System.arraycopy(dx, _dx_offset, dy, _dy_offset, n);
    }
}

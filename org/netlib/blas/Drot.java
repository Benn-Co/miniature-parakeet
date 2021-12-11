package org.netlib.blas;

// DROT applies a plane rotation.
public final class Drot {

    public static void drot(int n, double[] dx, int _dx_offset, int incx, double[] dy,
            int _dy_offset, int incy, double c, double s) {

        if (n <= 0) {
            return;
        }

        int k = 0;

        if (incx != 1 || incy != 1) {
            int ix = 1;
            int iy = 1;
            if (incx < 0) {
                ix = (-n + 1) * incx + 1;
            }
            if (incy < 0) {
                iy = (-n + 1) * incy + 1;
            }
            k = 1;
            for (int i = n; i > 0; i--) {
                double dtemp = c * dx[ix - 1 + _dx_offset] + s * dy[iy - 1 + _dy_offset];
                dy[iy - 1 + _dy_offset] = c * dy[iy - 1 + _dy_offset] - s * dx[ix - 1 + _dx_offset];
                dx[ix - 1 + _dx_offset] = dtemp;
                ix += incx;
                iy += incy;
                k++;
            }

            return;
        }
        k = 1;
        for (int i = n; i > 0; i--) {
            double dtemp = c * dx[k - 1 + _dx_offset] + s * dy[k - 1 + _dy_offset];
            dy[k - 1 + _dy_offset] = c * dy[k - 1 + _dy_offset] - s * dx[k - 1 + _dx_offset];
            dx[k - 1 + _dx_offset] = dtemp;
            k++;
        }
    }
}

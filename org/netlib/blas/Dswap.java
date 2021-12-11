package org.netlib.blas;

// DSWAP interchanges two vectors.
// Uses unrolled loops for increments equal to 1.
public final class Dswap {

    public static void dswap(int n, double[] dx, int _dx_offset, int incx, double[] dy, int _dy_offset, int incy) {

        if (n <= 0) {
            return;
        }

        // code for unequal increments or equal increments
        // not equal to 1
        if (incx != 1 || incy != 1) {
            int ix = 1;
            int iy = 1;
            if (incx < 0) {
                ix = (1 - n) * incx + 1;
            }
            if (incy < 0) {
                iy = (1 - n) * incy + 1;
            }
            for (int i = n; i > 0; i--) {
                double dtemp = dx[ix - 1 + _dx_offset];
                dx[ix - 1 + _dx_offset] = dy[iy - 1 + _dy_offset];
                dy[iy - 1 + _dy_offset] = dtemp;
                ix += incx;
                iy += incy;
            }

            return;
        }

        // code for both increments equal to 1
        int m = n % 3;
        int i;
        if (m != 0) {
            i = 1;
            for (int k = m; k > 0; k--) {
                double dtemp = dx[i - 1 + _dx_offset];
                dx[i - 1 + _dx_offset] = dy[i - 1 + _dy_offset];
                dy[i - 1 + _dy_offset] = dtemp;
                i++;
            }

            if (n < 3) {
                return;
            }
        }

        int mp1 = m + 1;
        i = mp1;

        for (int k = (n - mp1 + 3) / 3; k > 0; k--) {

            double dtemp           = dx[i - 1 + _dx_offset];
            dx[i - 1 + _dx_offset] = dy[i - 1 + _dy_offset];
            dy[i - 1 + _dy_offset] = dtemp;

            dtemp                  = dx[i +     _dx_offset];
            dx[i +     _dx_offset] = dy[i +     _dy_offset];
            dy[i +     _dy_offset] = dtemp;

            dtemp                  = dx[i + 1 + _dx_offset];
            dx[i + 1 + _dx_offset] = dy[i + 1 + _dy_offset];
            dy[i + 1 + _dy_offset] = dtemp;

            i += 3;
        }
    }
}

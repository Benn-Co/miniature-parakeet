package org.netlib.blas;

// DSCAL scales a vector by a constant.
public final class Dscal {

    public static void dscal(int n, double da, double[] dx, int _dx_offset, int incx) {

        if (n <= 0 || incx <= 0) {
            return;
        }

        // code for increment not equal to 1
        if (incx != 1) {
            int nincx = n * incx;
            int l = 1;
            for (int i = ((nincx - 1) + incx) / incx; i > 0; i--) {
                dx[l - 1 + _dx_offset] = da * dx[l - 1 + _dx_offset];
                l += incx;
            }

            return;
        }

        // code for increment equal to 1
        for (int j = 0; j < n; ++j) {
            dx[j + _dx_offset] *= da;
        }
    }
}

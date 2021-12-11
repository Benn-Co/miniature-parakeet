package org.netlib.blas;

// IDAMAX finds the index of the first element having maximum absolute value.
public final class Idamax {

    public static int idamax(int n, double[] dx, int _dx_offset, int incx) {

        if (n < 1 || incx <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int l = 0;
        int idamax = 1;
        double dmax = 0.0;

        // code for increment not equal to 1
        if (incx != 1) {
            int ix = 1;
            dmax = Math.abs(dx[_dx_offset]);
            ix += incx;
            l = 2;
            for (int k = n - 1; k > 0; k--) {
                if (Math.abs(dx[ix - 1 + _dx_offset]) > dmax) {
                    idamax = l;
                    dmax = Math.abs(dx[ix - 1 + _dx_offset]);
                }
                ix += incx;
                l++;
            }

            return idamax;
        }
        // code for increment equal to 1
        dmax = Math.abs(dx[_dx_offset]);
        l = 2;
        for (int k = n - 1; k > 0; k--) {
            if (Math.abs(dx[l - 1 + _dx_offset]) > dmax) {
                idamax = l;
                dmax = Math.abs(dx[l - 1 + _dx_offset]);
            }
            l++;
        }

        return idamax;
    }
}

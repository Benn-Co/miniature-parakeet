package org.netlib.blas;

// DASUM takes the sum of the absolute values.
public final class Dasum {

    public static double dasum(int n, double[] dx, int _dx_offset, int incx) {

        double dasum;
        label0: {

            if (n <= 0 || incx <= 0) {
                return 0.0;
            }

            dasum = 0.0;
            int k = 0;

            // code for increment not equal to 1
            if (incx != 1) {
                int nincx = n * incx;
                k = 1;
                for (int i = (nincx - 1 + incx) / incx; i > 0; i--) {
                    dasum += Math.abs(dx[k - 1 + _dx_offset]);
                    k += incx;
                }

                return dasum;
            }
            // code for increment equal to 1
            int m = n % 6;
            if (m != 0) {
                k = 1;
                for (int i = m; i > 0; i--) {
                    dasum += Math.abs(dx[k - 1 + _dx_offset]);
                    k++;
                }

                if (n < 6) {
                    break label0;
                }
            }
            int mp1 = m + 1;
            k = mp1;
            for (int i = (n - mp1 + 6) / 6; i > 0; i--) {
                dasum = dasum + Math.abs(dx[k - 1 + _dx_offset]) + Math.abs(dx[k + _dx_offset])
                        + Math.abs(dx[k + 1 + _dx_offset]) + Math.abs(dx[k + 2 + _dx_offset])
                        + Math.abs(dx[k + 3 + _dx_offset]) + Math.abs(dx[k + 4 + _dx_offset]);
                k += 6;
            }

        }
        return dasum;
    }
}

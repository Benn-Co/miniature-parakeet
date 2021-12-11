package org.netlib.blas;

// DNRM2 returns the euclidean norm of a vector via the function
// name, so that DNRM2 := sqrt( x'*x )
public final class Dnrm2 {

    public static double dnrm2(int n, double[] x, int _x_offset, int incx) {

        double norm = 0.0;

        if (n < 1 || incx < 1) {
            norm = 0.0;
        } else if (n == 1) {
            norm = Math.abs(x[_x_offset]);
        } else {
            double scale = 0.0;
            double ssq = 1.0;
            int ix = 1;
            for (int i = (((1 + (n - 1) * incx) - 1) + incx) / incx; i > 0; i--) {
                if (x[(ix - 1) + _x_offset] != 0.0) {
                    double absxi = Math.abs(x[(ix - 1) + _x_offset]);
                    if (scale < absxi) {
                        ssq = 1.0 + ssq * Math.pow(scale / absxi, 2);
                        scale = absxi;
                    } else {
                        ssq += Math.pow(absxi / scale, 2);
                    }
                }
                ix += incx;
            }

            norm = scale * Math.sqrt(ssq);
        }
        return norm;
    }
}

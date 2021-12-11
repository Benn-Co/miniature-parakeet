package org.netlib.lapack;

import org.netlib.util.doubleW;

// DLASSQ  returns the values  scl and smsq such that
//
//    ( scl**2 )*smsq = x( 1 )**2 +...+ x( n )**2 + ( scale**2 )*sumsq,
//
// where  x( i ) = X( 1 + ( i - 1 )*INCX ). The value of sumsq is
// assumed to be non-negative and scl returns the value
//
//    scl = max( scale, abs( x( i ) ) ).
//
// scale and sumsq must be supplied in SCALE and SUMSQ and
// scl and smsq are overwritten on SCALE and SUMSQ respectively.
//
// The routine makes only one pass through the vector x.
public final class Dlassq {

    public static void dlassq(int n, double[] x, int _x_offset, int incx, doubleW scale, doubleW sumsq) {

        if (n > 0) {
            int ix = 1;
            for (int p = ((n - 1) * incx + incx) / incx; p > 0; p--) {
                if (x[ix - 1 + _x_offset] != 0.0) {
                    double absxi = Math.abs(x[ix - 1 + _x_offset]);
                    if (scale.val < absxi) {
                        sumsq.val = 1.0 + sumsq.val * Math.pow(scale.val / absxi, 2.0);
                        scale.val = absxi;
                    } else {
                        sumsq.val = sumsq.val + Math.pow(absxi / scale.val, 2.0);
                    }
                }
                ix += incx;
            }
        }
    }
}

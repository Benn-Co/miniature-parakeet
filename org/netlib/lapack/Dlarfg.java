package org.netlib.lapack;

import org.netlib.blas.Dnrm2;
import org.netlib.blas.Dscal;
import org.netlib.util.Util;
import org.netlib.util.doubleW;

// DLARFG generates a real elementary reflector H of order n, such
// that
//
//       H * ( alpha ) = ( beta ),   H**T * H = I.
//           (   x   )   (   0  )
//
// where alpha and beta are scalars, and x is an (n-1)-element real
// vector. H is represented in the form
//
//       H = I - tau * ( 1 ) * ( 1 v**T ) ,
//                     ( v )
//
// where tau is a real scalar and v is a real (n-1)-element
// vector.
//
// If the elements of x are all zero, then tau = 0 and H is taken
// to be the unit matrix.
//
// Otherwise  1 <= tau <= 2.
public final class Dlarfg {

    public static void dlarfg(int n, doubleW alpha, double[] x, int _x_offset, int incx, doubleW tau) {

        if (n <= 1) {
            tau.val = 0.0;
            return;
        }
        double xnorm = Dnrm2.dnrm2(n - 1, x, _x_offset, incx);
        if (xnorm == 0.0) {
            // H = I
            tau.val = 0.0;
        } else {
            // general case
            double beta = -Util.dsign(Dlapy2.dlapy2(alpha.val, xnorm), alpha.val);
            final double safmin = 2.0041683600089728E-292;
            if (Math.abs(beta) < safmin) {
                final double rsafmn = 4.9896007738367995E291;
                int knt = 0;
                do {
                    knt++;
                    Dscal.dscal(n - 1, rsafmn, x, _x_offset, incx);
                    beta *= rsafmn;
                    alpha.val = alpha.val * rsafmn;
                } while (Math.abs(beta) < safmin);

                // New BETA is at most 1, at least SAFMIN

                xnorm = Dnrm2.dnrm2(n - 1, x, _x_offset, incx);
                beta = -Util.dsign(Dlapy2.dlapy2(alpha.val, xnorm), alpha.val);
                tau.val = (beta - alpha.val) / beta;
                Dscal.dscal(n - 1, 1.0 / (alpha.val - beta), x, _x_offset, incx);
                alpha.val = beta;
                // If ALPHA is subnormal, it may lose relative accuracy
                for (int j = knt; j > 0; j--) {
                    alpha.val = alpha.val * safmin;
                }
            } else {
                tau.val = (beta - alpha.val) / beta;
                Dscal.dscal(n - 1, 1.0 / (alpha.val - beta), x, _x_offset, incx);
                alpha.val = beta;
            }
        }
    }
}

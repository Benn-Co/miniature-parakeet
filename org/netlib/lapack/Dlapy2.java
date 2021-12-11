package org.netlib.lapack;

// DLAPY2 returns sqrt(x**2 + y**2), taking care
// not to cause unnecessary overflow.
public final class Dlapy2 {

    public static double dlapy2(double x, double y) {
        double xabs = Math.abs(x);
        double yabs = Math.abs(y);
        double w = Math.max(xabs, yabs);
        double z = Math.min(xabs, yabs);
        if (z == 0.0) {
            return w;
        }
        return w * Math.sqrt(1.0 + Math.pow(z / w, 2));
    }
}

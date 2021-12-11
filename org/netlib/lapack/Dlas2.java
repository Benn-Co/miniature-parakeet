package org.netlib.lapack;

import org.netlib.util.doubleW;

public final class Dlas2
{
    public static void dlas2(double d, double d1, double d2, doubleW doublew, doubleW doublew1)
    {
        double d15 = 0.0;
        double d16 = 0.0;
        double d17 = 0.0;
        double d18 = 0.0;
        double d19 = 0.0;
        d15 = Math.abs(d);
        d18 = Math.abs(d1);
        d19 = Math.abs(d2);
        d16 = Math.min(d15, d19);
        d17 = Math.max(d15, d19);
        if(d16 == 0.0)
        {
            doublew.val = 0.0;
            if(d17 == 0.0)
                doublew1.val = d18;
            else
                doublew1.val = Math.max(d17, d18) * Math.sqrt(1.0 + Math.pow(Math.min(d17, d18) / Math.max(d17, d18), 2.0));
        } else
        if(d18 < d17)
        {
            double d4 = 1.0 + d16 / d17;
            double d7 = (d17 - d16) / d17;
            double d10 = Math.pow(d18 / d17, 2);
            double d13 = 2.0 / (Math.sqrt(d4 * d4 + d10) + Math.sqrt(d7 * d7 + d10));
            doublew.val = d16 * d13;
            doublew1.val = d17 / d13;
        } else
        {
            double d11 = d17 / d18;
            if(d11 == 0.0)
            {
                doublew.val = (d16 * d17) / d18;
                doublew1.val = d18;
            } else
            {
                double d5 = 1.0 + d16 / d17;
                double d8 = (d17 - d16) / d17;
                double d14 = 1.0 / (Math.sqrt(1.0 + Math.pow(d5 * d11, 2.0)) + Math.sqrt(1.0 + Math.pow(d8 * d11, 2.0)));
                doublew.val = d16 * d14 * d11;
                doublew.val = doublew.val + doublew.val;
                doublew1.val = d18 / (d14 + d14);
            }
        }
    }
}

package org.netlib.lapack;

import org.netlib.util.doubleW;

public final class Dlae2
{
    public static void dlae2(double d, double d1, double d2, doubleW doublew, doubleW doublew1)
    {
        double d3 = 0.0D;
        double d4 = 0.0D;
        double d5 = 0.0D;
        double d6 = 0.0D;
        double d7 = 0.0D;
        double d8 = 0.0D;
        double d9 = 0.0D;
        double d10 = 0.0D;
        d9 = d + d2;
        d7 = d - d2;
        d6 = Math.abs(d7);
        d10 = d1 + d1;
        d3 = Math.abs(d10);
        if(Math.abs(d) > Math.abs(d2))
        {
            d5 = d;
            d4 = d2;
        } else
        {
            d5 = d2;
            d4 = d;
        }
        if(d6 > d3)
            d8 = d6 * Math.sqrt(1.0D + Math.pow(d3 / d6, 2));
        else
        if(d6 < d3)
            d8 = d3 * Math.sqrt(1.0D + Math.pow(d6 / d3, 2));
        else
            d8 = d3 * Math.sqrt(2D);
        if(d9 < 0.0D)
        {
            doublew.val = 0.5D * (d9 - d8);
            doublew1.val = (d5 / doublew.val) * d4 - (d1 / doublew.val) * d1;
        } else
        if(d9 > 0.0D)
        {
            doublew.val = 0.5D * (d9 + d8);
            doublew1.val = (d5 / doublew.val) * d4 - (d1 / doublew.val) * d1;
        } else
        {
            doublew.val = 0.5D * d8;
            doublew1.val = -(0.5D * d8);
        }
    }
}

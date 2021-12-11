package org.netlib.lapack;

import org.netlib.util.doubleW;

public final class Dlaev2
{
    public static void dlaev2(double d, double d1, double d2, doubleW doublew, doubleW doublew1, 
            doubleW doublew2, doubleW doublew3)
    {
        byte byte0 = 0;
        byte byte1 = 0;
        double d3 = 0.0D;
        double d4 = 0.0D;
        double d5 = 0.0D;
        double d6 = 0.0D;
        double d7 = 0.0D;
        double d8 = 0.0D;
        double d11 = 0.0D;
        double d12 = 0.0D;
        double d13 = 0.0D;
        double d14 = 0.0D;
        d13 = d + d2;
        d11 = d - d2;
        d7 = Math.abs(d11);
        d14 = d1 + d1;
        d3 = Math.abs(d14);
        if(Math.abs(d) > Math.abs(d2))
        {
            d5 = d;
            d4 = d2;
        } else
        {
            d5 = d2;
            d4 = d;
        }
        if(d7 > d3)
            d12 = d7 * Math.sqrt(1.0D + Math.pow(d3 / d7, 2));
        else
        if(d7 < d3)
            d12 = d3 * Math.sqrt(1.0D + Math.pow(d7 / d3, 2));
        else
            d12 = d3 * Math.sqrt(2D);
        if(d13 < 0.0D)
        {
            doublew.val = 0.5D * (d13 - d12);
            byte0 = -1;
            doublew1.val = (d5 / doublew.val) * d4 - (d1 / doublew.val) * d1;
        } else
        if(d13 > 0.0D)
        {
            doublew.val = 0.5D * (d13 + d12);
            byte0 = 1;
            doublew1.val = (d5 / doublew.val) * d4 - (d1 / doublew.val) * d1;
        } else
        {
            doublew.val = 0.5D * d12;
            doublew1.val = -(0.5D * d12);
            byte0 = 1;
        }
        if(d11 >= 0.0D)
        {
            d8 = d11 + d12;
            byte1 = 1;
        } else
        {
            d8 = d11 - d12;
            byte1 = -1;
        }
        d6 = Math.abs(d8);
        if(d6 > d3)
        {
            double d10 = -(d14 / d8);
            doublew3.val = 1.0D / Math.sqrt(1.0D + d10 * d10);
            doublew2.val = d10 * doublew3.val;
        } else
        if(d3 == 0.0D)
        {
            doublew2.val = 1.0D;
            doublew3.val = 0.0D;
        } else
        {
            double d16 = -(d8 / d14);
            doublew2.val = 1.0D / Math.sqrt(1.0D + d16 * d16);
            doublew3.val = d16 * doublew2.val;
        }
        if(byte0 == byte1)
        {
            double d17 = doublew2.val;
            doublew2.val = -doublew3.val;
            doublew3.val = d17;
        }
    }
}

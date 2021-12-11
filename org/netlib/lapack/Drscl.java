package org.netlib.lapack;

import org.netlib.blas.Dscal;
import org.netlib.util.doubleW;

public final class Drscl
{
    public static void drscl(int i, double d, double ad[], int j, int k)
    {
        boolean flag = false;
        doubleW doublew = new doubleW(0.0D);
        double d1 = 0.0D;
        double d4 = 0.0D;
        doubleW doublew1 = new doubleW(0.0D);
        if(i <= 0)
            return;
        doublew1.val = Dlamch.dlamch("S");
        doublew.val = 1.0D / doublew1.val;
        Dlabad.dlabad(doublew1, doublew);
        d1 = d;
        d4 = 1.0D;
        do
        {
            double d3 = d1 * doublew1.val;
            double d6 = d4 / doublew.val;
            double d8;
            if((Math.abs(d3) > Math.abs(d4)) && (d4 != 0.0D))
            {
                d8 = doublew1.val;
                flag = false;
                d1 = d3;
            } else
            if(Math.abs(d6) > Math.abs(d1))
            {
                d8 = doublew.val;
                flag = false;
                d4 = d6;
            } else
            {
                d8 = d4 / d1;
                flag = true;
            }
            Dscal.dscal(i, d8, ad, j, k);
        } while(flag ^ true);
    }
}

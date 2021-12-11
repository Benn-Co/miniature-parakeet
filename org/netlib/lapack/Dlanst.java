package org.netlib.lapack;

import org.netlib.blas.Lsame;
import org.netlib.util.doubleW;

public final class Dlanst
{
    public static double dlanst(String s, int i, double ad[], int j, double ad1[], int k)
    {
        double d = 0.0;
        doubleW doublew = new doubleW(0.0);
        doubleW doublew1 = new doubleW(0.0);
        double d1 = 0.0;
        if(i <= 0)
            d = 0.0;
        else
        if(Lsame.lsame(s, "M"))
        {
            d = Math.abs(ad[(i - 1) + j]);
            int l = 1;
            for(int j1 = i - 1; j1 > 0; j1--)
            {
                d = Math.max(d, Math.abs(ad[(l - 1) + j]));
                d = Math.max(d, Math.abs(ad1[(l - 1) + k]));
                l++;
            }

        } else
        if((Lsame.lsame(s, "O") || s.regionMatches(0, "1", 0, 1)) || Lsame.lsame(s, "I"))
        {
            if(i == 1)
            {
                d = Math.abs(ad[j]);
            } else
            {
                d = Math.max(Math.abs(ad[j]) + Math.abs(ad1[k]), Math.abs(ad1[(i - 2) + k]) + Math.abs(ad[(i - 1) + j]));
                int i1 = 2;
                for(int k1 = i - 2; k1 > 0; k1--)
                {
                    d = Math.max(d, Math.abs(ad[(i1 - 1) + j]) + Math.abs(ad1[(i1 - 1) + k]) + Math.abs(ad1[(i1 - 2) + k]));
                    i1++;
                }

            }
        } else
        if(Lsame.lsame(s, "F") || Lsame.lsame(s, "E"))
        {
            doublew.val = 0.0;
            doublew1.val = 1.0;
            if (i > 1)
            {
                Dlassq.dlassq(i - 1, ad1, k, 1, doublew, doublew1);
                doublew1.val = 2.0 * doublew1.val;
            }
            Dlassq.dlassq(i, ad, j, 1, doublew, doublew1);
            d = doublew.val * Math.sqrt(doublew1.val);
        }
        d1 = d;
        return d1;
    }
}

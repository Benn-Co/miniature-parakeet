package org.netlib.lapack;

import org.netlib.util.doubleW;

public final class Dlansp
{
    public static double dlansp(String s, String s1, int i, double ad[], int j, double ad1[], int k)
    {
        doubleW doublew = new doubleW(0.0D);
        doubleW doublew1 = new doubleW(0.0D);
        double d4 = 0.0D;
        double d5 = 0.0D;
        if(i == 0)
            d4 = 0.0D;
        else
        if(Lsame.lsame(s, "M"))
        {
            d4 = 0.0D;
            if(Lsame.lsame(s1, "U"))
            {
                int i4 = 1;
                int k2 = 1;
                for(int i5 = (i - 1) + 1; i5 > 0; i5--)
                {
                    int l = i4;
                    for(int j7 = ((i4 + k2) - 1 - i4) + 1; j7 > 0; j7--)
                    {
                        d4 = Math.max(d4, Math.abs(ad[(l - 1) + j]));
                        l++;
                    }

                    i4 += k2;
                    k2++;
                }

            } else
            {
                int j4 = 1;
                int l2 = 1;
                for(int j5 = (i - 1) + 1; j5 > 0; j5--)
                {
                    int i1 = j4;
                    for(int k7 = ((j4 + i) - l2 - j4) + 1; k7 > 0; k7--)
                    {
                        d4 = Math.max(d4, Math.abs(ad[(i1 - 1) + j]));
                        i1++;
                    }

                    j4 = ((j4 + i) - l2) + 1;
                    l2++;
                }

            }
        } else
        if((Lsame.lsame(s, "I") || Lsame.lsame(s, "O")) || s.regionMatches(0, "1", 0, 1))
        {
            d4 = 0.0D;
            int k4 = 1;
            if(Lsame.lsame(s1, "U"))
            {
                int i3 = 1;
                for(int k5 = (i - 1) + 1; k5 > 0; k5--)
                {
                    doublew1.val = 0.0D;
                    int j1 = 1;
                    for(int l7 = (i3 - 1 - 1) + 1; l7 > 0; l7--)
                    {
                        double d1 = Math.abs(ad[(k4 - 1) + j]);
                        doublew1.val = doublew1.val + d1;
                        ad1[(j1 - 1) + k] = ad1[(j1 - 1) + k] + d1;
                        k4++;
                        j1++;
                    }

                    ad1[(i3 - 1) + k] = doublew1.val + Math.abs(ad[(k4 - 1) + j]);
                    k4++;
                    i3++;
                }

                int k1 = 1;
                for(int l5 = (i - 1) + 1; l5 > 0; l5--)
                {
                    d4 = Math.max(d4, ad1[(k1 - 1) + k]);
                    k1++;
                }

            } else
            {
                int l1 = 1;
                for(int i6 = (i - 1) + 1; i6 > 0; i6--)
                {
                    ad1[(l1 - 1) + k] = 0.0D;
                    l1++;
                }

                int j3 = 1;
                for(int j6 = (i - 1) + 1; j6 > 0; j6--)
                {
                    doublew1.val = ad1[(j3 - 1) + k] + Math.abs(ad[(k4 - 1) + j]);
                    k4++;
                    int i2 = j3 + 1;
                    for(int i8 = (i - (j3 + 1)) + 1; i8 > 0; i8--)
                    {
                        double d2 = Math.abs(ad[(k4 - 1) + j]);
                        doublew1.val = doublew1.val + d2;
                        ad1[(i2 - 1) + k] = ad1[(i2 - 1) + k] + d2;
                        k4++;
                        i2++;
                    }

                    d4 = Math.max(d4, doublew1.val);
                    j3++;
                }

            }
        } else
        if(Lsame.lsame(s, "F") || Lsame.lsame(s, "E"))
        {
            doublew.val = 0.0D;
            doublew1.val = 1.0D;
            int l4 = 2;
            if(Lsame.lsame(s1, "U"))
            {
                int k3 = 2;
                for(int k6 = (i - 2) + 1; k6 > 0; k6--)
                {
                    Dlassq.dlassq(k3 - 1, ad, (l4 - 1) + j, 1, doublew, doublew1);
                    l4 += k3;
                    k3++;
                }

            } else
            {
                int l3 = 1;
                for(int l6 = (i - 1 - 1) + 1; l6 > 0; l6--)
                {
                    Dlassq.dlassq(i - l3, ad, (l4 - 1) + j, 1, doublew, doublew1);
                    l4 = ((l4 + i) - l3) + 1;
                    l3++;
                }

            }
            doublew1.val = (double)2 * doublew1.val;
            l4 = 1;
            int j2 = 1;
            for(int i7 = (i - 1) + 1; i7 > 0; i7--)
            {
                if(ad[(l4 - 1) + j] != 0.0D)
                {
                    double d3 = Math.abs(ad[(l4 - 1) + j]);
                    if(doublew.val < d3)
                    {
                        doublew1.val = 1.0D + doublew1.val * Math.pow(doublew.val / d3, 2);
                        doublew.val = d3;
                    } else
                    {
                        doublew1.val = doublew1.val + Math.pow(d3 / doublew.val, 2);
                    }
                }
                if(Lsame.lsame(s1, "U"))
                    l4 = l4 + j2 + 1;
                else
                    l4 = ((l4 + i) - j2) + 1;
                j2++;
            }

            d4 = doublew.val * Math.sqrt(doublew1.val);
        }
        d5 = d4;
        return d5;
    }
}

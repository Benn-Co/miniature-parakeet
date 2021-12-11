package org.netlib.lapack;

import org.netlib.util.doubleW;

public final class Dlansy
{
    public static double dlansy(String s, String s1, int i, double ad[], int j, int k, double ad1[], int l)
    {
        doubleW doublew = new doubleW(0.0D);
        doubleW doublew1 = new doubleW(0.0D);
        double d3 = 0.0D;
        double d4 = 0.0D;
        if(i == 0)
            d3 = 0.0D;
        else
        if(Lsame.lsame(s, "M"))
        {
            d3 = 0.0D;
            if(Lsame.lsame(s1, "U"))
            {
                int k2 = 1;
                for(int i4 = (i - 1) + 1; i4 > 0; i4--)
                {
                    int i1 = 1;
                    for(int i6 = (k2 - 1) + 1; i6 > 0; i6--)
                    {
                        d3 = Math.max(d3, Math.abs(ad[(i1 - 1) + (k2 - 1) * k + j]));
                        i1++;
                    }

                    k2++;
                }

            } else
            {
                int l2 = 1;
                for(int j4 = (i - 1) + 1; j4 > 0; j4--)
                {
                    int j1 = l2;
                    for(int j6 = (i - l2) + 1; j6 > 0; j6--)
                    {
                        d3 = Math.max(d3, Math.abs(ad[(j1 - 1) + (l2 - 1) * k + j]));
                        j1++;
                    }

                    l2++;
                }

            }
        } else
        if((Lsame.lsame(s, "I") || Lsame.lsame(s, "O")) || s.regionMatches(0, "1", 0, 1))
        {
            d3 = 0.0D;
            if(Lsame.lsame(s1, "U"))
            {
                int i3 = 1;
                for(int k4 = (i - 1) + 1; k4 > 0; k4--)
                {
                    doublew1.val = 0.0D;
                    int k1 = 1;
                    for(int k6 = (i3 - 1 - 1) + 1; k6 > 0; k6--)
                    {
                        double d1 = Math.abs(ad[(k1 - 1) + (i3 - 1) * k + j]);
                        doublew1.val = doublew1.val + d1;
                        ad1[(k1 - 1) + l] = ad1[(k1 - 1) + l] + d1;
                        k1++;
                    }

                    ad1[(i3 - 1) + l] = doublew1.val + Math.abs(ad[(i3 - 1) + (i3 - 1) * k + j]);
                    i3++;
                }

                int l1 = 1;
                for(int l4 = (i - 1) + 1; l4 > 0; l4--)
                {
                    d3 = Math.max(d3, ad1[(l1 - 1) + l]);
                    l1++;
                }

            } else
            {
                int i2 = 1;
                for(int i5 = (i - 1) + 1; i5 > 0; i5--)
                {
                    ad1[(i2 - 1) + l] = 0.0D;
                    i2++;
                }

                int j3 = 1;
                for(int j5 = (i - 1) + 1; j5 > 0; j5--)
                {
                    doublew1.val = ad1[(j3 - 1) + l] + Math.abs(ad[(j3 - 1) + (j3 - 1) * k + j]);
                    int j2 = j3 + 1;
                    for(int l6 = (i - (j3 + 1)) + 1; l6 > 0; l6--)
                    {
                        double d2 = Math.abs(ad[(j2 - 1) + (j3 - 1) * k + j]);
                        doublew1.val = doublew1.val + d2;
                        ad1[(j2 - 1) + l] = ad1[(j2 - 1) + l] + d2;
                        j2++;
                    }

                    d3 = Math.max(d3, doublew1.val);
                    j3++;
                }

            }
        } else
        if(Lsame.lsame(s, "F") || Lsame.lsame(s, "E"))
        {
            doublew.val = 0.0D;
            doublew1.val = 1.0D;
            if(Lsame.lsame(s1, "U"))
            {
                int k3 = 2;
                for(int k5 = (i - 2) + 1; k5 > 0; k5--)
                {
                    Dlassq.dlassq(k3 - 1, ad, (1 - 1) + (k3 - 1) * k + j, 1, doublew, doublew1);
                    k3++;
                }

            } else
            {
                int l3 = 1;
                for(int l5 = (i - 1 - 1) + 1; l5 > 0; l5--)
                {
                    Dlassq.dlassq(i - l3, ad, ((l3 + 1) - 1) + (l3 - 1) * k + j, 1, doublew, doublew1);
                    l3++;
                }

            }
            doublew1.val = (double)2 * doublew1.val;
            Dlassq.dlassq(i, ad, j, k + 1, doublew, doublew1);
            d3 = doublew.val * Math.sqrt(doublew1.val);
        }
        d4 = d3;
        return d4;
    }
}

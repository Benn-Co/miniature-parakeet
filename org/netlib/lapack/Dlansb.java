package org.netlib.lapack;

import org.netlib.util.doubleW;

public final class Dlansb
{
    public static double dlansb(String s, String s1, int i, int j, double ad[], int k, int l, double ad1[], 
            int i1)
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
                int l2 = 1;
                for(int i5 = i; i5 > 0; i5--)
                {
                    int j1 = Math.max((j + 2) - l2, 1);
                    for(int i7 = ((j + 1) - Math.max((j + 2) - l2, 1)) + 1; i7 > 0; i7--)
                    {
                        d3 = Math.max(d3, Math.abs(ad[(j1 - 1) + (l2 - 1) * l + k]));
                        j1++;
                    }

                    l2++;
                }

            } else
            {
                int i3 = 1;
                for(int j5 = i; j5 > 0; j5--)
                {
                    int k1 = 1;
                    for(int j7 = (Math.min((i + 1) - i3, j + 1) - 1) + 1; j7 > 0; j7--)
                    {
                        d3 = Math.max(d3, Math.abs(ad[(k1 - 1) + (i3 - 1) * l + k]));
                        k1++;
                    }

                    i3++;
                }

            }
        } else
        if((Lsame.lsame(s, "I") || Lsame.lsame(s, "O")) || s.regionMatches(0, "1", 0, 1))
        {
            d3 = 0.0D;
            if(Lsame.lsame(s1, "U"))
            {
                int j3 = 1;
                for(int k5 = (i - 1) + 1; k5 > 0; k5--)
                {
                    doublew1.val = 0.0D;
                    int j4 = (j + 1) - j3;
                    int l1 = Math.max(1, j3 - j);
                    for(int k7 = (j3 - 1 - Math.max(1, j3 - j)) + 1; k7 > 0; k7--)
                    {
                        double d1 = Math.abs(ad[((j4 + l1) - 1) + (j3 - 1) * l + k]);
                        doublew1.val = doublew1.val + d1;
                        ad1[(l1 - 1) + i1] = ad1[(l1 - 1) + i1] + d1;
                        l1++;
                    }

                    ad1[(j3 - 1) + i1] = doublew1.val + Math.abs(ad[((j + 1) - 1) + (j3 - 1) * l + k]);
                    j3++;
                }

                int i2 = 1;
                for(int l5 = i; l5 > 0; l5--)
                {
                    d3 = Math.max(d3, ad1[(i2 - 1) + i1]);
                    i2++;
                }

            } else
            {
                int j2 = 1;
                for(int i6 = i; i6 > 0; i6--)
                {
                    ad1[(j2 - 1) + i1] = 0.0D;
                    j2++;
                }

                int k3 = 1;
                for(int j6 = (i - 1) + 1; j6 > 0; j6--)
                {
                    doublew1.val = ad1[(k3 - 1) + i1] + Math.abs(ad[(1 - 1) + (k3 - 1) * l + k]);
                    int k4 = 1 - k3;
                    int k2 = k3 + 1;
                    for(int l7 = (Math.min(i, k3 + j) - (k3 + 1)) + 1; l7 > 0; l7--)
                    {
                        double d2 = Math.abs(ad[((k4 + k2) - 1) + (k3 - 1) * l + k]);
                        doublew1.val = doublew1.val + d2;
                        ad1[(k2 - 1) + i1] = ad1[(k2 - 1) + i1] + d2;
                        k2++;
                    }

                    d3 = Math.max(d3, doublew1.val);
                    k3++;
                }

            }
        } else
        if(Lsame.lsame(s, "F") || Lsame.lsame(s, "E"))
        {
            doublew.val = 0.0D;
            doublew1.val = 1.0D;
            int l4;
            if(j > 0)
            {
                if(Lsame.lsame(s1, "U"))
                {
                    int l3 = 2;
                    for(int k6 = i - 1; k6 > 0; k6--)
                    {
                        Dlassq.dlassq(Math.min(l3 - 1, j), ad, (Math.max((j + 2) - l3, 1) - 1) + (l3 - 1) * l + k, 1, doublew, doublew1);
                        l3++;
                    }

                    l4 = j + 1;
                } else
                {
                    int i4 = 1;
                    for(int l6 = i - 1; l6 > 0; l6--)
                    {
                        Dlassq.dlassq(Math.min(i - i4, j), ad, (2 - 1) + (i4 - 1) * l + k, 1, doublew, doublew1);
                        i4++;
                    }

                    l4 = 1;
                }
                doublew1.val = (double)2 * doublew1.val;
            } else
            {
                l4 = 1;
            }
            Dlassq.dlassq(i, ad, (l4 - 1) + (1 - 1) * l + k, l, doublew, doublew1);
            d3 = doublew.val * Math.sqrt(doublew1.val);
        }
        d4 = d3;
        return d4;
    }
}

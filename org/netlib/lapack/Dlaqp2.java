package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.util.doubleW;

public final class Dlaqp2
{
    public static void dlaqp2(int i, int j, int k, double ad[], int l, int i1, int ai[], int j1, 
            double ad1[], int k1, double ad2[], int l1, double ad3[], int i2, double ad4[], 
            int j2)
    {
        int k2 = 0;
        int j3 = 0;
        double d6 = 0.0D;
        j3 = Math.min(i - k, j);
        d6 = Math.sqrt(Dlamch.dlamch("Epsilon"));
        k2 = 1;
        for(int i4 = (j3 - 1) + 1; i4 > 0; i4--)
        {
            int k3 = k + k2;
            int l3 = (k2 - 1) + Idamax.idamax((j - k2) + 1, ad2, (k2 - 1) + l1, 1);
            if(l3 != k2)
            {
                Dswap.dswap(i, ad, (1 - 1) + (l3 - 1) * i1 + l, 1, ad, (1 - 1) + (k2 - 1) * i1 + l, 1);
                int l2 = ai[(l3 - 1) + j1];
                ai[(l3 - 1) + j1] = ai[(k2 - 1) + j1];
                ai[(k2 - 1) + j1] = l2;
                ad2[(l3 - 1) + l1] = ad2[(k2 - 1) + l1];
                ad3[(l3 - 1) + i2] = ad3[(k2 - 1) + i2];
            }
            if(k3 < i)
                dlarfg_adapter((i - k3) + 1, ad, (k3 - 1) + (k2 - 1) * i1 + l, ad, ((k3 + 1) - 1) + (k2 - 1) * i1 + l, 1, ad1, (k2 - 1) + k1);
            else
                dlarfg_adapter(1, ad, (i - 1) + (k2 - 1) * i1 + l, ad, (i - 1) + (k2 - 1) * i1 + l, 1, ad1, (k2 - 1) + k1);
            if(k2 < j)
            {
                double d1 = ad[(k3 - 1) + (k2 - 1) * i1 + l];
                ad[(k3 - 1) + (k2 - 1) * i1 + l] = 1.0D;
                Dlarf.dlarf("Left", (i - k3) + 1, j - k2, ad, (k3 - 1) + (k2 - 1) * i1 + l, 1, ad1[(k2 - 1) + k1], ad, (k3 - 1) + ((k2 + 1) - 1) * i1 + l, i1, ad4, (1 - 1) + j2);
                ad[(k3 - 1) + (k2 - 1) * i1 + l] = d1;
            }
            int i3 = k2 + 1;
            for(int j4 = (j - (k2 + 1)) + 1; j4 > 0; j4--)
            {
                if(ad2[(i3 - 1) + l1] != 0.0D)
                {
                    double d3 = 1.0D - Math.pow(Math.abs(ad[(k3 - 1) + (i3 - 1) * i1 + l]) / ad2[(i3 - 1) + l1], 2);
                    d3 = Math.max(d3, 0.0D);
                    double d5 = d3 * Math.pow(ad2[(i3 - 1) + l1] / ad3[(i3 - 1) + i2], 2);
                    if(d5 <= d6)
                    {
                        if(k3 < i)
                        {
                            ad2[(i3 - 1) + l1] = Dnrm2.dnrm2(i - k3, ad, ((k3 + 1) - 1) + (i3 - 1) * i1 + l, 1);
                            ad3[(i3 - 1) + i2] = ad2[(i3 - 1) + l1];
                        } else
                        {
                            ad2[(i3 - 1) + l1] = 0.0D;
                            ad3[(i3 - 1) + i2] = 0.0D;
                        }
                    } else
                    {
                        ad2[(i3 - 1) + l1] = ad2[(i3 - 1) + l1] * Math.sqrt(d3);
                    }
                }
                i3++;
            }

            k2++;
        }

    }

    private static void dlarfg_adapter(int i, double ad[], int j, double ad1[], int k, int l, double ad2[], int i1)
    {
        doubleW doublew = new doubleW(ad[j]);
        doubleW doublew1 = new doubleW(ad2[i1]);
        Dlarfg.dlarfg(i, doublew, ad1, k, l, doublew1);
        ad[j] = doublew.val;
        ad2[i1] = doublew1.val;
    }
}

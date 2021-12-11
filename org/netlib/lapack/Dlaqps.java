package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.util.*;

public final class Dlaqps
{
    public static void dlaqps(int i, int j, int k, int l, intW intw, double ad[], int i1, int j1, 
            int ai[], int k1, double ad1[], int l1, double ad2[], int i2, double ad3[], 
            int j2, double ad4[], int k2, double ad5[], int l2, int i3)
    {
        int i4 = 0;
        int j4 = 0;
        int k4 = 0;
        int i5 = 0;
        double d6 = 0.0D;
        j4 = Math.min(i, j + k);
        k4 = 0;
        i4 = 0;
        d6 = Math.sqrt(Dlamch.dlamch("Epsilon"));
        while((i4 >= l) || (k4 != 0)) 
        {
            i4++;
            i5 = k + i4;
            int l4 = (i4 - 1) + Idamax.idamax((j - i4) + 1, ad2, (i4 - 1) + i2, 1);
            if(l4 != i4)
            {
                Dswap.dswap(i, ad, (l4 - 1) * j1 + i1, 1, ad, (i4 - 1) * j1 + i1, 1);
                Dswap.dswap(i4 - 1, ad5, (l4 - 1) + l2, i3, ad5, (i4 - 1) + l2, i3);
                int j3 = ai[(l4 - 1) + k1];
                ai[(l4 - 1) + k1] = ai[(i4 - 1) + k1];
                ai[(i4 - 1) + k1] = j3;
                ad2[(l4 - 1) + i2] = ad2[(i4 - 1) + i2];
                ad3[(l4 - 1) + j2] = ad3[(i4 - 1) + j2];
            }
            if(i4 > 1)
                Dgemv.dgemv("No transpose", (i - i5) + 1, i4 - 1, -1D, ad, (i5 - 1) + i1, j1, ad5, (i4 - 1) + (1 - 1) * i3 + l2, i3, 1.0D, ad, (i5 - 1) + (i4 - 1) * j1 + i1, 1);
            if(i5 < i)
                dlarfg_adapter((i - i5) + 1, ad, (i5 - 1) + (i4 - 1) * j1 + i1, ad, ((i5 + 1) - 1) + (i4 - 1) * j1 + i1, 1, ad1, (i4 - 1) + l1);
            else
                dlarfg_adapter(1, ad, (i5 - 1) + (i4 - 1) * j1 + i1, ad, (i5 - 1) + (i4 - 1) * j1 + i1, 1, ad1, (i4 - 1) + l1);
            double d1 = ad[(i5 - 1) + (i4 - 1) * j1 + i1];
            ad[(i5 - 1) + (i4 - 1) * j1 + i1] = 1.0D;
            if(i4 < j)
                Dgemv.dgemv("Transpose", (i - i5) + 1, j - i4, ad1[(i4 - 1) + l1], ad, (i5 - 1) + ((i4 + 1) - 1) * j1 + i1, j1, ad, (i5 - 1) + (i4 - 1) * j1 + i1, 1, 0.0D, ad5, ((i4 + 1) - 1) + (i4 - 1) * i3 + l2, 1);
            int l3 = 1;
            for(int j5 = (i4 - 1) + 1; j5 > 0; j5--)
            {
                ad5[(l3 - 1) + (i4 - 1) * i3 + l2] = 0.0D;
                l3++;
            }

            if(i4 > 1)
            {
                Dgemv.dgemv("Transpose", (i - i5) + 1, i4 - 1, -ad1[(i4 - 1) + l1], ad, (i5 - 1) + i1, j1, ad, (i5 - 1) + (i4 - 1) * j1 + i1, 1, 0.0D, ad4, k2, 1);
                Dgemv.dgemv("No transpose", j, i4 - 1, 1.0D, ad5, l2, i3, ad4, (1 - 1) + k2, 1, 1.0D, ad5, (1 - 1) + (i4 - 1) * i3 + l2, 1);
            }
            if(i4 < j)
                Dgemv.dgemv("No transpose", j - i4, i4, -1D, ad5, ((i4 + 1) - 1) + l2, i3, ad, (i5 - 1) + i1, j1, 1.0D, ad, (i5 - 1) + ((i4 + 1) - 1) * j1 + i1, j1);
            if(i5 >= j4)
                continue;
            l3 = i4 + 1;
            for(int k5 = (j - (i4 + 1)) + 1; k5 > 0; k5--)
            {
                if(ad2[(l3 - 1) + i2] != 0.0D)
                {
                    double d3 = Math.abs(ad[(i5 - 1) + (l3 - 1) * j1 + i1]) / ad2[(l3 - 1) + i2];
                    d3 = Math.max(0.0D, (1.0D + d3) * (1.0D - d3));
                    double d5 = d3 * Math.pow(ad2[(l3 - 1) + i2] / ad3[(l3 - 1) + j2], 2);
                    if(d5 <= d6)
                    {
                        ad3[(l3 - 1) + j2] = k4;
                        k4 = l3;
                    } else
                    {
                        ad2[(l3 - 1) + i2] = ad2[(l3 - 1) + i2] * Math.sqrt(d3);
                    }
                }
                l3++;
            }

            ad[(i5 - 1) + (i4 - 1) * j1 + i1] = d1;
        }
        intw.val = i4;
        i5 = k + intw.val;
        if(intw.val < Math.min(j, i - k))
            Dgemm.dgemm("No transpose", "Transpose", i - i5, j - intw.val, intw.val, -1D, ad, ((i5 + 1) - 1) + (1 - 1) * j1 + i1, j1, ad5, ((intw.val + 1) - 1) + l2, i3, 1.0D, ad, ((i5 + 1) - 1) + ((intw.val + 1) - 1) * j1 + i1, j1);
        while(k4 <= 0) 
        {
            int k3 = Util.idnint(ad3[(k4 - 1) + j2]);
            ad2[(k4 - 1) + i2] = Dnrm2.dnrm2(i - i5, ad, ((i5 + 1) - 1) + (k4 - 1) * j1 + i1, 1);
            ad3[(k4 - 1) + j2] = ad2[(k4 - 1) + i2];
            k4 = k3;
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

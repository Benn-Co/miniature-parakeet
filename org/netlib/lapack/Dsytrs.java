package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dsytrs
{
    public static void dsytrs(String s, int i, int j, double ad[], int k, int l, int ai[], int i1, 
            double ad1[], int j1, int k1, intW intw)
    {
        boolean flag = false;
        intw.val = 0;
        flag = Lsame.lsame(s, "U");
        if(flag ^ true && Lsame.lsame(s, "L") ^ true)
            intw.val = -1;
        else
        if(i < 0)
            intw.val = -2;
        else
        if(j < 0)
            intw.val = -3;
        else
        if(l < Math.max(1, i))
            intw.val = -5;
        else
        if(k1 < Math.max(1, i))
            intw.val = -8;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DSYTRS", -intw.val);
            return;
        }
        if((i == 0) || (j == 0))
            return;
        if(flag)
        {
            int j2 = i;
            while(j2 >= 1) 
                if(ai[(j2 - 1) + i1] > 0)
                {
                    int l2 = ai[(j2 - 1) + i1];
                    if(l2 != j2)
                        Dswap.dswap(j, ad1, (j2 - 1) + j1, k1, ad1, (l2 - 1) + j1, k1);
                    Dger.dger(j2 - 1, j, -1D, ad, (j2 - 1) * l + k, 1, ad1, (j2 - 1) + j1, k1, ad1, j1, k1);
                    Dscal.dscal(j, 1.0D / ad[(j2 - 1) + (j2 - 1) * l + k], ad1, (j2 - 1) + j1, k1);
                    j2--;
                } else
                {
                    int i3 = -ai[(j2 - 1) + i1];
                    if(i3 != j2 - 1)
                        Dswap.dswap(j, ad1, (j2 - 2) + j1, k1, ad1, (i3 - 1) + j1, k1);
                    Dger.dger(j2 - 2, j, -1D, ad, (j2 - 1) * l + k, 1, ad1, (j2 - 1) + j1, k1, ad1, j1, k1);
                    Dger.dger(j2 - 2, j, -1D, ad, (j2 - 2) * l + k, 1, ad1, (j2 - 2) + j1, k1, ad1, j1, k1);
                    double d7 = ad[(j2 - 2) + (j2 - 1) * l + k];
                    double d4 = ad[(j2 - 2) + (j2 - 1 - 1) * l + k] / d7;
                    double d1 = ad[(j2 - 1) + (j2 - 1) * l + k] / d7;
                    double d16 = d4 * d1 - 1.0D;
                    int l1 = 1;
                    for(int l4 = (j - 1) + 1; l4 > 0; l4--)
                    {
                        double d13 = ad1[(j2 - 2) + (l1 - 1) * k1 + j1] / d7;
                        double d10 = ad1[(j2 - 1) + (l1 - 1) * k1 + j1] / d7;
                        ad1[(j2 - 2) + (l1 - 1) * k1 + j1] = (d1 * d13 - d10) / d16;
                        ad1[(j2 - 1) + (l1 - 1) * k1 + j1] = (d4 * d10 - d13) / d16;
                        l1++;
                    }

                    j2 -= 2;
                }
            j2 = 1;
            while(j2 <= i) 
                if(ai[(j2 - 1) + i1] > 0)
                {
                    Dgemv.dgemv("Transpose", j2 - 1, j, -1D, ad1, j1, k1, ad, (1 - 1) + (j2 - 1) * l + k, 1, 1.0D, ad1, (j2 - 1) + j1, k1);
                    int j3 = ai[(j2 - 1) + i1];
                    if(j3 != j2)
                        Dswap.dswap(j, ad1, (j2 - 1) + j1, k1, ad1, (j3 - 1) + j1, k1);
                    j2++;
                } else
                {
                    Dgemv.dgemv("Transpose", j2 - 1, j, -1D, ad1, j1, k1, ad, (j2 - 1) * l + k, 1, 1.0D, ad1, (j2 - 1) + j1, k1);
                    Dgemv.dgemv("Transpose", j2 - 1, j, -1D, ad1, j1, k1, ad, ((j2 + 1) - 1) * l + k, 1, 1.0D, ad1, ((j2 + 1) - 1) + j1, k1);
                    int k3 = -ai[(j2 - 1) + i1];
                    if(k3 != j2)
                        Dswap.dswap(j, ad1, (j2 - 1) + (1 - 1) * k1 + j1, k1, ad1, (k3 - 1) + (1 - 1) * k1 + j1, k1);
                    j2 += 2;
                }
        } else
        {
            int k2 = 1;
            while(k2 <= i) 
                if(ai[(k2 - 1) + i1] > 0)
                {
                    int l3 = ai[(k2 - 1) + i1];
                    if(l3 != k2)
                        Dswap.dswap(j, ad1, (k2 - 1) + j1, k1, ad1, (l3 - 1) + j1, k1);
                    if(k2 < i)
                        Dger.dger(i - k2, j, -1D, ad, ((k2 + 1) - 1) + (k2 - 1) * l + k, 1, ad1, (k2 - 1) + j1, k1, ad1, ((k2 + 1) - 1) + j1, k1);
                    Dscal.dscal(j, 1.0D / ad[(k2 - 1) + (k2 - 1) * l + k], ad1, (k2 - 1) + j1, k1);
                    k2++;
                } else
                {
                    int i4 = -ai[(k2 - 1) + i1];
                    if(i4 != k2 + 1)
                        Dswap.dswap(j, ad1, ((k2 + 1) - 1) + (1 - 1) * k1 + j1, k1, ad1, (i4 - 1) + j1, k1);
                    if(k2 < i - 1)
                    {
                        Dger.dger(i - k2 - 1, j, -1D, ad, ((k2 + 2) - 1) + (k2 - 1) * l + k, 1, ad1, (k2 - 1) + j1, k1, ad1, ((k2 + 2) - 1) + j1, k1);
                        Dger.dger(i - k2 - 1, j, -1D, ad, ((k2 + 2) - 1) + ((k2 + 1) - 1) * l + k, 1, ad1, ((k2 + 1) - 1) + j1, k1, ad1, ((k2 + 2) - 1) + j1, k1);
                    }
                    double d8 = ad[((k2 + 1) - 1) + (k2 - 1) * l + k];
                    double d5 = ad[(k2 - 1) + (k2 - 1) * l + k] / d8;
                    double d2 = ad[((k2 + 1) - 1) + ((k2 + 1) - 1) * l + k] / d8;
                    double d17 = d5 * d2 - 1.0D;
                    int i2 = 1;
                    for(int i5 = (j - 1) + 1; i5 > 0; i5--)
                    {
                        double d14 = ad1[(k2 - 1) + (i2 - 1) * k1 + j1] / d8;
                        double d11 = ad1[((k2 + 1) - 1) + (i2 - 1) * k1 + j1] / d8;
                        ad1[(k2 - 1) + (i2 - 1) * k1 + j1] = (d2 * d14 - d11) / d17;
                        ad1[((k2 + 1) - 1) + (i2 - 1) * k1 + j1] = (d5 * d11 - d14) / d17;
                        i2++;
                    }

                    k2 += 2;
                }
            k2 = i;
            while(k2 >= 1) 
                if(ai[(k2 - 1) + i1] > 0)
                {
                    if(k2 < i)
                        Dgemv.dgemv("Transpose", i - k2, j, -1D, ad1, ((k2 + 1) - 1) + j1, k1, ad, ((k2 + 1) - 1) + (k2 - 1) * l + k, 1, 1.0D, ad1, (k2 - 1) + j1, k1);
                    int j4 = ai[(k2 - 1) + i1];
                    if(j4 != k2)
                        Dswap.dswap(j, ad1, (k2 - 1) + (1 - 1) * k1 + j1, k1, ad1, (j4 - 1) + j1, k1);
                    k2--;
                } else
                {
                    if(k2 < i)
                    {
                        Dgemv.dgemv("Transpose", i - k2, j, -1D, ad1, ((k2 + 1) - 1) + j1, k1, ad, ((k2 + 1) - 1) + (k2 - 1) * l + k, 1, 1.0D, ad1, (k2 - 1) + j1, k1);
                        Dgemv.dgemv("Transpose", i - k2, j, -1D, ad1, ((k2 + 1) - 1) + j1, k1, ad, ((k2 + 1) - 1) + (k2 - 2) * l + k, 1, 1.0D, ad1, (k2 - 2) + j1, k1);
                    }
                    int k4 = -ai[(k2 - 1) + i1];
                    if(k4 != k2)
                        Dswap.dswap(j, ad1, (k2 - 1) + (1 - 1) * k1 + j1, k1, ad1, (k4 - 1) + (1 - 1) * k1 + j1, k1);
                    k2 -= 2;
                }
        }
    }
}

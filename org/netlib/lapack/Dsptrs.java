package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dsptrs
{
    public static void dsptrs(String s, int i, int j, double ad[], int k, int ai[], int l, double ad1[], 
            int i1, int j1, intW intw)
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
        if(j1 < Math.max(1, i))
            intw.val = -7;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DSPTRS", -intw.val);
            return;
        }
        if((i == 0) || (j == 0))
            return;
        if(flag)
        {
            int i2 = i;
            int k2 = (i * (i + 1)) / 2 + 1;
            while(i2 >= 1) 
            {
                k2 -= i2;
                if(ai[(i2 - 1) + l] > 0)
                {
                    int i3 = ai[(i2 - 1) + l];
                    if(i3 != i2)
                        Dswap.dswap(j, ad1, (i2 - 1) + i1, j1, ad1, (i3 - 1) + i1, j1);
                    Dger.dger(i2 - 1, j, -1D, ad, (k2 - 1) + k, 1, ad1, (i2 - 1) + i1, j1, ad1, i1, j1);
                    Dscal.dscal(j, 1.0D / ad[((k2 + i2) - 2) + k], ad1, (i2 - 1) + i1, j1);
                    i2--;
                } else
                {
                    int j3 = -ai[(i2 - 1) + l];
                    if(j3 != i2 - 1)
                        Dswap.dswap(j, ad1, (i2 - 2) + i1, j1, ad1, (j3 - 1) + i1, j1);
                    Dger.dger(i2 - 2, j, -1D, ad, (k2 - 1) + k, 1, ad1, (i2 - 1) + i1, j1, ad1, i1, j1);
                    Dger.dger(i2 - 2, j, -1D, ad, (k2 - (i2 - 1) - 1) + k, 1, ad1, (i2 - 2) + i1, j1, ad1, i1, j1);
                    double d7 = ad[((k2 + i2) - 2 - 1) + k];
                    double d4 = ad[(k2 - 2) + k] / d7;
                    double d1 = ad[((k2 + i2) - 2) + k] / d7;
                    double d16 = d4 * d1 - 1.0D;
                    int k1 = 1;
                    for(int i5 = (j - 1) + 1; i5 > 0; i5--)
                    {
                        double d13 = ad1[(i2 - 2) + (k1 - 1) * j1 + i1] / d7;
                        double d10 = ad1[(i2 - 1) + (k1 - 1) * j1 + i1] / d7;
                        ad1[(i2 - 2) + (k1 - 1) * j1 + i1] = (d1 * d13 - d10) / d16;
                        ad1[(i2 - 1) + (k1 - 1) * j1 + i1] = (d4 * d10 - d13) / d16;
                        k1++;
                    }

                    k2 = (k2 - i2) + 1;
                    i2 -= 2;
                }
            }
            i2 = 1;
            k2 = 1;
            while(i2 <= i) 
                if(ai[(i2 - 1) + l] > 0)
                {
                    Dgemv.dgemv("Transpose", i2 - 1, j, -1D, ad1, i1, j1, ad, (k2 - 1) + k, 1, 1.0D, ad1, (i2 - 1) + i1, j1);
                    int k3 = ai[(i2 - 1) + l];
                    if(k3 != i2)
                        Dswap.dswap(j, ad1, (i2 - 1) + i1, j1, ad1, (k3 - 1) + (1 - 1) * j1 + i1, j1);
                    k2 += i2;
                    i2++;
                } else
                {
                    Dgemv.dgemv("Transpose", i2 - 1, j, -1D, ad1, i1, j1, ad, (k2 - 1) + k, 1, 1.0D, ad1, (i2 - 1) + i1, j1);
                    Dgemv.dgemv("Transpose", i2 - 1, j, -1D, ad1, i1, j1, ad, ((k2 + i2) - 1) + k, 1, 1.0D, ad1, ((i2 + 1) - 1) + i1, j1);
                    int l3 = -ai[(i2 - 1) + l];
                    if(l3 != i2)
                        Dswap.dswap(j, ad1, (i2 - 1) + (1 - 1) * j1 + i1, j1, ad1, (l3 - 1) + (1 - 1) * j1 + i1, j1);
                    k2 = k2 + 2 * i2 + 1;
                    i2 += 2;
                }
        } else
        {
            int j2 = 1;
            int l2 = 1;
            while(j2 <= i) 
                if(ai[(j2 - 1) + l] > 0)
                {
                    int i4 = ai[(j2 - 1) + l];
                    if(i4 != j2)
                        Dswap.dswap(j, ad1, (j2 - 1) + i1, j1, ad1, (i4 - 1) + i1, j1);
                    if(j2 < i)
                        Dger.dger(i - j2, j, -1D, ad, ((l2 + 1) - 1) + k, 1, ad1, (j2 - 1) + i1, j1, ad1, ((j2 + 1) - 1) + i1, j1);
                    Dscal.dscal(j, 1.0D / ad[(l2 - 1) + k], ad1, (j2 - 1) + i1, j1);
                    l2 = ((l2 + i) - j2) + 1;
                    j2++;
                } else
                {
                    int j4 = -ai[(j2 - 1) + l];
                    if(j4 != j2 + 1)
                        Dswap.dswap(j, ad1, ((j2 + 1) - 1) + i1, j1, ad1, (j4 - 1) + i1, j1);
                    if(j2 < i - 1)
                    {
                        Dger.dger(i - j2 - 1, j, -1D, ad, ((l2 + 2) - 1) + k, 1, ad1, (j2 - 1) + i1, j1, ad1, ((j2 + 2) - 1) + (1 - 1) * j1 + i1, j1);
                        Dger.dger(i - j2 - 1, j, -1D, ad, ((((l2 + i) - j2) + 2) - 1) + k, 1, ad1, ((j2 + 1) - 1) + i1, j1, ad1, ((j2 + 2) - 1) + i1, j1);
                    }
                    double d8 = ad[((l2 + 1) - 1) + k];
                    double d5 = ad[(l2 - 1) + k] / d8;
                    double d2 = ad[((((l2 + i) - j2) + 1) - 1) + k] / d8;
                    double d17 = d5 * d2 - 1.0D;
                    int l1 = 1;
                    for(int j5 = (j - 1) + 1; j5 > 0; j5--)
                    {
                        double d14 = ad1[(j2 - 1) + (l1 - 1) * j1 + i1] / d8;
                        double d11 = ad1[((j2 + 1) - 1) + (l1 - 1) * j1 + i1] / d8;
                        ad1[(j2 - 1) + (l1 - 1) * j1 + i1] = (d2 * d14 - d11) / d17;
                        ad1[((j2 + 1) - 1) + (l1 - 1) * j1 + i1] = (d5 * d11 - d14) / d17;
                        l1++;
                    }

                    l2 = l2 + 2 * (i - j2) + 1;
                    j2 += 2;
                }
            j2 = i;
            l2 = (i * (i + 1)) / 2 + 1;
            while(j2 >= 1) 
            {
                l2 -= (i - j2) + 1;
                if(ai[(j2 - 1) + l] > 0)
                {
                    if(j2 < i)
                        Dgemv.dgemv("Transpose", i - j2, j, -1D, ad1, ((j2 + 1) - 1) + i1, j1, ad, ((l2 + 1) - 1) + k, 1, 1.0D, ad1, (j2 - 1) + i1, j1);
                    int k4 = ai[(j2 - 1) + l];
                    if(k4 != j2)
                        Dswap.dswap(j, ad1, (j2 - 1) + i1, j1, ad1, (k4 - 1) + i1, j1);
                    j2--;
                } else
                {
                    if(j2 < i)
                    {
                        Dgemv.dgemv("Transpose", i - j2, j, -1D, ad1, ((j2 + 1) - 1) + i1, j1, ad, ((l2 + 1) - 1) + k, 1, 1.0D, ad1, (j2 - 1) + i1, j1);
                        Dgemv.dgemv("Transpose", i - j2, j, -1D, ad1, ((j2 + 1) - 1) + i1, j1, ad, (l2 - (i - j2) - 1) + k, 1, 1.0D, ad1, (j2 - 2) + i1, j1);
                    }
                    int l4 = -ai[(j2 - 1) + l];
                    if(l4 != j2)
                        Dswap.dswap(j, ad1, (j2 - 1) + (1 - 1) * j1 + i1, j1, ad1, (l4 - 1) + (1 - 1) * j1 + i1, j1);
                    l2 -= (i - j2) + 2;
                    j2 -= 2;
                }
            }
        }
    }
}

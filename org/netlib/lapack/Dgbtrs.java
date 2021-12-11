package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgbtrs
{
    public static void dgbtrs(String s, int i, int j, int k, int l, double ad[], int i1, int j1, 
            int ai[], int k1, double ad1[], int l1, int i2, intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        int j3 = 0;
        intw.val = 0;
        flag1 = Lsame.lsame(s, "N");
        if((flag1 ^ true && Lsame.lsame(s, "T") ^ true) && Lsame.lsame(s, "C") ^ true)
            intw.val = -1;
        else
        if(i < 0)
            intw.val = -2;
        else
        if(j < 0)
            intw.val = -3;
        else
        if(k < 0)
            intw.val = -4;
        else
        if(l < 0)
            intw.val = -5;
        else
        if(j1 < 2 * j + k + 1)
            intw.val = -7;
        else
        if(i2 < Math.max(1, i))
            intw.val = -10;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DGBTRS", -intw.val);
            return;
        }
        if((i == 0) || (l == 0))
            return;
        j3 = k + j + 1;
        flag = j > 0;
        if(flag1)
        {
            if(flag)
            {
                int l2 = 1;
                for(int k4 = i - 1; k4 > 0; k4--)
                {
                    int i4 = Math.min(j, i - l2);
                    int k3 = ai[(l2 - 1) + k1];
                    if(k3 != l2)
                        Dswap.dswap(l, ad1, (k3 - 1) + l1, i2, ad1, (l2 - 1) + l1, i2);
                    Dger.dger(i4, l, -1D, ad, ((j3 + 1) - 1) + (l2 - 1) * j1 + i1, 1, ad1, (l2 - 1) + l1, i2, ad1, ((l2 + 1) - 1) + l1, i2);
                    l2++;
                }

            }
            int j2 = 1;
            for(int l4 = l; l4 > 0; l4--)
            {
                Dtbsv.dtbsv("Upper", "No transpose", "Non-unit", i, j + k, ad, i1, j1, ad1, (j2 - 1) * i2 + l1, 1);
                j2++;
            }

        } else
        {
            int k2 = 1;
            for(int i5 = l; i5 > 0; i5--)
            {
                Dtbsv.dtbsv("Upper", "Transpose", "Non-unit", i, j + k, ad, i1, j1, ad1, (k2 - 1) * i2 + l1, 1);
                k2++;
            }

            if(flag)
            {
                int i3 = i - 1;
                for(int j5 = ((1 - (i - 1)) + -1) / -1; j5 > 0; j5--)
                {
                    int j4 = Math.min(j, i - i3);
                    Dgemv.dgemv("Transpose", j4, l, -1D, ad1, ((i3 + 1) - 1) + l1, i2, ad, ((j3 + 1) - 1) + (i3 - 1) * j1 + i1, 1, 1.0D, ad1, (i3 - 1) + l1, i2);
                    int l3 = ai[(i3 - 1) + k1];
                    if(l3 != i3)
                        Dswap.dswap(l, ad1, (l3 - 1) + (1 - 1) * i2 + l1, i2, ad1, (i3 - 1) + l1, i2);
                    i3--;
                }

            }
        }
    }
}

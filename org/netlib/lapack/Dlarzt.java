package org.netlib.lapack;

import org.netlib.blas.Dgemv;
import org.netlib.blas.Dtrmv;
import org.netlib.err.Xerbla;

public final class Dlarzt
{
    public static void dlarzt(String s, String s1, int i, int j, double ad[], int k, int l, double ad1[], 
            int i1, double ad2[], int j1, int k1)
    {
        int l1 = 0;
        byte byte0 = 0;
        byte0 = 0;
        if(Lsame.lsame(s, "B") ^ true)
            byte0 = -1;
        else
        if(Lsame.lsame(s1, "R") ^ true)
            byte0 = -2;
        if(byte0 != 0)
        {
            Xerbla.xerbla("DLARZT", -byte0);
            return;
        }
        l1 = j;
        for(int j2 = ((1 - j) + -1) / -1; j2 > 0; j2--)
        {
            if(ad1[(l1 - 1) + i1] == 0.0D)
            {
                int i2 = l1;
                for(int k2 = (j - l1) + 1; k2 > 0; k2--)
                {
                    ad2[(i2 - 1) + (l1 - 1) * k1 + j1] = 0.0D;
                    i2++;
                }

            } else
            {
                if(l1 < j)
                {
                    Dgemv.dgemv("No transpose", j - l1, i, -ad1[(l1 - 1) + i1], ad, ((l1 + 1) - 1) + (1 - 1) * l + k, l, ad, (l1 - 1) + (1 - 1) * l + k, l, 0.0D, ad2, ((l1 + 1) - 1) + (l1 - 1) * k1 + j1, 1);
                    Dtrmv.dtrmv("Lower", "No transpose", "Non-unit", j - l1, ad2, ((l1 + 1) - 1) + ((l1 + 1) - 1) * k1 + j1, k1, ad2, ((l1 + 1) - 1) + (l1 - 1) * k1 + j1, 1);
                }
                ad2[(l1 - 1) + (l1 - 1) * k1 + j1] = ad1[(l1 - 1) + i1];
            }
            l1--;
        }

    }
}

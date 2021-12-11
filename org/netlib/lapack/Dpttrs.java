package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dpttrs
{
    public static void dpttrs(int i, int j, double ad[], int k, double ad1[], int l, double ad2[], int i1, 
            int j1, intW intw)
    {
        int i2 = 0;
        intw.val = 0;
        if(i < 0)
            intw.val = -1;
        else
        if(j < 0)
            intw.val = -2;
        else
        if(j1 < Math.max(1, i))
            intw.val = -6;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DPTTRS", -intw.val);
            return;
        }
        if((i == 0) || (j == 0))
            return;
        if(j == 1)
            i2 = 1;
        else
            i2 = Math.max(1, Ilaenv.ilaenv(1, "DPTTRS", " ", i, j, -1, -1));
        if(i2 >= j)
        {
            Dptts2.dptts2(i, j, ad, k, ad1, l, ad2, i1, j1);
        } else
        {
            int k1 = 1;
            for(int j2 = ((j - 1) + i2) / i2; j2 > 0; j2--)
            {
                int l1 = Math.min((j - k1) + 1, i2);
                Dptts2.dptts2(i, l1, ad, k, ad1, l, ad2, (k1 - 1) * j1 + i1, j1);
                k1 += i2;
            }

        }
    }
}

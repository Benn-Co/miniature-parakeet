package org.netlib.lapack;

import org.netlib.blas.Dtpsv;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dpptrs
{
    public static void dpptrs(String s, int i, int j, double ad[], int k, double ad1[], int l, int i1, 
            intW intw)
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
        if(i1 < Math.max(1, i))
            intw.val = -6;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DPPTRS", -intw.val);
            return;
        }
        if((i == 0) || (j == 0))
            return;
        if(flag)
        {
            int j1 = 1;
            for(int l1 = (j - 1) + 1; l1 > 0; l1--)
            {
                Dtpsv.dtpsv("Upper", "Transpose", "Non-unit", i, ad, k, ad1, (j1 - 1) * i1 + l, 1);
                Dtpsv.dtpsv("Upper", "No transpose", "Non-unit", i, ad, k, ad1, (j1 - 1) * i1 + l, 1);
                j1++;
            }

        } else
        {
            int k1 = 1;
            for(int i2 = (j - 1) + 1; i2 > 0; i2--)
            {
                Dtpsv.dtpsv("Lower", "No transpose", "Non-unit", i, ad, k, ad1, (k1 - 1) * i1 + l, 1);
                Dtpsv.dtpsv("Lower", "Transpose", "Non-unit", i, ad, k, ad1, (k1 - 1) * i1 + l, 1);
                k1++;
            }

        }
    }
}

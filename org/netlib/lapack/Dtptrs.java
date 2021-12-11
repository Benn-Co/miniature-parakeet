package org.netlib.lapack;

import org.netlib.blas.Dtpsv;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dtptrs
{
    public static void dtptrs(String s, String s1, String s2, int i, int j, double ad[], int k, double ad1[], 
            int l, int i1, intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        int j1 = 0;
        intw.val = 0;
        flag1 = Lsame.lsame(s, "U");
        flag = Lsame.lsame(s2, "N");
        if(flag1 ^ true && Lsame.lsame(s, "L") ^ true)
            intw.val = -1;
        else
        if((Lsame.lsame(s1, "N") ^ true && Lsame.lsame(s1, "T") ^ true) && Lsame.lsame(s1, "C") ^ true)
            intw.val = -2;
        else
        if(flag ^ true && Lsame.lsame(s2, "U") ^ true)
            intw.val = -3;
        else
        if(i < 0)
            intw.val = -4;
        else
        if(j < 0)
            intw.val = -5;
        else
        if(i1 < Math.max(1, i))
            intw.val = -8;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DTPTRS", -intw.val);
            return;
        }
        if(i == 0)
            return;
        if(flag)
            if(flag1)
            {
                int k1 = 1;
                intw.val = 1;
                for(int i2 = (i - 1) + 1; i2 > 0; i2--)
                {
                    if(ad[((k1 + intw.val) - 1 - 1) + k] == 0.0D)
                        return;
                    k1 += intw.val;
                    intw.val = intw.val + 1;
                }

            } else
            {
                int l1 = 1;
                intw.val = 1;
                for(int j2 = (i - 1) + 1; j2 > 0; j2--)
                {
                    if(ad[(l1 - 1) + k] == 0.0D)
                        return;
                    l1 = ((l1 + i) - intw.val) + 1;
                    intw.val = intw.val + 1;
                }

            }
        intw.val = 0;
        j1 = 1;
        for(int k2 = (j - 1) + 1; k2 > 0; k2--)
        {
            Dtpsv.dtpsv(s, s1, s2, i, ad, k, ad1, (1 - 1) + (j1 - 1) * i1 + l, 1);
            j1++;
        }

    }
}

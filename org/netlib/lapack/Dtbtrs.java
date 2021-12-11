package org.netlib.lapack;

import org.netlib.blas.Dtbsv;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dtbtrs
{
    public static void dtbtrs(String s, String s1, String s2, int i, int j, int k, double ad[], int l, 
            int i1, double ad1[], int j1, int k1, intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        int l1 = 0;
        intw.val = 0;
        flag = Lsame.lsame(s2, "N");
        flag1 = Lsame.lsame(s, "U");
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
        if(k < 0)
            intw.val = -6;
        else
        if(i1 < j + 1)
            intw.val = -8;
        else
        if(k1 < Math.max(1, i))
            intw.val = -10;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DTBTRS", -intw.val);
            return;
        }
        if(i == 0)
            return;
        if(flag)
            if(flag1)
            {
                intw.val = 1;
                for(int i2 = (i - 1) + 1; i2 > 0; i2--)
                {
                    if(ad[((j + 1) - 1) + (intw.val - 1) * i1 + l] == 0.0D)
                        return;
                    intw.val = intw.val + 1;
                }

            } else
            {
                intw.val = 1;
                for(int j2 = (i - 1) + 1; j2 > 0; j2--)
                {
                    if(ad[(1 - 1) + (intw.val - 1) * i1 + l] == 0.0D)
                        return;
                    intw.val = intw.val + 1;
                }

            }
        intw.val = 0;
        l1 = 1;
        for(int k2 = (k - 1) + 1; k2 > 0; k2--)
        {
            Dtbsv.dtbsv(s, s1, s2, i, j, ad, l, i1, ad1, (1 - 1) + (l1 - 1) * k1 + j1, 1);
            l1++;
        }

    }
}

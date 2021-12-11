package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dsysv
{
    public static void dsysv(String s, int i, int j, double ad[], int k, int l, int ai[], int i1, 
            double ad1[], int j1, int k1, double ad2[], int l1, int i2, intW intw)
    {
        boolean flag = false;
        int j2 = 0;
        intw.val = 0;
        flag = i2 == -1;
        if(Lsame.lsame(s, "U") ^ true && Lsame.lsame(s, "L") ^ true)
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
        else
        if((i2 < 1) && flag ^ true)
            intw.val = -10;
        if(intw.val == 0)
        {
            if(i == 0)
            {
                j2 = 1;
            } else
            {
                int k2 = Ilaenv.ilaenv(1, "DSYTRF", s, i, -1, -1, -1);
                j2 = i * k2;
            }
            ad2[(1 - 1) + l1] = j2;
        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DSYSV ", -intw.val);
            return;
        }
        if(flag)
            return;
        Dsytrf.dsytrf(s, i, ad, k, l, ai, i1, ad2, l1, i2, intw);
        if(intw.val == 0)
            Dsytrs.dsytrs(s, i, j, ad, k, l, ai, i1, ad1, j1, k1, intw);
        ad2[(1 - 1) + l1] = j2;
    }
}

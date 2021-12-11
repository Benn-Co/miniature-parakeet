package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dpbsv
{
    public static void dpbsv(String s, int i, int j, int k, double ad[], int l, int i1, double ad1[], 
            int j1, int k1, intW intw)
    {
        intw.val = 0;
        if(Lsame.lsame(s, "U") ^ true && Lsame.lsame(s, "L") ^ true)
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
        if(i1 < j + 1)
            intw.val = -6;
        else
        if(k1 < Math.max(1, i))
            intw.val = -8;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DPBSV ", -intw.val);
            return;
        }
        Dpbtrf.dpbtrf(s, i, j, ad, l, i1, intw);
        if(intw.val == 0)
            Dpbtrs.dpbtrs(s, i, j, k, ad, l, i1, ad1, j1, k1, intw);
    }
}

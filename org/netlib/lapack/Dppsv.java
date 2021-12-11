package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dppsv
{
    public static void dppsv(String s, int i, int j, double ad[], int k, double ad1[], int l, int i1, 
            intW intw)
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
        if(i1 < Math.max(1, i))
            intw.val = -6;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DPPSV ", -intw.val);
            return;
        }
        Dpptrf.dpptrf(s, i, ad, k, intw);
        if(intw.val == 0)
            Dpptrs.dpptrs(s, i, j, ad, k, ad1, l, i1, intw);
    }
}

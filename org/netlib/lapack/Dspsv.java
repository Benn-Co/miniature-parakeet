package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dspsv
{
    public static void dspsv(String s, int i, int j, double ad[], int k, int ai[], int l, double ad1[], 
            int i1, int j1, intW intw)
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
        if(j1 < Math.max(1, i))
            intw.val = -7;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DSPSV ", -intw.val);
            return;
        }
        Dsptrf.dsptrf(s, i, ad, k, ai, l, intw);
        if(intw.val == 0)
            Dsptrs.dsptrs(s, i, j, ad, k, ai, l, ad1, i1, j1, intw);
    }
}

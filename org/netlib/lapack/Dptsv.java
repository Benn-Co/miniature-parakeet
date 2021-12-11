package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dptsv
{
    public static void dptsv(int i, int j, double ad[], int k, double ad1[], int l, double ad2[], int i1, 
            int j1, intW intw)
    {
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
            Xerbla.xerbla("DPTSV ", -intw.val);
            return;
        }
        Dpttrf.dpttrf(i, ad, k, ad1, l, intw);
        if(intw.val == 0)
            Dpttrs.dpttrs(i, j, ad, k, ad1, l, ad2, i1, j1, intw);
    }
}

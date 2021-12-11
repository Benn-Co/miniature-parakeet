package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgbsv
{
    public static void dgbsv(int i, int j, int k, int l, double ad[], int i1, int j1, int ai[], 
            int k1, double ad1[], int l1, int i2, intW intw)
    {
        intw.val = 0;
        if(i < 0)
            intw.val = -1;
        else
        if(j < 0)
            intw.val = -2;
        else
        if(k < 0)
            intw.val = -3;
        else
        if(l < 0)
            intw.val = -4;
        else
        if(j1 < 2 * j + k + 1)
            intw.val = -6;
        else
        if(i2 < Math.max(i, 1))
            intw.val = -9;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DGBSV ", -intw.val);
            return;
        }
        Dgbtrf.dgbtrf(i, i, j, k, ad, i1, j1, ai, k1, intw);
        if(intw.val == 0)
            Dgbtrs.dgbtrs("No transpose", i, j, k, l, ad, i1, j1, ai, k1, ad1, l1, i2, intw);
    }
}

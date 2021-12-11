package org.netlib.lapack;

import org.netlib.blas.Dtrsm;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dpotrs
{
    public static void dpotrs(String s, int i, int j, double ad[], int k, int l, double ad1[], int i1, 
            int j1, intW intw)
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
        if(l < Math.max(1, i))
            intw.val = -5;
        else
        if(j1 < Math.max(1, i))
            intw.val = -7;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DPOTRS", -intw.val);
            return;
        }
        if((i == 0) || (j == 0))
            return;
        if(flag)
        {
            Dtrsm.dtrsm("Left", "Upper", "Transpose", "Non-unit", i, j, 1.0D, ad, k, l, ad1, i1, j1);
            Dtrsm.dtrsm("Left", "Upper", "No transpose", "Non-unit", i, j, 1.0D, ad, k, l, ad1, i1, j1);
        } else
        {
            Dtrsm.dtrsm("Left", "Lower", "No transpose", "Non-unit", i, j, 1.0D, ad, k, l, ad1, i1, j1);
            Dtrsm.dtrsm("Left", "Lower", "Transpose", "Non-unit", i, j, 1.0D, ad, k, l, ad1, i1, j1);
        }
    }
}

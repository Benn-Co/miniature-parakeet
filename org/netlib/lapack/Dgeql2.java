package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dgeql2
{
    public static void dgeql2(int i, int j, double ad[], int k, int l, double ad1[], int i1, double ad2[], 
            int j1, intW intw)
    {
        int k1 = 0;
        int l1 = 0;
        intw.val = 0;
        if(i < 0)
            intw.val = -1;
        else
        if(j < 0)
            intw.val = -2;
        else
        if(l < Math.max(1, i))
            intw.val = -4;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DGEQL2", -intw.val);
            return;
        }
        l1 = Math.min(i, j);
        k1 = l1;
        for(int i2 = ((1 - l1) + -1) / -1; i2 > 0; i2--)
        {
            dlarfg_adapter((i - l1) + k1, ad, (((i - l1) + k1) - 1) + (((j - l1) + k1) - 1) * l + k, ad, (((j - l1) + k1) - 1) * l + k, 1, ad1, (k1 - 1) + i1);
            double d1 = ad[(((i - l1) + k1) - 1) + (((j - l1) + k1) - 1) * l + k];
            ad[(((i - l1) + k1) - 1) + (((j - l1) + k1) - 1) * l + k] = 1.0D;
            Dlarf.dlarf("Left", (i - l1) + k1, ((j - l1) + k1) - 1, ad, (((j - l1) + k1) - 1) * l + k, 1, ad1[(k1 - 1) + i1], ad, k, l, ad2, j1);
            ad[(((i - l1) + k1) - 1) + (((j - l1) + k1) - 1) * l + k] = d1;
            k1--;
        }

    }

    private static void dlarfg_adapter(int i, double ad[], int j, double ad1[], int k, int l, double ad2[], int i1)
    {
        doubleW doublew = new doubleW(ad[j]);
        doubleW doublew1 = new doubleW(ad2[i1]);
        Dlarfg.dlarfg(i, doublew, ad1, k, l, doublew1);
        ad[j] = doublew.val;
        ad2[i1] = doublew1.val;
    }
}

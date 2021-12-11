package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlasd1
{
    public static void dlasd1(int i, int j, int k, double ad[], int l, doubleW doublew, doubleW doublew1, double ad1[], 
            int i1, int j1, double ad2[], int k1, int l1, int ai[], int i2, 
            int ai1[], int j2, double ad3[], int k2, intW intw)
    {
        int l2 = 0;
        int i3 = 0;
        int j3 = 0;
        int k3 = 0;
        int l3 = 0;
        int i4 = 0;
        int j4 = 0;
        int k4 = 0;
        int l4 = 0;
        int i5 = 0;
        intW intw1 = new intW(0);
        int j5 = 0;
        int k5 = 0;
        int l5 = 0;
        int i6 = 0;
        int j6 = 0;
        double d = 0.0;
        intw.val = 0;
        if(i < 1)
            intw.val = -1;
        else
        if(j < 1)
            intw.val = -2;
        else
        if((k < 0) || (k > 1))
            intw.val = -3;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DLASD1", -intw.val);
            return;
        }
        j6 = i + j + 1;
        i6 = j6 + k;
        k5 = j6;
        l5 = i6;
        i5 = 1;
        j4 = i5 + i6;
        k4 = j4 + j6;
        l4 = k4 + k5 * j6;
        i4 = l4 + l5 * i6;
        j3 = 1;
        k3 = j3 + j6;
        l2 = k3 + j6;
        l3 = l2 + j6;
        d = Math.max(Math.abs(doublew.val), Math.abs(doublew1.val));
        ad[((i + 1) - 1) + l] = 0.0;
        i3 = 1;
        for(int i7 = (j6 - 1) + 1; i7 > 0; i7--)
        {
            if(Math.abs(ad[(i3 - 1) + l]) > d)
                d = Math.abs(ad[(i3 - 1) + l]);
            i3++;
        }

        Dlascl.dlascl("G", 0, 0, d, 1.0, j6, 1, ad, l, j6, intw);
        doublew.val = doublew.val / d;
        doublew1.val = doublew1.val / d;
        Dlasd2.dlasd2(i, j, k, intw1, ad, l, ad3, (i5 - 1) + k2, doublew.val, doublew1.val, ad1, i1, j1, ad2, k1, l1, ad3, (j4 - 1) + k2, ad3, (k4 - 1) + k2, k5, ad3, (l4 - 1) + k2, l5, ai1, (l3 - 1) + j2, ai1, (j3 - 1) + j2, ai1, (k3 - 1) + j2, ai, i2, ai1, (l2 - 1) + j2, intw);
        j5 = intw1.val;
        Dlasd3.dlasd3(i, j, k, intw1.val, ad, l, ad3, (i4 - 1) + k2, j5, ad3, (j4 - 1) + k2, ad1, i1, j1, ad3, (k4 - 1) + k2, k5, ad2, k1, l1, ad3, (l4 - 1) + k2, l5, ai1, (k3 - 1) + j2, ai1, (l2 - 1) + j2, ad3, (i5 - 1) + k2, intw);
        if(intw.val != 0)
        {
            return;
        } else
        {
            Dlascl.dlascl("G", 0, 0, 1.0, d, j6, 1, ad, l, j6, intw);
            int k6 = intw1.val;
            int l6 = j6 - intw1.val;
            Dlamrg.dlamrg(k6, l6, ad, l, 1, -1, ai, i2);
            return;
        }
    }
}

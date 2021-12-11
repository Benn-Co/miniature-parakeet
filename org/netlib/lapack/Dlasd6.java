package org.netlib.lapack;

import org.netlib.blas.Dcopy;
import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlasd6
{
    public static void dlasd6(int i, int j, int k, int l, double ad[], int i1, double ad1[], int j1, 
            double ad2[], int k1, doubleW doublew, doubleW doublew1, int ai[], int l1, int ai1[], 
            int i2, intW intw, int ai2[], int j2, int k2, double ad3[], int l2, 
            int i3, double ad4[], int j3, double ad5[], int k3, double ad6[], int l3, 
            double ad7[], int i4, intW intw1, doubleW doublew2, doubleW doublew3, double ad8[], int j4, 
            int ai3[], int k4, intW intw2)
    {
        int l4 = 0;
        int i5 = 0;
        int j5 = 0;
        int k5 = 0;
        int l5 = 0;
        int i6 = 0;
        int j6 = 0;
        int k6 = 0;
        int l6 = 0;
        int i7 = 0;
        int j7 = 0;
        int k7 = 0;
        double d = 0.0;
        intw2.val = 0;
        i7 = j + k + 1;
        l6 = i7 + l;
        if((i < 0) || (i > 1))
            intw2.val = -1;
        else
        if(j < 1)
            intw2.val = -2;
        else
        if(k < 1)
            intw2.val = -3;
        else
        if((l < 0) || (l > 1))
            intw2.val = -4;
        else
        if(k2 < i7)
            intw2.val = -14;
        else
        if(i3 < i7)
            intw2.val = -16;
        if(intw2.val != 0)
        {
            Xerbla.xerbla("DLASD6", -intw2.val);
            return;
        }
        l5 = 1;
        k6 = l5 + i7;
        i6 = k6 + l6;
        j6 = i6 + l6;
        i5 = 1;
        j5 = i5 + i7;
        k5 = j5 + i7;
        d = Math.max(Math.abs(doublew.val), Math.abs(doublew1.val));
        ad[((j + 1) - 1) + i1] = 0.0;
        l4 = 1;
        for(int l7 = i7; l7 > 0; l7--)
        {
            if(Math.abs(ad[(l4 - 1) + i1]) > d)
                d = Math.abs(ad[(l4 - 1) + i1]);
            l4++;
        }

        Dlascl.dlascl("G", 0, 0, d, 1.0, i7, 1, ad, i1, i7, intw2);
        doublew.val = doublew.val / d;
        doublew1.val = doublew1.val / d;
        Dlasd7.dlasd7(i, j, k, l, intw1, ad, i1, ad7, i4, ad8, (k6 - 1) + j4, ad1, j1, ad8, (i6 - 1) + j4, ad2, k1, ad8, (j6 - 1) + j4, doublew.val, doublew1.val, ad8, (l5 - 1) + j4, ai3, (i5 - 1) + k4, ai3, (k5 - 1) + k4, ai, l1, ai1, i2, intw, ai2, j2, k2, ad3, l2, i3, doublew2, doublew3, intw2);
        Dlasd8.dlasd8(i, intw1.val, ad, i1, ad7, i4, ad1, j1, ad2, k1, ad5, k3, ad6, l3, i3, ad8, (l5 - 1) + j4, ad8, (k6 - 1) + j4, intw2);
        if(i == 1)
        {
            Dcopy.dcopy(intw1.val, ad, i1, 1, ad4, j3, 1);
            Dcopy.dcopy(intw1.val, ad8, (l5 - 1) + j4, 1, ad4, i3 + j3, 1);
        }
        Dlascl.dlascl("G", 0, 0, 1.0, d, i7, 1, ad, i1, i7, intw2);
        j7 = intw1.val;
        k7 = i7 - intw1.val;
        Dlamrg.dlamrg(j7, k7, ad, i1, 1, -1, ai, l1);
    }
}

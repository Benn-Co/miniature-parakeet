package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlasd0
{
    public static void dlasd0(int i, int j, double ad[], int k, double ad1[], int l, double ad2[], int i1, 
            int j1, double ad3[], int k1, int l1, int i2, int ai[], int j2, 
            double ad4[], int k2, intW intw)
    {
        int l2 = 0;
        int i4 = 0;
        int l4 = 0;
        int j5 = 0;
        int j6 = 0;
        int k6 = 0;
        int l6 = 0;
        intW intw1 = new intW(0);
        int i7 = 0;
        int j7 = 0;
        int k7 = 0;
        intW intw2 = new intW(0);
        doubleW doublew = new doubleW(0.0);
        doubleW doublew1 = new doubleW(0.0);
        intw.val = 0;
        if(i < 0)
            intw.val = -1;
        else
        if((j < 0) || (j > 1))
            intw.val = -2;
        k6 = i + j;
        if(j1 < i)
            intw.val = -6;
        else
        if(l1 < k6)
            intw.val = -8;
        else
        if(i2 < 3)
            intw.val = -9;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DLASD0", -intw.val);
            return;
        }
        if(i <= i2)
        {
            Dlasdq.dlasdq("U", j, i, k6, i, 0, ad, k, ad1, l, ad3, k1, l1, ad2, i1, j1, ad2, i1, j1, ad4, k2, intw);
            return;
        }
        l4 = 1;
        j7 = l4 + i;
        k7 = j7 + i;
        i4 = k7 + i;
        j5 = i4 + i;
        Dlasdt.dlasdt(i, intw2, intw1, ai, (l4 - 1) + j2, ai, (j7 - 1) + j2, ai, (k7 - 1) + j2, i2);
        i7 = (intw1.val + 1) / 2;
        l6 = 0;
        l2 = i7;
        for(int k10 = (intw1.val - i7) + 1; k10 > 0; k10--)
        {
            int j3 = l2 - 1;
            int k3 = ai[((l4 + j3) - 1) + j2];
            int l7 = ai[((j7 + j3) - 1) + j2];
            int l8 = l7 + 1;
            int i9 = ai[((k7 + j3) - 1) + j2];
            int l9 = i9 + 1;
            int j8 = k3 - l7;
            int k9 = k3 + 1;
            int i10 = 1;
            Dlasdq.dlasdq("U", i10, l7, l8, l7, l6, ad, (j8 - 1) + k, ad1, (j8 - 1) + l, ad3, (j8 - 1) + (j8 - 1) * l1 + k1, l1, ad2, (j8 - 1) + (j8 - 1) * j1 + i1, j1, ad2, (j8 - 1) + (j8 - 1) * j1 + i1, j1, ad4, k2, intw);
            if(intw.val != 0)
                return;
            int i5 = (i4 + j8) - 2;
            int k5 = 1;
            for(int i11 = l7; i11 > 0; i11--)
            {
                ai[((i5 + k5) - 1) + j2] = k5;
                k5++;
            }

            if(l2 == intw1.val)
                i10 = j;
            else
                i10 = 1;
            l9 = i9 + i10;
            Dlasdq.dlasdq("U", i10, i9, l9, i9, l6, ad, (k9 - 1) + k, ad1, (k9 - 1) + l, ad3, (k9 - 1) + (k9 - 1) * l1 + k1, l1, ad2, (k9 - 1) + (k9 - 1) * j1 + i1, j1, ad2, (k9 - 1) + (k9 - 1) * j1 + i1, j1, ad4, k2, intw);
            if(intw.val != 0)
                return;
            i5 = i4 + k3;
            k5 = 1;
            for(int j11 = i9; j11 > 0; j11--)
            {
                ai[((i5 + k5) - 2) + j2] = k5;
                k5++;
            }

            l2++;
        }

        j6 = intw2.val;
        for(int l10 = ((1 - intw2.val) + -1) / -1; l10 > 0; l10--)
        {
            int l5;
            int i6;
            if(j6 == 1)
            {
                l5 = 1;
                i6 = 1;
            } else
            {
                l5 = (int)Math.pow(2.0, j6 - 1.0);
                i6 = 2 * l5 - 1;
            }
            int i3 = l5;
            for(int k11 = (i6 - l5) + 1; k11 > 0; k11--)
            {
                int k4 = i3 - 1;
                int l3 = ai[((l4 + k4) - 1) + j2];
                int i8 = ai[((j7 + k4) - 1) + j2];
                int j9 = ai[((k7 + k4) - 1) + j2];
                int k8 = l3 - i8;
                int j10;
                if((j == 0) && (i3 == i6))
                    j10 = j;
                else
                    j10 = 1;
                int j4 = (i4 + k8) - 1;
                doublew.val = ad[(l3 - 1) + k];
                doublew1.val = ad1[(l3 - 1) + l];
                Dlasd1.dlasd1(i8, j9, j10, ad, (k8 - 1) + k, doublew, doublew1, ad2, (k8 - 1) + (k8 - 1) * j1 + i1, j1, ad3, (k8 - 1) + (k8 - 1) * l1 + k1, l1, ai, (j4 - 1) + j2, ai, (j5 - 1) + j2, ad4, k2, intw);
                if(intw.val != 0)
                    return;
                i3++;
            }

            j6--;
        }

    }
}

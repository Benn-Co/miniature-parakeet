package org.netlib.lapack;

import org.netlib.blas.Dcopy;
import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlasda
{
    public static void dlasda(int i, int j, int k, int l, double ad[], int i1, double ad1[], int j1, 
            double ad2[], int k1, int l1, double ad3[], int i2, int ai[], int j2, 
            double ad4[], int k2, double ad5[], int l2, double ad6[], int i3, double ad7[], 
            int j3, int ai1[], int k3, int ai2[], int l3, int i4, int ai3[], 
            int j4, double ad8[], int k4, double ad9[], int l4, double ad10[], int i5, 
            double ad11[], int j5, int ai4[], int k5, intW intw)
    {
        int l5 = 0;
        int i7 = 0;
        int i8 = 0;
        int l8 = 0;
        int i9 = 0;
        int l9 = 0;
        int j10 = 0;
        int k10 = 0;
        intW intw1 = new intW(0);
        int l10 = 0;
        int i11 = 0;
        int j11 = 0;
        intW intw2 = new intW(0);
        int i14 = 0;
        int j14 = 0;
        int k14 = 0;
        int l14 = 0;
        int k15 = 0;
        int j16 = 0;
        doubleW doublew = new doubleW(0.0);
        doubleW doublew1 = new doubleW(0.0);
        intw.val = 0;
        if((i < 0) || (i > 1))
            intw.val = -1;
        else
        if(j < 3)
            intw.val = -2;
        else
        if(k < 0)
            intw.val = -3;
        else
        if((l < 0) || (l > 1))
            intw.val = -4;
        else
        if(l1 < k + l)
            intw.val = -8;
        else
        if(i4 < k)
            intw.val = -17;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DLASDA", -intw.val);
            return;
        }
        j10 = k + l;
        if(k <= j)
        {
            if(i == 0)
                Dlasdq.dlasdq("U", l, k, 0, 0, 0, ad, i1, ad1, j1, ad3, i2, l1, ad2, k1, l1, ad2, k1, l1, ad11, j5, intw);
            else
                Dlasdq.dlasdq("U", l, k, j10, k, 0, ad, i1, ad1, j1, ad3, i2, l1, ad2, k1, l1, ad2, k1, l1, ad11, j5, intw);
            return;
        }
        i8 = 1;
        i11 = i8 + k;
        j11 = i11 + k;
        i7 = j11 + k;
        l8 = i7 + k;
        k10 = 0;
        i14 = 0;
        l14 = j + 1;
        k15 = 1;
        j16 = k15 + j10;
        j14 = j16 + j10;
        k14 = j14 + l14 * l14;
        Dlasdt.dlasdt(k, intw2, intw1, ai4, (i8 - 1) + k5, ai4, (i11 - 1) + k5, ai4, (j11 - 1) + k5, j);
        l10 = (intw1.val + 1) / 2;
        l5 = l10;
        for(int i17 = (intw1.val - l10) + 1; i17 > 0; i17--)
        {
            int j6 = l5 - 1;
            int k6 = ai4[((i8 + j6) - 1) + k5];
            int k11 = ai4[((i11 + j6) - 1) + k5];
            int k12 = k11 + 1;
            int l12 = ai4[((j11 + j6) - 1) + k5];
            int i12 = k6 - k11;
            int j13 = k6 + 1;
            int j7 = (i7 + i12) - 2;
            int l15 = (k15 + i12) - 1;
            int k16 = (j16 + i12) - 1;
            int i15 = 1;
            if(i == 0)
            {
                Dlaset.dlaset("A", k12, k12, 0.0, 1.0, ad11, (j14 - 1) + j5, l14);
                Dlasdq.dlasdq("U", i15, k11, k12, i14, k10, ad, (i12 - 1) + i1, ad1, (i12 - 1) + j1, ad11, (j14 - 1) + j5, l14, ad11, (k14 - 1) + j5, k11, ad11, (k14 - 1) + j5, k11, ad11, (k14 - 1) + j5, intw);
                int j8 = j14 + k11 * l14;
                Dcopy.dcopy(k12, ad11, (j14 - 1) + j5, 1, ad11, (l15 - 1) + j5, 1);
                Dcopy.dcopy(k12, ad11, (j8 - 1) + j5, 1, ad11, (k16 - 1) + j5, 1);
            } else
            {
                Dlaset.dlaset("A", k11, k11, 0.0, 1.0, ad2, (i12 - 1) + k1, l1);
                Dlaset.dlaset("A", k12, k12, 0.0, 1.0, ad3, (i12 - 1) + i2, l1);
                Dlasdq.dlasdq("U", i15, k11, k12, k11, k10, ad, (i12 - 1) + i1, ad1, (i12 - 1) + j1, ad3, (i12 - 1) + i2, l1, ad2, (i12 - 1) + k1, l1, ad2, (i12 - 1) + k1, l1, ad11, (j14 - 1) + j5, intw);
                Dcopy.dcopy(k12, ad3, (i12 - 1) + i2, 1, ad11, (l15 - 1) + j5, 1);
                Dcopy.dcopy(k12, ad3, (i12 - 1) + (k12 - 1) * l1 + i2, 1, ad11, (k16 - 1) + j5, 1);
            }
            if(intw.val != 0)
                return;
            i9 = 1;
            for(int k17 = k11; k17 > 0; k17--)
            {
                ai4[((j7 + i9) - 1) + k5] = i9;
                i9++;
            }

            if((l5 == intw1.val) && (l == 0))
                i15 = 0;
            else
                i15 = 1;
            j7 += k12;
            l15 += k12;
            k16 += k12;
            int l13 = l12 + i15;
            if(i == 0)
            {
                Dlaset.dlaset("A", l13, l13, 0.0, 1.0, ad11, (j14 - 1) + j5, l14);
                Dlasdq.dlasdq("U", i15, l12, l13, i14, k10, ad, (j13 - 1) + i1, ad1, (j13 - 1) + j1, ad11, (j14 - 1) + j5, l14, ad11, (k14 - 1) + j5, l12, ad11, (k14 - 1) + j5, l12, ad11, (k14 - 1) + j5, intw);
                int k8 = j14 + (l13 - 1) * l14;
                Dcopy.dcopy(l13, ad11, (j14 - 1) + j5, 1, ad11, (l15 - 1) + j5, 1);
                Dcopy.dcopy(l13, ad11, (k8 - 1) + j5, 1, ad11, (k16 - 1) + j5, 1);
            } else
            {
                Dlaset.dlaset("A", l12, l12, 0.0, 1.0, ad2, (j13 - 1) + k1, l1);
                Dlaset.dlaset("A", l13, l13, 0.0, 1.0, ad3, (j13 - 1) + i2, l1);
                Dlasdq.dlasdq("U", i15, l12, l13, l12, k10, ad, (j13 - 1) + i1, ad1, (j13 - 1) + j1, ad3, (j13 - 1) + i2, l1, ad2, (j13 - 1) + k1, l1, ad2, (j13 - 1) + k1, l1, ad11, (j14 - 1) + j5, intw);
                Dcopy.dcopy(l13, ad3, (j13 - 1) + i2, 1, ad11, (l15 - 1) + j5, 1);
                Dcopy.dcopy(l13, ad3, (j13 - 1) + (l13 - 1) * l1 + i2, 1, ad11, (k16 - 1) + j5, 1);
            }
            if(intw.val != 0)
                return;
            i9 = 1;
            for(int l17 = l12; l17 > 0; l17--)
            {
                ai4[((j7 + i9) - 1) + k5] = i9;
                i9++;
            }

            l5++;
        }

        i9 = (int) Math.pow(2.0, intw2.val);
        l9 = intw2.val;
        for(int j17 = ((1 - intw2.val) + -1) / -1; j17 > 0; j17--)
        {
            int i10 = l9 * 2 - 1;
            int j9;
            int k9;
            if(l9 == 1)
            {
                j9 = 1;
                k9 = 1;
            } else
            {
                j9 = (int) Math.pow(2.0, l9 - 1);
                k9 = 2 * j9 - 1;
            }
            int i6 = j9;
            for(int i18 = (k9 - j9) + 1; i18 > 0; i18--)
            {
                int l7 = i6 - 1;
                int l6 = ai4[((i8 + l7) - 1) + k5];
                int l11 = ai4[((i11 + l7) - 1) + k5];
                int i13 = ai4[((j11 + l7) - 1) + k5];
                int j12 = l6 - l11;
                int j15;
                if(i6 == k9)
                    j15 = l;
                else
                    j15 = 1;
                int i16 = (k15 + j12) - 1;
                int l16 = (j16 + j12) - 1;
                int k7 = (i7 + j12) - 1;
                doublew.val = ad[(l6 - 1) + i1];
                doublew1.val = ad1[(l6 - 1) + j1];
                if(i == 0)
                {
                    dlasd6_adapter(i, l11, i13, j15, ad, (j12 - 1) + i1, ad11, (i16 - 1) + j5, ad11, (l16 - 1) + j5, doublew, doublew1, ai4, (k7 - 1) + k5, ai3, j4, ai1, k3, ai2, l3, i4, ad8, k4, l1, ad7, j3, ad4, k2, ad5, l2, ad6, i3, ai, j2, ad9, l4, ad10, i5, ad11, (j14 - 1) + j5, ai4, (l8 - 1) + k5, intw);
                } else
                {
                    i9--;
                    dlasd6_adapter(i, l11, i13, j15, ad, (j12 - 1) + i1, ad11, (i16 - 1) + j5, ad11, (l16 - 1) + j5, doublew, doublew1, ai4, (k7 - 1) + k5, ai3, (j12 - 1) + (l9 - 1) * i4 + j4, ai1, (i9 - 1) + k3, ai2, (j12 - 1) + (i10 - 1) * i4 + l3, i4, ad8, (j12 - 1) + (i10 - 1) * l1 + k4, l1, ad7, (j12 - 1) + (i10 - 1) * l1 + j3, ad4, (j12 - 1) + (l9 - 1) * l1 + k2, ad5, (j12 - 1) + (i10 - 1) * l1 + l2, ad6, (j12 - 1) + (l9 - 1) * l1 + i3, ai, (i9 - 1) + j2, ad9, (i9 - 1) + l4, ad10, (i9 - 1) + i5, ad11, (j14 - 1) + j5, ai4, (l8 - 1) + k5, intw);
                }
                if(intw.val != 0)
                    return;
                i6++;
            }

            l9--;
        }

    }

    private static void dlasd6_adapter(int i, int j, int k, int l, double ad[], int i1, double ad1[], int j1, 
            double ad2[], int k1, doubleW doublew, doubleW doublew1, int ai[], int l1, int ai1[], 
            int i2, int ai2[], int j2, int ai3[], int k2, int l2, double ad3[], 
            int i3, int j3, double ad4[], int k3, double ad5[], int l3, double ad6[], 
            int i4, double ad7[], int j4, int ai4[], int k4, double ad8[], int l4, 
            double ad9[], int i5, double ad10[], int j5, int ai5[], int k5, intW intw)
    {
        intW intw1 = new intW(ai2[j2]);
        intW intw2 = new intW(ai4[k4]);
        doubleW doublew2 = new doubleW(ad8[l4]);
        doubleW doublew3 = new doubleW(ad9[i5]);
        Dlasd6.dlasd6(i, j, k, l, ad, i1, ad1, j1, ad2, k1, doublew, doublew1, ai, l1, ai1, i2, intw1, ai3, k2, l2, ad3, i3, j3, ad4, k3, ad5, l3, ad6, i4, ad7, j4, intw2, doublew2, doublew3, ad10, j5, ai5, k5, intw);
        ai2[j2] = intw1.val;
        ai4[k4] = intw2.val;
        ad8[l4] = doublew2.val;
        ad9[i5] = doublew3.val;
    }
}

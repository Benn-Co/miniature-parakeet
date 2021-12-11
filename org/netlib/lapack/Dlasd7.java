package org.netlib.lapack;

import org.netlib.blas.Dcopy;
import org.netlib.blas.Drot;
import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlasd7
{
    public static void dlasd7(int i, int j, int k, int l, intW intw, double ad[], int i1, double ad1[], 
            int j1, double ad2[], int k1, double ad3[], int l1, double ad4[], int i2, 
            double ad5[], int j2, double ad6[], int k2, double d, double d1, double ad7[], int l2, int ai[], int i3, int ai1[], int j3, 
            int ai2[], int k3, int ai3[], int l3, intW intw1, int ai4[], int i4, 
            int j4, double ad8[], int k4, int l4, doubleW doublew, doubleW doublew1, intW intw2)
    {
        int l7;
        int i8;
        int j8;
        double d7;
        double d8;
label0:
        {
            int i5 = 0;
            int i6 = 0;
            int j7 = 0;
            int k7 = 0;
            l7 = 0;
            i8 = 0;
            j8 = 0;
            int k8 = 0;
            double d2 = 0.0;
            double d5 = 0.0;
            d7 = 0.0;
            d8 = 0.0;
            intw2.val = 0;
            i8 = j + k + 1;
            l7 = i8 + l;
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
            if(j4 < i8)
                intw2.val = -22;
            else
            if(l4 < i8)
                intw2.val = -24;
            if(intw2.val != 0)
            {
                Xerbla.xerbla("DLASD7", -intw2.val);
                return;
            }
            j8 = j + 1;
            k8 = j + 2;
            if(i == 1)
                intw1.val = 0;
            d8 = d * ad5[(j8 - 1) + j2];
            ad5[(j8 - 1) + j2] = 0.0;
            d5 = ad3[(j8 - 1) + l1];
            i5 = j;
            for(int l8 = ((1 - j) + -1) / -1; l8 > 0; l8--)
            {
                ad1[((i5 + 1) - 1) + j1] = d * ad5[(i5 - 1) + j2];
                ad5[(i5 - 1) + j2] = 0.0;
                ad3[((i5 + 1) - 1) + l1] = ad3[(i5 - 1) + l1];
                ad[((i5 + 1) - 1) + i1] = ad[(i5 - 1) + i1];
                ai2[((i5 + 1) - 1) + k3] = ai2[(i5 - 1) + k3] + 1;
                i5--;
            }

            ad3[(1 - 1) + l1] = d5;
            i5 = k8;
            for(int i9 = (l7 - k8) + 1; i9 > 0; i9--)
            {
                ad1[(i5 - 1) + j1] = d1 * ad3[(i5 - 1) + l1];
                ad3[(i5 - 1) + l1] = 0.0;
                i5++;
            }

            i5 = k8;
            for(int j9 = (i8 - k8) + 1; j9 > 0; j9--)
            {
                ai2[(i5 - 1) + k3] = ai2[(i5 - 1) + k3] + j8;
                i5++;
            }

            i5 = 2;
            for(int k9 = (i8 - 2) + 1; k9 > 0; k9--)
            {
                ad7[(i5 - 1) + l2] = ad[(ai2[(i5 - 1) + k3] - 1) + i1];
                ad2[(i5 - 1) + k1] = ad1[(ai2[(i5 - 1) + k3] - 1) + j1];
                ad4[(i5 - 1) + i2] = ad3[(ai2[(i5 - 1) + k3] - 1) + l1];
                ad6[(i5 - 1) + k2] = ad5[(ai2[(i5 - 1) + k3] - 1) + j2];
                i5++;
            }

            Dlamrg.dlamrg(j, k, ad7, (2 - 1) + l2, 1, 1, ai, (2 - 1) + i3);
            i5 = 2;
            for(int l9 = (i8 - 2) + 1; l9 > 0; l9--)
            {
                int j5 = 1 + ai[(i5 - 1) + i3];
                ad[(i5 - 1) + i1] = ad7[(j5 - 1) + l2];
                ad1[(i5 - 1) + j1] = ad2[(j5 - 1) + k1];
                ad3[(i5 - 1) + l1] = ad4[(j5 - 1) + i2];
                ad5[(i5 - 1) + j2] = ad6[(j5 - 1) + k2];
                i5++;
            }

            d2 = Dlamch.dlamch("Epsilon");
            d7 = Math.max(Math.abs(d), Math.abs(d1));
            d7 = 8.0 * 8.0 * d2 * Math.max(Math.abs(ad[(i8 - 1) + i1]), d7);
            intw.val = 1;
            k7 = i8 + 1;
            i6 = 2;
            for(int i10 = (i8 - 2) + 1; i10 > 0; i10--)
            {
                if(Math.abs(ad1[(i6 - 1) + j1]) <= d7)
                {
                    k7--;
                    ai1[(k7 - 1) + j3] = i6;
                    if(i6 == i8)
                        break label0;
                } else
                {
                    j7 = i6;
                    break;
                }
                i6++;
            }

            i6 = j7;
            do
            {
                i6++;
                if(i6 > i8)
                    break;
                if(Math.abs(ad1[(i6 - 1) + j1]) <= d7)
                {
                    k7--;
                    ai1[(k7 - 1) + j3] = i6;
                } else
                if(Math.abs(ad[(i6 - 1) + i1] - ad[(j7 - 1) + i1]) <= d7)
                {
                    doublew1.val = ad1[(j7 - 1) + j1];
                    doublew.val = ad1[(i6 - 1) + j1];
                    double d6 = Dlapy2.dlapy2(doublew.val, doublew1.val);
                    ad1[(i6 - 1) + j1] = d6;
                    ad1[(j7 - 1) + j1] = 0.0D;
                    doublew.val = doublew.val / d6;
                    doublew1.val = -(doublew1.val / d6);
                    if(i == 1)
                    {
                        intw1.val = intw1.val + 1;
                        int l5 = ai2[((ai[(j7 - 1) + i3] + 1) - 1) + k3];
                        int k5 = ai2[((ai[(i6 - 1) + i3] + 1) - 1) + k3];
                        if(l5 <= j8)
                            l5--;
                        if(k5 <= j8)
                            k5--;
                        ai4[(intw1.val - 1) + (2 - 1) * j4 + i4] = l5;
                        ai4[(intw1.val - 1) + (1 - 1) * j4 + i4] = k5;
                        ad8[(intw1.val - 1) + (2 - 1) * l4 + k4] = doublew.val;
                        ad8[(intw1.val - 1) + (1 - 1) * l4 + k4] = doublew1.val;
                    }
                    Drot.drot(1, ad3, (j7 - 1) + l1, 1, ad3, (i6 - 1) + l1, 1, doublew.val, doublew1.val);
                    Drot.drot(1, ad5, (j7 - 1) + j2, 1, ad5, (i6 - 1) + j2, 1, doublew.val, doublew1.val);
                    k7--;
                    ai1[(k7 - 1) + j3] = j7;
                    j7 = i6;
                } else
                {
                    intw.val = intw.val + 1;
                    ad2[(intw.val - 1) + k1] = ad1[(j7 - 1) + j1];
                    ad7[(intw.val - 1) + l2] = ad[(j7 - 1) + i1];
                    ai1[(intw.val - 1) + j3] = j7;
                    j7 = i6;
                }
            } while(true);
            intw.val = intw.val + 1;
            ad2[(intw.val - 1) + k1] = ad1[(j7 - 1) + j1];
            ad7[(intw.val - 1) + l2] = ad[(j7 - 1) + i1];
            ai1[(intw.val - 1) + j3] = j7;
        }
        int j6 = 2;
        for(int j10 = (i8 - 2) + 1; j10 > 0; j10--)
        {
            int l6 = ai1[(j6 - 1) + j3];
            ad7[(j6 - 1) + l2] = ad[(l6 - 1) + i1];
            ad4[(j6 - 1) + i2] = ad3[(l6 - 1) + l1];
            ad6[(j6 - 1) + k2] = ad5[(l6 - 1) + j2];
            j6++;
        }

        if(i == 1)
        {
            int k6 = 2;
            for(int k10 = (i8 - 2) + 1; k10 > 0; k10--)
            {
                int i7 = ai1[(k6 - 1) + j3];
                ai3[(k6 - 1) + l3] = ai2[((ai[(i7 - 1) + i3] + 1) - 1) + k3];
                if(ai3[(k6 - 1) + l3] <= j8)
                    ai3[(k6 - 1) + l3] = ai3[(k6 - 1) + l3] - 1;
                k6++;
            }

        }
        Dcopy.dcopy(i8 - intw.val, ad7, ((intw.val + 1) - 1) + l2, 1, ad, ((intw.val + 1) - 1) + i1, 1);
        ad7[l2] = 0.0;
        double d4 = d7 / 2.0;
        if(Math.abs(ad7[(2 - 1) + l2]) <= d4)
            ad7[(2 - 1) + l2] = d4;
        if(l7 > i8)
        {
            ad1[(1 - 1) + j1] = Dlapy2.dlapy2(d8, ad1[(l7 - 1) + j1]);
            if(ad1[(1 - 1) + j1] <= d7)
            {
                doublew.val = 1.0;
                doublew1.val = 0.0;
                ad1[(1 - 1) + j1] = d7;
            } else
            {
                doublew.val = d8 / ad1[j1];
                doublew1.val = -(ad1[(l7 - 1) + j1] / ad1[j1]);
            }
            Drot.drot(1, ad3, (l7 - 1) + l1, 1, ad3, l1, 1, doublew.val, doublew1.val);
            Drot.drot(1, ad5, (l7 - 1) + j2, 1, ad5, j2, 1, doublew.val, doublew1.val);
        } else
        if(Math.abs(d8) <= d7)
            ad1[j1] = d7;
        else
            ad1[j1] = d8;
        Dcopy.dcopy(intw.val - 1, ad2, 1 + k1, 1, ad1, 1 + j1, 1);
        Dcopy.dcopy(i8 - 1, ad4, 1 + i2, 1, ad3, 1 + l1, 1);
        Dcopy.dcopy(i8 - 1, ad6, 1 + k2, 1, ad5, 1 + j2, 1);
    }
}

package org.netlib.lapack;

import org.netlib.blas.Dcopy;
import org.netlib.blas.Drot;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dlasd2
{
    public static void dlasd2(int i, int j, int k, intW intw, double ad[], int l, double ad1[], int i1, 
            double d, double d1, double ad2[], int j1, int k1, 
            double ad3[], int l1, int i2, double ad4[], int j2, double ad5[], int k2, 
            int l2, double ad6[], int i3, int j3, int ai[], int k3, int ai1[], 
            int l3, int ai2[], int i4, int ai3[], int j4, int ai4[], int k4, 
            intW intw1)
    {
        int ai5[];
        int ai6[];
        int j8;
        int k8;
        int l8;
        int i9;
        double d2;
        double d6;
        double d9;
        double d10;
label0:
        {
            ai5 = new int[4];
            ai6 = new int[4];
            int j5 = 0;
            int l6 = 0;
            int l7 = 0;
            int i8 = 0;
            j8 = 0;
            k8 = 0;
            l8 = 0;
            i9 = 0;
            d2 = 0.0;
            double d3 = 0.0;
            d6 = 0.0;
            d9 = 0.0;
            d10 = 0.0;
            intw1.val = 0;
            if(i < 1)
                intw1.val = -1;
            else
            if(j < 1)
                intw1.val = -2;
            else
            if((k != 1) && (k != 0))
                intw1.val = -3;
            k8 = i + j + 1;
            j8 = k8 + k;
            if(k1 < k8)
                intw1.val = -10;
            else
            if(i2 < j8)
                intw1.val = -12;
            else
            if(l2 < k8)
                intw1.val = -15;
            else
            if(j3 < j8)
                intw1.val = -17;
            if(intw1.val != 0)
            {
                Xerbla.xerbla("DLASD2", -intw1.val);
                return;
            }
            l8 = i + 1;
            i9 = i + 2;
            d10 = d * ad3[(l8 - 1) + (l8 - 1) * i2 + l1];
            ad1[(1 - 1) + i1] = d10;
            j5 = i;
            for(int j9 = ((1 - i) + -1) / -1; j9 > 0; j9--)
            {
                ad1[((j5 + 1) - 1) + i1] = d * ad3[(j5 - 1) + (l8 - 1) * i2 + l1];
                ad[((j5 + 1) - 1) + l] = ad[(j5 - 1) + l];
                ai3[((j5 + 1) - 1) + j4] = ai3[(j5 - 1) + j4] + 1;
                j5--;
            }

            j5 = i9;
            for(int k9 = (j8 - i9) + 1; k9 > 0; k9--)
            {
                ad1[(j5 - 1) + i1] = d1 * ad3[(j5 - 1) + (i9 - 1) * i2 + l1];
                j5++;
            }

            j5 = 2;
            for(int l9 = l8 - 1; l9 > 0; l9--)
            {
                ai4[(j5 - 1) + k4] = 1;
                j5++;
            }

            j5 = i9;
            for(int i10 = (k8 - i9) + 1; i10 > 0; i10--)
            {
                ai4[(j5 - 1) + k4] = 2;
                j5++;
            }

            j5 = i9;
            for(int j10 = (k8 - i9) + 1; j10 > 0; j10--)
            {
                ai3[(j5 - 1) + j4] = ai3[(j5 - 1) + j4] + l8;
                j5++;
            }

            j5 = 2;
            for(int k10 = k8 - 1; k10 > 0; k10--)
            {
                ad4[(j5 - 1) + j2] = ad[(ai3[(j5 - 1) + j4] - 1) + l];
                ad5[(j5 - 1) + (1 - 1) * l2 + k2] = ad1[(ai3[(j5 - 1) + j4] - 1) + i1];
                ai2[(j5 - 1) + i4] = ai4[(ai3[(j5 - 1) + j4] - 1) + k4];
                j5++;
            }

            Dlamrg.dlamrg(i, j, ad4, 1 + j2, 1, 1, ai1, 1 + l3);
            j5 = 2;
            for(int l10 = k8 - 1; l10 > 0; l10--)
            {
                int l5 = 1 + ai1[(j5 - 1) + l3];
                ad[(j5 - 1) + l] = ad4[(l5 - 1) + j2];
                ad1[(j5 - 1) + i1] = ad5[(l5 - 1) + (1 - 1) * l2 + k2];
                ai4[(j5 - 1) + k4] = ai2[(l5 - 1) + i4];
                j5++;
            }

            d3 = Dlamch.dlamch("Epsilon");
            d9 = Math.max(Math.abs(d), Math.abs(d1));
            d9 = 8D * d3 * Math.max(Math.abs(ad[(k8 - 1) + l]), d9);
            intw.val = 1;
            i8 = k8 + 1;
            l6 = 2;
            for(int i11 = k8 - 1; i11 > 0; i11--)
            {
                if(Math.abs(ad1[(l6 - 1) + i1]) <= d9)
                {
                    i8--;
                    ai[(i8 - 1) + k3] = l6;
                    ai4[(l6 - 1) + k4] = 4;
                    if(l6 == k8)
                        break label0;
                } else
                {
                    l7 = l6;
                    break;
                }
                l6++;
            }

            l6 = l7;
            do
            {
                l6++;
                if(l6 > k8)
                    break;
                if(Math.abs(ad1[(l6 - 1) + i1]) <= d9)
                {
                    i8--;
                    ai[(i8 - 1) + k3] = l6;
                    ai4[(l6 - 1) + k4] = 4;
                } else
                if(Math.abs(ad[(l6 - 1) + l] - ad[(l7 - 1) + l]) <= d9)
                {
                    d6 = ad1[(l7 - 1) + i1];
                    d2 = ad1[(l6 - 1) + i1];
                    double d8 = Dlapy2.dlapy2(d2, d6);
                    d2 /= d8;
                    d6 = -(d6 / d8);
                    ad1[(l6 - 1) + i1] = d8;
                    ad1[(l7 - 1) + i1] = 0.0;
                    int k6 = ai3[((ai1[(l7 - 1) + l3] + 1) - 1) + j4];
                    int i6 = ai3[((ai1[(l6 - 1) + l3] + 1) - 1) + j4];
                    if(k6 <= l8)
                        k6--;
                    if(i6 <= l8)
                        i6--;
                    Drot.drot(k8, ad2, (k6 - 1) * k1 + j1, 1, ad2, (1 - 1) + (i6 - 1) * k1 + j1, 1, d2, d6);
                    Drot.drot(j8, ad3, (k6 - 1) + l1, i2, ad3, (i6 - 1) + l1, i2, d2, d6);
                    if(ai4[(l6 - 1) + k4] != ai4[(l7 - 1) + k4])
                        ai4[(l6 - 1) + k4] = 3;
                    ai4[(l7 - 1) + k4] = 4;
                    i8--;
                    ai[(i8 - 1) + k3] = l7;
                    l7 = l6;
                } else
                {
                    intw.val = intw.val + 1;
                    ad5[(intw.val - 1) + (1 - 1) * l2 + k2] = ad1[(l7 - 1) + i1];
                    ad4[(intw.val - 1) + j2] = ad[(l7 - 1) + l];
                    ai[(intw.val - 1) + k3] = l7;
                    l7 = l6;
                }
            } while(true);
            intw.val = intw.val + 1;
            ad5[(intw.val - 1) + (1 - 1) * l2 + k2] = ad1[(l7 - 1) + i1];
            ad4[(intw.val - 1) + j2] = ad[(l7 - 1) + l];
            ai[(intw.val - 1) + k3] = l7;
        }
        int i7 = 1;
        for(int j11 = 4; j11 > 0; j11--)
        {
            ai5[i7 - 1] = 0;
            i7++;
        }

        i7 = 2;
        for(int k11 = k8 - 1; k11 > 0; k11--)
        {
            int l4 = ai4[(i7 - 1) + k4];
            ai5[l4 - 1] = ai5[l4 - 1] + 1;
            i7++;
        }

        ai6[0] = 2;
        ai6[1] = 2 + ai5[0];
        ai6[2] = ai6[1] + ai5[1];
        ai6[3] = ai6[2] + ai5[2];
        i7 = 2;
        for(int l11 = k8 - 1; l11 > 0; l11--)
        {
            int j7 = ai[(i7 - 1) + k3];
            int i5 = ai4[(j7 - 1) + k4];
            ai2[(ai6[i5 - 1] - 1) + i4] = i7;
            ai6[i5 - 1] = ai6[i5 - 1] + 1;
            i7++;
        }

        i7 = 2;
        for(int i12 = k8 - 1; i12 > 0; i12--)
        {
            int k7 = ai[(i7 - 1) + k3];
            ad4[(i7 - 1) + j2] = ad[(k7 - 1) + l];
            int j6 = ai3[((ai1[(ai[(ai2[(i7 - 1) + i4] - 1) + k3] - 1) + l3] + 1) - 1) + j4];
            if(j6 <= l8)
                j6--;
            Dcopy.dcopy(k8, ad2, (j6 - 1) * k1 + j1, 1, ad5, (i7 - 1) * l2 + k2, 1);
            Dcopy.dcopy(j8, ad3, (j6 - 1) + l1, i2, ad6, (i7 - 1) + i3, j3);
            i7++;
        }

        ad4[j2] = 0.0;
        double d5 = d9 / 2.0;
        if(Math.abs(ad4[1 + j2]) <= d5)
            ad4[1 + j2] = d5;
        if(j8 > k8)
        {
            ad1[i1] = Dlapy2.dlapy2(d10, ad1[(j8 - 1) + i1]);
            if(ad1[i1] <= d9)
            {
                d2 = 1.0;
                d6 = 0.0;
                ad1[i1] = d9;
            } else
            {
                d2 = d10 / ad1[i1];
                d6 = ad1[(j8 - 1) + i1] / ad1[i1];
            }
        } else
        if(Math.abs(d10) <= d9)
            ad1[i1] = d9;
        else
            ad1[i1] = d10;
        Dcopy.dcopy(intw.val - 1, ad5, 1 + k2, 1, ad1, 1 + i1, 1);
        Dlaset.dlaset("A", k8, 1, 0.0, 0.0, ad5, k2, l2);
        ad5[(l8 - 1) + k2] = 1.0;
        if(j8 > k8)
        {
            int k5 = 1;
            for(int j12 = l8; j12 > 0; j12--)
            {
                ad3[(j8 - 1) + (k5 - 1) * i2 + l1] = -(d6 * ad3[(l8 - 1) + (k5 - 1) * i2 + l1]);
                ad6[(k5 - 1) * j3 + i3] = d2 * ad3[(l8 - 1) + (k5 - 1) * i2 + l1];
                k5++;
            }

            k5 = i9;
            for(int k12 = (j8 - i9) + 1; k12 > 0; k12--)
            {
                ad6[(k5 - 1) * j3 + i3] = d6 * ad3[(j8 - 1) + (k5 - 1) * i2 + l1];
                ad3[(j8 - 1) + (k5 - 1) * i2 + l1] = d2 * ad3[(j8 - 1) + (k5 - 1) * i2 + l1];
                k5++;
            }

        } else
        {
            Dcopy.dcopy(j8, ad3, (l8 - 1) + l1, i2, ad6, i3, j3);
        }
        if(j8 > k8)
            Dcopy.dcopy(j8, ad3, (j8 - 1) + l1, i2, ad6, (j8 - 1) + i3, j3);
        if(k8 > intw.val)
        {
            Dcopy.dcopy(k8 - intw.val, ad4, ((intw.val + 1) - 1) + j2, 1, ad, ((intw.val + 1) - 1) + l, 1);
            Dlacpy.dlacpy("A", k8, k8 - intw.val, ad5, ((intw.val + 1) - 1) * l2 + k2, l2, ad2, ((intw.val + 1) - 1) * k1 + j1, k1);
            Dlacpy.dlacpy("A", k8 - intw.val, j8, ad6, ((intw.val + 1) - 1) + i3, j3, ad3, ((intw.val + 1) - 1) + l1, i2);
        }
        i7 = 1;
        for (int l12 = 4; l12 > 0; l12--)
        {
            ai4[(i7 - 1) + k4] = ai5[i7 - 1];
            i7++;
        }

    }
}

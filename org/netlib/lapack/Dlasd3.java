package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.*;

public final class Dlasd3
{
    public static void dlasd3(int i, int j, int k, int l, double ad[], int i1, double ad1[], int j1, 
            int k1, double ad2[], int l1, double ad3[], int i2, int j2, double ad4[], 
            int k2, int l2, double ad5[], int i3, int j3, double ad6[], int k3, 
            int l3, int ai[], int i4, int ai1[], int j4, double ad7[], int k4, 
            intW intw)
    {
        int l4 = 0;
        int i5 = 0;
        int k5 = 0;
        int i7 = 0;
        int j7 = 0;
        int k7 = 0;
        int l7 = 0;
        int i8 = 0;
        int j8 = 0;
        double d = 0.0;
        intw.val = 0;
        if(i < 1)
            intw.val = -1;
        else
        if(j < 1)
            intw.val = -2;
        else
        if((k != 1) && (k != 0))
            intw.val = -3;
        k7 = i + j + 1;
        j7 = k7 + k;
        l7 = i + 1;
        i8 = i + 2;
        if((l < 1) || (l > k7))
            intw.val = -4;
        else
        if(k1 < l)
            intw.val = -7;
        else
        if(j2 < k7)
            intw.val = -10;
        else
        if(l2 < k7)
            intw.val = -12;
        else
        if(j3 < j7)
            intw.val = -14;
        else
        if(l3 < j7)
            intw.val = -16;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DLASD3", -intw.val);
            return;
        }
        if(l == 1)
        {
            ad[(1 - 1) + i1] = Math.abs(ad7[k4]);
            Dcopy.dcopy(j7, ad6, k3, l3, ad5, i3, j3);
            if(ad7[(1 - 1) + k4] > 0.0)
            {
                Dcopy.dcopy(k7, ad4, k2, 1, ad3, i2, 1);
            } else
            {
                i5 = 1;
                for(int k8 = k7; k8 > 0; k8--)
                {
                    ad3[(i5 - 1) + i2] = -ad4[(i5 - 1) + k2];
                    i5++;
                }

            }
            return;
        }
        i5 = 1;
        for(int l8 = (l - 1) + 1; l8 > 0; l8--)
        {
            ad2[(i5 - 1) + l1] = Dlamc3.dlamc3(ad2[(i5 - 1) + l1], ad2[(i5 - 1) + l1]) - ad2[(i5 - 1) + l1];
            i5++;
        }

        Dcopy.dcopy(l, ad7, k4, 1, ad1, j1, 1);
        d = Dnrm2.dnrm2(l, ad7, k4, 1);
        Dlascl.dlascl("G", 0, 0, d, 1.0, l, 1, ad7, k4, l, intw);
        d *= d;
        k5 = 1;
        for(int i9 = (l - 1) + 1; i9 > 0; i9--)
        {
            dlasd4_adapter(l, k5, ad2, l1, ad7, k4, ad3, (k5 - 1) * j2 + i2, d, ad, (k5 - 1) + i1, ad5, (k5 - 1) * j3 + i3, intw);
            if(intw.val != 0)
                return;
            k5++;
        }

        i5 = 1;
        for(int j9 = (l - 1) + 1; j9 > 0; j9--)
        {
            ad7[(i5 - 1) + k4] = ad3[(i5 - 1) + (l - 1) * j2 + i2] * ad5[(i5 - 1) + (l - 1) * j3 + i3];
            int l5 = 1;
            for(int k10 = (i5 - 1 - 1) + 1; k10 > 0; k10--)
            {
                ad7[(i5 - 1) + k4] = ad7[(i5 - 1) + k4] * ((ad3[(i5 - 1) + (l5 - 1) * j2 + i2] * ad5[(i5 - 1) + (l5 - 1) * j3 + i3]) / (ad2[(i5 - 1) + l1] - ad2[(l5 - 1) + l1]) / (ad2[(i5 - 1) + l1] + ad2[(l5 - 1) + l1]));
                l5++;
            }

            l5 = i5;
            for(int l10 = (l - 1 - i5) + 1; l10 > 0; l10--)
            {
                ad7[(i5 - 1) + k4] = ad7[(i5 - 1) + k4] * ((ad3[(i5 - 1) + (l5 - 1) * j2 + i2] * ad5[(i5 - 1) + (l5 - 1) * j3 + i3]) / (ad2[(i5 - 1) + l1] - ad2[((l5 + 1) - 1) + l1]) / (ad2[(i5 - 1) + l1] + ad2[((l5 + 1) - 1) + l1]));
                l5++;
            }

            ad7[(i5 - 1) + k4] = Util.dsign(Math.sqrt(Math.abs(ad7[(i5 - 1) + k4])), ad1[(i5 - 1) + j1]);
            i5++;
        }

        i5 = 1;
        for(int k9 = (l - 1) + 1; k9 > 0; k9--)
        {
            ad5[(i5 - 1) * j3 + i3] = ad7[k4] / ad3[(i5 - 1) * j2 + i2] / ad5[(i5 - 1) * j3 + i3];
            ad3[(i5 - 1) * j2 + i2] = -1.0;
            int i6 = 2;
            for(int i11 = (l - 2) + 1; i11 > 0; i11--)
            {
                ad5[(i6 - 1) + (i5 - 1) * j3 + i3] = ad7[(i6 - 1) + k4] / ad3[(i6 - 1) + (i5 - 1) * j2 + i2] / ad5[(i6 - 1) + (i5 - 1) * j3 + i3];
                ad3[(i6 - 1) + (i5 - 1) * j2 + i2] = ad2[(i6 - 1) + l1] * ad5[(i6 - 1) + (i5 - 1) * j3 + i3];
                i6++;
            }

            double d2 = Dnrm2.dnrm2(l, ad3, (i5 - 1) * j2 + i2, 1);
            ad1[(1 - 1) + (i5 - 1) * k1 + j1] = ad3[(1 - 1) + (i5 - 1) * j2 + i2] / d2;
            i6 = 2;
            for(int j11 = (l - 2) + 1; j11 > 0; j11--)
            {
                int k6 = ai[(i6 - 1) + i4];
                ad1[(i6 - 1) + (i5 - 1) * k1 + j1] = ad3[(k6 - 1) + (i5 - 1) * j2 + i2] / d2;
                i6++;
            }

            i5++;
        }

        if(l == 2)
        {
            Dgemm.dgemm("N", "N", k7, l, l, 1.0, ad4, k2, l2, ad1, j1, k1, 0.0, ad3, i2, j2);
        } else
        {
            if(ai1[(1 - 1) + j4] > 0)
            {
                Dgemm.dgemm("N", "N", i, l, ai1[j4], 1.0, ad4, l2 + k2, l2, ad1, 1 + j1, k1, 0.0, ad3, i2, j2);
                if(ai1[2 + j4] > 0)
                {
                    i7 = 2 + ai1[j4] + ai1[1 + j4];
                    Dgemm.dgemm("N", "N", i, l, ai1[2 + j4], 1.0, ad4, (i7 - 1) * l2 + k2, l2, ad1, (i7 - 1) + j1, k1, 1.0, ad3, i2, j2);
                }
            } else
            if(ai1[2 + j4] > 0)
            {
                i7 = 2 + ai1[j4] + ai1[1 + j4];
                Dgemm.dgemm("N", "N", i, l, ai1[2 + j4], 1.0, ad4, (i7 - 1) * l2 + k2, l2, ad1, (i7 - 1) + j1, k1, 0.0, ad3, i2, j2);
            } else
            {
                Dlacpy.dlacpy("F", i, l, ad4, k2, l2, ad3, i2, j2);
            }
            Dcopy.dcopy(l, ad1, j1, k1, ad3, (l7 - 1) + i2, j2);
            i7 = 2 + ai1[j4];
            l4 = ai1[1 + j4] + ai1[2 + j4];
            Dgemm.dgemm("N", "N", j, l, l4, 1.0, ad4, (i8 - 1) + (i7 - 1) * l2 + k2, l2, ad1, (i7 - 1) + j1, k1, 0.0, ad3, (i8 - 1) + i2, j2);
        }
        i5 = 1;
        for(int l9 = l; l9 > 0; l9--)
        {
            double d3 = Dnrm2.dnrm2(l, ad5, (i5 - 1) * j3 + i3, 1);
            ad1[(i5 - 1) + j1] = ad5[(i5 - 1) * j3 + i3] / d3;
            int j6 = 2;
            for(int k11 = l - 1; k11 > 0; k11--)
            {
                int l6 = ai[(j6 - 1) + i4];
                ad1[(i5 - 1) + (j6 - 1) * k1 + j1] = ad5[(l6 - 1) + (i5 - 1) * j3 + i3] / d3;
                j6++;
            }

            i5++;
        }

        if(l == 2)
        {
            Dgemm.dgemm("N", "N", l, j7, l, 1.0, ad1, j1, k1, ad6, k3, l3, 0.0, ad5, i3, j3);
            return;
        }
        i7 = 1 + ai1[j4];
        Dgemm.dgemm("N", "N", l, l7, i7, 1.0, ad1, j1, k1, ad6, k3, l3, 0.0, ad5, i3, j3);
        i7 = 2 + ai1[j4] + ai1[1 + j4];
        if(i7 <= l3)
            Dgemm.dgemm("N", "N", l, l7, ai1[(3 - 1) + j4], 1.0, ad1, (i7 - 1) * k1 + j1, k1, ad6, (i7 - 1) + k3, l3, 1.0, ad5, i3, j3);
        i7 = ai1[j4] + 1;
        j8 = j + k;
        if(i7 > 1)
        {
            int j5 = 1;
            for(int i10 = l; i10 > 0; i10--)
            {
                ad1[(j5 - 1) + (i7 - 1) * k1 + j1] = ad1[(j5 - 1) + j1];
                j5++;
            }

            j5 = i8;
            for(int j10 = (j7 - i8) + 1; j10 > 0; j10--)
            {
                ad6[(i7 - 1) + (j5 - 1) * l3 + k3] = ad6[(j5 - 1) * l3 + k3];
                j5++;
            }

        }
        l4 = 1 + ai1[1 + j4] + ai1[2 + j4];
        Dgemm.dgemm("N", "N", l, j8, l4, 1.0, ad1, (i7 - 1) * k1 + j1, k1, ad6, (i7 - 1) + (i8 - 1) * l3 + k3, l3, 0.0, ad5, (i8 - 1) * j3 + i3, j3);
    }

    private static void dlasd4_adapter(int i, int j, double ad[], int k, double ad1[], int l, double ad2[], int i1, 
            double d, double ad3[], int j1, double ad4[], int k1, intW intw)
    {
        doubleW doublew = new doubleW(ad3[j1]);
        Dlasd4.dlasd4(i, j, ad, k, ad1, l, ad2, i1, d, doublew, ad4, k1, intw);
        ad3[j1] = doublew.val;
    }
}

package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgbtrf
{
    public static void dgbtrf(int i, int j, int k, int l, double ad[], int i1, int j1, int ai[], 
            int k1, intW intw)
    {
        int k7 = 0;
        int l7 = 0;
        double ad1[] = new double[65 * 64];
        double ad2[] = new double[65 * 64];
        k7 = l + k;
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
        if(j1 < k + k7 + 1)
            intw.val = -6;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DGBTRF", -intw.val);
            return;
        }
        if((i == 0) || (j == 0))
            return;
        l7 = Ilaenv.ilaenv(1, "DGBTRF", " ", i, j, k, l);
        l7 = Math.min(l7, 64);
        if((l7 <= 1) || (l7 > k))
        {
            Dgbtf2.dgbtf2(i, j, k, l, ad, i1, j1, ai, k1, intw);
        } else
        {
            int l4 = 1;
            for(int k8 = (l7 - 1) + 1; k8 > 0; k8--)
            {
                int l1 = 1;
                for(int k9 = (l4 - 1 - 1) + 1; k9 > 0; k9--)
                {
                    ad1[(l1 - 1) + (l4 - 1) * 65] = 0.0D;
                    l1++;
                }

                l4++;
            }

            l4 = 1;
            for(int l8 = (l7 - 1) + 1; l8 > 0; l8--)
            {
                int i2 = l4 + 1;
                for(int l9 = (l7 - (l4 + 1)) + 1; l9 > 0; l9--)
                {
                    ad2[(i2 - 1) + (l4 - 1) * 65] = 0.0D;
                    i2++;
                }

                l4++;
            }

            l4 = l + 2;
            for(int i9 = (Math.min(k7, j) - (l + 2)) + 1; i9 > 0; i9--)
            {
                int j2 = (k7 - l4) + 2;
                for(int i10 = (k - ((k7 - l4) + 2)) + 1; i10 > 0; i10--)
                {
                    ad[(j2 - 1) + (l4 - 1) * j1 + i1] = 0.0D;
                    j2++;
                }

                l4++;
            }

            int l6 = 1;
            l4 = 1;
            for(int j9 = ((Math.min(i, j) - 1) + l7) / l7; j9 > 0; j9--)
            {
                int k5 = Math.min(l7, (Math.min(i, j) - l4) + 1);
                int j3 = Math.min(k - k5, (i - l4 - k5) + 1);
                int k3 = Math.min(k5, (i - l4 - k) + 1);
                int l5 = l4;
                for(int j10 = ((l4 + k5) - 1 - l4) + 1; j10 > 0; j10--)
                {
                    if(l5 + k7 <= j)
                    {
                        int k2 = 1;
                        for(int i12 = (k - 1) + 1; i12 > 0; i12--)
                        {
                            ad[(k2 - 1) + ((l5 + k7) - 1) * j1 + i1] = 0.0D;
                            k2++;
                        }

                    }
                    int j7 = Math.min(k, i - l5);
                    int j6 = Idamax.idamax(j7 + 1, ad, ((k7 + 1) - 1) + (l5 - 1) * j1 + i1, 1);
                    ai[(l5 - 1) + k1] = (j6 + l5) - l4;
                    if(ad[((k7 + j6) - 1) + (l5 - 1) * j1 + i1] != 0.0D)
                    {
                        l6 = Math.max(l6, Math.min((l5 + l + j6) - 1, j));
                        if(j6 != 1)
                            if((j6 + l5) - 1 < l4 + k)
                            {
                                Dswap.dswap(k5, ad, ((k7 + 1 + l5) - l4 - 1) + (l4 - 1) * j1 + i1, j1 - 1, ad, ((k7 + j6 + l5) - l4 - 1) + (l4 - 1) * j1 + i1, j1 - 1);
                            } else
                            {
                                Dswap.dswap(l5 - l4, ad, ((k7 + 1 + l5) - l4 - 1) + (l4 - 1) * j1 + i1, j1 - 1, ad2, ((j6 + l5) - l4 - k - 1) + (1 - 1) * 65, 65);
                                Dswap.dswap((l4 + k5) - l5, ad, ((k7 + 1) - 1) + (l5 - 1) * j1 + i1, j1 - 1, ad, ((k7 + j6) - 1) + (l5 - 1) * j1 + i1, j1 - 1);
                            }
                        Dscal.dscal(j7, 1.0D / ad[((k7 + 1) - 1) + (l5 - 1) * j1 + i1], ad, ((k7 + 2) - 1) + (l5 - 1) * j1 + i1, 1);
                        int i6 = Math.min(l6, (l4 + k5) - 1);
                        if(i6 > l5)
                            Dger.dger(j7, i6 - l5, -1D, ad, ((k7 + 2) - 1) + (l5 - 1) * j1 + i1, 1, ad, (k7 - 1) + ((l5 + 1) - 1) * j1 + i1, j1 - 1, ad, ((k7 + 1) - 1) + ((l5 + 1) - 1) * j1 + i1, j1 - 1);
                    } else
                    if(intw.val == 0)
                        intw.val = l5;
                    int i8 = Math.min((l5 - l4) + 1, k3);
                    if(i8 > 0)
                        Dcopy.dcopy(i8, ad, ((((k7 + k + 1) - l5) + l4) - 1) + (l5 - 1) * j1 + i1, 1, ad2, (1 - 1) + (((l5 - l4) + 1) - 1) * 65, 1);
                    l5++;
                }

                if(l4 + k5 <= j)
                {
                    int i5 = Math.min((l6 - l4) + 1, k7) - k5;
                    int j5 = Math.max(0, (l6 - l4 - k7) + 1);
                    Dlaswp.dlaswp(i5, ad, ((k7 + 1) - k5 - 1) + ((l4 + k5) - 1) * j1 + i1, j1 - 1, 1, k5, ai, (l4 - 1) + k1, 1);
                    int l2 = l4;
                    for(int k10 = ((l4 + k5) - 1 - l4) + 1; k10 > 0; k10--)
                    {
                        ai[(l2 - 1) + k1] = (ai[(l2 - 1) + k1] + l4) - 1;
                        l2++;
                    }

                    int i7 = (l4 - 1) + k5 + i5;
                    l2 = 1;
                    for(int l10 = (j5 - 1) + 1; l10 > 0; l10--)
                    {
                        l5 = i7 + l2;
                        int l3 = (l4 + l2) - 1;
                        for(int j12 = ((l4 + k5) - 1 - ((l4 + l2) - 1)) + 1; j12 > 0; j12--)
                        {
                            int k4 = ai[(l3 - 1) + k1];
                            if(k4 != l3)
                            {
                                double d1 = ad[((k7 + 1 + l3) - l5 - 1) + (l5 - 1) * j1 + i1];
                                ad[((k7 + 1 + l3) - l5 - 1) + (l5 - 1) * j1 + i1] = ad[((k7 + 1 + k4) - l5 - 1) + (l5 - 1) * j1 + i1];
                                ad[((k7 + 1 + k4) - l5 - 1) + (l5 - 1) * j1 + i1] = d1;
                            }
                            l3++;
                        }

                        l2++;
                    }

                    if(i5 > 0)
                    {
                        Dtrsm.dtrsm("Left", "Lower", "No transpose", "Unit", k5, i5, 1.0D, ad, ((k7 + 1) - 1) + (l4 - 1) * j1 + i1, j1 - 1, ad, ((k7 + 1) - k5 - 1) + ((l4 + k5) - 1) * j1 + i1, j1 - 1);
                        if(j3 > 0)
                            Dgemm.dgemm("No transpose", "No transpose", j3, i5, k5, -1D, ad, ((k7 + 1 + k5) - 1) + (l4 - 1) * j1 + i1, j1 - 1, ad, ((k7 + 1) - k5 - 1) + ((l4 + k5) - 1) * j1 + i1, j1 - 1, 1.0D, ad, ((k7 + 1) - 1) + ((l4 + k5) - 1) * j1 + i1, j1 - 1);
                        if(k3 > 0)
                            Dgemm.dgemm("No transpose", "No transpose", k3, i5, k5, -1D, ad2, 0, 65, ad, ((k7 + 1) - k5 - 1) + ((l4 + k5) - 1) * j1 + i1, j1 - 1, 1.0D, ad, ((k7 + k + 1) - k5 - 1) + ((l4 + k5) - 1) * j1 + i1, j1 - 1);
                    }
                    if(j5 > 0)
                    {
                        l5 = 1;
                        for(int i11 = (j5 - 1) + 1; i11 > 0; i11--)
                        {
                            int i4 = l5;
                            for(int k12 = (k5 - l5) + 1; k12 > 0; k12--)
                            {
                                ad1[(i4 - 1) + (l5 - 1) * 65] = ad[(((i4 - l5) + 1) - 1) + ((l5 + l4 + k7) - 1 - 1) * j1 + i1];
                                i4++;
                            }

                            l5++;
                        }

                        Dtrsm.dtrsm("Left", "Lower", "No transpose", "Unit", k5, j5, 1.0D, ad, ((k7 + 1) - 1) + (l4 - 1) * j1 + i1, j1 - 1, ad1, 0, 65);
                        if(j3 > 0)
                            Dgemm.dgemm("No transpose", "No transpose", j3, j5, k5, -1D, ad, ((k7 + 1 + k5) - 1) + (l4 - 1) * j1 + i1, j1 - 1, ad1, 0, 65, 1.0D, ad, ((1 + k5) - 1) + ((l4 + k7) - 1) * j1 + i1, j1 - 1);
                        if(k3 > 0)
                            Dgemm.dgemm("No transpose", "No transpose", k3, j5, k5, -1D, ad2, 0, 65, ad1, 0, 65, 1.0D, ad, ((1 + k) - 1) + ((l4 + k7) - 1) * j1 + i1, j1 - 1);
                        l5 = 1;
                        for(int j11 = (j5 - 1) + 1; j11 > 0; j11--)
                        {
                            int j4 = l5;
                            for(int l12 = (k5 - l5) + 1; l12 > 0; l12--)
                            {
                                ad[(((j4 - l5) + 1) - 1) + ((l5 + l4 + k7) - 1 - 1) * j1 + i1] = ad1[(j4 - 1) + (l5 - 1) * 65];
                                j4++;
                            }

                            l5++;
                        }

                    }
                } else
                {
                    int i3 = l4;
                    for(int k11 = ((l4 + k5) - 1 - l4) + 1; k11 > 0; k11--)
                    {
                        ai[(i3 - 1) + k1] = (ai[(i3 - 1) + k1] + l4) - 1;
                        i3++;
                    }

                }
                l5 = (l4 + k5) - 1;
                for(int l11 = ((l4 - ((l4 + k5) - 1)) + -1) / -1; l11 > 0; l11--)
                {
                    int k6 = (ai[(l5 - 1) + k1] - l5) + 1;
                    if(k6 != 1)
                        if((k6 + l5) - 1 < l4 + k)
                            Dswap.dswap(l5 - l4, ad, ((k7 + 1 + l5) - l4 - 1) + (l4 - 1) * j1 + i1, j1 - 1, ad, ((k7 + k6 + l5) - l4 - 1) + (l4 - 1) * j1 + i1, j1 - 1);
                        else
                            Dswap.dswap(l5 - l4, ad, ((k7 + 1 + l5) - l4 - 1) + (l4 - 1) * j1 + i1, j1 - 1, ad2, ((k6 + l5) - l4 - k - 1) + (1 - 1) * 65, 65);
                    int j8 = Math.min(k3, (l5 - l4) + 1);
                    if(j8 > 0)
                        Dcopy.dcopy(j8, ad2, (1 - 1) + (((l5 - l4) + 1) - 1) * 65, 1, ad, ((((k7 + k + 1) - l5) + l4) - 1) + (l5 - 1) * j1 + i1, 1);
                    l5--;
                }

                l4 += l7;
            }

        }
    }
}

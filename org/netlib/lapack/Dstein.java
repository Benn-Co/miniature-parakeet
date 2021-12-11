package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dstein
{
    public static void dstein(int i, double ad[], int j, double ad1[], int k, int l, double ad2[], int i1, 
            int ai[], int j1, int ai1[], int k1, double ad3[], int l1, int i2, 
            double ad4[], int j2, int ai2[], int k2, int ai3[], int l2, intW intw)
    {
        int l3 = 0;
        int i4 = 0;
        intW intw1 = new intW(0);
        int i5 = 0;
        int j5 = 0;
        int k5 = 0;
        int l5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        double d = 0.0D;
        double d1 = 0.0D;
        double d6 = 0.0D;
        double d7 = 0.0D;
        doubleW doublew = new doubleW(0.0D);
        double d17 = 0.0D;
        int ai4[] = new int[4];
        intw.val = 0;
        i4 = 1;
        for(int k8 = (l - 1) + 1; k8 > 0; k8--)
        {
            ai3[(i4 - 1) + l2] = 0;
            i4++;
        }

        if(i < 0)
            intw.val = -1;
        else
        if((l < 0) || (l > i))
            intw.val = -4;
        else
        if(i2 < Math.max(1, i))
        {
            intw.val = -9;
        } else
        {
            int k6 = 2;
            for(int l8 = (l - 2) + 1; l8 > 0; l8--)
            {
                if(ai[(k6 - 1) + j1] < ai[(k6 - 1 - 1) + j1])
                {
                    intw.val = -6;
                    break;
                }
                if((ai[(k6 - 1) + j1] == ai[(k6 - 1 - 1) + j1]) && (ad2[(k6 - 1) + i1] < ad2[(k6 - 1 - 1) + i1]))
                {
                    intw.val = -5;
                    break;
                }
                k6++;
            }

        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DSTEIN", -intw.val);
            return;
        }
        if((i == 0) || (l == 0))
            return;
        if(i == 1)
        {
            ad3[(1 - 1) + (1 - 1) * i2 + l1] = 1.0D;
            return;
        }
        d1 = Dlamch.dlamch("Precision");
        i4 = 1;
        for(int i9 = (4 - 1) + 1; i9 > 0; i9--)
        {
            ai4[i4 - 1] = 1;
            i4++;
        }

        i5 = 0;
        j5 = i5 + i;
        k5 = j5 + i;
        l5 = k5 + i;
        i6 = l5 + i;
        i7 = 1;
        i8 = 1;
        for(int j9 = (ai[(l - 1) + j1] - 1) + 1; j9 > 0; j9--)
        {
            int i3;
            if(i8 == 1)
                i3 = 1;
            else
                i3 = ai1[(i8 - 1 - 1) + k1] + 1;
            int k3 = ai1[(i8 - 1) + k1];
            int j3 = (k3 - i3) + 1;
            if(j3 != 1)
            {
                l3 = i3;
                d6 = Math.abs(ad[(i3 - 1) + j]) + Math.abs(ad1[(i3 - 1) + k]);
                d6 = Math.max(d6, Math.abs(ad[(k3 - 1) + j]) + Math.abs(ad1[(k3 - 1 - 1) + k]));
                int j4 = i3 + 1;
                for(int k9 = (k3 - 1 - (i3 + 1)) + 1; k9 > 0; k9--)
                {
                    d6 = Math.max(d6, Math.abs(ad[(j4 - 1) + j]) + Math.abs(ad1[(j4 - 1 - 1) + k]) + Math.abs(ad1[(j4 - 1) + k]));
                    j4++;
                }

                d7 = 0.001D * d6;
                d = Math.sqrt(0.10000000000000001D / (double)j3);
            }
            int j7 = 0;
            int l6 = i7;
label0:
            for(int l9 = (l - i7) + 1; l9 > 0; l9--)
            {
                double d16;
label1:
                {
label2:
                    {
                        if(ai[(l6 - 1) + j1] != i8)
                        {
                            i7 = l6;
                            break label0;
                        }
                        j7++;
                        d16 = ad2[(l6 - 1) + i1];
                        if(j3 == 1)
                        {
                            ad4[((i5 + 1) - 1) + j2] = 1.0D;
                            break label1;
                        }
                        if(j7 > 1)
                        {
                            double d3 = Math.abs(d1 * d16);
                            double d9 = 10D * d3;
                            double d14 = d16 - d17;
                            if(d14 < d9)
                                d16 = d17 + d9;
                        }
                        int j6 = 0;
                        int j8 = 0;
                        Dlarnv.dlarnv(2, ai4, 0, j3, ad4, ((i5 + 1) - 1) + j2);
                        Dcopy.dcopy(j3, ad, (i3 - 1) + j, 1, ad4, ((l5 + 1) - 1) + j2, 1);
                        Dcopy.dcopy(j3 - 1, ad1, (i3 - 1) + k, 1, ad4, ((j5 + 2) - 1) + j2, 1);
                        Dcopy.dcopy(j3 - 1, ad1, (i3 - 1) + k, 1, ad4, ((k5 + 1) - 1) + j2, 1);
                        doublew.val = 0.0D;
                        Dlagtf.dlagtf(j3, ad4, ((l5 + 1) - 1) + j2, d16, ad4, ((j5 + 2) - 1) + j2, ad4, ((k5 + 1) - 1) + j2, doublew.val, ad4, ((i6 + 1) - 1) + j2, ai2, k2, intw1);
                        do
                        {
                            j6++;
                            if(j6 > 5)
                                break;
                            double d11 = ((double)j3 * d6 * Math.max(d1, Math.abs(ad4[((l5 + j3) - 1) + j2]))) / Dasum.dasum(j3, ad4, ((i5 + 1) - 1) + j2, 1);
                            Dscal.dscal(j3, d11, ad4, ((i5 + 1) - 1) + j2, 1);
                            Dlagts.dlagts(-1, j3, ad4, ((l5 + 1) - 1) + j2, ad4, ((j5 + 2) - 1) + j2, ad4, ((k5 + 1) - 1) + j2, ad4, ((i6 + 1) - 1) + j2, ai2, k2, ad4, ((i5 + 1) - 1) + j2, doublew, intw1);
                            if(j7 != 1)
                            {
                                if(Math.abs(d16 - d17) > d7)
                                    l3 = l6;
                                if(l3 != l6)
                                {
                                    int k4 = l3;
                                    for(int i10 = (l6 - 1 - l3) + 1; i10 > 0; i10--)
                                    {
                                        double d19 = -Ddot.ddot(j3, ad4, ((i5 + 1) - 1) + j2, 1, ad3, (i3 - 1) + (k4 - 1) * i2 + l1, 1);
                                        Daxpy.daxpy(j3, d19, ad3, (i3 - 1) + (k4 - 1) * i2 + l1, 1, ad4, ((i5 + 1) - 1) + j2, 1);
                                        k4++;
                                    }

                                }
                            }
                            int k7 = Idamax.idamax(j3, ad4, ((i5 + 1) - 1) + j2, 1);
                            double d5 = Math.abs(ad4[((i5 + k7) - 1) + j2]);
                            if(d5 >= d)
                            {
                                j8++;
                                if(j8 >= 2 + 1)
                                    break label2;
                            }
                        } while(true);
                        intw.val = intw.val + 1;
                        ai3[(intw.val - 1) + l2] = l6;
                    }
                    double d12 = 1.0D / Dnrm2.dnrm2(j3, ad4, ((i5 + 1) - 1) + j2, 1);
                    int l7 = Idamax.idamax(j3, ad4, ((i5 + 1) - 1) + j2, 1);
                    if(ad4[((i5 + l7) - 1) + j2] < 0.0D)
                        d12 = -d12;
                    Dscal.dscal(j3, d12, ad4, ((i5 + 1) - 1) + j2, 1);
                }
                int l4 = 1;
                for(int j10 = (i - 1) + 1; j10 > 0; j10--)
                {
                    ad3[(l4 - 1) + (l6 - 1) * i2 + l1] = 0.0D;
                    l4++;
                }

                l4 = 1;
                for(int k10 = (j3 - 1) + 1; k10 > 0; k10--)
                {
                    ad3[((i3 + l4) - 2) + (l6 - 1) * i2 + l1] = ad4[((i5 + l4) - 1) + j2];
                    l4++;
                }

                d17 = d16;
                l6++;
            }

            i8++;
        }

    }
}

package org.netlib.arpack;

import org.netlib.blas.Dcopy;
import org.netlib.blas.Drot;
import org.netlib.lapack.*;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlaqrb
{
    public static void dlaqrb(boolean flag, int i, int j, int k, double ad[], int l, int i1, double ad1[], 
            int j1, double ad2[], int k1, double ad3[], int l1, intW intw)
    {
        int i2 = 0;
        int j2 = 0;
        int k2 = 0;
        int l2 = 0;
        int j3 = 0;
        int l4 = 0;
        doubleW doublew = new doubleW(0.0D);
        doubleW doublew1 = new doubleW(0.0D);
        double d25 = 0.0D;
        doubleW doublew2 = new doubleW(0.0D);
        doubleW doublew3 = new doubleW(0.0D);
        double d41 = 0.0D;
        doubleW doublew4 = new doubleW(0.0D);
        double ad4[] = new double[3];
        double ad5[] = new double[1];
        intw.val = 0;
        if(i == 0)
            return;
        if(j == k)
        {
            ad1[(j - 1) + j1] = ad[(j - 1) + (j - 1) * i1 + l];
            ad2[(j - 1) + k1] = 0.0D;
            return;
        }
        j3 = 1;
        for(int j5 = (i - 1 - 1) + 1; j5 > 0; j5--)
        {
            ad3[(j3 - 1) + l1] = 0.0D;
            j3++;
        }

        ad3[(i - 1) + l1] = 1.0D;
        l4 = (k - j) + 1;
        doublew4.val = Dlamch.dlamch("safe minimum");
        doublew1.val = 1.0D / doublew4.val;
        Dlabad.dlabad(doublew4, doublew1);
        d41 = Dlamch.dlamch("precision");
        d25 = doublew4.val * ((double)l4 / d41);
        if(flag)
        {
            j2 = 1;
            k2 = i;
            i2 = 1;
            for(int k5 = (k2 - 2 - 1) + 1; k5 > 0; k5--)
            {
                ad[((j2 + i2 + 1) - 1) + (i2 - 1) * i1 + l] = 0.0D;
                i2++;
            }

        } else
        {
            i2 = 1;
            for(int l5 = (k - j - 1 - 1) + 1; l5 > 0; l5--)
            {
                ad[((j + i2 + 1) - 1) + ((j + i2) - 1 - 1) * i1 + l] = 0.0D;
                i2++;
            }

        }
        l2 = 30 * l4;
        i2 = k;
label0:
        do
        {
            int i3;
            int j4;
label1:
            {
                j4 = j;
                if(i2 < j)
                    break label0;
                i3 = 0;
                for(int i6 = (l2 - 0) + 1; i6 > 0; i6--)
                {
                    int i4 = i2;
                    for(int j6 = (((j4 + 1) - i2) + -1) / -1; j6 > 0; j6--)
                    {
                        double d39 = Math.abs(ad[(i4 - 1 - 1) + (i4 - 1 - 1) * i1 + l]) + Math.abs(ad[(i4 - 1) + (i4 - 1) * i1 + l]);
                        if(d39 == 0.0D)
                            d39 = Dlanhs.dlanhs("1", (i2 - j4) + 1, ad, (j4 - 1) + (j4 - 1) * i1 + l, i1, ad5, 0);
                        if(Math.abs(ad[(i4 - 1) + (i4 - 1 - 1) * i1 + l]) <= Math.max(d41 * d39, d25))
                            break;
                        i4--;
                    }

                    j4 = i4;
                    if(j4 > j)
                        ad[(j4 - 1) + (j4 - 1 - 1) * i1 + l] = 0.0D;
                    if(j4 >= i2 - 1)
                        break label1;
                    if(flag ^ true)
                    {
                        j2 = j4;
                        k2 = i2;
                    }
                    double d13;
                    double d17;
                    double d19;
                    if((i3 == 10) || (i3 == 20))
                    {
                        double d23 = Math.abs(ad[(i2 - 1) + (i2 - 1 - 1) * i1 + l]) + Math.abs(ad[(i2 - 1 - 1) + (i2 - 2 - 1) * i1 + l]);
                        d19 = 0.75D * d23;
                        d13 = d19;
                        d17 = -0.4375D * d23 * d23;
                    } else
                    {
                        d19 = ad[(i2 - 1) + (i2 - 1) * i1 + l];
                        d13 = ad[(i2 - 1 - 1) + (i2 - 1 - 1) * i1 + l];
                        d17 = ad[(i2 - 1) + (i2 - 1 - 1) * i1 + l] * ad[(i2 - 1 - 1) + (i2 - 1) * i1 + l];
                    }
                    int k4 = i2 - 2;
                    for(int k6 = ((j4 - (i2 - 2)) + -1) / -1; k6 > 0; k6--)
                    {
                        double d5 = ad[(k4 - 1) + (k4 - 1) * i1 + l];
                        double d11 = ad[((k4 + 1) - 1) + ((k4 + 1) - 1) * i1 + l];
                        double d9 = ad[((k4 + 1) - 1) + (k4 - 1) * i1 + l];
                        double d7 = ad[(k4 - 1) + ((k4 + 1) - 1) * i1 + l];
                        double d21 = d19 - d5;
                        double d15 = d13 - d5;
                        double d43 = (d15 * d21 - d17) / d9 + d7;
                        double d45 = d11 - d5 - d15 - d21;
                        double d48 = ad[((k4 + 2) - 1) + ((k4 + 1) - 1) * i1 + l];
                        double d24 = Math.abs(d43) + Math.abs(d45) + Math.abs(d48);
                        d43 /= d24;
                        d45 /= d24;
                        d48 /= d24;
                        ad4[1 - 1] = d43;
                        ad4[2 - 1] = d45;
                        ad4[3 - 1] = d48;
                        if(k4 == j4)
                            break;
                        double d1 = ad[(k4 - 1 - 1) + (k4 - 1 - 1) * i1 + l];
                        double d3 = ad[(k4 - 1) + (k4 - 1 - 1) * i1 + l];
                        double d40 = Math.abs(d43) * (Math.abs(d1) + Math.abs(d5) + Math.abs(d11));
                        if(Math.abs(d3) * (Math.abs(d45) + Math.abs(d48)) <= d41 * d40)
                            break;
                        k4--;
                    }

                    i4 = k4;
                    for(int l6 = (i2 - 1 - k4) + 1; l6 > 0; l6--)
                    {
                        int i5 = Math.min(3, (i2 - i4) + 1);
                        if(i4 > k4)
                            Dcopy.dcopy(i5, ad, (i4 - 1) + (i4 - 1 - 1) * i1 + l, 1, ad4, 0, 1);
                        dlarfg_adapter(i5, ad4, 1 - 1, ad4, 2 - 1, 1, doublew3);
                        if(i4 > k4)
                        {
                            ad[(i4 - 1) + (i4 - 1 - 1) * i1 + l] = ad4[1 - 1];
                            ad[((i4 + 1) - 1) + (i4 - 1 - 1) * i1 + l] = 0.0D;
                            if(i4 < i2 - 1)
                                ad[((i4 + 2) - 1) + (i4 - 1 - 1) * i1 + l] = 0.0D;
                        } else
                        if(k4 > j4)
                            ad[(i4 - 1) + (i4 - 1 - 1) * i1 + l] = -ad[(i4 - 1) + (i4 - 1 - 1) * i1 + l];
                        double d46 = ad4[2 - 1];
                        double d35 = doublew3.val * d46;
                        if(i5 == 3)
                        {
                            double d49 = ad4[3 - 1];
                            double d37 = doublew3.val * d49;
                            int k3 = i4;
                            for(int i7 = (k2 - i4) + 1; i7 > 0; i7--)
                            {
                                double d27 = ad[(i4 - 1) + (k3 - 1) * i1 + l] + d46 * ad[((i4 + 1) - 1) + (k3 - 1) * i1 + l] + d49 * ad[((i4 + 2) - 1) + (k3 - 1) * i1 + l];
                                ad[(i4 - 1) + (k3 - 1) * i1 + l] = ad[(i4 - 1) + (k3 - 1) * i1 + l] - d27 * doublew3.val;
                                ad[((i4 + 1) - 1) + (k3 - 1) * i1 + l] = ad[((i4 + 1) - 1) + (k3 - 1) * i1 + l] - d27 * d35;
                                ad[((i4 + 2) - 1) + (k3 - 1) * i1 + l] = ad[((i4 + 2) - 1) + (k3 - 1) * i1 + l] - d27 * d37;
                                k3++;
                            }

                            k3 = j2;
                            for(int j7 = (Math.min(i4 + 3, i2) - j2) + 1; j7 > 0; j7--)
                            {
                                double d28 = ad[(k3 - 1) + (i4 - 1) * i1 + l] + d46 * ad[(k3 - 1) + ((i4 + 1) - 1) * i1 + l] + d49 * ad[(k3 - 1) + ((i4 + 2) - 1) * i1 + l];
                                ad[(k3 - 1) + (i4 - 1) * i1 + l] = ad[(k3 - 1) + (i4 - 1) * i1 + l] - d28 * doublew3.val;
                                ad[(k3 - 1) + ((i4 + 1) - 1) * i1 + l] = ad[(k3 - 1) + ((i4 + 1) - 1) * i1 + l] - d28 * d35;
                                ad[(k3 - 1) + ((i4 + 2) - 1) * i1 + l] = ad[(k3 - 1) + ((i4 + 2) - 1) * i1 + l] - d28 * d37;
                                k3++;
                            }

                            double d29 = ad3[(i4 - 1) + l1] + d46 * ad3[((i4 + 1) - 1) + l1] + d49 * ad3[((i4 + 2) - 1) + l1];
                            ad3[(i4 - 1) + l1] = ad3[(i4 - 1) + l1] - d29 * doublew3.val;
                            ad3[((i4 + 1) - 1) + l1] = ad3[((i4 + 1) - 1) + l1] - d29 * d35;
                            ad3[((i4 + 2) - 1) + l1] = ad3[((i4 + 2) - 1) + l1] - d29 * d37;
                        } else
                        if(i5 == 2)
                        {
                            int l3 = i4;
                            for(int k7 = (k2 - i4) + 1; k7 > 0; k7--)
                            {
                                double d30 = ad[(i4 - 1) + (l3 - 1) * i1 + l] + d46 * ad[((i4 + 1) - 1) + (l3 - 1) * i1 + l];
                                ad[(i4 - 1) + (l3 - 1) * i1 + l] = ad[(i4 - 1) + (l3 - 1) * i1 + l] - d30 * doublew3.val;
                                ad[((i4 + 1) - 1) + (l3 - 1) * i1 + l] = ad[((i4 + 1) - 1) + (l3 - 1) * i1 + l] - d30 * d35;
                                l3++;
                            }

                            l3 = j2;
                            for(int l7 = (i2 - j2) + 1; l7 > 0; l7--)
                            {
                                double d31 = ad[(l3 - 1) + (i4 - 1) * i1 + l] + d46 * ad[(l3 - 1) + ((i4 + 1) - 1) * i1 + l];
                                ad[(l3 - 1) + (i4 - 1) * i1 + l] = ad[(l3 - 1) + (i4 - 1) * i1 + l] - d31 * doublew3.val;
                                ad[(l3 - 1) + ((i4 + 1) - 1) * i1 + l] = ad[(l3 - 1) + ((i4 + 1) - 1) * i1 + l] - d31 * d35;
                                l3++;
                            }

                            double d32 = ad3[(i4 - 1) + l1] + d46 * ad3[((i4 + 1) - 1) + l1];
                            ad3[(i4 - 1) + l1] = ad3[(i4 - 1) + l1] - d32 * doublew3.val;
                            ad3[((i4 + 1) - 1) + l1] = ad3[((i4 + 1) - 1) + l1] - d32 * d35;
                        }
                        i4++;
                    }

                    i3++;
                }

                intw.val = i2;
                return;
            }
            if(j4 == i2)
            {
                ad1[(i2 - 1) + j1] = ad[(i2 - 1) + (i2 - 1) * i1 + l];
                ad2[(i2 - 1) + k1] = 0.0D;
            } else
            if(j4 == i2 - 1)
            {
                dlanv2_adapter(ad, (i2 - 1 - 1) + (i2 - 1 - 1) * i1 + l, ad, (i2 - 1 - 1) + (i2 - 1) * i1 + l, ad, (i2 - 1) + (i2 - 1 - 1) * i1 + l, ad, (i2 - 1) + (i2 - 1) * i1 + l, ad1, (i2 - 1 - 1) + j1, ad2, (i2 - 1 - 1) + k1, ad1, (i2 - 1) + j1, ad2, (i2 - 1) + k1, doublew, doublew2);
                if(flag)
                {
                    if(k2 > i2)
                        Drot.drot(k2 - i2, ad, (i2 - 1 - 1) + ((i2 + 1) - 1) * i1 + l, i1, ad, (i2 - 1) + ((i2 + 1) - 1) * i1 + l, i1, doublew.val, doublew2.val);
                    Drot.drot(i2 - j2 - 1, ad, (j2 - 1) + (i2 - 1 - 1) * i1 + l, 1, ad, (j2 - 1) + (i2 - 1) * i1 + l, 1, doublew.val, doublew2.val);
                    double d33 = doublew.val * ad3[(i2 - 1 - 1) + l1] + doublew2.val * ad3[(i2 - 1) + l1];
                    ad3[(i2 - 1) + l1] = doublew.val * ad3[(i2 - 1) + l1] - doublew2.val * ad3[(i2 - 1 - 1) + l1];
                    ad3[(i2 - 1 - 1) + l1] = d33;
                }
            }
            l2 -= i3;
            i2 = j4 - 1;
        } while(true);
    }

    private static void dlarfg_adapter(int i, double ad[], int j, double ad1[], int k, int l, doubleW doublew)
    {
        doubleW doublew1 = new doubleW(ad[j]);
        Dlarfg.dlarfg(i, doublew1, ad1, k, l, doublew);
        ad[j] = doublew1.val;
    }

    private static void dlanv2_adapter(double ad[], int i, double ad1[], int j, double ad2[], int k, double ad3[], int l, 
            double ad4[], int i1, double ad5[], int j1, double ad6[], int k1, double ad7[], 
            int l1, doubleW doublew, doubleW doublew1)
    {
        doubleW doublew2 = new doubleW(ad[i]);
        doubleW doublew3 = new doubleW(ad1[j]);
        doubleW doublew4 = new doubleW(ad2[k]);
        doubleW doublew5 = new doubleW(ad3[l]);
        doubleW doublew6 = new doubleW(ad4[i1]);
        doubleW doublew7 = new doubleW(ad5[j1]);
        doubleW doublew8 = new doubleW(ad6[k1]);
        doubleW doublew9 = new doubleW(ad7[l1]);
        Dlanv2.dlanv2(doublew2, doublew3, doublew4, doublew5, doublew6, doublew7, doublew8, doublew9, doublew, doublew1);
        ad[i] = doublew2.val;
        ad1[j] = doublew3.val;
        ad2[k] = doublew4.val;
        ad3[l] = doublew5.val;
        ad4[i1] = doublew6.val;
        ad5[j1] = doublew7.val;
        ad6[k1] = doublew8.val;
        ad7[l1] = doublew9.val;
    }
}

package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.*;

public final class Dsterf
{
    public static void dsterf(int i, double ad[], int j, double ad1[], int k, intW intw)
    {
label0:
        {
            int l1 = 0;
            int j2 = 0;
            int i4 = 0;
            double d11 = 0.0D;
            double d12 = 0.0D;
            doubleW doublew = new doubleW(0.0D);
            doubleW doublew1 = new doubleW(0.0D);
            double d38 = 0.0D;
            double d39 = 0.0D;
            double d43 = 0.0D;
            double d44 = 0.0D;
            intw.val = 0;
            if(i < 0)
            {
                intw.val = -1;
                Xerbla.xerbla("DSTERF", -intw.val);
                return;
            }
            if(i <= 1)
                return;
            d11 = Dlamch.dlamch("E");
            d12 = Math.pow(d11, 2);
            d39 = Dlamch.dlamch("S");
            d38 = 1.0D / d39;
            d43 = Math.sqrt(d38) / 3D;
            d44 = Math.sqrt(d39) / d12;
            i4 = i * 30;
            l1 = 0;
            j2 = 1;
label1:
            do
            {
                int j3;
label2:
                {
                    if(j2 > i)
                        break label1;
                    if(j2 > 1)
                        ad1[(j2 - 1 - 1) + k] = 0.0D;
                    j3 = j2;
                    for(int j4 = (i - 1 - j2) + 1; j4 > 0; j4--)
                    {
                        if(Math.abs(ad1[(j3 - 1) + k]) <= Math.sqrt(Math.abs(ad[(j3 - 1) + j])) * Math.sqrt(Math.abs(ad[((j3 + 1) - 1) + j])) * d11)
                        {
                            ad1[(j3 - 1) + k] = 0.0D;
                            break label2;
                        }
                        j3++;
                    }

                    j3 = i;
                }
                int i2 = j2;
                int i3 = i2;
                int k2 = j3;
                int l2 = k2;
                j2 = j3 + 1;
                if(k2 == i2)
                    continue;
                double d4 = Dlanst.dlanst("I", (k2 - i2) + 1, ad, (i2 - 1) + j, ad1, (i2 - 1) + k);
                byte byte0 = 0;
                if(d4 > d43)
                {
                    byte0 = 1;
                    Dlascl.dlascl("G", 0, 0, d4, d43, (k2 - i2) + 1, 1, ad, (i2 - 1) + j, i, intw);
                    Dlascl.dlascl("G", 0, 0, d4, d43, k2 - i2, 1, ad1, (i2 - 1) + k, i, intw);
                } else
                if(d4 < d44)
                {
                    byte0 = 2;
                    Dlascl.dlascl("G", 0, 0, d4, d44, (k2 - i2) + 1, 1, ad, (i2 - 1) + j, i, intw);
                    Dlascl.dlascl("G", 0, 0, d4, d44, k2 - i2, 1, ad1, (i2 - 1) + k, i, intw);
                }
                int l = i2;
                for(int k4 = (k2 - 1 - i2) + 1; k4 > 0; k4--)
                {
                    ad1[(l - 1) + k] = Math.pow(ad1[(l - 1) + k], 2);
                    l++;
                }

                if(Math.abs(ad[(k2 - 1) + j]) < Math.abs(ad[(i2 - 1) + j]))
                {
                    k2 = i3;
                    i2 = l2;
                }
                if(k2 >= i2)
label3:
                    do
                    {
                        double d23;
                        do
                        {
                            int k3;
label4:
                            {
                                if(i2 != k2)
                                {
                                    k3 = i2;
                                    for(int l4 = (k2 - 1 - i2) + 1; l4 > 0; l4--)
                                    {
                                        if(Math.abs(ad1[(k3 - 1) + k]) <= d12 * Math.abs(ad[(k3 - 1) + j] * ad[((k3 + 1) - 1) + j]))
                                            break label4;
                                        k3++;
                                    }

                                }
                                k3 = k2;
                            }
                            if(k3 < k2)
                                ad1[(k3 - 1) + k] = 0.0D;
                            d23 = ad[(i2 - 1) + j];
                            if(k3 == i2)
                                break;
                            if(k3 == i2 + 1)
                            {
                                double d31 = Math.sqrt(ad1[(i2 - 1) + k]);
                                Dlae2.dlae2(ad[(i2 - 1) + j], d31, ad[((i2 + 1) - 1) + j], doublew, doublew1);
                                ad[(i2 - 1) + j] = doublew.val;
                                ad[((i2 + 1) - 1) + j] = doublew1.val;
                                ad1[(i2 - 1) + k] = 0.0D;
                                i2 += 2;
                                if(i2 > k2)
                                    break label3;
                            } else
                            {
                                if(l1 == i4)
                                    break label3;
                                l1++;
                                double d32 = Math.sqrt(ad1[(i2 - 1) + k]);
                                double d41 = (ad[((i2 + 1) - 1) + j] - d23) / (2D * d32);
                                double d26 = Dlapy2.dlapy2(d41, 1.0D);
                                d41 = d23 - d32 / (d41 + Util.dsign(d26, d41));
                                double d9 = 1.0D;
                                double d36 = 0.0D;
                                double d14 = ad[(k3 - 1) + j] - d41;
                                d23 = d14 * d14;
                                int i1 = k3 - 1;
                                for(int i5 = ((i2 - (k3 - 1)) + -1) / -1; i5 > 0; i5--)
                                {
                                    double d6 = ad1[(i1 - 1) + k];
                                    double d27 = d23 + d6;
                                    if(i1 != k3 - 1)
                                        ad1[((i1 + 1) - 1) + k] = d36 * d27;
                                    double d17 = d9;
                                    d9 = d23 / d27;
                                    d36 = d6 / d27;
                                    double d20 = d14;
                                    double d1 = ad[(i1 - 1) + j];
                                    d14 = d9 * (d1 - d41) - d36 * d20;
                                    ad[((i1 + 1) - 1) + j] = d20 + (d1 - d14);
                                    if(d9 != 0.0D)
                                        d23 = (d14 * d14) / d9;
                                    else
                                        d23 = d17 * d6;
                                    i1--;
                                }

                                ad1[(i2 - 1) + k] = d36 * d23;
                                ad[(i2 - 1) + j] = d41 + d14;
                            }
                        } while(true);
                        ad[(i2 - 1) + j] = d23;
                        i2++;
                    } while(i2 <= k2);
                else
label5:
                    do
                    {
                        double d24;
                        do
                        {
                            int l3;
label6:
                            {
                                l3 = i2;
                                for(int j5 = (((k2 + 1) - i2) + -1) / -1; j5 > 0; j5--)
                                {
                                    if(Math.abs(ad1[(l3 - 1 - 1) + k]) <= d12 * Math.abs(ad[(l3 - 1) + j] * ad[(l3 - 1 - 1) + j]))
                                        break label6;
                                    l3--;
                                }

                                l3 = k2;
                            }
                            if(l3 > k2)
                                ad1[(l3 - 1 - 1) + k] = 0.0D;
                            d24 = ad[(i2 - 1) + j];
                            if(l3 == i2)
                                break;
                            if(l3 == i2 - 1)
                            {
                                double d33 = Math.sqrt(ad1[(i2 - 1 - 1) + k]);
                                Dlae2.dlae2(ad[(i2 - 1) + j], d33, ad[(i2 - 1 - 1) + j], doublew, doublew1);
                                ad[(i2 - 1) + j] = doublew.val;
                                ad[(i2 - 1 - 1) + j] = doublew1.val;
                                ad1[(i2 - 1 - 1) + k] = 0.0D;
                                i2 -= 2;
                                if(i2 < k2)
                                    break label5;
                            } else
                            {
                                if(l1 == i4)
                                    break label5;
                                l1++;
                                double d34 = Math.sqrt(ad1[(i2 - 1 - 1) + k]);
                                double d42 = (ad[(i2 - 1 - 1) + j] - d24) / (2D * d34);
                                double d28 = Dlapy2.dlapy2(d42, 1.0D);
                                d42 = d24 - d34 / (d42 + Util.dsign(d28, d42));
                                double d10 = 1.0D;
                                double d37 = 0.0D;
                                double d15 = ad[(l3 - 1) + j] - d42;
                                d24 = d15 * d15;
                                int j1 = l3;
                                for(int k5 = (i2 - 1 - l3) + 1; k5 > 0; k5--)
                                {
                                    double d7 = ad1[(j1 - 1) + k];
                                    double d29 = d24 + d7;
                                    if(j1 != l3)
                                        ad1[(j1 - 1 - 1) + k] = d37 * d29;
                                    double d18 = d10;
                                    d10 = d24 / d29;
                                    d37 = d7 / d29;
                                    double d21 = d15;
                                    double d2 = ad[((j1 + 1) - 1) + j];
                                    d15 = d10 * (d2 - d42) - d37 * d21;
                                    ad[(j1 - 1) + j] = d21 + (d2 - d15);
                                    if(d10 != 0.0D)
                                        d24 = (d15 * d15) / d10;
                                    else
                                        d24 = d18 * d7;
                                    j1++;
                                }

                                ad1[(i2 - 2) + k] = d37 * d24;
                                ad[(i2 - 1) + j] = d42 + d15;
                            }
                        } while(true);
                        ad[(i2 - 1) + j] = d24;
                        i2--;
                    } while(i2 >= k2);
                if(byte0 == 1)
                    Dlascl.dlascl("G", 0, 0, d43, d4, (l2 - i3) + 1, 1, ad, (i3 - 1) + j, i, intw);
                if(byte0 == 2)
                    Dlascl.dlascl("G", 0, 0, d44, d4, (l2 - i3) + 1, 1, ad, (i3 - 1) + j, i, intw);
                if(l1 >= i4)
                {
                    int k1 = 1;
                    for(int l5 = i - 1; l5 > 0; l5--)
                    {
                        if(ad1[(k1 - 1) + k] != 0.0D)
                            intw.val = intw.val + 1;
                        k1++;
                    }

                    break label0;
                }
            } while(true);
            Dlasrt.dlasrt("I", i, ad, j, intw);
        }
    }
}

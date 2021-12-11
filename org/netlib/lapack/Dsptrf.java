package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dsptrf
{
    public static void dsptrf(String s, int i, double ad[], int j, int ai[], int k, intW intw)
    {
        boolean flag = false;
        int j1 = 0;
        int l6 = 0;
        double d3 = 0.0D;
        intw.val = 0;
        flag = Lsame.lsame(s, "U");
        if(flag ^ true && Lsame.lsame(s, "L") ^ true)
            intw.val = -1;
        else
        if(i < 0)
            intw.val = -2;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DSPTRF", -intw.val);
            return;
        }
        d3 = (1.0D + Math.sqrt(17D)) / 8D;
        if(flag)
        {
            int j4 = i;
            int l4 = ((i - 1) * i) / 2 + 1;
            do
            {
                int l5 = l4;
                if(j4 < 1)
                    break;
                byte byte0 = 1;
                double d1 = Math.abs(ad[((l4 + j4) - 1 - 1) + j]);
                double d5;
                if(j4 > 1)
                {
                    j1 = Idamax.idamax(j4 - 1, ad, (l4 - 1) + j, 1);
                    d5 = Math.abs(ad[((l4 + j1) - 1 - 1) + j]);
                } else
                {
                    d5 = 0.0D;
                }
                int j6;
                if(Math.max(d1, d5) == 0.0D)
                {
                    if(intw.val == 0)
                        intw.val = j4;
                    j6 = j4;
                } else
                {
                    if(d1 >= d3 * d5)
                    {
                        j6 = j4;
                    } else
                    {
                        double d21 = 0.0D;
                        int i7 = (j1 * (j1 + 1)) / 2 + j1;
                        int k1 = j1 + 1;
                        for(int j8 = (j4 - (j1 + 1)) + 1; j8 > 0; j8--)
                        {
                            if(Math.abs(ad[(i7 - 1) + j]) > d21)
                            {
                                d21 = Math.abs(ad[(i7 - 1) + j]);
                            }
                            i7 += k1;
                            k1++;
                        }

                        l6 = ((j1 - 1) * j1) / 2 + 1;
                        if(j1 > 1)
                        {
                            int k3 = Idamax.idamax(j1 - 1, ad, (l6 - 1) + j, 1);
                            d21 = Math.max(d21, Math.abs(ad[((l6 + k3) - 1 - 1) + j]));
                        }
                        if(d1 >= d3 * d5 * (d5 / d21))
                            j6 = j4;
                        else
                        if(Math.abs(ad[((l6 + j1) - 1 - 1) + j]) >= d3 * d21)
                        {
                            j6 = j1;
                        } else
                        {
                            j6 = j1;
                            byte0 = 2;
                        }
                    }
                    int j5 = (j4 - byte0) + 1;
                    if(byte0 == 2)
                        l5 = (l5 - j4) + 1;
                    if(j6 != j5)
                    {
                        Dswap.dswap(j6 - 1, ad, (l5 - 1) + j, 1, ad, (l6 - 1) + j, 1);
                        int j7 = (l6 + j6) - 1;
                        int l1 = j6 + 1;
                        for(int k8 = (j5 - 1 - (j6 + 1)) + 1; k8 > 0; k8--)
                        {
                            j7 = (j7 + l1) - 1;
                            double d24 = ad[((l5 + l1) - 1 - 1) + j];
                            ad[((l5 + l1) - 1 - 1) + j] = ad[(j7 - 1) + j];
                            ad[(j7 - 1) + j] = d24;
                            l1++;
                        }

                        double d25 = ad[((l5 + j5) - 1 - 1) + j];
                        ad[((l5 + j5) - 1 - 1) + j] = ad[((l6 + j6) - 1 - 1) + j];
                        ad[((l6 + j6) - 1 - 1) + j] = d25;
                        if(byte0 == 2)
                        {
                            double d26 = ad[((l4 + j4) - 2 - 1) + j];
                            ad[((l4 + j4) - 2 - 1) + j] = ad[((l4 + j6) - 1 - 1) + j];
                            ad[((l4 + j6) - 1 - 1) + j] = d26;
                        }
                    }
                    if(byte0 == 1)
                    {
                        double d18 = 1.0D / ad[((l4 + j4) - 1 - 1) + j];
                        Dspr.dspr(s, j4 - 1, -d18, ad, (l4 - 1) + j, 1, ad, j);
                        Dscal.dscal(j4 - 1, d18, ad, (l4 - 1) + j, 1);
                    } else
                    if(j4 > 2)
                    {
                        double d11 = ad[(((j4 - 1) + ((j4 - 1) * j4) / 2) - 1) + j];
                        double d15 = ad[(((j4 - 1) + ((j4 - 2) * (j4 - 1)) / 2) - 1) + j] / d11;
                        double d8 = ad[((j4 + ((j4 - 1) * j4) / 2) - 1) + j] / d11;
                        double d27 = 1.0D / (d8 * d15 - 1.0D);
                        d11 = d27 / d11;
                        int i2 = j4 - 2;
                        for(int l8 = ((1 - (j4 - 2)) + -1) / -1; l8 > 0; l8--)
                        {
                            double d36 = d11 * (d8 * ad[((i2 + ((j4 - 2) * (j4 - 1)) / 2) - 1) + j] - ad[((i2 + ((j4 - 1) * j4) / 2) - 1) + j]);
                            double d33 = d11 * (d15 * ad[((i2 + ((j4 - 1) * j4) / 2) - 1) + j] - ad[((i2 + ((j4 - 2) * (j4 - 1)) / 2) - 1) + j]);
                            int l = i2;
                            for(int l9 = ((1 - i2) + -1) / -1; l9 > 0; l9--)
                            {
                                ad[((l + ((i2 - 1) * i2) / 2) - 1) + j] = ad[((l + ((i2 - 1) * i2) / 2) - 1) + j] - ad[((l + ((j4 - 1) * j4) / 2) - 1) + j] * d33 - ad[((l + ((j4 - 2) * (j4 - 1)) / 2) - 1) + j] * d36;
                                l--;
                            }

                            ad[((i2 + ((j4 - 1) * j4) / 2) - 1) + j] = d33;
                            ad[((i2 + ((j4 - 2) * (j4 - 1)) / 2) - 1) + j] = d36;
                            i2--;
                        }

                    }
                }
                if(byte0 == 1)
                {
                    ai[(j4 - 1) + k] = j6;
                } else
                {
                    ai[(j4 - 1) + k] = -j6;
                    ai[(j4 - 1 - 1) + k] = -j6;
                }
                j4 -= byte0;
                l4 = l5 - j4;
            } while(true);
        } else
        {
            int k4 = 1;
            int i5 = 1;
            int i8 = (i * (i + 1)) / 2;
            do
            {
                int i6 = i5;
                if(k4 > i)
                    break;
                byte byte1 = 1;
                double d2 = Math.abs(ad[(i5 - 1) + j]);
                double d6;
                if(k4 < i)
                {
                    j1 = k4 + Idamax.idamax(i - k4, ad, ((i5 + 1) - 1) + j, 1);
                    d6 = Math.abs(ad[((i5 + j1) - k4 - 1) + j]);
                } else
                {
                    d6 = 0.0D;
                }
                int k6;
                if(Math.max(d2, d6) == 0.0D)
                {
                    if(intw.val == 0)
                        intw.val = k4;
                    k6 = k4;
                } else
                {
                    if(d2 >= d3 * d6)
                    {
                        k6 = k4;
                    } else
                    {
                        double d22 = 0.0D;
                        int k7 = (i5 + j1) - k4;
                        int j2 = k4;
                        for(int i9 = (j1 - 1 - k4) + 1; i9 > 0; i9--)
                        {
                            if(Math.abs(ad[(k7 - 1) + j]) > d22)
                            {
                                d22 = Math.abs(ad[(k7 - 1) + j]);
                            }
                            k7 = (k7 + i) - j2;
                            j2++;
                        }

                        l6 = (i8 - (((i - j1) + 1) * ((i - j1) + 2)) / 2) + 1;
                        if(j1 < i)
                        {
                            int i4 = j1 + Idamax.idamax(i - j1, ad, ((l6 + 1) - 1) + j, 1);
                            d22 = Math.max(d22, Math.abs(ad[((l6 + i4) - j1 - 1) + j]));
                        }
                        if(d2 >= d3 * d6 * (d6 / d22))
                            k6 = k4;
                        else
                        if(Math.abs(ad[(l6 - 1) + j]) >= d3 * d22)
                        {
                            k6 = j1;
                        } else
                        {
                            k6 = j1;
                            byte1 = 2;
                        }
                    }
                    int k5 = (k4 + byte1) - 1;
                    if(byte1 == 2)
                        i6 = ((i6 + i) - k4) + 1;
                    if(k6 != k5)
                    {
                        if(k6 < i)
                            Dswap.dswap(i - k6, ad, ((((i6 + k6) - k5) + 1) - 1) + j, 1, ad, ((l6 + 1) - 1) + j, 1);
                        int l7 = (i6 + k6) - k5;
                        int k2 = k5 + 1;
                        for(int j9 = (k6 - 1 - (k5 + 1)) + 1; j9 > 0; j9--)
                        {
                            l7 = ((l7 + i) - k2) + 1;
                            double d28 = ad[((i6 + k2) - k5 - 1) + j];
                            ad[((i6 + k2) - k5 - 1) + j] = ad[(l7 - 1) + j];
                            ad[(l7 - 1) + j] = d28;
                            k2++;
                        }

                        double d29 = ad[(i6 - 1) + j];
                        ad[(i6 - 1) + j] = ad[(l6 - 1) + j];
                        ad[(l6 - 1) + j] = d29;
                        if(byte1 == 2)
                        {
                            double d30 = ad[((i5 + 1) - 1) + j];
                            ad[((i5 + 1) - 1) + j] = ad[((i5 + k6) - k4 - 1) + j];
                            ad[((i5 + k6) - k4 - 1) + j] = d30;
                        }
                    }
                    if(byte1 == 1)
                    {
                        if(k4 < i)
                        {
                            double d19 = 1.0D / ad[(i5 - 1) + j];
                            Dspr.dspr(s, i - k4, -d19, ad, ((i5 + 1) - 1) + j, 1, ad, ((((i5 + i) - k4) + 1) - 1) + j);
                            Dscal.dscal(i - k4, d19, ad, ((i5 + 1) - 1) + j, 1);
                        }
                    } else
                    if(k4 < i - 1)
                    {
                        double d13 = ad[((k4 + 1 + ((k4 - 1) * (2 * i - k4)) / 2) - 1) + j];
                        double d9 = ad[((k4 + 1 + (k4 * (2 * i - k4 - 1)) / 2) - 1) + j] / d13;
                        double d16 = ad[((k4 + ((k4 - 1) * (2 * i - k4)) / 2) - 1) + j] / d13;
                        double d31 = 1.0D / (d9 * d16 - 1.0D);
                        d13 = d31 / d13;
                        int l2 = k4 + 2;
                        for(int k9 = (i - (k4 + 2)) + 1; k9 > 0; k9--)
                        {
                            double d34 = d13 * (d9 * ad[((l2 + ((k4 - 1) * (2 * i - k4)) / 2) - 1) + j] - ad[((l2 + (k4 * (2 * i - k4 - 1)) / 2) - 1) + j]);
                            double d38 = d13 * (d16 * ad[((l2 + (k4 * (2 * i - k4 - 1)) / 2) - 1) + j] - ad[((l2 + ((k4 - 1) * (2 * i - k4)) / 2) - 1) + j]);
                            int i1 = l2;
                            for(int i10 = (i - l2) + 1; i10 > 0; i10--)
                            {
                                ad[((i1 + ((l2 - 1) * (2 * i - l2)) / 2) - 1) + j] = ad[((i1 + ((l2 - 1) * (2 * i - l2)) / 2) - 1) + j] - ad[((i1 + ((k4 - 1) * (2 * i - k4)) / 2) - 1) + j] * d34 - ad[((i1 + (k4 * (2 * i - k4 - 1)) / 2) - 1) + j] * d38;
                                i1++;
                            }

                            ad[((l2 + ((k4 - 1) * (2 * i - k4)) / 2) - 1) + j] = d34;
                            ad[((l2 + (k4 * (2 * i - k4 - 1)) / 2) - 1) + j] = d38;
                            l2++;
                        }

                    }
                }
                if(byte1 == 1)
                {
                    ai[(k4 - 1) + k] = k6;
                } else
                {
                    ai[(k4 - 1) + k] = -k6;
                    ai[((k4 + 1) - 1) + k] = -k6;
                }
                k4 += byte1;
                i5 = ((i6 + i) - k4) + 2;
            } while(true);
        }
    }
}

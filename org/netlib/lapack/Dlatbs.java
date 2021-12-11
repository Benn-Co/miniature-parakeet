package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlatbs
{
    public static void dlatbs(String s, String s1, String s2, String s3, int i, int j, double ad[], int k, 
            int l, double ad1[], int i1, doubleW doublew, double ad2[], int j1, intW intw)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        int i5;
        byte byte0;
        int j5;
        int k7;
        double d;
        double d1;
        double d9;
        double d18;
        double d20;
        double d30;
label0:
        {
            flag = false;
            flag1 = false;
            flag2 = false;
            int i3 = 0;
            int j3 = 0;
            i5 = 0;
            byte0 = 0;
            j5 = 0;
            k7 = 0;
            d = 0.0D;
            d1 = 0.0D;
            d9 = 0.0D;
            d18 = 0.0D;
            double d19 = 0.0D;
            d20 = 0.0D;
            double d23 = 0.0D;
            d30 = 0.0D;
            intw.val = 0;
            flag2 = Lsame.lsame(s, "U");
            flag = Lsame.lsame(s1, "N");
            flag1 = Lsame.lsame(s2, "N");
            if(flag2 ^ true && Lsame.lsame(s, "L") ^ true)
                intw.val = -1;
            else
            if((flag ^ true && Lsame.lsame(s1, "T") ^ true) && Lsame.lsame(s1, "C") ^ true)
                intw.val = -2;
            else
            if(flag1 ^ true && Lsame.lsame(s2, "U") ^ true)
                intw.val = -3;
            else
            if(Lsame.lsame(s3, "Y") ^ true && Lsame.lsame(s3, "N") ^ true)
                intw.val = -4;
            else
            if(i < 0)
                intw.val = -5;
            else
            if(j < 0)
                intw.val = -6;
            else
            if(l < j + 1)
                intw.val = -8;
            if(intw.val != 0)
            {
                Xerbla.xerbla("DLATBS", -intw.val);
                return;
            }
            if(i == 0)
                return;
            d9 = Dlamch.dlamch("Safe minimum") / Dlamch.dlamch("Precision");
            d = 1.0D / d9;
            doublew.val = 1.0D;
            if(Lsame.lsame(s3, "N"))
                if(flag2)
                {
                    j3 = 1;
                    for(int l7 = (i - 1) + 1; l7 > 0; l7--)
                    {
                        int k5 = Math.min(j, j3 - 1);
                        ad2[(j3 - 1) + j1] = Dasum.dasum(k5, ad, ((j + 1) - k5 - 1) + (j3 - 1) * l + k, 1);
                        j3++;
                    }

                } else
                {
                    j3 = 1;
                    for(int i8 = (i - 1) + 1; i8 > 0; i8--)
                    {
                        int l5 = Math.min(j, i - j3);
                        if(l5 > 0)
                            ad2[(j3 - 1) + j1] = Dasum.dasum(l5, ad, (2 - 1) + (j3 - 1) * l + k, 1);
                        else
                            ad2[(j3 - 1) + j1] = 0.0D;
                        j3++;
                    }

                }
            i3 = Idamax.idamax(i, ad2, j1, 1);
            d19 = ad2[(i3 - 1) + j1];
            if(d19 <= d)
            {
                d20 = 1.0D;
            } else
            {
                d20 = 1.0D / (d9 * d19);
                Dscal.dscal(i, d20, ad2, j1, 1);
            }
            j3 = Idamax.idamax(i, ad1, i1, 1);
            d30 = Math.abs(ad1[(j3 - 1) + i1]);
            d23 = d30;
            if(flag)
            {
                if(flag2)
                {
                    i5 = i;
                    j5 = 1;
                    byte0 = -1;
                    k7 = j + 1;
                } else
                {
                    i5 = 1;
                    j5 = i;
                    byte0 = 1;
                    k7 = 1;
                }
                if(d20 != 1.0D)
                {
                    d1 = 0.0D;
                    break label0;
                }
                if(flag1)
                {
                    d1 = 1.0D / Math.max(d23, d9);
                    d23 = d1;
                    int k3 = i5;
                    for(int j8 = ((j5 - i5) + byte0) / byte0; j8 > 0; j8--)
                    {
                        if(d1 <= d9)
                            break label0;
                        double d13 = Math.abs(ad[(k7 - 1) + (k3 - 1) * l + k]);
                        d23 = Math.min(d23, Math.min(1.0D, d13) * d1);
                        if(d13 + ad2[(k3 - 1) + j1] >= d9)
                            d1 *= d13 / (d13 + ad2[(k3 - 1) + j1]);
                        else
                            d1 = 0.0D;
                        k3 += byte0;
                    }

                    d1 = d23;
                } else
                {
                    d1 = Math.min(1.0D, 1.0D / Math.max(d23, d9));
                    int l3 = i5;
                    for(int k8 = ((j5 - i5) + byte0) / byte0; k8 > 0; k8--)
                    {
                        if(d1 <= d9)
                            break;
                        d1 *= 1.0D / (1.0D + ad2[(l3 - 1) + j1]);
                        l3 += byte0;
                    }

                }
                break label0;
            }
            if(flag2)
            {
                i5 = 1;
                j5 = i;
                byte0 = 1;
                k7 = j + 1;
            } else
            {
                i5 = i;
                j5 = 1;
                byte0 = -1;
                k7 = 1;
            }
            if(d20 != 1.0D)
            {
                d1 = 0.0D;
                break label0;
            }
            if(flag1)
            {
                d1 = 1.0D / Math.max(d23, d9);
                d23 = d1;
                int i4 = i5;
                for(int l8 = ((j5 - i5) + byte0) / byte0; l8 > 0; l8--)
                {
                    if(d1 <= d9)
                        break label0;
                    double d25 = 1.0D + ad2[(i4 - 1) + j1];
                    d1 = Math.min(d1, d23 / d25);
                    double d14 = Math.abs(ad[(k7 - 1) + (i4 - 1) * l + k]);
                    if(d25 > d14)
                        d23 *= d14 / d25;
                    i4 += byte0;
                }

                d1 = Math.min(d1, d23);
            } else
            {
                d1 = Math.min(1.0D, 1.0D / Math.max(d23, d9));
                int j4 = i5;
                for(int i9 = ((j5 - i5) + byte0) / byte0; i9 > 0; i9--)
                {
                    if(d1 <= d9)
                        break;
                    double d26 = 1.0D + ad2[(j4 - 1) + j1];
                    d1 /= d26;
                    j4 += byte0;
                }

            }
        }
label1:
        {
label2:
            {
label3:
                {
                    if(d1 * d20 > d9)
                    {
                        Dtbsv.dtbsv(s, s1, s2, i, j, ad, k, l, ad1, i1, 1);
                        break label1;
                    }
                    if(d30 > d)
                    {
                        doublew.val = d / d30;
                        Dscal.dscal(i, doublew.val, ad1, i1, 1);
                        d30 = d;
                    }
                    if(!flag)
                        break label3;
                    int k4 = i5;
                    for(int j9 = ((j5 - i5) + byte0) / byte0; j9 > 0; j9--)
                    {
                        double d27;
label4:
                        {
                            d27 = Math.abs(ad1[(k4 - 1) + i1]);
                            if(flag1)
                            {
                                d18 = ad[(k7 - 1) + (k4 - 1) * l + k] * d20;
                            } else
                            {
                                d18 = d20;
                                if(d20 == 1.0D)
                                    break label4;
                            }
                            double d15 = Math.abs(d18);
                            if(d15 > d9)
                            {
                                if((d15 < 1.0D) && (d27 > d15 * d))
                                {
                                    double d3 = 1.0D / d27;
                                    Dscal.dscal(i, d3, ad1, i1, 1);
                                    doublew.val = doublew.val * d3;
                                    d30 *= d3;
                                }
                                ad1[(k4 - 1) + i1] = ad1[(k4 - 1) + i1] / d18;
                                d27 = Math.abs(ad1[(k4 - 1) + i1]);
                            } else
                            if(d15 > 0.0D)
                            {
                                if(d27 > d15 * d)
                                {
                                    double d4 = (d15 * d) / d27;
                                    if(ad2[(k4 - 1) + j1] > 1.0D)
                                        d4 /= ad2[(k4 - 1) + j1];
                                    Dscal.dscal(i, d4, ad1, i1, 1);
                                    doublew.val = doublew.val * d4;
                                    d30 *= d4;
                                }
                                ad1[(k4 - 1) + i1] = ad1[(k4 - 1) + i1] / d18;
                                d27 = Math.abs(ad1[(k4 - 1) + i1]);
                            } else
                            {
                                int k1 = 1;
                                for(int l9 = (i - 1) + 1; l9 > 0; l9--)
                                {
                                    ad1[(k1 - 1) + i1] = 0.0D;
                                    k1++;
                                }

                                ad1[(k4 - 1) + i1] = 1.0D;
                                d27 = 1.0D;
                                doublew.val = 0.0D;
                                d30 = 0.0D;
                            }
                        }
                        if(d27 > 1.0D)
                        {
                            double d5 = 1.0D / d27;
                            if(ad2[(k4 - 1) + j1] > (d - d30) * d5)
                            {
                                d5 *= 0.5D;
                                Dscal.dscal(i, d5, ad1, i1, 1);
                                doublew.val = doublew.val * d5;
                            }
                        } else
                        if(d27 * ad2[(k4 - 1) + j1] > d - d30)
                        {
                            Dscal.dscal(i, 0.5D, ad1, i1, 1);
                            doublew.val = doublew.val * 0.5D;
                        }
                        if(flag2)
                        {
                            if(k4 > 1)
                            {
                                int i6 = Math.min(j, k4 - 1);
                                Daxpy.daxpy(i6, -(ad1[(k4 - 1) + i1] * d20), ad, ((j + 1) - i6 - 1) + (k4 - 1) * l + k, 1, ad1, (k4 - i6 - 1) + i1, 1);
                                int l1 = Idamax.idamax(k4 - 1, ad1, i1, 1);
                                d30 = Math.abs(ad1[(l1 - 1) + i1]);
                            }
                        } else
                        if(k4 < i)
                        {
                            int j6 = Math.min(j, i - k4);
                            if(j6 > 0)
                                Daxpy.daxpy(j6, -(ad1[(k4 - 1) + i1] * d20), ad, (2 - 1) + (k4 - 1) * l + k, 1, ad1, ((k4 + 1) - 1) + i1, 1);
                            int i2 = k4 + Idamax.idamax(i - k4, ad1, ((k4 + 1) - 1) + i1, 1);
                            d30 = Math.abs(ad1[(i2 - 1) + i1]);
                        }
                        k4 += byte0;
                    }

                    break label2;
                }
                int l4 = i5;
                for(int k9 = ((j5 - i5) + byte0) / byte0; k9 > 0; k9--)
                {
label5:
                    {
                        double d28 = Math.abs(ad1[(l4 - 1) + i1]);
                        double d22 = d20;
                        double d6 = 1.0D / Math.max(d30, 1.0D);
                        if(ad2[(l4 - 1) + j1] > (d - d28) * d6)
                        {
                            d6 *= 0.5D;
                            if(flag1)
                                d18 = ad[(k7 - 1) + (l4 - 1) * l + k] * d20;
                            else
                                d18 = d20;
                            double d16 = Math.abs(d18);
                            if(d16 > 1.0D)
                            {
                                d6 = Math.min(1.0D, d6 * d16);
                                d22 /= d18;
                            }
                            if(d6 < 1.0D)
                            {
                                Dscal.dscal(i, d6, ad1, i1, 1);
                                doublew.val = doublew.val * d6;
                                d30 *= d6;
                            }
                        }
                        double d11 = 0.0D;
                        if(d22 == 1.0D)
                        {
                            if(flag2)
                            {
                                int k6 = Math.min(j, l4 - 1);
                                d11 = Ddot.ddot(k6, ad, ((j + 1) - k6 - 1) + (l4 - 1) * l + k, 1, ad1, (l4 - k6 - 1) + i1, 1);
                            } else
                            {
                                int l6 = Math.min(j, i - l4);
                                if(l6 > 0)
                                    d11 = Ddot.ddot(l6, ad, (2 - 1) + (l4 - 1) * l + k, 1, ad1, ((l4 + 1) - 1) + i1, 1);
                            }
                        } else
                        if(flag2)
                        {
                            int i7 = Math.min(j, l4 - 1);
                            int j2 = 1;
                            for(int i10 = (i7 - 1) + 1; i10 > 0; i10--)
                            {
                                d11 += ad[((j + j2) - i7 - 1) + (l4 - 1) * l + k] * d22 * ad1[(((l4 - i7 - 1) + j2) - 1) + i1];
                                j2++;
                            }

                        } else
                        {
                            int j7 = Math.min(j, i - l4);
                            int k2 = 1;
                            for(int j10 = (j7 - 1) + 1; j10 > 0; j10--)
                            {
                                d11 += ad[((k2 + 1) - 1) + (l4 - 1) * l + k] * d22 * ad1[((l4 + k2) - 1) + i1];
                                k2++;
                            }

                        }
                        if(d22 == d20)
                        {
                            ad1[(l4 - 1) + i1] = ad1[(l4 - 1) + i1] - d11;
                            double d29 = Math.abs(ad1[(l4 - 1) + i1]);
                            if(flag1)
                            {
                                d18 = ad[(k7 - 1) + (l4 - 1) * l + k] * d20;
                            } else
                            {
                                d18 = d20;
                                if(d20 == 1.0D)
                                    break label5;
                            }
                            double d17 = Math.abs(d18);
                            if(d17 > d9)
                            {
                                if((d17 < 1.0D) && (d29 > d17 * d))
                                {
                                    double d7 = 1.0D / d29;
                                    Dscal.dscal(i, d7, ad1, i1, 1);
                                    doublew.val = doublew.val * d7;
                                    d30 *= d7;
                                }
                                ad1[(l4 - 1) + i1] = ad1[(l4 - 1) + i1] / d18;
                            } else
                            if(d17 > 0.0D)
                            {
                                if(d29 > d17 * d)
                                {
                                    double d8 = (d17 * d) / d29;
                                    Dscal.dscal(i, d8, ad1, i1, 1);
                                    doublew.val = doublew.val * d8;
                                    d30 *= d8;
                                }
                                ad1[(l4 - 1) + i1] = ad1[(l4 - 1) + i1] / d18;
                            } else
                            {
                                int l2 = 1;
                                for(int k10 = (i - 1) + 1; k10 > 0; k10--)
                                {
                                    ad1[(l2 - 1) + i1] = 0.0D;
                                    l2++;
                                }

                                ad1[(l4 - 1) + i1] = 1.0D;
                                doublew.val = 0.0D;
                                d30 = 0.0D;
                            }
                        } else
                        {
                            ad1[(l4 - 1) + i1] = ad1[(l4 - 1) + i1] / d18 - d11;
                        }
                    }
                    d30 = Math.max(d30, Math.abs(ad1[(l4 - 1) + i1]));
                    l4 += byte0;
                }

            }
            doublew.val = doublew.val / d20;
        }
        if(d20 != 1.0D)
            Dscal.dscal(i, 1.0D / d20, ad2, j1, 1);
    }
}

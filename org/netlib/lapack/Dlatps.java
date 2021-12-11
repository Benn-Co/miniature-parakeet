package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlatps
{
    public static void dlatps(String s, String s1, String s2, String s3, int i, double ad[], int j, double ad1[], 
            int k, doubleW doublew, double ad2[], int l, intW intw)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        int i6;
        byte byte0;
        int j6;
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
            int k2 = 0;
            int j4 = 0;
            i6 = 0;
            byte0 = 0;
            j6 = 0;
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
            if(intw.val != 0)
            {
                Xerbla.xerbla("DLATPS", -intw.val);
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
                    int l2 = 1;
                    j4 = 1;
                    for(int j7 = (i - 1) + 1; j7 > 0; j7--)
                    {
                        ad2[(j4 - 1) + l] = Dasum.dasum(j4 - 1, ad, (l2 - 1) + j, 1);
                        l2 += j4;
                        j4++;
                    }

                } else
                {
                    int i3 = 1;
                    j4 = 1;
                    for(int k7 = (i - 1 - 1) + 1; k7 > 0; k7--)
                    {
                        ad2[(j4 - 1) + l] = Dasum.dasum(i - j4, ad, ((i3 + 1) - 1) + j, 1);
                        i3 = ((i3 + i) - j4) + 1;
                        j4++;
                    }

                    ad2[(i - 1) + l] = 0.0D;
                }
            k2 = Idamax.idamax(i, ad2, l, 1);
            d19 = ad2[(k2 - 1) + l];
            if(d19 <= d)
            {
                d20 = 1.0D;
            } else
            {
                d20 = 1.0D / (d9 * d19);
                Dscal.dscal(i, d20, ad2, l, 1);
            }
            j4 = Idamax.idamax(i, ad1, k, 1);
            d30 = Math.abs(ad1[(j4 - 1) + k]);
            d23 = d30;
            if(flag)
            {
                if(flag2)
                {
                    i6 = i;
                    j6 = 1;
                    byte0 = -1;
                } else
                {
                    i6 = 1;
                    j6 = i;
                    byte0 = 1;
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
                    int j3 = (i6 * (i6 + 1)) / 2;
                    int k6 = i;
                    int k4 = i6;
                    for(int l7 = ((j6 - i6) + byte0) / byte0; l7 > 0; l7--)
                    {
                        if(d1 <= d9)
                            break label0;
                        double d13 = Math.abs(ad[(j3 - 1) + j]);
                        d23 = Math.min(d23, Math.min(1.0D, d13) * d1);
                        if(d13 + ad2[(k4 - 1) + l] >= d9)
                            d1 *= d13 / (d13 + ad2[(k4 - 1) + l]);
                        else
                            d1 = 0.0D;
                        j3 += byte0 * k6;
                        k6--;
                        k4 += byte0;
                    }

                    d1 = d23;
                } else
                {
                    d1 = Math.min(1.0D, 1.0D / Math.max(d23, d9));
                    int l4 = i6;
                    for(int i8 = ((j6 - i6) + byte0) / byte0; i8 > 0; i8--)
                    {
                        if(d1 <= d9)
                            break;
                        d1 *= 1.0D / (1.0D + ad2[(l4 - 1) + l]);
                        l4 += byte0;
                    }

                }
                break label0;
            }
            if(flag2)
            {
                i6 = 1;
                j6 = i;
                byte0 = 1;
            } else
            {
                i6 = i;
                j6 = 1;
                byte0 = -1;
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
                int k3 = (i6 * (i6 + 1)) / 2;
                int l6 = 1;
                int i5 = i6;
                for(int j8 = ((j6 - i6) + byte0) / byte0; j8 > 0; j8--)
                {
                    if(d1 <= d9)
                        break label0;
                    double d25 = 1.0D + ad2[(i5 - 1) + l];
                    d1 = Math.min(d1, d23 / d25);
                    double d14 = Math.abs(ad[(k3 - 1) + j]);
                    if(d25 > d14)
                        d23 *= d14 / d25;
                    l6++;
                    k3 += byte0 * l6;
                    i5 += byte0;
                }

                d1 = Math.min(d1, d23);
            } else
            {
                d1 = Math.min(1.0D, 1.0D / Math.max(d23, d9));
                int j5 = i6;
                for(int k8 = ((j6 - i6) + byte0) / byte0; k8 > 0; k8--)
                {
                    if(d1 <= d9)
                        break;
                    double d26 = 1.0D + ad2[(j5 - 1) + l];
                    d1 /= d26;
                    j5 += byte0;
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
                        Dtpsv.dtpsv(s, s1, s2, i, ad, j, ad1, k, 1);
                        break label1;
                    }
                    if(d30 > d)
                    {
                        doublew.val = d / d30;
                        Dscal.dscal(i, doublew.val, ad1, k, 1);
                        d30 = d;
                    }
                    if(!flag)
                        break label3;
                    int l3 = (i6 * (i6 + 1)) / 2;
                    int k5 = i6;
                    for(int l8 = ((j6 - i6) + byte0) / byte0; l8 > 0; l8--)
                    {
                        double d27;
label4:
                        {
                            d27 = Math.abs(ad1[(k5 - 1) + k]);
                            if(flag1)
                            {
                                d18 = ad[(l3 - 1) + j] * d20;
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
                                    Dscal.dscal(i, d3, ad1, k, 1);
                                    doublew.val = doublew.val * d3;
                                    d30 *= d3;
                                }
                                ad1[(k5 - 1) + k] = ad1[(k5 - 1) + k] / d18;
                                d27 = Math.abs(ad1[(k5 - 1) + k]);
                            } else
                            if(d15 > 0.0D)
                            {
                                if(d27 > d15 * d)
                                {
                                    double d4 = (d15 * d) / d27;
                                    if(ad2[(k5 - 1) + l] > 1.0D)
                                        d4 /= ad2[(k5 - 1) + l];
                                    Dscal.dscal(i, d4, ad1, k, 1);
                                    doublew.val = doublew.val * d4;
                                    d30 *= d4;
                                }
                                ad1[(k5 - 1) + k] = ad1[(k5 - 1) + k] / d18;
                                d27 = Math.abs(ad1[(k5 - 1) + k]);
                            } else
                            {
                                int i1 = 1;
                                for(int j9 = (i - 1) + 1; j9 > 0; j9--)
                                {
                                    ad1[(i1 - 1) + k] = 0.0D;
                                    i1++;
                                }

                                ad1[(k5 - 1) + k] = 1.0D;
                                d27 = 1.0D;
                                doublew.val = 0.0D;
                                d30 = 0.0D;
                            }
                        }
                        if(d27 > 1.0D)
                        {
                            double d5 = 1.0D / d27;
                            if(ad2[(k5 - 1) + l] > (d - d30) * d5)
                            {
                                d5 *= 0.5D;
                                Dscal.dscal(i, d5, ad1, k, 1);
                                doublew.val = doublew.val * d5;
                            }
                        } else
                        if(d27 * ad2[(k5 - 1) + l] > d - d30)
                        {
                            Dscal.dscal(i, 0.5D, ad1, k, 1);
                            doublew.val = doublew.val * 0.5D;
                        }
                        if(flag2)
                        {
                            if(k5 > 1)
                            {
                                Daxpy.daxpy(k5 - 1, -(ad1[(k5 - 1) + k] * d20), ad, (((l3 - k5) + 1) - 1) + j, 1, ad1, k, 1);
                                int j1 = Idamax.idamax(k5 - 1, ad1, k, 1);
                                d30 = Math.abs(ad1[(j1 - 1) + k]);
                            }
                            l3 -= k5;
                        } else
                        {
                            if(k5 < i)
                            {
                                Daxpy.daxpy(i - k5, -(ad1[(k5 - 1) + k] * d20), ad, ((l3 + 1) - 1) + j, 1, ad1, ((k5 + 1) - 1) + k, 1);
                                int k1 = k5 + Idamax.idamax(i - k5, ad1, ((k5 + 1) - 1) + k, 1);
                                d30 = Math.abs(ad1[(k1 - 1) + k]);
                            }
                            l3 = ((l3 + i) - k5) + 1;
                        }
                        k5 += byte0;
                    }

                    break label2;
                }
                int i4 = (i6 * (i6 + 1)) / 2;
                int i7 = 1;
                int l5 = i6;
                for(int i9 = ((j6 - i6) + byte0) / byte0; i9 > 0; i9--)
                {
label5:
                    {
                        double d28 = Math.abs(ad1[(l5 - 1) + k]);
                        double d22 = d20;
                        double d6 = 1.0D / Math.max(d30, 1.0D);
                        if(ad2[(l5 - 1) + l] > (d - d28) * d6)
                        {
                            d6 *= 0.5D;
                            if(flag1)
                                d18 = ad[(i4 - 1) + j] * d20;
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
                                Dscal.dscal(i, d6, ad1, k, 1);
                                doublew.val = doublew.val * d6;
                                d30 *= d6;
                            }
                        }
                        double d11 = 0.0D;
                        if(d22 == 1.0D)
                        {
                            if(flag2)
                                d11 = Ddot.ddot(l5 - 1, ad, (((i4 - l5) + 1) - 1) + j, 1, ad1, k, 1);
                            else
                            if(l5 < i)
                                d11 = Ddot.ddot(i - l5, ad, ((i4 + 1) - 1) + j, 1, ad1, ((l5 + 1) - 1) + k, 1);
                        } else
                        if(flag2)
                        {
                            int l1 = 1;
                            for(int k9 = (l5 - 1 - 1) + 1; k9 > 0; k9--)
                            {
                                d11 += ad[(((i4 - l5) + l1) - 1) + j] * d22 * ad1[(l1 - 1) + k];
                                l1++;
                            }

                        } else
                        if(l5 < i)
                        {
                            int i2 = 1;
                            for(int l9 = (i - l5 - 1) + 1; l9 > 0; l9--)
                            {
                                d11 += ad[((i4 + i2) - 1) + j] * d22 * ad1[((l5 + i2) - 1) + k];
                                i2++;
                            }

                        }
                        if(d22 == d20)
                        {
                            ad1[(l5 - 1) + k] = ad1[(l5 - 1) + k] - d11;
                            double d29 = Math.abs(ad1[(l5 - 1) + k]);
                            if(flag1)
                            {
                                d18 = ad[(i4 - 1) + j] * d20;
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
                                    Dscal.dscal(i, d7, ad1, k, 1);
                                    doublew.val = doublew.val * d7;
                                    d30 *= d7;
                                }
                                ad1[(l5 - 1) + k] = ad1[(l5 - 1) + k] / d18;
                            } else
                            if(d17 > 0.0D)
                            {
                                if(d29 > d17 * d)
                                {
                                    double d8 = (d17 * d) / d29;
                                    Dscal.dscal(i, d8, ad1, k, 1);
                                    doublew.val = doublew.val * d8;
                                    d30 *= d8;
                                }
                                ad1[(l5 - 1) + k] = ad1[(l5 - 1) + k] / d18;
                            } else
                            {
                                int j2 = 1;
                                for(int i10 = (i - 1) + 1; i10 > 0; i10--)
                                {
                                    ad1[(j2 - 1) + k] = 0.0D;
                                    j2++;
                                }

                                ad1[(l5 - 1) + k] = 1.0D;
                                doublew.val = 0.0D;
                                d30 = 0.0D;
                            }
                        } else
                        {
                            ad1[(l5 - 1) + k] = ad1[(l5 - 1) + k] / d18 - d11;
                        }
                    }
                    d30 = Math.max(d30, Math.abs(ad1[(l5 - 1) + k]));
                    i7++;
                    i4 += byte0 * i7;
                    l5 += byte0;
                }

            }
            doublew.val = doublew.val / d20;
        }
        if(d20 != 1.0D)
            Dscal.dscal(i, 1.0D / d20, ad2, l, 1);
    }
}

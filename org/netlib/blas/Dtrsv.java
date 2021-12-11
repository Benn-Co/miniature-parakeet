package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dtrsv
{
    public static void dtrsv(String s, String s1, String s2, int i, double ad[], int j, int k, double ad1[], 
            int l, int i1)
    {
        byte byte0 = 0;
        int j7 = 0;
        boolean flag4 = false;
        byte0 = 0;
        if(Lsame.lsame(s, "U") ^ true && Lsame.lsame(s, "L") ^ true)
            byte0 = 1;
        else
        if((Lsame.lsame(s1, "N") ^ true && Lsame.lsame(s1, "T") ^ true) && Lsame.lsame(s1, "C") ^ true)
            byte0 = 2;
        else
        if(Lsame.lsame(s2, "U") ^ true && Lsame.lsame(s2, "N") ^ true)
            byte0 = 3;
        else
        if(i < 0)
            byte0 = 4;
        else
        if(k < Math.max(1, i))
            byte0 = 6;
        else
        if(i1 == 0)
            byte0 = 8;
        if(byte0 != 0)
        {
            Xerbla.xerbla("DTRSV ", byte0);
            return;
        }
        if(i == 0)
            return;
        flag4 = Lsame.lsame(s2, "N");
        if(i1 <= 0)
            j7 = 1 - (i - 1) * i1;
        else
        if(i1 != 1)
            j7 = 1;
        if(Lsame.lsame(s1, "N"))
        {
            if(Lsame.lsame(s, "U"))
            {
                if(i1 == 1)
                {
                    int j4 = i;
                    for(int k7 = ((1 - i) + -1) / -1; k7 > 0; k7--)
                    {
                        if(ad1[(j4 - 1) + l] != 0.0D)
                        {
                            if(flag4)
                                ad1[(j4 - 1) + l] = ad1[(j4 - 1) + l] / ad[(j4 - 1) + (j4 - 1) * k + j];
                            double d1 = ad1[(j4 - 1) + l];
                            int j1 = j4 - 1;
                            for(int k9 = ((1 - (j4 - 1)) + -1) / -1; k9 > 0; k9--)
                            {
                                ad1[(j1 - 1) + l] = ad1[(j1 - 1) + l] - d1 * ad[(j1 - 1) + (j4 - 1) * k + j];
                                j1--;
                            }

                        }
                        j4--;
                    }

                } else
                {
                    int j6 = j7 + (i - 1) * i1;
                    int k4 = i;
                    for(int l7 = ((1 - i) + -1) / -1; l7 > 0; l7--)
                    {
                        if(ad1[(j6 - 1) + l] != 0.0D)
                        {
                            if(flag4)
                                ad1[(j6 - 1) + l] = ad1[(j6 - 1) + l] / ad[(k4 - 1) + (k4 - 1) * k + j];
                            double d2 = ad1[(j6 - 1) + l];
                            int j3 = j6;
                            int k1 = k4 - 1;
                            for(int l9 = ((1 - (k4 - 1)) + -1) / -1; l9 > 0; l9--)
                            {
                                j3 -= i1;
                                ad1[(j3 - 1) + l] = ad1[(j3 - 1) + l] - d2 * ad[(k1 - 1) + (k4 - 1) * k + j];
                                k1--;
                            }

                        }
                        j6 -= i1;
                        k4--;
                    }

                }
            } else
            if(i1 == 1)
            {
                int l4 = 1;
                for(int i8 = (i - 1) + 1; i8 > 0; i8--)
                {
                    if(ad1[(l4 - 1) + l] != 0.0D)
                    {
                        if(flag4)
                            ad1[(l4 - 1) + l] = ad1[(l4 - 1) + l] / ad[(l4 - 1) + (l4 - 1) * k + j];
                        double d3 = ad1[(l4 - 1) + l];
                        int l1 = l4 + 1;
                        for(int i10 = (i - (l4 + 1)) + 1; i10 > 0; i10--)
                        {
                            ad1[(l1 - 1) + l] = ad1[(l1 - 1) + l] - d3 * ad[(l1 - 1) + (l4 - 1) * k + j];
                            l1++;
                        }

                    }
                    l4++;
                }

            } else
            {
                int k6 = j7;
                int i5 = 1;
                for(int j8 = (i - 1) + 1; j8 > 0; j8--)
                {
                    if(ad1[(k6 - 1) + l] != 0.0D)
                    {
                        if(flag4)
                            ad1[(k6 - 1) + l] = ad1[(k6 - 1) + l] / ad[(i5 - 1) + (i5 - 1) * k + j];
                        double d4 = ad1[(k6 - 1) + l];
                        int k3 = k6;
                        int i2 = i5 + 1;
                        for(int j10 = (i - (i5 + 1)) + 1; j10 > 0; j10--)
                        {
                            k3 += i1;
                            ad1[(k3 - 1) + l] = ad1[(k3 - 1) + l] - d4 * ad[(i2 - 1) + (i5 - 1) * k + j];
                            i2++;
                        }

                    }
                    k6 += i1;
                    i5++;
                }

            }
        } else
        if(Lsame.lsame(s, "U"))
        {
            if(i1 == 1)
            {
                int j5 = 1;
                for(int k8 = (i - 1) + 1; k8 > 0; k8--)
                {
                    double d5 = ad1[(j5 - 1) + l];
                    int j2 = 1;
                    for(int k10 = (j5 - 1 - 1) + 1; k10 > 0; k10--)
                    {
                        d5 -= ad[(j2 - 1) + (j5 - 1) * k + j] * ad1[(j2 - 1) + l];
                        j2++;
                    }

                    if(flag4)
                        d5 /= ad[(j5 - 1) + (j5 - 1) * k + j];
                    ad1[(j5 - 1) + l] = d5;
                    j5++;
                }

            } else
            {
                int l6 = j7;
                int k5 = 1;
                for(int l8 = (i - 1) + 1; l8 > 0; l8--)
                {
                    double d6 = ad1[(l6 - 1) + l];
                    int l3 = j7;
                    int k2 = 1;
                    for(int l10 = (k5 - 1 - 1) + 1; l10 > 0; l10--)
                    {
                        d6 -= ad[(k2 - 1) + (k5 - 1) * k + j] * ad1[(l3 - 1) + l];
                        l3 += i1;
                        k2++;
                    }

                    if(flag4)
                        d6 /= ad[(k5 - 1) + (k5 - 1) * k + j];
                    ad1[(l6 - 1) + l] = d6;
                    l6 += i1;
                    k5++;
                }

            }
        } else
        if(i1 == 1)
        {
            int l5 = i;
            for(int i9 = ((1 - i) + -1) / -1; i9 > 0; i9--)
            {
                double d7 = ad1[(l5 - 1) + l];
                int l2 = i;
                for(int i11 = (((l5 + 1) - i) + -1) / -1; i11 > 0; i11--)
                {
                    d7 -= ad[(l2 - 1) + (l5 - 1) * k + j] * ad1[(l2 - 1) + l];
                    l2--;
                }

                if(flag4)
                    d7 /= ad[(l5 - 1) + (l5 - 1) * k + j];
                ad1[(l5 - 1) + l] = d7;
                l5--;
            }

        } else
        {
            j7 += (i - 1) * i1;
            int i7 = j7;
            int i6 = i;
            for (int j9 = ((1 - i) + -1) / -1; j9 > 0; j9--)
            {
                double d8 = ad1[(i7 - 1) + l];
                int i4 = j7;
                int i3 = i;
                for (int j11 = (((i6 + 1) - i) + -1) / -1; j11 > 0; j11--)
                {
                    d8 -= ad[(i3 - 1) + (i6 - 1) * k + j] * ad1[(i4 - 1) + l];
                    i4 -= i1;
                    i3--;
                }

                if (flag4)
                    d8 /= ad[(i6 - 1) + (i6 - 1) * k + j];
                ad1[(i7 - 1) + l] = d8;
                i7 -= i1;
                i6--;
            }

        }
    }
}

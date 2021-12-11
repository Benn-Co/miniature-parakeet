package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dtbsv
{
    public static void dtbsv(String s, String s1, String s2, int i, int j, double ad[], int k, int l, 
            double ad1[], int i1, int j1)
    {
        byte byte0 = 0;
        int i8 = 0;
        boolean flag = false;
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
        if(j < 0)
            byte0 = 5;
        else
        if(l < j + 1)
            byte0 = 7;
        else
        if(j1 == 0)
            byte0 = 9;
        if(byte0 != 0)
        {
            Xerbla.xerbla("DTBSV ", byte0);
            return;
        }
        if(i == 0)
            return;
        flag = Lsame.lsame(s2, "N");
        if(j1 <= 0)
            i8 = 1 - (i - 1) * j1;
        else
        if(j1 != 1)
            i8 = 1;
        if(Lsame.lsame(s1, "N"))
        {
            if(Lsame.lsame(s, "U"))
            {
                int k7 = j + 1;
                if(j1 == 1)
                {
                    int k4 = i;
                    for(int j10 = ((1 - i) + -1) / -1; j10 > 0; j10--)
                    {
                        if(ad1[(k4 - 1) + i1] != 0.0D)
                        {
                            int j8 = k7 - k4;
                            if(flag)
                                ad1[(k4 - 1) + i1] = ad1[(k4 - 1) + i1] / ad[(k7 - 1) + (k4 - 1) * l + k];
                            double d1 = ad1[(k4 - 1) + i1];
                            int k1 = k4 - 1;
                            for(int j12 = ((Math.max(1, k4 - j) - (k4 - 1)) + -1) / -1; j12 > 0; j12--)
                            {
                                ad1[(k1 - 1) + i1] = ad1[(k1 - 1) + i1] - d1 * ad[((j8 + k1) - 1) + (k4 - 1) * l + k];
                                k1--;
                            }

                        }
                        k4--;
                    }

                } else
                {
                    i8 += (i - 1) * j1;
                    int k6 = i8;
                    int l4 = i;
                    for(int k10 = ((1 - i) + -1) / -1; k10 > 0; k10--)
                    {
                        i8 -= j1;
                        if(ad1[(k6 - 1) + i1] != 0.0D)
                        {
                            int k3 = i8;
                            int k8 = k7 - l4;
                            if(flag)
                                ad1[(k6 - 1) + i1] = ad1[(k6 - 1) + i1] / ad[(k7 - 1) + (l4 - 1) * l + k];
                            double d2 = ad1[(k6 - 1) + i1];
                            int l1 = l4 - 1;
                            for(int k12 = ((Math.max(1, l4 - j) - (l4 - 1)) + -1) / -1; k12 > 0; k12--)
                            {
                                ad1[(k3 - 1) + i1] = ad1[(k3 - 1) + i1] - d2 * ad[((k8 + l1) - 1) + (l4 - 1) * l + k];
                                k3 -= j1;
                                l1--;
                            }

                        }
                        k6 -= j1;
                        l4--;
                    }

                }
            } else
            if(j1 == 1)
            {
                int i5 = 1;
                for(int l10 = (i - 1) + 1; l10 > 0; l10--)
                {
                    if(ad1[(i5 - 1) + i1] != 0.0D)
                    {
                        int l8 = 1 - i5;
                        if(flag)
                            ad1[(i5 - 1) + i1] = ad1[(i5 - 1) + i1] / ad[(1 - 1) + (i5 - 1) * l + k];
                        double d3 = ad1[(i5 - 1) + i1];
                        int i2 = i5 + 1;
                        for(int l12 = (Math.min(i, i5 + j) - (i5 + 1)) + 1; l12 > 0; l12--)
                        {
                            ad1[(i2 - 1) + i1] = ad1[(i2 - 1) + i1] - d3 * ad[((l8 + i2) - 1) + (i5 - 1) * l + k];
                            i2++;
                        }

                    }
                    i5++;
                }

            } else
            {
                int l6 = i8;
                int j5 = 1;
                for(int i11 = (i - 1) + 1; i11 > 0; i11--)
                {
                    i8 += j1;
                    if(ad1[(l6 - 1) + i1] != 0.0D)
                    {
                        int l3 = i8;
                        int i9 = 1 - j5;
                        if(flag)
                            ad1[(l6 - 1) + i1] = ad1[(l6 - 1) + i1] / ad[(1 - 1) + (j5 - 1) * l + k];
                        double d4 = ad1[(l6 - 1) + i1];
                        int j2 = j5 + 1;
                        for(int i13 = (Math.min(i, j5 + j) - (j5 + 1)) + 1; i13 > 0; i13--)
                        {
                            ad1[(l3 - 1) + i1] = ad1[(l3 - 1) + i1] - d4 * ad[((i9 + j2) - 1) + (j5 - 1) * l + k];
                            l3 += j1;
                            j2++;
                        }

                    }
                    l6 += j1;
                    j5++;
                }

            }
        } else
        if(Lsame.lsame(s, "U"))
        {
            int l7 = j + 1;
            if(j1 == 1)
            {
                int k5 = 1;
                for(int j11 = (i - 1) + 1; j11 > 0; j11--)
                {
                    double d5 = ad1[(k5 - 1) + i1];
                    int j9 = l7 - k5;
                    int k2 = Math.max(1, k5 - j);
                    for(int j13 = (k5 - 1 - Math.max(1, k5 - j)) + 1; j13 > 0; j13--)
                    {
                        d5 -= ad[((j9 + k2) - 1) + (k5 - 1) * l + k] * ad1[(k2 - 1) + i1];
                        k2++;
                    }

                    if(flag)
                        d5 /= ad[(l7 - 1) + (k5 - 1) * l + k];
                    ad1[(k5 - 1) + i1] = d5;
                    k5++;
                }

            } else
            {
                int i7 = i8;
                int l5 = 1;
                for(int k11 = (i - 1) + 1; k11 > 0; k11--)
                {
                    double d6 = ad1[(i7 - 1) + i1];
                    int i4 = i8;
                    int k9 = l7 - l5;
                    int l2 = Math.max(1, l5 - j);
                    for(int k13 = (l5 - 1 - Math.max(1, l5 - j)) + 1; k13 > 0; k13--)
                    {
                        d6 -= ad[((k9 + l2) - 1) + (l5 - 1) * l + k] * ad1[(i4 - 1) + i1];
                        i4 += j1;
                        l2++;
                    }

                    if(flag)
                        d6 /= ad[(l7 - 1) + (l5 - 1) * l + k];
                    ad1[(i7 - 1) + i1] = d6;
                    i7 += j1;
                    if(l5 > j)
                        i8 += j1;
                    l5++;
                }

            }
        } else
        if(j1 == 1)
        {
            int i6 = i;
            for(int l11 = ((1 - i) + -1) / -1; l11 > 0; l11--)
            {
                double d7 = ad1[(i6 - 1) + i1];
                int l9 = 1 - i6;
                int i3 = Math.min(i, i6 + j);
                for(int l13 = (((i6 + 1) - Math.min(i, i6 + j)) + -1) / -1; l13 > 0; l13--)
                {
                    d7 -= ad[((l9 + i3) - 1) + (i6 - 1) * l + k] * ad1[(i3 - 1) + i1];
                    i3--;
                }

                if(flag)
                    d7 /= ad[(1 - 1) + (i6 - 1) * l + k];
                ad1[(i6 - 1) + i1] = d7;
                i6--;
            }

        } else
        {
            i8 += (i - 1) * j1;
            int j7 = i8;
            int j6 = i;
            for (int i12 = ((1 - i) + -1) / -1; i12 > 0; i12--)
            {
                double d8 = ad1[(j7 - 1) + i1];
                int j4 = i8;
                int i10 = 1 - j6;
                int j3 = Math.min(i, j6 + j);
                for (int i14 = (((j6 + 1) - Math.min(i, j6 + j)) + -1) / -1; i14 > 0; i14--)
                {
                    d8 -= ad[((i10 + j3) - 1) + (j6 - 1) * l + k] * ad1[(j4 - 1) + i1];
                    j4 -= j1;
                    j3--;
                }

                if (flag)
                    d8 /= ad[(1 - 1) + (j6 - 1) * l + k];
                ad1[(j7 - 1) + i1] = d8;
                j7 -= j1;
                if (i - j6 >= j)
                    i8 -= j1;
                j6--;
            }

        }
    }
}

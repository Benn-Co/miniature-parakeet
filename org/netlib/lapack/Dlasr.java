package org.netlib.lapack;

import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;

public final class Dlasr
{
    public static void dlasr(String s, String s1, String s2, int i, int j, double ad[], int k, double ad1[], 
            int l, double ad2[], int i1, int j1)
    {
        byte byte0 = 0;
        byte0 = 0;
        if((Lsame.lsame(s, "L") || Lsame.lsame(s, "R")) ^ true)
            byte0 = 1;
        else
        if(((Lsame.lsame(s1, "V") || Lsame.lsame(s1, "T")) || Lsame.lsame(s1, "B")) ^ true)
            byte0 = 2;
        else
        if((Lsame.lsame(s2, "F") || Lsame.lsame(s2, "B")) ^ true)
            byte0 = 3;
        else
        if(i < 0)
            byte0 = 4;
        else
        if(j < 0)
            byte0 = 5;
        else
        if(j1 < Math.max(1, i))
            byte0 = 9;
        if(byte0 != 0)
        {
            Xerbla.xerbla("DLASR ", byte0);
            return;
        }
        if((i == 0) || (j == 0))
            return;
        if(Lsame.lsame(s, "L"))
        {
            if(Lsame.lsame(s1, "V"))
            {
                if(Lsame.lsame(s2, "F"))
                {
                    int k4 = 1;
                    for(int k7 = (i - 1 - 1) + 1; k7 > 0; k7--)
                    {
                        double d1 = ad[(k4 - 1) + k];
                        double d14 = ad1[(k4 - 1) + l];
                        if((d1 != 1.0) || (d14 != 0.0))
                        {
                            int k1 = 1;
                            for(int k10 = (j - 1) + 1; k10 > 0; k10--)
                            {
                                double d27 = ad2[((k4 + 1) - 1) + (k1 - 1) * j1 + i1];
                                ad2[((k4 + 1) - 1) + (k1 - 1) * j1 + i1] = d1 * d27 - d14 * ad2[(k4 - 1) + (k1 - 1) * j1 + i1];
                                ad2[(k4 - 1) + (k1 - 1) * j1 + i1] = d14 * d27 + d1 * ad2[(k4 - 1) + (k1 - 1) * j1 + i1];
                                k1++;
                            }

                        }
                        k4++;
                    }

                } else
                if(Lsame.lsame(s2, "B"))
                {
                    int l4 = i - 1;
                    for(int l7 = ((1 - (i - 1)) + -1) / -1; l7 > 0; l7--)
                    {
                        double d2 = ad[(l4 - 1) + k];
                        double d15 = ad1[(l4 - 1) + l];
                        if((d2 != 1.0) || (d15 != 0.0))
                        {
                            int l1 = 1;
                            for(int l10 = j; l10 > 0; l10--)
                            {
                                double d28 = ad2[((l4 + 1) - 1) + (l1 - 1) * j1 + i1];
                                ad2[((l4 + 1) - 1) + (l1 - 1) * j1 + i1] = d2 * d28 - d15 * ad2[(l4 - 1) + (l1 - 1) * j1 + i1];
                                ad2[(l4 - 1) + (l1 - 1) * j1 + i1] = d15 * d28 + d2 * ad2[(l4 - 1) + (l1 - 1) * j1 + i1];
                                l1++;
                            }

                        }
                        l4--;
                    }

                }
            } else
            if(Lsame.lsame(s1, "T"))
            {
                if(Lsame.lsame(s2, "F"))
                {
                    int i5 = 2;
                    for(int i8 = i - 1; i8 > 0; i8--)
                    {
                        double d3 = ad[(i5 - 1 - 1) + k];
                        double d16 = ad1[(i5 - 1 - 1) + l];
                        if((d3 != 1.0) || (d16 != 0.0))
                        {
                            int i2 = 1;
                            for(int i11 = j; i11 > 0; i11--)
                            {
                                double d29 = ad2[(i5 - 1) + (i2 - 1) * j1 + i1];
                                ad2[(i5 - 1) + (i2 - 1) * j1 + i1] = d3 * d29 - d16 * ad2[(1 - 1) + (i2 - 1) * j1 + i1];
                                ad2[(1 - 1) + (i2 - 1) * j1 + i1] = d16 * d29 + d3 * ad2[(1 - 1) + (i2 - 1) * j1 + i1];
                                i2++;
                            }

                        }
                        i5++;
                    }

                } else
                if(Lsame.lsame(s2, "B"))
                {
                    int j5 = i;
                    for(int j8 = ((2 - i) + -1) / -1; j8 > 0; j8--)
                    {
                        double d4 = ad[(j5 - 1 - 1) + k];
                        double d17 = ad1[(j5 - 1 - 1) + l];
                        if((d4 != 1.0) || (d17 != 0.0))
                        {
                            int j2 = 1;
                            for(int j11 = j; j11 > 0; j11--)
                            {
                                double d30 = ad2[(j5 - 1) + (j2 - 1) * j1 + i1];
                                ad2[(j5 - 1) + (j2 - 1) * j1 + i1] = d4 * d30 - d17 * ad2[(j2 - 1) * j1 + i1];
                                ad2[(j2 - 1) * j1 + i1] = d17 * d30 + d4 * ad2[(j2 - 1) * j1 + i1];
                                j2++;
                            }

                        }
                        j5--;
                    }

                }
            } else
            if(Lsame.lsame(s1, "B"))
                if(Lsame.lsame(s2, "F"))
                {
                    int k5 = 1;
                    for(int k8 = i - 1; k8 > 0; k8--)
                    {
                        double d5 = ad[(k5 - 1) + k];
                        double d18 = ad1[(k5 - 1) + l];
                        if((d5 != 1.0) || (d18 != 0.0))
                        {
                            int k2 = 1;
                            for(int k11 = j; k11 > 0; k11--)
                            {
                                double d31 = ad2[(k5 - 1) + (k2 - 1) * j1 + i1];
                                ad2[(k5 - 1) + (k2 - 1) * j1 + i1] = d18 * ad2[(i - 1) + (k2 - 1) * j1 + i1] + d5 * d31;
                                ad2[(i - 1) + (k2 - 1) * j1 + i1] = d5 * ad2[(i - 1) + (k2 - 1) * j1 + i1] - d18 * d31;
                                k2++;
                            }

                        }
                        k5++;
                    }

                } else
                if(Lsame.lsame(s2, "B"))
                {
                    int l5 = i - 1;
                    for(int l8 = ((1 - (i - 1)) + -1) / -1; l8 > 0; l8--)
                    {
                        double d6 = ad[(l5 - 1) + k];
                        double d19 = ad1[(l5 - 1) + l];
                        if((d6 != 1.0) || (d19 != 0.0))
                        {
                            int l2 = 1;
                            for(int l11 = j; l11 > 0; l11--)
                            {
                                double d32 = ad2[(l5 - 1) + (l2 - 1) * j1 + i1];
                                ad2[(l5 - 1) + (l2 - 1) * j1 + i1] = d19 * ad2[(i - 1) + (l2 - 1) * j1 + i1] + d6 * d32;
                                ad2[(i - 1) + (l2 - 1) * j1 + i1] = d6 * ad2[(i - 1) + (l2 - 1) * j1 + i1] - d19 * d32;
                                l2++;
                            }

                        }
                        l5--;
                    }

                }
        } else
        if(Lsame.lsame(s, "R"))
            if(Lsame.lsame(s1, "V"))
            {
                if(Lsame.lsame(s2, "F"))
                {
                    int i6 = 1;
                    for(int i9 = j - 1; i9 > 0; i9--)
                    {
                        double d7 = ad[(i6 - 1) + k];
                        double d20 = ad1[(i6 - 1) + l];
                        if((d7 != 1.0) || (d20 != 0.0))
                        {
                            int i3 = 1;
                            for(int i12 = i; i12 > 0; i12--)
                            {
                                double d33 = ad2[(i3 - 1) + ((i6 + 1) - 1) * j1 + i1];
                                ad2[(i3 - 1) + ((i6 + 1) - 1) * j1 + i1] = d7 * d33 - d20 * ad2[(i3 - 1) + (i6 - 1) * j1 + i1];
                                ad2[(i3 - 1) + (i6 - 1) * j1 + i1] = d20 * d33 + d7 * ad2[(i3 - 1) + (i6 - 1) * j1 + i1];
                                i3++;
                            }

                        }
                        i6++;
                    }

                } else
                if(Lsame.lsame(s2, "B"))
                {
                    int j6 = j - 1;
                    for(int j9 = ((1 - (j - 1)) + -1) / -1; j9 > 0; j9--)
                    {
                        double d8 = ad[(j6 - 1) + k];
                        double d21 = ad1[(j6 - 1) + l];
                        if((d8 != 1.0) || (d21 != 0.0))
                        {
                            int j3 = 1;
                            for(int j12 = i; j12 > 0; j12--)
                            {
                                double d34 = ad2[(j3 - 1) + ((j6 + 1) - 1) * j1 + i1];
                                ad2[(j3 - 1) + ((j6 + 1) - 1) * j1 + i1] = d8 * d34 - d21 * ad2[(j3 - 1) + (j6 - 1) * j1 + i1];
                                ad2[(j3 - 1) + (j6 - 1) * j1 + i1] = d21 * d34 + d8 * ad2[(j3 - 1) + (j6 - 1) * j1 + i1];
                                j3++;
                            }

                        }
                        j6--;
                    }

                }
            } else
            if(Lsame.lsame(s1, "T"))
            {
                if(Lsame.lsame(s2, "F"))
                {
                    int k6 = 2;
                    for(int k9 = j - 1; k9 > 0; k9--)
                    {
                        double d9 = ad[(k6 - 2) + k];
                        double d22 = ad1[(k6 - 2) + l];
                        if((d9 != 1.0) || (d22 != 0.0))
                        {
                            int k3 = 1;
                            for(int k12 = i; k12 > 0; k12--)
                            {
                                double d35 = ad2[(k3 - 1) + (k6 - 1) * j1 + i1];
                                ad2[(k3 - 1) + (k6 - 1) * j1 + i1] = d9 * d35 - d22 * ad2[(k3 - 1) + i1];
                                ad2[(k3 - 1) + i1] = d22 * d35 + d9 * ad2[(k3 - 1) + i1];
                                k3++;
                            }

                        }
                        k6++;
                    }

                } else
                if(Lsame.lsame(s2, "B"))
                {
                    int l6 = j;
                    for(int l9 = ((2 - j) + -1) / -1; l9 > 0; l9--)
                    {
                        double d10 = ad[(l6 - 1 - 1) + k];
                        double d23 = ad1[(l6 - 1 - 1) + l];
                        if((d10 != 1.0) || (d23 != 0.0))
                        {
                            int l3 = 1;
                            for(int l12 = i; l12 > 0; l12--)
                            {
                                double d36 = ad2[(l3 - 1) + (l6 - 1) * j1 + i1];
                                ad2[(l3 - 1) + (l6 - 1) * j1 + i1] = d10 * d36 - d23 * ad2[(l3 - 1) + i1];
                                ad2[(l3 - 1) + i1] = d23 * d36 + d10 * ad2[(l3 - 1) + i1];
                                l3++;
                            }

                        }
                        l6--;
                    }

                }
            } else
            if(Lsame.lsame(s1, "B"))
                if(Lsame.lsame(s2, "F"))
                {
                    int i7 = 1;
                    for(int i10 = j - 1; i10 > 0; i10--)
                    {
                        double d11 = ad[(i7 - 1) + k];
                        double d24 = ad1[(i7 - 1) + l];
                        if((d11 != 1.0) || (d24 != 0.0))
                        {
                            int i4 = 1;
                            for(int i13 = i; i13 > 0; i13--)
                            {
                                double d37 = ad2[(i4 - 1) + (i7 - 1) * j1 + i1];
                                ad2[(i4 - 1) + (i7 - 1) * j1 + i1] = d24 * ad2[(i4 - 1) + (j - 1) * j1 + i1] + d11 * d37;
                                ad2[(i4 - 1) + (j - 1) * j1 + i1] = d11 * ad2[(i4 - 1) + (j - 1) * j1 + i1] - d24 * d37;
                                i4++;
                            }

                        }
                        i7++;
                    }

                } else
                if(Lsame.lsame(s2, "B"))
                {
                    int j7 = j - 1;
                    for(int j10 = ((1 - (j - 1)) + -1) / -1; j10 > 0; j10--)
                    {
                        double d12 = ad[(j7 - 1) + k];
                        double d25 = ad1[(j7 - 1) + l];
                        if((d12 != 1.0) || (d25 != 0.0))
                        {
                            int j4 = 1;
                            for(int j13 = i; j13 > 0; j13--)
                            {
                                double d38 = ad2[(j4 - 1) + (j7 - 1) * j1 + i1];
                                ad2[(j4 - 1) + (j7 - 1) * j1 + i1] = d25 * ad2[(j4 - 1) + (j - 1) * j1 + i1] + d12 * d38;
                                ad2[(j4 - 1) + (j - 1) * j1 + i1] = d12 * ad2[(j4 - 1) + (j - 1) * j1 + i1] - d25 * d38;
                                j4++;
                            }

                        }
                        j7--;
                    }

                }
    }
}


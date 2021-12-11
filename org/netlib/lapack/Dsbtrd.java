package org.netlib.lapack;

import org.netlib.blas.Drot;
import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dsbtrd
{
    public static void dsbtrd(String s, String s1, int i, int j, double ad[], int k, int l, double ad1[], 
            int i1, double ad2[], int j1, double ad3[], int k1, int l1, double ad4[], 
            int i2, intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        int j5 = 0;
        int k5 = 0;
        int l6 = 0;
        int i12 = 0;
        int j12 = 0;
        int k12 = 0;
        doubleW doublew = new doubleW(0.0D);
        flag = Lsame.lsame(s, "V");
        flag2 = flag || Lsame.lsame(s, "U");
        flag1 = Lsame.lsame(s1, "U");
        i12 = j + 1;
        j12 = j - 1;
        k5 = l - 1;
        l6 = 1;
        intw.val = 0;
        if(flag2 ^ true && Lsame.lsame(s, "N") ^ true)
            intw.val = -1;
        else
        if(flag1 ^ true && Lsame.lsame(s1, "L") ^ true)
            intw.val = -2;
        else
        if(i < 0)
            intw.val = -3;
        else
        if(j < 0)
            intw.val = -4;
        else
        if(l < i12)
            intw.val = -6;
        else
        if((l1 < Math.max(1, i)) && flag2)
            intw.val = -10;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DSBTRD", -intw.val);
            return;
        }
        if(i == 0)
            return;
        if(flag)
            Dlaset.dlaset("Full", i, i, 0.0D, 1.0D, ad3, k1, l1);
        j5 = i12 * l;
        k12 = Math.min(i - 1, j);
        if(flag1)
        {
            if(j > 1)
            {
                int j15 = 0;
                int k8 = k12 + 2;
                int l9 = 1;
                int j2 = 1;
                for(int j16 = (i - 2 - 1) + 1; j16 > 0; j16--)
                {
                    int k11 = k12 + 1;
                    for(int j18 = ((2 - (k12 + 1)) + -1) / -1; j18 > 0; j18--)
                    {
                        k8 += k12;
                        l9 += k12;
                        if(j15 > 0)
                        {
                            Dlargv.dlargv(j15, ad, (1 - 1) + (k8 - 1 - 1) * l + k, j5, ad4, (k8 - 1) + i2, i12, ad1, (k8 - 1) + i1, i12);
                            if(j15 >= 2 * j - 1)
                            {
                                int l12 = 1;
                                for(int l18 = (j - 1 - 1) + 1; l18 > 0; l18--)
                                {
                                    Dlartv.dlartv(j15, ad, ((l12 + 1) - 1) + (k8 - 1 - 1) * l + k, j5, ad, (l12 - 1) + (k8 - 1) * l + k, j5, ad1, (k8 - 1) + i1, ad4, (k8 - 1) + i2, i12);
                                    l12++;
                                }

                            } else
                            {
                                int j10 = k8 + (j15 - 1) * i12;
                                int i11 = k8;
                                for(int i19 = ((j10 - k8) + i12) / i12; i19 > 0; i19--)
                                {
                                    Drot.drot(j12, ad, (2 - 1) + (i11 - 1 - 1) * l + k, 1, ad, (1 - 1) + (i11 - 1) * l + k, 1, ad1[(i11 - 1) + i1], ad4[(i11 - 1) + i2]);
                                    i11 += i12;
                                }

                            }
                        }
                        if(k11 > 2)
                        {
                            if(k11 <= (i - j2) + 1)
                            {
                                dlartg_adapter(ad[(((j - k11) + 3) - 1) + ((j2 + k11) - 2 - 1) * l + k], ad[(((j - k11) + 2) - 1) + ((j2 + k11) - 1 - 1) * l + k], ad1, ((j2 + k11) - 1 - 1) + i1, ad4, ((j2 + k11) - 1 - 1) + i2, doublew);
                                ad[(((j - k11) + 3) - 1) + ((j2 + k11) - 2 - 1) * l + k] = doublew.val;
                                Drot.drot(k11 - 3, ad, (((j - k11) + 4) - 1) + ((j2 + k11) - 2 - 1) * l + k, 1, ad, (((j - k11) + 3) - 1) + ((j2 + k11) - 1 - 1) * l + k, 1, ad1[((j2 + k11) - 1 - 1) + i1], ad4[((j2 + k11) - 1 - 1) + i2]);
                            }
                            j15++;
                            k8 = k8 - k12 - 1;
                        }
                        if(j15 > 0)
                            Dlar2v.dlar2v(j15, ad, (i12 - 1) + (k8 - 1 - 1) * l + k, ad, (i12 - 1) + (k8 - 1) * l + k, ad, (j - 1) + (k8 - 1) * l + k, j5, ad1, (k8 - 1) + i1, ad4, (k8 - 1) + i2, i12);
                        if(j15 > 0)
                            if(2 * j - 1 < j15)
                            {
                                int i13 = 1;
                                for(int j19 = (j - 1 - 1) + 1; j19 > 0; j19--)
                                {
                                    int l15;
                                    if(l9 + i13 > i)
                                        l15 = j15 - 1;
                                    else
                                        l15 = j15;
                                    if(l15 > 0)
                                        Dlartv.dlartv(l15, ad, (j - i13 - 1) + ((k8 + i13) - 1) * l + k, j5, ad, (((j - i13) + 1) - 1) + ((k8 + i13) - 1) * l + k, j5, ad1, (k8 - 1) + i1, ad4, (k8 - 1) + i2, i12);
                                    i13++;
                                }

                            } else
                            {
                                int i9 = k8 + i12 * (j15 - 2);
                                if(i9 >= k8)
                                {
                                    int l10 = k8;
                                    for(int k19 = ((i9 - k8) + i12) / i12; k19 > 0; k19--)
                                    {
                                        Drot.drot(j - 1, ad, (j - 1 - 1) + ((l10 + 1) - 1) * l + k, k5, ad, (j - 1) + ((l10 + 1) - 1) * l + k, k5, ad1[(l10 - 1) + i1], ad4[(l10 - 1) + i2]);
                                        l10 += i12;
                                    }

                                }
                                int j14 = Math.min(j12, i - l9);
                                int l13 = i9 + i12;
                                if(j14 > 0)
                                    Drot.drot(j14, ad, (j - 1 - 1) + ((l13 + 1) - 1) * l + k, k5, ad, (j - 1) + ((l13 + 1) - 1) * l + k, k5, ad1[(l13 - 1) + i1], ad4[(l13 - 1) + i2]);
                            }
                        if(flag2)
                            if(flag)
                            {
                                l6 = Math.max(l6, l9);
                                int j4 = Math.max(0, k11 - 3);
                                int l5 = 1 + j2 * j;
                                if(k11 == 2)
                                    l5 += j;
                                l5 = Math.min(l5, l6);
                                int i7 = k8;
                                for(int l19 = ((l9 - k8) + i12) / i12; l19 > 0; l19--)
                                {
                                    int l4 = j2 - j4 / j12;
                                    j4++;
                                    int j6 = Math.max(1, i7 - l4);
                                    int l14 = (1 + l5) - j6;
                                    l5 = Math.min(l5 + j, l6);
                                    Drot.drot(l14, ad3, (j6 - 1) + (i7 - 1 - 1) * l1 + k1, 1, ad3, (j6 - 1) + (i7 - 1) * l1 + k1, 1, ad1[(i7 - 1) + i1], ad4[(i7 - 1) + i2]);
                                    i7 += i12;
                                }

                            } else
                            {
                                int j7 = k8;
                                for(int i20 = ((l9 - k8) + i12) / i12; i20 > 0; i20--)
                                {
                                    Drot.drot(i, ad3, (1 - 1) + (j7 - 1 - 1) * l1 + k1, 1, ad3, (1 - 1) + (j7 - 1) * l1 + k1, 1, ad1[(j7 - 1) + i1], ad4[(j7 - 1) + i2]);
                                    j7 += i12;
                                }

                            }
                        if(l9 + k12 > i)
                        {
                            j15--;
                            l9 = l9 - k12 - 1;
                        }
                        int k7 = k8;
                        for(int j20 = ((l9 - k8) + i12) / i12; j20 > 0; j20--)
                        {
                            ad4[((k7 + j) - 1) + i2] = ad4[(k7 - 1) + i2] * ad[(1 - 1) + ((k7 + j) - 1) * l + k];
                            ad[(1 - 1) + ((k7 + j) - 1) * l + k] = ad1[(k7 - 1) + i1] * ad[(1 - 1) + ((k7 + j) - 1) * l + k];
                            k7 += i12;
                        }

                        k11--;
                    }

                    j2++;
                }

            }
            if(j > 0)
            {
                int k2 = 1;
                for(int k16 = (i - 1 - 1) + 1; k16 > 0; k16--)
                {
                    ad2[(k2 - 1) + j1] = ad[(j - 1) + ((k2 + 1) - 1) * l + k];
                    k2++;
                }

            } else
            {
                int l2 = 1;
                for(int l16 = (i - 1 - 1) + 1; l16 > 0; l16--)
                {
                    ad2[(l2 - 1) + j1] = 0.0D;
                    l2++;
                }

            }
            int i3 = 1;
            for(int i17 = (i - 1) + 1; i17 > 0; i17--)
            {
                ad1[(i3 - 1) + i1] = ad[(i12 - 1) + (i3 - 1) * l + k];
                i3++;
            }

        } else
        {
            if(j > 1)
            {
                int k15 = 0;
                int l8 = k12 + 2;
                int i10 = 1;
                int j3 = 1;
                for(int j17 = (i - 2 - 1) + 1; j17 > 0; j17--)
                {
                    int l11 = k12 + 1;
                    for(int k18 = ((2 - (k12 + 1)) + -1) / -1; k18 > 0; k18--)
                    {
                        l8 += k12;
                        i10 += k12;
                        if(k15 > 0)
                        {
                            Dlargv.dlargv(k15, ad, (i12 - 1) + (l8 - i12 - 1) * l + k, j5, ad4, (l8 - 1) + i2, i12, ad1, (l8 - 1) + i1, i12);
                            if(k15 > 2 * j - 1)
                            {
                                int j13 = 1;
                                for(int k20 = (j - 1 - 1) + 1; k20 > 0; k20--)
                                {
                                    Dlartv.dlartv(k15, ad, (i12 - j13 - 1) + (((l8 - i12) + j13) - 1) * l + k, j5, ad, (((i12 - j13) + 1) - 1) + (((l8 - i12) + j13) - 1) * l + k, j5, ad1, (l8 - 1) + i1, ad4, (l8 - 1) + i2, i12);
                                    j13++;
                                }

                            } else
                            {
                                int k10 = l8 + i12 * (k15 - 1);
                                int j11 = l8;
                                for(int l20 = ((k10 - l8) + i12) / i12; l20 > 0; l20--)
                                {
                                    Drot.drot(j12, ad, (j - 1) + (j11 - j - 1) * l + k, k5, ad, (i12 - 1) + (j11 - j - 1) * l + k, k5, ad1[(j11 - 1) + i1], ad4[(j11 - 1) + i2]);
                                    j11 += i12;
                                }

                            }
                        }
                        if(l11 > 2)
                        {
                            if(l11 <= (i - j3) + 1)
                            {
                                dlartg_adapter(ad[(l11 - 1 - 1) + (j3 - 1) * l + k], ad[(l11 - 1) + (j3 - 1) * l + k], ad1, ((j3 + l11) - 1 - 1) + i1, ad4, ((j3 + l11) - 1 - 1) + i2, doublew);
                                ad[(l11 - 1 - 1) + (j3 - 1) * l + k] = doublew.val;
                                Drot.drot(l11 - 3, ad, (l11 - 2 - 1) + ((j3 + 1) - 1) * l + k, l - 1, ad, (l11 - 1 - 1) + ((j3 + 1) - 1) * l + k, l - 1, ad1[((j3 + l11) - 1 - 1) + i1], ad4[((j3 + l11) - 1 - 1) + i2]);
                            }
                            k15++;
                            l8 = l8 - k12 - 1;
                        }
                        if(k15 > 0)
                            Dlar2v.dlar2v(k15, ad, (1 - 1) + (l8 - 1 - 1) * l + k, ad, (1 - 1) + (l8 - 1) * l + k, ad, (2 - 1) + (l8 - 1 - 1) * l + k, j5, ad1, (l8 - 1) + i1, ad4, (l8 - 1) + i2, i12);
                        if(k15 > 0)
                            if(k15 > 2 * j - 1)
                            {
                                int k13 = 1;
                                for(int i21 = (j - 1 - 1) + 1; i21 > 0; i21--)
                                {
                                    int i16;
                                    if(i10 + k13 > i)
                                        i16 = k15 - 1;
                                    else
                                        i16 = k15;
                                    if(i16 > 0)
                                        Dlartv.dlartv(i16, ad, ((k13 + 2) - 1) + (l8 - 1 - 1) * l + k, j5, ad, ((k13 + 1) - 1) + (l8 - 1) * l + k, j5, ad1, (l8 - 1) + i1, ad4, (l8 - 1) + i2, i12);
                                    k13++;
                                }

                            } else
                            {
                                int j9 = l8 + i12 * (k15 - 2);
                                if(j9 >= l8)
                                {
                                    int k9 = l8;
                                    for(int j21 = ((j9 - l8) + i12) / i12; j21 > 0; j21--)
                                    {
                                        Drot.drot(j12, ad, (3 - 1) + (k9 - 1 - 1) * l + k, 1, ad, (2 - 1) + (k9 - 1) * l + k, 1, ad1[(k9 - 1) + i1], ad4[(k9 - 1) + i2]);
                                        k9 += i12;
                                    }

                                }
                                int k14 = Math.min(j12, i - i10);
                                int i14 = j9 + i12;
                                if(k14 > 0)
                                    Drot.drot(k14, ad, (3 - 1) + (i14 - 1 - 1) * l + k, 1, ad, (2 - 1) + (i14 - 1) * l + k, 1, ad1[(i14 - 1) + i1], ad4[(i14 - 1) + i2]);
                            }
                        if(flag2)
                            if(flag)
                            {
                                l6 = Math.max(l6, i10);
                                int k4 = Math.max(0, l11 - 3);
                                int i6 = 1 + j3 * j;
                                if(l11 == 2)
                                    i6 += j;
                                i6 = Math.min(i6, l6);
                                int l7 = l8;
                                for(int k21 = ((i10 - l8) + i12) / i12; k21 > 0; k21--)
                                {
                                    int i5 = j3 - k4 / j12;
                                    k4++;
                                    int k6 = Math.max(1, l7 - i5);
                                    int i15 = (1 + i6) - k6;
                                    i6 = Math.min(i6 + j, l6);
                                    Drot.drot(i15, ad3, (k6 - 1) + (l7 - 1 - 1) * l1 + k1, 1, ad3, (k6 - 1) + (l7 - 1) * l1 + k1, 1, ad1[(l7 - 1) + i1], ad4[(l7 - 1) + i2]);
                                    l7 += i12;
                                }

                            } else
                            {
                                int i8 = l8;
                                for(int l21 = ((i10 - l8) + i12) / i12; l21 > 0; l21--)
                                {
                                    Drot.drot(i, ad3, (1 - 1) + (i8 - 1 - 1) * l1 + k1, 1, ad3, (1 - 1) + (i8 - 1) * l1 + k1, 1, ad1[(i8 - 1) + i1], ad4[(i8 - 1) + i2]);
                                    i8 += i12;
                                }

                            }
                        if(i10 + k12 > i)
                        {
                            k15--;
                            i10 = i10 - k12 - 1;
                        }
                        int j8 = l8;
                        for(int i22 = ((i10 - l8) + i12) / i12; i22 > 0; i22--)
                        {
                            ad4[((j8 + j) - 1) + i2] = ad4[(j8 - 1) + i2] * ad[(i12 - 1) + (j8 - 1) * l + k];
                            ad[(i12 - 1) + (j8 - 1) * l + k] = ad1[(j8 - 1) + i1] * ad[(i12 - 1) + (j8 - 1) * l + k];
                            j8 += i12;
                        }

                        l11--;
                    }

                    j3++;
                }

            }
            if(j > 0)
            {
                int k3 = 1;
                for(int k17 = i - 1; k17 > 0; k17--)
                {
                    ad2[(k3 - 1) + j1] = ad[(2 - 1) + (k3 - 1) * l + k];
                    k3++;
                }

            } else
            {
                int l3 = 1;
                for(int l17 = i - 1; l17 > 0; l17--)
                {
                    ad2[(l3 - 1) + j1] = 0.0D;
                    l3++;
                }

            }
            int i4 = 1;
            for(int i18 = i; i18 > 0; i18--)
            {
                ad1[(i4 - 1) + i1] = ad[(i4 - 1) * l + k];
                i4++;
            }

        }
    }

    private static void dlartg_adapter(double d, double d1, double ad[], int i, double ad1[], int j, 
            doubleW doublew)
    {
        doubleW doublew1 = new doubleW(ad[i]);
        doubleW doublew2 = new doubleW(ad1[j]);
        Dlartg.dlartg(d, d1, doublew1, doublew2, doublew);
        ad[i] = doublew1.val;
        ad1[j] = doublew2.val;
    }
}

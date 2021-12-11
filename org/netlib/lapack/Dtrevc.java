package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.*;

public final class Dtrevc
{
    public static void dtrevc(String s, String s1, boolean aflag[], int i, int j, double ad[], int k, int l, 
            double ad1[], int i1, int j1, double ad2[], int k1, int l1, int i2, 
            intW intw, double ad3[], int j2, intW intw1)
    {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag6 = false;
        boolean flag7 = false;
        intW intw2 = new intW(0);
        int k4 = 0;
        int l11 = 0;
        double d5 = 0.0D;
        doubleW doublew = new doubleW(0.0D);
        doubleW doublew1 = new doubleW(0.0D);
        double d29 = 0.0D;
        double d30 = 0.0D;
        doubleW doublew2 = new doubleW(0.0D);
        doubleW doublew3 = new doubleW(0.0D);
        double ad4[] = new double[2 * 2];
        flag1 = Lsame.lsame(s, "B");
        flag6 = Lsame.lsame(s, "R") || flag1;
        flag2 = Lsame.lsame(s, "L") || flag1;
        flag = Lsame.lsame(s1, "A");
        flag3 = Lsame.lsame(s1, "B");
        flag7 = Lsame.lsame(s1, "S");
        intw1.val = 0;
        if(flag6 ^ true && flag2 ^ true)
            intw1.val = -1;
        else
        if((flag ^ true && flag3 ^ true) && flag7 ^ true)
            intw1.val = -2;
        else
        if(j < 0)
            intw1.val = -4;
        else
        if(l < Math.max(1, j))
            intw1.val = -6;
        else
        if((j1 < 1) || (flag2 && (j1 < j)))
            intw1.val = -8;
        else
        if((l1 < 1) || (flag6 && (l1 < j)))
        {
            intw1.val = -10;
        } else
        {
            if(flag7)
            {
                intw.val = 0;
                boolean flag5 = false;
                k4 = 1;
                for(int i12 = (j - 1) + 1; i12 > 0; i12--)
                {
                    if(flag5)
                    {
                        flag5 = false;
                        aflag[(k4 - 1) + i] = false;
                    } else
                    if(k4 < j)
                    {
                        if(ad[((k4 + 1) - 1) + (k4 - 1) * l + k] == 0.0D)
                        {
                            if(aflag[(k4 - 1) + i])
                                intw.val = intw.val + 1;
                        } else
                        {
                            flag5 = true;
                            if(aflag[(k4 - 1) + i] || aflag[((k4 + 1) - 1) + i])
                            {
                                aflag[(k4 - 1) + i] = true;
                                intw.val = intw.val + 2;
                            }
                        }
                    } else
                    if(aflag[(j - 1) + i])
                        intw.val = intw.val + 1;
                    k4++;
                }

            } else
            {
                intw.val = j;
            }
            if(i2 < intw.val)
                intw1.val = -11;
        }
        if(intw1.val != 0)
        {
            Xerbla.xerbla("DTREVC", -intw1.val);
            return;
        }
        if(j == 0)
            return;
        doublew2.val = Dlamch.dlamch("Safe minimum");
        doublew.val = 1.0D / doublew2.val;
        Dlabad.dlabad(doublew2, doublew);
        d30 = Dlamch.dlamch("Precision");
        d29 = doublew2.val * ((double)j / d30);
        d5 = (1.0D - d30) / d29;
        ad3[(1 - 1) + j2] = 0.0D;
        k4 = 2;
        for(int j12 = (j - 2) + 1; j12 > 0; j12--)
        {
            ad3[(k4 - 1) + j2] = 0.0D;
            int k2 = 1;
            for(int i13 = (k4 - 1 - 1) + 1; i13 > 0; i13--)
            {
                ad3[(k4 - 1) + j2] = ad3[(k4 - 1) + j2] + Math.abs(ad[(k2 - 1) + (k4 - 1) * l + k]);
                k2++;
            }

            k4++;
        }

        l11 = 2 * j;
        if(flag6)
        {
            byte byte0 = 0;
            int i4 = intw.val;
            int j11 = j;
            for(int k12 = ((1 - j) + -1) / -1; k12 > 0; k12--)
            {
                if(byte0 != 1)
                {
                    if((j11 != 1) && (ad[(j11 - 1) + (j11 - 1 - 1) * l + k] != 0.0D))
                        byte0 = -1;
                    if(!flag7 || ((byte0 != 0) ? !(aflag[(j11 - 1 - 1) + i] ^ true) : !(aflag[(j11 - 1) + i] ^ true)))
                    {
                        double d41 = ad[(j11 - 1) + (j11 - 1) * l + k];
                        double d38 = 0.0D;
                        if(byte0 != 0)
                            d38 = Math.sqrt(Math.abs(ad[(j11 - 1) + (j11 - 1 - 1) * l + k])) * Math.sqrt(Math.abs(ad[(j11 - 1 - 1) + (j11 - 1) * l + k]));
                        double d27 = Math.max(d30 * (Math.abs(d41) + Math.abs(d38)), d29);
                        if(byte0 == 0)
                        {
                            ad3[((j11 + j) - 1) + j2] = 1.0D;
                            int l8 = 1;
                            for(int j13 = (j11 - 1 - 1) + 1; j13 > 0; j13--)
                            {
                                ad3[((l8 + j) - 1) + j2] = -ad[(l8 - 1) + (j11 - 1) * l + k];
                                l8++;
                            }

                            int l7 = j11 - 1;
                            int l4 = j11 - 1;
                            for(int k13 = ((1 - (j11 - 1)) + -1) / -1; k13 > 0; k13--)
                            {
                                if(l4 <= l7)
                                {
                                    int l5 = l4;
                                    int l6 = l4;
                                    l7 = l4 - 1;
                                    if((l4 > 1) && (ad[(l4 - 1) + (l4 - 1 - 1) * l + k] != 0.0D))
                                    {
                                        l5 = l4 - 1;
                                        l7 = l4 - 2;
                                    }
                                    if(l5 == l6)
                                    {
                                        Dlaln2.dlaln2(false, 1, 1, d27, 1.0D, ad, (l4 - 1) + (l4 - 1) * l + k, l, 1.0D, 1.0D, ad3, ((l4 + j) - 1) + j2, j, d41, 0.0D, ad4, 0, 2, doublew1, doublew3, intw2);
                                        if((doublew3.val > 1.0D) && (ad3[(l4 - 1) + j2] > d5 / doublew3.val))
                                        {
                                            ad4[(1 - 1) + (1 - 1) * 2] = ad4[(1 - 1) + (1 - 1) * 2] / doublew3.val;
                                            doublew1.val = doublew1.val / doublew3.val;
                                        }
                                        if(doublew1.val != 1.0D)
                                            Dscal.dscal(j11, doublew1.val, ad3, ((1 + j) - 1) + j2, 1);
                                        ad3[((l4 + j) - 1) + j2] = ad4[(1 - 1) + (1 - 1) * 2];
                                        Daxpy.daxpy(l4 - 1, -ad4[(1 - 1) + (1 - 1) * 2], ad, (1 - 1) + (l4 - 1) * l + k, 1, ad3, ((1 + j) - 1) + j2, 1);
                                    } else
                                    {
                                        Dlaln2.dlaln2(false, 2, 1, d27, 1.0D, ad, (l4 - 1 - 1) + (l4 - 1 - 1) * l + k, l, 1.0D, 1.0D, ad3, (((l4 - 1) + j) - 1) + j2, j, d41, 0.0D, ad4, 0, 2, doublew1, doublew3, intw2);
                                        if(doublew3.val > 1.0D)
                                        {
                                            double d1 = Math.max(ad3[(l4 - 1 - 1) + j2], ad3[(l4 - 1) + j2]);
                                            if(d1 > d5 / doublew3.val)
                                            {
                                                ad4[(1 - 1) + (1 - 1) * 2] = ad4[(1 - 1) + (1 - 1) * 2] / doublew3.val;
                                                ad4[(2 - 1) + (1 - 1) * 2] = ad4[(2 - 1) + (1 - 1) * 2] / doublew3.val;
                                                doublew1.val = doublew1.val / doublew3.val;
                                            }
                                        }
                                        if(doublew1.val != 1.0D)
                                            Dscal.dscal(j11, doublew1.val, ad3, ((1 + j) - 1) + j2, 1);
                                        ad3[(((l4 - 1) + j) - 1) + j2] = ad4[(1 - 1) + (1 - 1) * 2];
                                        ad3[((l4 + j) - 1) + j2] = ad4[(2 - 1) + (1 - 1) * 2];
                                        Daxpy.daxpy(l4 - 2, -ad4[(1 - 1) + (1 - 1) * 2], ad, (1 - 1) + (l4 - 1 - 1) * l + k, 1, ad3, ((1 + j) - 1) + j2, 1);
                                        Daxpy.daxpy(l4 - 2, -ad4[(2 - 1) + (1 - 1) * 2], ad, (1 - 1) + (l4 - 1) * l + k, 1, ad3, ((1 + j) - 1) + j2, 1);
                                    }
                                }
                                l4--;
                            }

                            if(flag3 ^ true)
                            {
                                Dcopy.dcopy(j11, ad3, ((1 + j) - 1) + j2, 1, ad2, (1 - 1) + (i4 - 1) * l1 + k1, 1);
                                int l2 = Idamax.idamax(j11, ad2, (1 - 1) + (i4 - 1) * l1 + k1, 1);
                                double d18 = 1.0D / Math.abs(ad2[(l2 - 1) + (i4 - 1) * l1 + k1]);
                                Dscal.dscal(j11, d18, ad2, (1 - 1) + (i4 - 1) * l1 + k1, 1);
                                int i9 = j11 + 1;
                                for(int l13 = (j - (j11 + 1)) + 1; l13 > 0; l13--)
                                {
                                    ad2[(i9 - 1) + (i4 - 1) * l1 + k1] = 0.0D;
                                    i9++;
                                }

                            } else
                            {
                                if(j11 > 1)
                                    Dgemv.dgemv("N", j, j11 - 1, 1.0D, ad2, k1, l1, ad3, ((1 + j) - 1) + j2, 1, ad3[((j11 + j) - 1) + j2], ad2, (1 - 1) + (j11 - 1) * l1 + k1, 1);
                                int i3 = Idamax.idamax(j, ad2, (1 - 1) + (j11 - 1) * l1 + k1, 1);
                                double d19 = 1.0D / Math.abs(ad2[(i3 - 1) + (j11 - 1) * l1 + k1]);
                                Dscal.dscal(j, d19, ad2, (1 - 1) + (j11 - 1) * l1 + k1, 1);
                            }
                        } else
                        {
                            if(Math.abs(ad[(j11 - 1 - 1) + (j11 - 1) * l + k]) >= Math.abs(ad[(j11 - 1) + (j11 - 1 - 1) * l + k]))
                            {
                                ad3[(((j11 - 1) + j) - 1) + j2] = 1.0D;
                                ad3[((j11 + l11) - 1) + j2] = d38 / ad[(j11 - 1 - 1) + (j11 - 1) * l + k];
                            } else
                            {
                                ad3[(((j11 - 1) + j) - 1) + j2] = -(d38 / ad[(j11 - 1) + (j11 - 1 - 1) * l + k]);
                                ad3[((j11 + l11) - 1) + j2] = 1.0D;
                            }
                            ad3[((j11 + j) - 1) + j2] = 0.0D;
                            ad3[(((j11 - 1) + l11) - 1) + j2] = 0.0D;
                            int j9 = 1;
                            for(int i14 = (j11 - 2 - 1) + 1; i14 > 0; i14--)
                            {
                                ad3[((j9 + j) - 1) + j2] = -(ad3[(((j11 - 1) + j) - 1) + j2] * ad[(j9 - 1) + (j11 - 1 - 1) * l + k]);
                                ad3[((j9 + l11) - 1) + j2] = -(ad3[((j11 + l11) - 1) + j2] * ad[(j9 - 1) + (j11 - 1) * l + k]);
                                j9++;
                            }

                            int i8 = j11 - 2;
                            int i5 = j11 - 2;
                            for(int j14 = ((1 - (j11 - 2)) + -1) / -1; j14 > 0; j14--)
                            {
                                if(i5 <= i8)
                                {
                                    int i6 = i5;
                                    int i7 = i5;
                                    i8 = i5 - 1;
                                    if((i5 > 1) && (ad[(i5 - 1) + (i5 - 1 - 1) * l + k] != 0.0D))
                                    {
                                        i6 = i5 - 1;
                                        i8 = i5 - 2;
                                    }
                                    if(i6 == i7)
                                    {
                                        Dlaln2.dlaln2(false, 1, 2, d27, 1.0D, ad, (i5 - 1) + (i5 - 1) * l + k, l, 1.0D, 1.0D, ad3, ((i5 + j) - 1) + j2, j, d41, d38, ad4, 0, 2, doublew1, doublew3, intw2);
                                        if((doublew3.val > 1.0D) && (ad3[(i5 - 1) + j2] > d5 / doublew3.val))
                                        {
                                            ad4[(1 - 1) + (1 - 1) * 2] = ad4[(1 - 1) + (1 - 1) * 2] / doublew3.val;
                                            ad4[(1 - 1) + (2 - 1) * 2] = ad4[(1 - 1) + (2 - 1) * 2] / doublew3.val;
                                            doublew1.val = doublew1.val / doublew3.val;
                                        }
                                        if(doublew1.val != 1.0D)
                                        {
                                            Dscal.dscal(j11, doublew1.val, ad3, ((1 + j) - 1) + j2, 1);
                                            Dscal.dscal(j11, doublew1.val, ad3, ((1 + l11) - 1) + j2, 1);
                                        }
                                        ad3[((i5 + j) - 1) + j2] = ad4[(1 - 1) + (1 - 1) * 2];
                                        ad3[((i5 + l11) - 1) + j2] = ad4[(1 - 1) + (2 - 1) * 2];
                                        Daxpy.daxpy(i5 - 1, -ad4[(1 - 1) + (1 - 1) * 2], ad, (1 - 1) + (i5 - 1) * l + k, 1, ad3, ((1 + j) - 1) + j2, 1);
                                        Daxpy.daxpy(i5 - 1, -ad4[(1 - 1) + (2 - 1) * 2], ad, (1 - 1) + (i5 - 1) * l + k, 1, ad3, ((1 + l11) - 1) + j2, 1);
                                    } else
                                    {
                                        Dlaln2.dlaln2(false, 2, 2, d27, 1.0D, ad, (i5 - 1 - 1) + (i5 - 1 - 1) * l + k, l, 1.0D, 1.0D, ad3, (((i5 - 1) + j) - 1) + j2, j, d41, d38, ad4, 0, 2, doublew1, doublew3, intw2);
                                        if(doublew3.val > 1.0D)
                                        {
                                            double d2 = Math.max(ad3[(i5 - 1 - 1) + j2], ad3[(i5 - 1) + j2]);
                                            if(d2 > d5 / doublew3.val)
                                            {
                                                double d12 = 1.0D / doublew3.val;
                                                ad4[(1 - 1) + (1 - 1) * 2] = ad4[(1 - 1) + (1 - 1) * 2] * d12;
                                                ad4[(1 - 1) + (2 - 1) * 2] = ad4[(1 - 1) + (2 - 1) * 2] * d12;
                                                ad4[(2 - 1) + (1 - 1) * 2] = ad4[(2 - 1) + (1 - 1) * 2] * d12;
                                                ad4[(2 - 1) + (2 - 1) * 2] = ad4[(2 - 1) + (2 - 1) * 2] * d12;
                                                doublew1.val = doublew1.val * d12;
                                            }
                                        }
                                        if(doublew1.val != 1.0D)
                                        {
                                            Dscal.dscal(j11, doublew1.val, ad3, ((1 + j) - 1) + j2, 1);
                                            Dscal.dscal(j11, doublew1.val, ad3, ((1 + l11) - 1) + j2, 1);
                                        }
                                        ad3[(((i5 - 1) + j) - 1) + j2] = ad4[(1 - 1) + (1 - 1) * 2];
                                        ad3[((i5 + j) - 1) + j2] = ad4[(2 - 1) + (1 - 1) * 2];
                                        ad3[(((i5 - 1) + l11) - 1) + j2] = ad4[(1 - 1) + (2 - 1) * 2];
                                        ad3[((i5 + l11) - 1) + j2] = ad4[(2 - 1) + (2 - 1) * 2];
                                        Daxpy.daxpy(i5 - 2, -ad4[(1 - 1) + (1 - 1) * 2], ad, (1 - 1) + (i5 - 1 - 1) * l + k, 1, ad3, ((1 + j) - 1) + j2, 1);
                                        Daxpy.daxpy(i5 - 2, -ad4[(2 - 1) + (1 - 1) * 2], ad, (1 - 1) + (i5 - 1) * l + k, 1, ad3, ((1 + j) - 1) + j2, 1);
                                        Daxpy.daxpy(i5 - 2, -ad4[(1 - 1) + (2 - 1) * 2], ad, (1 - 1) + (i5 - 1 - 1) * l + k, 1, ad3, ((1 + l11) - 1) + j2, 1);
                                        Daxpy.daxpy(i5 - 2, -ad4[(2 - 1) + (2 - 1) * 2], ad, (1 - 1) + (i5 - 1) * l + k, 1, ad3, ((1 + l11) - 1) + j2, 1);
                                    }
                                }
                                i5--;
                            }

                            if(flag3 ^ true)
                            {
                                Dcopy.dcopy(j11, ad3, ((1 + j) - 1) + j2, 1, ad2, (1 - 1) + (i4 - 1 - 1) * l1 + k1, 1);
                                Dcopy.dcopy(j11, ad3, ((1 + l11) - 1) + j2, 1, ad2, (1 - 1) + (i4 - 1) * l1 + k1, 1);
                                double d7 = 0.0D;
                                int k9 = 1;
                                for(int k14 = (j11 - 1) + 1; k14 > 0; k14--)
                                {
                                    d7 = Math.max(d7, Math.abs(ad2[(k9 - 1) + (i4 - 1 - 1) * l1 + k1]) + Math.abs(ad2[(k9 - 1) + (i4 - 1) * l1 + k1]));
                                    k9++;
                                }

                                double d20 = 1.0D / d7;
                                Dscal.dscal(j11, d20, ad2, (1 - 1) + (i4 - 1 - 1) * l1 + k1, 1);
                                Dscal.dscal(j11, d20, ad2, (1 - 1) + (i4 - 1) * l1 + k1, 1);
                                k9 = j11 + 1;
                                for(int l14 = (j - (j11 + 1)) + 1; l14 > 0; l14--)
                                {
                                    ad2[(k9 - 1) + (i4 - 1 - 1) * l1 + k1] = 0.0D;
                                    ad2[(k9 - 1) + (i4 - 1) * l1 + k1] = 0.0D;
                                    k9++;
                                }

                            } else
                            {
                                if(j11 > 2)
                                {
                                    Dgemv.dgemv("N", j, j11 - 2, 1.0D, ad2, k1, l1, ad3, ((1 + j) - 1) + j2, 1, ad3[(((j11 - 1) + j) - 1) + j2], ad2, (1 - 1) + (j11 - 1 - 1) * l1 + k1, 1);
                                    Dgemv.dgemv("N", j, j11 - 2, 1.0D, ad2, k1, l1, ad3, ((1 + l11) - 1) + j2, 1, ad3[((j11 + l11) - 1) + j2], ad2, (1 - 1) + (j11 - 1) * l1 + k1, 1);
                                } else
                                {
                                    Dscal.dscal(j, ad3[(((j11 - 1) + j) - 1) + j2], ad2, (1 - 1) + (j11 - 1 - 1) * l1 + k1, 1);
                                    Dscal.dscal(j, ad3[((j11 + l11) - 1) + j2], ad2, (1 - 1) + (j11 - 1) * l1 + k1, 1);
                                }
                                double d8 = 0.0D;
                                int l9 = 1;
                                for(int i15 = (j - 1) + 1; i15 > 0; i15--)
                                {
                                    d8 = Math.max(d8, Math.abs(ad2[(l9 - 1) + (j11 - 1 - 1) * l1 + k1]) + Math.abs(ad2[(l9 - 1) + (j11 - 1) * l1 + k1]));
                                    l9++;
                                }

                                double d21 = 1.0D / d8;
                                Dscal.dscal(j, d21, ad2, (1 - 1) + (j11 - 1 - 1) * l1 + k1, 1);
                                Dscal.dscal(j, d21, ad2, (1 - 1) + (j11 - 1) * l1 + k1, 1);
                            }
                        }
                        i4--;
                        if(byte0 != 0)
                            i4--;
                    }
                }
                if(byte0 == 1)
                    byte0 = 0;
                if(byte0 == -1)
                    byte0 = 1;
                j11--;
            }

        }
        if(flag2)
        {
            int l3 = 0;
            int j4 = 1;
            int k11 = 1;
            for(int l12 = (j - 1) + 1; l12 > 0; l12--)
            {
                if(l3 != -1)
                {
                    if((k11 != j) && (ad[((k11 + 1) - 1) + (k11 - 1) * l + k] != 0.0D))
                        l3 = 1;
                    if(!flag7 || !(aflag[(k11 - 1) + i] ^ true))
                    {
                        double d42 = ad[(k11 - 1) + (k11 - 1) * l + k];
                        double d39 = 0.0D;
                        if(l3 != 0)
                            d39 = Math.sqrt(Math.abs(ad[(k11 - 1) + ((k11 + 1) - 1) * l + k])) * Math.sqrt(Math.abs(ad[((k11 + 1) - 1) + (k11 - 1) * l + k]));
                        double d28 = Math.max(d30 * (Math.abs(d42) + Math.abs(d39)), d29);
                        if(l3 == 0)
                        {
                            ad3[((k11 + j) - 1) + j2] = 1.0D;
                            int i10 = k11 + 1;
                            for(int j15 = (j - (k11 + 1)) + 1; j15 > 0; j15--)
                            {
                                ad3[((i10 + j) - 1) + j2] = -ad[(k11 - 1) + (i10 - 1) * l + k];
                                i10++;
                            }

                            double d35 = 1.0D;
                            double d32 = d5;
                            int j8 = k11 + 1;
                            int j5 = k11 + 1;
                            for(int k15 = (j - (k11 + 1)) + 1; k15 > 0; k15--)
                            {
                                if(j5 >= j8)
                                {
                                    int j6 = j5;
                                    int j7 = j5;
                                    j8 = j5 + 1;
                                    if((j5 < j) && (ad[((j5 + 1) - 1) + (j5 - 1) * l + k] != 0.0D))
                                    {
                                        j7 = j5 + 1;
                                        j8 = j5 + 2;
                                    }
                                    if(j6 == j7)
                                    {
                                        if(ad3[(j5 - 1) + j2] > d32)
                                        {
                                            double d13 = 1.0D / d35;
                                            Dscal.dscal((j - k11) + 1, d13, ad3, ((k11 + j) - 1) + j2, 1);
                                            d35 = 1.0D;
                                            d32 = d5;
                                        }
                                        ad3[((j5 + j) - 1) + j2] = ad3[((j5 + j) - 1) + j2] - Ddot.ddot(j5 - k11 - 1, ad, ((k11 + 1) - 1) + (j5 - 1) * l + k, 1, ad3, ((k11 + 1 + j) - 1) + j2, 1);
                                        Dlaln2.dlaln2(false, 1, 1, d28, 1.0D, ad, (j5 - 1) + (j5 - 1) * l + k, l, 1.0D, 1.0D, ad3, ((j5 + j) - 1) + j2, j, d42, 0.0D, ad4, 0, 2, doublew1, doublew3, intw2);
                                        if(doublew1.val != 1.0D)
                                            Dscal.dscal((j - k11) + 1, doublew1.val, ad3, ((k11 + j) - 1) + j2, 1);
                                        ad3[((j5 + j) - 1) + j2] = ad4[(1 - 1) + (1 - 1) * 2];
                                        d35 = Math.max(Math.abs(ad3[((j5 + j) - 1) + j2]), d35);
                                        d32 = d5 / d35;
                                    } else
                                    {
                                        double d3 = Math.max(ad3[(j5 - 1) + j2], ad3[((j5 + 1) - 1) + j2]);
                                        if(d3 > d32)
                                        {
                                            double d14 = 1.0D / d35;
                                            Dscal.dscal((j - k11) + 1, d14, ad3, ((k11 + j) - 1) + j2, 1);
                                            d35 = 1.0D;
                                            d32 = d5;
                                        }
                                        ad3[((j5 + j) - 1) + j2] = ad3[((j5 + j) - 1) + j2] - Ddot.ddot(j5 - k11 - 1, ad, ((k11 + 1) - 1) + (j5 - 1) * l + k, 1, ad3, ((k11 + 1 + j) - 1) + j2, 1);
                                        ad3[((j5 + 1 + j) - 1) + j2] = ad3[((j5 + 1 + j) - 1) + j2] - Ddot.ddot(j5 - k11 - 1, ad, ((k11 + 1) - 1) + ((j5 + 1) - 1) * l + k, 1, ad3, ((k11 + 1 + j) - 1) + j2, 1);
                                        Dlaln2.dlaln2(true, 2, 1, d28, 1.0D, ad, (j5 - 1) + (j5 - 1) * l + k, l, 1.0D, 1.0D, ad3, ((j5 + j) - 1) + j2, j, d42, 0.0D, ad4, 0, 2, doublew1, doublew3, intw2);
                                        if(doublew1.val != 1.0D)
                                            Dscal.dscal((j - k11) + 1, doublew1.val, ad3, ((k11 + j) - 1) + j2, 1);
                                        ad3[((j5 + j) - 1) + j2] = ad4[(1 - 1) + (1 - 1) * 2];
                                        ad3[((j5 + 1 + j) - 1) + j2] = ad4[(2 - 1) + (1 - 1) * 2];
                                        d35 = Util.max(Math.abs(ad3[((j5 + j) - 1) + j2]), Math.abs(ad3[((j5 + 1 + j) - 1) + j2]), d35);
                                        d32 = d5 / d35;
                                    }
                                }
                                j5++;
                            }

                            if(flag3 ^ true)
                            {
                                Dcopy.dcopy((j - k11) + 1, ad3, ((k11 + j) - 1) + j2, 1, ad1, (k11 - 1) + (j4 - 1) * j1 + i1, 1);
                                int j3 = (Idamax.idamax((j - k11) + 1, ad1, (k11 - 1) + (j4 - 1) * j1 + i1, 1) + k11) - 1;
                                double d22 = 1.0D / Math.abs(ad1[(j3 - 1) + (j4 - 1) * j1 + i1]);
                                Dscal.dscal((j - k11) + 1, d22, ad1, (k11 - 1) + (j4 - 1) * j1 + i1, 1);
                                int j10 = 1;
                                for(int l15 = (k11 - 1 - 1) + 1; l15 > 0; l15--)
                                {
                                    ad1[(j10 - 1) + (j4 - 1) * j1 + i1] = 0.0D;
                                    j10++;
                                }

                            } else
                            {
                                if(k11 < j)
                                    Dgemv.dgemv("N", j, j - k11, 1.0D, ad1, (1 - 1) + ((k11 + 1) - 1) * j1 + i1, j1, ad3, ((k11 + 1 + j) - 1) + j2, 1, ad3[((k11 + j) - 1) + j2], ad1, (1 - 1) + (k11 - 1) * j1 + i1, 1);
                                int k3 = Idamax.idamax(j, ad1, (1 - 1) + (k11 - 1) * j1 + i1, 1);
                                double d23 = 1.0D / Math.abs(ad1[(k3 - 1) + (k11 - 1) * j1 + i1]);
                                Dscal.dscal(j, d23, ad1, (1 - 1) + (k11 - 1) * j1 + i1, 1);
                            }
                        } else
                        {
                            if(Math.abs(ad[(k11 - 1) + ((k11 + 1) - 1) * l + k]) >= Math.abs(ad[((k11 + 1) - 1) + (k11 - 1) * l + k]))
                            {
                                ad3[((k11 + j) - 1) + j2] = d39 / ad[(k11 - 1) + ((k11 + 1) - 1) * l + k];
                                ad3[((k11 + 1 + l11) - 1) + j2] = 1.0D;
                            } else
                            {
                                ad3[((k11 + j) - 1) + j2] = 1.0D;
                                ad3[((k11 + 1 + l11) - 1) + j2] = -(d39 / ad[((k11 + 1) - 1) + (k11 - 1) * l + k]);
                            }
                            ad3[((k11 + 1 + j) - 1) + j2] = 0.0D;
                            ad3[((k11 + l11) - 1) + j2] = 0.0D;
                            int k10 = k11 + 2;
                            for(int i16 = (j - (k11 + 2)) + 1; i16 > 0; i16--)
                            {
                                ad3[((k10 + j) - 1) + j2] = -(ad3[((k11 + j) - 1) + j2] * ad[(k11 - 1) + (k10 - 1) * l + k]);
                                ad3[((k10 + l11) - 1) + j2] = -(ad3[((k11 + 1 + l11) - 1) + j2] * ad[((k11 + 1) - 1) + (k10 - 1) * l + k]);
                                k10++;
                            }

                            double d36 = 1.0D;
                            double d33 = d5;
                            int k8 = k11 + 2;
                            int k5 = k11 + 2;
                            for(int j16 = (j - (k11 + 2)) + 1; j16 > 0; j16--)
                            {
                                if(k5 >= k8)
                                {
                                    int k6 = k5;
                                    int k7 = k5;
                                    k8 = k5 + 1;
                                    if((k5 < j) && (ad[((k5 + 1) - 1) + (k5 - 1) * l + k] != 0.0D))
                                    {
                                        k7 = k5 + 1;
                                        k8 = k5 + 2;
                                    }
                                    if(k6 == k7)
                                    {
                                        if(ad3[(k5 - 1) + j2] > d33)
                                        {
                                            double d15 = 1.0D / d36;
                                            Dscal.dscal((j - k11) + 1, d15, ad3, ((k11 + j) - 1) + j2, 1);
                                            Dscal.dscal((j - k11) + 1, d15, ad3, ((k11 + l11) - 1) + j2, 1);
                                            d36 = 1.0D;
                                            d33 = d5;
                                        }
                                        ad3[((k5 + j) - 1) + j2] = ad3[((k5 + j) - 1) + j2] - Ddot.ddot(k5 - k11 - 2, ad, ((k11 + 2) - 1) + (k5 - 1) * l + k, 1, ad3, ((k11 + 2 + j) - 1) + j2, 1);
                                        ad3[((k5 + l11) - 1) + j2] = ad3[((k5 + l11) - 1) + j2] - Ddot.ddot(k5 - k11 - 2, ad, ((k11 + 2) - 1) + (k5 - 1) * l + k, 1, ad3, ((k11 + 2 + l11) - 1) + j2, 1);
                                        Dlaln2.dlaln2(false, 1, 2, d28, 1.0D, ad, (k5 - 1) + (k5 - 1) * l + k, l, 1.0D, 1.0D, ad3, ((k5 + j) - 1) + j2, j, d42, -d39, ad4, 0, 2, doublew1, doublew3, intw2);
                                        if(doublew1.val != 1.0D)
                                        {
                                            Dscal.dscal((j - k11) + 1, doublew1.val, ad3, ((k11 + j) - 1) + j2, 1);
                                            Dscal.dscal((j - k11) + 1, doublew1.val, ad3, ((k11 + l11) - 1) + j2, 1);
                                        }
                                        ad3[((k5 + j) - 1) + j2] = ad4[(1 - 1) + (1 - 1) * 2];
                                        ad3[((k5 + l11) - 1) + j2] = ad4[(1 - 1) + (2 - 1) * 2];
                                        d36 = Util.max(Math.abs(ad3[((k5 + j) - 1) + j2]), Math.abs(ad3[((k5 + l11) - 1) + j2]), d36);
                                        d33 = d5 / d36;
                                    } else
                                    {
                                        double d4 = Math.max(ad3[(k5 - 1) + j2], ad3[((k5 + 1) - 1) + j2]);
                                        if(d4 > d33)
                                        {
                                            double d16 = 1.0D / d36;
                                            Dscal.dscal((j - k11) + 1, d16, ad3, ((k11 + j) - 1) + j2, 1);
                                            Dscal.dscal((j - k11) + 1, d16, ad3, ((k11 + l11) - 1) + j2, 1);
                                            d36 = 1.0D;
                                            d33 = d5;
                                        }
                                        ad3[((k5 + j) - 1) + j2] = ad3[((k5 + j) - 1) + j2] - Ddot.ddot(k5 - k11 - 2, ad, ((k11 + 2) - 1) + (k5 - 1) * l + k, 1, ad3, ((k11 + 2 + j) - 1) + j2, 1);
                                        ad3[((k5 + l11) - 1) + j2] = ad3[((k5 + l11) - 1) + j2] - Ddot.ddot(k5 - k11 - 2, ad, ((k11 + 2) - 1) + (k5 - 1) * l + k, 1, ad3, ((k11 + 2 + l11) - 1) + j2, 1);
                                        ad3[((k5 + 1 + j) - 1) + j2] = ad3[((k5 + 1 + j) - 1) + j2] - Ddot.ddot(k5 - k11 - 2, ad, ((k11 + 2) - 1) + ((k5 + 1) - 1) * l + k, 1, ad3, ((k11 + 2 + j) - 1) + j2, 1);
                                        ad3[((k5 + 1 + l11) - 1) + j2] = ad3[((k5 + 1 + l11) - 1) + j2] - Ddot.ddot(k5 - k11 - 2, ad, ((k11 + 2) - 1) + ((k5 + 1) - 1) * l + k, 1, ad3, ((k11 + 2 + l11) - 1) + j2, 1);
                                        Dlaln2.dlaln2(true, 2, 2, d28, 1.0D, ad, (k5 - 1) + (k5 - 1) * l + k, l, 1.0D, 1.0D, ad3, ((k5 + j) - 1) + j2, j, d42, -d39, ad4, 0, 2, doublew1, doublew3, intw2);
                                        if(doublew1.val != 1.0D)
                                        {
                                            Dscal.dscal((j - k11) + 1, doublew1.val, ad3, ((k11 + j) - 1) + j2, 1);
                                            Dscal.dscal((j - k11) + 1, doublew1.val, ad3, ((k11 + l11) - 1) + j2, 1);
                                        }
                                        ad3[((k5 + j) - 1) + j2] = ad4[(1 - 1) + (1 - 1) * 2];
                                        ad3[((k5 + l11) - 1) + j2] = ad4[(1 - 1) + (2 - 1) * 2];
                                        ad3[((k5 + 1 + j) - 1) + j2] = ad4[(2 - 1) + (1 - 1) * 2];
                                        ad3[((k5 + 1 + l11) - 1) + j2] = ad4[(2 - 1) + (2 - 1) * 2];
                                        d36 = Math.max(Math.max(Util.max(Math.abs(ad4[(1 - 1) + (1 - 1) * 2]), Math.abs(ad4[(1 - 1) + (2 - 1) * 2]), Math.abs(ad4[(2 - 1) + (1 - 1) * 2])), Math.abs(ad4[(2 - 1) + (2 - 1) * 2])), d36);
                                        d33 = d5 / d36;
                                    }
                                }
                                k5++;
                            }

                            if(flag3 ^ true)
                            {
                                Dcopy.dcopy((j - k11) + 1, ad3, ((k11 + j) - 1) + j2, 1, ad1, (k11 - 1) + (j4 - 1) * j1 + i1, 1);
                                Dcopy.dcopy((j - k11) + 1, ad3, ((k11 + l11) - 1) + j2, 1, ad1, (k11 - 1) + ((j4 + 1) - 1) * j1 + i1, 1);
                                double d9 = 0.0D;
                                int l10 = k11;
                                for(int k16 = (j - k11) + 1; k16 > 0; k16--)
                                {
                                    d9 = Math.max(d9, Math.abs(ad1[(l10 - 1) + (j4 - 1) * j1 + i1]) + Math.abs(ad1[(l10 - 1) + ((j4 + 1) - 1) * j1 + i1]));
                                    l10++;
                                }

                                double d24 = 1.0D / d9;
                                Dscal.dscal((j - k11) + 1, d24, ad1, (k11 - 1) + (j4 - 1) * j1 + i1, 1);
                                Dscal.dscal((j - k11) + 1, d24, ad1, (k11 - 1) + ((j4 + 1) - 1) * j1 + i1, 1);
                                l10 = 1;
                                for(int l16 = (k11 - 1 - 1) + 1; l16 > 0; l16--)
                                {
                                    ad1[(l10 - 1) + (j4 - 1) * j1 + i1] = 0.0D;
                                    ad1[(l10 - 1) + ((j4 + 1) - 1) * j1 + i1] = 0.0D;
                                    l10++;
                                }

                            } else
                            {
                                if(k11 < j - 1)
                                {
                                    Dgemv.dgemv("N", j, j - k11 - 1, 1.0D, ad1, (1 - 1) + ((k11 + 2) - 1) * j1 + i1, j1, ad3, ((k11 + 2 + j) - 1) + j2, 1, ad3[((k11 + j) - 1) + j2], ad1, (1 - 1) + (k11 - 1) * j1 + i1, 1);
                                    Dgemv.dgemv("N", j, j - k11 - 1, 1.0D, ad1, (1 - 1) + ((k11 + 2) - 1) * j1 + i1, j1, ad3, ((k11 + 2 + l11) - 1) + j2, 1, ad3[((k11 + 1 + l11) - 1) + j2], ad1, (1 - 1) + ((k11 + 1) - 1) * j1 + i1, 1);
                                } else
                                {
                                    Dscal.dscal(j, ad3[((k11 + j) - 1) + j2], ad1, (1 - 1) + (k11 - 1) * j1 + i1, 1);
                                    Dscal.dscal(j, ad3[((k11 + 1 + l11) - 1) + j2], ad1, (1 - 1) + ((k11 + 1) - 1) * j1 + i1, 1);
                                }
                                double d10 = 0.0D;
                                int i11 = 1;
                                for(int i17 = (j - 1) + 1; i17 > 0; i17--)
                                {
                                    d10 = Math.max(d10, Math.abs(ad1[(i11 - 1) + (k11 - 1) * j1 + i1]) + Math.abs(ad1[(i11 - 1) + ((k11 + 1) - 1) * j1 + i1]));
                                    i11++;
                                }

                                double d25 = 1.0D / d10;
                                Dscal.dscal(j, d25, ad1, (1 - 1) + (k11 - 1) * j1 + i1, 1);
                                Dscal.dscal(j, d25, ad1, (1 - 1) + ((k11 + 1) - 1) * j1 + i1, 1);
                            }
                        }
                        j4++;
                        if(l3 != 0)
                            j4++;
                    }
                }
                if(l3 == -1)
                    l3 = 0;
                if(l3 == 1)
                    l3 = -1;
                k11++;
            }

        }
    }
}

package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.*;

public final class Dstemr
{
    public static void dstemr(String s, String s1, int i, double ad[], int j, double ad1[], int k, double d, double d1, int l, int i1, intW intw, double ad2[], 
            int j1, double ad3[], int k1, int l1, int i2, int ai[], int j2, 
            booleanW booleanw, double ad4[], int k2, int l2, int ai1[], int i3, int j3, 
            intW intw1)
    {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;
        int k4 = 0;
        int l4 = 0;
        int i5 = 0;
        int j5 = 0;
        intW intw2 = new intW(0);
        int k5 = 0;
        int l5 = 0;
        int k6 = 0;
        int l6 = 0;
        int i7 = 0;
        int j7 = 0;
        int k7 = 0;
        int l7 = 0;
        intW intw3 = new intW(0);
        intW intw4 = new intW(0);
        int i8 = 0;
        int j9 = 0;
        int k9 = 0;
        intW intw5 = new intW(0);
        intW intw6 = new intW(0);
        double d2 = 0.0D;
        doubleW doublew = new doubleW(0.0D);
        double d3 = 0.0D;
        doubleW doublew1 = new doubleW(0.0D);
        doubleW doublew2 = new doubleW(0.0D);
        doubleW doublew3 = new doubleW(0.0D);
        double d4 = 0.0D;
        double d5 = 0.0D;
        doubleW doublew4 = new doubleW(0.0D);
        doubleW doublew5 = new doubleW(0.0D);
        double d6 = 0.0D;
        double d7 = 0.0D;
        double d8 = 0.0D;
        doubleW doublew6 = new doubleW(0.0D);
        double d9 = 0.0D;
        double d12 = 0.0D;
        doubleW doublew7 = new doubleW(0.0D);
        doubleW doublew8 = new doubleW(0.0D);
        flag4 = Lsame.lsame(s, "V");
        flag = Lsame.lsame(s1, "A");
        flag3 = Lsame.lsame(s1, "V");
        flag1 = Lsame.lsame(s1, "I");
        flag2 = (l2 == -1) || (j3 == -1);
        flag5 = i2 == -1;
        booleanw.val = intw1.val != 0;
        if(flag4)
        {
            k9 = 18 * i;
            j9 = 10 * i;
        } else
        {
            k9 = 12 * i;
            j9 = 8 * i;
        }
        doublew7.val = 0.0D;
        doublew8.val = 0.0D;
        k4 = 0;
        l5 = 0;
        if(flag3)
        {
            doublew7.val = d;
            doublew8.val = d1;
        } else
        if(flag1)
        {
            k4 = l;
            l5 = i1;
        }
        intw1.val = 0;
        if((flag4 || Lsame.lsame(s, "N")) ^ true)
            intw1.val = -1;
        else
        if(((flag || flag3) || flag1) ^ true)
            intw1.val = -2;
        else
        if(i < 0)
            intw1.val = -3;
        else
        if((flag3 && (i > 0)) && (doublew8.val <= doublew7.val))
            intw1.val = -7;
        else
        if(flag1 && ((k4 < 1) || (k4 > i)))
            intw1.val = -8;
        else
        if(flag1 && ((l5 < k4) || (l5 > i)))
            intw1.val = -9;
        else
        if((l1 < 1) || (flag4 && (l1 < i)))
            intw1.val = -13;
        else
        if((l2 < k9) && flag2 ^ true)
            intw1.val = -17;
        else
        if((j3 < j9) && flag2 ^ true)
            intw1.val = -19;
        d6 = Dlamch.dlamch("Safe minimum");
        d3 = Dlamch.dlamch("Precision");
        d8 = d6 / d3;
        d2 = 1.0D / d8;
        d5 = Math.sqrt(d8);
        d4 = Math.min(Math.sqrt(d2), 1.0D / Math.sqrt(Math.sqrt(d6)));
        if(intw1.val == 0)
        {
            ad4[(1 - 1) + k2] = k9;
            ai1[(1 - 1) + i3] = j9;
            if(flag4 && flag)
                intw6.val = i;
            else
            if(flag4 && flag3)
                Dlarrc.dlarrc("T", i, d, d1, ad, j, ad1, k, d6, intw6, intw3, intw4, intw1);
            else
            if(flag4 && flag1)
                intw6.val = (l5 - k4) + 1;
            else
                intw6.val = 0;
            if(flag5 && (intw1.val == 0))
                ad3[(1 - 1) + (1 - 1) * l1 + k1] = intw6.val;
            else
            if((i2 < intw6.val) && flag5 ^ true)
                intw1.val = -14;
        }
        if(intw1.val != 0)
        {
            Xerbla.xerbla("DSTEMR", -intw1.val);
            return;
        }
        if(flag2 || flag5)
            return;
        intw.val = 0;
        if(i == 0)
            return;
        if(i == 1)
        {
            if(flag || flag1)
            {
                intw.val = 1;
                ad2[(1 - 1) + j1] = ad[(1 - 1) + j];
            } else
            if((doublew7.val < ad[(1 - 1) + j]) && (doublew8.val >= ad[(1 - 1) + j]))
            {
                intw.val = 1;
                ad2[(1 - 1) + j1] = ad[(1 - 1) + j];
            }
            if(flag4 && flag5 ^ true)
            {
                ad3[(1 - 1) + (1 - 1) * l1 + k1] = 1.0D;
                ai[(1 - 1) + j2] = 1;
                ai[(2 - 1) + j2] = 1;
            }
            return;
        }
        if(i == 2)
        {
            if(flag4 ^ true)
                Dlae2.dlae2(ad[(1 - 1) + j], ad1[(1 - 1) + k], ad[(2 - 1) + j], doublew2, doublew3);
            else
            if(flag4 && flag5 ^ true)
                Dlaev2.dlaev2(ad[(1 - 1) + j], ad1[(1 - 1) + k], ad[(2 - 1) + j], doublew2, doublew3, doublew, doublew6);
            if((flag || ((flag3 && (doublew3.val > doublew7.val)) && (doublew3.val <= doublew8.val))) || (flag1 && (k4 == 1)))
            {
                intw.val = intw.val + 1;
                ad2[(intw.val - 1) + j1] = doublew3.val;
                if(flag4 && flag5 ^ true)
                {
                    ad3[(1 - 1) + (intw.val - 1) * l1 + k1] = -doublew6.val;
                    ad3[(2 - 1) + (intw.val - 1) * l1 + k1] = doublew.val;
                    if(doublew6.val != 0.0D)
                    {
                        if(doublew.val != 0.0D)
                        {
                            ai[(2 * intw.val - 1 - 1) + j2] = 1;
                            ai[(2 * intw.val - 1 - 1) + j2] = 2;
                        } else
                        {
                            ai[(2 * intw.val - 1 - 1) + j2] = 1;
                            ai[(2 * intw.val - 1 - 1) + j2] = 1;
                        }
                    } else
                    {
                        ai[(2 * intw.val - 1 - 1) + j2] = 2;
                        ai[(2 * intw.val - 1) + j2] = 2;
                    }
                }
            }
            if((flag || ((flag3 && (doublew2.val > doublew7.val)) && (doublew2.val <= doublew8.val))) || (flag1 && (l5 == 2)))
            {
                intw.val = intw.val + 1;
                ad2[(intw.val - 1) + j1] = doublew2.val;
                if(flag4 && flag5 ^ true)
                {
                    ad3[(1 - 1) + (intw.val - 1) * l1 + k1] = doublew.val;
                    ad3[(2 - 1) + (intw.val - 1) * l1 + k1] = doublew6.val;
                    if(doublew6.val != 0.0D)
                    {
                        if(doublew.val != 0.0D)
                        {
                            ai[(2 * intw.val - 1 - 1) + j2] = 1;
                            ai[(2 * intw.val - 1 - 1) + j2] = 2;
                        } else
                        {
                            ai[(2 * intw.val - 1 - 1) + j2] = 1;
                            ai[(2 * intw.val - 1 - 1) + j2] = 1;
                        }
                    } else
                    {
                        ai[(2 * intw.val - 1 - 1) + j2] = 2;
                        ai[(2 * intw.val - 1) + j2] = 2;
                    }
                }
            }
            return;
        }
        k7 = 1;
        i7 = 2 * i + 1;
        j7 = 3 * i + 1;
        k6 = 4 * i + 1;
        l6 = 5 * i + 1;
        l7 = 6 * i + 1;
        k5 = 1;
        l4 = i + 1;
        i5 = 2 * i + 1;
        j5 = 3 * i + 1;
        d7 = 1.0D;
        d12 = Dlanst.dlanst("M", i, ad, j, ad1, k);
        if((d12 > 0.0D) && (d12 < d5))
            d7 = d5 / d12;
        else
        if(d12 > d4)
            d7 = d4 / d12;
        if(d7 != 1.0D)
        {
            Dscal.dscal(i, d7, ad, j, 1);
            Dscal.dscal(i - 1, d7, ad1, k, 1);
            d12 *= d7;
            if(flag3)
            {
                doublew7.val = doublew7.val * d7;
                doublew8.val = doublew8.val * d7;
            }
        }
        if(booleanw.val)
            Dlarrr.dlarrr(i, ad, j, ad1, k, intw2);
        else
            intw2.val = -1;
        if(intw2.val == 0)
        {
            d9 = d3;
        } else
        {
            d9 = -d3;
            booleanw.val = false;
        }
        if(booleanw.val)
            Dcopy.dcopy(i, ad, j, 1, ad4, (k6 - 1) + k2, 1);
        i8 = 1;
        for(int k10 = (i - 1 - 1) + 1; k10 > 0; k10--)
        {
            ad4[((l6 + i8) - 1 - 1) + k2] = Math.pow(ad1[(i8 - 1) + k], 2);
            i8++;
        }

        if(flag4 ^ true)
        {
            doublew4.val = 4D * d3;
            doublew5.val = 4D * d3;
        } else
        {
            doublew4.val = Math.sqrt(d3);
            doublew5.val = Math.max(Math.sqrt(d3) * 0.0050000000000000001D, 4D * d3);
        }
        Dlarre.dlarre(s1, i, doublew7, doublew8, k4, l5, ad, j, ad1, k, ad4, (l6 - 1) + k2, doublew4.val, doublew5.val, d9, intw5, ai1, (k5 - 1) + i3, intw, ad2, j1, ad4, (i7 - 1) + k2, ad4, (j7 - 1) + k2, ai1, (l4 - 1) + i3, ai1, (i5 - 1) + i3, ad4, (k7 - 1) + k2, doublew1, ad4, (l7 - 1) + k2, ai1, (j5 - 1) + i3, intw2);
        if(intw2.val != 0)
        {
            intw1.val = 10 + Math.abs(intw2.val);
            return;
        }
        if(flag4)
        {
            Dlarrv.dlarrv(i, doublew7.val, doublew8.val, ad, j, ad1, k, doublew1.val, ai1, (k5 - 1) + i3, intw.val, 1, intw.val, 0.001D, doublew4, doublew5, ad2, j1, ad4, (i7 - 1) + k2, ad4, (j7 - 1) + k2, ai1, (l4 - 1) + i3, ai1, (i5 - 1) + i3, ad4, (k7 - 1) + k2, ad3, k1, l1, ai, j2, ad4, (l7 - 1) + k2, ai1, (j5 - 1) + i3, intw2);
            if(intw2.val != 0)
            {
                intw1.val = 20 + Math.abs(intw2.val);
                return;
            }
        } else
        {
            int j8 = 1;
            for(int l10 = (intw.val - 1) + 1; l10 > 0; l10--)
            {
                intw3.val = ai1[((l4 + j8) - 1 - 1) + i3];
                ad2[(j8 - 1) + j1] = ad2[(j8 - 1) + j1] + ad1[(ai1[((k5 + intw3.val) - 1 - 1) + i3] - 1) + k];
                j8++;
            }

        }
        if(booleanw.val)
        {
            int l3 = 1;
            int i10 = 1;
            int l8 = 1;
            for(int i11 = (ai1[((l4 + intw.val) - 1 - 1) + i3] - 1) + 1; i11 > 0; i11--)
            {
                int i4 = ai1[((k5 + l8) - 1 - 1) + i3];
                int j6 = (i4 - l3) + 1;
                int j10;
                for(j10 = i10 - 1; (j10 < intw.val) && (ai1[((l4 + j10) - 1) + i3] == l8); j10++);
                if(j10 < i10)
                {
                    l3 = i4 + 1;
                } else
                {
                    int l9 = ai1[((i5 + i10) - 1 - 1) + i3] - 1;
                    int j4 = ai1[((i5 + i10) - 1 - 1) + i3];
                    int i6 = ai1[((i5 + j10) - 1 - 1) + i3];
                    doublew5.val = 4D * d3;
                    Dlarrj.dlarrj(j6, ad4, ((k6 + l3) - 1 - 1) + k2, ad4, ((l6 + l3) - 1 - 1) + k2, j4, i6, doublew5.val, l9, ad2, (i10 - 1) + j1, ad4, ((i7 + i10) - 1 - 1) + k2, ad4, (l7 - 1) + k2, ai1, (j5 - 1) + i3, doublew1.val, d12, intw2);
                    l3 = i4 + 1;
                    i10 = j10 + 1;
                }
                l8++;
            }

        }
        if(d7 != 1.0D)
            Dscal.dscal(intw.val, 1.0D / d7, ad2, j1, 1);
        if(intw5.val > 1)
            if(flag4 ^ true)
            {
                Dlasrt.dlasrt("I", intw.val, ad2, j1, intw2);
                if(intw2.val != 0)
                {
                    intw1.val = 3;
                    return;
                }
            } else
            {
                int k8 = 1;
                for (int j11 = intw.val - 1; j11 > 0; j11--)
                {
                    int k3 = 0;
                    double d11 = ad2[(k8 - 1) + j1];
                    int i9 = k8 + 1;
                    for(int k11 = (intw.val - (k8 + 1)) + 1; k11 > 0; k11--)
                    {
                        if(ad2[(i9 - 1) + j1] < d11)
                        {
                            k3 = i9;
                            d11 = ad2[(i9 - 1) + j1];
                        }
                        i9++;
                    }

                    if(k3 != 0)
                    {
                        ad2[(k3 - 1) + j1] = ad2[(k8 - 1) + j1];
                        ad2[(k8 - 1) + j1] = d11;
                        if(flag4)
                        {
                            Dswap.dswap(i, ad3, (k3 - 1) * l1 + k1, 1, ad3, (k8 - 1) * l1 + k1, 1);
                            intw3.val = ai[(2 * k3 - 1 - 1) + j2];
                            ai[(2 * k3 - 2) + j2] = ai[(2 * k8 - 2) + j2];
                            ai[(2 * k8 - 2) + j2] = intw3.val;
                            intw3.val = ai[(2 * k3 - 1) + j2];
                            ai[(2 * k3 - 1) + j2] = ai[(2 * k8 - 1) + j2];
                            ai[(2 * k8 - 1) + j2] = intw3.val;
                        }
                    }
                    k8++;
                }

            }
        ad4[k2] = k9;
        ai1[i3] = j9;
    }
}

package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.booleanW;
import org.netlib.util.intW;

public final class Dsyevr
{
    public static void dsyevr(String s, String s1, String s2, int i, double ad[], int j, int k, double d, double d1, int l, int i1, double d2, 
            intW intw, double ad1[], int j1, double ad2[], int k1, int l1, int ai[], 
            int i2, double ad3[], int j2, int k2, int ai1[], int l2, int i3, 
            intW intw1)
    {
        boolean flag5;
        boolean flag9;
        int i8;
        int i9;
        double d10;
label0:
        {
            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;
            boolean flag4 = false;
            flag5 = false;
            booleanW booleanw = new booleanW(false);
            String s3 = new String(" ");
            int k3 = 0;
            intW intw2 = new intW(0);
            int i4 = 0;
            int j4 = 0;
            int k4 = 0;
            int l4 = 0;
            int i5 = 0;
            int j5 = 0;
            int k5 = 0;
            int l5 = 0;
            int i6 = 0;
            int j6 = 0;
            flag9 = false;
            i8 = 0;
            int j8 = 0;
            i9 = 0;
            int j9 = 0;
            intW intw3 = new intW(0);
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            double d6 = 0.0D;
            double d7 = 0.0D;
            double d8 = 0.0D;
            double d9 = 0.0D;
            d10 = 0.0D;
            double d11 = 0.0D;
            double d14 = 0.0D;
            double d15 = 0.0D;
            k3 = Ilaenv.ilaenv(10, "DSYEVR", "N", 1, 2, 3, 4);
            flag2 = Lsame.lsame(s2, "L");
            flag5 = Lsame.lsame(s, "V");
            flag = Lsame.lsame(s1, "A");
            flag4 = Lsame.lsame(s1, "V");
            flag1 = Lsame.lsame(s1, "I");
            flag3 = (k2 == -1) || (i3 == -1);
            j9 = Math.max(1, 26 * i);
            i8 = Math.max(1, 10 * i);
            intw1.val = 0;
            if((flag5 || Lsame.lsame(s, "N")) ^ true)
                intw1.val = -1;
            else
            if(((flag || flag4) || flag1) ^ true)
                intw1.val = -2;
            else
            if((flag2 || Lsame.lsame(s2, "U")) ^ true)
                intw1.val = -3;
            else
            if(i < 0)
                intw1.val = -4;
            else
            if(k < Math.max(1, i))
                intw1.val = -6;
            else
            if(flag4)
            {
                if((i > 0) && (d1 <= d))
                    intw1.val = -8;
            } else
            if(flag1)
                if((l < 1) || (l > Math.max(1, i)))
                    intw1.val = -9;
                else
                if((i1 < Math.min(i, l)) || (i1 > i))
                    intw1.val = -10;
            if(intw1.val == 0)
                if((l1 < 1) || (flag5 && (l1 < i)))
                    intw1.val = -15;
                else
                if((k2 < j9) && flag3 ^ true)
                    intw1.val = -18;
                else
                if((i3 < i8) && flag3 ^ true)
                    intw1.val = -20;
            if(intw1.val == 0)
            {
                int k9 = Ilaenv.ilaenv(1, "DSYTRD", s2, i, -1, -1, -1);
                k9 = Math.max(k9, Ilaenv.ilaenv(1, "DORMTR", s2, i, -1, -1, -1));
                i9 = Math.max((k9 + 1) * i, j9);
                ad3[(1 - 1) + j2] = i9;
                ai1[(1 - 1) + l2] = i8;
            }
            if(intw1.val != 0)
            {
                Xerbla.xerbla("DSYEVR", -intw1.val);
                return;
            }
            if(flag3)
                return;
            intw.val = 0;
            if(i == 0)
            {
                ad3[(1 - 1) + j2] = 1;
                return;
            }
            if(i == 1)
            {
                ad3[(1 - 1) + j2] = 7;
                if(flag || flag1)
                {
                    intw.val = 1;
                    ad1[(1 - 1) + j1] = ad[(1 - 1) + (1 - 1) * k + j];
                } else
                if((d < ad[(1 - 1) + (1 - 1) * k + j]) && (d1 >= ad[(1 - 1) + (1 - 1) * k + j]))
                {
                    intw.val = 1;
                    ad1[(1 - 1) + j1] = ad[(1 - 1) + (1 - 1) * k + j];
                }
                if(flag5)
                    ad2[(1 - 1) + (1 - 1) * l1 + k1] = 1.0D;
                return;
            }
            d9 = Dlamch.dlamch("Safe minimum");
            d6 = Dlamch.dlamch("Precision");
            d11 = d9 / d6;
            d5 = 1.0D / d11;
            d8 = Math.sqrt(d11);
            d7 = Math.min(Math.sqrt(d5), 1.0D / Math.sqrt(Math.sqrt(d9)));
            flag9 = false;
            d3 = d2;
            d14 = d;
            d15 = d1;
            d4 = Dlansy.dlansy("M", s2, i, ad, j, k, ad3, j2);
            if((d4 > 0.0D) && (d4 < d8))
            {
                flag9 = true;
                d10 = d8 / d4;
            } else
            if(d4 > d7)
            {
                flag9 = true;
                d10 = d7 / d4;
            }
            if(flag9)
            {
                if(flag2)
                {
                    int i7 = 1;
                    for(int l9 = (i - 1) + 1; l9 > 0; l9--)
                    {
                        Dscal.dscal((i - i7) + 1, d10, ad, (i7 - 1) + (i7 - 1) * k + j, 1);
                        i7++;
                    }

                } else
                {
                    int j7 = 1;
                    for(int i10 = (i - 1) + 1; i10 > 0; i10--)
                    {
                        Dscal.dscal(j7, d10, ad, (1 - 1) + (j7 - 1) * k + j, 1);
                        j7++;
                    }

                }
                if(d2 > (double)0)
                    d3 = d2 * d10;
                if(flag4)
                {
                    d14 = d * d10;
                    d15 = d1 * d10;
                }
            }
            i6 = 1;
            i4 = i6 + i;
            k4 = i4 + i;
            j4 = k4 + i;
            l4 = j4 + i;
            j6 = l4 + i;
            j8 = (k2 - j6) + 1;
            i5 = 1;
            k5 = i5 + i;
            j5 = k5 + i;
            l5 = k5 + i;
            Dsytrd.dsytrd(s2, i, ad, j, k, ad3, (i4 - 1) + j2, ad3, (k4 - 1) + j2, ad3, (i6 - 1) + j2, ad3, (j6 - 1) + j2, j8, intw2);
            if((flag || ((flag1 && (l == 1)) && (i1 == i))) && (k3 == 1))
            {
                if(flag5 ^ true)
                {
                    Dcopy.dcopy(i, ad3, (i4 - 1) + j2, 1, ad1, j1, 1);
                    Dcopy.dcopy(i - 1, ad3, (k4 - 1) + j2, 1, ad3, (l4 - 1) + j2, 1);
                    Dsterf.dsterf(i, ad1, j1, ad3, (l4 - 1) + j2, intw1);
                } else
                {
                    Dcopy.dcopy(i - 1, ad3, (k4 - 1) + j2, 1, ad3, (l4 - 1) + j2, 1);
                    Dcopy.dcopy(i, ad3, (i4 - 1) + j2, 1, ad3, (j4 - 1) + j2, 1);
                    if(d2 <= 0.0D * (double)i * d6)
                        booleanw.val = true;
                    else
                        booleanw.val = false;
                    Dstemr.dstemr(s, "A", i, ad3, (j4 - 1) + j2, ad3, (l4 - 1) + j2, d, d1, l, i1, intw, ad1, j1, ad2, k1, l1, i, ai, i2, booleanw, ad3, (j6 - 1) + j2, k2, ai1, l2, i3, intw1);
                    if(flag5 && (intw1.val == 0))
                    {
                        int k6 = k4;
                        int k8 = (k2 - k6) + 1;
                        Dormtr.dormtr("L", s2, "N", i, intw.val, ad, j, k, ad3, (i6 - 1) + j2, ad2, k1, l1, ad3, (k6 - 1) + j2, k8, intw2);
                    }
                }
                if(intw1.val == 0)
                {
                    intw.val = i;
                    break label0;
                }
                intw1.val = 0;
            }
            if(flag5)
                s3 = "B";
            else
                s3 = "E";
            Dstebz.dstebz(s1, s3, i, d14, d15, l, i1, d3, ad3, (i4 - 1) + j2, ad3, (k4 - 1) + j2, intw, intw3, ad1, j1, ai1, (i5 - 1) + l2, ai1, (k5 - 1) + l2, ad3, (j6 - 1) + j2, ai1, (l5 - 1) + l2, intw1);
            if(flag5)
            {
                Dstein.dstein(i, ad3, (i4 - 1) + j2, ad3, (k4 - 1) + j2, intw.val, ad1, j1, ai1, (i5 - 1) + l2, ai1, (k5 - 1) + l2, ad2, k1, l1, ad3, (j6 - 1) + j2, ai1, (l5 - 1) + l2, ai1, (j5 - 1) + l2, intw1);
                int l6 = k4;
                int l8 = (k2 - l6) + 1;
                Dormtr.dormtr("L", s2, "N", i, intw.val, ad, j, k, ad3, (i6 - 1) + j2, ad2, k1, l1, ad3, (l6 - 1) + j2, l8, intw2);
            }
        }
        if(flag9)
        {
            int l3;
            if(intw1.val == 0)
                l3 = intw.val;
            else
                l3 = intw1.val - 1;
            Dscal.dscal(l3, 1.0D / d10, ad1, j1, 1);
        }
        if(flag5)
        {
            int k7 = 1;
            for(int j10 = (intw.val - 1 - 1) + 1; j10 > 0; j10--)
            {
                int j3 = 0;
                double d13 = ad1[(k7 - 1) + j1];
                int l7 = k7 + 1;
                for(int k10 = (intw.val - (k7 + 1)) + 1; k10 > 0; k10--)
                {
                    if(ad1[(l7 - 1) + j1] < d13)
                    {
                        j3 = l7;
                        d13 = ad1[(l7 - 1) + j1];
                    }
                    l7++;
                }

                if(j3 != 0)
                {
                    ad1[(j3 - 1) + j1] = ad1[(k7 - 1) + j1];
                    ad1[(k7 - 1) + j1] = d13;
                    Dswap.dswap(i, ad2, (1 - 1) + (j3 - 1) * l1 + k1, 1, ad2, (1 - 1) + (k7 - 1) * l1 + k1, 1);
                }
                k7++;
            }

        }
        ad3[(1 - 1) + j2] = i9;
        ai1[(1 - 1) + l2] = i8;
    }
}

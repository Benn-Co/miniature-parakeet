package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.booleanW;
import org.netlib.util.intW;

public final class Dstevr
{
    public static void dstevr(String s, String s1, int i, double ad[], int j, double ad1[], int k, double d, double d1, int l, int i1, double d2, 
            intW intw, double ad2[], int j1, double ad3[], int k1, int l1, int ai[], 
            int i2, double ad4[], int j2, int k2, int ai1[], int l2, int i3, 
            intW intw1)
    {
        boolean flag5;
        boolean flag8;
        int l5;
        int i6;
        double d8;
label0:
        {
            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;
            boolean flag4 = false;
            flag5 = false;
            booleanW booleanw = new booleanW(false);
            String s2 = new String(" ");
            int k3 = 0;
            int i4 = 0;
            int j4 = 0;
            int k4 = 0;
            int l4 = 0;
            flag8 = false;
            l5 = 0;
            i6 = 0;
            intW intw2 = new intW(0);
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            double d6 = 0.0D;
            double d7 = 0.0D;
            d8 = 0.0D;
            double d9 = 0.0D;
            double d12 = 0.0D;
            double d13 = 0.0D;
            double d14 = 0.0D;
            k3 = Ilaenv.ilaenv(10, "DSTEVR", "N", 1, 2, 3, 4);
            flag5 = Lsame.lsame(s, "V");
            flag = Lsame.lsame(s1, "A");
            flag4 = Lsame.lsame(s1, "V");
            flag1 = Lsame.lsame(s1, "I");
            flag3 = (k2 == -1) || (i3 == -1);
            i6 = Math.max(1, 20 * i);
            l5 = Math.max(1, 10 * i);
            intw1.val = 0;
            if((flag5 || Lsame.lsame(s, "N")) ^ true)
                intw1.val = -1;
            else
            if(((flag || flag4) || flag1) ^ true)
                intw1.val = -2;
            else
            if(i < 0)
                intw1.val = -3;
            else
            if(flag4)
            {
                if((i > 0) && (d1 <= d))
                    intw1.val = -7;
            } else
            if(flag1)
                if((l < 1) || (l > Math.max(1, i)))
                    intw1.val = -8;
                else
                if((i1 < Math.min(i, l)) || (i1 > i))
                    intw1.val = -9;
            if((intw1.val == 0) && ((l1 < 1) || (flag5 && (l1 < i))))
                intw1.val = -14;
            if(intw1.val == 0)
            {
                ad4[(1 - 1) + j2] = i6;
                ai1[(1 - 1) + l2] = l5;
                if((k2 < i6) && flag3 ^ true)
                    intw1.val = -17;
                else
                if((i3 < l5) && flag3 ^ true)
                    intw1.val = -19;
            }
            if(intw1.val != 0)
            {
                Xerbla.xerbla("DSTEVR", -intw1.val);
                return;
            }
            if(flag3)
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
                if((d < ad[(1 - 1) + j]) && (d1 >= ad[(1 - 1) + j]))
                {
                    intw.val = 1;
                    ad2[(1 - 1) + j1] = ad[(1 - 1) + j];
                }
                if(flag5)
                    ad3[(1 - 1) + (1 - 1) * l1 + k1] = 1.0D;
                return;
            }
            d7 = Dlamch.dlamch("Safe minimum");
            d4 = Dlamch.dlamch("Precision");
            d9 = d7 / d4;
            d3 = 1.0D / d9;
            d6 = Math.sqrt(d9);
            d5 = Math.min(Math.sqrt(d3), 1.0D / Math.sqrt(Math.sqrt(d7)));
            flag8 = false;
            d13 = d;
            d14 = d1;
            d12 = Dlanst.dlanst("M", i, ad, j, ad1, k);
            if((d12 > 0.0D) && (d12 < d6))
            {
                flag8 = true;
                d8 = d6 / d12;
            } else
            if(d12 > d5)
            {
                flag8 = true;
                d8 = d5 / d12;
            }
            if(flag8)
            {
                Dscal.dscal(i, d8, ad, j, 1);
                Dscal.dscal(i - 1, d8, ad1, (1 - 1) + k, 1);
                if(flag4)
                {
                    d13 = d * d8;
                    d14 = d1 * d8;
                }
            }
            i4 = 1;
            k4 = i4 + i;
            j4 = k4 + i;
            l4 = k4 + i;
            flag2 = false;
            if(flag1 && ((l == 1) && (i1 == i)))
                flag2 = true;
            if((flag || flag2) && (k3 == 1))
            {
                Dcopy.dcopy(i - 1, ad1, (1 - 1) + k, 1, ad4, (1 - 1) + j2, 1);
                if(flag5 ^ true)
                {
                    Dcopy.dcopy(i, ad, j, 1, ad2, j1, 1);
                    Dsterf.dsterf(i, ad2, j1, ad4, j2, intw1);
                } else
                {
                    Dcopy.dcopy(i, ad, j, 1, ad4, ((i + 1) - 1) + j2, 1);
                    if(d2 <= 2D * (double)i * d4)
                        booleanw.val = true;
                    else
                        booleanw.val = false;
                    Dstemr.dstemr(s, "A", i, ad4, ((i + 1) - 1) + j2, ad4, j2, d, d1, l, i1, intw, ad2, j1, ad3, k1, l1, i, ai, i2, booleanw, ad4, ((2 * i + 1) - 1) + j2, k2 - 2 * i, ai1, l2, i3, intw1);
                }
                if(intw1.val == 0)
                {
                    intw.val = i;
                    break label0;
                }
                intw1.val = 0;
            }
            if(flag5)
                s2 = "B";
            else
                s2 = "E";
            Dstebz.dstebz(s1, s2, i, d13, d14, l, i1, d2, ad, j, ad1, k, intw, intw2, ad2, j1, ai1, (i4 - 1) + l2, ai1, (k4 - 1) + l2, ad4, j2, ai1, (l4 - 1) + l2, intw1);
            if(flag5)
                Dstein.dstein(i, ad, j, ad1, k, intw.val, ad2, j1, ai1, (i4 - 1) + l2, ai1, (k4 - 1) + l2, ad3, k1, l1, ad4, j2, ai1, (l4 - 1) + l2, ai1, (j4 - 1) + l2, intw1);
        }
        if(flag8)
        {
            int l3;
            if(intw1.val == 0)
                l3 = intw.val;
            else
                l3 = intw1.val - 1;
            Dscal.dscal(l3, 1.0D / d8, ad2, j1, 1);
        }
        if(flag5)
        {
            int j5 = 1;
            for(int j6 = (intw.val - 1 - 1) + 1; j6 > 0; j6--)
            {
                int j3 = 0;
                double d11 = ad2[(j5 - 1) + j1];
                int k5 = j5 + 1;
                for(int k6 = (intw.val - (j5 + 1)) + 1; k6 > 0; k6--)
                {
                    if(ad2[(k5 - 1) + j1] < d11)
                    {
                        j3 = k5;
                        d11 = ad2[(k5 - 1) + j1];
                    }
                    k5++;
                }

                if(j3 != 0)
                {
                    int i5 = ai1[(j3 - 1) + l2];
                    ad2[(j3 - 1) + j1] = ad2[(j5 - 1) + j1];
                    ai1[(j3 - 1) + l2] = ai1[(j5 - 1) + l2];
                    ad2[(j5 - 1) + j1] = d11;
                    ai1[(j5 - 1) + l2] = i5;
                    Dswap.dswap(i, ad3, (1 - 1) + (j3 - 1) * l1 + k1, 1, ad3, (1 - 1) + (j5 - 1) * l1 + k1, 1);
                }
                j5++;
            }

        }
        ad4[(1 - 1) + j2] = i6;
        ai1[(1 - 1) + l2] = l5;
    }
}

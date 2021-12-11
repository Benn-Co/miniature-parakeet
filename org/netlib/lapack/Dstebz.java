package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dstebz
{
    public static void dstebz(String s, String s1, int i, double d, double d1, int j, 
            int k, double d2, double ad[], int l, double ad1[], int i1, 
            intW intw, intW intw1, double ad2[], int j1, int ai[], int k1, int ai1[], 
            int l1, double ad3[], int i2, int ai2[], int j2, intW intw2)
    {
        boolean flag = false;
        boolean flag1 = false;
        int l3 = 0;
        intW intw3 = new intW(0);
        intW intw4 = new intW(0);
        byte byte0 = 0;
        intW intw5 = new intW(0);
        byte byte1 = 0;
        int i6 = 0;
        int j7 = 0;
        int k9 = 0;
        int l9 = 0;
        int i10 = 0;
        double d15 = 0.0D;
        double d16 = 0.0D;
        double d17 = 0.0D;
        double d30 = 0.0D;
        double d34 = 0.0D;
        double d35 = 0.0D;
        double d36 = 0.0D;
        double d37 = 0.0D;
        int ai3[] = new int[1];
        intw2.val = 0;
        if(Lsame.lsame(s, "A"))
            byte1 = 1;
        else
        if(Lsame.lsame(s, "V"))
            byte1 = 2;
        else
        if(Lsame.lsame(s, "I"))
            byte1 = 3;
        else
            byte1 = 0;
        if(Lsame.lsame(s1, "B"))
            byte0 = 2;
        else
        if(Lsame.lsame(s1, "E"))
            byte0 = 1;
        else
            byte0 = 0;
        if(byte1 <= 0)
            intw2.val = -1;
        else
        if(byte0 <= 0)
            intw2.val = -2;
        else
        if(i < 0)
            intw2.val = -3;
        else
        if(byte1 == 2)
        {
            if(d >= d1)
                intw2.val = -5;
        } else
        if((byte1 == 3) && ((j < 1) || (j > Math.max(1, i))))
            intw2.val = -6;
        else
        if((byte1 == 3) && ((k < Math.min(i, j)) || (k > i)))
            intw2.val = -7;
        if(intw2.val != 0)
        {
            Xerbla.xerbla("DSTEBZ", -intw2.val);
            return;
        }
        intw2.val = 0;
        flag = false;
        flag1 = false;
        intw.val = 0;
        if(i == 0)
            return;
        if(((byte1 == 3) && (j == 1)) && (k == i))
            byte1 = 1;
        d17 = Dlamch.dlamch("S");
        d30 = Dlamch.dlamch("P");
        d16 = d30 * 2D;
        k9 = Ilaenv.ilaenv(1, "DSTEBZ", " ", i, -1, -1, -1);
        if(k9 <= 1)
            k9 = 0;
        if(i == 1)
        {
            intw1.val = 1;
            ai1[(1 - 1) + l1] = 1;
            if((byte1 == 2) && ((d >= ad[(1 - 1) + l]) || (d1 < ad[(1 - 1) + l])))
            {
                intw.val = 0;
            } else
            {
                ad2[(1 - 1) + j1] = ad[(1 - 1) + l];
                ai[(1 - 1) + k1] = 1;
                intw.val = 1;
            }
            return;
        }
        intw1.val = 1;
        ad3[(i - 1) + i2] = 0.0D;
        d15 = 1.0D;
        i6 = 2;
        for(int j10 = (i - 2) + 1; j10 > 0; j10--)
        {
            double d19 = Math.pow(ad1[(i6 - 1 - 1) + i1], 2);
            if(Math.abs(ad[(i6 - 1) + l] * ad[(i6 - 1 - 1) + l]) * Math.pow(d30, 2) + d17 > d19)
            {
                ai1[(intw1.val - 1) + l1] = i6 - 1;
                intw1.val = intw1.val + 1;
                ad3[(i6 - 1 - 1) + i2] = 0.0D;
            } else
            {
                ad3[(i6 - 1 - 1) + i2] = d19;
                d15 = Math.max(d15, d19);
            }
            i6++;
        }

        ai1[(intw1.val - 1) + l1] = i;
        d15 *= d17;
        if(byte1 == 3)
        {
            double d13 = ad[(1 - 1) + l];
            double d10 = ad[(1 - 1) + l];
            double d20 = 0.0D;
            int j6 = 1;
            for(int k10 = (i - 1 - 1) + 1; k10 > 0; k10--)
            {
                double d25 = Math.sqrt(ad3[(j6 - 1) + i2]);
                d13 = Math.max(d13, ad[(j6 - 1) + l] + d20 + d25);
                d10 = Math.min(d10, ad[(j6 - 1) + l] - d20 - d25);
                d20 = d25;
                j6++;
            }

            d13 = Math.max(d13, ad[(i - 1) + l] + d20);
            d10 = Math.min(d10, ad[(i - 1) + l] - d20);
            double d28 = Math.max(Math.abs(d10), Math.abs(d13));
            d10 = d10 - 2.1000000000000001D * d28 * d30 * (double)i - 2.1000000000000001D * 2D * d15;
            d13 = d13 + 2.1000000000000001D * d28 * d30 * (double)i + 2.1000000000000001D * d15;
            int k4 = (int)((Math.log(d28 + d15) - Math.log(d15)) / Math.log(2D)) + 2;
            double d4;
            if(d2 <= 0.0D)
                d4 = d30 * d28;
            else
                d4 = d2;
            ad3[((i + 1) - 1) + i2] = d10;
            ad3[((i + 2) - 1) + i2] = d10;
            ad3[((i + 3) - 1) + i2] = d13;
            ad3[((i + 4) - 1) + i2] = d13;
            ad3[((i + 5) - 1) + i2] = d10;
            ad3[((i + 6) - 1) + i2] = d13;
            ai2[(1 - 1) + j2] = -1;
            ai2[(2 - 1) + j2] = -1;
            ai2[(3 - 1) + j2] = i + 1;
            ai2[(4 - 1) + j2] = i + 1;
            ai2[(5 - 1) + j2] = j - 1;
            ai2[(6 - 1) + j2] = k;
            Dlaebz.dlaebz(3, k4, i, 2, 2, k9, d4, d16, d15, ad, l, ad1, i1, ad3, i2, ai2, (5 - 1) + j2, ad3, ((i + 1) - 1) + i2, ad3, ((i + 5) - 1) + i2, intw5, ai2, j2, ad2, j1, ai, k1, intw3);
            if(ai2[(6 - 1) + j2] == k)
            {
                d34 = ad3[((i + 1) - 1) + i2];
                d35 = ad3[((i + 3) - 1) + i2];
                l9 = ai2[(1 - 1) + j2];
                d36 = ad3[((i + 4) - 1) + i2];
                d37 = ad3[((i + 2) - 1) + i2];
                i10 = ai2[(4 - 1) + j2];
            } else
            {
                d34 = ad3[((i + 2) - 1) + i2];
                d35 = ad3[((i + 4) - 1) + i2];
                l9 = ai2[(2 - 1) + j2];
                d36 = ad3[((i + 3) - 1) + i2];
                d37 = ad3[((i + 1) - 1) + i2];
                i10 = ai2[(3 - 1) + j2];
            }
            if((((l9 < 0) || (l9 >= i)) || (i10 < 1)) || (i10 > i))
            {
                intw2.val = 4;
                return;
            }
        } else
        {
            double d29 = Math.max(Math.abs(ad[(1 - 1) + l]) + Math.abs(ad1[(1 - 1) + i1]), Math.abs(ad[(i - 1) + l]) + Math.abs(ad1[(i - 1 - 1) + i1]));
            int k6 = 2;
            for(int l10 = (i - 1 - 2) + 1; l10 > 0; l10--)
            {
                d29 = Math.max(d29, Math.abs(ad[(k6 - 1) + l]) + Math.abs(ad1[(k6 - 1 - 1) + i1]) + Math.abs(ad1[(k6 - 1) + i1]));
                k6++;
            }

            if(byte1 == 2)
            {
                d34 = d;
                d36 = d1;
            } else
            {
                d34 = 0.0D;
                d36 = 0.0D;
            }
        }
        intw.val = 0;
        l3 = 0;
        intw2.val = 0;
        l9 = 0;
        i10 = 0;
        j7 = 1;
        for(int i11 = (intw1.val - 1) + 1; i11 > 0; i11--)
        {
label0:
            {
                int j4 = l3;
                int l2 = j4 + 1;
                l3 = ai1[(j7 - 1) + l1];
                int i4 = l3 - j4;
                if(i4 == 1)
                {
                    if((byte1 == 1) || (d34 >= ad[(l2 - 1) + l] - d15))
                        l9++;
                    if((byte1 == 1) || (d36 >= ad[(l2 - 1) + l] - d15))
                        i10++;
                    if((byte1 == 1) || ((d34 < ad[(l2 - 1) + l] - d15) && (d36 >= ad[(l2 - 1) + l] - d15)))
                    {
                        intw.val = intw.val + 1;
                        ad2[(intw.val - 1) + j1] = ad[(l2 - 1) + l];
                        ai[(intw.val - 1) + k1] = j7;
                    }
                    break label0;
                }
                double d14 = ad[(l2 - 1) + l];
                double d11 = ad[(l2 - 1) + l];
                double d21 = 0.0D;
                int l6 = l2;
                for(int k12 = (l3 - 1 - l2) + 1; k12 > 0; k12--)
                {
                    double d26 = Math.abs(ad1[(l6 - 1) + i1]);
                    d14 = Math.max(d14, ad[(l6 - 1) + l] + d21 + d26);
                    d11 = Math.min(d11, ad[(l6 - 1) + l] - d21 - d26);
                    d21 = d26;
                    l6++;
                }

                d14 = Math.max(d14, ad[(l3 - 1) + l] + d21);
                d11 = Math.min(d11, ad[(l3 - 1) + l] - d21);
                double d8 = Math.max(Math.abs(d11), Math.abs(d14));
                d11 = d11 - 2.1000000000000001D * d8 * d30 * (double)i4 - 2.1000000000000001D * d15;
                d14 = d14 + 2.1000000000000001D * d8 * d30 * (double)i4 + 2.1000000000000001D * d15;
                double d6;
                if(d2 <= 0.0D)
                    d6 = d30 * Math.max(Math.abs(d11), Math.abs(d14));
                else
                    d6 = d2;
                if(byte1 > 1)
                {
                    if(d14 < d34)
                    {
                        l9 += i4;
                        i10 += i4;
                        break label0;
                    }
                    d11 = Math.max(d11, d34);
                    d14 = Math.min(d14, d36);
                    if(d11 >= d14)
                        break label0;
                }
                ad3[((i + 1) - 1) + i2] = d11;
                ad3[((i + i4 + 1) - 1) + i2] = d14;
                Dlaebz.dlaebz(1, 0, i4, i4, 1, k9, d6, d16, d15, ad, (l2 - 1) + l, ad1, (l2 - 1) + i1, ad3, (l2 - 1) + i2, ai3, 0, ad3, ((i + 1) - 1) + i2, ad3, ((i + 2 * i4 + 1) - 1) + i2, intw4, ai2, j2, ad2, ((intw.val + 1) - 1) + j1, ai, ((intw.val + 1) - 1) + k1, intw3);
                l9 += ai2[(1 - 1) + j2];
                i10 += ai2[((i4 + 1) - 1) + j2];
                int l5 = intw.val - ai2[(1 - 1) + j2];
                int l4 = (int)((Math.log((d14 - d11) + d15) - Math.log(d15)) / Math.log(2D)) + 2;
                Dlaebz.dlaebz(2, l4, i4, i4, 1, k9, d6, d16, d15, ad, (l2 - 1) + l, ad1, (l2 - 1) + i1, ad3, (l2 - 1) + i2, ai3, 0, ad3, ((i + 1) - 1) + i2, ad3, ((i + 2 * i4 + 1) - 1) + i2, intw5, ai2, j2, ad2, ((intw.val + 1) - 1) + j1, ai, ((intw.val + 1) - 1) + k1, intw3);
                l6 = 1;
                for(int l12 = (intw5.val - 1) + 1; l12 > 0; l12--)
                {
                    double d22 = 0.5D * (ad3[((l6 + i) - 1) + i2] + ad3[((l6 + i4 + i) - 1) + i2]);
                    int k2;
                    if(l6 > intw5.val - intw3.val)
                    {
                        flag = true;
                        k2 = -j7;
                    } else
                    {
                        k2 = j7;
                    }
                    int i8 = ai2[(l6 - 1) + j2] + 1 + l5;
                    for(int l13 = ((ai2[((l6 + i4) - 1) + j2] + l5) - (ai2[(l6 - 1) + j2] + 1 + l5)) + 1; l13 > 0; l13--)
                    {
                        ad2[(i8 - 1) + j1] = d22;
                        ai[(i8 - 1) + k1] = k2;
                        i8++;
                    }

                    l6++;
                }

                intw.val = intw.val + intw4.val;
            }
            j7++;
        }

        if(byte1 == 3)
        {
            intw4.val = 0;
            int i3 = j - 1 - l9;
            int j3 = i10 - k;
            if((i3 > 0) || (j3 > 0))
            {
                int j8 = 1;
                for(int j11 = (intw.val - 1) + 1; j11 > 0; j11--)
                {
                    if((ad2[(j8 - 1) + j1] <= d35) && (i3 > 0))
                        i3--;
                    else
                    if((ad2[(j8 - 1) + j1] >= d37) && (j3 > 0))
                    {
                        j3--;
                    } else
                    {
                        intw4.val = intw4.val + 1;
                        ad2[(intw4.val - 1) + j1] = ad2[(j8 - 1) + j1];
                        ai[(intw4.val - 1) + k1] = ai[(j8 - 1) + k1];
                    }
                    j8++;
                }

                intw.val = intw4.val;
            }
            if((i3 > 0) || (j3 > 0))
            {
                if(i3 > 0)
                {
                    double d32 = d36;
                    for(int k11 = (i3 - 1) + 1; k11 > 0; k11--)
                    {
                        int j5 = 0;
                        int k8 = 1;
                        for(int i13 = (intw.val - 1) + 1; i13 > 0; i13--)
                        {
                            if((ai[(k8 - 1) + k1] != 0) && ((ad2[(k8 - 1) + j1] < d32) || (j5 == 0)))
                            {
                                j5 = k8;
                                d32 = ad2[(k8 - 1) + j1];
                            }
                            k8++;
                        }

                        ai[(j5 - 1) + k1] = 0;
                    }

                }
                if(j3 > 0)
                {
                    double d33 = d34;
                    for(int l11 = (j3 - 1) + 1; l11 > 0; l11--)
                    {
                        int k5 = 0;
                        int l8 = 1;
                        for(int j13 = (intw.val - 1) + 1; j13 > 0; j13--)
                        {
                            if((ai[(l8 - 1) + k1] != 0) && ((ad2[(l8 - 1) + j1] > d33) || (k5 == 0)))
                            {
                                k5 = l8;
                                d33 = ad2[(l8 - 1) + j1];
                            }
                            l8++;
                        }

                        ai[(k5 - 1) + k1] = 0;
                    }

                }
                intw4.val = 0;
                int i9 = 1;
                for(int i12 = (intw.val - 1) + 1; i12 > 0; i12--)
                {
                    if(ai[(i9 - 1) + k1] != 0)
                    {
                        intw4.val = intw4.val + 1;
                        ad2[(intw4.val - 1) + j1] = ad2[(i9 - 1) + j1];
                        ai[(intw4.val - 1) + k1] = ai[(i9 - 1) + k1];
                    }
                    i9++;
                }

                intw.val = intw4.val;
            }
            if((i3 < 0) || (j3 < 0))
                flag1 = true;
        }
        if((byte0 == 1) && (intw1.val > 1))
        {
            int j9 = 1;
            for (int j12 = intw.val - 1; j12 > 0; j12--)
            {
                int k3 = 0;
                double d23 = ad2[(j9 - 1) + j1];
                int i7 = j9 + 1;
                for(int k13 = (intw.val - (j9 + 1)) + 1; k13 > 0; k13--)
                {
                    if(ad2[(i7 - 1) + j1] < d23)
                    {
                        k3 = i7;
                        d23 = ad2[(i7 - 1) + j1];
                    }
                    i7++;
                }

                if(k3 != 0)
                {
                    int i5 = ai[(k3 - 1) + k1];
                    ad2[(k3 - 1) + j1] = ad2[(j9 - 1) + j1];
                    ai[(k3 - 1) + k1] = ai[(j9 - 1) + k1];
                    ad2[(j9 - 1) + j1] = d23;
                    ai[(j9 - 1) + k1] = i5;
                }
                j9++;
            }

        }
        intw2.val = 0;
        if(flag)
            intw2.val = intw2.val + 1;
        if(flag1)
            intw2.val = intw2.val + 2;
    }
}

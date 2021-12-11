package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.*;

public final class Dlasq2
{
    public static void dlasq2(int i, double ad[], int j, intW intw)
    {
        intW intw1;
        intW intw2;
        intW intw4;
        intW intw5;
        double d25;
label0:
        {
            boolean flag = false;
            int k = 0;
            intw1 = new intW(0);
            intw2 = new intW(0);
            int k2 = 0;
            intW intw3 = new intW(0);
            intw4 = new intW(0);
            intw5 = new intW(0);
            int j3 = 0;
            intW intw6 = new intW(0);
            double d = 0.0;
            doubleW doublew = new doubleW(0.0);
            doubleW doublew1 = new doubleW(0.0);
            doubleW doublew2 = new doubleW(0.0);
            doubleW doublew3 = new doubleW(0.0);
            doubleW doublew4 = new doubleW(0.0);
            doubleW doublew5 = new doubleW(0.0);
            doubleW doublew6 = new doubleW(0.0);
            double d2 = 0.0;
            double d6 = 0.0;
            double d10 = 0.0;
            doubleW doublew7 = new doubleW(0.0);
            double d17 = 0.0;
            doubleW doublew8 = new doubleW(0.0);
            doubleW doublew9 = new doubleW(0.0);
            double d23 = 0.0;
            double d24 = 0.0;
            d25 = 0.0;
            double d26 = 0.0;
            intw.val = 0;
            d10 = Dlamch.dlamch("Precision");
            d17 = Dlamch.dlamch("Safe minimum");
            d23 = d10 * 100.0;
            d24 = Math.pow(d23, 2);
            if(i < 0)
            {
                intw.val = -1;
                Xerbla.xerbla("DLASQ2", 1);
                return;
            }
            if(i == 0)
                return;
            if(i == 1)
            {
                if(ad[(1 - 1) + j] < 0.0)
                {
                    intw.val = -201;
                    Xerbla.xerbla("DLASQ2", 2);
                }
                return;
            }
            if(i == 2)
            {
                if((ad[(2 - 1) + j] < 0.0D) || (ad[(3 - 1) + j] < 0.0D))
                {
                    intw.val = -2;
                    Xerbla.xerbla("DLASQ2", 2);
                    return;
                }
                if(ad[(3 - 1) + j] > ad[(1 - 1) + j])
                {
                    d = ad[(3 - 1) + j];
                    ad[(3 - 1) + j] = ad[(1 - 1) + j];
                    ad[(1 - 1) + j] = d;
                }
                ad[(5 - 1) + j] = ad[(1 - 1) + j] + ad[(2 - 1) + j] + ad[(3 - 1) + j];
                if(ad[(2 - 1) + j] > ad[(3 - 1) + j] * d24)
                {
                    double d19 = 0.5D * ((ad[(1 - 1) + j] - ad[(3 - 1) + j]) + ad[(2 - 1) + j]);
                    double d16 = ad[(3 - 1) + j] * (ad[(2 - 1) + j] / d19);
                    if(d16 <= d19)
                        d16 = ad[(3 - 1) + j] * (ad[(2 - 1) + j] / (d19 * (1.0D + Math.sqrt(1.0D + d16 / d19))));
                    else
                        d16 = ad[(3 - 1) + j] * (ad[(2 - 1) + j] / (d19 + Math.sqrt(d19) * Math.sqrt(d19 + d16)));
                    d19 = ad[(1 - 1) + j] + (d16 + ad[(2 - 1) + j]);
                    ad[(3 - 1) + j] = ad[(3 - 1) + j] * (ad[(1 - 1) + j] / d19);
                    ad[(1 - 1) + j] = d19;
                }
                ad[(2 - 1) + j] = ad[(3 - 1) + j];
                ad[(6 - 1) + j] = ad[(2 - 1) + j] + ad[(1 - 1) + j];
                return;
            }
            ad[(2 * i - 1) + j] = 0.0D;
            d6 = ad[(2 - 1) + j];
            doublew7.val = 0.0D;
            d26 = 0.0D;
            d = 0.0D;
            d2 = 0.0D;
            k2 = 1;
            for(int i4 = ((2 * (i - 1) - 1) + 2) / 2; i4 > 0; i4--)
            {
                if(ad[(k2 - 1) + j] < 0.0D)
                {
                    intw.val = -(200 + k2);
                    Xerbla.xerbla("DLASQ2", 2);
                    return;
                }
                if(ad[((k2 + 1) - 1) + j] < 0.0D)
                {
                    intw.val = -(200 + k2 + 1);
                    Xerbla.xerbla("DLASQ2", 2);
                    return;
                }
                d += ad[(k2 - 1) + j];
                d2 += ad[((k2 + 1) - 1) + j];
                doublew7.val = Math.max(doublew7.val, ad[(k2 - 1) + j]);
                d6 = Math.min(d6, ad[((k2 + 1) - 1) + j]);
                d26 = Util.max(doublew7.val, d26, ad[((k2 + 1) - 1) + j]);
                k2 += 2;
            }

            if(ad[(2 * i - 1 - 1) + j] < 0.0D)
            {
                intw.val = -((200 + 2 * i) - 1);
                Xerbla.xerbla("DLASQ2", 2);
                return;
            }
            d += ad[(2 * i - 1 - 1) + j];
            doublew7.val = Math.max(doublew7.val, ad[(2 * i - 1 - 1) + j]);
            d26 = Math.max(doublew7.val, d26);
            if(d2 == 0.0D)
            {
                k2 = 2;
                for(int j4 = (i - 2) + 1; j4 > 0; j4--)
                {
                    ad[(k2 - 1) + j] = ad[(2 * k2 - 1 - 1) + j];
                    k2++;
                }

                Dlasrt.dlasrt("D", i, ad, j, intw1);
                ad[(2 * i - 1 - 1) + j] = d;
                return;
            }
            d25 = d + d2;
            if(d25 == 0.0D)
            {
                ad[(2 * i - 1 - 1) + j] = 0.0D;
                return;
            }
            flag = (Ilaenv.ilaenv(10, "DLASQ2", "N", 1, 2, 3, 4) == 1) && (Ilaenv.ilaenv(11, "DLASQ2", "N", 1, 2, 3, 4) == 1);
            k2 = 2 * i;
            for(int k4 = ((2 - 2 * i) + -2) / -2; k4 > 0; k4--)
            {
                ad[(2 * k2 - 1) + j] = 0.0D;
                ad[(2 * k2 - 1 - 1) + j] = ad[(k2 - 1) + j];
                ad[(2 * k2 - 2 - 1) + j] = 0.0D;
                ad[(2 * k2 - 3 - 1) + j] = ad[(k2 - 1 - 1) + j];
                k2 += -2;
            }

            k = 1;
            intw3.val = i;
            if(1.5D * ad[(4 * k - 3 - 1) + j] < ad[(4 * intw3.val - 3 - 1) + j])
            {
                int l1 = 4 * (k + intw3.val);
                int l = 4 * k;
                for(int l4 = ((2 * ((k + intw3.val) - 1) - 4 * k) + 4) / 4; l4 > 0; l4--)
                {
                    double d21 = ad[(l - 3 - 1) + j];
                    ad[(l - 3 - 1) + j] = ad[(l1 - l - 3 - 1) + j];
                    ad[(l1 - l - 3 - 1) + j] = d21;
                    d21 = ad[(l - 1 - 1) + j];
                    ad[(l - 1 - 1) + j] = ad[(l1 - l - 5 - 1) + j];
                    ad[(l1 - l - 5 - 1) + j] = d21;
                    l += 4;
                }

            }
            j3 = 0;
            k2 = 1;
            for(int i5 = (2 - 1) + 1; i5 > 0; i5--)
            {
                double d1 = ad[((4 * intw3.val + j3) - 3 - 1) + j];
                int i1 = 4 * (intw3.val - 1) + j3;
                for(int i6 = (((4 * k + j3) - (4 * (intw3.val - 1) + j3)) + -4) / -4; i6 > 0; i6--)
                {
                    if(ad[(i1 - 1 - 1) + j] <= d24 * d1)
                    {
                        ad[(i1 - 1 - 1) + j] = 0.0D;
                        d1 = ad[(i1 - 3 - 1) + j];
                    } else
                    {
                        d1 = ad[(i1 - 3 - 1) + j] * (d1 / (d1 + ad[(i1 - 1 - 1) + j]));
                    }
                    i1 += -4;
                }

                double d7 = ad[((4 * k + j3 + 1) - 1) + j];
                d1 = ad[((4 * k + j3) - 3 - 1) + j];
                i1 = 4 * k + j3;
                for(int j6 = (((4 * (intw3.val - 1) + j3) - (4 * k + j3)) + 4) / 4; j6 > 0; j6--)
                {
                    ad[(i1 - 2 * j3 - 2 - 1) + j] = d1 + ad[(i1 - 1 - 1) + j];
                    if(ad[(i1 - 1 - 1) + j] <= d24 * d1)
                    {
                        ad[(i1 - 1 - 1) + j] = 0.0D;
                        ad[(i1 - 2 * j3 - 2 - 1) + j] = d1;
                        ad[(i1 - 2 * j3 - 1) + j] = 0.0D;
                        d1 = ad[((i1 + 1) - 1) + j];
                    } else
                    if((d17 * ad[((i1 + 1) - 1) + j] < ad[(i1 - 2 * j3 - 2 - 1) + j]) && (d17 * ad[(i1 - 2 * j3 - 2 - 1) + j] < ad[((i1 + 1) - 1) + j]))
                    {
                        double d22 = ad[((i1 + 1) - 1) + j] / ad[(i1 - 2 * j3 - 2 - 1) + j];
                        ad[(i1 - 2 * j3 - 1) + j] = ad[(i1 - 1 - 1) + j] * d22;
                        d1 *= d22;
                    } else
                    {
                        ad[(i1 - 2 * j3 - 1) + j] = ad[((i1 + 1) - 1) + j] * (ad[(i1 - 1 - 1) + j] / ad[(i1 - 2 * j3 - 2 - 1) + j]);
                        d1 = ad[((i1 + 1) - 1) + j] * (d1 / ad[(i1 - 2 * j3 - 2 - 1) + j]);
                    }
                    d7 = Math.min(d7, ad[(i1 - 2 * j3 - 1) + j]);
                    i1 += 4;
                }

                ad[(4 * intw3.val - j3 - 2 - 1) + j] = d1;
                doublew7.val = ad[(4 * k - j3 - 2 - 1) + j];
                i1 = (4 * k - j3) + 2;
                for(int k6 = ((4 * intw3.val - j3 - 2 - ((4 * k - j3) + 2)) + 4) / 4; k6 > 0; k6--)
                {
                    doublew7.val = Math.max(doublew7.val, ad[(i1 - 1) + j]);
                    i1 += 4;
                }

                j3 = 1 - j3;
                k2++;
            }

            intw6.val = 0;
            doublew2.val = 0.0D;
            doublew3.val = 0.0D;
            doublew4.val = 0.0D;
            doublew5.val = 0.0D;
            doublew6.val = 0.0D;
            doublew9.val = 0.0D;
            intw2.val = 2;
            intw5.val = 0;
            intw4.val = 2 * (intw3.val - k);

            for(int j5 = ((i + 1) - 1) + 1; j5 > 0; j5--)
            {
                int j1;
                double d5;
                double d8;
                double d14;
label1:
                {
                    if(intw3.val < 1)
                        break label0;
                    doublew.val = 0.0D;
                    if(intw3.val == i)
                        doublew8.val = 0.0D;
                    else
                        doublew8.val = -ad[(4 * intw3.val - 1 - 1) + j];
                    if(doublew8.val < 0.0D)
                    {
                        intw.val = 1;
                        return;
                    }
                    d5 = 0.0D;
                    if(intw3.val > k)
                        d8 = Math.abs(ad[(4 * intw3.val - 5 - 1) + j]);
                    else
                        d8 = 0.0D;
                    d14 = ad[(4 * intw3.val - 3 - 1) + j];
                    doublew7.val = d14;
                    j1 = 4 * intw3.val;
                    for(int l6 = ((8 - 4 * intw3.val) + -4) / -4; l6 > 0; l6--)
                    {
                        if(ad[(j1 - 5 - 1) + j] <= 0.0D)
                            break label1;
                        if(d14 >= 4D * d5)
                        {
                            d14 = Math.min(d14, ad[(j1 - 3 - 1) + j]);
                            d5 = Math.max(d5, ad[(j1 - 5 - 1) + j]);
                        }
                        doublew7.val = Math.max(doublew7.val, ad[(j1 - 7 - 1) + j] + ad[(j1 - 5 - 1) + j]);
                        d8 = Math.min(d8, ad[(j1 - 5 - 1) + j]);
                        j1 += -4;
                    }

                    j1 = 4;
                }
label2:
                {
                    k = j1 / 4;
                    ad[(4 * intw3.val - 1 - 1) + j] = d8;
                    doublew1.val = -Math.max(0.0D, d14 - 2D * Math.sqrt(d14) * Math.sqrt(d5));
                    int k3 = 0;
                    int i3 = 30 * ((intw3.val - k) + 1);
                    for(int i7 = (i3 - 1) + 1; i7 > 0; i7--)
                    {
                        if(k > intw3.val)
                            break label2;
                        Dlazq3.dlazq3(k, intw3, ad, j, k3, doublew1, doublew8, doublew, doublew7, intw5, intw2, intw4, flag, intw6, doublew2, doublew3, doublew4, doublew5, doublew6, doublew9);
                        k3 = 1 - k3;
                        if(((k3 == 0) && (intw3.val - k >= 3)) && ((ad[(4 * intw3.val - 1) + j] <= d24 * doublew7.val) || (ad[(4 * intw3.val - 1 - 1) + j] <= d24 * doublew8.val)))
                        {
                            int l3 = k - 1;
                            doublew7.val = ad[(4 * k - 3 - 1) + j];
                            double d9 = ad[(4 * k - 1 - 1) + j];
                            double d12 = ad[(4 * k - 1) + j];
                            int k1 = 4 * k;
                            for(int j7 = ((4 * (intw3.val - 3) - 4 * k) + 4) / 4; j7 > 0; j7--)
                            {
                                if((ad[(k1 - 1) + j] <= d24 * ad[(k1 - 3 - 1) + j]) || (ad[(k1 - 1 - 1) + j] <= d24 * doublew8.val))
                                {
                                    ad[(k1 - 1 - 1) + j] = -doublew8.val;
                                    l3 = k1 / 4;
                                    doublew7.val = 0.0D;
                                    d9 = ad[((k1 + 3) - 1) + j];
                                    d12 = ad[((k1 + 4) - 1) + j];
                                } else
                                {
                                    doublew7.val = Math.max(doublew7.val, ad[((k1 + 1) - 1) + j]);
                                    d9 = Math.min(d9, ad[(k1 - 1 - 1) + j]);
                                    d12 = Math.min(d12, ad[(k1 - 1) + j]);
                                }
                                k1 += 4;
                            }

                            ad[(4 * intw3.val - 1 - 1) + j] = d9;
                            ad[(4 * intw3.val - 1) + j] = d12;
                            k = l3 + 1;
                        }
                    }

                    intw.val = 2;
                    return;
                }
            }

            intw.val = 3;
            return;
        }
        int l2 = 2;
        for(int k5 = (i - 2) + 1; k5 > 0; k5--)
        {
            ad[(l2 - 1) + j] = ad[(4 * l2 - 3 - 1) + j];
            l2++;
        }

        Dlasrt.dlasrt("D", i, ad, j, intw1);
        double d3 = 0.0D;
        l2 = i;
        for(int l5 = ((1 - i) + -1) / -1; l5 > 0; l5--)
        {
            d3 += ad[(l2 - 1) + j];
            l2--;
        }

        ad[((2 * i + 1) - 1) + j] = d25;
        ad[((2 * i + 2) - 1) + j] = d3;
        ad[((2 * i + 3) - 1) + j] = intw2.val;
        ad[((2 * i + 4) - 1) + j] = (double)intw4.val / (double)(int)Math.pow(i, 2);
        ad[((2 * i + 5) - 1) + j] = (100D * (double)intw5.val) / (double)intw2.val;
    }
}

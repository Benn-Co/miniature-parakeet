package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.*;

public final class Dbdsqr
{
    public static void dbdsqr(String s, int i, int j, int k, int l, double ad[], int i1, double ad1[], 
            int j1, double ad2[], int k1, int l1, double ad3[], int i2, int j2, 
            double ad4[], int k2, int l2, double ad5[], int i3, intW intw)
    {
label0:
        {
label1:
            {
                boolean flag = false;
                int j3 = 0;
                doubleW doublew = new doubleW(0.0D);
                doubleW doublew1 = new doubleW(0.0D);
                doubleW doublew2 = new doubleW(0.0D);
                doubleW doublew3 = new doubleW(0.0D);
                doubleW doublew4 = new doubleW(0.0D);
                doubleW doublew5 = new doubleW(0.0D);
                doubleW doublew6 = new doubleW(0.0D);
                doubleW doublew7 = new doubleW(0.0D);
                doubleW doublew8 = new doubleW(0.0D);
                doubleW doublew9 = new doubleW(0.0D);
                doubleW doublew10 = new doubleW(0.0D);
                doubleW doublew11 = new doubleW(0.0D);
                intw.val = 0;
                flag = Lsame.lsame(s, "L");
                if (!Lsame.lsame(s, "U") && !flag)
                    intw.val = -1;
                else
                if(i < 0)
                    intw.val = -2;
                else
                if(j < 0)
                    intw.val = -3;
                else
                if(k < 0)
                    intw.val = -4;
                else
                if(l < 0)
                    intw.val = -5;
                else
                if(((j == 0) && (l1 < 1)) || ((j > 0) && (l1 < Math.max(1, i))))
                    intw.val = -9;
                else
                if(j2 < Math.max(1, k))
                    intw.val = -11;
                else
                if(((l == 0) && (l2 < 1)) || ((l > 0) && (l2 < Math.max(1, i))))
                    intw.val = -13;
                if(intw.val != 0)
                {
                    Xerbla.xerbla("DBDSQR", -intw.val);
                    return;
                }
                if(i == 0)
                    return;
                if(i != 1)
                {
                    boolean flag2 = ((j > 0) || (k > 0)) || (l > 0);
                    if(flag2 ^ true)
                    {
                        Dlasq1.dlasq1(i, ad, i1, ad1, j1, ad5, i3, intw);
                        return;
                    }
                    int i6 = i - 1;
                    int j6 = i6 + i6;
                    int k6 = j6 + i6;
                    byte byte0 = 0;
                    double d5 = Dlamch.dlamch("Epsilon");
                    double d38 = Dlamch.dlamch("Safe minimum");
                    if(flag)
                    {
                        j3 = 1;
                        for(int j7 = (i - 1 - 1) + 1; j7 > 0; j7--)
                        {
                            Dlartg.dlartg(ad[(j3 - 1) + i1], ad1[(j3 - 1) + j1], doublew2, doublew11, doublew5);
                            ad[(j3 - 1) + i1] = doublew5.val;
                            ad1[(j3 - 1) + j1] = doublew11.val * ad[((j3 + 1) - 1) + i1];
                            ad[((j3 + 1) - 1) + i1] = doublew2.val * ad[((j3 + 1) - 1) + i1];
                            ad5[(j3 - 1) + i3] = doublew2.val;
                            ad5[((i6 + j3) - 1) + i3] = doublew11.val;
                            j3++;
                        }

                        if(k > 0)
                            Dlasr.dlasr("R", "V", "F", k, i, ad5, i3, ad5, (i - 1) + i3, ad3, i2, j2);
                        if(l > 0)
                            Dlasr.dlasr("L", "V", "F", i, l, ad5, i3, ad5, (i - 1) + i3, ad4, k2, l2);
                    }
                    double d36 = Math.max(10.0, Math.min(100.0, Math.pow(d5, -0.125)));
                    double d34 = d36 * d5;
                    double d22 = 0.0;
                    j3 = 1;
                    for(int k7 = i; k7 > 0; k7--)
                    {
                        d22 = Math.max(d22, Math.abs(ad[(j3 - 1) + i1]));
                        j3++;
                    }

                    j3 = 1;
                    for(int l7 = i - 1; l7 > 0; l7--)
                    {
                        d22 = Math.max(d22, Math.abs(ad1[(j3 - 1) + j1]));
                        j3++;
                    }

                    double d28 = 0.0;
                    double d32;
                    if(d34 >= 0.0)
                    {
                        double d30 = Math.abs(ad[i1]);
                        if(d30 != 0.0)
                        {
                            double d16 = d30;
                            j3 = 2;
                            for(int i8 = i - 1; i8 > 0; i8--)
                            {
                                d16 = Math.abs(ad[(j3 - 1) + i1]) * (d16 / (d16 + Math.abs(ad1[(j3 - 2) + j1])));
                                d30 = Math.min(d30, d16);
                                if (d30 == 0.0)
                                    break;
                                j3++;
                            }

                        }
                        d30 /= Math.sqrt(i);
                        d32 = Math.max(d34 * d30, (double)(6 * i * i) * d38);
                    } else
                    {
                        d32 = Math.max(Math.abs(d34) * d22, (double)(6 * i * i) * d38);
                    }
                    int l5 = 6 * i * i;
                    int i4 = 0;
                    int l6 = -1;
                    int i7 = -1;
                    int k5 = i;
label2:
                    do
                    {
                        int k4;
                        double d23;
label3:
                        {
label4:
                            {
                                if(k5 <= 1)
                                    break label2;
                                if(i4 > l5)
                                    break label1;
                                if((d34 < 0.0) && (Math.abs(ad[(k5 - 1) + i1]) <= d32))
                                    ad[(k5 - 1) + i1] = 0.0;
                                d23 = Math.abs(ad[(k5 - 1) + i1]);
                                double d25 = d23;
                                int l4 = 1;
                                for (int j8 = k5 - 1; j8 > 0; j8--)
                                {
                                    k4 = k5 - l4;
                                    double d3 = Math.abs(ad[(k4 - 1) + i1]);
                                    double d1 = Math.abs(ad1[(k4 - 1) + j1]);
                                    if((d34 < 0.0) && (d3 <= d32))
                                        ad[(k4 - 1) + i1] = 0.0;
                                    if(d1 <= d32)
                                        break label4;
                                    d25 = Math.min(d25, d3);
                                    d23 = Util.max(d23, d3, d1);
                                    l4++;
                                }

                                k4 = 0;
                                break label3;
                            }
                            ad1[(k4 - 1) + j1] = 0.0;
                            if(k4 == k5 - 1)
                            {
                                k5--;
                                continue;
                            }
                        }
                        k4++;
                        if(k4 == k5 - 1)
                        {
                            Dlasv2.dlasv2(ad[(k5 - 2) + i1], ad1[(k5 - 2) + j1], ad[(k5 - 1) + i1], doublew7, doublew8, doublew10, doublew1, doublew9, doublew);
                            ad[(k5 - 2) + i1] = doublew8.val;
                            ad1[(k5 - 2) + j1] = 0.0;
                            ad[(k5 - 1) + i1] = doublew7.val;
                            if(j > 0)
                                Drot.drot(j, ad2, (k5 - 2) + k1, l1, ad2, (k5 - 1) + k1, l1, doublew1.val, doublew10.val);
                            if(k > 0)
                                Drot.drot(k, ad3, (k5 - 2) * j2 + i2, 1, ad3, (k5 - 1) * j2 + i2, 1, doublew.val, doublew9.val);
                            if(l > 0)
                                Drot.drot(l, ad4, (k5 - 2) + k2, l2, ad4, (k5 - 1) + k2, l2, doublew.val, doublew9.val);
                            k5 -= 2;
                            continue;
                        }
                        if((k4 > i7) || (k5 < l6))
                            if(Math.abs(ad[(k4 - 1) + i1]) >= Math.abs(ad[(k5 - 1) + i1]))
                                byte0 = 1;
                            else
                                byte0 = 2;
                        if(byte0 == 1)
                        {
                            if((Math.abs(ad1[(k5 - 2) + j1]) <= Math.abs(d34) * Math.abs(ad[(k5 - 1) + i1])) || ((d34 < 0.0) && (Math.abs(ad1[(k5 - 2) + j1]) <= d32)))
                            {
                                ad1[(k5 - 2) + j1] = 0.0;
                                continue;
                            }
                            if(d34 >= 0.0)
                            {
                                double d17 = Math.abs(ad[(k4 - 1) + i1]);
                                d28 = d17;
                                int i5 = k4;
                                for(int k8 = (k5 - 1 - k4) + 1; k8 > 0; k8--)
                                {
                                    if(Math.abs(ad1[(i5 - 1) + j1]) <= d34 * d17)
                                    {
                                        ad1[(i5 - 1) + j1] = 0.0;
                                        continue label2;
                                    }
                                    d17 = Math.abs(ad[i5 + i1]) * (d17 / (d17 + Math.abs(ad1[(i5 - 1) + j1])));
                                    d28 = Math.min(d28, d17);
                                    i5++;
                                }

                            }
                        } else
                        {
                            if((Math.abs(ad1[(k4 - 1) + j1]) <= Math.abs(d34) * Math.abs(ad[(k4 - 1) + i1])) || ((d34 < 0.0) && (Math.abs(ad1[(k4 - 1) + j1]) <= d32)))
                            {
                                ad1[(k4 - 1) + j1] = 0.0;
                                continue;
                            }
                            if(d34 >= 0.0)
                            {
                                double d18 = Math.abs(ad[(k5 - 1) + i1]);
                                d28 = d18;
                                int j5 = k5 - 1;
                                for(int l8 = ((k4 - (k5 - 1)) + -1) / -1; l8 > 0; l8--)
                                {
                                    if(Math.abs(ad1[(j5 - 1) + j1]) <= d34 * d18)
                                    {
                                        ad1[(j5 - 1) + j1] = 0.0;
                                        continue label2;
                                    }
                                    d18 = Math.abs(ad[(j5 - 1) + i1]) * (d18 / (d18 + Math.abs(ad1[(j5 - 1) + j1])));
                                    d28 = Math.min(d28, d18);
                                    j5--;
                                }

                            }
                        }
                        l6 = k4;
                        i7 = k5;
                        if ((d34 >= 0.0) && ((double)i * d34 * (d28 / d23) <= Math.max(d5, 0.01 * d34)))
                        {
                            doublew6.val = 0.0;
                        } else
                        {
                            double d20;
                            if(byte0 == 1)
                            {
                                d20 = Math.abs(ad[(k4 - 1) + i1]);
                                Dlas2.dlas2(ad[(k5 - 2) + i1], ad1[(k5 - 2) + j1], ad[(k5 - 1) + i1], doublew6, doublew5);
                            } else
                            {
                                d20 = Math.abs(ad[(k5 - 1) + i1]);
                                Dlas2.dlas2(ad[(k4 - 1) + i1], ad1[(k4 - 1) + j1], ad[((k4 + 1) - 1) + i1], doublew6, doublew5);
                            }
                            if((d20 > 0.0) && (Math.pow(doublew6.val / d20, 2.0) < d5))
                                doublew6.val = 0.0;
                        }
                        i4 = (i4 + k5) - k4;
                        if(doublew6.val == 0.0)
                        {
                            if(byte0 == 1)
                            {
                                doublew2.val = 1.0;
                                doublew3.val = 1.0;
                                j3 = k4;
                                for(int i9 = (k5 - 1 - k4) + 1; i9 > 0; i9--)
                                {
                                    Dlartg.dlartg(ad[(j3 - 1) + i1] * doublew2.val, ad1[(j3 - 1) + j1], doublew2, doublew11, doublew5);
                                    if(j3 > k4)
                                        ad1[(j3 - 2) + j1] = doublew4.val * doublew5.val;
                                    dlartg_adapter(doublew3.val * doublew5.val, ad[((j3 + 1) - 1) + i1] * doublew11.val, doublew3, doublew4, ad, (j3 - 1) + i1);
                                    ad5[(((j3 - k4) + 1) - 1) + i3] = doublew2.val;
                                    ad5[(((j3 - k4) + 1 + i6) - 1) + i3] = doublew11.val;
                                    ad5[(((j3 - k4) + 1 + j6) - 1) + i3] = doublew3.val;
                                    ad5[(((j3 - k4) + 1 + k6) - 1) + i3] = doublew4.val;
                                    j3++;
                                }

                                double d13 = ad[(k5 - 1) + i1] * doublew2.val;
                                ad[(k5 - 1) + i1] = d13 * doublew3.val;
                                ad1[(k5 - 2) + j1] = d13 * doublew4.val;
                                if(j > 0)
                                    Dlasr.dlasr("L", "V", "F", (k5 - k4) + 1, j, ad5, i3, ad5, (i - 1) + i3, ad2, (k4 - 1) + k1, l1);
                                if(k > 0)
                                    Dlasr.dlasr("R", "V", "F", k, (k5 - k4) + 1, ad5, ((j6 + 1) - 1) + i3, ad5, ((k6 + 1) - 1) + i3, ad3, (k4 - 1) * j2 + i2, j2);
                                if(l > 0)
                                    Dlasr.dlasr("L", "V", "F", (k5 - k4) + 1, l, ad5, ((j6 + 1) - 1) + i3, ad5, ((k6 + 1) - 1) + i3, ad4, (k4 - 1) + k2, l2);
                                if(Math.abs(ad1[(k5 - 2) + j1]) <= d32)
                                    ad1[(k5 - 2) + j1] = 0.0;
                            } else
                            {
                                doublew2.val = 1.0;
                                doublew3.val = 1.0;
                                j3 = k5;
                                for(int j9 = (((k4 + 1) - k5) + -1) / -1; j9 > 0; j9--)
                                {
                                    Dlartg.dlartg(ad[(j3 - 1) + i1] * doublew2.val, ad1[(j3 - 2) + j1], doublew2, doublew11, doublew5);
                                    if(j3 < k5)
                                        ad1[(j3 - 1) + j1] = doublew4.val * doublew5.val;
                                    dlartg_adapter(doublew3.val * doublew5.val, ad[(j3 - 2) + i1] * doublew11.val, doublew3, doublew4, ad, (j3 - 1) + i1);
                                    ad5[(j3 - k4 - 1) + i3] = doublew2.val;
                                    ad5[(((j3 - k4) + i6) - 1) + i3] = -doublew11.val;
                                    ad5[(((j3 - k4) + j6) - 1) + i3] = doublew3.val;
                                    ad5[(((j3 - k4) + k6) - 1) + i3] = -doublew4.val;
                                    j3--;
                                }

                                double d14 = ad[(k4 - 1) + i1] * doublew2.val;
                                ad[(k4 - 1) + i1] = d14 * doublew3.val;
                                ad1[(k4 - 1) + j1] = d14 * doublew4.val;
                                if(j > 0)
                                    Dlasr.dlasr("L", "V", "B", (k5 - k4) + 1, j, ad5, ((j6 + 1) - 1) + i3, ad5, ((k6 + 1) - 1) + i3, ad2, (k4 - 1) + k1, l1);
                                if(k > 0)
                                    Dlasr.dlasr("R", "V", "B", k, (k5 - k4) + 1, ad5, i3, ad5, (i - 1) + i3, ad3, (k4 - 1) * j2 + i2, j2);
                                if(l > 0)
                                    Dlasr.dlasr("L", "V", "B", (k5 - k4) + 1, l, ad5, i3, ad5, (i - 1) + i3, ad4, (k4 - 1) + k2, l2);
                                if(Math.abs(ad1[(k4 - 1) + j1]) <= d32)
                                    ad1[(k4 - 1) + j1] = 0.0;
                            }
                        } else
                        if(byte0 == 1)
                        {
                            double d7 = (Math.abs(ad[(k4 - 1) + i1]) - doublew6.val) * (Util.dsign(1.0, ad[(k4 - 1) + i1]) + doublew6.val / ad[(k4 - 1) + i1]);
                            double d10 = ad1[(k4 - 1) + j1];
                            j3 = k4;
                            for(int k9 = (k5 - 1 - k4) + 1; k9 > 0; k9--)
                            {
                                Dlartg.dlartg(d7, d10, doublew1, doublew10, doublew5);
                                if(j3 > k4)
                                    ad1[(j3 - 2) + j1] = doublew5.val;
                                d7 = doublew1.val * ad[(j3 - 1) + i1] + doublew10.val * ad1[(j3 - 1) + j1];
                                ad1[(j3 - 1) + j1] = doublew1.val * ad1[(j3 - 1) + j1] - doublew10.val * ad[(j3 - 1) + i1];
                                d10 = doublew10.val * ad[((j3 + 1) - 1) + i1];
                                ad[((j3 + 1) - 1) + i1] = doublew1.val * ad[((j3 + 1) - 1) + i1];
                                Dlartg.dlartg(d7, d10, doublew, doublew9, doublew5);
                                ad[(j3 - 1) + i1] = doublew5.val;
                                d7 = doublew.val * ad1[(j3 - 1) + j1] + doublew9.val * ad[((j3 + 1) - 1) + i1];
                                ad[((j3 + 1) - 1) + i1] = doublew.val * ad[((j3 + 1) - 1) + i1] - doublew9.val * ad1[(j3 - 1) + j1];
                                if(j3 < k5 - 1)
                                {
                                    d10 = doublew9.val * ad1[((j3 + 1) - 1) + j1];
                                    ad1[((j3 + 1) - 1) + j1] = doublew.val * ad1[((j3 + 1) - 1) + j1];
                                }
                                ad5[(((j3 - k4) + 1) - 1) + i3] = doublew1.val;
                                ad5[(((j3 - k4) + 1 + i6) - 1) + i3] = doublew10.val;
                                ad5[(((j3 - k4) + 1 + j6) - 1) + i3] = doublew.val;
                                ad5[(((j3 - k4) + 1 + k6) - 1) + i3] = doublew9.val;
                                j3++;
                            }

                            ad1[(k5 - 2) + j1] = d7;
                            if(j > 0)
                                Dlasr.dlasr("L", "V", "F", (k5 - k4) + 1, j, ad5, i3, ad5, (i - 1) + i3, ad2, (k4 - 1) + k1, l1);
                            if(k > 0)
                                Dlasr.dlasr("R", "V", "F", k, (k5 - k4) + 1, ad5, ((j6 + 1) - 1) + i3, ad5, ((k6 + 1) - 1) + i3, ad3, (k4 - 1) * j2 + i2, j2);
                            if(l > 0)
                                Dlasr.dlasr("L", "V", "F", (k5 - k4) + 1, l, ad5, ((j6 + 1) - 1) + i3, ad5, ((k6 + 1) - 1) + i3, ad4, (k4 - 1) + k2, l2);
                            if(Math.abs(ad1[(k5 - 1 - 1) + j1]) <= d32)
                                ad1[(k5 - 1 - 1) + j1] = 0.0;
                        } else
                        {
                            double d8 = (Math.abs(ad[(k5 - 1) + i1]) - doublew6.val) * (Util.dsign(1.0, ad[(k5 - 1) + i1]) + doublew6.val / ad[(k5 - 1) + i1]);
                            double d11 = ad1[(k5 - 2) + j1];
                            j3 = k5;
                            for(int l9 = (((k4 + 1) - k5) + -1) / -1; l9 > 0; l9--)
                            {
                                Dlartg.dlartg(d8, d11, doublew1, doublew10, doublew5);
                                if(j3 < k5)
                                    ad1[(j3 - 1) + j1] = doublew5.val;
                                d8 = doublew1.val * ad[(j3 - 1) + i1] + doublew10.val * ad1[(j3 - 2) + j1];
                                ad1[(j3 - 2) + j1] = doublew1.val * ad1[(j3 - 2) + j1] - doublew10.val * ad[(j3 - 1) + i1];
                                d11 = doublew10.val * ad[(j3 - 2) + i1];
                                ad[(j3 - 2) + i1] = doublew1.val * ad[(j3 - 2) + i1];
                                Dlartg.dlartg(d8, d11, doublew, doublew9, doublew5);
                                ad[(j3 - 1) + i1] = doublew5.val;
                                d8 = doublew.val * ad1[(j3 - 2) + j1] + doublew9.val * ad[(j3 - 2) + i1];
                                ad[(j3 - 2) + i1] = doublew.val * ad[(j3 - 2) + i1] - doublew9.val * ad1[(j3 - 2) + j1];
                                if(j3 > k4 + 1)
                                {
                                    d11 = doublew9.val * ad1[(j3 - 3) + j1];
                                    ad1[(j3 - 3) + j1] = doublew.val * ad1[(j3 - 3) + j1];
                                }
                                ad5[(j3 - k4 - 1) + i3] = doublew1.val;
                                ad5[(((j3 - k4) + i6) - 1) + i3] = -doublew10.val;
                                ad5[(((j3 - k4) + j6) - 1) + i3] = doublew.val;
                                ad5[(((j3 - k4) + k6) - 1) + i3] = -doublew9.val;
                                j3--;
                            }

                            ad1[(k4 - 1) + j1] = d8;
                            if(Math.abs(ad1[(k4 - 1) + j1]) <= d32)
                                ad1[(k4 - 1) + j1] = 0.0;
                            if(j > 0)
                                Dlasr.dlasr("L", "V", "B", (k5 - k4) + 1, j, ad5, ((j6 + 1) - 1) + i3, ad5, ((k6 + 1) - 1) + i3, ad2, (k4 - 1) + k1, l1);
                            if(k > 0)
                                Dlasr.dlasr("R", "V", "B", k, (k5 - k4) + 1, ad5, i3, ad5, (i - 1) + i3, ad3, (k4 - 1) * j2 + i2, j2);
                            if(l > 0)
                                Dlasr.dlasr("L", "V", "B", (k5 - k4) + 1, l, ad5, i3, ad5, (i - 1) + i3, ad4, (k4 - 1) + k2, l2);
                        }
                    } while(true);
                }
                j3 = 1;
                for(int i10 = (i - 1) + 1; i10 > 0; i10--)
                {
                    if(ad[(j3 - 1) + i1] < 0.0)
                    {
                        ad[(j3 - 1) + i1] = -ad[(j3 - 1) + i1];
                        if(j > 0)
                            Dscal.dscal(j, -1.0, ad2, (j3 - 1) + k1, l1);
                    }
                    j3++;
                }

                j3 = 1;
                for(int j10 = i - 1; j10 > 0; j10--)
                {
                    int l3 = 1;
                    double d26 = ad[i1];
                    int j4 = 2;
                    for(int l10 = ((i + 1) - j3 - 2) + 1; l10 > 0; l10--)
                    {
                        if(ad[(j4 - 1) + i1] <= d26)
                        {
                            l3 = j4;
                            d26 = ad[(j4 - 1) + i1];
                        }
                        j4++;
                    }

                    if(l3 != (i + 1) - j3)
                    {
                        ad[(l3 - 1) + i1] = ad[((i + 1) - j3 - 1) + i1];
                        ad[((i + 1) - j3 - 1) + i1] = d26;
                        if(j > 0)
                            Dswap.dswap(j, ad2, (l3 - 1) + k1, l1, ad2, ((i + 1) - j3 - 1) + k1, l1);
                        if(k > 0)
                            Dswap.dswap(k, ad3, (l3 - 1) * j2 + i2, 1, ad3, ((i + 1) - j3 - 1) * j2 + i2, 1);
                        if(l > 0)
                            Dswap.dswap(l, ad4, (l3 - 1) + k2, l2, ad4, ((i + 1) - j3 - 1) + k2, l2);
                    }
                    j3++;
                }

                break label0;
            }
            intw.val = 0;
            int k3 = 1;
            for(int k10 = (i - 1 - 1) + 1; k10 > 0; k10--)
            {
                if (ad1[(k3 - 1) + j1] != 0.0)
                    intw.val = intw.val + 1;
                k3++;
            }

        }
    }

    private static void dlartg_adapter(double d, double d1, doubleW doublew, doubleW doublew1, double ad[], int i)
    {
        doubleW doublew2 = new doubleW(ad[i]);
        Dlartg.dlartg(d, d1, doublew, doublew1, doublew2);
        ad[i] = doublew2.val;
    }
}

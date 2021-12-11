package org.netlib.arpack;

import org.netlib.lapack.*;
import org.netlib.util.*;

public final class Dstqrb
{
    public static void dstqrb(int i, double ad[], int j, double ad1[], int k, double ad2[], int l, double ad3[], 
            int i1, intW intw)
    {
label0:
        {
            byte byte0 = 0;
            int i3 = 0;
            int l3 = 0;
            int i7 = 0;
            int j7 = 0;
            doubleW doublew = new doubleW(0.0D);
            double d5 = 0.0D;
            double d6 = 0.0D;
            doubleW doublew1 = new doubleW(0.0D);
            doubleW doublew2 = new doubleW(0.0D);
            doubleW doublew3 = new doubleW(0.0D);
            doubleW doublew4 = new doubleW(0.0D);
            double d17 = 0.0D;
            double d18 = 0.0D;
            double d19 = 0.0D;
            double d20 = 0.0D;
            intw.val = 0;
            byte0 = 2;
            if(i == 0)
                return;
            if(i == 1)
            {
                if(byte0 == 2)
                    ad2[(1 - 1) + l] = 1.0D;
                return;
            }
            d5 = Dlamch.dlamch("e");
            d6 = Math.pow(d5, 2);
            d18 = Dlamch.dlamch("s");
            d17 = 1.0D / d18;
            d19 = Math.sqrt(d17) / 3D;
            d20 = Math.sqrt(d18) / d6;
            if(byte0 == 2)
            {
                int k2 = 1;
                for(int k7 = (i - 1 - 1) + 1; k7 > 0; k7--)
                {
                    ad2[(k2 - 1) + l] = 0.0D;
                    k2++;
                }

                ad2[(i - 1) + l] = 1.0D;
            }
            j7 = i * 30;
            i3 = 0;
            l3 = 1;
            i7 = i - 1;
label1:
            do
            {
                int k5;
label2:
                {
                    if(l3 > i)
                        break label1;
                    if(l3 > 1)
                        ad1[(l3 - 1 - 1) + k] = 0.0D;
                    if(l3 <= i7)
                    {
                        k5 = l3;
                        for(int l7 = (i7 - l3) + 1; l7 > 0; l7--)
                        {
                            double d22 = Math.abs(ad1[(k5 - 1) + k]);
                            if(d22 == 0.0D)
                                break label2;
                            if(d22 <= Math.sqrt(Math.abs(ad[(k5 - 1) + j])) * Math.sqrt(Math.abs(ad[((k5 + 1) - 1) + j])) * d5)
                            {
                                ad1[(k5 - 1) + k] = 0.0D;
                                break label2;
                            }
                            k5++;
                        }

                    }
                    k5 = i;
                }
                int k3 = l3;
                int j5 = k3;
                int i4 = k5;
                int l4 = i4;
                l3 = k5 + 1;
                if(i4 == k3)
                    continue;
                double d1 = Dlanst.dlanst("i", (i4 - k3) + 1, ad, (k3 - 1) + j, ad1, (k3 - 1) + k);
                byte byte1 = 0;
                if(d1 == 0.0D)
                    continue;
                if(d1 > d19)
                {
                    byte1 = 1;
                    Dlascl.dlascl("g", 0, 0, d1, d19, (i4 - k3) + 1, 1, ad, (k3 - 1) + j, i, intw);
                    Dlascl.dlascl("g", 0, 0, d1, d19, i4 - k3, 1, ad1, (k3 - 1) + k, i, intw);
                } else
                if(d1 < d20)
                {
                    byte1 = 2;
                    Dlascl.dlascl("g", 0, 0, d1, d20, (i4 - k3) + 1, 1, ad, (k3 - 1) + j, i, intw);
                    Dlascl.dlascl("g", 0, 0, d1, d20, i4 - k3, 1, ad1, (k3 - 1) + k, i, intw);
                }
                if(Math.abs(ad[(i4 - 1) + j]) < Math.abs(ad[(k3 - 1) + j]))
                {
                    i4 = j5;
                    k3 = l4;
                }
                if(i4 > k3)
label3:
                    do
                    {
                        double d14;
                        do
                        {
                            int l5;
label4:
                            {
                                if(k3 != i4)
                                {
                                    int j4 = i4 - 1;
                                    l5 = k3;
                                    for(int i8 = (j4 - k3) + 1; i8 > 0; i8--)
                                    {
                                        double d23 = Math.pow(Math.abs(ad1[(l5 - 1) + k]), 2);
                                        if(d23 <= d6 * Math.abs(ad[(l5 - 1) + j]) * Math.abs(ad[((l5 + 1) - 1) + j]) + d18)
                                            break label4;
                                        l5++;
                                    }

                                }
                                l5 = i4;
                            }
                            if(l5 < i4)
                                ad1[(l5 - 1) + k] = 0.0D;
                            d14 = ad[(k3 - 1) + j];
                            if(l5 == k3)
                                break;
                            if(l5 == k3 + 1)
                            {
                                if(byte0 > 0)
                                {
                                    Dlaev2.dlaev2(ad[(k3 - 1) + j], ad1[(k3 - 1) + k], ad[((k3 + 1) - 1) + j], doublew2, doublew3, doublew, doublew4);
                                    ad3[(k3 - 1) + i1] = doublew.val;
                                    ad3[(((i - 1) + k3) - 1) + i1] = doublew4.val;
                                    double d24 = ad2[((k3 + 1) - 1) + l];
                                    ad2[((k3 + 1) - 1) + l] = doublew.val * d24 - doublew4.val * ad2[(k3 - 1) + l];
                                    ad2[(k3 - 1) + l] = doublew4.val * d24 + doublew.val * ad2[(k3 - 1) + l];
                                } else
                                {
                                    Dlae2.dlae2(ad[(k3 - 1) + j], ad1[(k3 - 1) + k], ad[((k3 + 1) - 1) + j], doublew2, doublew3);
                                }
                                ad[(k3 - 1) + j] = doublew2.val;
                                ad[((k3 + 1) - 1) + j] = doublew3.val;
                                ad1[(k3 - 1) + k] = 0.0D;
                                k3 += 2;
                                if(k3 > i4)
                                    break label3;
                            } else
                            {
                                if(i3 == j7)
                                    break label3;
                                i3++;
                                double d11 = (ad[((k3 + 1) - 1) + j] - d14) / (2D * ad1[(k3 - 1) + k]);
                                doublew1.val = Dlapy2.dlapy2(d11, 1.0D);
                                d11 = (ad[(l5 - 1) + j] - d14) + ad1[(k3 - 1) + k] / (d11 + Util.dsign(doublew1.val, d11));
                                doublew4.val = 1.0D;
                                doublew.val = 1.0D;
                                d14 = 0.0D;
                                int l6 = l5 - 1;
                                int j1 = l6;
                                for(int j8 = ((k3 - l6) + -1) / -1; j8 > 0; j8--)
                                {
                                    double d8 = doublew4.val * ad1[(j1 - 1) + k];
                                    double d3 = doublew.val * ad1[(j1 - 1) + k];
                                    Dlartg.dlartg(d11, d8, doublew, doublew4, doublew1);
                                    if(j1 != l5 - 1)
                                        ad1[((j1 + 1) - 1) + k] = doublew1.val;
                                    d11 = ad[((j1 + 1) - 1) + j] - d14;
                                    doublew1.val = (ad[(j1 - 1) + j] - d11) * doublew4.val + 2D * doublew.val * d3;
                                    d14 = doublew4.val * doublew1.val;
                                    ad[((j1 + 1) - 1) + j] = d11 + d14;
                                    d11 = doublew.val * doublew1.val - d3;
                                    if(byte0 > 0)
                                    {
                                        ad3[(j1 - 1) + i1] = doublew.val;
                                        ad3[(((i - 1) + j1) - 1) + i1] = -doublew4.val;
                                    }
                                    j1--;
                                }

                                if(byte0 > 0)
                                {
                                    int j6 = (l5 - k3) + 1;
                                    Dlasr.dlasr("r", "v", "b", 1, j6, ad3, (k3 - 1) + i1, ad3, (((i - 1) + k3) - 1) + i1, ad2, (k3 - 1) + l, 1);
                                }
                                ad[(k3 - 1) + j] = ad[(k3 - 1) + j] - d14;
                                ad1[(k3 - 1) + k] = d11;
                            }
                        } while(true);
                        ad[(k3 - 1) + j] = d14;
                        k3++;
                    } while(k3 <= i4);
                else
label5:
                    do
                    {
                        double d15;
                        do
                        {
                            int i6;
label6:
                            {
                                if(k3 != i4)
                                {
                                    int k4 = i4 + 1;
                                    i6 = k3;
                                    for(int k8 = ((k4 - k3) + -1) / -1; k8 > 0; k8--)
                                    {
                                        double d25 = Math.pow(Math.abs(ad1[(i6 - 1 - 1) + k]), 2);
                                        if(d25 <= d6 * Math.abs(ad[(i6 - 1) + j]) * Math.abs(ad[(i6 - 1 - 1) + j]) + d18)
                                            break label6;
                                        i6--;
                                    }

                                }
                                i6 = i4;
                            }
                            if(i6 > i4)
                                ad1[(i6 - 1 - 1) + k] = 0.0D;
                            d15 = ad[(k3 - 1) + j];
                            if(i6 == k3)
                                break;
                            if(i6 == k3 - 1)
                            {
                                if(byte0 > 0)
                                {
                                    Dlaev2.dlaev2(ad[(k3 - 1 - 1) + j], ad1[(k3 - 1 - 1) + k], ad[(k3 - 1) + j], doublew2, doublew3, doublew, doublew4);
                                    double d26 = ad2[(k3 - 1) + l];
                                    ad2[(k3 - 1) + l] = doublew.val * d26 - doublew4.val * ad2[(k3 - 1 - 1) + l];
                                    ad2[(k3 - 1 - 1) + l] = doublew4.val * d26 + doublew.val * ad2[(k3 - 1 - 1) + l];
                                } else
                                {
                                    Dlae2.dlae2(ad[(k3 - 1 - 1) + j], ad1[(k3 - 1 - 1) + k], ad[(k3 - 1) + j], doublew2, doublew3);
                                }
                                ad[(k3 - 1 - 1) + j] = doublew2.val;
                                ad[(k3 - 1) + j] = doublew3.val;
                                ad1[(k3 - 1 - 1) + k] = 0.0D;
                                k3 -= 2;
                                if(k3 < i4)
                                    break label5;
                            } else
                            {
                                if(i3 == j7)
                                    break label5;
                                i3++;
                                double d12 = (ad[(k3 - 1 - 1) + j] - d15) / (2D * ad1[(k3 - 1 - 1) + k]);
                                doublew1.val = Dlapy2.dlapy2(d12, 1.0D);
                                d12 = (ad[(i6 - 1) + j] - d15) + ad1[(k3 - 1 - 1) + k] / (d12 + Util.dsign(doublew1.val, d12));
                                doublew4.val = 1.0D;
                                doublew.val = 1.0D;
                                d15 = 0.0D;
                                int i5 = k3 - 1;
                                int k1 = i6;
                                for(int l8 = (i5 - i6) + 1; l8 > 0; l8--)
                                {
                                    double d9 = doublew4.val * ad1[(k1 - 1) + k];
                                    double d4 = doublew.val * ad1[(k1 - 1) + k];
                                    Dlartg.dlartg(d12, d9, doublew, doublew4, doublew1);
                                    if(k1 != i6)
                                        ad1[(k1 - 1 - 1) + k] = doublew1.val;
                                    d12 = ad[(k1 - 1) + j] - d15;
                                    doublew1.val = (ad[((k1 + 1) - 1) + j] - d12) * doublew4.val + 2D * doublew.val * d4;
                                    d15 = doublew4.val * doublew1.val;
                                    ad[(k1 - 1) + j] = d12 + d15;
                                    d12 = doublew.val * doublew1.val - d4;
                                    if(byte0 > 0)
                                    {
                                        ad3[(k1 - 1) + i1] = doublew.val;
                                        ad3[(((i - 1) + k1) - 1) + i1] = doublew4.val;
                                    }
                                    k1++;
                                }

                                if(byte0 > 0)
                                {
                                    int k6 = (k3 - i6) + 1;
                                    Dlasr.dlasr("r", "v", "f", 1, k6, ad3, (i6 - 1) + i1, ad3, (((i - 1) + i6) - 1) + i1, ad2, (i6 - 1) + l, 1);
                                }
                                ad[(k3 - 1) + j] = ad[(k3 - 1) + j] - d15;
                                ad1[(i5 - 1) + k] = d12;
                            }
                        } while(true);
                        ad[(k3 - 1) + j] = d15;
                        k3--;
                    } while(k3 >= i4);
                if(byte1 == 1)
                {
                    Dlascl.dlascl("g", 0, 0, d19, d1, (l4 - j5) + 1, 1, ad, (j5 - 1) + j, i, intw);
                    Dlascl.dlascl("g", 0, 0, d19, d1, l4 - j5, 1, ad1, (j5 - 1) + k, i, intw);
                } else
                if(byte1 == 2)
                {
                    Dlascl.dlascl("g", 0, 0, d20, d1, (l4 - j5) + 1, 1, ad, (j5 - 1) + j, i, intw);
                    Dlascl.dlascl("g", 0, 0, d20, d1, l4 - j5, 1, ad1, (j5 - 1) + k, i, intw);
                }
                if(i3 >= j7)
                {
                    int l1 = 1;
                    for(int i9 = (i - 1 - 1) + 1; i9 > 0; i9--)
                    {
                        if(ad1[(l1 - 1) + k] != 0.0D)
                            intw.val = intw.val + 1;
                        l1++;
                    }

                    break label0;
                }
            } while(true);
            if(byte0 == 0)
            {
                Dlasrt.dlasrt("i", i, ad, j, intw);
            } else
            {
                int j2 = 2;
                for(int j9 = (i - 2) + 1; j9 > 0; j9--)
                {
                    int i2 = j2 - 1;
                    int j3 = i2;
                    double d16 = ad[(i2 - 1) + j];
                    int l2 = j2;
                    for(int k9 = (i - j2) + 1; k9 > 0; k9--)
                    {
                        if(ad[(l2 - 1) + j] < d16)
                        {
                            j3 = l2;
                            d16 = ad[(l2 - 1) + j];
                        }
                        l2++;
                    }

                    if(j3 != i2)
                    {
                        ad[(j3 - 1) + j] = ad[(i2 - 1) + j];
                        ad[(i2 - 1) + j] = d16;
                        d16 = ad2[(j3 - 1) + l];
                        ad2[(j3 - 1) + l] = ad2[(i2 - 1) + l];
                        ad2[(i2 - 1) + l] = d16;
                    }
                    j2++;
                }

            }
        }
    }
}

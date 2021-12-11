package org.netlib.lapack;

import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlazq4
{
    public static void dlazq4(int i, int j, double ad[], int k, int l, int i1, double d, 
            double d1, double d2, double d3, double d4, double d5, doubleW doublew, intW intw, doubleW doublew1)
    {
        int j2 = 0;
        double d36 = 0.0;
        if(d <= 0.0)
        {
            doublew.val = -d;
            intw.val = -1;
            return;
        }
        j2 = 4 * j + l;
        if(i1 == j)
        {
            if((d == d3) || (d == d4))
            {
                double d14 = Math.sqrt(ad[(j2 - 4) + k]) * Math.sqrt(ad[(j2 - 6) + k]);
                double d21 = Math.sqrt(ad[(j2 - 8) + k]) * Math.sqrt(ad[(j2 - 10) + k]);
                double d7 = ad[(j2 - 8) + k] + ad[(j2 - 6) + k];
                if((d == d3) && (d1 == d4))
                {
                    double d33 = d2 - d7 - d2 * 0.25;
                    double d31;
                    if((d33 > 0.0) && (d33 > d21))
                        d31 = d7 - d3 - (d21 / d33) * d21;
                    else
                        d31 = d7 - d3 - (d14 + d21);
                    if((d31 > 0.0) && (d31 > d14))
                    {
                        d36 = Math.max(d3 - (d14 / d31) * d14, 0.5 * d);
                        intw.val = -2;
                    } else
                    {
                        d36 = 0.0;
                        if(d3 > d14)
                            d36 = d3 - d14;
                        if(d7 > d14 + d21)
                            d36 = Math.min(d36, d7 - (d14 + d21));
                        d36 = Math.max(d36, 0.33300000000000002 * d);
                        intw.val = -3;
                    }
                } else
                {
                    intw.val = -4;
                    d36 = 0.25 * d;
                    int k2;
                    double d8;
                    double d22;
                    double d28;
                    if(d == d3)
                    {
                        d28 = d3;
                        d8 = 0.0;
                        if(ad[(j2 - 6) + k] > ad[(j2 - 8) + k])
                            return;
                        d22 = ad[(j2 - 6) + k] / ad[(j2 - 8) + k];
                        k2 = j2 - 9;
                    } else
                    {
                        k2 = j2 - 2 * l;
                        d22 = ad[(k2 - 3) + k];
                        d28 = d4;
                        if(ad[(k2 - 4 - 1) + k] > ad[(k2 - 2 - 1) + k])
                            return;
                        d8 = ad[(k2 - 4 - 1) + k] / ad[(k2 - 2 - 1) + k];
                        if(ad[(j2 - 9 - 1) + k] > ad[(j2 - 11 - 1) + k])
                            return;
                        d22 = ad[(j2 - 9 - 1) + k] / ad[(j2 - 11 - 1) + k];
                        k2 = j2 - 13;
                    }
                    d8 += d22;
                    int j1 = k2;
                    for(int i3 = ((((4 * i - 1) + l) - k2) + -4) / -4; i3 > 0; i3--)
                    {
                        if(d22 == 0.0)
                            break;
                        double d15 = d22;
                        if(ad[(j1 - 1) + k] > ad[(j1 - 2 - 1) + k])
                            return;
                        d22 *= ad[(j1 - 1) + k] / ad[(j1 - 2 - 1) + k];
                        d8 += d22;
                        if((100.0 * Math.max(d22, d15) < d8) || (0.56299999999999994 < d8))
                            break;
                        j1 += -4;
                    }

                    d8 = 1.05 * d8;
                    if(d8 < 0.56299999999999994)
                        d36 = (d28 * (1.0 - Math.sqrt(d8))) / (1.0 + d8);
                }
            } else
            if(d == d5)
            {
                intw.val = -5;
                d36 = 0.25 * d;
                int l2 = j2 - 2 * l;
                double d16 = ad[(l2 - 2 - 1) + k];
                double d23 = ad[(l2 - 6 - 1) + k];
                double d29 = d5;
                if((ad[(l2 - 8 - 1) + k] > d23) || (ad[(l2 - 4 - 1) + k] > d16))
                    return;
                double d9 = (ad[(l2 - 8 - 1) + k] / d23) * (1.0 + ad[(l2 - 4 - 1) + k] / d16);
                if(j - i > 2)
                {
                    double d24 = ad[(j2 - 13 - 1) + k] / ad[(j2 - 15 - 1) + k];
                    d9 += d24;
                    int k1 = j2 - 17;
                    for(int j3 = ((((4 * i - 1) + l) - (j2 - 17)) + -4) / -4; j3 > 0; j3--)
                    {
                        if(d24 == 0.0)
                            break;
                        double d17 = d24;
                        if(ad[(k1 - 1) + k] > ad[(k1 - 3) + k])
                            return;
                        d24 *= ad[(k1 - 1) + k] / ad[(k1 - 3) + k];
                        d9 += d24;
                        if((100.0 * Math.max(d24, d17) < d9) || (0.56299999999999994 < d9))
                            break;
                        k1 += -4;
                    }

                    d9 = 1.05 * d9;
                }
                if(d9 < 0.56299999999999994)
                    d36 = (d29 * (1.0 - Math.sqrt(d9))) / (1.0 + d9);
            } else
            {
                if(intw.val == -6)
                    doublew1.val = doublew1.val + 0.33300000000000002 * (1.0 - doublew1.val);
                else
                if(intw.val == -18)
                    doublew1.val = 0.25 * 0.33300000000000002;
                else
                    doublew1.val = 0.25;
                d36 = doublew1.val * d;
                intw.val = -6;
            }
        } else
        if(i1 == j + 1)
        {
            if((d1 == d4) && (d2 == d5))
            {
                intw.val = -7;
                d36 = 0.33300000000000002 * d1;
                if(ad[(j2 - 6) + k] > ad[(j2 - 8) + k])
                    return;
                double d18 = ad[(j2 - 6) + k] / ad[(j2 - 8) + k];
                double d25 = d18;
                if(d25 != 0.0)
                {
                    int l1 = (4 * j - 9) + l;
                    for(int k3 = ((((4 * i - 1) + l) - ((4 * j - 9) + l)) + -4) / -4; k3 > 0; k3--)
                    {
                        double d10 = d18;
                        if(ad[(l1 - 1) + k] > ad[(l1 - 3) + k])
                            return;
                        d18 *= ad[(l1 - 1) + k] / ad[(l1 - 3) + k];
                        d25 += d18;
                        if(100.0 * Math.max(d18, d10) < d25)
                            break;
                        l1 += -4;
                    }

                }
                d25 = Math.sqrt(1.05 * d25);
                double d11 = d1 / (1.0 + Math.pow(d25, 2.0));
                double d34 = 0.5 * d2 - d11;
                if((d34 > 0.0) && (d34 > d25 * d11))
                {
                    d36 = Math.max(d36, d11 * (1.0 - 1.01 * d11 * (d25 / d34) * d25));
                } else
                {
                    d36 = Math.max(d36, d11 * (1.0 - 1.01 * d25));
                    intw.val = -8;
                }
            } else
            {
                d36 = 0.25 * d1;
                if(d1 == d4)
                    d36 = 0.5 * d1;
                intw.val = -9;
            }
        } else
        if(i1 == j + 2)
        {
            if((d2 == d5) && (2.0 * ad[(j2 - 6) + k] < ad[(j2 - 8) + k]))
            {
                intw.val = -10;
                d36 = 0.33300000000000002 * d2;
                if(ad[(j2 - 6) + k] > ad[(j2 - 8) + k])
                    return;
                double d19 = ad[(j2 - 6) + k] / ad[(j2 - 8) + k];
                double d26 = d19;
                if(d26 != 0.0)
                {
                    int i2 = (4 * j - 9) + l;
                    for(int l3 = ((((4 * i - 1) + l) - ((4 * j - 9) + l)) + -4) / -4; l3 > 0; l3--)
                    {
                        if(ad[(i2 - 1) + k] > ad[(i2 - 3) + k])
                            return;
                        d19 *= ad[(i2 - 1) + k] / ad[(i2 - 3) + k];
                        d26 += d19;
                        if(100.0 * d19 < d26)
                            break;
                        i2 += -4;
                    }

                }
                d26 = Math.sqrt(1.05 * d26);
                double d12 = d2 / (1.0 + Math.pow(d26, 2.0));
                double d35 = (ad[(j2 - 8) + k] + ad[(j2 - 10) + k]) - Math.sqrt(ad[(j2 - 12) + k]) * Math.sqrt(ad[(j2 - 10) + k]) - d12;
                if((d35 > 0.0) && (d35 > d26 * d12))
                    d36 = Math.max(d36, d12 * (1.0 - 1.01 * d12 * (d26 / d35) * d26));
                else
                    d36 = Math.max(d36, d12 * (1.0 - 1.01 * d26));
            } else
            {
                d36 = 0.25 * d2;
                intw.val = -11;
            }
        } else
        if(i1 > j + 2)
        {
            d36 = 0.0;
            intw.val = -12;
        }
        doublew.val = d36;
    }
}

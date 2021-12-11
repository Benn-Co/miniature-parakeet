package org.netlib.lapack;

import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlasd4
{
    public static void dlasd4(int i, int j, double ad[], int k, double ad1[], int l, double ad2[], int i1, 
            double d, doubleW doublew, double ad3[], int j1, intW intw)
    {
label0:
        {
            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;
            int k1 = 0;
            int l1 = 0;
            int i2 = 0;
            int j2 = 0;
            int k2 = 0;
            int l2 = 0;
            int j3 = 0;
            double d19 = 0.0;
            double d24 = 0.0;
            double d25 = 0.0;
            double d26 = 0.0;
            double d27 = 0.0;
            double d46 = 0.0;
            double d47 = 0.0;
            double d48 = 0.0;
            doubleW doublew1 = new doubleW(0.0D);
            double d49 = 0.0;
            double d50 = 0.0;
            double d52 = 0.0;
            double d53 = 0.0;
            double d54 = 0.0;
            double d55 = 0.0;
            double d56 = 0.0;
            double d57 = 0.0;
            double d75 = 0.0;
            double ad4[] = new double[3];
            double ad5[] = new double[3];
            intw.val = 0;
            if (i == 1)
            {
                doublew.val = Math.sqrt(ad[k] * ad[k] + d * ad1[l] * ad1[l]);
                ad2[i1] = 1.0;
                ad3[j1] = 1.0;
                return;
            }
            if (i == 2)
            {
                Dlasd5.dlasd5(j, ad, k, ad1, l, ad2, i1, d, doublew, ad3, j1);
                return;
            }
            d47 = Dlamch.dlamch("Epsilon"); // XXX
            d53 = 1.0 / d;
            if(j == i)
            {
                k1 = i - 1;
                j3 = 1;
                d57 = d / 2.0;
                double d62 = d57 / (ad[(i - 1) + k] + Math.sqrt(ad[(i - 1) + k] * ad[(i - 1) + k] + d57));
                l2 = 1;
                for(int k3 = i; k3 > 0; k3--)
                {
                    ad3[(l2 - 1) + j1] = ad[(l2 - 1) + k] + ad[(i - 1) + k] + d62;
                    ad2[(l2 - 1) + i1] = ad[(l2 - 1) + k] - ad[(i - 1) + k] - d62;
                    l2++;
                }

                d52 = 0.0;
                l2 = 1;
                for(int l3 = (i - 3) + 1; l3 > 0; l3--)
                {
                    d52 += (ad1[(l2 - 1) + l] * ad1[(l2 - 1) + l]) / (ad2[(l2 - 1) + i1] * ad3[(l2 - 1) + j1]);
                    l2++;
                }

                d19 = d53 + d52;
                d75 = d19 + (ad1[(k1 - 1) + l] * ad1[(k1 - 1) + l]) / (ad2[(k1 - 1) + i1] * ad3[(k1 - 1) + j1]) + (ad1[(i - 1) + l] * ad1[(i - 1) + l]) / (ad2[(i - 1) + i1] * ad3[(i - 1) + j1]);
                if (d75 <= 0.0)
                {
                    double d63 = Math.sqrt(ad[(i - 1) + k] * ad[(i - 1) + k] + d);
                    d57 = (ad1[(i - 2) + l] * ad1[(i - 2) + l]) / ((ad[(i - 2) + k] + d63) * ((ad[(i - 1) + k] - ad[(i - 2) + k]) + d / (ad[(i - 1) + k] + d63))) + (ad1[(i - 1) + l] * ad1[(i - 1) + l]) / d;
                    if(d19 <= d57)
                    {
                        d56 = d;
                    } else
                    {
                        d24 = (ad[(i - 1) + k] - ad[(i - 2) + k]) * (ad[(i - 1) + k] + ad[(i - 2) + k]);
                        double d2 = -(d19 * d24) + ad1[(i - 2) + l] * ad1[(i - 2) + l] + ad1[(i - 1) + l] * ad1[(i - 1) + l];
                        double d11 = ad1[(i - 1) + l] * ad1[(i - 1) + l] * d24;
                        if(d2 < 0.0)
                            d56 = (2.0 * d11) / (Math.sqrt(d2 * d2 + 4.0 * d11 * d19) - d2);
                        else
                            d56 = (d2 + Math.sqrt(d2 * d2 + 4.0 * d11 * d19)) / (2.0 * d19);
                    }
                } else
                {
                    d24 = (ad[(i - 1) + k] - ad[(i - 2) + k]) * (ad[(i - 1) + k] + ad[(i - 2) + k]);
                    double d3 = -(d19 * d24) + ad1[(i - 2) + l] * ad1[(i - 2) + l] + ad1[(i - 1) + l] * ad1[(i - 1) + l];
                    double d12 = ad1[(i - 1) + l] * ad1[(i - 1) + l] * d24;
                    if(d3 < 0.0)
                        d56 = (2.0 * d12) / (Math.sqrt(d3 * d3 + 4.0 * d12 * d19) - d3);
                    else
                        d56 = (d3 + Math.sqrt(d3 * d3 + 4.0 * d12 * d19)) / (2.0 * d19);
                }
                doublew1.val = d56 / (ad[(i - 1) + k] + Math.sqrt(ad[(i - 1) + k] * ad[(i - 1) + k] + d56));
                doublew.val = ad[(i - 1) + k] + doublew1.val;
                l2 = 1;
                for (int i4 = (i - 1) + 1; i4 > 0; i4--)
                {
                    ad2[(l2 - 1) + i1] = ad[(l2 - 1) + k] - ad[(j - 1) + k] - doublew1.val;
                    ad3[(l2 - 1) + j1] = ad[(l2 - 1) + k] + ad[(j - 1) + k] + doublew1.val;
                    l2++;
                }

                d27 = 0.0;
                d52 = 0.0;
                d48 = 0.0;
                l2 = 1;
                for (int j4 = k1; j4 > 0; j4--)
                {
                    d57 = ad1[(l2 - 1) + l] / (ad2[(l2 - 1) + i1] * ad3[(l2 - 1) + j1]);
                    d52 += ad1[(l2 - 1) + l] * d57;
                    d27 += d57 * d57;
                    d48 += d52;
                    l2++;
                }

                d48 = Math.abs(d48);
                d57 = ad1[(i - 1) + l] / (ad2[(i - 1) + i1] * ad3[(i - 1) + j1]);
                d49 = ad1[(i - 1) + l] * d57;
                d26 = d57 * d57;
                d48 = ((8.0 * (-d49 - d52) + d48) - d49) + d53 + Math.abs(d56) * (d27 + d26);
                d75 = d53 + d49 + d52;
                if (Math.abs(d75) <= d47 * d48)
                    break label0;
                j3++;
                double d44 = ad3[(i - 2) + j1] * ad2[(i - 2) + i1];
                double d41 = ad3[(i - 1) + j1] * ad2[(i - 1) + i1];
                d19 = d75 - d44 * d27 - d41 * d26;
                double d4 = (d41 + d44) * d75 - d41 * d44 * (d27 + d26);
                double d13 = d41 * d44 * d75;
                if(d19 < 0.0)
                    d19 = Math.abs(d19);
                if(d19 == 0.0)
                    doublew1.val = d - doublew.val * doublew.val;
                else
                if (d4 >= 0.0)
                    doublew1.val = (d4 + Math.sqrt(Math.abs(d4 * d4 - 4.0 * d13 * d19))) / (2.0 * d19);
                else
                    doublew1.val = (2.0 * d13) / (d4 - Math.sqrt(Math.abs(d4 * d4 - 4.0 * d13 * d19)));
                if (d75 * doublew1.val > 0.0)
                    doublew1.val = -(d75 / (d27 + d26));
                d57 = doublew1.val - d41;
                if(d57 > d)
                    doublew1.val = d + d41;
                d56 += doublew1.val;
                doublew1.val = doublew1.val / (doublew.val + Math.sqrt(doublew1.val + doublew.val * doublew.val));
                l2 = 1;
                for (int k4 = i; k4 > 0; k4--)
                {
                    ad2[(l2 - 1) + i1] = ad2[(l2 - 1) + i1] - doublew1.val;
                    ad3[(l2 - 1) + j1] = ad3[(l2 - 1) + j1] + doublew1.val;
                    l2++;
                }

                doublew.val = doublew.val + doublew1.val;
                d27 = 0.0;
                d52 = 0.0;
                d48 = 0.0;
                l2 = 1;
                for(int l4 = k1; l4 > 0; l4--)
                {
                    d57 = ad1[(l2 - 1) + l] / (ad3[(l2 - 1) + j1] * ad2[(l2 - 1) + i1]);
                    d52 += ad1[(l2 - 1) + l] * d57;
                    d27 += d57 * d57;
                    d48 += d52;
                    l2++;
                }

                d48 = Math.abs(d48);
                d57 = ad1[(i - 1) + l] / (ad3[(i - 1) + j1] * ad2[(i - 1) + i1]);
                d49 = ad1[(i - 1) + l] * d57;
                d26 = d57 * d57;
                d48 = ((8.0 * (-d49 - d52) + d48) - d49) + d53 + Math.abs(d56) * (d27 + d26);
                d75 = d53 + d49 + d52;
                k2 = j3 + 1;
                j3 = k2;
                for(int i5 = 21 - k2; i5 > 0; i5--)
                {
                    if(Math.abs(d75) <= d47 * d48)
                        break label0;
                    double d45 = ad3[(i - 2) + j1] * ad2[(i - 2) + i1];
                    double d42 = ad3[(i - 1) + j1] * ad2[(i - 1) + i1];
                    d19 = d75 - d45 * d27 - d42 * d26;
                    double d5 = (d42 + d45) * d75 - d45 * d42 * (d27 + d26);
                    double d14 = d45 * d42 * d75;
                    if(d5 >= 0.0D)
                        doublew1.val = (d5 + Math.sqrt(Math.abs(d5 * d5 - 4.0 * d14 * d19))) / (2.0 * d19);
                    else
                        doublew1.val = (2.0 * d14) / (d5 - Math.sqrt(Math.abs(d5 * d5 - 4.0 * d14 * d19)));
                    if(d75 * doublew1.val > 0.0)
                        doublew1.val = -(d75 / (d27 + d26));
                    d57 = doublew1.val - d42;
                    if(d57 <= 0.0)
                        doublew1.val = doublew1.val / 2.0;
                    d56 += doublew1.val;
                    doublew1.val = doublew1.val / (doublew.val + Math.sqrt(doublew1.val + doublew.val * doublew.val));
                    l2 = 1;
                    for(int i8 = i; i8 > 0; i8--)
                    {
                        ad2[(l2 - 1) + i1] = ad2[(l2 - 1) + i1] - doublew1.val;
                        ad3[(l2 - 1) + j1] = ad3[(l2 - 1) + j1] + doublew1.val;
                        l2++;
                    }

                    doublew.val = doublew.val + doublew1.val;
                    d27 = 0.0;
                    d52 = 0.0;
                    d48 = 0.0;
                    l2 = 1;
                    for (int j8 = k1; j8 > 0; j8--)
                    {
                        d57 = ad1[(l2 - 1) + l] / (ad3[(l2 - 1) + j1] * ad2[(l2 - 1) + i1]);
                        d52 += ad1[(l2 - 1) + l] * d57;
                        d27 += d57 * d57;
                        d48 += d52;
                        l2++;
                    }

                    d48 = Math.abs(d48);
                    d57 = ad1[(i - 1) + l] / (ad3[(i - 1) + j1] * ad2[(i - 1) + i1]);
                    d49 = ad1[(i - 1) + l] * d57;
                    d26 = d57 * d57;
                    d48 = ((8.0 * (-d49 - d52) + d48) - d49) + d53 + Math.abs(d56) * (d27 + d26);
                    d75 = d53 + d49 + d52;
                    j3++;
                }

                intw.val = 1;
                break label0;
            }
            j3 = 1;
            j2 = j + 1;
            d24 = (ad[(j2 - 1) + k] - ad[(j - 1) + k]) * (ad[(j2 - 1) + k] + ad[(j - 1) + k]);
            d25 = d24 / 2.0;
            d57 = d25 / (ad[(j - 1) + k] + Math.sqrt(ad[(j - 1) + k] * ad[(j - 1) + k] + d25));
            l2 = 1;
            for(int j5 = i; j5 > 0; j5--)
            {
                ad3[(l2 - 1) + j1] = ad[(l2 - 1) + k] + ad[(j - 1) + k] + d57;
                ad2[(l2 - 1) + i1] = ad[(l2 - 1) + k] - ad[(j - 1) + k] - d57;
                l2++;
            }

            d52 = 0.0;
            l2 = 1;
            for(int k5 = j - 1; k5 > 0; k5--)
            {
                d52 += (ad1[(l2 - 1) + l] * ad1[(l2 - 1) + l]) / (ad3[(l2 - 1) + j1] * ad2[(l2 - 1) + i1]);
                l2++;
            }

            d49 = 0.0;
            l2 = i;
            for(int l5 = (((j + 2) - i) + -1) / -1; l5 > 0; l5--)
            {
                d49 += (ad1[(l2 - 1) + l] * ad1[(l2 - 1) + l]) / (ad3[(l2 - 1) + j1] * ad2[(l2 - 1) + i1]);
                l2--;
            }

            d19 = d53 + d52 + d49;
            d75 = d19 + (ad1[(j - 1) + l] * ad1[(j - 1) + l]) / (ad3[(j - 1) + j1] * ad2[(j - 1) + i1]) + (ad1[(j2 - 1) + l] * ad1[(j2 - 1) + l]) / (ad3[(j2 - 1) + j1] * ad2[(j2 - 1) + i1]);
            if(d75 > 0.0)
            {
                flag = true;
                d54 = 0.0;
                d55 = d25;
                double d6 = d19 * d24 + ad1[(j - 1) + l] * ad1[(j - 1) + l] + ad1[(j2 - 1) + l] * ad1[(j2 - 1) + l];
                double d15 = ad1[(j - 1) + l] * ad1[(j - 1) + l] * d24;
                if(d6 > 0.0)
                    d56 = (2.0 * d15) / (d6 + Math.sqrt(Math.abs(d6 * d6 - 4.0 * d15 * d19)));
                else
                    d56 = (d6 - Math.sqrt(Math.abs(d6 * d6 - 4.0 * d15 * d19))) / (2.0 * d19);
                doublew1.val = d56 / (ad[(j - 1) + k] + Math.sqrt(ad[(j - 1) + k] * ad[(j - 1) + k] + d56));
            } else
            {
                flag = false;
                d54 = -d25;
                d55 = 0.0;
                double d7 = d19 * d24 - ad1[(j - 1) + l] * ad1[(j - 1) + l] - ad1[(j2 - 1) + l] * ad1[(j2 - 1) + l];
                double d16 = ad1[(j2 - 1) + l] * ad1[(j2 - 1) + l] * d24;
                if(d7 < 0.0)
                    d56 = (2.0 * d16) / (d7 - Math.sqrt(Math.abs(d7 * d7 + 4.0 * d16 * d19)));
                else
                    d56 = -((d7 + Math.sqrt(Math.abs(d7 * d7 + 4.0 * d16 * d19))) / (2.0 * d19));
                doublew1.val = d56 / (ad[(j2 - 1) + k] + Math.sqrt(Math.abs(ad[(j2 - 1) + k] * ad[(j2 - 1) + k] + d56)));
            }
            if(flag)
            {
                k1 = j;
                doublew.val = ad[(j - 1) + k] + doublew1.val;
                l2 = 1;
                for(int i6 = i; i6 > 0; i6--)
                {
                    ad3[(l2 - 1) + j1] = ad[(l2 - 1) + k] + ad[(j - 1) + k] + doublew1.val;
                    ad2[(l2 - 1) + i1] = ad[(l2 - 1) + k] - ad[(j - 1) + k] - doublew1.val;
                    l2++;
                }

            } else
            {
                k1 = j + 1;
                doublew.val = ad[(j2 - 1) + k] + doublew1.val;
                l2 = 1;
                for(int j6 = i; j6 > 0; j6--)
                {
                    ad3[(l2 - 1) + j1] = ad[(l2 - 1) + k] + ad[(j2 - 1) + k] + doublew1.val;
                    ad2[(l2 - 1) + i1] = ad[(l2 - 1) + k] - ad[(j2 - 1) + k] - doublew1.val;
                    l2++;
                }

            }
            l1 = k1 - 1;
            i2 = k1 + 1;
            d27 = 0.0;
            d52 = 0.0;
            d48 = 0.0;
            l2 = 1;
            for(int k6 = l1; k6 > 0; k6--)
            {
                d57 = ad1[(l2 - 1) + l] / (ad3[(l2 - 1) + j1] * ad2[(l2 - 1) + i1]);
                d52 += ad1[(l2 - 1) + l] * d57;
                d27 += d57 * d57;
                d48 += d52;
                l2++;
            }

            d48 = Math.abs(d48);
            d26 = 0.0;
            d49 = 0.0;
            l2 = i;
            for(int l6 = ((i2 - i) + -1) / -1; l6 > 0; l6--)
            {
                d57 = ad1[(l2 - 1) + l] / (ad3[(l2 - 1) + j1] * ad2[(l2 - 1) + i1]);
                d49 += ad1[(l2 - 1) + l] * d57;
                d26 += d57 * d57;
                d48 += d49;
                l2--;
            }

            d75 = d53 + d49 + d52;
            flag2 = false;
            if(flag)
            {
                if(d75 < 0.0)
                    flag2 = true;
            } else
            if(d75 > 0.0)
                flag2 = true;
            if((k1 == 1) || (k1 == i))
                flag2 = false;
            d57 = ad1[(k1 - 1) + l] / (ad3[(k1 - 1) + j1] * ad2[(k1 - 1) + i1]);
            d46 = d27 + d26 + d57 * d57;
            d57 = ad1[(k1 - 1) + l] * d57;
            d75 += d57;
            d48 = 8.0 * (d49 - d52) + d48 + 2.0 * d53 + 3.0 * Math.abs(d57) + Math.abs(d56) * d46;
            if(Math.abs(d75) <= d47 * d48)
                break label0;
            if(d75 <= 0.0)
                d54 = Math.max(d54, d56);
            else
                d55 = Math.min(d55, d56);
            j3++;
            if(!flag2)
            {
                double d35 = ad3[(j2 - 1) + j1] * ad2[(j2 - 1) + i1];
                double d38 = ad3[(j - 1) + j1] * ad2[(j - 1) + i1];
                double d20;
                if(flag)
                    d20 = (d75 - d35 * d46) + d24 * Math.pow(ad1[(j - 1) + l] / d38, 2.0);
                else
                    d20 = d75 - d38 * d46 - d24 * Math.pow(ad1[(j2 - 1) + l] / d35, 2.0);
                double d8 = (d35 + d38) * d75 - d35 * d38 * d46;
                double d17 = d35 * d38 * d75;
                if(d20 == 0.0)
                {
                    if(d8 == 0.0)
                        if(flag)
                            d8 = ad1[(j - 1) + l] * ad1[(j - 1) + l] + d35 * d35 * (d27 + d26);
                        else
                            d8 = ad1[(j2 - 1) + l] * ad1[(j2 - 1) + l] + d38 * d38 * (d27 + d26);
                    doublew1.val = d17 / d8;
                } else
                if(d8 <= 0.0)
                    doublew1.val = (d8 - Math.sqrt(Math.abs(d8 * d8 - 4.0 * d17 * d20))) / (2.0 * d20);
                else
                    doublew1.val = (2.0 * d17) / (d8 + Math.sqrt(Math.abs(d8 * d8 - 4.0 * d17 * d20)));
            } else
            {
                double d29 = ad3[(l1 - 1) + j1] * ad2[(l1 - 1) + i1];
                double d32 = ad3[(i2 - 1) + j1] * ad2[(i2 - 1) + i1];
                d57 = d53 + d52 + d49;
                double d21;
                if(flag)
                {
                    double d64 = ad1[(l1 - 1) + l] / d29;
                    d64 *= d64;
                    d21 = d57 - d32 * (d27 + d26) - (ad[(l1 - 1) + k] - ad[(i2 - 1) + k]) * (ad[(l1 - 1) + k] + ad[(i2 - 1) + k]) * d64;
                    ad5[0] = ad1[(l1 - 1) + l] * ad1[(l1 - 1) + l];
                    if(d27 < d64)
                        ad5[2] = d32 * d32 * d26;
                    else
                        ad5[2] = d32 * d32 * ((d27 - d64) + d26);
                } else
                {
                    double d65 = ad1[(i2 - 1) + l] / d32;
                    d65 *= d65;
                    d21 = d57 - d29 * (d27 + d26) - (ad[(i2 - 1) + k] - ad[(l1 - 1) + k]) * (ad[(l1 - 1) + k] + ad[(i2 - 1) + k]) * d65;
                    if(d26 < d65)
                        ad5[0] = d29 * d29 * d27;
                    else
                        ad5[0] = d29 * d29 * (d27 + (d26 - d65));
                    ad5[2] = ad1[(i2 - 1) + l] * ad1[(i2 - 1) + l];
                }
                ad5[1] = ad1[(k1 - 1) + l] * ad1[(k1 - 1) + l];
                ad4[0] = d29;
                ad4[1] = ad2[(k1 - 1) + i1] * ad3[(k1 - 1) + j1];
                ad4[2] = d32;
                Dlaed6.dlaed6(j3, flag, d21, ad4, 0, ad5, 0, d75, doublew1, intw);
                if(intw.val != 0)
                    break label0;
            }
            if(d75 * doublew1.val >= 0.0)
                doublew1.val = -(d75 / d46);
            if(flag)
            {
                double d66 = ad3[(j - 1) + j1] * ad2[(j - 1) + i1];
                d57 = doublew1.val - d66;
            } else
            {
                double d67 = ad3[(j2 - 1) + j1] * ad2[(j2 - 1) + i1];
                d57 = doublew1.val - d67;
            }
            if((d57 > d55) || (d57 < d54))
                if(d75 < 0.0)
                    doublew1.val = (d55 - d56) / 2.0;
                else
                    doublew1.val = (d54 - d56) / 2.0;
            d56 += doublew1.val;
            doublew1.val = doublew1.val / (doublew.val + Math.sqrt(doublew.val * doublew.val + doublew1.val));
            d50 = d75;
            doublew.val = doublew.val + doublew1.val;
            l2 = 1;
            for(int i7 = i; i7 > 0; i7--)
            {
                ad3[(l2 - 1) + j1] = ad3[(l2 - 1) + j1] + doublew1.val;
                ad2[(l2 - 1) + i1] = ad2[(l2 - 1) + i1] - doublew1.val;
                l2++;
            }

            d27 = 0.0;
            d52 = 0.0;
            d48 = 0.0;
            l2 = 1;
            for(int j7 = l1; j7 > 0; j7--)
            {
                d57 = ad1[(l2 - 1) + l] / (ad3[(l2 - 1) + j1] * ad2[(l2 - 1) + i1]);
                d52 += ad1[(l2 - 1) + l] * d57;
                d27 += d57 * d57;
                d48 += d52;
                l2++;
            }

            d48 = Math.abs(d48);
            d26 = 0.0;
            d49 = 0.0;
            l2 = i;
            for(int k7 = ((i2 - i) + -1) / -1; k7 > 0; k7--)
            {
                d57 = ad1[(l2 - 1) + l] / (ad3[(l2 - 1) + j1] * ad2[(l2 - 1) + i1]);
                d49 += ad1[(l2 - 1) + l] * d57;
                d26 += d57 * d57;
                d48 += d49;
                l2--;
            }

            d57 = ad1[(k1 - 1) + l] / (ad3[(k1 - 1) + j1] * ad2[(k1 - 1) + i1]);
            d46 = d27 + d26 + d57 * d57;
            d57 = ad1[(k1 - 1) + l] * d57;
            d75 = d53 + d49 + d52 + d57;
            d48 = 8.0 * (d49 - d52) + d48 + 2.0 * d53 + 3.0 * Math.abs(d57) + Math.abs(d56) * d46;
            if(d75 <= 0.0)
                d54 = Math.max(d54, d56);
            else
                d55 = Math.min(d55, d56);
            flag1 = false;
            if(flag)
            {
                if(-d75 > Math.abs(d50) / 10.0)
                    flag1 = true;
            } else
            if(d75 > Math.abs(d50) / 10.0)
                flag1 = true;
            k2 = j3 + 1;
            j3 = k2;
            for (int l7 = 21 - k2; l7 > 0; l7--)
            {
                if(Math.abs(d75) <= d47 * d48)
                    break label0;
                if(!flag2)
                {
                    double d36 = ad3[(j2 - 1) + j1] * ad2[(j2 - 1) + i1];
                    double d39 = ad3[(j - 1) + j1] * ad2[(j - 1) + i1];
                    double d22;
                    if(!flag1)
                    {
                        if(flag)
                            d22 = (d75 - d36 * d46) + d24 * Math.pow(ad1[(j - 1) + l] / d39, 2.0);
                        else
                            d22 = d75 - d39 * d46 - d24 * Math.pow(ad1[(j2 - 1) + l] / d36, 2.0);
                    } else
                    {
                        double d58 = ad1[(k1 - 1) + l] / (ad3[(k1 - 1) + j1] * ad2[(k1 - 1) + i1]);
                        if(flag)
                            d27 += d58 * d58;
                        else
                            d26 += d58 * d58;
                        d22 = d75 - d39 * d27 - d36 * d26;
                    }
                    double d9 = (d36 + d39) * d75 - d36 * d39 * d46;
                    double d18 = d36 * d39 * d75;
                    if(d22 == 0.0)
                    {
                        if(d9 == 0.0)
                            if(!flag1)
                            {
                                if(flag)
                                    d9 = ad1[(j - 1) + l] * ad1[(j - 1) + l] + d36 * d36 * (d27 + d26);
                                else
                                    d9 = ad1[(j2 - 1) + l] * ad1[(j2 - 1) + l] + d39 * d39 * (d27 + d26);
                            } else
                            {
                                d9 = d39 * d39 * d27 + d36 * d36 * d26;
                            }
                        doublew1.val = d18 / d9;
                    } else
                    if(d9 <= 0.0)
                        doublew1.val = (d9 - Math.sqrt(Math.abs(d9 * d9 - 4.0 * d18 * d22))) / (2.0 * d22);
                    else
                        doublew1.val = (2.0 * d18) / (d9 + Math.sqrt(Math.abs(d9 * d9 - 4.0 * d18 * d22)));
                } else
                {
                    double d30 = ad3[(l1 - 1) + j1] * ad2[(l1 - 1) + i1];
                    double d33 = ad3[(i2 - 1) + j1] * ad2[(i2 - 1) + i1];
                    double d59 = d53 + d52 + d49;
                    double d23;
                    if(flag1)
                    {
                        d23 = d59 - d30 * d27 - d33 * d26;
                        ad5[0] = d30 * d30 * d27;
                        ad5[2] = d33 * d33 * d26;
                    } else
                    if(flag)
                    {
                        double d68 = ad1[(l1 - 1) + l] / d30;
                        d68 *= d68;
                        double d73 = (ad[(l1 - 1) + k] - ad[(i2 - 1) + k]) * (ad[(l1 - 1) + k] + ad[(i2 - 1) + k]) * d68;
                        d23 = d59 - d33 * (d27 + d26) - d73;
                        ad5[0] = ad1[(l1 - 1) + l] * ad1[(l1 - 1) + l];
                        if(d27 < d68)
                            ad5[2] = d33 * d33 * d26;
                        else
                            ad5[2] = d33 * d33 * ((d27 - d68) + d26);
                    } else
                    {
                        double d69 = ad1[(i2 - 1) + l] / d33;
                        d69 *= d69;
                        double d74 = (ad[(i2 - 1) + k] - ad[(l1 - 1) + k]) * (ad[(l1 - 1) + k] + ad[(i2 - 1) + k]) * d69;
                        d23 = d59 - d30 * (d27 + d26) - d74;
                        if(d26 < d69)
                            ad5[0] = d30 * d30 * d27;
                        else
                            ad5[0] = d30 * d30 * (d27 + (d26 - d69));
                        ad5[2] = ad1[(i2 - 1) + l] * ad1[(i2 - 1) + l];
                    }
                    ad4[0] = d30;
                    ad4[1] = ad2[(k1 - 1) + i1] * ad3[(k1 - 1) + j1];
                    ad4[2] = d33;
                    Dlaed6.dlaed6(j3, flag, d23, ad4, 0, ad5, 0, d75, doublew1, intw);
                    if(intw.val != 0)
                        break label0;
                }
                if (d75 * doublew1.val >= 0.0)
                    doublew1.val = -(d75 / d46);
                double d60;
                if(flag)
                {
                    double d70 = ad3[(j - 1) + j1] * ad2[(j - 1) + i1];
                    d60 = doublew1.val - d70;
                } else
                {
                    double d71 = ad3[(j2 - 1) + j1] * ad2[(j2 - 1) + i1];
                    d60 = doublew1.val - d71;
                }
                if((d60 > d55) || (d60 < d54))
                    if(d75 < 0.0)
                        doublew1.val = (d55 - d56) / 2.0;
                    else
                        doublew1.val = (d54 - d56) / 2.0;
                d56 += doublew1.val;
                doublew1.val = doublew1.val / (doublew.val + Math.sqrt(doublew.val * doublew.val + doublew1.val));
                doublew.val = doublew.val + doublew1.val;
                int i3 = 1;
                for(int k8 = i; k8 > 0; k8--)
                {
                    ad3[(i3 - 1) + j1] = ad3[(i3 - 1) + j1] + doublew1.val;
                    ad2[(i3 - 1) + i1] = ad2[(i3 - 1) + i1] - doublew1.val;
                    i3++;
                }

                double d51 = d75;
                d27 = 0.0;
                d52 = 0.0;
                d48 = 0.0;
                i3 = 1;
                for(int l8 = l1; l8 > 0; l8--)
                {
                    d60 = ad1[(i3 - 1) + l] / (ad3[(i3 - 1) + j1] * ad2[(i3 - 1) + i1]);
                    d52 += ad1[(i3 - 1) + l] * d60;
                    d27 += d60 * d60;
                    d48 += d52;
                    i3++;
                }

                d48 = Math.abs(d48);
                d26 = 0.0;
                d49 = 0.0;
                i3 = i;
                for(int i9 = ((i2 - i) + -1) / -1; i9 > 0; i9--)
                {
                    d60 = ad1[(i3 - 1) + l] / (ad3[(i3 - 1) + j1] * ad2[(i3 - 1) + i1]);
                    d49 += ad1[(i3 - 1) + l] * d60;
                    d26 += d60 * d60;
                    d48 += d49;
                    i3--;
                }

                d60 = ad1[(k1 - 1) + l] / (ad3[(k1 - 1) + j1] * ad2[(k1 - 1) + i1]);
                d46 = d27 + d26 + d60 * d60;
                d60 = ad1[(k1 - 1) + l] * d60;
                d75 = d53 + d49 + d52 + d60;
                d48 = 8.0 * (d49 - d52) + d48 + 2.0 * d53 + 3.0 * Math.abs(d60) + Math.abs(d56) * d46;
                if((d75 * d51 > 0.0) && (Math.abs(d75) > Math.abs(d51) / 10.0))
                    flag1 ^= true;
                if(d75 <= 0.0)
                    d54 = Math.max(d54, d56);
                else
                    d55 = Math.min(d55, d56);
                j3++;
            }

            intw.val = 1;
        }
    }
}

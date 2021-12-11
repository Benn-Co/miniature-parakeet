package org.netlib.arpack;

import org.netlib.lapack.Dlapy2;

public final class Dsortc
{
    public static void dsortc(String s, boolean flag, int i, double ad[], int j, double ad1[], int k, double ad2[], 
            int l)
    {
        int k2 = 0;
        k2 = i / 2;
        if(s.regionMatches(0, "LM", 0, 2))
            while(k2 != 0) 
            {
                int i1 = k2;
                for(int j4 = (i - 1 - k2) + 1; j4 > 0; j4--)
                {
                    int l2 = i1 - k2;
                    while(l2 >= 0) 
                    {
                        double d14 = Dlapy2.dlapy2(ad[(l2 - 0) + j], ad1[(l2 - 0) + k]);
                        double d17 = Dlapy2.dlapy2(ad[((l2 + k2) - 0) + j], ad1[((l2 + k2) - 0) + k]);
                        if(d14 <= d17)
                            break;
                        double d1 = ad[(l2 - 0) + j];
                        ad[(l2 - 0) + j] = ad[((l2 + k2) - 0) + j];
                        ad[((l2 + k2) - 0) + j] = d1;
                        d1 = ad1[(l2 - 0) + k];
                        ad1[(l2 - 0) + k] = ad1[((l2 + k2) - 0) + k];
                        ad1[((l2 + k2) - 0) + k] = d1;
                        if(flag)
                        {
                            double d2 = ad2[(l2 - 0) + l];
                            ad2[(l2 - 0) + l] = ad2[((l2 + k2) - 0) + l];
                            ad2[((l2 + k2) - 0) + l] = d2;
                        }
                        l2 -= k2;
                    }
                    i1++;
                }

                k2 /= 2;
            }
        else
        if(s.regionMatches(0, "SM", 0, 2))
            while(k2 != 0) 
            {
                int j1 = k2;
                for(int k4 = (i - 1 - k2) + 1; k4 > 0; k4--)
                {
                    int i3 = j1 - k2;
                    while(i3 >= 0) 
                    {
                        double d15 = Dlapy2.dlapy2(ad[(i3 - 0) + j], ad1[(i3 - 0) + k]);
                        double d18 = Dlapy2.dlapy2(ad[((i3 + k2) - 0) + j], ad1[((i3 + k2) - 0) + k]);
                        if(d15 >= d18)
                            break;
                        double d3 = ad[(i3 - 0) + j];
                        ad[(i3 - 0) + j] = ad[((i3 + k2) - 0) + j];
                        ad[((i3 + k2) - 0) + j] = d3;
                        d3 = ad1[(i3 - 0) + k];
                        ad1[(i3 - 0) + k] = ad1[((i3 + k2) - 0) + k];
                        ad1[((i3 + k2) - 0) + k] = d3;
                        if(flag)
                        {
                            double d4 = ad2[(i3 - 0) + l];
                            ad2[(i3 - 0) + l] = ad2[((i3 + k2) - 0) + l];
                            ad2[((i3 + k2) - 0) + l] = d4;
                        }
                        i3 -= k2;
                    }
                    j1++;
                }

                k2 /= 2;
            }
        else
        if(s.regionMatches(0, "LR", 0, 2))
            while(k2 != 0) 
            {
                int k1 = k2;
                for(int l4 = (i - 1 - k2) + 1; l4 > 0; l4--)
                {
                    for(int j3 = k1 - k2; (j3 >= 0) && (ad[(j3 - 0) + j] > ad[((j3 + k2) - 0) + j]); j3 -= k2)
                    {
                        double d5 = ad[(j3 - 0) + j];
                        ad[(j3 - 0) + j] = ad[((j3 + k2) - 0) + j];
                        ad[((j3 + k2) - 0) + j] = d5;
                        d5 = ad1[(j3 - 0) + k];
                        ad1[(j3 - 0) + k] = ad1[((j3 + k2) - 0) + k];
                        ad1[((j3 + k2) - 0) + k] = d5;
                        if(flag)
                        {
                            double d6 = ad2[(j3 - 0) + l];
                            ad2[(j3 - 0) + l] = ad2[((j3 + k2) - 0) + l];
                            ad2[((j3 + k2) - 0) + l] = d6;
                        }
                    }

                    k1++;
                }

                k2 /= 2;
            }
        else
        if(s.regionMatches(0, "SR", 0, 2))
            while(k2 != 0) 
            {
                int l1 = k2;
                for(int i5 = (i - 1 - k2) + 1; i5 > 0; i5--)
                {
                    for(int k3 = l1 - k2; (k3 >= 0) && (ad[(k3 - 0) + j] < ad[((k3 + k2) - 0) + j]); k3 -= k2)
                    {
                        double d7 = ad[(k3 - 0) + j];
                        ad[(k3 - 0) + j] = ad[((k3 + k2) - 0) + j];
                        ad[((k3 + k2) - 0) + j] = d7;
                        d7 = ad1[(k3 - 0) + k];
                        ad1[(k3 - 0) + k] = ad1[((k3 + k2) - 0) + k];
                        ad1[((k3 + k2) - 0) + k] = d7;
                        if(flag)
                        {
                            double d8 = ad2[(k3 - 0) + l];
                            ad2[(k3 - 0) + l] = ad2[((k3 + k2) - 0) + l];
                            ad2[((k3 + k2) - 0) + l] = d8;
                        }
                    }

                    l1++;
                }

                k2 /= 2;
            }
        else
        if(s.regionMatches(0, "LI", 0, 2))
            while(k2 != 0) 
            {
                int i2 = k2;
                for(int j5 = (i - 1 - k2) + 1; j5 > 0; j5--)
                {
                    for(int l3 = i2 - k2; (l3 >= 0) && (Math.abs(ad1[(l3 - 0) + k]) > Math.abs(ad1[((l3 + k2) - 0) + k])); l3 -= k2)
                    {
                        double d9 = ad[(l3 - 0) + j];
                        ad[(l3 - 0) + j] = ad[((l3 + k2) - 0) + j];
                        ad[((l3 + k2) - 0) + j] = d9;
                        d9 = ad1[(l3 - 0) + k];
                        ad1[(l3 - 0) + k] = ad1[((l3 + k2) - 0) + k];
                        ad1[((l3 + k2) - 0) + k] = d9;
                        if(flag)
                        {
                            double d10 = ad2[(l3 - 0) + l];
                            ad2[(l3 - 0) + l] = ad2[((l3 + k2) - 0) + l];
                            ad2[((l3 + k2) - 0) + l] = d10;
                        }
                    }

                    i2++;
                }

                k2 /= 2;
            }
        else
        if(s.regionMatches(0, "SI", 0, 2))
            while(k2 != 0) 
            {
                int j2 = k2;
                for(int k5 = (i - 1 - k2) + 1; k5 > 0; k5--)
                {
                    for(int i4 = j2 - k2; (i4 >= 0) && (Math.abs(ad1[(i4 - 0) + k]) < Math.abs(ad1[((i4 + k2) - 0) + k])); i4 -= k2)
                    {
                        double d11 = ad[(i4 - 0) + j];
                        ad[(i4 - 0) + j] = ad[((i4 + k2) - 0) + j];
                        ad[((i4 + k2) - 0) + j] = d11;
                        d11 = ad1[(i4 - 0) + k];
                        ad1[(i4 - 0) + k] = ad1[((i4 + k2) - 0) + k];
                        ad1[((i4 + k2) - 0) + k] = d11;
                        if(flag)
                        {
                            double d12 = ad2[(i4 - 0) + l];
                            ad2[(i4 - 0) + l] = ad2[((i4 + k2) - 0) + l];
                            ad2[((i4 + k2) - 0) + l] = d12;
                        }
                    }

                    j2++;
                }

                k2 /= 2;
            }
    }
}

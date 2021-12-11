package org.netlib.arpack;


public final class Dsortr
{
    public static void dsortr(String s, boolean flag, int i, double ad[], int j, double ad1[], int k)
    {
        int l1 = 0;
        l1 = i / 2;
        if(s.regionMatches(0, "SA", 0, 2))
            while(l1 != 0) 
            {
                int l = l1;
                for(int i3 = (i - 1 - l1) + 1; i3 > 0; i3--)
                {
                    for(int i2 = l - l1; (i2 >= 0) && (ad[(i2 - 0) + j] < ad[((i2 + l1) - 0) + j]); i2 -= l1)
                    {
                        double d1 = ad[(i2 - 0) + j];
                        ad[(i2 - 0) + j] = ad[((i2 + l1) - 0) + j];
                        ad[((i2 + l1) - 0) + j] = d1;
                        if(flag)
                        {
                            double d2 = ad1[(i2 - 0) + k];
                            ad1[(i2 - 0) + k] = ad1[((i2 + l1) - 0) + k];
                            ad1[((i2 + l1) - 0) + k] = d2;
                        }
                    }

                    l++;
                }

                l1 /= 2;
            }
        else
        if(s.regionMatches(0, "SM", 0, 2))
            while(l1 != 0) 
            {
                int i1 = l1;
                for(int j3 = (i - 1 - l1) + 1; j3 > 0; j3--)
                {
                    for(int j2 = i1 - l1; (j2 >= 0) && (Math.abs(ad[(j2 - 0) + j]) < Math.abs(ad[((j2 + l1) - 0) + j])); j2 -= l1)
                    {
                        double d3 = ad[(j2 - 0) + j];
                        ad[(j2 - 0) + j] = ad[((j2 + l1) - 0) + j];
                        ad[((j2 + l1) - 0) + j] = d3;
                        if(flag)
                        {
                            double d4 = ad1[(j2 - 0) + k];
                            ad1[(j2 - 0) + k] = ad1[((j2 + l1) - 0) + k];
                            ad1[((j2 + l1) - 0) + k] = d4;
                        }
                    }

                    i1++;
                }

                l1 /= 2;
            }
        else
        if(s.regionMatches(0, "LA", 0, 2))
            while(l1 != 0) 
            {
                int j1 = l1;
                for(int k3 = (i - 1 - l1) + 1; k3 > 0; k3--)
                {
                    for(int k2 = j1 - l1; (k2 >= 0) && (ad[(k2 - 0) + j] > ad[((k2 + l1) - 0) + j]); k2 -= l1)
                    {
                        double d5 = ad[(k2 - 0) + j];
                        ad[(k2 - 0) + j] = ad[((k2 + l1) - 0) + j];
                        ad[((k2 + l1) - 0) + j] = d5;
                        if(flag)
                        {
                            double d6 = ad1[(k2 - 0) + k];
                            ad1[(k2 - 0) + k] = ad1[((k2 + l1) - 0) + k];
                            ad1[((k2 + l1) - 0) + k] = d6;
                        }
                    }

                    j1++;
                }

                l1 /= 2;
            }
        else
        if(s.regionMatches(0, "LM", 0, 2))
            while(l1 != 0) 
            {
                int k1 = l1;
                for(int l3 = (i - 1 - l1) + 1; l3 > 0; l3--)
                {
                    for(int l2 = k1 - l1; (l2 >= 0) && (Math.abs(ad[(l2 - 0) + j]) > Math.abs(ad[((l2 + l1) - 0) + j])); l2 -= l1)
                    {
                        double d7 = ad[(l2 - 0) + j];
                        ad[(l2 - 0) + j] = ad[((l2 + l1) - 0) + j];
                        ad[((l2 + l1) - 0) + j] = d7;
                        if(flag)
                        {
                            double d8 = ad1[(l2 - 0) + k];
                            ad1[(l2 - 0) + k] = ad1[((l2 + l1) - 0) + k];
                            ad1[((l2 + l1) - 0) + k] = d8;
                        }
                    }

                    k1++;
                }

                l1 /= 2;
            }
    }
}

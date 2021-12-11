package org.netlib.arpack;

import org.netlib.blas.Dswap;

public final class Dsesrt
{
    public static void dsesrt(String s, boolean flag, int i, double ad[], int j, int k, double ad1[], int l, 
            int i1)
    {
        int j2 = 0;
        j2 = i / 2;
        if(s.regionMatches(0, "SA", 0, 2))
            while(j2 != 0) 
            {
                int j1 = j2;
                for(int k3 = (i - 1 - j2) + 1; k3 > 0; k3--)
                {
                    for(int k2 = j1 - j2; (k2 >= 0) && (ad[(k2 - 0) + j] < ad[((k2 + j2) - 0) + j]); k2 -= j2)
                    {
                        double d1 = ad[(k2 - 0) + j];
                        ad[(k2 - 0) + j] = ad[((k2 + j2) - 0) + j];
                        ad[((k2 + j2) - 0) + j] = d1;
                        if(flag)
                            Dswap.dswap(k, ad1, (1 - 1) + (k2 - 0) * i1 + l, 1, ad1, (1 - 1) + ((k2 + j2) - 0) * i1 + l, 1);
                    }

                    j1++;
                }

                j2 /= 2;
            }
        else
        if(s.regionMatches(0, "SM", 0, 2))
            while(j2 != 0) 
            {
                int k1 = j2;
                for(int l3 = (i - 1 - j2) + 1; l3 > 0; l3--)
                {
                    for(int l2 = k1 - j2; (l2 >= 0) && (Math.abs(ad[(l2 - 0) + j]) < Math.abs(ad[((l2 + j2) - 0) + j])); l2 -= j2)
                    {
                        double d2 = ad[(l2 - 0) + j];
                        ad[(l2 - 0) + j] = ad[((l2 + j2) - 0) + j];
                        ad[((l2 + j2) - 0) + j] = d2;
                        if(flag)
                            Dswap.dswap(k, ad1, (1 - 1) + (l2 - 0) * i1 + l, 1, ad1, (1 - 1) + ((l2 + j2) - 0) * i1 + l, 1);
                    }

                    k1++;
                }

                j2 /= 2;
            }
        else
        if(s.regionMatches(0, "LA", 0, 2))
            while(j2 != 0) 
            {
                int l1 = j2;
                for(int i4 = (i - 1 - j2) + 1; i4 > 0; i4--)
                {
                    for(int i3 = l1 - j2; (i3 >= 0) && (ad[(i3 - 0) + j] > ad[((i3 + j2) - 0) + j]); i3 -= j2)
                    {
                        double d3 = ad[(i3 - 0) + j];
                        ad[(i3 - 0) + j] = ad[((i3 + j2) - 0) + j];
                        ad[((i3 + j2) - 0) + j] = d3;
                        if(flag)
                            Dswap.dswap(k, ad1, (1 - 1) + (i3 - 0) * i1 + l, 1, ad1, (1 - 1) + ((i3 + j2) - 0) * i1 + l, 1);
                    }

                    l1++;
                }

                j2 /= 2;
            }
        else
        if(s.regionMatches(0, "LM", 0, 2))
            while(j2 != 0) 
            {
                int i2 = j2;
                for(int j4 = (i - 1 - j2) + 1; j4 > 0; j4--)
                {
                    for(int j3 = i2 - j2; (j3 >= 0) && (Math.abs(ad[(j3 - 0) + j]) > Math.abs(ad[((j3 + j2) - 0) + j])); j3 -= j2)
                    {
                        double d4 = ad[(j3 - 0) + j];
                        ad[(j3 - 0) + j] = ad[((j3 + j2) - 0) + j];
                        ad[((j3 + j2) - 0) + j] = d4;
                        if(flag)
                            Dswap.dswap(k, ad1, (1 - 1) + (j3 - 0) * i1 + l, 1, ad1, (1 - 1) + ((j3 + j2) - 0) * i1 + l, 1);
                    }

                    i2++;
                }

                j2 /= 2;
            }
    }
}

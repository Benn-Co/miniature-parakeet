package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgtsv
{
    public static void dgtsv(int i, int j, double ad[], int k, double ad1[], int l, double ad2[], int i1, 
            double ad3[], int j1, int k1, intW intw)
    {
        intw.val = 0;
        if(i < 0)
            intw.val = -1;
        else
        if(j < 0)
            intw.val = -2;
        else
        if(k1 < Math.max(1, i))
            intw.val = -7;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DGTSV ", -intw.val);
            return;
        }
        if(i == 0)
            return;
        if(j == 1)
        {
            int l1 = 1;
            for(int l4 = (i - 2 - 1) + 1; l4 > 0; l4--)
            {
                if(Math.abs(ad1[(l1 - 1) + l]) >= Math.abs(ad[(l1 - 1) + k]))
                {
                    if(ad1[(l1 - 1) + l] != 0.0D)
                    {
                        double d1 = ad[(l1 - 1) + k] / ad1[(l1 - 1) + l];
                        ad1[((l1 + 1) - 1) + l] = ad1[((l1 + 1) - 1) + l] - d1 * ad2[(l1 - 1) + i1];
                        ad3[((l1 + 1) - 1) + (1 - 1) * k1 + j1] = ad3[((l1 + 1) - 1) + (1 - 1) * k1 + j1] - d1 * ad3[(l1 - 1) + (1 - 1) * k1 + j1];
                    } else
                    {
                        intw.val = l1;
                        return;
                    }
                    ad[(l1 - 1) + k] = 0.0D;
                } else
                {
                    double d2 = ad1[(l1 - 1) + l] / ad[(l1 - 1) + k];
                    ad1[(l1 - 1) + l] = ad[(l1 - 1) + k];
                    double d10 = ad1[((l1 + 1) - 1) + l];
                    ad1[((l1 + 1) - 1) + l] = ad2[(l1 - 1) + i1] - d2 * d10;
                    ad[(l1 - 1) + k] = ad2[((l1 + 1) - 1) + i1];
                    ad2[((l1 + 1) - 1) + i1] = -(d2 * ad[(l1 - 1) + k]);
                    ad2[(l1 - 1) + i1] = d10;
                    d10 = ad3[(l1 - 1) + (1 - 1) * k1 + j1];
                    ad3[(l1 - 1) + (1 - 1) * k1 + j1] = ad3[((l1 + 1) - 1) + (1 - 1) * k1 + j1];
                    ad3[((l1 + 1) - 1) + (1 - 1) * k1 + j1] = d10 - d2 * ad3[((l1 + 1) - 1) + (1 - 1) * k1 + j1];
                }
                l1++;
            }

            if(i > 1)
            {
                int i2 = i - 1;
                if(Math.abs(ad1[(i2 - 1) + l]) >= Math.abs(ad[(i2 - 1) + k]))
                {
                    if(ad1[(i2 - 1) + l] != 0.0D)
                    {
                        double d3 = ad[(i2 - 1) + k] / ad1[(i2 - 1) + l];
                        ad1[((i2 + 1) - 1) + l] = ad1[((i2 + 1) - 1) + l] - d3 * ad2[(i2 - 1) + i1];
                        ad3[((i2 + 1) - 1) + (1 - 1) * k1 + j1] = ad3[((i2 + 1) - 1) + (1 - 1) * k1 + j1] - d3 * ad3[(i2 - 1) + (1 - 1) * k1 + j1];
                    } else
                    {
                        intw.val = i2;
                        return;
                    }
                } else
                {
                    double d4 = ad1[(i2 - 1) + l] / ad[(i2 - 1) + k];
                    ad1[(i2 - 1) + l] = ad[(i2 - 1) + k];
                    double d11 = ad1[((i2 + 1) - 1) + l];
                    ad1[((i2 + 1) - 1) + l] = ad2[(i2 - 1) + i1] - d4 * d11;
                    ad2[(i2 - 1) + i1] = d11;
                    d11 = ad3[(i2 - 1) + (1 - 1) * k1 + j1];
                    ad3[(i2 - 1) + (1 - 1) * k1 + j1] = ad3[((i2 + 1) - 1) + (1 - 1) * k1 + j1];
                    ad3[((i2 + 1) - 1) + (1 - 1) * k1 + j1] = d11 - d4 * ad3[((i2 + 1) - 1) + (1 - 1) * k1 + j1];
                }
            }
            if(ad1[(i - 1) + l] == 0.0D)
            {
                intw.val = i;
                return;
            }
        } else
        {
            int j2 = 1;
            for(int i5 = (i - 2 - 1) + 1; i5 > 0; i5--)
            {
                if(Math.abs(ad1[(j2 - 1) + l]) >= Math.abs(ad[(j2 - 1) + k]))
                {
                    if(ad1[(j2 - 1) + l] != 0.0D)
                    {
                        double d5 = ad[(j2 - 1) + k] / ad1[(j2 - 1) + l];
                        ad1[((j2 + 1) - 1) + l] = ad1[((j2 + 1) - 1) + l] - d5 * ad2[(j2 - 1) + i1];
                        int j3 = 1;
                        for(int j6 = (j - 1) + 1; j6 > 0; j6--)
                        {
                            ad3[((j2 + 1) - 1) + (j3 - 1) * k1 + j1] = ad3[((j2 + 1) - 1) + (j3 - 1) * k1 + j1] - d5 * ad3[(j2 - 1) + (j3 - 1) * k1 + j1];
                            j3++;
                        }

                    } else
                    {
                        intw.val = j2;
                        return;
                    }
                    ad[(j2 - 1) + k] = 0.0D;
                } else
                {
                    double d6 = ad1[(j2 - 1) + l] / ad[(j2 - 1) + k];
                    ad1[(j2 - 1) + l] = ad[(j2 - 1) + k];
                    double d12 = ad1[((j2 + 1) - 1) + l];
                    ad1[((j2 + 1) - 1) + l] = ad2[(j2 - 1) + i1] - d6 * d12;
                    ad[(j2 - 1) + k] = ad2[((j2 + 1) - 1) + i1];
                    ad2[((j2 + 1) - 1) + i1] = -(d6 * ad[(j2 - 1) + k]);
                    ad2[(j2 - 1) + i1] = d12;
                    int k3 = 1;
                    for(int k6 = (j - 1) + 1; k6 > 0; k6--)
                    {
                        double d13 = ad3[(j2 - 1) + (k3 - 1) * k1 + j1];
                        ad3[(j2 - 1) + (k3 - 1) * k1 + j1] = ad3[((j2 + 1) - 1) + (k3 - 1) * k1 + j1];
                        ad3[((j2 + 1) - 1) + (k3 - 1) * k1 + j1] = d13 - d6 * ad3[((j2 + 1) - 1) + (k3 - 1) * k1 + j1];
                        k3++;
                    }

                }
                j2++;
            }

            if(i > 1)
            {
                int k2 = i - 1;
                if(Math.abs(ad1[(k2 - 1) + l]) >= Math.abs(ad[(k2 - 1) + k]))
                {
                    if(ad1[(k2 - 1) + l] != 0.0D)
                    {
                        double d7 = ad[(k2 - 1) + k] / ad1[(k2 - 1) + l];
                        ad1[((k2 + 1) - 1) + l] = ad1[((k2 + 1) - 1) + l] - d7 * ad2[(k2 - 1) + i1];
                        int l3 = 1;
                        for(int j5 = (j - 1) + 1; j5 > 0; j5--)
                        {
                            ad3[((k2 + 1) - 1) + (l3 - 1) * k1 + j1] = ad3[((k2 + 1) - 1) + (l3 - 1) * k1 + j1] - d7 * ad3[(k2 - 1) + (l3 - 1) * k1 + j1];
                            l3++;
                        }

                    } else
                    {
                        intw.val = k2;
                        return;
                    }
                } else
                {
                    double d8 = ad1[(k2 - 1) + l] / ad[(k2 - 1) + k];
                    ad1[(k2 - 1) + l] = ad[(k2 - 1) + k];
                    double d14 = ad1[((k2 + 1) - 1) + l];
                    ad1[((k2 + 1) - 1) + l] = ad2[(k2 - 1) + i1] - d8 * d14;
                    ad2[(k2 - 1) + i1] = d14;
                    int i4 = 1;
                    for(int k5 = (j - 1) + 1; k5 > 0; k5--)
                    {
                        double d15 = ad3[(k2 - 1) + (i4 - 1) * k1 + j1];
                        ad3[(k2 - 1) + (i4 - 1) * k1 + j1] = ad3[((k2 + 1) - 1) + (i4 - 1) * k1 + j1];
                        ad3[((k2 + 1) - 1) + (i4 - 1) * k1 + j1] = d15 - d8 * ad3[((k2 + 1) - 1) + (i4 - 1) * k1 + j1];
                        i4++;
                    }

                }
            }
            if(ad1[(i - 1) + l] == 0.0D)
            {
                intw.val = i;
                return;
            }
        }
        if(j <= 2)
        {
            int j4 = 1;
            do
            {
                ad3[(i - 1) + (j4 - 1) * k1 + j1] = ad3[(i - 1) + (j4 - 1) * k1 + j1] / ad1[(i - 1) + l];
                if(i > 1)
                    ad3[(i - 1 - 1) + (j4 - 1) * k1 + j1] = (ad3[(i - 1 - 1) + (j4 - 1) * k1 + j1] - ad2[(i - 1 - 1) + i1] * ad3[(i - 1) + (j4 - 1) * k1 + j1]) / ad1[(i - 1 - 1) + l];
                int l2 = i - 2;
                for(int l5 = ((1 - (i - 2)) + -1) / -1; l5 > 0; l5--)
                {
                    ad3[(l2 - 1) + (j4 - 1) * k1 + j1] = (ad3[(l2 - 1) + (j4 - 1) * k1 + j1] - ad2[(l2 - 1) + i1] * ad3[((l2 + 1) - 1) + (j4 - 1) * k1 + j1] - ad[(l2 - 1) + k] * ad3[((l2 + 2) - 1) + (j4 - 1) * k1 + j1]) / ad1[(l2 - 1) + l];
                    l2--;
                }

                if(j4 >= j)
                    break;
                j4++;
            } while(true);
        } else
        {
            int k4 = 1;
            for(int i6 = (j - 1) + 1; i6 > 0; i6--)
            {
                ad3[(i - 1) + (k4 - 1) * k1 + j1] = ad3[(i - 1) + (k4 - 1) * k1 + j1] / ad1[(i - 1) + l];
                if(i > 1)
                    ad3[(i - 1 - 1) + (k4 - 1) * k1 + j1] = (ad3[(i - 1 - 1) + (k4 - 1) * k1 + j1] - ad2[(i - 1 - 1) + i1] * ad3[(i - 1) + (k4 - 1) * k1 + j1]) / ad1[(i - 1 - 1) + l];
                int i3 = i - 2;
                for(int l6 = ((1 - (i - 2)) + -1) / -1; l6 > 0; l6--)
                {
                    ad3[(i3 - 1) + (k4 - 1) * k1 + j1] = (ad3[(i3 - 1) + (k4 - 1) * k1 + j1] - ad2[(i3 - 1) + i1] * ad3[((i3 + 1) - 1) + (k4 - 1) * k1 + j1] - ad[(i3 - 1) + k] * ad3[((i3 + 2) - 1) + (k4 - 1) * k1 + j1]) / ad1[(i3 - 1) + l];
                    i3--;
                }

                k4++;
            }

        }
    }
}

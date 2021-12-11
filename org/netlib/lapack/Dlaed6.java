package org.netlib.lapack;

import org.netlib.util.*;

public final class Dlaed6
{
    public static void dlaed6(int i, boolean flag, double d, double ad[], int j, double ad1[], int k, 
            double d1, doubleW doublew, intW intw)
    {
        boolean flag1;
        double d24;
label0:
        {
            double ad2[] = new double[3];
            double ad3[] = new double[3];
            flag1 = false;
            int l = 0;
            int j1 = 0;
            int k1 = 0;
            double d8 = 0.0D;
            double d12 = 0.0D;
            double d13 = 0.0D;
            double d14 = 0.0D;
            double d19 = 0.0D;
            double d20 = 0.0D;
            d24 = 0.0D;
            double d25 = 0.0D;
            double d26 = 0.0D;
            double d27 = 0.0D;
            double d28 = 0.0D;
            double d29 = 0.0D;
            double d46 = 0.0D;
            double d47 = 0.0D;
            intw.val = 0;
            if(flag)
            {
                d46 = ad[(2 - 1) + j];
                d47 = ad[(3 - 1) + j];
            } else
            {
                d46 = ad[(1 - 1) + j];
                d47 = ad[(2 - 1) + j];
            }
            if(d1 < 0.0D)
                d46 = 0.0D;
            else
                d47 = 0.0D;
            k1 = 1;
            doublew.val = 0.0D;
            if(i == 2)
            {
                double d3;
                double d6;
                double d10;
                if(flag)
                {
                    d29 = (ad[(3 - 1) + j] - ad[(2 - 1) + j]) / 2D;
                    d10 = d + ad1[(1 - 1) + k] / (ad[(1 - 1) + j] - ad[(2 - 1) + j] - d29);
                    d3 = d10 * (ad[(2 - 1) + j] + ad[(3 - 1) + j]) + ad1[(2 - 1) + k] + ad1[(3 - 1) + k];
                    d6 = d10 * ad[(2 - 1) + j] * ad[(3 - 1) + j] + ad1[(2 - 1) + k] * ad[(3 - 1) + j] + ad1[(3 - 1) + k] * ad[(2 - 1) + j];
                } else
                {
                    d29 = (ad[(1 - 1) + j] - ad[(2 - 1) + j]) / 2D;
                    d10 = d + ad1[(3 - 1) + k] / (ad[(3 - 1) + j] - ad[(2 - 1) + j] - d29);
                    d3 = d10 * (ad[(1 - 1) + j] + ad[(2 - 1) + j]) + ad1[(1 - 1) + k] + ad1[(2 - 1) + k];
                    d6 = d10 * ad[(1 - 1) + j] * ad[(2 - 1) + j] + ad1[(1 - 1) + k] * ad[(2 - 1) + j] + ad1[(2 - 1) + k] * ad[(1 - 1) + j];
                }
                d29 = Util.max(Math.abs(d3), Math.abs(d6), Math.abs(d10));
                d3 /= d29;
                d6 /= d29;
                d10 /= d29;
                if(d10 == 0.0D)
                    doublew.val = d6 / d3;
                else
                if(d3 <= 0.0D)
                    doublew.val = (d3 - Math.sqrt(Math.abs(d3 * d3 - 4D * d6 * d10))) / (2D * d10);
                else
                    doublew.val = (2D * d6) / (d3 + Math.sqrt(Math.abs(d3 * d3 - 4D * d6 * d10)));
                if((doublew.val < d46) || (doublew.val > d47))
                    doublew.val = (d46 + d47) / 2D;
                if(((ad[(1 - 1) + j] == doublew.val) || (ad[(2 - 1) + j] == doublew.val)) || (ad[(3 - 1) + j] == doublew.val))
                {
                    doublew.val = 0.0D;
                } else
                {
                    d29 = d1 + (doublew.val * ad1[(1 - 1) + k]) / (ad[(1 - 1) + j] * (ad[(1 - 1) + j] - doublew.val)) + (doublew.val * ad1[(2 - 1) + k]) / (ad[(2 - 1) + j] * (ad[(2 - 1) + j] - doublew.val)) + (doublew.val * ad1[(3 - 1) + k]) / (ad[(3 - 1) + j] * (ad[(3 - 1) + j] - doublew.val));
                    if(d29 <= 0.0D)
                        d46 = doublew.val;
                    else
                        d47 = doublew.val;
                    if(Math.abs(d1) <= Math.abs(d29))
                        doublew.val = 0.0D;
                }
            }
            d14 = Dlamch.dlamch("Epsilon");
            d8 = Dlamch.dlamch("Base");
            d25 = Math.pow(d8, (int)(Math.log(Dlamch.dlamch("SafMin")) / Math.log(d8) / 3D));
            d27 = 1.0D / d25;
            d26 = d25 * d25;
            d28 = d27 * d27;
            if(flag)
                d29 = Math.min(Math.abs(ad[(2 - 1) + j] - doublew.val), Math.abs(ad[(3 - 1) + j] - doublew.val));
            else
                d29 = Math.min(Math.abs(ad[(1 - 1) + j] - doublew.val), Math.abs(ad[(2 - 1) + j] - doublew.val));
            flag1 = false;
            if(d29 <= d25)
            {
                flag1 = true;
                double d23;
                if(d29 <= d26)
                {
                    d23 = d28;
                    d24 = d26;
                } else
                {
                    d23 = d27;
                    d24 = d25;
                }
                l = 1;
                for(int l1 = (3 - 1) + 1; l1 > 0; l1--)
                {
                    ad2[l - 1] = ad[(l - 1) + j] * d23;
                    ad3[l - 1] = ad1[(l - 1) + k] * d23;
                    l++;
                }

                doublew.val = doublew.val * d23;
                d46 *= d23;
                d47 *= d23;
            } else
            {
                l = 1;
                for(int i2 = (3 - 1) + 1; i2 > 0; i2--)
                {
                    ad2[l - 1] = ad[(l - 1) + j];
                    ad3[l - 1] = ad1[(l - 1) + k];
                    l++;
                }

            }
            d20 = 0.0D;
            d13 = 0.0D;
            d12 = 0.0D;
            l = 1;
            for(int j2 = (3 - 1) + 1; j2 > 0; j2--)
            {
                double d30 = 1.0D / (ad2[l - 1] - doublew.val);
                double d34 = ad3[l - 1] * d30;
                double d38 = d34 * d30;
                double d42 = d38 * d30;
                d20 += d34 / ad2[l - 1];
                d13 += d38;
                d12 += d42;
                l++;
            }

            d19 = d1 + doublew.val * d20;
            if(Math.abs(d19) <= 0.0D)
                break label0;
            if(d19 <= 0.0D)
                d46 = doublew.val;
            else
                d47 = doublew.val;
            j1 = k1 + 1;
            k1 = j1;
            for(int k2 = (40 - j1) + 1; k2 > 0; k2--)
            {
                double d35;
                double d39;
                if(flag)
                {
                    d35 = ad2[2 - 1] - doublew.val;
                    d39 = ad2[3 - 1] - doublew.val;
                } else
                {
                    d35 = ad2[1 - 1] - doublew.val;
                    d39 = ad2[2 - 1] - doublew.val;
                }
                double d4 = (d35 + d39) * d19 - d35 * d39 * d13;
                double d7 = d35 * d39 * d19;
                double d11 = (d19 - (d35 + d39) * d13) + d35 * d39 * d12;
                double d31 = Util.max(Math.abs(d4), Math.abs(d7), Math.abs(d11));
                d4 /= d31;
                d7 /= d31;
                d11 /= d31;
                double d18;
                if(d11 == 0.0D)
                    d18 = d7 / d4;
                else
                if(d4 <= 0.0D)
                    d18 = (d4 - Math.sqrt(Math.abs(d4 * d4 - 4D * d7 * d11))) / (2D * d11);
                else
                    d18 = (2D * d7) / (d4 + Math.sqrt(Math.abs(d4 * d4 - 4D * d7 * d11)));
                if(d19 * d18 >= 0.0D)
                    d18 = -(d19 / d13);
                doublew.val = doublew.val + d18;
                if((doublew.val < d46) || (doublew.val > d47))
                    doublew.val = (d46 + d47) / 2D;
                double d21 = 0.0D;
                double d16 = 0.0D;
                d13 = 0.0D;
                d12 = 0.0D;
                int i1 = 1;
                for(int l2 = (3 - 1) + 1; l2 > 0; l2--)
                {
                    double d32 = 1.0D / (ad2[i1 - 1] - doublew.val);
                    double d36 = ad3[i1 - 1] * d32;
                    double d40 = d36 * d32;
                    double d43 = d40 * d32;
                    double d45 = d36 / ad2[i1 - 1];
                    d21 += d45;
                    d16 += Math.abs(d45);
                    d13 += d40;
                    d12 += d43;
                    i1++;
                }

                d19 = d1 + doublew.val * d21;
                d16 = 8D * (Math.abs(d1) + Math.abs(doublew.val) * d16) + Math.abs(doublew.val) * d13;
                if(Math.abs(d19) <= d14 * d16)
                    break label0;
                if(d19 <= 0.0D)
                    d46 = doublew.val;
                else
                    d47 = doublew.val;
                k1++;
            }

            intw.val = 1;
        }
        if(flag1)
            doublew.val = doublew.val * d24;
    }
}

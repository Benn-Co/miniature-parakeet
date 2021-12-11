package org.netlib.lapack;

import org.netlib.util.doubleW;

public final class Dlasd5
{
    public static void dlasd5(int i, double[] ad, int j, double[] ad1, int k, double[] ad2, int l, double d, doubleW doublew, double[] ad3, int i1)
    {
        double d9 = 0.0;
        double d10 = 0.0;
        d9 = ad[1 + j] - ad[j];
        d10 = d9 * (ad[1 + j] + ad[j]);
        if (i == 1)
        {
            double d16 = 1.0 + (4.0 * d * ((ad1[1 + k] * ad1[1 + k]) / (ad[j] + 3.0 * ad[1 + j]) - (ad1[k] * ad1[k]) / (3.0 * ad[j] + ad[1 + j]))) / d9;
            if(d16 > 0.0)
            {
                double d2 = d10 + d * (ad1[k] * ad1[k] + ad1[1 + k] * ad1[1 + k]);
                double d6 = d * ad1[k] * ad1[k] * d10;
                double d12 = (2.0 * d6) / (d2 + Math.sqrt(Math.abs(d2 * d2 - 4.0 * d6)));
                d12 /= ad[j] + Math.sqrt(ad[j] * ad[j] + d12);
                doublew.val = ad[j] + d12;
                ad2[l] = -d12;
                ad2[1 + l] = d9 - d12;
                ad3[i1] = 2.0 * ad[j] + d12;
                ad3[1 + i1] = ad[j] + d12 + ad[1 + j];
            } else
            {
                double d3 = -d10 + d * (ad1[k] * ad1[k] + ad1[1 + k] * ad1[1 + k]);
                double d7 = d * ad1[1 + k] * ad1[1 + k] * d10;
                double d13;
                if (d3 > 0.0) {
                    d13 = -((2.0 * d7) / (d3 + Math.sqrt(d3 * d3 + 4.0 * d7)));
                } else {
                    d13 = (d3 - Math.sqrt(d3 * d3 + 4.0 * d7)) / 2.0;
                }
                d13 /= ad[1 + j] + Math.sqrt(Math.abs(ad[1 + j] * ad[1 + j] + d13));
                doublew.val = ad[1 + j] + d13;
                ad2[l] = -(d9 + d13);
                ad2[1 + l] = -d13;
                ad3[i1] = ad[j] + d13 + ad[1 + j];
                ad3[1 + i1] = 2.0 * ad[1 + j] + d13;
            }
        } else
        {
            double d4 = -d10 + d * (ad1[k] * ad1[k] + ad1[1 + k] * ad1[1 + k]);
            double d8 = d * ad1[1 + k] * ad1[1 + k] * d10;
            double d14;
            if (d4 > 0.0) {
                d14 = (d4 + Math.sqrt(d4 * d4 + 4.0 * d8)) / 2.0;
            } else {
                d14 = (2.0 * d8) / (-d4 + Math.sqrt(d4 * d4 + 4.0 * d8));
            }
            d14 /= ad[1 + j] + Math.sqrt(ad[1 + j] * ad[1 + j] + d14);
            doublew.val = ad[1 + j] + d14;
            ad2[l] = -(d9 + d14);
            ad2[1 + l] = -d14;
            ad3[i1] = ad[j] + d14 + ad[1 + j];
            ad3[1 + i1] = 2.0 * ad[1 + j] + d14;
        }
    }
}

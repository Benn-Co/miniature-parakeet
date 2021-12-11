package org.netlib.lapack;

import org.netlib.util.doubleW;

public final class Dlasq5
{
    public static void dlasq5(int i, int j, double ad[], int k, int l, double d, doubleW doublew, 
            doubleW doublew1, doubleW doublew2, doubleW doublew3, doubleW doublew4, doubleW doublew5, boolean flag)
    {
        int i1 = 0;
        double d1 = 0.0;
        double d2 = 0.0;
        if(j - i - 1 <= 0)
            return;
        i1 = (4 * i + l) - 3;
        d2 = ad[((i1 + 4) - 1) + k];
        d1 = ad[(i1 - 1) + k] - d;
        doublew.val = d1;
        doublew1.val = -ad[(i1 - 1) + k];
        if(flag)
        {
            if(l == 0)
            {
                i1 = 4 * i;
                for(int l1 = ((4 * (j - 3) - 4 * i) + 4) / 4; l1 > 0; l1--)
                {
                    ad[(i1 - 2 - 1) + k] = d1 + ad[(i1 - 1 - 1) + k];
                    double d4 = ad[((i1 + 1) - 1) + k] / ad[(i1 - 2 - 1) + k];
                    d1 = d1 * d4 - d;
                    doublew.val = Math.min(doublew.val, d1);
                    ad[(i1 - 1) + k] = ad[(i1 - 1 - 1) + k] * d4;
                    d2 = Math.min(ad[(i1 - 1) + k], d2);
                    i1 += 4;
                }

            } else
            {
                i1 = 4 * i;
                for(int i2 = ((4 * (j - 3) - 4 * i) + 4) / 4; i2 > 0; i2--)
                {
                    ad[(i1 - 3 - 1) + k] = d1 + ad[(i1 - 1) + k];
                    double d5 = ad[((i1 + 2) - 1) + k] / ad[(i1 - 3 - 1) + k];
                    d1 = d1 * d5 - d;
                    doublew.val = Math.min(doublew.val, d1);
                    ad[(i1 - 2) + k] = ad[(i1 - 1) + k] * d5;
                    d2 = Math.min(ad[(i1 - 2) + k], d2);
                    i1 += 4;
                }

            }
            doublew5.val = d1;
            doublew2.val = doublew.val;
            i1 = 4 * (j - 2) - l;
            int j1 = (i1 + 2 * l) - 1;
            ad[(i1 - 3) + k] = doublew5.val + ad[(j1 - 1) + k];
            ad[(i1 - 1) + k] = ad[((j1 + 2) - 1) + k] * (ad[(j1 - 1) + k] / ad[(i1 - 3) + k]);
            doublew4.val = ad[((j1 + 2) - 1) + k] * (doublew5.val / ad[(i1 - 3) + k]) - d;
            doublew.val = Math.min(doublew.val, doublew4.val);
            doublew1.val = doublew.val;
            i1 += 4;
            j1 = (i1 + 2 * l) - 1;
            ad[(i1 - 3) + k] = doublew4.val + ad[(j1 - 1) + k];
            ad[(i1 - 1) + k] = ad[((j1 + 2) - 1) + k] * (ad[(j1 - 1) + k] / ad[(i1 - 3) + k]);
            doublew3.val = ad[((j1 + 2) - 1) + k] * (doublew4.val / ad[(i1 - 3) + k]) - d;
            doublew.val = Math.min(doublew.val, doublew3.val);
        } else
        {
            if(l == 0)
            {
                i1 = 4 * i;
                for(int j2 = ((4 * (j - 3) - 4 * i) + 4) / 4; j2 > 0; j2--)
                {
                    ad[(i1 - 2 - 1) + k] = d1 + ad[(i1 - 1 - 1) + k];
                    if(d1 < 0.0)
                        return;
                    ad[(i1 - 1) + k] = ad[((i1 + 1) - 1) + k] * (ad[(i1 - 2) + k] / ad[(i1 - 3) + k]);
                    d1 = ad[((i1 + 1) - 1) + k] * (d1 / ad[(i1 - 3) + k]) - d;
                    doublew.val = Math.min(doublew.val, d1);
                    d2 = Math.min(d2, ad[(i1 - 1) + k]);
                    i1 += 4;
                }

            } else
            {
                i1 = 4 * i;
                for(int k2 = ((4 * (j - 3) - 4 * i) + 4) / 4; k2 > 0; k2--)
                {
                    ad[(i1 - 3 - 1) + k] = d1 + ad[(i1 - 1) + k];
                    if(d1 < 0.0)
                        return;
                    ad[(i1 - 2) + k] = ad[((i1 + 2) - 1) + k] * (ad[(i1 - 1) + k] / ad[(i1 - 4) + k]);
                    d1 = ad[((i1 + 2) - 1) + k] * (d1 / ad[(i1 - 4) + k]) - d;
                    doublew.val = Math.min(doublew.val, d1);
                    d2 = Math.min(d2, ad[(i1 - 2) + k]);
                    i1 += 4;
                }

            }
            doublew5.val = d1;
            doublew2.val = doublew.val;
            i1 = 4 * (j - 2) - l;
            int k1 = (i1 + 2 * l) - 1;
            ad[(i1 - 3) + k] = doublew5.val + ad[(k1 - 1) + k];
            if (doublew5.val < 0.0)
                return;
            ad[(i1 - 1) + k] = ad[((k1 + 2) - 1) + k] * (ad[(k1 - 1) + k] / ad[(i1 - 3) + k]);
            doublew4.val = ad[((k1 + 2) - 1) + k] * (doublew5.val / ad[(i1 - 3) + k]) - d;
            doublew.val = Math.min(doublew.val, doublew4.val);
            doublew1.val = doublew.val;
            i1 += 4;
            k1 = (i1 + 2 * l) - 1;
            ad[(i1 - 3) + k] = doublew4.val + ad[(k1 - 1) + k];
            if(doublew4.val < 0.0)
                return;
            ad[(i1 - 1) + k] = ad[((k1 + 2) - 1) + k] * (ad[(k1 - 1) + k] / ad[(i1 - 3) + k]);
            doublew3.val = ad[((k1 + 2) - 1) + k] * (doublew4.val / ad[(i1 - 3) + k]) - d;
            doublew.val = Math.min(doublew.val, doublew3.val);
        }
        ad[((i1 + 2) - 1) + k] = doublew3.val;
        ad[(4 * j - l - 1) + k] = d2;
    }
}

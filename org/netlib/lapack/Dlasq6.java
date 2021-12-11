package org.netlib.lapack;

import org.netlib.util.doubleW;

public final class Dlasq6
{
    public static void dlasq6(int i, int j, double ad[], int k, int l, doubleW doublew, doubleW doublew1, doubleW doublew2, 
            doubleW doublew3, doubleW doublew4, doubleW doublew5)
    {
        int i1 = 0;
        int j1 = 0;
        double d = 0.0;
        double d1 = 0.0;
        double d2 = 0.0;
        if(j - i - 1 <= 0)
            return;
        d2 = Dlamch.dlamch("Safe minimum");
        i1 = (4 * i + l) - 3;
        d1 = ad[((i1 + 4) - 1) + k];
        d = ad[(i1 - 1) + k];
        doublew.val = d;
        if(l == 0)
        {
            i1 = 4 * i;
            for(int k1 = ((4 * (j - 3) - 4 * i) + 4) / 4; k1 > 0; k1--)
            {
                ad[(i1 - 2 - 1) + k] = d + ad[(i1 - 1 - 1) + k];
                if(ad[(i1 - 2 - 1) + k] == 0.0)
                {
                    ad[(i1 - 1) + k] = 0.0;
                    d = ad[((i1 + 1) - 1) + k];
                    doublew.val = d;
                    d1 = 0.0;
                } else
                if((d2 * ad[((i1 + 1) - 1) + k] < ad[(i1 - 2 - 1) + k]) && (d2 * ad[(i1 - 2 - 1) + k] < ad[((i1 + 1) - 1) + k]))
                {
                    double d4 = ad[((i1 + 1) - 1) + k] / ad[(i1 - 2 - 1) + k];
                    ad[(i1 - 1) + k] = ad[(i1 - 2) + k] * d4;
                    d *= d4;
                } else
                {
                    ad[(i1 - 1) + k] = ad[((i1 + 1) - 1) + k] * (ad[(i1 - 2) + k] / ad[(i1 - 3) + k]);
                    d = ad[((i1 + 1) - 1) + k] * (d / ad[(i1 - 3) + k]);
                }
                doublew.val = Math.min(doublew.val, d);
                d1 = Math.min(d1, ad[(i1 - 1) + k]);
                i1 += 4;
            }

        } else
        {
            i1 = 4 * i;
            for(int l1 = ((4 * (j - 3) - 4 * i) + 4) / 4; l1 > 0; l1--)
            {
                ad[(i1 - 4) + k] = d + ad[(i1 - 1) + k];
                if(ad[(i1 - 4) + k] == 0.0)
                {
                    ad[(i1 - 2) + k] = 0.0;
                    d = ad[((i1 + 2) - 1) + k];
                    doublew.val = d;
                    d1 = 0.0;
                } else
                if((d2 * ad[((i1 + 2) - 1) + k] < ad[(i1 - 4) + k]) && (d2 * ad[(i1 - 4) + k] < ad[((i1 + 2) - 1) + k]))
                {
                    double d5 = ad[((i1 + 2) - 1) + k] / ad[(i1 - 4) + k];
                    ad[(i1 - 2) + k] = ad[(i1 - 1) + k] * d5;
                    d *= d5;
                } else
                {
                    ad[(i1 - 2) + k] = ad[((i1 + 2) - 1) + k] * (ad[(i1 - 1) + k] / ad[(i1 - 4) + k]);
                    d = ad[((i1 + 2) - 1) + k] * (d / ad[(i1 - 3 - 1) + k]);
                }
                doublew.val = Math.min(doublew.val, d);
                d1 = Math.min(d1, ad[(i1 - 1 - 1) + k]);
                i1 += 4;
            }

        }
        doublew5.val = d;
        doublew2.val = doublew.val;
        i1 = 4 * (j - 2) - l;
        j1 = (i1 + 2 * l) - 1;
        ad[(i1 - 3) + k] = doublew5.val + ad[(j1 - 1) + k];
        if(ad[(i1 - 3) + k] == 0.0)
        {
            ad[(i1 - 1) + k] = 0.0;
            doublew4.val = ad[((j1 + 2) - 1) + k];
            doublew.val = doublew4.val;
            d1 = 0.0;
        } else
        if((d2 * ad[((j1 + 2) - 1) + k] < ad[(i1 - 3) + k]) && (d2 * ad[(i1 - 3) + k] < ad[((j1 + 2) - 1) + k]))
        {
            double d6 = ad[((j1 + 2) - 1) + k] / ad[(i1 - 3) + k];
            ad[(i1 - 1) + k] = ad[(j1 - 1) + k] * d6;
            doublew4.val = doublew5.val * d6;
        } else
        {
            ad[(i1 - 1) + k] = ad[((j1 + 2) - 1) + k] * (ad[(j1 - 1) + k] / ad[(i1 - 2 - 1) + k]);
            doublew4.val = ad[((j1 + 2) - 1) + k] * (doublew5.val / ad[(i1 - 3) + k]);
        }
        doublew.val = Math.min(doublew.val, doublew4.val);
        doublew1.val = doublew.val;
        i1 += 4;
        j1 = (i1 + 2 * l) - 1;
        ad[(i1 - 3) + k] = doublew4.val + ad[(j1 - 1) + k];
        if(ad[(i1 - 3) + k] == 0.0)
        {
            ad[(i1 - 1) + k] = 0.0;
            doublew3.val = ad[((j1 + 2) - 1) + k];
            doublew.val = doublew3.val;
            d1 = 0.0;
        } else
        if((d2 * ad[((j1 + 2) - 1) + k] < ad[(i1 - 3) + k]) && (d2 * ad[(i1 - 3) + k] < ad[((j1 + 2) - 1) + k]))
        {
            double d7 = ad[((j1 + 2) - 1) + k] / ad[(i1 - 3) + k];
            ad[(i1 - 1) + k] = ad[(j1 - 1) + k] * d7;
            doublew3.val = doublew4.val * d7;
        } else
        {
            ad[(i1 - 1) + k] = ad[((j1 + 2) - 1) + k] * (ad[(j1 - 1) + k] / ad[(i1 - 3) + k]);
            doublew3.val = ad[((j1 + 2) - 1) + k] * (doublew4.val / ad[(i1 - 3) + k]);
        }
        doublew.val = Math.min(doublew.val, doublew3.val);
        ad[((i1 + 2) - 1) + k] = doublew3.val;
        ad[(4 * j - l - 1) + k] = d1;
    }
}

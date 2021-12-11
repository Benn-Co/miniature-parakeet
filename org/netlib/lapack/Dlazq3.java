package org.netlib.lapack;

import org.netlib.util.*;

public final class Dlazq3
{
    public static void dlazq3(int i, intW intw, double ad[], int j, int k, doubleW doublew, doubleW doublew1, doubleW doublew2, 
            doubleW doublew3, intW intw1, intW intw2, intW intw3, boolean flag, intW intw4, doubleW doublew4, 
            doubleW doublew5, doubleW doublew6, doubleW doublew7, doubleW doublew8, doubleW doublew9)
    {
        int j1 = 0;
        double d = 0.0;
        doubleW doublew10 = new doubleW(0.0);
        double d4 = 0.0;
        double d5 = 0.0;
        double d8 = 0.0;
        double d9 = 0.0;
        j1 = intw.val;
        d = Dlamch.dlamch("Precision");
        d4 = Dlamch.dlamch("Safe minimum");
        d8 = d * 100.0;
        d9 = Math.pow(d8, 2.0);
        doublew10.val = 0.0;
label0:
        do
        {
            int k1;
label1:
            {
label2:
                {
                    if(intw.val < i)
                        return;
                    if(intw.val != i)
                    {
                        k1 = 4 * intw.val + k;
                        if(intw.val == i + 1)
                            break label1;
                        if((ad[(k1 - 5 - 1) + j] > d9 * (doublew1.val + ad[(k1 - 3 - 1) + j])) && (ad[(k1 - 2 * k - 4 - 1) + j] > d9 * ad[(k1 - 7 - 1) + j]))
                            break label2;
                    }
                    ad[(4 * intw.val - 3 - 1) + j] = ad[((4 * intw.val + k) - 3 - 1) + j] + doublew1.val;
                    intw.val = intw.val - 1;
                    continue;
                }
                if((ad[(k1 - 9 - 1) + j] > d9 * doublew1.val) && (ad[(k1 - 2 * k - 8 - 1) + j] > d9 * ad[(k1 - 11 - 1) + j]))
                    break label0;
            }
            if(ad[(k1 - 3 - 1) + j] > ad[(k1 - 7 - 1) + j])
            {
                double d2 = ad[(k1 - 3 - 1) + j];
                ad[(k1 - 3 - 1) + j] = ad[(k1 - 7 - 1) + j];
                ad[(k1 - 7 - 1) + j] = d2;
            }
            if(ad[(k1 - 5 - 1) + j] > ad[(k1 - 3 - 1) + j] * d9)
            {
                d5 = 0.5 * ((ad[(k1 - 7 - 1) + j] - ad[(k1 - 3 - 1) + j]) + ad[(k1 - 5 - 1) + j]);
                double d3 = ad[(k1 - 3 - 1) + j] * (ad[(k1 - 5 - 1) + j] / d5);
                if(d3 <= d5)
                    d3 = ad[(k1 - 3 - 1) + j] * (ad[(k1 - 5 - 1) + j] / (d5 * (1.0 + Math.sqrt(1.0 + d3 / d5))));
                else
                    d3 = ad[(k1 - 3 - 1) + j] * (ad[(k1 - 5 - 1) + j] / (d5 + Math.sqrt(d5) * Math.sqrt(d5 + d3)));
                d5 = ad[(k1 - 7 - 1) + j] + (d3 + ad[(k1 - 5 - 1) + j]);
                ad[(k1 - 3 - 1) + j] = ad[(k1 - 3 - 1) + j] * (ad[(k1 - 7 - 1) + j] / d5);
                ad[(k1 - 7 - 1) + j] = d5;
            }
            ad[(4 * intw.val - 7 - 1) + j] = ad[(k1 - 7 - 1) + j] + doublew1.val;
            ad[(4 * intw.val - 3 - 1) + j] = ad[(k1 - 3 - 1) + j] + doublew1.val;
            intw.val = intw.val - 2;
        } while(true);
label3:
        {
            if(((doublew.val <= 0.0) || (intw.val < j1)) && (1.5 * ad[((4 * i + k) - 3 - 1) + j] < ad[((4 * intw.val + k) - 3 - 1) + j]))
            {
                int l = 4 * (i + intw.val);
                int i1 = 4 * i;
                for(int l1 = ((2 * ((i + intw.val) - 1) - 4 * i) + 4) / 4; l1 > 0; l1--)
                {
                    double d7 = ad[(i1 - 3 - 1) + j];
                    ad[(i1 - 3 - 1) + j] = ad[(l - i1 - 3 - 1) + j];
                    ad[(l - i1 - 3 - 1) + j] = d7;
                    d7 = ad[(i1 - 2 - 1) + j];
                    ad[(i1 - 2 - 1) + j] = ad[(l - i1 - 2 - 1) + j];
                    ad[(l - i1 - 2 - 1) + j] = d7;
                    d7 = ad[(i1 - 1 - 1) + j];
                    ad[(i1 - 1 - 1) + j] = ad[(l - i1 - 5 - 1) + j];
                    ad[(l - i1 - 5 - 1) + j] = d7;
                    d7 = ad[(i1 - 1) + j];
                    ad[(i1 - 1) + j] = ad[(l - i1 - 4 - 1) + j];
                    ad[(l - i1 - 4 - 1) + j] = d7;
                    i1 += 4;
                }

                if(intw.val - i <= 4)
                {
                    ad[((4 * intw.val + k) - 1 - 1) + j] = ad[((4 * i + k) - 1 - 1) + j];
                    ad[(4 * intw.val - k - 1) + j] = ad[(4 * i - k - 1) + j];
                }
                doublew5.val = Math.min(doublew5.val, ad[((4 * intw.val + k) - 1 - 1) + j]);
                ad[((4 * intw.val + k) - 1 - 1) + j] = Util.min(ad[((4 * intw.val + k) - 1 - 1) + j], ad[((4 * i + k) - 1 - 1) + j], ad[((4 * i + k + 3) - 1) + j]);
                ad[(4 * intw.val - k - 1) + j] = Util.min(ad[(4 * intw.val - k - 1) + j], ad[(4 * i - k - 1) + j], ad[(((4 * i - k) + 4) - 1) + j]);
                doublew3.val = Util.max(doublew3.val, ad[((4 * i + k) - 3 - 1) + j], ad[((4 * i + k + 1) - 1) + j]);
                doublew.val = 0.0;
            }
            if((doublew.val < 0.0) || (d4 * doublew3.val < Util.min(ad[((4 * intw.val + k) - 1 - 1) + j], ad[((4 * intw.val + k) - 9 - 1) + j], doublew5.val + ad[(4 * intw.val - k - 1) + j])))
            {
                Dlazq4.dlazq4(i, intw.val, ad, j, k, j1, doublew.val, doublew4.val, doublew5.val, doublew6.val, doublew7.val, doublew8.val, doublew9, intw4, doublew10);
                do
                {
                    Dlasq5.dlasq5(i, intw.val, ad, j, k, doublew9.val, doublew, doublew4, doublew5, doublew6, doublew7, doublew8, flag);
                    intw3.val = intw3.val + ((intw.val - i) + 2);
                    intw2.val = intw2.val + 1;
                    if((doublew.val >= 0.0) && (doublew4.val > 0.0))
                        break label3;
                    if((((doublew.val < 0.0) && (doublew4.val > 0.0)) && (ad[(4 * (intw.val - 1) - k - 1) + j] < d8 * (doublew1.val + doublew7.val))) && (Math.abs(doublew6.val) < d8 * doublew1.val))
                    {
                        ad[(((4 * (intw.val - 1) - k) + 2) - 1) + j] = 0.0;
                        doublew.val = 0.0;
                        break label3;
                    }
                    if(doublew.val < 0.0)
                    {
                        intw1.val = intw1.val + 1;
                        if(intw4.val < -22)
                            doublew9.val = 0.0;
                        else
                        if(doublew4.val > 0.0)
                        {
                            doublew9.val = (doublew9.val + doublew.val) * (1.0 - 2.0 * d);
                            intw4.val = intw4.val - 11;
                        } else
                        {
                            doublew9.val = 0.25 * doublew9.val;
                            intw4.val = intw4.val - 12;
                        }
                        continue;
                    }
                    if(doublew.val == doublew.val)
                        break;
                    doublew9.val = 0.0;
                } while(true);
            }
            Dlasq6.dlasq6(i, intw.val, ad, j, k, doublew, doublew4, doublew5, doublew6, doublew7, doublew8);
            intw3.val = intw3.val + ((intw.val - i) + 2);
            intw2.val = intw2.val + 1;
            doublew9.val = 0.0;
        }
        if(doublew9.val < doublew1.val)
        {
            doublew2.val = doublew2.val + doublew9.val;
            d5 = doublew1.val + doublew2.val;
            doublew2.val = doublew2.val - (d5 - doublew1.val);
        } else
        {
            d5 = doublew1.val + doublew9.val;
            doublew2.val = (doublew1.val - (d5 - doublew9.val)) + doublew2.val;
        }
        doublew1.val = d5;
    }
}

package org.netlib.lapack;

import org.netlib.blas.Dswap;
import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlasdq
{
    public static void dlasdq(String s, int i, int j, int k, int l, int i1, double ad[], int j1, 
            double ad1[], int k1, double ad2[], int l1, int i2, double ad3[], int j2, 
            int k2, double ad4[], int l2, int i3, double ad5[], int j3, intW intw)
    {
        boolean flag = false;
        int k3 = 0;
        byte byte0 = 0;
        int j4 = 0;
        int k4 = 0;
        doubleW doublew = new doubleW(0.0);
        doubleW doublew1 = new doubleW(0.0);
        doubleW doublew2 = new doubleW(0.0);
        intw.val = 0;
        byte0 = 0;
        if(Lsame.lsame(s, "U"))
            byte0 = 1;
        if(Lsame.lsame(s, "L"))
            byte0 = 2;
        if(byte0 == 0)
            intw.val = -1;
        else
        if((i < 0) || (i > 1))
            intw.val = -2;
        else
        if(j < 0)
            intw.val = -3;
        else
        if(k < 0)
            intw.val = -4;
        else
        if(l < 0)
            intw.val = -5;
        else
        if(i1 < 0)
            intw.val = -6;
        else
        if(((k == 0) && (i2 < 1)) || ((k > 0) && (i2 < Math.max(1, j))))
            intw.val = -10;
        else
        if(k2 < Math.max(1, l))
            intw.val = -12;
        else
        if(((i1 == 0) && (i3 < 1)) || ((i1 > 0) && (i3 < Math.max(1, j))))
            intw.val = -14;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DLASDQ", -intw.val);
            return;
        }
        if(j == 0)
            return;
        flag = ((k > 0) || (l > 0)) || (i1 > 0);
        j4 = j + 1;
        k4 = i;
        if((byte0 == 1) && (k4 == 1))
        {
            k3 = 1;
            for(int l4 = j - 1; l4 > 0; l4--)
            {
                Dlartg.dlartg(ad[(k3 - 1) + j1], ad1[(k3 - 1) + k1], doublew, doublew2, doublew1);
                ad[(k3 - 1) + j1] = doublew1.val;
                ad1[(k3 - 1) + k1] = doublew2.val * ad[((k3 + 1) - 1) + j1];
                ad[((k3 + 1) - 1) + j1] = doublew.val * ad[((k3 + 1) - 1) + j1];
                if(flag)
                {
                    ad5[(k3 - 1) + j3] = doublew.val;
                    ad5[((j + k3) - 1) + j3] = doublew2.val;
                }
                k3++;
            }

            Dlartg.dlartg(ad[(j - 1) + j1], ad1[(j - 1) + k1], doublew, doublew2, doublew1);
            ad[(j - 1) + j1] = doublew1.val;
            ad1[(j - 1) + k1] = 0.0;
            if(flag)
            {
                ad5[(j - 1) + j3] = doublew.val;
                ad5[((j + j) - 1) + j3] = doublew2.val;
            }
            byte0 = 2;
            k4 = 0;
            if (k > 0)
                Dlasr.dlasr("L", "V", "F", j4, k, ad5, j3, ad5, (j4 - 1) + j3, ad2, l1, i2);
        }
        if (byte0 == 2)
        {
            k3 = 1;
            for(int i5 = j - 1; i5 > 0; i5--)
            {
                Dlartg.dlartg(ad[(k3 - 1) + j1], ad1[(k3 - 1) + k1], doublew, doublew2, doublew1);
                ad[(k3 - 1) + j1] = doublew1.val;
                ad1[(k3 - 1) + k1] = doublew2.val * ad[((k3 + 1) - 1) + j1];
                ad[((k3 + 1) - 1) + j1] = doublew.val * ad[((k3 + 1) - 1) + j1];
                if (flag)
                {
                    ad5[(k3 - 1) + j3] = doublew.val;
                    ad5[((j + k3) - 1) + j3] = doublew2.val;
                }
                k3++;
            }

            if (k4 == 1)
            {
                Dlartg.dlartg(ad[(j - 1) + j1], ad1[(j - 1) + k1], doublew, doublew2, doublew1);
                ad[(j - 1) + j1] = doublew1.val;
                if(flag)
                {
                    ad5[(j - 1) + j3] = doublew.val;
                    ad5[((j + j) - 1) + j3] = doublew2.val;
                }
            }
            if (l > 0)
                if (k4 == 0)
                    Dlasr.dlasr("R", "V", "F", l, j, ad5, j3, ad5, (j4 - 1) + j3, ad3, j2, k2);
                else
                    Dlasr.dlasr("R", "V", "F", l, j4, ad5, j3, ad5, (j4 - 1) + j3, ad3, j2, k2);
            if (i1 > 0)
                if (k4 == 0)
                    Dlasr.dlasr("L", "V", "F", j, i1, ad5, j3, ad5, (j4 - 1) + j3, ad4, l2, i3);
                else
                    Dlasr.dlasr("L", "V", "F", j4, i1, ad5, j3, ad5, (j4 - 1) + j3, ad4, l2, i3);
        }
        Dbdsqr.dbdsqr("U", j, k, l, i1, ad, j1, ad1, k1, ad2, l1, i2, ad3, j2, k2, ad4, l2, i3, ad5, j3, intw);
        k3 = 1;
        for (int j5 = (j - 1) + 1; j5 > 0; j5--)
        {
            int l3 = k3;
            double d1 = ad[(k3 - 1) + j1];
            int i4 = k3 + 1;
            for (int k5 = (j - (k3 + 1)) + 1; k5 > 0; k5--)
            {
                if (ad[(i4 - 1) + j1] < d1)
                {
                    l3 = i4;
                    d1 = ad[(i4 - 1) + j1];
                }
                i4++;
            }

            if(l3 != k3)
            {
                ad[(l3 - 1) + j1] = ad[(k3 - 1) + j1];
                ad[(k3 - 1) + j1] = d1;
                if(k > 0)
                    Dswap.dswap(k, ad2, (l3 - 1) + l1, i2, ad2, (k3 - 1) + l1, i2);
                if(l > 0)
                    Dswap.dswap(l, ad3, (l3 - 1) * k2 + j2, 1, ad3, (k3 - 1) * k2 + j2, 1);
                if(i1 > 0)
                    Dswap.dswap(i1, ad4, (l3 - 1) + l2, i3, ad4, (k3 - 1) + l2, i3);
            }
            k3++;
        }

    }
}


package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.*;

public final class Dlasd8
{
    public static void dlasd8(int i, int j, double ad[], int k, double ad1[], int l, double ad2[], int i1, 
            double ad3[], int j1, double ad4[], int k1, double ad5[], int l1, int i2, 
            double ad6[], int j2, double ad7[], int k2, intW intw)
    {
        int l2 = 0;
        int j3 = 0;
        int k3 = 0;
        int l3 = 0;
        int i4 = 0;
        int j4 = 0;
        int k4 = 0;
        double d2 = 0.0;
        double d7 = 0.0;
        double d8 = 0.0;
        intw.val = 0;
        if((i < 0) || (i > 1))
            intw.val = -1;
        else
        if(j < 1)
            intw.val = -2;
        else
        if(i2 < j)
            intw.val = -9;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DLASD8", -intw.val);
            return;
        }
        if(j == 1)
        {
            ad[k] = Math.abs(ad1[l]);
            ad4[k1] = ad[k];
            if(i == 1)
            {
                ad4[1 + k1] = 1.0;
                ad5[i2 + l1] = 1.0;
            }
            return;
        }
        l2 = 1;
        for(int l4 = j; l4 > 0; l4--)
        {
            ad6[(l2 - 1) + j2] = Dlamc3.dlamc3(ad6[(l2 - 1) + j2], ad6[(l2 - 1) + j2]) - ad6[(l2 - 1) + j2];
            l2++;
        }

        j3 = 1;
        k3 = j3 + j;
        i4 = k3 + j;
        l3 = k3 - 1;
        j4 = i4 - 1;
        d8 = Dnrm2.dnrm2(j, ad1, l, 1);
        Dlascl.dlascl("G", 0, 0, d8, 1.0, j, 1, ad1, l, j, intw);
        d8 *= d8;
        Dlaset.dlaset("A", j, 1, 1.0, 1.0, ad7, (i4 - 1) + k2, j);
        k4 = 1;
        for(int i5 = j; i5 > 0; i5--)
        {
            dlasd4_adapter(j, k4, ad6, j2, ad1, l, ad7, (j3 - 1) + k2, d8, ad, (k4 - 1) + k, ad7, (k3 - 1) + k2, intw);
            if(intw.val != 0)
                return;
            ad7[((j4 + k4) - 1) + k2] = ad7[((j4 + k4) - 1) + k2] * ad7[(k4 - 1) + k2] * ad7[((l3 + k4) - 1) + k2];
            ad4[(k4 - 1) + k1] = -ad7[(k4 - 1) + k2];
            ad5[(k4 - 1) + l1] = -ad7[((k4 + 1) - 1) + k2];
            l2 = 1;
            for(int l5 = k4 - 1; l5 > 0; l5--)
            {
                ad7[((j4 + l2) - 1) + k2] = (ad7[((j4 + l2) - 1) + k2] * ad7[(l2 - 1) + k2] * ad7[((l3 + l2) - 1) + k2]) / (ad6[(l2 - 1) + j2] - ad6[(k4 - 1) + j2]) / (ad6[(l2 - 1) + j2] + ad6[(k4 - 1) + j2]);
                l2++;
            }

            l2 = k4 + 1;
            for(int i6 = (j - (k4 + 1)) + 1; i6 > 0; i6--)
            {
                ad7[((j4 + l2) - 1) + k2] = (ad7[((j4 + l2) - 1) + k2] * ad7[(l2 - 1) + k2] * ad7[((l3 + l2) - 1) + k2]) / (ad6[(l2 - 1) + j2] - ad6[(k4 - 1) + j2]) / (ad6[(l2 - 1) + j2] + ad6[(k4 - 1) + j2]);
                l2++;
            }

            k4++;
        }

        l2 = 1;
        for(int j5 = j; j5 > 0; j5--)
        {
            ad1[(l2 - 1) + l] = Util.dsign(Math.sqrt(Math.abs(ad7[((j4 + l2) - 1) + k2])), ad1[(l2 - 1) + l]);
            l2++;
        }

        k4 = 1;
        for(int k5 = j; k5 > 0; k5--)
        {
            double d1 = ad4[(k4 - 1) + k1];
            double d4 = ad[(k4 - 1) + k];
            double d6 = -ad6[(k4 - 1) + j2];
            if(k4 < j)
            {
                d2 = -ad5[(k4 - 1) + l1];
                d7 = -ad6[((k4 + 1) - 1) + j2];
            }
            ad7[(k4 - 1) + k2] = -(ad1[(k4 - 1) + l] / d1 / (ad6[(k4 - 1) + j2] + d4));
            int i3 = 1;
            for(int j6 = k4 - 1; j6 > 0; j6--)
            {
                ad7[(i3 - 1) + k2] = ad1[(i3 - 1) + l] / (Dlamc3.dlamc3(ad6[(i3 - 1) + j2], d6) - d1) / (ad6[(i3 - 1) + j2] + d4);
                i3++;
            }

            i3 = k4 + 1;
            for(int k6 = (j - (k4 + 1)) + 1; k6 > 0; k6--)
            {
                ad7[(i3 - 1) + k2] = ad1[(i3 - 1) + l] / (Dlamc3.dlamc3(ad6[(i3 - 1) + j2], d7) + d2) / (ad6[(i3 - 1) + j2] + d4);
                i3++;
            }

            double d10 = Dnrm2.dnrm2(j, ad7, k2, 1);
            ad7[((l3 + k4) - 1) + k2] = Ddot.ddot(j, ad7, k2, 1, ad2, i1, 1) / d10;
            ad7[((j4 + k4) - 1) + k2] = Ddot.ddot(j, ad7, k2, 1, ad3, j1, 1) / d10;
            if(i == 1)
                ad5[(k4 - 1) + (2 - 1) * i2 + l1] = d10;
            k4++;
        }

        Dcopy.dcopy(j, ad7, (k3 - 1) + k2, 1, ad2, i1, 1);
        Dcopy.dcopy(j, ad7, (i4 - 1) + k2, 1, ad3, j1, 1);
    }

    private static void dlasd4_adapter(int i, int j, double ad[], int k, double ad1[], int l, double ad2[], int i1, 
            double d, double ad3[], int j1, double ad4[], int k1, intW intw)
    {
        doubleW doublew = new doubleW(ad3[j1]);
        Dlasd4.dlasd4(i, j, ad, k, ad1, l, ad2, i1, d, doublew, ad4, k1, intw);
        ad3[j1] = doublew.val;
    }
}

package org.netlib.lapack;

import org.netlib.blas.Dcopy;
import org.netlib.blas.Dswap;
import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.*;

public final class Dbdsdc
{
    public static void dbdsdc(String s, String s1, int i, double ad[], int j, double ad1[], int k, double ad2[], 
            int l, int i1, double ad3[], int j1, int k1, double ad4[], int l1, 
            int ai[], int i2, double ad5[], int j2, int ai1[], int k2, intW intw)
    {
        int l2 = 0;
        int i3 = 0;
        int j3 = 0;
        int k3 = 0;
        byte byte0 = 0;
        int k4 = 0;
        byte byte1 = 0;
        intW intw1 = new intW(0);
        int l4 = 0;
        int i5 = 0;
        int j5 = 0;
        byte byte2 = 0;
        int k5 = 0;
        int i6 = 0;
        int l6 = 0;
        byte byte3 = 0;
        int j7 = 0;
        byte byte4 = 0;
        int k7 = 0;
        int k8 = 0;
        int l8 = 0;
        doubleW doublew = new doubleW(0.0);
        doubleW doublew1 = new doubleW(0.0);
        doubleW doublew2 = new doubleW(0.0);
        intw.val = 0;
        byte2 = 0;
        if(Lsame.lsame(s, "U"))
            byte2 = 1;
        if(Lsame.lsame(s, "L"))
            byte2 = 2;
        if(Lsame.lsame(s1, "N"))
            byte1 = 0;
        else
        if(Lsame.lsame(s1, "P"))
            byte1 = 1;
        else
        if(Lsame.lsame(s1, "I"))
            byte1 = 2;
        else
            byte1 = -1;
        if(byte2 == 0)
            intw.val = -1;
        else
        if(byte1 < 0)
            intw.val = -2;
        else
        if(i < 0)
            intw.val = -3;
        else
        if((i1 < 1) || ((byte1 == 2) && (i1 < i)))
            intw.val = -7;
        else
        if((k1 < 1) || ((byte1 == 2) && (k1 < i)))
            intw.val = -9;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DBDSDC", -intw.val);
            return;
        }
        if(i == 0)
            return;
        k7 = Ilaenv.ilaenv(9, "DBDSDC", " ", 0, 0, 0, 0);
        if(i == 1)
        {
            if(byte1 == 1)
            {
                ad4[l1] = Util.dsign(1.0, ad[j]);
                ad4[((1 + k7 * i) - 1) + l1] = 1.0;
            } else
            if(byte1 == 2)
            {
                ad2[l] = Util.dsign(1.0, ad[j]);
                ad3[j1] = 1.0;
            }
            ad[j] = Math.abs(ad[j]);
            return;
        }
        l6 = i - 1;
        k8 = 1;
        byte4 = 3;
        if(byte1 == 1)
        {
            Dcopy.dcopy(i, ad, j, 1, ad4, (1 - 1) + l1, 1);
            Dcopy.dcopy(i - 1, ad1, k, 1, ad4, ((i + 1) - 1) + l1, 1);
        }
        if(byte2 == 2)
        {
            byte4 = 5;
            k8 = 2 * i - 1;
            int l3 = 1;
            for (int i9 = i - 1; i9 > 0; i9--)
            {
                Dlartg.dlartg(ad[(l3 - 1) + j], ad1[(l3 - 1) + k], doublew, doublew2, doublew1);
                ad[(l3 - 1) + j] = doublew1.val;
                ad1[(l3 - 1) + k] = doublew2.val * ad[((l3 + 1) - 1) + j];
                ad[((l3 + 1) - 1) + j] = doublew.val * ad[((l3 + 1) - 1) + j];
                if(byte1 == 1)
                {
                    ad4[((l3 + 2 * i) - 1) + l1] = doublew.val;
                    ad4[((l3 + 3 * i) - 1) + l1] = doublew2.val;
                } else
                if(byte1 == 2)
                {
                    ad5[(l3 - 1) + j2] = doublew.val;
                    ad5[((l6 + l3) - 1) + j2] = -doublew2.val;
                }
                l3++;
            }

        }
        if(byte1 == 0)
            Dlasdq.dlasdq("U", 0, i, 0, 0, 0, ad, j, ad1, k, ad3, j1, k1, ad2, l, i1, ad2, l, i1, ad5, (k8 - 1) + j2, intw);
        else
        if(i <= k7)
        {
            if(byte1 == 2)
            {
                Dlaset.dlaset("A", i, i, 0.0D, 1.0D, ad2, l, i1);
                Dlaset.dlaset("A", i, i, 0.0D, 1.0D, ad3, j1, k1);
                Dlasdq.dlasdq("U", 0, i, i, i, 0, ad, j, ad1, k, ad3, j1, k1, ad2, l, i1, ad2, l, i1, ad5, (k8 - 1) + j2, intw);
            } else
            if(byte1 == 1)
            {
                j5 = 1;
                k5 = j5 + i;
                Dlaset.dlaset("A", i, i, 0.0D, 1.0D, ad4, ((j5 + (byte4 - 1) * i) - 1) + l1, i);
                Dlaset.dlaset("A", i, i, 0.0D, 1.0D, ad4, ((k5 + (byte4 - 1) * i) - 1) + l1, i);
                Dlasdq.dlasdq("U", 0, i, i, i, 0, ad, j, ad1, k, ad4, ((k5 + (byte4 - 1) * i) - 1) + l1, i, ad4, ((j5 + (byte4 - 1) * i) - 1) + l1, i, ad4, ((j5 + (byte4 - 1) * i) - 1) + l1, i, ad5, (k8 - 1) + j2, intw);
            }
        } else
        {
            if(byte1 == 2)
            {
                Dlaset.dlaset("A", i, i, 0.0D, 1.0D, ad2, l, i1);
                Dlaset.dlaset("A", i, i, 0.0D, 1.0D, ad3, j1, k1);
            }
            double d3 = Dlanst.dlanst("M", i, ad, j, ad1, k);
            if(d3 == 0.0D)
                return;
            Dlascl.dlascl("G", 0, 0, d3, 1.0D, i, 1, ad, j, i, intw1);
            Dlascl.dlascl("G", 0, 0, d3, 1.0D, l6, 1, ad1, k, l6, intw1);
            double d1 = Dlamch.dlamch("Epsilon");
            int k6 = (int)(Math.log((double)i / (double)(k7 + 1)) / Math.log(2D)) + 1;
            int l7 = k7 + 1;
            if(byte1 == 1)
            {
                j5 = 1;
                k5 = 1 + k7;
                l2 = k5 + l7;
                i3 = l2 + k6;
                l8 = i3 + k6 * 2;
                k4 = l8 + k6;
                i5 = k4 + 1;
                j7 = i5 + 1;
                k3 = j7 + 2 * k6;
                i6 = 1;
                byte0 = 2;
                byte3 = 3;
                j3 = byte3 + k6;
            }
            int i4 = 1;
            for(int j9 = (i - 1) + 1; j9 > 0; j9--)
            {
                if(Math.abs(ad[(i4 - 1) + j]) < d1)
                    ad[(i4 - 1) + j] = Util.dsign(d1, ad[(i4 - 1) + j]);
                i4++;
            }

            int j8 = 1;
            int i8 = 0;
            i4 = 1;
            for(int k9 = (l6 - 1) + 1; k9 > 0; k9--)
            {
                if((Math.abs(ad1[(i4 - 1) + k]) < d1) || (i4 == l6))
                {
                    int i7;
                    if(i4 < l6)
                        i7 = (i4 - j8) + 1;
                    else
                    if(Math.abs(ad1[(i4 - 1) + k]) >= d1)
                    {
                        i7 = (i - j8) + 1;
                    } else
                    {
                        i7 = (i4 - j8) + 1;
                        if(byte1 == 2)
                        {
                            ad2[(i - 1) + (i - 1) * i1 + l] = Util.dsign(1.0D, ad[(i - 1) + j]);
                            ad3[(i - 1) + (i - 1) * k1 + j1] = 1.0D;
                        } else
                        if(byte1 == 1)
                        {
                            ad4[((i + (byte4 - 1) * i) - 1) + l1] = Util.dsign(1.0D, ad[(i - 1) + j]);
                            ad4[((i + ((k7 + byte4) - 1) * i) - 1) + l1] = 1.0D;
                        }
                        ad[(i - 1) + j] = Math.abs(ad[(i - 1) + j]);
                    }
                    if(byte1 == 2)
                    {
                        Dlasd0.dlasd0(i7, i8, ad, (j8 - 1) + j, ad1, (j8 - 1) + k, ad2, (j8 - 1) + (j8 - 1) * i1 + l, i1, ad3, (j8 - 1) + (j8 - 1) * k1 + j1, k1, k7, ai1, k2, ad5, (k8 - 1) + j2, intw);
                    } else
                    {
                        Dlasda.dlasda(byte1, k7, i7, i8, ad, (j8 - 1) + j, ad1, (j8 - 1) + k, ad4, ((j8 + ((j5 + byte4) - 2) * i) - 1) + l1, i, ad4, ((j8 + ((k5 + byte4) - 2) * i) - 1) + l1, ai, ((j8 + i6 * i) - 1) + i2, ad4, ((j8 + ((l2 + byte4) - 2) * i) - 1) + l1, ad4, ((j8 + ((i3 + byte4) - 2) * i) - 1) + l1, ad4, ((j8 + ((l8 + byte4) - 2) * i) - 1) + l1, ad4, ((j8 + ((j7 + byte4) - 2) * i) - 1) + l1, ai, ((j8 + byte0 * i) - 1) + i2, ai, ((j8 + j3 * i) - 1) + i2, i, ai, ((j8 + byte3 * i) - 1) + i2, ad4, ((j8 + ((k3 + byte4) - 2) * i) - 1) + l1, ad4, ((j8 + ((k4 + byte4) - 2) * i) - 1) + l1, ad4, ((j8 + ((i5 + byte4) - 2) * i) - 1) + l1, ad5, (k8 - 1) + j2, ai1, k2, intw);
                        if(intw.val != 0)
                            return;
                    }
                    j8 = i4 + 1;
                }
                i4++;
            }

            Dlascl.dlascl("G", 0, 0, 1.0D, d3, i, 1, ad, j, i, intw1);
        }
        l4 = 2;
        for(int l9 = (i - 2) + 1; l9 > 0; l9--)
        {
            int j4 = l4 - 1;
            int j6 = j4;
            double d5 = ad[(j4 - 1) + j];
            int l5 = l4;
            for(int i10 = (i - l4) + 1; i10 > 0; i10--)
            {
                if(ad[(l5 - 1) + j] > d5)
                {
                    j6 = l5;
                    d5 = ad[(l5 - 1) + j];
                }
                l5++;
            }

            if(j6 != j4)
            {
                ad[(j6 - 1) + j] = ad[(j4 - 1) + j];
                ad[(j4 - 1) + j] = d5;
                if(byte1 == 1)
                    ai[(j4 - 1) + i2] = j6;
                else
                if(byte1 == 2)
                {
                    Dswap.dswap(i, ad2, (j4 - 1) * i1 + l, 1, ad2, (j6 - 1) * i1 + l, 1);
                    Dswap.dswap(i, ad3, (j4 - 1) + j1, k1, ad3, (j6 - 1) + j1, k1);
                }
            } else
            if(byte1 == 1)
                ai[(j4 - 1) + i2] = j4;
            l4++;
        }

        if(byte1 == 1)
            if(byte2 == 1)
                ai[(i - 1) + i2] = 1;
            else
                ai[(i - 1) + i2] = 0;
        if((byte2 == 2) && (byte1 == 2))
            Dlasr.dlasr("L", "V", "B", i, i, ad5, j2, ad5, (i - 1) + j2, ad2, l, i1);
    }
}

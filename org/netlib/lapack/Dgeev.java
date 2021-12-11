package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.*;

public final class Dgeev
{
    public static void dgeev(String s, String s1, int i, double ad[], int j, int k, double ad1[], int l, 
            double ad2[], int i1, double ad3[], int j1, int k1, double ad4[], int l1, 
            int i2, double ad5[], int j2, int k2, intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        String s2 = new String(" ");
        int i4 = 0;
        intW intw1 = new intW(0);
        intW intw2 = new intW(0);
        intW intw3 = new intW(0);
        int j4 = 0;
        int k4 = 0;
        int j5 = 0;
        intW intw4 = new intW(0);
        double d = 0.0D;
        doubleW doublew = new doubleW(0.0D);
        doubleW doublew1 = new doubleW(0.0D);
        double d1 = 0.0D;
        double d2 = 0.0D;
        doubleW doublew2 = new doubleW(0.0D);
        doubleW doublew3 = new doubleW(0.0D);
        doubleW doublew4 = new doubleW(0.0D);
        boolean aflag[] = new boolean[1];
        double ad6[] = new double[1];
        intw.val = 0;
        flag = k2 == -1;
        flag2 = Lsame.lsame(s, "V");
        flag3 = Lsame.lsame(s1, "V");
        if(flag2 ^ true && Lsame.lsame(s, "N") ^ true)
            intw.val = -1;
        else
        if(flag3 ^ true && Lsame.lsame(s1, "N") ^ true)
            intw.val = -2;
        else
        if(i < 0)
            intw.val = -3;
        else
        if(k < Math.max(1, i))
            intw.val = -5;
        else
        if((k1 < 1) || (flag2 && (k1 < i)))
            intw.val = -9;
        else
        if((i2 < 1) || (flag3 && (i2 < i)))
            intw.val = -11;
        if(intw.val == 0)
        {
            int k5;
            if(i == 0)
            {
                k5 = 1;
                j5 = 1;
            } else
            {
                j5 = 2 * i + i * Ilaenv.ilaenv(1, "DGEHRD", " ", i, 1, i, 0);
                if(flag2)
                {
                    k5 = 4 * i;
                    j5 = Math.max(j5, 2 * i + (i - 1) * Ilaenv.ilaenv(1, "DORGHR", " ", i, 1, i, -1));
                    Dhseqr.dhseqr("S", "V", i, 1, i, ad, j, k, ad1, l, ad2, i1, ad3, j1, k1, ad5, j2, -1, intw);
                    int l2 = (int)ad5[(1 - 1) + j2];
                    j5 = Util.max(j5, i + 1, i + l2);
                    j5 = Math.max(j5, 4 * i);
                } else
                if(flag3)
                {
                    k5 = 4 * i;
                    j5 = Math.max(j5, 2 * i + (i - 1) * Ilaenv.ilaenv(1, "DORGHR", " ", i, 1, i, -1));
                    Dhseqr.dhseqr("S", "V", i, 1, i, ad, j, k, ad1, l, ad2, i1, ad4, l1, i2, ad5, j2, -1, intw);
                    int i3 = (int)ad5[(1 - 1) + j2];
                    j5 = Util.max(j5, i + 1, i + i3);
                    j5 = Math.max(j5, 4 * i);
                } else
                {
                    k5 = 3 * i;
                    Dhseqr.dhseqr("E", "N", i, 1, i, ad, j, k, ad1, l, ad2, i1, ad4, l1, i2, ad5, j2, -1, intw);
                    int j3 = (int)ad5[(1 - 1) + j2];
                    j5 = Util.max(j5, i + 1, i + j3);
                }
                j5 = Math.max(j5, k5);
            }
            ad5[(1 - 1) + j2] = j5;
            if((k2 < k5) && flag ^ true)
                intw.val = -13;
        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DGEEV ", -intw.val);
            return;
        }
        if(flag)
            return;
        if(i == 0)
            return;
        d2 = Dlamch.dlamch("P");
        doublew3.val = Dlamch.dlamch("S");
        doublew.val = 1.0D / doublew3.val;
        Dlabad.dlabad(doublew3, doublew);
        doublew3.val = Math.sqrt(doublew3.val) / d2;
        doublew.val = 1.0D / doublew3.val;
        d = Dlange.dlange("M", i, i, ad, j, k, ad6, 0);
        flag1 = false;
        if((d > 0.0D) && (d < doublew3.val))
        {
            flag1 = true;
            d1 = doublew3.val;
        } else
        if(d > doublew.val)
        {
            flag1 = true;
            d1 = doublew.val;
        }
        if(flag1)
            Dlascl.dlascl("G", 0, 0, d, d1, i, i, ad, j, k, intw1);
        i4 = 1;
        Dgebal.dgebal("B", i, ad, j, k, intw3, intw2, ad5, (i4 - 1) + j2, intw1);
        j4 = i4 + i;
        k4 = j4 + i;
        Dgehrd.dgehrd(i, intw3.val, intw2.val, ad, j, k, ad5, (j4 - 1) + j2, ad5, (k4 - 1) + j2, (k2 - k4) + 1, intw1);
        if(flag2)
        {
            s2 = "L";
            Dlacpy.dlacpy("L", i, i, ad, j, k, ad3, j1, k1);
            Dorghr.dorghr(i, intw3.val, intw2.val, ad3, j1, k1, ad5, (j4 - 1) + j2, ad5, (k4 - 1) + j2, (k2 - k4) + 1, intw1);
            k4 = j4;
            Dhseqr.dhseqr("S", "V", i, intw3.val, intw2.val, ad, j, k, ad1, l, ad2, i1, ad3, j1, k1, ad5, (k4 - 1) + j2, (k2 - k4) + 1, intw);
            if(flag3)
            {
                s2 = "B";
                Dlacpy.dlacpy("F", i, i, ad3, j1, k1, ad4, l1, i2);
            }
        } else
        if(flag3)
        {
            s2 = "R";
            Dlacpy.dlacpy("L", i, i, ad, j, k, ad4, l1, i2);
            Dorghr.dorghr(i, intw3.val, intw2.val, ad4, l1, i2, ad5, (j4 - 1) + j2, ad5, (k4 - 1) + j2, (k2 - k4) + 1, intw1);
            k4 = j4;
            Dhseqr.dhseqr("S", "V", i, intw3.val, intw2.val, ad, j, k, ad1, l, ad2, i1, ad4, l1, i2, ad5, (k4 - 1) + j2, (k2 - k4) + 1, intw);
        } else
        {
            k4 = j4;
            Dhseqr.dhseqr("E", "N", i, intw3.val, intw2.val, ad, j, k, ad1, l, ad2, i1, ad4, l1, i2, ad5, (k4 - 1) + j2, (k2 - k4) + 1, intw);
        }
        if(intw.val <= 0)
        {
            if(flag2 || flag3)
                Dtrevc.dtrevc(s2, "B", aflag, 0, i, ad, j, k, ad3, j1, k1, ad4, l1, i2, i, intw4, ad5, (k4 - 1) + j2, intw1);
            if(flag2)
            {
                Dgebak.dgebak("B", "L", i, intw3.val, intw2.val, ad5, (i4 - 1) + j2, i, ad3, j1, k1, intw1);
                int k3 = 1;
                for(int l5 = (i - 1) + 1; l5 > 0; l5--)
                {
                    if(ad2[(k3 - 1) + i1] == 0.0D)
                    {
                        double d4 = 1.0D / Dnrm2.dnrm2(i, ad3, (1 - 1) + (k3 - 1) * k1 + j1, 1);
                        Dscal.dscal(i, d4, ad3, (1 - 1) + (k3 - 1) * k1 + j1, 1);
                    } else
                    if(ad2[(k3 - 1) + i1] > 0.0D)
                    {
                        double d5 = 1.0D / Dlapy2.dlapy2(Dnrm2.dnrm2(i, ad3, (k3 - 1) * k1 + j1, 1), Dnrm2.dnrm2(i, ad3, ((k3 + 1) - 1) * k1 + j1, 1));
                        Dscal.dscal(i, d5, ad3, (1 - 1) + (k3 - 1) * k1 + j1, 1);
                        Dscal.dscal(i, d5, ad3, (1 - 1) + ((k3 + 1) - 1) * k1 + j1, 1);
                        int l4 = 1;
                        for(int j6 = (i - 1) + 1; j6 > 0; j6--)
                        {
                            ad5[((k4 + l4) - 1 - 1) + j2] = Math.pow(ad3[(l4 - 1) + (k3 - 1) * k1 + j1], 2) + Math.pow(ad3[(l4 - 1) + ((k3 + 1) - 1) * k1 + j1], 2);
                            l4++;
                        }

                        l4 = Idamax.idamax(i, ad5, (k4 - 1) + j2, 1);
                        Dlartg.dlartg(ad3[(l4 - 1) + (k3 - 1) * k1 + j1], ad3[(l4 - 1) + ((k3 + 1) - 1) * k1 + j1], doublew1, doublew4, doublew2);
                        Drot.drot(i, ad3, (1 - 1) + (k3 - 1) * k1 + j1, 1, ad3, (1 - 1) + ((k3 + 1) - 1) * k1 + j1, 1, doublew1.val, doublew4.val);
                        ad3[(l4 - 1) + ((k3 + 1) - 1) * k1 + j1] = 0.0D;
                    }
                    k3++;
                }

            }
            if(flag3)
            {
                Dgebak.dgebak("B", "R", i, intw3.val, intw2.val, ad5, (i4 - 1) + j2, i, ad4, l1, i2, intw1);
                int l3 = 1;
                for(int i6 = (i - 1) + 1; i6 > 0; i6--)
                {
                    if(ad2[(l3 - 1) + i1] == 0.0D)
                    {
                        double d6 = 1.0D / Dnrm2.dnrm2(i, ad4, (1 - 1) + (l3 - 1) * i2 + l1, 1);
                        Dscal.dscal(i, d6, ad4, (1 - 1) + (l3 - 1) * i2 + l1, 1);
                    } else
                    if(ad2[(l3 - 1) + i1] > 0.0D)
                    {
                        double d7 = 1.0D / Dlapy2.dlapy2(Dnrm2.dnrm2(i, ad4, (l3 - 1) * i2 + l1, 1), Dnrm2.dnrm2(i, ad4, (1 - 1) + ((l3 + 1) - 1) * i2 + l1, 1));
                        Dscal.dscal(i, d7, ad4, (l3 - 1) * i2 + l1, 1);
                        Dscal.dscal(i, d7, ad4, ((l3 + 1) - 1) * i2 + l1, 1);
                        int i5 = 1;
                        for(int k6 = (i - 1) + 1; k6 > 0; k6--)
                        {
                            ad5[((k4 + i5) - 1 - 1) + j2] = Math.pow(ad4[(i5 - 1) + (l3 - 1) * i2 + l1], 2) + Math.pow(ad4[(i5 - 1) + ((l3 + 1) - 1) * i2 + l1], 2);
                            i5++;
                        }

                        i5 = Idamax.idamax(i, ad5, (k4 - 1) + j2, 1);
                        Dlartg.dlartg(ad4[(i5 - 1) + (l3 - 1) * i2 + l1], ad4[(i5 - 1) + ((l3 + 1) - 1) * i2 + l1], doublew1, doublew4, doublew2);
                        Drot.drot(i, ad4, (1 - 1) + (l3 - 1) * i2 + l1, 1, ad4, ((l3 + 1) - 1) * i2 + l1, 1, doublew1.val, doublew4.val);
                        ad4[(i5 - 1) + ((l3 + 1) - 1) * i2 + l1] = 0.0D;
                    }
                    l3++;
                }

            }
        }
        if(flag1)
        {
            Dlascl.dlascl("G", 0, 0, d1, d, i - intw.val, 1, ad1, ((intw.val + 1) - 1) + l, Math.max(i - intw.val, 1), intw1);
            Dlascl.dlascl("G", 0, 0, d1, d, i - intw.val, 1, ad2, ((intw.val + 1) - 1) + i1, Math.max(i - intw.val, 1), intw1);
            if(intw.val > 0)
            {
                Dlascl.dlascl("G", 0, 0, d1, d, intw3.val - 1, 1, ad1, l, i, intw1);
                Dlascl.dlascl("G", 0, 0, d1, d, intw3.val - 1, 1, ad2, i1, i, intw1);
            }
        }
        ad5[j2] = j5;
    }
}

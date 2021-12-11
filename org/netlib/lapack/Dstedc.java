package org.netlib.lapack;

import org.netlib.blas.Dgemm;
import org.netlib.blas.Dswap;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dstedc
{
    public static void dstedc(String s, int i, double ad[], int j, double ad1[], int k, double ad2[], int l, 
            int i1, double ad3[], int j1, int k1, int ai[], int l1, int i2, 
            intW intw)
    {
        int l3;
        int i4;
label0:
        {
            boolean flag = false;
            byte byte0 = 0;
            l3 = 0;
            i4 = 0;
            int j4 = 0;
            int k4 = 0;
            int l4 = 0;
            int i5 = 0;
            double d = 0.0D;
            double d1 = 0.0D;
            intw.val = 0;
            flag = (k1 == -1) || (i2 == -1);
            if(Lsame.lsame(s, "N"))
                byte0 = 0;
            else
            if(Lsame.lsame(s, "V"))
                byte0 = 1;
            else
            if(Lsame.lsame(s, "I"))
                byte0 = 2;
            else
                byte0 = -1;
            if(byte0 < 0)
                intw.val = -1;
            else
            if(i < 0)
                intw.val = -2;
            else
            if((i1 < 1) || ((byte0 > 0) && (i1 < Math.max(1, i))))
                intw.val = -6;
            if(intw.val == 0)
            {
                k4 = Ilaenv.ilaenv(9, "DSTEDC", " ", 0, 0, 0, 0);
                if((i <= 1) || (byte0 == 0))
                {
                    l3 = 1;
                    i4 = 1;
                } else
                if(i <= k4)
                {
                    l3 = 1;
                    i4 = 2 * (i - 1);
                } else
                {
                    int k3 = (int)(Math.log(i) / Math.log(2D));
                    if((int)Math.pow(2, k3) < i)
                        k3++;
                    if((int)Math.pow(2, k3) < i)
                        k3++;
                    if(byte0 == 1)
                    {
                        i4 = 1 + 3 * i + 2 * i * k3 + 3 * (int)Math.pow(i, 2);
                        l3 = 6 + 6 * i + 5 * i * k3;
                    } else
                    if(byte0 == 2)
                    {
                        i4 = 1 + 4 * i + (int)Math.pow(i, 2);
                        l3 = 3 + 5 * i;
                    }
                }
                ad3[(1 - 1) + j1] = i4;
                ai[(1 - 1) + l1] = l3;
                if((k1 < i4) && flag ^ true)
                    intw.val = -8;
                else
                if((i2 < l3) && flag ^ true)
                    intw.val = -10;
            }
            if(intw.val != 0)
            {
                Xerbla.xerbla("DSTEDC", -intw.val);
                return;
            }
            if(flag)
                return;
            if(i == 0)
                return;
            if(i == 1)
            {
                if(byte0 != 0)
                    ad2[(1 - 1) + (1 - 1) * i1 + l] = 1.0D;
                return;
            }
            if(byte0 == 0)
            {
                Dsterf.dsterf(i, ad, j, ad1, k, intw);
                break label0;
            }
            if(i <= k4)
            {
                Dsteqr.dsteqr(s, i, ad, j, ad1, k, ad2, l, i1, ad3, j1, intw);
                break label0;
            }
            if(byte0 == 1)
                i5 = 1 + i * i;
            else
                i5 = 1;
            if(byte0 == 2)
                Dlaset.dlaset("Full", i, i, 0.0D, 1.0D, ad2, l, i1);
            d1 = Dlanst.dlanst("M", i, ad, j, ad1, k);
            if(d1 == 0.0D)
                break label0;
            d = Dlamch.dlamch("Epsilon");
            l4 = 1;
            do
            {
                if(l4 > i)
                    break;
                int j2 = l4;
                do
                {
                    if(j2 >= i)
                        break;
                    double d6 = d * Math.sqrt(Math.abs(ad[(j2 - 1) + j])) * Math.sqrt(Math.abs(ad[((j2 + 1) - 1) + j]));
                    if(Math.abs(ad1[(j2 - 1) + k]) <= d6)
                        break;
                    j2++;
                } while(true);
                j4 = (j2 - l4) + 1;
                if(j4 == 1)
                {
                    l4 = j2 + 1;
                    continue;
                }
                if(j4 > k4)
                {
                    double d2 = Dlanst.dlanst("M", j4, ad, (l4 - 1) + j, ad1, (l4 - 1) + k);
                    Dlascl.dlascl("G", 0, 0, d2, 1.0D, j4, 1, ad, (l4 - 1) + j, j4, intw);
                    Dlascl.dlascl("G", 0, 0, d2, 1.0D, j4 - 1, 1, ad1, (l4 - 1) + k, j4 - 1, intw);
                    int j5;
                    if(byte0 == 1)
                        j5 = 1;
                    else
                        j5 = l4;
                    Dlaed0.dlaed0(byte0, i, j4, ad, (l4 - 1) + j, ad1, (l4 - 1) + k, ad2, (j5 - 1) + (l4 - 1) * i1 + l, i1, ad3, (1 - 1) + j1, i, ad3, (i5 - 1) + j1, ai, l1, intw);
                    if(intw.val != 0)
                    {
                        intw.val = (((intw.val / (j4 + 1) + l4) - 1) * (i + 1) + intw.val % (j4 + 1) + l4) - 1;
                        break label0;
                    }
                    Dlascl.dlascl("G", 0, 0, 1.0D, d2, j4, 1, ad, (l4 - 1) + j, j4, intw);
                } else
                {
                    if(byte0 == 1)
                    {
                        Dsteqr.dsteqr("I", j4, ad, (l4 - 1) + j, ad1, (l4 - 1) + k, ad3, j1, j4, ad3, ((j4 * j4 + 1) - 1) + j1, intw);
                        Dlacpy.dlacpy("A", i, j4, ad2, (1 - 1) + (l4 - 1) * i1 + l, i1, ad3, (i5 - 1) + j1, i);
                        Dgemm.dgemm("N", "N", i, j4, j4, 1.0D, ad3, (i5 - 1) + j1, i, ad3, j1, j4, 0.0D, ad2, (1 - 1) + (l4 - 1) * i1 + l, i1);
                    } else
                    if(byte0 == 2)
                        Dsteqr.dsteqr("I", j4, ad, (l4 - 1) + j, ad1, (l4 - 1) + k, ad2, (l4 - 1) + (l4 - 1) * i1 + l, i1, ad3, j1, intw);
                    else
                        Dsterf.dsterf(j4, ad, (l4 - 1) + j, ad1, (l4 - 1) + k, intw);
                    if(intw.val != 0)
                    {
                        intw.val = l4 * (i + 1) + j2;
                        break label0;
                    }
                }
                l4 = j2 + 1;
            } while(true);
            if(j4 != i)
                if(byte0 == 0)
                {
                    Dlasrt.dlasrt("I", i, ad, j, intw);
                } else
                {
                    int l2 = 2;
                    for(int k5 = i - 1; k5 > 0; k5--)
                    {
                        int k2 = l2 - 1;
                        int j3 = k2;
                        double d4 = ad[(k2 - 1) + j];
                        int i3 = l2;
                        for(int l5 = (i - l2) + 1; l5 > 0; l5--)
                        {
                            if(ad[(i3 - 1) + j] < d4)
                            {
                                j3 = i3;
                                d4 = ad[(i3 - 1) + j];
                            }
                            i3++;
                        }

                        if(j3 != k2)
                        {
                            ad[(j3 - 1) + j] = ad[(k2 - 1) + j];
                            ad[(k2 - 1) + j] = d4;
                            Dswap.dswap(i, ad2, (k2 - 1) * i1 + l, 1, ad2, (j3 - 1) * i1 + l, 1);
                        }
                        l2++;
                    }

                }
        }
        ad3[j1] = i4;
        ai[l1] = l3;
    }
}

package org.netlib.lapack;

import org.netlib.blas.Dscal;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dspevd
{
    public static void dspevd(String s, String s1, int i, double ad[], int j, double ad1[], int k, double ad2[], 
            int l, int i1, double ad3[], int j1, int k1, int ai[], int l1, 
            int i2, intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        intW intw1 = new intW(0);
        int j2 = 0;
        int k2 = 0;
        boolean flag3 = false;
        int i3 = 0;
        int k3 = 0;
        double d = 0.0D;
        double d1 = 0.0D;
        double d2 = 0.0D;
        double d3 = 0.0D;
        double d4 = 0.0D;
        double d5 = 0.0D;
        double d6 = 0.0D;
        double d7 = 0.0D;
        flag1 = Lsame.lsame(s, "V");
        flag = (k1 == -1) || (i2 == -1);
        intw.val = 0;
        if((flag1 || Lsame.lsame(s, "N")) ^ true)
            intw.val = -1;
        else
        if((Lsame.lsame(s1, "U") || Lsame.lsame(s1, "L")) ^ true)
            intw.val = -2;
        else
        if(i < 0)
            intw.val = -3;
        else
        if((i1 < 1) || (flag1 && (i1 < i)))
            intw.val = -7;
        if(intw.val == 0)
        {
            if(i <= 1)
            {
                i3 = 1;
                k3 = 1;
            } else
            if(flag1)
            {
                i3 = 3 + 5 * i;
                k3 = 1 + 6 * i + (int)Math.pow(i, 2);
            } else
            {
                i3 = 1;
                k3 = 2 * i;
            }
            ai[(1 - 1) + l1] = i3;
            ad3[(1 - 1) + j1] = k3;
            if((k1 < k3) && flag ^ true)
                intw.val = -9;
            else
            if((i2 < i3) && flag ^ true)
                intw.val = -11;
        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DSPEVD", -intw.val);
            return;
        }
        if(flag)
            return;
        if(i == 0)
            return;
        if(i == 1)
        {
            ad1[(1 - 1) + k] = ad[(1 - 1) + j];
            if(flag1)
                ad2[(1 - 1) + (1 - 1) * i1 + l] = 1.0D;
            return;
        }
        d5 = Dlamch.dlamch("Safe minimum");
        d2 = Dlamch.dlamch("Precision");
        d7 = d5 / d2;
        d1 = 1.0D / d7;
        d4 = Math.sqrt(d7);
        d3 = Math.sqrt(d1);
        d = Dlansp.dlansp("M", s1, i, ad, j, ad3, j1);
        flag3 = false;
        if((d > 0.0D) && (d < d4))
        {
            flag3 = true;
            d6 = d4 / d;
        } else
        if(d > d3)
        {
            flag3 = true;
            d6 = d3 / d;
        }
        if(flag3)
            Dscal.dscal((i * (i + 1)) / 2, d6, ad, j, 1);
        j2 = 1;
        k2 = j2 + i;
        Dsptrd.dsptrd(s1, i, ad, j, ad1, k, ad3, (j2 - 1) + j1, ad3, (k2 - 1) + j1, intw1);
        if(flag1 ^ true)
        {
            Dsterf.dsterf(i, ad1, k, ad3, (j2 - 1) + j1, intw);
        } else
        {
            int l2 = k2 + i;
            int j3 = (k1 - l2) + 1;
            Dstedc.dstedc("I", i, ad1, k, ad3, (j2 - 1) + j1, ad2, l, i1, ad3, (l2 - 1) + j1, j3, ai, l1, i2, intw);
            Dopmtr.dopmtr("L", s1, "N", i, i, ad, j, ad3, (k2 - 1) + j1, ad2, l, i1, ad3, (l2 - 1) + j1, intw1);
        }
        if(flag3)
            Dscal.dscal(i, 1.0D / d6, ad1, k, 1);
        ad3[(1 - 1) + j1] = k3;
        ai[(1 - 1) + l1] = i3;
    }
}

package org.netlib.lapack;

import org.netlib.blas.Dgemm;
import org.netlib.blas.Dscal;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dsbevd
{
    public static void dsbevd(String s, String s1, int i, int j, double ad[], int k, int l, double ad1[], 
            int i1, double ad2[], int j1, int k1, double ad3[], int l1, int i2, 
            int ai[], int j2, int k2, intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        intW intw1 = new intW(0);
        int l2 = 0;
        int i3 = 0;
        int j3 = 0;
        boolean flag3 = false;
        int k3 = 0;
        int l3 = 0;
        int i4 = 0;
        double d = 0.0D;
        double d1 = 0.0D;
        double d2 = 0.0D;
        double d3 = 0.0D;
        double d4 = 0.0D;
        double d5 = 0.0D;
        double d6 = 0.0D;
        double d7 = 0.0D;
        flag2 = Lsame.lsame(s, "V");
        flag = Lsame.lsame(s1, "L");
        flag1 = (i2 == -1) || (k2 == -1);
        intw.val = 0;
        if(i <= 1)
        {
            k3 = 1;
            i4 = 1;
        } else
        if(flag2)
        {
            k3 = 3 + 5 * i;
            i4 = 1 + 5 * i + 2 * (int)Math.pow(i, 2);
        } else
        {
            k3 = 1;
            i4 = 2 * i;
        }
        if((flag2 || Lsame.lsame(s, "N")) ^ true)
            intw.val = -1;
        else
        if((flag || Lsame.lsame(s1, "U")) ^ true)
            intw.val = -2;
        else
        if(i < 0)
            intw.val = -3;
        else
        if(j < 0)
            intw.val = -4;
        else
        if(l < j + 1)
            intw.val = -6;
        else
        if((k1 < 1) || (flag2 && (k1 < i)))
            intw.val = -9;
        if(intw.val == 0)
        {
            ad3[(1 - 1) + l1] = i4;
            ai[(1 - 1) + j2] = k3;
            if((i2 < i4) && flag1 ^ true)
                intw.val = -11;
            else
            if((k2 < k3) && flag1 ^ true)
                intw.val = -13;
        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DSBEVD", -intw.val);
            return;
        }
        if(flag1)
            return;
        if(i == 0)
            return;
        if(i == 1)
        {
            ad1[(1 - 1) + i1] = ad[k];
            if(flag2)
                ad2[j1] = 1.0D;
            return;
        }
        d5 = Dlamch.dlamch("Safe minimum");
        d2 = Dlamch.dlamch("Precision");
        d7 = d5 / d2;
        d1 = 1.0D / d7;
        d4 = Math.sqrt(d7);
        d3 = Math.sqrt(d1);
        d = Dlansb.dlansb("M", s1, i, j, ad, k, l, ad3, l1);
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
            if(flag)
                Dlascl.dlascl("B", j, j, 1.0D, d6, i, i, ad, k, l, intw);
            else
                Dlascl.dlascl("Q", j, j, 1.0D, d6, i, i, ad, k, l, intw);
        l2 = 1;
        j3 = l2 + i;
        i3 = j3 + i * i;
        l3 = (i2 - i3) + 1;
        Dsbtrd.dsbtrd(s, s1, i, j, ad, k, l, ad1, i1, ad3, (l2 - 1) + l1, ad2, j1, k1, ad3, (j3 - 1) + l1, intw1);
        if(flag2 ^ true)
        {
            Dsterf.dsterf(i, ad1, i1, ad3, (l2 - 1) + l1, intw);
        } else
        {
            Dstedc.dstedc("I", i, ad1, i1, ad3, (l2 - 1) + l1, ad3, (j3 - 1) + l1, i, ad3, (i3 - 1) + l1, l3, ai, j2, k2, intw);
            Dgemm.dgemm("N", "N", i, i, i, 1.0D, ad2, j1, k1, ad3, (j3 - 1) + l1, i, 0.0D, ad3, (i3 - 1) + l1, i);
            Dlacpy.dlacpy("A", i, i, ad3, (i3 - 1) + l1, i, ad2, j1, k1);
        }
        if(flag3)
            Dscal.dscal(i, 1.0D / d6, ad1, i1, 1);
        ad3[l1] = i4;
        ai[j2] = k3;
    }
}

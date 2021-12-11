package org.netlib.lapack;

import org.netlib.blas.Dscal;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dsyevd
{
    public static void dsyevd(String s, String s1, int i, double ad[], int j, int k, double ad1[], int l, 
            double ad2[], int i1, int j1, int ai[], int k1, int l1, intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        intW intw1 = new intW(0);
        int i2 = 0;
        int j2 = 0;
        int k2 = 0;
        int l2 = 0;
        boolean flag3 = false;
        int i3 = 0;
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
        flag1 = (j1 == -1) || (l1 == -1);
        intw.val = 0;
        if((flag2 || Lsame.lsame(s, "N")) ^ true)
            intw.val = -1;
        else
        if((flag || Lsame.lsame(s1, "U")) ^ true)
            intw.val = -2;
        else
        if(i < 0)
            intw.val = -3;
        else
        if(k < Math.max(1, i))
            intw.val = -5;
        if(intw.val == 0)
        {
            int j3;
            int j4;
            if(i <= 1)
            {
                j3 = 1;
                j4 = 1;
                i4 = j4;
                i3 = j3;
            } else
            {
                if(flag2)
                {
                    j3 = 3 + 5 * i;
                    j4 = 1 + 6 * i + 2 * (int)Math.pow(i, 2);
                } else
                {
                    j3 = 1;
                    j4 = 2 * i + 1;
                }
                i4 = Math.max(j4, 2 * i + Ilaenv.ilaenv(1, "DSYTRD", s1, i, -1, -1, -1));
                i3 = j3;
            }
            ad2[(1 - 1) + i1] = i4;
            ai[(1 - 1) + k1] = i3;
            if((j1 < j4) && flag1 ^ true)
                intw.val = -8;
            else
            if((l1 < j3) && flag1 ^ true)
                intw.val = -10;
        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DSYEVD", -intw.val);
            return;
        }
        if(flag1)
            return;
        if(i == 0)
            return;
        if(i == 1)
        {
            ad1[(1 - 1) + l] = ad[(1 - 1) + (1 - 1) * k + j];
            if(flag2)
                ad[(1 - 1) + (1 - 1) * k + j] = 1.0D;
            return;
        }
        d5 = Dlamch.dlamch("Safe minimum");
        d2 = Dlamch.dlamch("Precision");
        d7 = d5 / d2;
        d1 = 1.0D / d7;
        d4 = Math.sqrt(d7);
        d3 = Math.sqrt(d1);
        d = Dlansy.dlansy("M", s1, i, ad, j, k, ad2, i1);
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
            Dlascl.dlascl(s1, 0, 0, 1.0D, d6, i, i, ad, j, k, intw);
        i2 = 1;
        j2 = i2 + i;
        l2 = j2 + i;
        k3 = (j1 - l2) + 1;
        k2 = l2 + i * i;
        l3 = (j1 - k2) + 1;
        Dsytrd.dsytrd(s1, i, ad, j, k, ad1, l, ad2, (i2 - 1) + i1, ad2, (j2 - 1) + i1, ad2, (l2 - 1) + i1, k3, intw1);
        i4 = (int)((double)(2 * i) + ad2[(l2 - 1) + i1]);
        if(flag2 ^ true)
        {
            Dsterf.dsterf(i, ad1, l, ad2, (i2 - 1) + i1, intw);
        } else
        {
            Dstedc.dstedc("I", i, ad1, l, ad2, (i2 - 1) + i1, ad2, (l2 - 1) + i1, i, ad2, (k2 - 1) + i1, l3, ai, k1, l1, intw);
            Dormtr.dormtr("L", s1, "N", i, i, ad, j, k, ad2, (j2 - 1) + i1, ad2, (l2 - 1) + i1, i, ad2, (k2 - 1) + i1, l3, intw1);
            Dlacpy.dlacpy("A", i, i, ad2, (l2 - 1) + i1, i, ad, j, k);
            i4 = Math.max(i4, 1 + 6 * i + 2 * (int)Math.pow(i, 2));
        }
        if(flag3)
            Dscal.dscal(i, 1.0D / d6, ad1, l, 1);
        ad2[i1] = i4;
        ai[k1] = i3;
    }
}

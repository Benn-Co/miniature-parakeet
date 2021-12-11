package org.netlib.lapack;

import org.netlib.blas.Dtrmm;
import org.netlib.blas.Dtrsm;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dsygvd
{
    public static void dsygvd(int i, String s, String s1, int j, double ad[], int k, int l, double ad1[], 
            int i1, int j1, double ad2[], int k1, double ad3[], int l1, int i2, 
            int ai[], int j2, int k2, intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        int l2 = 0;
        int i3 = 0;
        int j3 = 0;
        int k3 = 0;
        flag2 = Lsame.lsame(s, "V");
        flag1 = Lsame.lsame(s1, "U");
        flag = (i2 == -1) || (k2 == -1);
        intw.val = 0;
        if(j <= 1)
        {
            i3 = 1;
            k3 = 1;
        } else
        if(flag2)
        {
            i3 = 3 + 5 * j;
            k3 = 1 + 6 * j + 2 * (int)Math.pow(j, 2);
        } else
        {
            i3 = 1;
            k3 = 2 * j + 1;
        }
        j3 = k3;
        l2 = i3;
        if((i < 1) || (i > 3))
            intw.val = -1;
        else
        if((flag2 || Lsame.lsame(s, "N")) ^ true)
            intw.val = -2;
        else
        if((flag1 || Lsame.lsame(s1, "L")) ^ true)
            intw.val = -3;
        else
        if(j < 0)
            intw.val = -4;
        else
        if(l < Math.max(1, j))
            intw.val = -6;
        else
        if(j1 < Math.max(1, j))
            intw.val = -8;
        if(intw.val == 0)
        {
            ad3[(1 - 1) + l1] = j3;
            ai[(1 - 1) + j2] = l2;
            if((i2 < k3) && flag ^ true)
                intw.val = -11;
            else
            if((k2 < i3) && flag ^ true)
                intw.val = -13;
        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DSYGVD", -intw.val);
            return;
        }
        if(flag)
            return;
        if(j == 0)
            return;
        Dpotrf.dpotrf(s1, j, ad1, i1, j1, intw);
        if(intw.val != 0)
        {
            intw.val = j + intw.val;
            return;
        }
        Dsygst.dsygst(i, s1, j, ad, k, l, ad1, i1, j1, intw);
        Dsyevd.dsyevd(s, s1, j, ad, k, l, ad2, k1, ad3, l1, i2, ai, j2, k2, intw);
        j3 = (int)Math.max(j3, ad3[(1 - 1) + l1]);
        l2 = (int)Math.max(l2, ai[(1 - 1) + j2]);
        if(flag2 && (intw.val == 0))
            if((i == 1) || (i == 2))
            {
                String s3;
                if(flag1)
                    s3 = "N";
                else
                    s3 = "T";
                Dtrsm.dtrsm("Left", s1, s3, "Non-unit", j, j, 1.0D, ad1, i1, j1, ad, k, l);
            } else
            if(i == 3)
            {
                String s4;
                if(flag1)
                    s4 = "T";
                else
                    s4 = "N";
                Dtrmm.dtrmm("Left", s1, s4, "Non-unit", j, j, 1.0D, ad1, i1, j1, ad, k, l);
            }
        ad3[(1 - 1) + l1] = j3;
        ai[(1 - 1) + j2] = l2;
    }
}

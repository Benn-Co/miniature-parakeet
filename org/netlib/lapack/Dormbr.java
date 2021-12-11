package org.netlib.lapack;

import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dormbr
{
    public static void dormbr(String s, String s1, String s2, int i, int j, int k, double ad[], int l, 
            int i1, double ad1[], int j1, double ad2[], int k1, int l1, double ad3[], 
            int i2, int j2, intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        intW intw1 = new intW(0);
        int k2 = 0;
        int i4 = 0;
        int j4 = 0;
        intw.val = 0;
        flag = Lsame.lsame(s, "Q");
        flag1 = Lsame.lsame(s1, "L");
        flag3 = Lsame.lsame(s2, "N");
        flag2 = j2 == -1;
        if (flag1)
        {
            i4 = i;
            j4 = j;
        } else
        {
            i4 = j;
            j4 = i;
        }
        if (!flag && !Lsame.lsame(s, "P"))
            intw.val = -1;
        else
        if (!flag1 && !Lsame.lsame(s1, "R"))
            intw.val = -2;
        else
        if (!flag3 && !Lsame.lsame(s2, "T"))
            intw.val = -3;
        else
        if (i < 0)
            intw.val = -4;
        else
        if (j < 0)
            intw.val = -5;
        else
        if (k < 0)
            intw.val = -6;
        else
        if ((flag && (i1 < Math.max(1, i4))) || (!flag && (i1 < Math.max(1, Math.min(i4, k)))))
            intw.val = -8;
        else
        if (l1 < Math.max(1, i))
            intw.val = -11;
        else
        if ((j2 < Math.max(1, j4)) && !flag2)
            intw.val = -13;

        if (intw.val == 0)
        {
            int j3;
            if(flag)
            {
                if(flag1)
                    j3 = Ilaenv.ilaenv(1, "DORMQR", s1 + s2, i - 1, j, i - 1, -1);
                else
                    j3 = Ilaenv.ilaenv(1, "DORMQR", s1 + s2, i, j - 1, j - 1, -1);
            } else
            if(flag1)
                j3 = Ilaenv.ilaenv(1, "DORMLQ", s1 + s2, i - 1, j, i - 1, -1);
            else
                j3 = Ilaenv.ilaenv(1, "DORMLQ", s1 + s2, i, j - 1, j - 1, -1);
            k2 = Math.max(1, j4) * j3;
            ad3[(1 - 1) + i2] = k2;
        }
        if (intw.val != 0)
        {
            Xerbla.xerbla("DORMBR", -intw.val);
            return;
        }

        if (flag2)
            return;
        ad3[i2] = 1;
        if((i == 0) || (j == 0))
            return;
        if(flag)
        {
            if(i4 >= k)
                Dormqr.dormqr(s1, s2, i, j, k, ad, l, i1, ad1, j1, ad2, k1, l1, ad3, i2, j2, intw1);
            else
            if(i4 > 1)
            {
                byte byte0;
                byte byte2;
                int l2;
                int k3;
                if(flag1)
                {
                    l2 = i - 1;
                    k3 = j;
                    byte0 = 2;
                    byte2 = 1;
                } else
                {
                    l2 = i;
                    k3 = j - 1;
                    byte0 = 1;
                    byte2 = 2;
                }
                Dormqr.dormqr(s1, s2, l2, k3, i4 - 1, ad, 1 + l, i1, ad1, j1, ad2, (byte0 - 1) + (byte2 - 1) * l1 + k1, l1, ad3, i2, j2, intw1);
            }
        } else
        {
            String s4;
            if(flag3)
                s4 = "T";
            else
                s4 = "N";
            if(i4 > k)
                Dormlq.dormlq(s1, s4, i, j, k, ad, l, i1, ad1, j1, ad2, k1, l1, ad3, i2, j2, intw1);
            else
            if(i4 > 1)
            {
                byte byte1;
                byte byte3;
                int i3;
                int l3;
                if(flag1)
                {
                    i3 = i - 1;
                    l3 = j;
                    byte1 = 2;
                    byte3 = 1;
                } else
                {
                    i3 = i;
                    l3 = j - 1;
                    byte1 = 1;
                    byte3 = 2;
                }
                Dormlq.dormlq(s1, s4, i3, l3, i4 - 1, ad, i1 + l, i1, ad1, j1, ad2, (byte1 - 1) + (byte3 - 1) * l1 + k1, l1, ad3, i2, j2, intw1);
            }
        }
        ad3[i2] = k2;
    }
}

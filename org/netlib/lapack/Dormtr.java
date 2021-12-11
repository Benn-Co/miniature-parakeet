package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dormtr
{
    public static void dormtr(String s, String s1, String s2, int i, int j, double ad[], int k, int l, 
            double ad1[], int i1, double ad2[], int j1, int k1, double ad3[], int l1, 
            int i2, intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        intW intw1 = new intW(0);
        int j2 = 0;
        int k2 = 0;
        int i3 = 0;
        int j3 = 0;
        int k3 = 0;
        intw.val = 0;
        flag = Lsame.lsame(s, "L");
        flag2 = Lsame.lsame(s1, "U");
        flag1 = i2 == -1;
        if(flag)
        {
            j3 = i;
            k3 = j;
        } else
        {
            j3 = j;
            k3 = i;
        }
        if(flag ^ true && Lsame.lsame(s, "R") ^ true)
            intw.val = -1;
        else
        if(flag2 ^ true && Lsame.lsame(s1, "L") ^ true)
            intw.val = -2;
        else
        if(Lsame.lsame(s2, "N") ^ true && Lsame.lsame(s2, "T") ^ true)
            intw.val = -3;
        else
        if(i < 0)
            intw.val = -4;
        else
        if(j < 0)
            intw.val = -5;
        else
        if(l < Math.max(1, j3))
            intw.val = -7;
        else
        if(k1 < Math.max(1, i))
            intw.val = -10;
        else
        if((i2 < Math.max(1, k3)) && flag1 ^ true)
            intw.val = -12;
        if(intw.val == 0)
        {
            int l2;
            if(flag2)
            {
                if(flag)
                    l2 = Ilaenv.ilaenv(1, "DORMQL", s + s2, i - 1, j, i - 1, -1);
                else
                    l2 = Ilaenv.ilaenv(1, "DORMQL", s + s2, i, j - 1, j - 1, -1);
            } else
            if(flag)
                l2 = Ilaenv.ilaenv(1, "DORMQR", s + s2, i - 1, j, i - 1, -1);
            else
                l2 = Ilaenv.ilaenv(1, "DORMQR", s + s2, i, j - 1, j - 1, -1);
            j2 = Math.max(1, k3) * l2;
            ad3[(1 - 1) + l1] = j2;
        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DORMTR", -intw.val);
            return;
        }
        if(flag1)
            return;
        if(((i == 0) || (j == 0)) || (j3 == 1))
        {
            ad3[(1 - 1) + l1] = 1;
            return;
        }
        if(flag)
        {
            k2 = i - 1;
            i3 = j;
        } else
        {
            k2 = i;
            i3 = j - 1;
        }
        if(flag2)
        {
            Dormql.dormql(s, s2, k2, i3, j3 - 1, ad, l + k, l, ad1, i1, ad2, j1, k1, ad3, l1, i2, intw1);
        } else
        {
            byte byte0;
            byte byte1;
            if(flag)
            {
                byte0 = 2;
                byte1 = 1;
            } else
            {
                byte0 = 1;
                byte1 = 2;
            }
            Dormqr.dormqr(s, s2, k2, i3, j3 - 1, ad, 1 + k, l, ad1, i1, ad2, (byte0 - 1) + (byte1 - 1) * k1 + j1, k1, ad3, l1, i2, intw1);
        }
        ad3[l1] = j2;
    }
}

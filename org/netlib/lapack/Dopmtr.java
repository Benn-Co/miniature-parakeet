package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dopmtr
{
    public static void dopmtr(String s, String s1, String s2, int i, int j, double ad[], int k, double ad1[], 
            int l, double ad2[], int i1, int j1, double ad3[], int k1, intW intw)
    {
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;
        int j3 = 0;
        int i4 = 0;
        int j4 = 0;
        int k4 = 0;
        int l4 = 0;
        intw.val = 0;
        flag3 = Lsame.lsame(s, "L");
        flag4 = Lsame.lsame(s2, "N");
        flag5 = Lsame.lsame(s1, "U");
        if(flag3)
            l4 = i;
        else
            l4 = j;
        if(flag3 ^ true && Lsame.lsame(s, "R") ^ true)
            intw.val = -1;
        else
        if(flag5 ^ true && Lsame.lsame(s1, "L") ^ true)
            intw.val = -2;
        else
        if(flag4 ^ true && Lsame.lsame(s2, "T") ^ true)
            intw.val = -3;
        else
        if(i < 0)
            intw.val = -4;
        else
        if(j < 0)
            intw.val = -5;
        else
        if(j1 < Math.max(1, i))
            intw.val = -9;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DOPMTR", -intw.val);
            return;
        }
        if((i == 0) || (j == 0))
            return;
        if(flag5)
        {
            boolean flag1 = (flag3 && flag4) || (flag3 ^ true && flag4 ^ true);
            int j2;
            int l2;
            byte byte0;
            int k3;
            if(flag1)
            {
                j2 = 1;
                l2 = l4 - 1;
                byte0 = 1;
                k3 = 2;
            } else
            {
                j2 = l4 - 1;
                l2 = 1;
                byte0 = -1;
                k3 = (l4 * (l4 + 1)) / 2 - 1;
            }
            if(flag3)
                k4 = j;
            else
                j4 = i;
            int l1 = j2;
            for(int i5 = ((l2 - j2) + byte0) / byte0; i5 > 0; i5--)
            {
                if(flag3)
                    j4 = l1;
                else
                    k4 = l1;
                double d1 = ad[(k3 - 1) + k];
                ad[(k3 - 1) + k] = 1.0D;
                Dlarf.dlarf(s, j4, k4, ad, (((k3 - l1) + 1) - 1) + k, 1, ad1[(l1 - 1) + l], ad2, i1, j1, ad3, k1);
                ad[(k3 - 1) + k] = d1;
                if(flag1)
                    k3 = k3 + l1 + 2;
                else
                    k3 = k3 - l1 - 1;
                l1 += byte0;
            }

        } else
        {
            boolean flag2 = (flag3 && flag4 ^ true) || (flag3 ^ true && flag4);
            int k2;
            int i3;
            byte byte1;
            int l3;
            if(flag2)
            {
                k2 = 1;
                i3 = l4 - 1;
                byte1 = 1;
                l3 = 2;
            } else
            {
                k2 = l4 - 1;
                i3 = 1;
                byte1 = -1;
                l3 = (l4 * (l4 + 1)) / 2 - 1;
            }
            if(flag3)
            {
                k4 = j;
                i4 = 1;
            } else
            {
                j4 = i;
                j3 = 1;
            }
            int i2 = k2;
            for(int j5 = ((i3 - k2) + byte1) / byte1; j5 > 0; j5--)
            {
                double d2 = ad[(l3 - 1) + k];
                ad[(l3 - 1) + k] = 1.0D;
                if(flag3)
                {
                    j4 = i - i2;
                    j3 = i2 + 1;
                } else
                {
                    k4 = j - i2;
                    i4 = i2 + 1;
                }
                Dlarf.dlarf(s, j4, k4, ad, (l3 - 1) + k, 1, ad1[(i2 - 1) + l], ad2, (j3 - 1) + (i4 - 1) * j1 + i1, j1, ad3, k1);
                ad[(l3 - 1) + k] = d2;
                if(flag2)
                    l3 = ((l3 + l4) - i2) + 1;
                else
                    l3 = ((l3 - l4) + i2) - 2;
                i2 += byte1;
            }

        }
    }
}

package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dormr3
{
    public static void dormr3(String s, String s1, int i, int j, int k, int l, double ad[], int i1, 
            int j1, double ad1[], int k1, double ad2[], int l1, int i2, double ad3[], 
            int j2, intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        int k2 = 0;
        int l2 = 0;
        int i3 = 0;
        byte byte0 = 0;
        int j3 = 0;
        int k3 = 0;
        int l3 = 0;
        int i4 = 0;
        int j4 = 0;
        int k4 = 0;
        intw.val = 0;
        flag = Lsame.lsame(s, "L");
        flag1 = Lsame.lsame(s1, "N");
        if(flag)
            k4 = i;
        else
            k4 = j;
        if(flag ^ true && Lsame.lsame(s, "R") ^ true)
            intw.val = -1;
        else
        if(flag1 ^ true && Lsame.lsame(s1, "T") ^ true)
            intw.val = -2;
        else
        if(i < 0)
            intw.val = -3;
        else
        if(j < 0)
            intw.val = -4;
        else
        if((k < 0) || (k > k4))
            intw.val = -5;
        else
        if(((l < 0) || (flag && (l > i))) || (flag ^ true && (l > j)))
            intw.val = -6;
        else
        if(j1 < Math.max(1, k))
            intw.val = -8;
        else
        if(i2 < Math.max(1, i))
            intw.val = -11;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DORMR3", -intw.val);
            return;
        }
        if(((i == 0) || (j == 0)) || (k == 0))
            return;
        if((flag && flag1 ^ true) || (flag ^ true && flag1))
        {
            l2 = 1;
            i3 = k;
            byte0 = 1;
        } else
        {
            l2 = k;
            i3 = 1;
            byte0 = -1;
        }
        if(flag)
        {
            j4 = j;
            k3 = (i - l) + 1;
            l3 = 1;
        } else
        {
            i4 = i;
            k3 = (j - l) + 1;
            j3 = 1;
        }
        k2 = l2;
        for(int l4 = ((i3 - l2) + byte0) / byte0; l4 > 0; l4--)
        {
            if(flag)
            {
                i4 = (i - k2) + 1;
                j3 = k2;
            } else
            {
                j4 = (j - k2) + 1;
                l3 = k2;
            }
            Dlarz.dlarz(s, i4, j4, l, ad, (k2 - 1) + (k3 - 1) * j1 + i1, j1, ad1[(k2 - 1) + k1], ad2, (j3 - 1) + (l3 - 1) * i2 + l1, i2, ad3, j2);
            k2 += byte0;
        }

    }
}

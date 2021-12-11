package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dormrz
{
    public static void dormrz(String s, String s1, int i, int j, int k, int l, double ad[], int i1, 
            int j1, double ad1[], int k1, double ad2[], int l1, int i2, double ad3[], 
            int j2, int k2, intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        int i4 = 0;
        intW intw1 = new intW(0);
        int j4 = 0;
        int l4 = 0;
        int i5 = 0;
        int j5 = 0;
        int k5 = 0;
        int l5 = 0;
        int i6 = 0;
        int j6 = 0;
        int k6 = 0;
        int l6 = 0;
        double ad4[] = new double[65 * 64];
        intw.val = 0;
        flag = Lsame.lsame(s, "L");
        flag2 = Lsame.lsame(s1, "N");
        flag1 = k2 == -1;
        if(flag)
        {
            k6 = i;
            l6 = Math.max(1, j);
        } else
        {
            k6 = j;
            l6 = Math.max(1, i);
        }
        if(flag ^ true && Lsame.lsame(s, "R") ^ true)
            intw.val = -1;
        else
        if(flag2 ^ true && Lsame.lsame(s1, "T") ^ true)
            intw.val = -2;
        else
        if(i < 0)
            intw.val = -3;
        else
        if(j < 0)
            intw.val = -4;
        else
        if((k < 0) || (k > k6))
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
        if(intw.val == 0)
        {
            if((i == 0) || (j == 0))
            {
                j5 = 1;
            } else
            {
                l5 = Math.min(64, Ilaenv.ilaenv(1, "DORMRQ", s + s1, i, j, k, -1));
                j5 = l6 * l5;
            }
            ad3[(1 - 1) + j2] = j5;
            if((k2 < Math.max(1, l6)) && flag1 ^ true)
                intw.val = -13;
        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DORMRZ", -intw.val);
            return;
        }
        if(flag1)
            return;
        if((i == 0) || (j == 0))
        {
            ad3[(1 - 1) + j2] = 1;
            return;
        }
        i6 = 2;
        i5 = l6;
        if((l5 > 1) && (l5 < k))
        {
            j4 = l6 * l5;
            if(k2 < j4)
            {
                l5 = k2 / i5;
                i6 = Math.max(2, Ilaenv.ilaenv(2, "DORMRQ", s + s1, i, j, k, -1));
            }
        } else
        {
            j4 = l6;
        }
        if((l5 < i6) || (l5 >= k))
        {
            Dormr3.dormr3(s, s1, i, j, k, l, ad, i1, j1, ad1, k1, ad2, l1, i2, ad3, j2, intw1);
        } else
        {
            int i3;
            int j3;
            int k3;
            if((flag && flag2 ^ true) || (flag ^ true && flag2))
            {
                i3 = 1;
                j3 = k;
                k3 = l5;
            } else
            {
                i3 = ((k - 1) / l5) * l5 + 1;
                j3 = 1;
                k3 = -l5;
            }
            int k4;
            if(flag)
            {
                j6 = j;
                l4 = 1;
                k4 = (i - l) + 1;
            } else
            {
                k5 = i;
                i4 = 1;
                k4 = (j - l) + 1;
            }
            String s3;
            if(flag2)
                s3 = "T";
            else
                s3 = "N";
            int l2 = i3;
            for(int i7 = ((j3 - i3) + k3) / k3; i7 > 0; i7--)
            {
                int l3 = Math.min(l5, (k - l2) + 1);
                Dlarzt.dlarzt("Backward", "Rowwise", l, l3, ad, (l2 - 1) + (k4 - 1) * j1 + i1, j1, ad1, (l2 - 1) + k1, ad4, 0, 65);
                if(flag)
                {
                    k5 = (i - l2) + 1;
                    i4 = l2;
                } else
                {
                    j6 = (j - l2) + 1;
                    l4 = l2;
                }
                Dlarzb.dlarzb(s, s3, "Backward", "Rowwise", k5, j6, l3, l, ad, (l2 - 1) + (k4 - 1) * j1 + i1, j1, ad4, 0, 65, ad2, (i4 - 1) + (l4 - 1) * i2 + l1, i2, ad3, j2, i5);
                l2 += k3;
            }

        }
        ad3[j2] = j5;
    }
}

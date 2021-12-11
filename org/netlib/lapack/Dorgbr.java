package org.netlib.lapack;

import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dorgbr
{
    public static void dorgbr(String s, int i, int j, int k, double ad[], int l, int i1, double ad1[], 
            int j1, double ad2[], int k1, int l1, intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        intW intw1 = new intW(0);
        int k3 = 0;
        int l3 = 0;
        intw.val = 0;
        flag1 = Lsame.lsame(s, "Q");
        l3 = Math.min(i, j);
        flag = l1 == -1;
        if (!flag1 && !Lsame.lsame(s, "P"))
            intw.val = -1;
        else
        if(i < 0)
            intw.val = -2;
        else
        if(((j < 0) || (flag1 && ((j > i) || (j < Math.min(i, k))))) || (!flag1 && ((i > j) || (i < Math.min(j, k)))))
            intw.val = -3;
        else
        if(k < 0)
            intw.val = -4;
        else
        if(i1 < Math.max(1, i))
            intw.val = -6;
        else
        if (l1 < Math.max(1, l3) && !flag)
            intw.val = -9;
        if(intw.val == 0)
        {
            int i4;
            if(flag1)
                i4 = Ilaenv.ilaenv(1, "DORGQR", " ", i, j, k, -1);
            else
                i4 = Ilaenv.ilaenv(1, "DORGLQ", " ", i, j, k, -1);
            k3 = Math.max(1, l3) * i4;
            ad2[(1 - 1) + k1] = k3;
        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DORGBR", -intw.val);
            return;
        }
        if(flag)
            return;
        if(i == 0 || j == 0)
        {
            ad2[k1] = 1;
            return;
        }
        if(flag1)
        {
            if(i >= k)
            {
                Dorgqr.dorgqr(i, j, k, ad, l, i1, ad1, j1, ad2, k1, l1, intw1);
            } else
            {
                int i3 = i;
                for(int j4 = ((2 - i) + -1) / -1; j4 > 0; j4--)
                {
                    ad[(i3 - 1) * i1 + l] = 0.0;
                    int i2 = i3 + 1;
                    for(int j5 = (i - (i3 + 1)) + 1; j5 > 0; j5--)
                    {
                        ad[(i2 - 1) + (i3 - 1) * i1 + l] = ad[(i2 - 1) + (i3 - 1 - 1) * i1 + l];
                        i2++;
                    }

                    i3--;
                }

                ad[l] = 1.0;
                int j2 = 2;
                for(int k4 = (i - 2) + 1; k4 > 0; k4--)
                {
                    ad[(j2 - 1) + l] = 0.0;
                    j2++;
                }

                if(i > 1)
                    Dorgqr.dorgqr(i - 1, i - 1, i - 1, ad, 1 + i1 + l, i1, ad1, j1, ad2, k1, l1, intw1);
            }
        } else
        if(k < j)
        {
            Dorglq.dorglq(i, j, k, ad, l, i1, ad1, j1, ad2, k1, l1, intw1);
        } else
        {
            ad[l] = 1.0;
            int k2 = 2;
            for(int l4 = j - 1; l4 > 0; l4--)
            {
                ad[(k2 - 1) + l] = 0.0;
                k2++;
            }

            int j3 = 2;
            for(int i5 = j - 1; i5 > 0; i5--)
            {
                int l2 = j3 - 1;
                for(int k5 = ((2 - (j3 - 1)) + -1) / -1; k5 > 0; k5--)
                {
                    ad[(l2 - 1) + (j3 - 1) * i1 + l] = ad[(l2 - 1 - 1) + (j3 - 1) * i1 + l];
                    l2--;
                }

                ad[(j3 - 1) * i1 + l] = 0.0;
                j3++;
            }

            if(j > 1)
                Dorglq.dorglq(j - 1, j - 1, j - 1, ad, 1 + i1 + l, i1, ad1, j1, ad2, k1, l1, intw1);
        }
        ad2[k1] = k3;
    }
}

package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dorgql
{
    public static void dorgql(int i, int j, int k, double ad[], int l, int i1, double ad1[], int j1, 
            double ad2[], int k1, int l1, intW intw)
    {
        boolean flag = false;
        intW intw1 = new intW(0);
        int l2 = 0;
        int k3 = 0;
        int i4 = 0;
        int k4 = 0;
        int l4 = 0;
        int i5 = 0;
        intw.val = 0;
        flag = l1 == -1;
        if(i < 0)
            intw.val = -1;
        else
        if((j < 0) || (j > i))
            intw.val = -2;
        else
        if((k < 0) || (k > j))
            intw.val = -3;
        else
        if(i1 < Math.max(1, i))
            intw.val = -5;
        if(intw.val == 0)
        {
            int j4;
            if(j == 0)
            {
                j4 = 1;
            } else
            {
                k4 = Ilaenv.ilaenv(1, "DORGQL", " ", i, j, k, -1);
                j4 = j * k4;
            }
            ad2[(1 - 1) + k1] = j4;
            if((l1 < Math.max(1, j)) && flag ^ true)
                intw.val = -8;
        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DORGQL", -intw.val);
            return;
        }
        if(flag)
            return;
        if(j <= 0)
            return;
        l4 = 2;
        i5 = 0;
        l2 = j;
        if((k4 > 1) && (k4 < k))
        {
            i5 = Math.max(0, Ilaenv.ilaenv(3, "DORGQL", " ", i, j, k, -1));
            if(i5 < k)
            {
                i4 = j;
                l2 = i4 * k4;
                if(l1 < l2)
                {
                    k4 = l1 / i4;
                    l4 = Math.max(2, Ilaenv.ilaenv(2, "DORGQL", " ", i, j, k, -1));
                }
            }
        }
        if(((k4 >= l4) && (k4 < k)) && (i5 < k))
        {
            k3 = Math.min(k, ((((k - i5) + k4) - 1) / k4) * k4);
            int i3 = 1;
            for(int j5 = (j - k3 - 1) + 1; j5 > 0; j5--)
            {
                int i2 = (i - k3) + 1;
                for(int l5 = (i - ((i - k3) + 1)) + 1; l5 > 0; l5--)
                {
                    ad[(i2 - 1) + (i3 - 1) * i1 + l] = 0.0D;
                    i2++;
                }

                i3++;
            }

        } else
        {
            k3 = 0;
        }
        Dorg2l.dorg2l(i - k3, j - k3, k - k3, ad, l, i1, ad1, j1, ad2, k1, intw1);
        if(k3 > 0)
        {
            int j2 = (k - k3) + 1;
            for(int k5 = ((k - ((k - k3) + 1)) + k4) / k4; k5 > 0; k5--)
            {
                int k2 = Math.min(k4, (k - j2) + 1);
                if((j - k) + j2 > 1)
                {
                    Dlarft.dlarft("Backward", "Columnwise", ((i - k) + j2 + k2) - 1, k2, ad, (((j - k) + j2) - 1) * i1 + l, i1, ad1, (j2 - 1) + j1, ad2, k1, i4);
                    Dlarfb.dlarfb("Left", "No transpose", "Backward", "Columnwise", ((i - k) + j2 + k2) - 1, ((j - k) + j2) - 1, k2, ad, (((j - k) + j2) - 1) * i1 + l, i1, ad2, k1, i4, ad, l, i1, ad2, ((k2 + 1) - 1) + k1, i4);
                }
                Dorg2l.dorg2l(((i - k) + j2 + k2) - 1, k2, k2, ad, (((j - k) + j2) - 1) * i1 + l, i1, ad1, (j2 - 1) + j1, ad2, k1, intw1);
                int j3 = (j - k) + j2;
                for(int i6 = (((j - k) + j2 + k2) - 1 - ((j - k) + j2)) + 1; i6 > 0; i6--)
                {
                    int l3 = (i - k) + j2 + k2;
                    for(int j6 = (i - ((i - k) + j2 + k2)) + 1; j6 > 0; j6--)
                    {
                        ad[(l3 - 1) + (j3 - 1) * i1 + l] = 0.0D;
                        l3++;
                    }

                    j3++;
                }

                j2 += k4;
            }

        }
        ad2[k1] = l2;
    }
}

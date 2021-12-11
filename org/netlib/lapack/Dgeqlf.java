package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgeqlf
{
    public static void dgeqlf(int i, int j, double ad[], int k, int l, double ad1[], int i1, double ad2[], 
            int j1, int k1, intW intw)
    {
        boolean flag = false;
        intW intw1 = new intW(0);
        int j2 = 0;
        int k2 = 0;
        int j3 = 0;
        int l3 = 0;
        int i4 = 0;
        int j4 = 0;
        int k4 = 0;
        int l4 = 0;
        intw.val = 0;
        flag = k1 == -1;
        if(i < 0)
            intw.val = -1;
        else
        if(j < 0)
            intw.val = -2;
        else
        if(l < Math.max(1, i))
            intw.val = -4;
        if(intw.val == 0)
        {
            k2 = Math.min(i, j);
            int k3;
            if(k2 == 0)
            {
                k3 = 1;
            } else
            {
                i4 = Ilaenv.ilaenv(1, "DGEQLF", " ", i, j, -1, -1);
                k3 = j * i4;
            }
            ad2[(1 - 1) + j1] = k3;
            if((k1 < Math.max(1, j)) && flag ^ true)
                intw.val = -7;
        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DGEQLF", -intw.val);
            return;
        }
        if(flag)
            return;
        if(k2 == 0)
            return;
        j4 = 2;
        l4 = 1;
        j2 = j;
        if((i4 > 1) && (i4 < k2))
        {
            l4 = Math.max(0, Ilaenv.ilaenv(3, "DGEQLF", " ", i, j, -1, -1));
            if(l4 < k2)
            {
                j3 = j;
                j2 = j3 * i4;
                if(k1 < j2)
                {
                    i4 = k1 / j3;
                    j4 = Math.max(2, Ilaenv.ilaenv(2, "DGEQLF", " ", i, j, -1, -1));
                }
            }
        }
        if(((i4 >= j4) && (i4 < k2)) && (l4 < k2))
        {
            int l2 = ((k2 - l4 - 1) / i4) * i4;
            int i3 = Math.min(k2, l2 + i4);
            int l1 = (k2 - i3) + l2 + 1;
            for(int i5 = ((((k2 - i3) + 1) - ((k2 - i3) + l2 + 1)) + -i4) / -i4; i5 > 0; i5--)
            {
                int i2 = Math.min((k2 - l1) + 1, i4);
                Dgeql2.dgeql2(((i - k2) + l1 + i2) - 1, i2, ad, (1 - 1) + (((j - k2) + l1) - 1) * l + k, l, ad1, (l1 - 1) + i1, ad2, j1, intw1);
                if((j - k2) + l1 > 1)
                {
                    Dlarft.dlarft("Backward", "Columnwise", ((i - k2) + l1 + i2) - 1, i2, ad, (1 - 1) + (((j - k2) + l1) - 1) * l + k, l, ad1, (l1 - 1) + i1, ad2, j1, j3);
                    Dlarfb.dlarfb("Left", "Transpose", "Backward", "Columnwise", ((i - k2) + l1 + i2) - 1, ((j - k2) + l1) - 1, i2, ad, (1 - 1) + (((j - k2) + l1) - 1) * l + k, l, ad2, j1, j3, ad, k, l, ad2, ((i2 + 1) - 1) + j1, j3);
                }
                l1 += -i4;
            }

            l3 = ((i - k2) + l1 + i4) - 1;
            k4 = ((j - k2) + l1 + i4) - 1;
        } else
        {
            l3 = i;
            k4 = j;
        }
        if((l3 > 0) && (k4 > 0))
            Dgeql2.dgeql2(l3, k4, ad, k, l, ad1, i1, ad2, j1, intw1);
        ad2[j1] = j2;
    }
}

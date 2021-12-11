package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgerqf
{
    public static void dgerqf(int i, int j, double ad[], int k, int l, double ad1[], int i1, double ad2[], 
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
                i4 = Ilaenv.ilaenv(1, "DGERQF", " ", i, j, -1, -1);
                k3 = i * i4;
            }
            ad2[(1 - 1) + j1] = k3;
            if((k1 < Math.max(1, i)) && flag ^ true)
                intw.val = -7;
        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DGERQF", -intw.val);
            return;
        }
        if(flag)
            return;
        if(k2 == 0)
            return;
        j4 = 2;
        l4 = 1;
        j2 = i;
        if((i4 > 1) && (i4 < k2))
        {
            l4 = Math.max(0, Ilaenv.ilaenv(3, "DGERQF", " ", i, j, -1, -1));
            if(l4 < k2)
            {
                j3 = i;
                j2 = j3 * i4;
                if(k1 < j2)
                {
                    i4 = k1 / j3;
                    j4 = Math.max(2, Ilaenv.ilaenv(2, "DGERQF", " ", i, j, -1, -1));
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
                Dgerq2.dgerq2(i2, ((j - k2) + l1 + i2) - 1, ad, (((i - k2) + l1) - 1) + k, l, ad1, (l1 - 1) + i1, ad2, j1, intw1);
                if((i - k2) + l1 > 1)
                {
                    Dlarft.dlarft("Backward", "Rowwise", ((j - k2) + l1 + i2) - 1, i2, ad, (((i - k2) + l1) - 1) + k, l, ad1, (l1 - 1) + i1, ad2, j1, j3);
                    Dlarfb.dlarfb("Right", "No transpose", "Backward", "Rowwise", ((i - k2) + l1) - 1, ((j - k2) + l1 + i2) - 1, i2, ad, (((i - k2) + l1) - 1) + k, l, ad2, j1, j3, ad, k, l, ad2, ((i2 + 1) - 1) + j1, j3);
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
            Dgerq2.dgerq2(l3, k4, ad, k, l, ad1, i1, ad2, j1, intw1);
        ad2[j1] = j2;
    }
}

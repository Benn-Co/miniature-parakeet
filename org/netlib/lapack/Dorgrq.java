package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dorgrq
{
    public static void dorgrq(int i, int j, int k, double ad[], int l, int i1, double ad1[], int j1, 
            double ad2[], int k1, int l1, intW intw)
    {
        boolean flag = false;
        intW intw1 = new intW(0);
        int i3 = 0;
        int l3 = 0;
        int j4 = 0;
        int l4 = 0;
        int i5 = 0;
        int j5 = 0;
        intw.val = 0;
        flag = l1 == -1;
        if(i < 0)
            intw.val = -1;
        else
        if(j < i)
            intw.val = -2;
        else
        if((k < 0) || (k > i))
            intw.val = -3;
        else
        if(i1 < Math.max(1, i))
            intw.val = -5;
        if(intw.val == 0)
        {
            int k4;
            if(i <= 0)
            {
                k4 = 1;
            } else
            {
                l4 = Ilaenv.ilaenv(1, "DORGRQ", " ", i, j, k, -1);
                k4 = i * l4;
            }
            ad2[(1 - 1) + k1] = k4;
            if((l1 < Math.max(1, i)) && flag ^ true)
                intw.val = -8;
        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DORGRQ", -intw.val);
            return;
        }
        if(flag)
            return;
        if(i <= 0)
            return;
        i5 = 2;
        j5 = 0;
        i3 = i;
        if((l4 > 1) && (l4 < k))
        {
            j5 = Math.max(0, Ilaenv.ilaenv(3, "DORGRQ", " ", i, j, k, -1));
            if(j5 < k)
            {
                j4 = i;
                i3 = j4 * l4;
                if(l1 < i3)
                {
                    l4 = l1 / j4;
                    i5 = Math.max(2, Ilaenv.ilaenv(2, "DORGRQ", " ", i, j, k, -1));
                }
            }
        }
        if(((l4 >= i5) && (l4 < k)) && (j5 < k))
        {
            l3 = Math.min(k, ((((k - j5) + l4) - 1) / l4) * l4);
            int j3 = (j - l3) + 1;
            for(int k5 = (j - ((j - l3) + 1)) + 1; k5 > 0; k5--)
            {
                int i2 = 1;
                for(int i6 = (i - l3 - 1) + 1; i6 > 0; i6--)
                {
                    ad[(i2 - 1) + (j3 - 1) * i1 + l] = 0.0D;
                    i2++;
                }

                j3++;
            }

        } else
        {
            l3 = 0;
        }
        Dorgr2.dorgr2(i - l3, j - l3, k - l3, ad, l, i1, ad1, j1, ad2, k1, intw1);
        if(l3 > 0)
        {
            int j2 = (k - l3) + 1;
            for(int l5 = ((k - ((k - l3) + 1)) + l4) / l4; l5 > 0; l5--)
            {
                int k2 = Math.min(l4, (k - j2) + 1);
                int l2 = (i - k) + j2;
                if(l2 > 1)
                {
                    Dlarft.dlarft("Backward", "Rowwise", ((j - k) + j2 + k2) - 1, k2, ad, (l2 - 1) + l, i1, ad1, (j2 - 1) + j1, ad2, k1, j4);
                    Dlarfb.dlarfb("Right", "Transpose", "Backward", "Rowwise", l2 - 1, ((j - k) + j2 + k2) - 1, k2, ad, (l2 - 1) + l, i1, ad2, k1, j4, ad, l, i1, ad2, ((k2 + 1) - 1) + k1, j4);
                }
                Dorgr2.dorgr2(k2, ((j - k) + j2 + k2) - 1, k2, ad, (l2 - 1) + l, i1, ad1, (j2 - 1) + j1, ad2, k1, intw1);
                int i4 = (j - k) + j2 + k2;
                for(int j6 = (j - ((j - k) + j2 + k2)) + 1; j6 > 0; j6--)
                {
                    int k3 = l2;
                    for(int k6 = ((l2 + k2) - 1 - l2) + 1; k6 > 0; k6--)
                    {
                        ad[(k3 - 1) + (i4 - 1) * i1 + l] = 0.0D;
                        k3++;
                    }

                    i4++;
                }

                j2 += l4;
            }

        }
        ad2[k1] = i3;
    }
}

package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dorglq
{
    public static void dorglq(int i, int j, int k, double ad[], int l, int i1, double ad1[], int j1, 
            double ad2[], int k1, int l1, intW intw)
    {
        boolean flag = false;
        intW intw1 = new intW(0);
        int l2 = 0;
        int k3 = 0;
        int l3 = 0;
        int j4 = 0;
        int k4 = 0;
        int l4 = 0;
        int i5 = 0;
        int j5 = 0;
        intw.val = 0;
        l4 = Ilaenv.ilaenv(1, "DORGLQ", " ", i, j, k, -1);
        k4 = Math.max(1, i) * l4;
        ad2[k1] = k4;
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
        else
        if((l1 < Math.max(1, i)) && !flag)
            intw.val = -8;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DORGLQ", -intw.val);
            return;
        }
        if(flag)
            return;
        if(i <= 0)
        {
            ad2[k1] = 1;
            return;
        }
        i5 = 2;
        j5 = 0;
        l2 = i;
        if((l4 > 1) && (l4 < k))
        {
            j5 = Math.max(0, Ilaenv.ilaenv(3, "DORGLQ", " ", i, j, k, -1));
            if(j5 < k)
            {
                j4 = i;
                l2 = j4 * l4;
                if(l1 < l2)
                {
                    l4 = l1 / j4;
                    i5 = Math.max(2, Ilaenv.ilaenv(2, "DORGLQ", " ", i, j, k, -1));
                }
            }
        }
        if(((l4 >= i5) && (l4 < k)) && (j5 < k))
        {
            k3 = ((k - j5 - 1) / l4) * l4;
            l3 = Math.min(k, k3 + l4);
            int i3 = 1;
            for(int k5 = l3; k5 > 0; k5--)
            {
                int i2 = l3 + 1;
                for(int i6 = (i - (l3 + 1)) + 1; i6 > 0; i6--)
                {
                    ad[(i2 - 1) + (i3 - 1) * i1 + l] = 0.0;
                    i2++;
                }

                i3++;
            }

        } else
        {
            l3 = 0;
        }
        if(l3 < i)
            Dorgl2.dorgl2(i - l3, j - l3, k - l3, ad, ((l3 + 1) - 1) + ((l3 + 1) - 1) * i1 + l, i1, ad1, ((l3 + 1) - 1) + j1, ad2, k1, intw1);
        if(l3 > 0)
        {
            int j2 = k3 + 1;
            for(int l5 = ((1 - (k3 + 1)) + -l4) / -l4; l5 > 0; l5--)
            {
                int k2 = Math.min(l4, (k - j2) + 1);
                if(j2 + k2 <= i)
                {
                    Dlarft.dlarft("Forward", "Rowwise", (j - j2) + 1, k2, ad, (j2 - 1) + (j2 - 1) * i1 + l, i1, ad1, (j2 - 1) + j1, ad2, k1, j4);
                    Dlarfb.dlarfb("Right", "Transpose", "Forward", "Rowwise", (i - j2 - k2) + 1, (j - j2) + 1, k2, ad, (j2 - 1) + (j2 - 1) * i1 + l, i1, ad2, k1, j4, ad, ((j2 + k2) - 1) + (j2 - 1) * i1 + l, i1, ad2, ((k2 + 1) - 1) + k1, j4);
                }
                Dorgl2.dorgl2(k2, (j - j2) + 1, k2, ad, (j2 - 1) + (j2 - 1) * i1 + l, i1, ad1, (j2 - 1) + j1, ad2, k1, intw1);
                int j3 = 1;
                for(int j6 = j2 - 1; j6 > 0; j6--)
                {
                    int i4 = j2;
                    for(int k6 = ((j2 + k2) - 1 - j2) + 1; k6 > 0; k6--)
                    {
                        ad[(i4 - 1) + (j3 - 1) * i1 + l] = 0.0;
                        i4++;
                    }

                    j3++;
                }

                j2 += -l4;
            }

        }
        ad2[k1] = l2;
    }
}

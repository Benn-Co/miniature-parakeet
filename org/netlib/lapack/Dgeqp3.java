package org.netlib.lapack;

import org.netlib.blas.Dnrm2;
import org.netlib.blas.Dswap;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgeqp3
{
    public static void dgeqp3(int i, int j, double ad[], int k, int l, int ai[], int i1, double ad1[], 
            int j1, double ad2[], int k1, int l1, intW intw)
    {
        boolean flag = false;
        intW intw1 = new intW(0);
        int i2 = 0;
        int j2 = 0;
        int j3 = 0;
        int l4 = 0;
        intw.val = 0;
        flag = l1 == -1;
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
            j3 = Math.min(i, j);
            int i3;
            if(j3 == 0)
            {
                i2 = 1;
                i3 = 1;
            } else
            {
                i2 = 3 * j + 1;
                int i4 = Ilaenv.ilaenv(1, "DGEQRF", " ", i, j, -1, -1);
                i3 = 2 * j + (j + 1) * i4;
            }
            ad2[(1 - 1) + k1] = i3;
            if((l1 < i2) && flag ^ true)
                intw.val = -8;
        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DGEQP3", -intw.val);
            return;
        }
        if(flag)
            return;
        if(j3 == 0)
            return;
        l4 = 1;
        j2 = 1;
        for(int j6 = (j - 1) + 1; j6 > 0; j6--)
        {
            if(ai[(j2 - 1) + i1] != 0)
            {
                if(j2 != l4)
                {
                    Dswap.dswap(i, ad, (1 - 1) + (j2 - 1) * l + k, 1, ad, (1 - 1) + (l4 - 1) * l + k, 1);
                    ai[(j2 - 1) + i1] = ai[(l4 - 1) + i1];
                    ai[(l4 - 1) + i1] = j2;
                } else
                {
                    ai[(j2 - 1) + i1] = j2;
                }
                l4++;
            } else
            {
                ai[(j2 - 1) + i1] = j2;
            }
            j2++;
        }

        l4--;
        if(l4 > 0)
        {
            int l3 = Math.min(i, l4);
            Dgeqrf.dgeqrf(i, l3, ad, k, l, ad1, j1, ad2, k1, l1, intw);
            i2 = Math.max(i2, (int)ad2[(1 - 1) + k1]);
            if(l3 < j)
            {
                Dormqr.dormqr("Left", "Transpose", i, j - l3, l3, ad, k, l, ad1, j1, ad, (1 - 1) + ((l3 + 1) - 1) * l + k, l, ad2, k1, l1, intw);
                i2 = Math.max(i2, (int)ad2[(1 - 1) + k1]);
            }
        }
        if(l4 < j3)
        {
            int j5 = i - l4;
            int l5 = j - l4;
            int k5 = j3 - l4;
            int j4 = Ilaenv.ilaenv(1, "DGEQRF", " ", j5, l5, -1, -1);
            int k4 = 2;
            int i5 = 0;
            if((j4 > 1) && (j4 < k5))
            {
                i5 = Math.max(0, Ilaenv.ilaenv(3, "DGEQRF", " ", j5, l5, -1, -1));
                if(i5 < k5)
                {
                    int k3 = 2 * l5 + (l5 + 1) * j4;
                    i2 = Math.max(i2, k3);
                    if(l1 < k3)
                    {
                        j4 = (l1 - 2 * l5) / (l5 + 1);
                        k4 = Math.max(2, Ilaenv.ilaenv(2, "DGEQRF", " ", j5, l5, -1, -1));
                    }
                }
            }
            int k2 = l4 + 1;
            for(int k6 = (j - (l4 + 1)) + 1; k6 > 0; k6--)
            {
                ad2[(k2 - 1) + k1] = Dnrm2.dnrm2(j5, ad, ((l4 + 1) - 1) + (k2 - 1) * l + k, 1);
                ad2[((j + k2) - 1) + k1] = ad2[(k2 - 1) + k1];
                k2++;
            }

            if(((j4 >= k4) && (j4 < k5)) && (i5 < k5))
            {
                k2 = l4 + 1;
                int i6 = j3 - i5;
                while(k2 > i6) 
                {
                    int l2 = Math.min(j4, (i6 - k2) + 1);
                    Dlaqps.dlaqps(i, (j - k2) + 1, k2 - 1, l2, intw1, ad, (1 - 1) + (k2 - 1) * l + k, l, ai, (k2 - 1) + i1, ad1, (k2 - 1) + j1, ad2, (k2 - 1) + k1, ad2, ((j + k2) - 1) + k1, ad2, ((2 * j + 1) - 1) + k1, ad2, ((2 * j + l2 + 1) - 1) + k1, (j - k2) + 1);
                    k2 += intw1.val;
                }
            } else
            {
                k2 = l4 + 1;
            }
            if(k2 <= j3)
                Dlaqp2.dlaqp2(i, (j - k2) + 1, k2 - 1, ad, (1 - 1) + (k2 - 1) * l + k, l, ai, (k2 - 1) + i1, ad1, (k2 - 1) + j1, ad2, (k2 - 1) + k1, ad2, ((j + k2) - 1) + k1, ad2, ((2 * j + 1) - 1) + k1);
        }
        ad2[k1] = i2;
    }
}

package org.netlib.lapack;

import org.netlib.blas.Dgemm;
import org.netlib.err.Xerbla;
import org.netlib.util.Util;
import org.netlib.util.intW;

public final class Dgebrd
{
    public static void dgebrd(int i, int j, double ad[], int k, int l, double ad1[], int i1, double ad2[], 
            int j1, double ad3[], int k1, double ad4[], int l1, double ad5[], int i2, 
            int j2, intW intw)
    {
        boolean flag = false;
        int k2 = 0;
        intW intw1 = new intW(0);
        int j3 = 0;
        int k3 = 0;
        int l3 = 0;
        int i4 = 0;
        int j4 = 0;
        int l4 = 0;
        double d = 0.0;
        intw.val = 0;
        j4 = Math.max(1, Ilaenv.ilaenv(1, "DGEBRD", " ", i, j, -1, -1));
        l3 = (i + j) * j4;
        ad5[i2] = l3;
        flag = j2 == -1;
        if(i < 0)
            intw.val = -1;
        else
        if(j < 0)
            intw.val = -2;
        else
        if(l < Math.max(1, i))
            intw.val = -4;
        else
        if((j2 < Util.max(1, i, j)) && !flag)
            intw.val = -10;
        if(intw.val < 0)
        {
            Xerbla.xerbla("DGEBRD", -intw.val);
            return;
        }
        if(flag)
            return;
        i4 = Math.min(i, j);
        if(i4 == 0)
        {
            ad5[i2] = 1;
            return;
        }
        d = Math.max(i, j);
        j3 = i;
        k3 = j;
        if((j4 > 1) && (j4 < i4))
        {
            l4 = Math.max(j4, Ilaenv.ilaenv(3, "DGEBRD", " ", i, j, -1, -1));
            if(l4 < i4)
            {
                d = (i + j) * j4;
                if((double)j2 < d)
                {
                    int k4 = Ilaenv.ilaenv(2, "DGEBRD", " ", i, j, -1, -1);
                    if(j2 >= (i + j) * k4)
                    {
                        j4 = j2 / (i + j);
                    } else
                    {
                        j4 = 1;
                        l4 = i4;
                    }
                }
            }
        } else
        {
            l4 = i4;
        }
        k2 = 1;
        for(int i5 = ((i4 - l4 - 1) + j4) / j4; i5 > 0; i5--)
        {
            Dlabrd.dlabrd((i - k2) + 1, (j - k2) + 1, j4, ad, (k2 - 1) + (k2 - 1) * l + k, l, ad1, (k2 - 1) + i1, ad2, (k2 - 1) + j1, ad3, (k2 - 1) + k1, ad4, (k2 - 1) + l1, ad5, i2, j3, ad5, ((j3 * j4 + 1) - 1) + i2, k3);
            Dgemm.dgemm("No transpose", "Transpose", (i - k2 - j4) + 1, (j - k2 - j4) + 1, j4, -1.0, ad, ((k2 + j4) - 1) + (k2 - 1) * l + k, l, ad5, ((j3 * j4 + j4 + 1) - 1) + i2, k3, 1.0, ad, ((k2 + j4) - 1) + ((k2 + j4) - 1) * l + k, l);
            Dgemm.dgemm("No transpose", "No transpose", (i - k2 - j4) + 1, (j - k2 - j4) + 1, j4, -1.0, ad5, ((j4 + 1) - 1) + i2, j3, ad, (k2 - 1) + ((k2 + j4) - 1) * l + k, l, 1.0, ad, ((k2 + j4) - 1) + ((k2 + j4) - 1) * l + k, l);
            if(i >= j)
            {
                int l2 = k2;
                for(int j5 = ((k2 + j4) - 1 - k2) + 1; j5 > 0; j5--)
                {
                    ad[(l2 - 1) + (l2 - 1) * l + k] = ad1[(l2 - 1) + i1];
                    ad[(l2 - 1) + l2 * l + k] = ad2[(l2 - 1) + j1];
                    l2++;
                }

            } else
            {
                int i3 = k2;
                for(int k5 = ((k2 + j4) - 1 - k2) + 1; k5 > 0; k5--)
                {
                    ad[(i3 - 1) + (i3 - 1) * l + k] = ad1[(i3 - 1) + i1];
                    ad[i3 + (i3 - 1) * l + k] = ad2[(i3 - 1) + j1];
                    i3++;
                }

            }
            k2 += j4;
        }

        Dgebd2.dgebd2((i - k2) + 1, (j - k2) + 1, ad, (k2 - 1) + (k2 - 1) * l + k, l, ad1, (k2 - 1) + i1, ad2, (k2 - 1) + j1, ad3, (k2 - 1) + k1, ad4, (k2 - 1) + l1, ad5, i2, intw1);
        ad5[i2] = d;
    }
}

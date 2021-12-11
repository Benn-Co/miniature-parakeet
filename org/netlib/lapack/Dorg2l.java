package org.netlib.lapack;

import org.netlib.blas.Dscal;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dorg2l
{
    public static void dorg2l(int i, int j, int k, double ad[], int l, int i1, double ad1[], int j1, 
            double ad2[], int k1, intW intw)
    {
        int l1 = 0;
        int j2 = 0;
        intw.val = 0;
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
        if(intw.val != 0)
        {
            Xerbla.xerbla("DORG2L", -intw.val);
            return;
        }
        if(j <= 0)
            return;
        j2 = 1;
        for(int i3 = (j - k - 1) + 1; i3 > 0; i3--)
        {
            int k2 = 1;
            for(int k3 = (i - 1) + 1; k3 > 0; k3--)
            {
                ad[(k2 - 1) + (j2 - 1) * i1 + l] = 0.0D;
                k2++;
            }

            ad[(((i - j) + j2) - 1) + (j2 - 1) * i1 + l] = 1.0D;
            j2++;
        }

        l1 = 1;
        for(int j3 = (k - 1) + 1; j3 > 0; j3--)
        {
            int i2 = (j - k) + l1;
            ad[(((i - j) + i2) - 1) + (i2 - 1) * i1 + l] = 1.0D;
            Dlarf.dlarf("Left", (i - j) + i2, i2 - 1, ad, (1 - 1) + (i2 - 1) * i1 + l, 1, ad1[(l1 - 1) + j1], ad, l, i1, ad2, k1);
            Dscal.dscal(((i - j) + i2) - 1, -ad1[(l1 - 1) + j1], ad, (1 - 1) + (i2 - 1) * i1 + l, 1);
            ad[(((i - j) + i2) - 1) + (i2 - 1) * i1 + l] = 1.0D - ad1[(l1 - 1) + j1];
            int l2 = (i - j) + i2 + 1;
            for(int l3 = (i - ((i - j) + i2 + 1)) + 1; l3 > 0; l3--)
            {
                ad[(l2 - 1) + (i2 - 1) * i1 + l] = 0.0D;
                l2++;
            }

            l1++;
        }

    }
}

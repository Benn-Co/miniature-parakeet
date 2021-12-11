package org.netlib.lapack;

import org.netlib.blas.Dscal;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dorgl2
{
    public static void dorgl2(int i, int j, int k, double ad[], int l, int i1, double ad1[], int j1, 
            double ad2[], int k1, intW intw)
    {
        int l1 = 0;
        intw.val = 0;
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
        if(intw.val != 0)
        {
            Xerbla.xerbla("DORGL2", -intw.val);
            return;
        }
        if(i <= 0)
            return;
        if(k < i)
        {
            int i2 = 1;
            for(int l2 = (j - 1) + 1; l2 > 0; l2--)
            {
                int j2 = k + 1;
                for(int j3 = (i - (k + 1)) + 1; j3 > 0; j3--)
                {
                    ad[(j2 - 1) + (i2 - 1) * i1 + l] = 0.0;
                    j2++;
                }

                if((i2 > k) && (i2 <= i))
                    ad[(i2 - 1) + (i2 - 1) * i1 + l] = 1.0;
                i2++;
            }

        }
        l1 = k;
        for(int i3 = ((1 - k) + -1) / -1; i3 > 0; i3--)
        {
            if(l1 < j)
            {
                if(l1 < i)
                {
                    ad[(l1 - 1) + (l1 - 1) * i1 + l] = 1.0;
                    Dlarf.dlarf("Right", i - l1, (j - l1) + 1, ad, (l1 - 1) + (l1 - 1) * i1 + l, i1, ad1[(l1 - 1) + j1], ad, ((l1 + 1) - 1) + (l1 - 1) * i1 + l, i1, ad2, k1);
                }
                Dscal.dscal(j - l1, -ad1[(l1 - 1) + j1], ad, (l1 - 1) + ((l1 + 1) - 1) * i1 + l, i1);
            }
            ad[(l1 - 1) + (l1 - 1) * i1 + l] = 1.0 - ad1[(l1 - 1) + j1];
            int k2 = 1;
            for(int k3 = l1 - 1; k3 > 0; k3--)
            {
                ad[(l1 - 1) + (k2 - 1) * i1 + l] = 0.0;
                k2++;
            }

            l1--;
        }

    }
}

package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dpttrf
{
    public static void dpttrf(int i, double ad[], int j, double ad1[], int k, intW intw)
    {
label0:
        {
            int l = 0;
            int i1 = 0;
            intw.val = 0;
            if(i < 0)
            {
                intw.val = -1;
                Xerbla.xerbla("DPTTRF", -intw.val);
                return;
            }
            if(i == 0)
                return;
            i1 = (i - 1) % 4;
            l = 1;
            for(int j1 = (i1 - 1) + 1; j1 > 0; j1--)
            {
                if(ad[(l - 1) + j] <= 0.0D)
                {
                    intw.val = l;
                    break label0;
                }
                double d1 = ad1[(l - 1) + k];
                ad1[(l - 1) + k] = d1 / ad[(l - 1) + j];
                ad[((l + 1) - 1) + j] = ad[((l + 1) - 1) + j] - ad1[(l - 1) + k] * d1;
                l++;
            }

            l = i1 + 1;
            for(int k1 = ((i - 4 - (i1 + 1)) + 4) / 4; k1 > 0; k1--)
            {
                if(ad[(l - 1) + j] <= 0.0D)
                {
                    intw.val = l;
                    break label0;
                }
                double d2 = ad1[(l - 1) + k];
                ad1[(l - 1) + k] = d2 / ad[(l - 1) + j];
                ad[((l + 1) - 1) + j] = ad[((l + 1) - 1) + j] - ad1[(l - 1) + k] * d2;
                if(ad[((l + 1) - 1) + j] <= 0.0D)
                {
                    intw.val = l + 1;
                    break label0;
                }
                d2 = ad1[((l + 1) - 1) + k];
                ad1[((l + 1) - 1) + k] = d2 / ad[((l + 1) - 1) + j];
                ad[((l + 2) - 1) + j] = ad[((l + 2) - 1) + j] - ad1[((l + 1) - 1) + k] * d2;
                if(ad[((l + 2) - 1) + j] <= 0.0D)
                {
                    intw.val = l + 2;
                    break label0;
                }
                d2 = ad1[((l + 2) - 1) + k];
                ad1[((l + 2) - 1) + k] = d2 / ad[((l + 2) - 1) + j];
                ad[((l + 3) - 1) + j] = ad[((l + 3) - 1) + j] - ad1[((l + 2) - 1) + k] * d2;
                if(ad[((l + 3) - 1) + j] <= 0.0D)
                {
                    intw.val = l + 3;
                    break label0;
                }
                d2 = ad1[((l + 3) - 1) + k];
                ad1[((l + 3) - 1) + k] = d2 / ad[((l + 3) - 1) + j];
                ad[((l + 4) - 1) + j] = ad[((l + 4) - 1) + j] - ad1[((l + 3) - 1) + k] * d2;
                l += 4;
            }

            if(ad[(i - 1) + j] <= 0.0D)
                intw.val = i;
        }
    }
}

package org.netlib.lapack;

import org.netlib.util.intW;

public final class Dlasdt
{
    public static void dlasdt(int i, intW intw, intW intw1, int ai[], int j, int ai1[], int k, int ai2[], 
            int l, int i1)
    {
        int j1 = 0;
        int l1 = 0;
        int i2 = 0;
        int j2 = 0;
        int k2 = 0;
        double d = 0.0;
        k2 = Math.max(1, i);
        d = Math.log((double)k2 / (double)(i1 + 1)) / Math.log(2.0);
        intw.val = (int)d + 1;
        j1 = i / 2;
        ai[j] = j1 + 1;
        ai1[k] = j1;
        ai2[l] = i - j1 - 1;
        l1 = 0;
        i2 = 1;
        j2 = 1;
        for(int j3 = (intw.val - 2) + 1; j3 > 0; j3--)
        {
            int k1 = 0;
            for(int k3 = j2; k3 > 0; k3--)
            {
                l1 += 2;
                i2 += 2;
                int l2 = j2 + k1;
                ai1[(l1 - 1) + k] = ai1[(l2 - 1) + k] / 2;
                ai2[(l1 - 1) + l] = ai1[(l2 - 1) + k] - ai1[(l1 - 1) + k] - 1;
                ai[(l1 - 1) + j] = ai[(l2 - 1) + j] - ai2[(l1 - 1) + l] - 1;
                ai1[(i2 - 1) + k] = ai2[(l2 - 1) + l] / 2;
                ai2[(i2 - 1) + l] = ai2[(l2 - 1) + l] - ai1[(i2 - 1) + k] - 1;
                ai[(i2 - 1) + j] = ai[(l2 - 1) + j] + ai1[(i2 - 1) + k] + 1;
                k1++;
            }

            j2 *= 2;
        }

        intw1.val = j2 * 2 - 1;
    }
}

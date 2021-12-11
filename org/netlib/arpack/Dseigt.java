package org.netlib.arpack;

import org.netlib.blas.Dcopy;
import org.netlib.util.*;

public final class Dseigt
{
    public static void dseigt(double d, int i, double ad[], int j, int k, double ad1[], int l, 
            double ad2[], int i1, double ad3[], int j1, intW intw)
    {
        int l1 = 0;
        Etime.etime();
        Second.second(t0);
        l1 = arpack_debug.mseigt.val;
        if(l1 > 0)
        {
            Dvout.dvout(arpack_debug.logfil.val, i, ad, (1 - 1) + (2 - 1) * k + j, arpack_debug.ndigit.val, "_seigt: main diagonal of matrix H");
            if(i > 1)
                Dvout.dvout(arpack_debug.logfil.val, i - 1, ad, (2 - 1) + (1 - 1) * k + j, arpack_debug.ndigit.val, "_seigt: sub diagonal of matrix H");
        }
        Dcopy.dcopy(i, ad, (1 - 1) + (2 - 1) * k + j, 1, ad1, l, 1);
        Dcopy.dcopy(i - 1, ad, (2 - 1) + (1 - 1) * k + j, 1, ad3, j1, 1);
        Dstqrb.dstqrb(i, ad1, l, ad3, j1, ad2, i1, ad3, ((i + 1) - 1) + j1, intw);
        if(intw.val == 0)
        {
            if(l1 > 1)
                Dvout.dvout(arpack_debug.logfil.val, i, ad2, i1, arpack_debug.ndigit.val, "_seigt: last row of the eigenvector matrix for H");
            int k1 = 1;
            for(int i2 = (i - 1) + 1; i2 > 0; i2--)
            {
                ad2[(k1 - 1) + i1] = d * Math.abs(ad2[(k1 - 1) + i1]);
                k1++;
            }

            Second.second(t1);
            arpack_timing.tseigt.val = arpack_timing.tseigt.val + (t1.val - t0.val);
        }
    }

    public static floatW t0 = new floatW(0.0F);
    public static floatW t1 = new floatW(0.0F);
    public static float t2 = 0.0F;
    public static float t3 = 0.0F;
    public static float t4 = 0.0F;
    public static float t5 = 0.0F;
}

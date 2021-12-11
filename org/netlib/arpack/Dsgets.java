package org.netlib.arpack;

import org.netlib.blas.Dcopy;
import org.netlib.blas.Dswap;
import org.netlib.util.*;

public final class Dsgets
{
    public static void dsgets(int i, String s, intW intw, intW intw1, double ad[], int j, double ad1[], int k, 
            double ad2[], int l)
    {
        int j1 = 0;
        Etime.etime();
        Second.second(t0);
        j1 = arpack_debug.msgets.val;
        if(s.regionMatches(0, "BE", 0, 2))
        {
            Dsortr.dsortr("LA", true, intw.val + intw1.val, ad, j, ad1, k);
            int i1 = intw.val / 2;
            if(intw.val > 1)
            {
                Dswap.dswap(Math.min(i1, intw1.val), ad, j, 1, ad, ((Math.max(i1, intw1.val) + 1) - 1) + j, 1);
                Dswap.dswap(Math.min(i1, intw1.val), ad1, k, 1, ad1, ((Math.max(i1, intw1.val) + 1) - 1) + k, 1);
            }
        } else
        {
            Dsortr.dsortr(s, true, intw.val + intw1.val, ad, j, ad1, k);
        }
        if((i == 1) && (intw1.val > 0))
        {
            Dsortr.dsortr("SM", true, intw1.val, ad1, k, ad, j);
            Dcopy.dcopy(intw1.val, ad, j, 1, ad2, l, 1);
        }
        Second.second(t1);
        arpack_timing.tsgets.val = arpack_timing.tsgets.val + (t1.val - t0.val);
        if(j1 > 0)
        {
            ivout_adapter(arpack_debug.logfil.val, 1, intw, arpack_debug.ndigit.val, "_sgets: KEV is");
            ivout_adapter(arpack_debug.logfil.val, 1, intw1, arpack_debug.ndigit.val, "_sgets: NP is");
            Dvout.dvout(arpack_debug.logfil.val, intw.val + intw1.val, ad, j, arpack_debug.ndigit.val, "_sgets: Eigenvalues of current H matrix");
            Dvout.dvout(arpack_debug.logfil.val, intw.val + intw1.val, ad1, k, arpack_debug.ndigit.val, "_sgets: Associated Ritz estimates");
        }
    }

    private static void ivout_adapter(int i, int j, intW intw, int k, String s)
    {
        int ai[] = {
            intw.val
        };
        Ivout.ivout(i, j, ai, 0, k, s);
        intw.val = ai[0];
    }

    public static floatW t0 = new floatW(0.0F);
    public static floatW t1 = new floatW(0.0F);
    public static float t2 = 0.0F;
    public static float t3 = 0.0F;
    public static float t4 = 0.0F;
    public static float t5 = 0.0F;
}

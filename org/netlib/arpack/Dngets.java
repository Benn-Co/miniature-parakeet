package org.netlib.arpack;

import org.netlib.util.*;

public final class Dngets
{
    public static void dngets(int i, String s, intW intw, intW intw1, double ad[], int j, double ad1[], int k, 
            double ad2[], int l, double ad3[], int i1, double ad4[], int j1)
    {
        int k1 = 0;
        Etime.etime();
        Second.second(t0);
        k1 = arpack_debug.mngets.val;
        if(s.regionMatches(0, "LM", 0, 2))
            Dsortc.dsortc("LR", true, intw.val + intw1.val, ad, j, ad1, k, ad2, l);
        else
        if(s.regionMatches(0, "SM", 0, 2))
            Dsortc.dsortc("SR", true, intw.val + intw1.val, ad, j, ad1, k, ad2, l);
        else
        if(s.regionMatches(0, "LR", 0, 2))
            Dsortc.dsortc("LM", true, intw.val + intw1.val, ad, j, ad1, k, ad2, l);
        else
        if(s.regionMatches(0, "SR", 0, 2))
            Dsortc.dsortc("SM", true, intw.val + intw1.val, ad, j, ad1, k, ad2, l);
        else
        if(s.regionMatches(0, "LI", 0, 2))
            Dsortc.dsortc("LM", true, intw.val + intw1.val, ad, j, ad1, k, ad2, l);
        else
        if(s.regionMatches(0, "SI", 0, 2))
            Dsortc.dsortc("SM", true, intw.val + intw1.val, ad, j, ad1, k, ad2, l);
        Dsortc.dsortc(s, true, intw.val + intw1.val, ad, j, ad1, k, ad2, l);
        if((ad[((intw1.val + 1) - 1) + j] - ad[(intw1.val - 1) + j] == 0.0D) && (ad1[((intw1.val + 1) - 1) + k] + ad1[(intw1.val - 1) + k] == 0.0D))
        {
            intw1.val = intw1.val - 1;
            intw.val = intw.val + 1;
        }
        if(i == 1)
            Dsortc.dsortc("SR", true, intw1.val, ad2, l, ad, j, ad1, k);
        Second.second(t1);
        arpack_timing.tngets.val = arpack_timing.tngets.val + (t1.val - t0.val);
        if(k1 > 0)
        {
            ivout_adapter(arpack_debug.logfil.val, 1, intw, arpack_debug.ndigit.val, "_ngets: KEV is");
            ivout_adapter(arpack_debug.logfil.val, 1, intw1, arpack_debug.ndigit.val, "_ngets: NP is");
            Dvout.dvout(arpack_debug.logfil.val, intw.val + intw1.val, ad, j, arpack_debug.ndigit.val, "_ngets: Eigenvalues of current H matrix -- real part");
            Dvout.dvout(arpack_debug.logfil.val, intw.val + intw1.val, ad1, k, arpack_debug.ndigit.val, "_ngets: Eigenvalues of current H matrix -- imag part");
            Dvout.dvout(arpack_debug.logfil.val, intw.val + intw1.val, ad2, l, arpack_debug.ndigit.val, "_ngets: Ritz estimates of the current KEV+NP Ritz values");
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

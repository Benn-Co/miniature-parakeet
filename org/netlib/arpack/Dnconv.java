package org.netlib.arpack;

import org.netlib.lapack.Dlamch;
import org.netlib.lapack.Dlapy2;
import org.netlib.util.floatW;
import org.netlib.util.intW;

public final class Dnconv
{
    public static void dnconv(int i, double ad[], int j, double ad1[], int k, double ad2[], int l, double d, intW intw)
    {
        int i1 = 0;
        double d3 = 0.0D;
        Second.second(t0);
        d3 = Dlamch.dlamch("Epsilon-Machine");
        d3 = Math.pow(d3, 2D / 3D);
        intw.val = 0;
        i1 = 1;
        for(int j1 = (i - 1) + 1; j1 > 0; j1--)
        {
            double d2 = Math.max(d3, Dlapy2.dlapy2(ad[(i1 - 1) + j], ad1[(i1 - 1) + k]));
            if(ad2[(i1 - 1) + l] <= d * d2)
                intw.val = intw.val + 1;
            i1++;
        }

        Second.second(t1);
        arpack_timing.tnconv.val = arpack_timing.tnconv.val + (t1.val - t0.val);
    }

    public static floatW t0 = new floatW(0.0F);
    public static floatW t1 = new floatW(0.0F);
    public static float t2 = 0.0F;
    public static float t3 = 0.0F;
    public static float t4 = 0.0F;
    public static float t5 = 0.0F;
}

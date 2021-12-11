package org.netlib.arpack;

import org.netlib.lapack.Dlamch;
import org.netlib.util.floatW;
import org.netlib.util.intW;

public final class Dsconv
{
    public static void dsconv(int i, double ad[], int j, double ad1[], int k, double d, intW intw)
    {
        int l = 0;
        double d3 = 0.0D;
        Second.second(t0);
        d3 = Dlamch.dlamch("Epsilon-Machine");
        d3 = Math.pow(d3, 2D / 3D);
        intw.val = 0;
        l = 1;
        for(int i1 = (i - 1) + 1; i1 > 0; i1--)
        {
            double d2 = Math.max(d3, Math.abs(ad[(l - 1) + j]));
            if(ad1[(l - 1) + k] <= d * d2)
                intw.val = intw.val + 1;
            l++;
        }

        Second.second(t1);
        arpack_timing.tsconv.val = arpack_timing.tsconv.val + (t1.val - t0.val);
    }

    public static floatW t0 = new floatW(0.0F);
    public static floatW t1 = new floatW(0.0F);
    public static float t2 = 0.0F;
    public static float t3 = 0.0F;
    public static float t4 = 0.0F;
    public static float t5 = 0.0F;
}

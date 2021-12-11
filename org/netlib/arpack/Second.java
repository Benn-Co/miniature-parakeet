package org.netlib.arpack;

import org.netlib.util.Etime;
import org.netlib.util.floatW;

public final class Second
{
    public static void second(floatW fw)
    {
        float af[] = new float[2];
        Etime.etime();
        Etime.etime(af, 0);
        fw.val = af[0];
    }
}

package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dsygst
{
    public static void dsygst(int i, String s, int j, double ad[], int k, int l, double ad1[], int i1, 
            int j1, intW intw)
    {
        boolean flag = false;
        int k3 = 0;
        intw.val = 0;
        flag = Lsame.lsame(s, "U");
        if((i < 1) || (i > 3))
            intw.val = -1;
        else
        if(flag ^ true && Lsame.lsame(s, "L") ^ true)
            intw.val = -2;
        else
        if(j < 0)
            intw.val = -3;
        else
        if(l < Math.max(1, j))
            intw.val = -5;
        else
        if(j1 < Math.max(1, j))
            intw.val = -7;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DSYGST", -intw.val);
            return;
        }
        if(j == 0)
            return;
        k3 = Ilaenv.ilaenv(1, "DSYGST", s, j, -1, -1, -1);
        if((k3 <= 1) || (k3 >= j))
            Dsygs2.dsygs2(i, s, j, ad, k, l, ad1, i1, j1, intw);
        else
        if(i == 1)
        {
            if(flag)
            {
                int k1 = 1;
                for(int l3 = ((j - 1) + k3) / k3; l3 > 0; l3--)
                {
                    int k2 = Math.min((j - k1) + 1, k3);
                    Dsygs2.dsygs2(i, s, k2, ad, (k1 - 1) + (k1 - 1) * l + k, l, ad1, (k1 - 1) + (k1 - 1) * j1 + i1, j1, intw);
                    if(k1 + k2 <= j)
                    {
                        Dtrsm.dtrsm("Left", s, "Transpose", "Non-unit", k2, (j - k1 - k2) + 1, 1.0D, ad1, (k1 - 1) + (k1 - 1) * j1 + i1, j1, ad, (k1 - 1) + ((k1 + k2) - 1) * l + k, l);
                        Dsymm.dsymm("Left", s, k2, (j - k1 - k2) + 1, -0.5D, ad, (k1 - 1) + (k1 - 1) * l + k, l, ad1, (k1 - 1) + ((k1 + k2) - 1) * j1 + i1, j1, 1.0D, ad, (k1 - 1) + ((k1 + k2) - 1) * l + k, l);
                        Dsyr2k.dsyr2k(s, "Transpose", (j - k1 - k2) + 1, k2, -1D, ad, (k1 - 1) + ((k1 + k2) - 1) * l + k, l, ad1, (k1 - 1) + ((k1 + k2) - 1) * j1 + i1, j1, 1.0D, ad, ((k1 + k2) - 1) + ((k1 + k2) - 1) * l + k, l);
                        Dsymm.dsymm("Left", s, k2, (j - k1 - k2) + 1, -0.5D, ad, (k1 - 1) + (k1 - 1) * l + k, l, ad1, (k1 - 1) + ((k1 + k2) - 1) * j1 + i1, j1, 1.0D, ad, (k1 - 1) + ((k1 + k2) - 1) * l + k, l);
                        Dtrsm.dtrsm("Right", s, "No transpose", "Non-unit", k2, (j - k1 - k2) + 1, 1.0D, ad1, ((k1 + k2) - 1) + ((k1 + k2) - 1) * j1 + i1, j1, ad, (k1 - 1) + ((k1 + k2) - 1) * l + k, l);
                    }
                    k1 += k3;
                }

            } else
            {
                int l1 = 1;
                for(int i4 = ((j - 1) + k3) / k3; i4 > 0; i4--)
                {
                    int l2 = Math.min((j - l1) + 1, k3);
                    Dsygs2.dsygs2(i, s, l2, ad, (l1 - 1) + (l1 - 1) * l + k, l, ad1, (l1 - 1) + (l1 - 1) * j1 + i1, j1, intw);
                    if(l1 + l2 <= j)
                    {
                        Dtrsm.dtrsm("Right", s, "Transpose", "Non-unit", (j - l1 - l2) + 1, l2, 1.0D, ad1, (l1 - 1) + (l1 - 1) * j1 + i1, j1, ad, ((l1 + l2) - 1) + (l1 - 1) * l + k, l);
                        Dsymm.dsymm("Right", s, (j - l1 - l2) + 1, l2, -0.5D, ad, (l1 - 1) + (l1 - 1) * l + k, l, ad1, ((l1 + l2) - 1) + (l1 - 1) * j1 + i1, j1, 1.0D, ad, ((l1 + l2) - 1) + (l1 - 1) * l + k, l);
                        Dsyr2k.dsyr2k(s, "No transpose", (j - l1 - l2) + 1, l2, -1D, ad, ((l1 + l2) - 1) + (l1 - 1) * l + k, l, ad1, ((l1 + l2) - 1) + (l1 - 1) * j1 + i1, j1, 1.0D, ad, ((l1 + l2) - 1) + ((l1 + l2) - 1) * l + k, l);
                        Dsymm.dsymm("Right", s, (j - l1 - l2) + 1, l2, -0.5D, ad, (l1 - 1) + (l1 - 1) * l + k, l, ad1, ((l1 + l2) - 1) + (l1 - 1) * j1 + i1, j1, 1.0D, ad, ((l1 + l2) - 1) + (l1 - 1) * l + k, l);
                        Dtrsm.dtrsm("Left", s, "No transpose", "Non-unit", (j - l1 - l2) + 1, l2, 1.0D, ad1, ((l1 + l2) - 1) + ((l1 + l2) - 1) * j1 + i1, j1, ad, ((l1 + l2) - 1) + (l1 - 1) * l + k, l);
                    }
                    l1 += k3;
                }

            }
        } else
        if(flag)
        {
            int i2 = 1;
            for(int j4 = ((j - 1) + k3) / k3; j4 > 0; j4--)
            {
                int i3 = Math.min((j - i2) + 1, k3);
                Dtrmm.dtrmm("Left", s, "No transpose", "Non-unit", i2 - 1, i3, 1.0D, ad1, i1, j1, ad, (i2 - 1) * l + k, l);
                Dsymm.dsymm("Right", s, i2 - 1, i3, 0.5D, ad, (i2 - 1) + (i2 - 1) * l + k, l, ad1, (i2 - 1) * j1 + i1, j1, 1.0D, ad, (i2 - 1) * l + k, l);
                Dsyr2k.dsyr2k(s, "No transpose", i2 - 1, i3, 1.0D, ad, (1 - 1) + (i2 - 1) * l + k, l, ad1, (i2 - 1) * j1 + i1, j1, 1.0D, ad, k, l);
                Dsymm.dsymm("Right", s, i2 - 1, i3, 0.5D, ad, (i2 - 1) + (i2 - 1) * l + k, l, ad1, (i2 - 1) * j1 + i1, j1, 1.0D, ad, (i2 - 1) * l + k, l);
                Dtrmm.dtrmm("Right", s, "Transpose", "Non-unit", i2 - 1, i3, 1.0D, ad1, (i2 - 1) + (i2 - 1) * j1 + i1, j1, ad, (i2 - 1) * l + k, l);
                Dsygs2.dsygs2(i, s, i3, ad, (i2 - 1) + (i2 - 1) * l + k, l, ad1, (i2 - 1) + (i2 - 1) * j1 + i1, j1, intw);
                i2 += k3;
            }

        } else
        {
            int j2 = 1;
            for(int k4 = ((j - 1) + k3) / k3; k4 > 0; k4--)
            {
                int j3 = Math.min((j - j2) + 1, k3);
                Dtrmm.dtrmm("Right", s, "No transpose", "Non-unit", j3, j2 - 1, 1.0D, ad1, i1, j1, ad, (j2 - 1) + (1 - 1) * l + k, l);
                Dsymm.dsymm("Left", s, j3, j2 - 1, 0.5D, ad, (j2 - 1) + (j2 - 1) * l + k, l, ad1, (j2 - 1) + (1 - 1) * j1 + i1, j1, 1.0D, ad, (j2 - 1) + (1 - 1) * l + k, l);
                Dsyr2k.dsyr2k(s, "Transpose", j2 - 1, j3, 1.0D, ad, (j2 - 1) + (1 - 1) * l + k, l, ad1, (j2 - 1) + (1 - 1) * j1 + i1, j1, 1.0D, ad, k, l);
                Dsymm.dsymm("Left", s, j3, j2 - 1, 0.5D, ad, (j2 - 1) + (j2 - 1) * l + k, l, ad1, (j2 - 1) + (1 - 1) * j1 + i1, j1, 1.0D, ad, (j2 - 1) + (1 - 1) * l + k, l);
                Dtrmm.dtrmm("Left", s, "Transpose", "Non-unit", j3, j2 - 1, 1.0D, ad1, (j2 - 1) + (j2 - 1) * j1 + i1, j1, ad, (j2 - 1) + (1 - 1) * l + k, l);
                Dsygs2.dsygs2(i, s, j3, ad, (j2 - 1) + (j2 - 1) * l + k, l, ad1, (j2 - 1) + (j2 - 1) * j1 + i1, j1, intw);
                j2 += k3;
            }

        }
    }
}

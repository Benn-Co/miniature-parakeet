package org.netlib.lapack;

import org.netlib.blas.Dtbsv;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dpbtrs
{
    public static void dpbtrs(String s, int i, int j, int k, double ad[], int l, int i1, double ad1[], 
            int j1, int k1, intW intw)
    {
        boolean flag = false;
        intw.val = 0;
        flag = Lsame.lsame(s, "U");
        if(flag ^ true && Lsame.lsame(s, "L") ^ true)
            intw.val = -1;
        else
        if(i < 0)
            intw.val = -2;
        else
        if(j < 0)
            intw.val = -3;
        else
        if(k < 0)
            intw.val = -4;
        else
        if(i1 < j + 1)
            intw.val = -6;
        else
        if(k1 < Math.max(1, i))
            intw.val = -8;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DPBTRS", -intw.val);
            return;
        }
        if((i == 0) || (k == 0))
            return;
        if(flag)
        {
            int l1 = 1;
            for(int j2 = (k - 1) + 1; j2 > 0; j2--)
            {
                Dtbsv.dtbsv("Upper", "Transpose", "Non-unit", i, j, ad, l, i1, ad1, (1 - 1) + (l1 - 1) * k1 + j1, 1);
                Dtbsv.dtbsv("Upper", "No transpose", "Non-unit", i, j, ad, l, i1, ad1, (1 - 1) + (l1 - 1) * k1 + j1, 1);
                l1++;
            }

        } else
        {
            int i2 = 1;
            for(int k2 = (k - 1) + 1; k2 > 0; k2--)
            {
                Dtbsv.dtbsv("Lower", "No transpose", "Non-unit", i, j, ad, l, i1, ad1, (1 - 1) + (i2 - 1) * k1 + j1, 1);
                Dtbsv.dtbsv("Lower", "Transpose", "Non-unit", i, j, ad, l, i1, ad1, (1 - 1) + (i2 - 1) * k1 + j1, 1);
                i2++;
            }

        }
    }
}

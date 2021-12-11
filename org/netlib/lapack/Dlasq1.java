package org.netlib.lapack;

import org.netlib.blas.Dcopy;
import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlasq1
{
    public static void dlasq1(int i, double ad[], int j, double ad1[], int k, double ad2[], int l, intW intw)
    {
        int i1 = 0;
        intW intw1 = new intW(0);
        double d = 0.0;
        double d1 = 0.0;
        double d2 = 0.0;
        doubleW doublew = new doubleW(0.0);
        doubleW doublew1 = new doubleW(0.0);
        intw.val = 0;
        if(i < 0)
        {
            intw.val = -2;
            Xerbla.xerbla("DLASQ1", -intw.val);
            return;
        }
        if(i == 0)
            return;
        if(i == 1)
        {
            ad[j] = Math.abs(ad[j]);
            return;
        }
        if(i == 2)
        {
            Dlas2.dlas2(ad[j], ad1[k], ad[1 + j], doublew, doublew1);
            ad[j] = doublew1.val;
            ad[1 + j] = doublew.val;
            return;
        }
        doublew1.val = 0.0;
        i1 = 1;
        for(int k1 = i - 1; k1 > 0; k1--)
        {
            ad[(i1 - 1) + j] = Math.abs(ad[(i1 - 1) + j]);
            doublew1.val = Math.max(doublew1.val, Math.abs(ad1[(i1 - 1) + k]));
            i1++;
        }

        ad[(i - 1) + j] = Math.abs(ad[(i - 1) + j]);
        if(doublew1.val == 0.0)
        {
            Dlasrt.dlasrt("D", i, ad, j, intw1);
            return;
        }
        i1 = 1;
        for(int l1 = (i - 1) + 1; l1 > 0; l1--)
        {
            doublew1.val = Math.max(doublew1.val, ad[(i1 - 1) + j]);
            i1++;
        }

        d = Dlamch.dlamch("Precision");
        d2 = Dlamch.dlamch("Safe minimum");
        d1 = Math.sqrt(d / d2);
        Dcopy.dcopy(i, ad, j, 1, ad2, l, 2);
        Dcopy.dcopy(i - 1, ad1, k, 1, ad2, 1 + l, 2);
        Dlascl.dlascl("G", 0, 0, doublew1.val, d1, 2 * i - 1, 1, ad2, l, 2 * i - 1, intw1);
        i1 = 1;
        for(int i2 = 2 * i - 1; i2 > 0; i2--)
        {
            ad2[(i1 - 1) + l] = Math.pow(ad2[(i1 - 1) + l], 2.0);
            i1++;
        }

        ad2[(2 * i - 1) + l] = 0.0;
        Dlasq2.dlasq2(i, ad2, l, intw);
        if(intw.val == 0)
        {
            int j1 = 1;
            for(int j2 = i; j2 > 0; j2--)
            {
                ad[(j1 - 1) + j] = Math.sqrt(ad2[(j1 - 1) + l]);
                j1++;
            }

            Dlascl.dlascl("G", 0, 0, d1, doublew1.val, i, 1, ad, j, i, intw1);
        }
    }
}

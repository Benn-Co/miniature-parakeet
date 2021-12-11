package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dsptrd
{
    public static void dsptrd(String s, int i, double ad[], int j, double ad1[], int k, double ad2[], int l, 
            double ad3[], int i1, intW intw)
    {
        boolean flag = false;
        doubleW doublew = new doubleW(0.0D);
        intw.val = 0;
        flag = Lsame.lsame(s, "U");
        if(flag ^ true && Lsame.lsame(s, "L") ^ true)
            intw.val = -1;
        else
        if(i < 0)
            intw.val = -2;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DSPTRD", -intw.val);
            return;
        }
        if(i <= 0)
            return;
        if(flag)
        {
            int l1 = (i * (i - 1)) / 2 + 1;
            int j1 = i - 1;
            for(int k2 = ((1 - (i - 1)) + -1) / -1; k2 > 0; k2--)
            {
                dlarfg_adapter(j1, ad, ((l1 + j1) - 1 - 1) + j, ad, (l1 - 1) + j, 1, doublew);
                ad2[(j1 - 1) + l] = ad[((l1 + j1) - 1 - 1) + j];
                if(doublew.val != 0.0D)
                {
                    ad[((l1 + j1) - 1 - 1) + j] = 1.0D;
                    Dspmv.dspmv(s, j1, doublew.val, ad, j, ad, (l1 - 1) + j, 1, 0.0D, ad3, i1, 1);
                    double d1 = -(0.5D * doublew.val * Ddot.ddot(j1, ad3, i1, 1, ad, (l1 - 1) + j, 1));
                    Daxpy.daxpy(j1, d1, ad, (l1 - 1) + j, 1, ad3, i1, 1);
                    Dspr2.dspr2(s, j1, -1D, ad, (l1 - 1) + j, 1, ad3, i1, 1, ad, j);
                    ad[((l1 + j1) - 1 - 1) + j] = ad2[(j1 - 1) + l];
                }
                ad1[((j1 + 1) - 1) + k] = ad[((l1 + j1) - 1) + j];
                ad3[(j1 - 1) + i1] = doublew.val;
                l1 -= j1;
                j1--;
            }

            ad1[(1 - 1) + k] = ad[(1 - 1) + j];
        } else
        {
            int j2 = 1;
            int k1 = 1;
            for(int l2 = (i - 1 - 1) + 1; l2 > 0; l2--)
            {
                int i2 = ((j2 + i) - k1) + 1;
                dlarfg_adapter(i - k1, ad, ((j2 + 1) - 1) + j, ad, ((j2 + 2) - 1) + j, 1, doublew);
                ad2[(k1 - 1) + l] = ad[((j2 + 1) - 1) + j];
                if(doublew.val != 0.0D)
                {
                    ad[((j2 + 1) - 1) + j] = 1.0D;
                    Dspmv.dspmv(s, i - k1, doublew.val, ad, (i2 - 1) + j, ad, ((j2 + 1) - 1) + j, 1, 0.0D, ad3, (k1 - 1) + i1, 1);
                    double d2 = -(0.5D * doublew.val * Ddot.ddot(i - k1, ad3, (k1 - 1) + i1, 1, ad, ((j2 + 1) - 1) + j, 1));
                    Daxpy.daxpy(i - k1, d2, ad, ((j2 + 1) - 1) + j, 1, ad3, (k1 - 1) + i1, 1);
                    Dspr2.dspr2(s, i - k1, -1D, ad, ((j2 + 1) - 1) + j, 1, ad3, (k1 - 1) + i1, 1, ad, (i2 - 1) + j);
                    ad[((j2 + 1) - 1) + j] = ad2[(k1 - 1) + l];
                }
                ad1[(k1 - 1) + k] = ad[(j2 - 1) + j];
                ad3[(k1 - 1) + i1] = doublew.val;
                j2 = i2;
                k1++;
            }

            ad1[(i - 1) + k] = ad[(j2 - 1) + j];
        }
    }

    private static void dlarfg_adapter(int i, double ad[], int j, double ad1[], int k, int l, doubleW doublew)
    {
        doubleW doublew1 = new doubleW(ad[j]);
        Dlarfg.dlarfg(i, doublew1, ad1, k, l, doublew);
        ad[j] = doublew1.val;
    }
}

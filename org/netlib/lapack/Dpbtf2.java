package org.netlib.lapack;

import org.netlib.blas.Dscal;
import org.netlib.blas.Dsyr;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dpbtf2
{
    public static void dpbtf2(String s, int i, int j, double ad[], int k, int l, intW intw)
    {
        int i1;
label0:
        {
            boolean flag = false;
            i1 = 0;
            int j1 = 0;
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
            if(l < j + 1)
                intw.val = -5;
            if(intw.val != 0)
            {
                Xerbla.xerbla("DPBTF2", -intw.val);
                return;
            }
            if(i == 0)
                return;
            j1 = Math.max(1, l - 1);
            if(flag)
            {
                i1 = 1;
                for(int i2 = (i - 1) + 1; i2 > 0; i2--)
                {
                    double d1 = ad[((j + 1) - 1) + (i1 - 1) * l + k];
                    if(d1 <= 0.0D)
                        break label0;
                    d1 = Math.sqrt(d1);
                    ad[((j + 1) - 1) + (i1 - 1) * l + k] = d1;
                    int k1 = Math.min(j, i - i1);
                    if(k1 > 0)
                    {
                        Dscal.dscal(k1, 1.0D / d1, ad, (j - 1) + ((i1 + 1) - 1) * l + k, j1);
                        Dsyr.dsyr("Upper", k1, -1D, ad, (j - 1) + ((i1 + 1) - 1) * l + k, j1, ad, ((j + 1) - 1) + ((i1 + 1) - 1) * l + k, j1);
                    }
                    i1++;
                }

            } else
            {
                i1 = 1;
                for(int j2 = (i - 1) + 1; j2 > 0; j2--)
                {
                    double d2 = ad[(1 - 1) + (i1 - 1) * l + k];
                    if(d2 <= 0.0D)
                        break label0;
                    d2 = Math.sqrt(d2);
                    ad[(1 - 1) + (i1 - 1) * l + k] = d2;
                    int l1 = Math.min(j, i - i1);
                    if(l1 > 0)
                    {
                        Dscal.dscal(l1, 1.0D / d2, ad, (2 - 1) + (i1 - 1) * l + k, 1);
                        Dsyr.dsyr("Lower", l1, -1D, ad, (2 - 1) + (i1 - 1) * l + k, 1, ad, ((i1 + 1) - 1) * l + k, j1);
                    }
                    i1++;
                }

            }
            return;
        }
        intw.val = i1;
    }
}

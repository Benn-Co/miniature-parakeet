package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dpptrf
{
    public static void dpptrf(String s, int i, double ad[], int j, intW intw)
    {
label0:
        {
            int k;
label1:
            {
                boolean flag = false;
                k = 0;
                int i1 = 0;
                intw.val = 0;
                flag = Lsame.lsame(s, "U");
                if(flag ^ true && Lsame.lsame(s, "L") ^ true)
                    intw.val = -1;
                else
                if(i < 0)
                    intw.val = -2;
                if(intw.val != 0)
                {
                    Xerbla.xerbla("DPPTRF", -intw.val);
                    return;
                }
                if(i == 0)
                    return;
                if(flag)
                {
                    i1 = 0;
                    k = 1;
                    for(int j1 = (i - 1) + 1; j1 > 0; j1--)
                    {
                        int l = i1 + 1;
                        i1 += k;
                        if(k > 1)
                            Dtpsv.dtpsv("Upper", "Transpose", "Non-unit", k - 1, ad, j, ad, (l - 1) + j, 1);
                        double d1 = ad[(i1 - 1) + j] - Ddot.ddot(k - 1, ad, (l - 1) + j, 1, ad, (l - 1) + j, 1);
                        if(d1 <= 0.0D)
                        {
                            ad[(i1 - 1) + j] = d1;
                            break label1;
                        }
                        ad[(i1 - 1) + j] = Math.sqrt(d1);
                        k++;
                    }

                    break label0;
                }
                i1 = 1;
                k = 1;
                for(int k1 = (i - 1) + 1; k1 > 0; k1--)
                {
                    double d2 = ad[(i1 - 1) + j];
                    if(d2 <= 0.0D)
                    {
                        ad[(i1 - 1) + j] = d2;
                        break label1;
                    }
                    d2 = Math.sqrt(d2);
                    ad[(i1 - 1) + j] = d2;
                    if(k < i)
                    {
                        Dscal.dscal(i - k, 1.0D / d2, ad, ((i1 + 1) - 1) + j, 1);
                        Dspr.dspr("Lower", i - k, -1D, ad, ((i1 + 1) - 1) + j, 1, ad, ((((i1 + i) - k) + 1) - 1) + j);
                        i1 = ((i1 + i) - k) + 1;
                    }
                    k++;
                }

                break label0;
            }
            intw.val = k;
        }
    }
}

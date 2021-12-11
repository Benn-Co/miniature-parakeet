package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dpotf2
{
    public static void dpotf2(String s, int i, double ad[], int j, int k, intW intw)
    {
label0:
        {
            int l;
label1:
            {
                boolean flag = false;
                l = 0;
                intw.val = 0;
                flag = Lsame.lsame(s, "U");
                if(flag ^ true && Lsame.lsame(s, "L") ^ true)
                    intw.val = -1;
                else
                if(i < 0)
                    intw.val = -2;
                else
                if(k < Math.max(1, i))
                    intw.val = -4;
                if(intw.val != 0)
                {
                    Xerbla.xerbla("DPOTF2", -intw.val);
                    return;
                }
                if(i == 0)
                    return;
                if(flag)
                {
                    l = 1;
                    for(int i1 = (i - 1) + 1; i1 > 0; i1--)
                    {
                        double d1 = ad[(l - 1) + (l - 1) * k + j] - Ddot.ddot(l - 1, ad, (l - 1) * k + j, 1, ad, (l - 1) * k + j, 1);
                        if(d1 <= 0.0D)
                        {
                            ad[(l - 1) + (l - 1) * k + j] = d1;
                            break label1;
                        }
                        d1 = Math.sqrt(d1);
                        ad[(l - 1) + (l - 1) * k + j] = d1;
                        if(l < i)
                        {
                            Dgemv.dgemv("Transpose", l - 1, i - l, -1D, ad, ((l + 1) - 1) * k + j, k, ad, (l - 1) * k + j, 1, 1.0D, ad, (l - 1) + ((l + 1) - 1) * k + j, k);
                            Dscal.dscal(i - l, 1.0D / d1, ad, (l - 1) + ((l + 1) - 1) * k + j, k);
                        }
                        l++;
                    }

                    break label0;
                }
                l = 1;
                for(int j1 = (i - 1) + 1; j1 > 0; j1--)
                {
                    double d2 = ad[(l - 1) + (l - 1) * k + j] - Ddot.ddot(l - 1, ad, (l - 1) + (1 - 1) * k + j, k, ad, (l - 1) + j, k);
                    if(d2 <= 0.0D)
                    {
                        ad[(l - 1) + (l - 1) * k + j] = d2;
                        break label1;
                    }
                    d2 = Math.sqrt(d2);
                    ad[(l - 1) + (l - 1) * k + j] = d2;
                    if(l < i)
                    {
                        Dgemv.dgemv("No transpose", i - l, l - 1, -1D, ad, ((l + 1) - 1) + j, k, ad, (l - 1) + j, k, 1.0D, ad, ((l + 1) - 1) + (l - 1) * k + j, 1);
                        Dscal.dscal(i - l, 1.0D / d2, ad, ((l + 1) - 1) + (l - 1) * k + j, 1);
                    }
                    l++;
                }

                break label0;
            }
            intw.val = l;
        }
    }
}

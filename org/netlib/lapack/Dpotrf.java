package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dpotrf
{
    public static void dpotrf(String s, int i, double ad[], int j, int k, intW intw)
    {
label0:
        {
            int l;
label1:
            {
                boolean flag = false;
                l = 0;
                int k1 = 0;
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
                    Xerbla.xerbla("DPOTRF", -intw.val);
                    return;
                }
                if(i == 0)
                    return;
                k1 = Ilaenv.ilaenv(1, "DPOTRF", s, i, -1, -1, -1);
                if((k1 <= 1) || (k1 >= i))
                {
                    Dpotf2.dpotf2(s, i, ad, j, k, intw);
                    break label0;
                }
                if(flag)
                {
                    l = 1;
                    for(int l1 = ((i - 1) + k1) / k1; l1 > 0; l1--)
                    {
                        int i1 = Math.min(k1, (i - l) + 1);
                        Dsyrk.dsyrk("Upper", "Transpose", i1, l - 1, -1D, ad, (1 - 1) + (l - 1) * k + j, k, 1.0D, ad, (l - 1) + (l - 1) * k + j, k);
                        Dpotf2.dpotf2("Upper", i1, ad, (l - 1) + (l - 1) * k + j, k, intw);
                        if(intw.val != 0)
                            break label1;
                        if(l + i1 <= i)
                        {
                            Dgemm.dgemm("Transpose", "No transpose", i1, (i - l - i1) + 1, l - 1, -1D, ad, (1 - 1) + (l - 1) * k + j, k, ad, (1 - 1) + ((l + i1) - 1) * k + j, k, 1.0D, ad, (l - 1) + ((l + i1) - 1) * k + j, k);
                            Dtrsm.dtrsm("Left", "Upper", "Transpose", "Non-unit", i1, (i - l - i1) + 1, 1.0D, ad, (l - 1) + (l - 1) * k + j, k, ad, (l - 1) + ((l + i1) - 1) * k + j, k);
                        }
                        l += k1;
                    }

                    break label0;
                }
                l = 1;
                for(int i2 = ((i - 1) + k1) / k1; i2 > 0; i2--)
                {
                    int j1 = Math.min(k1, (i - l) + 1);
                    Dsyrk.dsyrk("Lower", "No transpose", j1, l - 1, -1D, ad, (l - 1) + (1 - 1) * k + j, k, 1.0D, ad, (l - 1) + (l - 1) * k + j, k);
                    Dpotf2.dpotf2("Lower", j1, ad, (l - 1) + (l - 1) * k + j, k, intw);
                    if(intw.val != 0)
                        break label1;
                    if(l + j1 <= i)
                    {
                        Dgemm.dgemm("No transpose", "Transpose", (i - l - j1) + 1, j1, l - 1, -1D, ad, ((l + j1) - 1) + j, k, ad, (l - 1) + (1 - 1) * k + j, k, 1.0D, ad, ((l + j1) - 1) + (l - 1) * k + j, k);
                        Dtrsm.dtrsm("Right", "Lower", "Transpose", "Non-unit", (i - l - j1) + 1, j1, 1.0D, ad, (l - 1) + (l - 1) * k + j, k, ad, ((l + j1) - 1) + (l - 1) * k + j, k);
                    }
                    l += k1;
                }

                break label0;
            }
            intw.val = (intw.val + l) - 1;
        }
    }
}

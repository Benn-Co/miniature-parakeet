package org.netlib.lapack;

import org.netlib.blas.Dsyr2k;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dsytrd
{
    public static void dsytrd(String s, int i, double ad[], int j, int k, double ad1[], int l, double ad2[], 
            int i1, double ad3[], int j1, double ad4[], int k1, int l1, intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        intW intw1 = new intW(0);
        int k3 = 0;
        int l3 = 0;
        int i4 = 0;
        int k4 = 0;
        intw.val = 0;
        flag1 = Lsame.lsame(s, "U");
        flag = l1 == -1;
        if(flag1 ^ true && Lsame.lsame(s, "L") ^ true)
            intw.val = -1;
        else
        if(i < 0)
            intw.val = -2;
        else
        if(k < Math.max(1, i))
            intw.val = -4;
        else
        if((l1 < 1) && flag ^ true)
            intw.val = -9;
        if(intw.val == 0)
        {
            i4 = Ilaenv.ilaenv(1, "DSYTRD", s, i, -1, -1, -1);
            l3 = i * i4;
            ad4[(1 - 1) + k1] = l3;
        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DSYTRD", -intw.val);
            return;
        }
        if(flag)
            return;
        if(i == 0)
        {
            ad4[(1 - 1) + k1] = 1;
            return;
        }
        k4 = i;
        if((i4 > 1) && (i4 < i))
        {
            k4 = Math.max(i4, Ilaenv.ilaenv(3, "DSYTRD", s, i, -1, -1, -1));
            if(k4 < i)
            {
                k3 = i;
                int k2 = k3 * i4;
                if(l1 < k2)
                {
                    i4 = Math.max(l1 / k3, 1);
                    int j4 = Ilaenv.ilaenv(2, "DSYTRD", s, i, -1, -1, -1);
                    if(i4 < j4)
                        k4 = i;
                }
            } else
            {
                k4 = i;
            }
        } else
        {
            i4 = 1;
        }
        if(flag1)
        {
            int j3 = i - ((((i - k4) + i4) - 1) / i4) * i4;
            int i2 = (i - i4) + 1;
            for(int l4 = (((j3 + 1) - ((i - i4) + 1)) + -i4) / -i4; l4 > 0; l4--)
            {
                Dlatrd.dlatrd(s, (i2 + i4) - 1, i4, ad, j, k, ad2, i1, ad3, j1, ad4, k1, k3);
                Dsyr2k.dsyr2k(s, "No transpose", i2 - 1, i4, -1D, ad, (1 - 1) + (i2 - 1) * k + j, k, ad4, k1, k3, 1.0D, ad, j, k);
                int l2 = i2;
                for(int j5 = ((i2 + i4) - 1 - i2) + 1; j5 > 0; j5--)
                {
                    ad[(l2 - 2) + (l2 - 1) * k + j] = ad2[(l2 - 2) + i1];
                    ad1[(l2 - 1) + l] = ad[(l2 - 1) + (l2 - 1) * k + j];
                    l2++;
                }

                i2 += -i4;
            }

            Dsytd2.dsytd2(s, j3, ad, j, k, ad1, l, ad2, i1, ad3, j1, intw1);
        } else
        {
            int j2 = 1;
            for(int i5 = ((i - k4 - 1) + i4) / i4; i5 > 0; i5--)
            {
                Dlatrd.dlatrd(s, (i - j2) + 1, i4, ad, (j2 - 1) + (j2 - 1) * k + j, k, ad2, (j2 - 1) + i1, ad3, (j2 - 1) + j1, ad4, k1, k3);
                Dsyr2k.dsyr2k(s, "No transpose", (i - j2 - i4) + 1, i4, -1D, ad, ((j2 + i4) - 1) + (j2 - 1) * k + j, k, ad4, ((i4 + 1) - 1) + k1, k3, 1.0D, ad, ((j2 + i4) - 1) + ((j2 + i4) - 1) * k + j, k);
                int i3 = j2;
                for(int k5 = ((j2 + i4) - 1 - j2) + 1; k5 > 0; k5--)
                {
                    ad[((i3 + 1) - 1) + (i3 - 1) * k + j] = ad2[(i3 - 1) + i1];
                    ad1[(i3 - 1) + l] = ad[(i3 - 1) + (i3 - 1) * k + j];
                    i3++;
                }

                j2 += i4;
            }

            Dsytd2.dsytd2(s, (i - j2) + 1, ad, (j2 - 1) + (j2 - 1) * k + j, k, ad1, (j2 - 1) + l, ad2, (j2 - 1) + i1, ad3, (j2 - 1) + j1, intw1);
        }
        ad4[k1] = l3;
    }
}

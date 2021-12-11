package org.netlib.lapack;

import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dhseqr {
    public static void dhseqr(String s, String s1, int i, int j, int k, double ad[], int l, int i1,
            double ad1[], int j1, double ad2[], int k1, double ad3[], int l1, int i2,
            double ad4[], int j2, int k2, intW intw)
    {
        double ad5[] = new double[49 * 49];
        double ad6[] = new double[49];
        int l2 = 0;
        int j3 = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        flag3 = Lsame.lsame(s, "S");
        flag1 = Lsame.lsame(s1, "I");
        flag4 = flag1 || Lsame.lsame(s1, "V");
        ad4[(1 - 1) + j2] = Math.max(1, i);
        flag2 = k2 == -1;
        intw.val = 0;
        if(Lsame.lsame(s, "E") ^ true && flag3 ^ true)
            intw.val = -1;
        else
        if(Lsame.lsame(s1, "N") ^ true && flag4 ^ true)
            intw.val = -2;
        else
        if(i < 0)
            intw.val = -3;
        else
        if((j < 1) || (j > Math.max(1, i)))
            intw.val = -4;
        else
        if((k < Math.min(j, i)) || (k > i))
            intw.val = -5;
        else
        if(i1 < Math.max(1, i))
            intw.val = -7;
        else
        if((i2 < 1) || (flag4 && (i2 < Math.max(1, i))))
            intw.val = -11;
        else
        if((k2 < Math.max(1, i)) && flag2 ^ true)
            intw.val = -13;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DHSEQR", -intw.val);
            return;
        }
        if(i == 0)
            return;
        if(flag2)
        {
            Dlaqr0.dlaqr0(flag3, flag4, i, j, k, ad, l, i1, ad1, j1, ad2, k1, j, k, ad3, l1, i2, ad4, j2, k2, intw);
            ad4[(1 - 1) + j2] = Math.max(Math.max(1, i), ad4[(1 - 1) + j2]);
            return;
        }
        l2 = 1;
        for(int k3 = (j - 1 - 1) + 1; k3 > 0; k3--)
        {
            ad1[(l2 - 1) + j1] = ad[(l2 - 1) + (l2 - 1) * i1 + l];
            ad2[(l2 - 1) + k1] = 0.0D;
            l2++;
        }

        l2 = k + 1;
        for(int l3 = (i - (k + 1)) + 1; l3 > 0; l3--)
        {
            ad1[(l2 - 1) + j1] = ad[(l2 - 1) + (l2 - 1) * i1 + l];
            ad2[(l2 - 1) + k1] = 0.0D;
            l2++;
        }

        if(flag1)
            Dlaset.dlaset("A", i, i, 0.0D, 1.0D, ad3, l1, i2);
        if(j == k)
        {
            ad1[(j - 1) + j1] = ad[(j - 1) + (j - 1) * i1 + l];
            ad2[(j - 1) + k1] = 0.0D;
            return;
        }
        j3 = Ilaenv.ilaenv(12, "DHSEQR", s.substring(1 + -1, 1) + s1.substring(1 + -1, 1), i, j, k, k2);
        j3 = Math.max(11, j3);
        if(i > j3)
        {
            Dlaqr0.dlaqr0(flag3, flag4, i, j, k, ad, l, i1, ad1, j1, ad2, k1, j, k, ad3, l1, i2, ad4, j2, k2, intw);
        } else
        {
            Dlahqr.dlahqr(flag3, flag4, i, j, k, ad, l, i1, ad1, j1, ad2, k1, j, k, ad3, l1, i2, intw);
            if(intw.val > 0)
            {
                int i3 = intw.val;
                if(i >= 49)
                {
                    Dlaqr0.dlaqr0(flag3, flag4, i, j, i3, ad, l, i1, ad1, j1, ad2, k1, j, k, ad3, l1, i2, ad4, j2, k2, intw);
                } else
                {
                    Dlacpy.dlacpy("A", i, i, ad, l, i1, ad5, 0, 49);
                    ad5[((i + 1) - 1) + (i - 1) * 49] = 0.0D;
                    Dlaset.dlaset("A", 49, 49 - i, 0.0D, 0.0D, ad5, (1 - 1) + ((i + 1) - 1) * 49, 49);
                    Dlaqr0.dlaqr0(flag3, flag4, 49, j, i3, ad5, 0, 49, ad1, j1, ad2, k1, j, k, ad3, l1, i2, ad6, 0, 49, intw);
                    if(flag3 || (intw.val != 0))
                        Dlacpy.dlacpy("A", i, i, ad5, 0, 49, ad, l, i1);
                }
            }
        }
        if((flag3 || (intw.val != 0)) && (i > 2))
            Dlaset.dlaset("L", i - 2, i - 2, 0.0D, 0.0D, ad, (3 - 1) + (1 - 1) * i1 + l, i1);
        ad4[(1 - 1) + j2] = Math.max(Math.max(1, i), ad4[(1 - 1) + j2]);
    }
}

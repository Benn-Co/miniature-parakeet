package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;

public final class Dlarzb
{
    public static void dlarzb(String s, String s1, String s2, String s3, int i, int j, int k, int l, 
            double ad[], int i1, int j1, double ad1[], int k1, int l1, double ad2[], 
            int i2, int j2, double ad3[], int k2, int l2)
    {
        String s4 = new String(" ");
        byte byte0 = 0;
        if((i <= 0) || (j <= 0))
            return;
        byte0 = 0;
        if(Lsame.lsame(s2, "B") ^ true)
            byte0 = -3;
        else
        if(Lsame.lsame(s3, "R") ^ true)
            byte0 = -4;
        if(byte0 != 0)
        {
            Xerbla.xerbla("DLARZB", -byte0);
            return;
        }
        if(Lsame.lsame(s1, "N"))
            s4 = "T";
        else
            s4 = "N";
        if(Lsame.lsame(s, "L"))
        {
            int k3 = 1;
            for(int i4 = (k - 1) + 1; i4 > 0; i4--)
            {
                Dcopy.dcopy(j, ad2, (k3 - 1) + i2, j2, ad3, (k3 - 1) * l2 + k2, 1);
                k3++;
            }

            if(l > 0)
                Dgemm.dgemm("Transpose", "Transpose", j, k, l, 1.0D, ad2, (((i - l) + 1) - 1) + i2, j2, ad, i1, j1, 1.0D, ad3, k2, l2);
            Dtrmm.dtrmm("Right", "Lower", s4, "Non-unit", j, k, 1.0D, ad1, k1, l1, ad3, k2, l2);
            k3 = 1;
            for(int j4 = (j - 1) + 1; j4 > 0; j4--)
            {
                int i3 = 1;
                for(int i5 = (k - 1) + 1; i5 > 0; i5--)
                {
                    ad2[(i3 - 1) + (k3 - 1) * j2 + i2] = ad2[(i3 - 1) + (k3 - 1) * j2 + i2] - ad3[(k3 - 1) + (i3 - 1) * l2 + k2];
                    i3++;
                }

                k3++;
            }

            if(l > 0)
                Dgemm.dgemm("Transpose", "Transpose", l, j, k, -1D, ad, i1, j1, ad3, k2, l2, 1.0D, ad2, (((i - l) + 1) - 1) + i2, j2);
        } else
        if(Lsame.lsame(s, "R"))
        {
            int l3 = 1;
            for(int k4 = (k - 1) + 1; k4 > 0; k4--)
            {
                Dcopy.dcopy(i, ad2, (1 - 1) + (l3 - 1) * j2 + i2, 1, ad3, (l3 - 1) * l2 + k2, 1);
                l3++;
            }

            if(l > 0)
                Dgemm.dgemm("No transpose", "Transpose", i, k, l, 1.0D, ad2, (((j - l) + 1) - 1) * j2 + i2, j2, ad, i1, j1, 1.0D, ad3, k2, l2);
            Dtrmm.dtrmm("Right", "Lower", s1, "Non-unit", i, k, 1.0D, ad1, k1, l1, ad3, k2, l2);
            l3 = 1;
            for(int l4 = (k - 1) + 1; l4 > 0; l4--)
            {
                int j3 = 1;
                for(int j5 = (i - 1) + 1; j5 > 0; j5--)
                {
                    ad2[(j3 - 1) + (l3 - 1) * j2 + i2] = ad2[(j3 - 1) + (l3 - 1) * j2 + i2] - ad3[(j3 - 1) + (l3 - 1) * l2 + k2];
                    j3++;
                }

                l3++;
            }

            if(l > 0)
                Dgemm.dgemm("No transpose", "No transpose", i, l, k, -1D, ad3, k2, l2, ad, i1, j1, 1.0D, ad2, (1 - 1) + (((j - l) + 1) - 1) * j2 + i2, j2);
        }
    }
}

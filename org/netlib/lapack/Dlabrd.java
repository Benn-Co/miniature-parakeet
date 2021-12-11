package org.netlib.lapack;

import org.netlib.blas.Dgemv;
import org.netlib.blas.Dscal;
import org.netlib.util.doubleW;

public final class Dlabrd
{
    public static void dlabrd(int i, int j, int k, double ad[], int l, int i1, double ad1[], int j1, 
            double ad2[], int k1, double ad3[], int l1, double ad4[], int i2, double ad5[], 
            int j2, int k2, double ad6[], int l2, int i3)
    {
        if((i <= 0) || (j <= 0))
            return;
        if(i >= j)
        {
            int j3 = 1;
            for(int l3 = (k - 1) + 1; l3 > 0; l3--)
            {
                Dgemv.dgemv("No transpose", (i - j3) + 1, j3 - 1, -1D, ad, (j3 - 1) + (1 - 1) * i1 + l, i1, ad6, (j3 - 1) + (1 - 1) * i3 + l2, i3, 1.0D, ad, (j3 - 1) + (j3 - 1) * i1 + l, 1);
                Dgemv.dgemv("No transpose", (i - j3) + 1, j3 - 1, -1D, ad5, (j3 - 1) + (1 - 1) * k2 + j2, k2, ad, (1 - 1) + (j3 - 1) * i1 + l, 1, 1.0D, ad, (j3 - 1) + (j3 - 1) * i1 + l, 1);
                dlarfg_adapter((i - j3) + 1, ad, (j3 - 1) + (j3 - 1) * i1 + l, ad, (Math.min(j3 + 1, i) - 1) + (j3 - 1) * i1 + l, 1, ad3, (j3 - 1) + l1);
                ad1[(j3 - 1) + j1] = ad[(j3 - 1) + (j3 - 1) * i1 + l];
                if(j3 < j)
                {
                    ad[(j3 - 1) + (j3 - 1) * i1 + l] = 1.0D;
                    Dgemv.dgemv("Transpose", (i - j3) + 1, j - j3, 1.0D, ad, (j3 - 1) + ((j3 + 1) - 1) * i1 + l, i1, ad, (j3 - 1) + (j3 - 1) * i1 + l, 1, 0.0D, ad6, ((j3 + 1) - 1) + (j3 - 1) * i3 + l2, 1);
                    Dgemv.dgemv("Transpose", (i - j3) + 1, j3 - 1, 1.0D, ad, (j3 - 1) + (1 - 1) * i1 + l, i1, ad, (j3 - 1) + (j3 - 1) * i1 + l, 1, 0.0D, ad6, (1 - 1) + (j3 - 1) * i3 + l2, 1);
                    Dgemv.dgemv("No transpose", j - j3, j3 - 1, -1D, ad6, ((j3 + 1) - 1) + (1 - 1) * i3 + l2, i3, ad6, (1 - 1) + (j3 - 1) * i3 + l2, 1, 1.0D, ad6, ((j3 + 1) - 1) + (j3 - 1) * i3 + l2, 1);
                    Dgemv.dgemv("Transpose", (i - j3) + 1, j3 - 1, 1.0D, ad5, (j3 - 1) + (1 - 1) * k2 + j2, k2, ad, (j3 - 1) + (j3 - 1) * i1 + l, 1, 0.0D, ad6, (1 - 1) + (j3 - 1) * i3 + l2, 1);
                    Dgemv.dgemv("Transpose", j3 - 1, j - j3, -1D, ad, (1 - 1) + ((j3 + 1) - 1) * i1 + l, i1, ad6, (1 - 1) + (j3 - 1) * i3 + l2, 1, 1.0D, ad6, ((j3 + 1) - 1) + (j3 - 1) * i3 + l2, 1);
                    Dscal.dscal(j - j3, ad3[(j3 - 1) + l1], ad6, ((j3 + 1) - 1) + (j3 - 1) * i3 + l2, 1);
                    Dgemv.dgemv("No transpose", j - j3, j3, -1D, ad6, ((j3 + 1) - 1) + (1 - 1) * i3 + l2, i3, ad, (j3 - 1) + (1 - 1) * i1 + l, i1, 1.0D, ad, (j3 - 1) + ((j3 + 1) - 1) * i1 + l, i1);
                    Dgemv.dgemv("Transpose", j3 - 1, j - j3, -1D, ad, (1 - 1) + ((j3 + 1) - 1) * i1 + l, i1, ad5, (j3 - 1) + (1 - 1) * k2 + j2, k2, 1.0D, ad, (j3 - 1) + ((j3 + 1) - 1) * i1 + l, i1);
                    dlarfg_adapter(j - j3, ad, (j3 - 1) + ((j3 + 1) - 1) * i1 + l, ad, (j3 - 1) + (Math.min(j3 + 2, j) - 1) * i1 + l, i1, ad4, (j3 - 1) + i2);
                    ad2[(j3 - 1) + k1] = ad[(j3 - 1) + ((j3 + 1) - 1) * i1 + l];
                    ad[(j3 - 1) + ((j3 + 1) - 1) * i1 + l] = 1.0D;
                    Dgemv.dgemv("No transpose", i - j3, j - j3, 1.0D, ad, ((j3 + 1) - 1) + ((j3 + 1) - 1) * i1 + l, i1, ad, (j3 - 1) + ((j3 + 1) - 1) * i1 + l, i1, 0.0D, ad5, ((j3 + 1) - 1) + (j3 - 1) * k2 + j2, 1);
                    Dgemv.dgemv("Transpose", j - j3, j3, 1.0D, ad6, ((j3 + 1) - 1) + (1 - 1) * i3 + l2, i3, ad, (j3 - 1) + ((j3 + 1) - 1) * i1 + l, i1, 0.0D, ad5, (1 - 1) + (j3 - 1) * k2 + j2, 1);
                    Dgemv.dgemv("No transpose", i - j3, j3, -1D, ad, ((j3 + 1) - 1) + (1 - 1) * i1 + l, i1, ad5, (1 - 1) + (j3 - 1) * k2 + j2, 1, 1.0D, ad5, ((j3 + 1) - 1) + (j3 - 1) * k2 + j2, 1);
                    Dgemv.dgemv("No transpose", j3 - 1, j - j3, 1.0D, ad, (1 - 1) + ((j3 + 1) - 1) * i1 + l, i1, ad, (j3 - 1) + ((j3 + 1) - 1) * i1 + l, i1, 0.0D, ad5, (1 - 1) + (j3 - 1) * k2 + j2, 1);
                    Dgemv.dgemv("No transpose", i - j3, j3 - 1, -1D, ad5, ((j3 + 1) - 1) + (1 - 1) * k2 + j2, k2, ad5, (1 - 1) + (j3 - 1) * k2 + j2, 1, 1.0D, ad5, ((j3 + 1) - 1) + (j3 - 1) * k2 + j2, 1);
                    Dscal.dscal(i - j3, ad4[(j3 - 1) + i2], ad5, ((j3 + 1) - 1) + (j3 - 1) * k2 + j2, 1);
                }
                j3++;
            }

        } else
        {
            int k3 = 1;
            for(int i4 = (k - 1) + 1; i4 > 0; i4--)
            {
                Dgemv.dgemv("No transpose", (j - k3) + 1, k3 - 1, -1D, ad6, (k3 - 1) + (1 - 1) * i3 + l2, i3, ad, (k3 - 1) + (1 - 1) * i1 + l, i1, 1.0D, ad, (k3 - 1) + (k3 - 1) * i1 + l, i1);
                Dgemv.dgemv("Transpose", k3 - 1, (j - k3) + 1, -1D, ad, (1 - 1) + (k3 - 1) * i1 + l, i1, ad5, (k3 - 1) + (1 - 1) * k2 + j2, k2, 1.0D, ad, (k3 - 1) + (k3 - 1) * i1 + l, i1);
                dlarfg_adapter((j - k3) + 1, ad, (k3 - 1) + (k3 - 1) * i1 + l, ad, (k3 - 1) + (Math.min(k3 + 1, j) - 1) * i1 + l, i1, ad4, (k3 - 1) + i2);
                ad1[(k3 - 1) + j1] = ad[(k3 - 1) + (k3 - 1) * i1 + l];
                if(k3 < i)
                {
                    ad[(k3 - 1) + (k3 - 1) * i1 + l] = 1.0D;
                    Dgemv.dgemv("No transpose", i - k3, (j - k3) + 1, 1.0D, ad, ((k3 + 1) - 1) + (k3 - 1) * i1 + l, i1, ad, (k3 - 1) + (k3 - 1) * i1 + l, i1, 0.0D, ad5, ((k3 + 1) - 1) + (k3 - 1) * k2 + j2, 1);
                    Dgemv.dgemv("Transpose", (j - k3) + 1, k3 - 1, 1.0D, ad6, (k3 - 1) + (1 - 1) * i3 + l2, i3, ad, (k3 - 1) + (k3 - 1) * i1 + l, i1, 0.0D, ad5, (1 - 1) + (k3 - 1) * k2 + j2, 1);
                    Dgemv.dgemv("No transpose", i - k3, k3 - 1, -1D, ad, ((k3 + 1) - 1) + (1 - 1) * i1 + l, i1, ad5, (1 - 1) + (k3 - 1) * k2 + j2, 1, 1.0D, ad5, ((k3 + 1) - 1) + (k3 - 1) * k2 + j2, 1);
                    Dgemv.dgemv("No transpose", k3 - 1, (j - k3) + 1, 1.0D, ad, (1 - 1) + (k3 - 1) * i1 + l, i1, ad, (k3 - 1) + (k3 - 1) * i1 + l, i1, 0.0D, ad5, (1 - 1) + (k3 - 1) * k2 + j2, 1);
                    Dgemv.dgemv("No transpose", i - k3, k3 - 1, -1D, ad5, ((k3 + 1) - 1) + (1 - 1) * k2 + j2, k2, ad5, (1 - 1) + (k3 - 1) * k2 + j2, 1, 1.0D, ad5, ((k3 + 1) - 1) + (k3 - 1) * k2 + j2, 1);
                    Dscal.dscal(i - k3, ad4[(k3 - 1) + i2], ad5, ((k3 + 1) - 1) + (k3 - 1) * k2 + j2, 1);
                    Dgemv.dgemv("No transpose", i - k3, k3 - 1, -1D, ad, ((k3 + 1) - 1) + (1 - 1) * i1 + l, i1, ad6, (k3 - 1) + (1 - 1) * i3 + l2, i3, 1.0D, ad, ((k3 + 1) - 1) + (k3 - 1) * i1 + l, 1);
                    Dgemv.dgemv("No transpose", i - k3, k3, -1D, ad5, ((k3 + 1) - 1) + (1 - 1) * k2 + j2, k2, ad, (1 - 1) + (k3 - 1) * i1 + l, 1, 1.0D, ad, ((k3 + 1) - 1) + (k3 - 1) * i1 + l, 1);
                    dlarfg_adapter(i - k3, ad, ((k3 + 1) - 1) + (k3 - 1) * i1 + l, ad, (Math.min(k3 + 2, i) - 1) + (k3 - 1) * i1 + l, 1, ad3, (k3 - 1) + l1);
                    ad2[(k3 - 1) + k1] = ad[((k3 + 1) - 1) + (k3 - 1) * i1 + l];
                    ad[((k3 + 1) - 1) + (k3 - 1) * i1 + l] = 1.0D;
                    Dgemv.dgemv("Transpose", i - k3, j - k3, 1.0D, ad, ((k3 + 1) - 1) + ((k3 + 1) - 1) * i1 + l, i1, ad, ((k3 + 1) - 1) + (k3 - 1) * i1 + l, 1, 0.0D, ad6, ((k3 + 1) - 1) + (k3 - 1) * i3 + l2, 1);
                    Dgemv.dgemv("Transpose", i - k3, k3 - 1, 1.0D, ad, ((k3 + 1) - 1) + (1 - 1) * i1 + l, i1, ad, ((k3 + 1) - 1) + (k3 - 1) * i1 + l, 1, 0.0D, ad6, (1 - 1) + (k3 - 1) * i3 + l2, 1);
                    Dgemv.dgemv("No transpose", j - k3, k3 - 1, -1D, ad6, ((k3 + 1) - 1) + (1 - 1) * i3 + l2, i3, ad6, (1 - 1) + (k3 - 1) * i3 + l2, 1, 1.0D, ad6, ((k3 + 1) - 1) + (k3 - 1) * i3 + l2, 1);
                    Dgemv.dgemv("Transpose", i - k3, k3, 1.0D, ad5, ((k3 + 1) - 1) + (1 - 1) * k2 + j2, k2, ad, ((k3 + 1) - 1) + (k3 - 1) * i1 + l, 1, 0.0D, ad6, (1 - 1) + (k3 - 1) * i3 + l2, 1);
                    Dgemv.dgemv("Transpose", k3, j - k3, -1D, ad, (1 - 1) + ((k3 + 1) - 1) * i1 + l, i1, ad6, (1 - 1) + (k3 - 1) * i3 + l2, 1, 1.0D, ad6, ((k3 + 1) - 1) + (k3 - 1) * i3 + l2, 1);
                    Dscal.dscal(j - k3, ad3[(k3 - 1) + l1], ad6, ((k3 + 1) - 1) + (k3 - 1) * i3 + l2, 1);
                }
                k3++;
            }

        }
    }

    private static void dlarfg_adapter(int i, double ad[], int j, double ad1[], int k, int l, double ad2[], int i1)
    {
        doubleW doublew = new doubleW(ad[j]);
        doubleW doublew1 = new doubleW(ad2[i1]);
        Dlarfg.dlarfg(i, doublew, ad1, k, l, doublew1);
        ad[j] = doublew.val;
        ad2[i1] = doublew1.val;
    }
}

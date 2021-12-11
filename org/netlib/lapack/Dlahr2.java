package org.netlib.lapack;

import org.netlib.blas.Daxpy;
import org.netlib.blas.Dcopy;
import org.netlib.blas.Dgemm;
import org.netlib.blas.Dgemv;
import org.netlib.blas.Dscal;
import org.netlib.blas.Dtrmm;
import org.netlib.blas.Dtrmv;
import org.netlib.util.doubleW;

public final class Dlahr2 {

    public static void dlahr2(int i, int j, int k, double[] ad, int l, int i1, double[] ad1, int j1, double[] ad2,
            int k1, int l1, double[] ad3, int i2, int j2) {

        if (i <= 1) {
            return;
        }

        int k2 = 1;
        double d = 0.0;

        for (int l2 = k; l2 > 0; l2--) {
            if (k2 > 1) {
                Dgemv.dgemv("NO TRANSPOSE", i - j, k2 - 1, -1.0, ad3, j + i2, j2, ad, ((j + k2) - 2) + l, i1, 1.0, ad,
                        j + (k2 - 1) * i1 + l, 1);

                Dcopy.dcopy(k2 - 1, ad, j + (k2 - 1) * i1 + l, 1, ad2, (k - 1) * l1 + k1, 1);

                Dtrmv.dtrmv("Lower", "Transpose", "UNIT", k2 - 1, ad, j + l, i1, ad2, (k - 1) * l1 + k1, 1);

                Dgemv.dgemv("Transpose", (i - j - k2) + 1, k2 - 1, 1.0, ad, ((j + k2) - 1) + l, i1, ad,
                        ((j + k2) - 1) + (k2 - 1) * i1 + l, 1, 1.0, ad2, (k - 1) * l1 + k1, 1);

                Dtrmv.dtrmv("Upper", "Transpose", "NON-UNIT", k2 - 1, ad2, k1, l1, ad2, (k - 1) * l1 + k1, 1);

                Dgemv.dgemv("NO TRANSPOSE", (i - j - k2) + 1, k2 - 1, -1.0, ad, ((j + k2) - 1) + l, i1, ad2,
                        (k - 1) * l1 + k1, 1, 1.0, ad, ((j + k2) - 1) + (k2 - 1) * i1 + l, 1);

                Dtrmv.dtrmv("Lower", "NO TRANSPOSE", "UNIT", k2 - 1, ad, j + l, i1, ad2, (k - 1) * l1 + k1, 1);

                Daxpy.daxpy(k2 - 1, -1.0, ad2, (k - 1) * l1 + k1, 1, ad, j + (k2 - 1) * i1 + l, 1);

                ad[(j + k2 - 2) + (k2 - 2) * i1 + l] = d;
            }
            dlarfg_adapter(i - j - k2 + 1, ad, (j + k2 - 1) + (k2 - 1) * i1 + l, ad,
                    (Math.min(j + k2 + 1, i) - 1) + (k2 - 1) * i1 + l, 1, ad1, (k2 - 1) + j1);

            d = ad[(j + k2 - 1) + (k2 - 1) * i1 + l];

            ad[(j + k2 - 1) + (k2 - 1) * i1 + l] = 1.0;

            Dgemv.dgemv("NO TRANSPOSE", i - j, (i - j - k2) + 1, 1.0, ad, j + k2 * i1 + l, i1, ad,
                    (j + k2 - 1) + (k2 - 1) * i1 + l, 1, 0.0, ad3, j + (k2 - 1) * j2 + i2, 1);

            Dgemv.dgemv("Transpose", (i - j - k2) + 1, k2 - 1, 1.0, ad, (j + k2 - 1) + l, i1, ad,
                    (j + k2 - 1) + (k2 - 1) * i1 + l, 1, 0.0, ad2, (k2 - 1) * l1 + k1, 1);

            Dgemv.dgemv("NO TRANSPOSE", i - j, k2 - 1, -1.0, ad3, j + i2, j2, ad2, (k2 - 1) * l1 + k1, 1, 1.0, ad3,
                    j + (k2 - 1) * j2 + i2, 1);

            Dscal.dscal(i - j, ad1[k2 - 1 + j1], ad3, j + (k2 - 1) * j2 + i2, 1);

            Dscal.dscal(k2 - 1, -ad1[k2 - 1 + j1], ad2, (k2 - 1) * l1 + k1, 1);

            Dtrmv.dtrmv("Upper", "No Transpose", "NON-UNIT", k2 - 1, ad2, k1, l1, ad2, (k2 - 1) * l1 + k1, 1);

            ad2[(k2 - 1) + (k2 - 1) * l1 + k1] = ad1[k2 - 1 + j1];
            k2++;
        }

        ad[(j + k - 1) + (k - 1) * i1 + l] = d;
        Dlacpy.dlacpy("ALL", j, k, ad, i1 + l, i1, ad3, i2, j2);
        Dtrmm.dtrmm("RIGHT", "Lower", "NO TRANSPOSE", "UNIT", j, k, 1.0, ad, j + l, i1, ad3, i2, j2);

        if (i > j + k) {
            Dgemm.dgemm("NO TRANSPOSE", "NO TRANSPOSE", j, k, i - j - k, 1.0, ad, (1 + k) * i1 + l, i1, ad, j + k + l,
                    i1, 1.0, ad3, i2, j2);
        }
        Dtrmm.dtrmm("RIGHT", "Upper", "NO TRANSPOSE", "NON-UNIT", j, k, 1.0, ad2, k1, l1, ad3, i2, j2);
    }

    private static void dlarfg_adapter(int i, double[] ad, int j, double[] ad1, int k, int l, double[] ad2, int i1) {
        doubleW doublew = new doubleW(ad[j]);
        doubleW doublew1 = new doubleW(ad2[i1]);
        Dlarfg.dlarfg(i, doublew, ad1, k, l, doublew1);
        ad[j] = doublew.val;
        ad2[i1] = doublew1.val;
    }
}

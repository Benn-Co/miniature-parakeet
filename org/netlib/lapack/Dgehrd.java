package org.netlib.lapack;

import org.netlib.blas.Daxpy;
import org.netlib.blas.Dgemm;
import org.netlib.blas.Dtrmm;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgehrd {

    public static void dgehrd(int i, int j, int k, double ad[], int l, int i1, double ad1[], int j1, double ad2[],
            int k1, int l1, intW intw) {

        boolean flag = false;
        int i2 = 0;
        intW intw1 = new intW(0);
        int k2 = 0;
        int i3 = 0;
        int j3 = 0;
        int k3 = 0;
        int l3 = 0;
        int i4 = 0;
        int j4 = 0;
        double ad3[] = new double[65 * 64];
        intw.val = 0;
        k3 = Math.min(64, Ilaenv.ilaenv(1, "DGEHRD", " ", i, j, k, -1));
        j3 = i * k3;
        ad2[k1] = j3;

        flag = (l1 == -1);
        if (i < 0)
            intw.val = -1;
        else if (j < 1 || j > Math.max(1, i))
            intw.val = -2;
        else if (k < Math.min(j, i) || k > i)
            intw.val = -3;
        else if (i1 < Math.max(1, i))
            intw.val = -5;
        else if (l1 < Math.max(1, i) && !flag)
            intw.val = -8;
        if (intw.val != 0) {
            Xerbla.xerbla("DGEHRD", -intw.val);
            return;
        }
        if (flag) {
            return;
        }

        i2 = 1;
        for (int k4 = j - 1; k4 > 0; k4--) {
            ad1[i2 - 1 + j1] = 0.0;
            i2++;
        }

        i2 = Math.max(1, k);
        for (int l4 = i - Math.max(1, k); l4 > 0; l4--) {
            ad1[i2 - 1 + j1] = 0.0;
            i2++;
        }

        i4 = (k - j) + 1;
        if (i4 <= 1) {
            ad2[k1] = 1.0;
            return;
        }
        k3 = Math.min(64, Ilaenv.ilaenv(1, "DGEHRD", " ", i, j, k, -1));
        l3 = 2;
        k2 = 1;
        if (k3 > 1 && k3 < i4) {
            j4 = Math.max(k3, Ilaenv.ilaenv(3, "DGEHRD", " ", i, j, k, -1));
            if (j4 < i4) {
                k2 = i * k3;
                if (l1 < k2) {
                    l3 = Math.max(2, Ilaenv.ilaenv(2, "DGEHRD", " ", i, j, k, -1));
                    if (l1 >= i * l3) {
                        k3 = l1 / i;
                    } else {
                        k3 = 1;
                    }
                }
            }
        }
        i3 = i;
        if (k3 < l3 || k3 >= i4) {
            i2 = j;
        } else {
            i2 = j;
            for (int i5 = ((k - 1 - j4 - j) + k3) / k3; i5 > 0; i5--) {
                int j2 = Math.min(k3, k - i2);

                Dlahr2.dlahr2(k, i2, j2, ad, (i2 - 1) * i1 + l, i1, ad1, (i2 - 1) + j1, ad3, 0, 65, ad2, k1, i3);

                double d1 = ad[(i2 + j2 - 1) + (i2 + j2 - 2) * i1 + l];

                ad[(i2 + j2 - 1) + (i2 + j2 - 2) * i1 + l] = 1.0;

                Dgemm.dgemm("No transpose", "Transpose", k, (k - i2 - j2) + 1, j2, -1.0, ad2, k1, i3, ad,
                        (i2 + j2) - 1 + (i2 - 1) * i1 + l, i1, 1.0, ad, (i2 + j2 - 1) * i1 + l, i1);

                ad[(i2 + j2 - 1) + (i2 + j2 - 2) * i1 + l] = d1;

                Dtrmm.dtrmm("Right", "Lower", "Transpose", "Unit", i2, j2 - 1, 1.0, ad, i2 + (i2 - 1) * i1 + l, i1, ad2,
                        k1, i3);

                int l2 = 0;
                for (int j5 = j2 - 1; j5 > 0; j5--) {
                    Daxpy.daxpy(i2, -1.0, ad2, i3 * l2 + k1, 1, ad, (i2 + l2) * i1 + l, 1);
                    l2++;
                }

                Dlarfb.dlarfb("Left", "Transpose", "Forward", "Columnwise", k - i2, (i - i2 - j2) + 1, j2, ad,
                        i2 + (i2 - 1) * i1 + l, i1, ad3, 0, 65, ad, i2 + (i2 + j2 - 1) * i1 + l, i1, ad2, k1, i3);

                i2 += k3;
            }

        }
        Dgehd2.dgehd2(i, i2, k, ad, l, i1, ad1, j1, ad2, k1, intw1);
        ad2[k1] = k2;
    }
}

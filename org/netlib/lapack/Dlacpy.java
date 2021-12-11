package org.netlib.lapack;

import org.netlib.blas.Lsame;

// DLACPY copies all or part of a two-dimensional matrix A to another
// matrix B.
public final class Dlacpy {

    public static void dlacpy(String uplo, int m, int n, double[] a, int _a_offset, int lda, double[] b, int _b_offset,
            int ldb) {

        if (Lsame.lsame(uplo, "U")) {
            int k = 1;
            for (int j = n; j > 0; j--) {
                int l = 1;
                for (int i = Math.min(k, m); i > 0; i--) {
                    b[l - 1 + (k - 1) * ldb + _b_offset] = a[l - 1 + (k - 1) * lda + _a_offset];
                    l++;
                }

                k++;
            }

        } else if (Lsame.lsame(uplo, "L")) {
            int k = 1;
            for (int j = n; j > 0; j--) {
                int l = k;
                for (int i = m - k + 1; i > 0; i--) {
                    b[l - 1 + (k - 1) * ldb + _b_offset] = a[l - 1 + (k - 1) * lda + _a_offset];
                    l++;
                }

                k++;
            }
        } else {
            int k = 1;
            for (int j = n; j > 0; j--) {
                int l = 1;
                for (int i = m; i > 0; i--) {
                    b[l - 1 + (k - 1) * ldb + _b_offset] = a[l - 1 + (k - 1) * lda + _a_offset];
                    l++;
                }

                k++;
            }
        }
    }
}

package org.netlib.lapack;

import org.netlib.blas.Lsame;

// DLASET initializes an m-by-n matrix A to BETA on the diagonal and
// ALPHA on the offdiagonals.
public final class Dlaset {

    public static void dlaset(String uplo, int m, int n, double alpha, double beta, double[] a, int _a_offset,
            int lda) {

        int k = 0;
        // Set the strictly upper triangular or trapezoidal part of the
        // array to ALPHA.
        if (Lsame.lsame(uplo, "U")) {
            int l = 2;
            for (int j = n - 1; j > 0; j--) {
                k = 1;
                for (int i = Math.min(l - 1, m); i > 0; i--) {
                    a[k - 1 + (l - 1) * lda + _a_offset] = alpha;
                    k++;
                }

                l++;
            }

        } else if (Lsame.lsame(uplo, "L")) {
            // Set the strictly lower triangular or trapezoidal part of the
            // array to ALPHA.
            int l = 1;
            for (int j = Math.min(m, n); j > 0; j--) {
                k = l + 1;
                for (int i = m - l; i > 0; i--) {
                    a[k - 1 + (l - 1) * lda + _a_offset] = alpha;
                    k++;
                }

                l++;
            }

        } else {
            // Set the leading m-by-n submatrix to ALPHA.
            int l = 1;
            for (int j = n; j > 0; j--) {
                k = 1;
                for (int i = m; i > 0; i--) {
                    a[k - 1 + (l - 1) * lda + _a_offset] = alpha;
                    k++;
                }

                l++;
            }

        }
        // Set the first min(M,N) diagonal elements to BETA.
        k = 1;
        for (int i = Math.min(m, n); i > 0; i--) {
            a[k - 1 + (k - 1) * lda + _a_offset] = beta;
            k++;
        }
    }
}

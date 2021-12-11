package org.netlib.lapack;

import org.netlib.blas.Dgemm;
import org.netlib.blas.Dtrsm;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

// DGETRF computes an LU factorization of a general M-by-N matrix A
// using partial pivoting with row interchanges.
//
// The factorization has the form
//    A = P * L * U
// where P is a permutation matrix, L is lower triangular with unit
// diagonal elements (lower trapezoidal if m > n), and U is upper
// triangular (upper trapezoidal if m < n).
public final class Dgetrf {

    public static void dgetrf(int m, int n, double[] a, int _a_offset, int lda, int[] ipiv, int _ipiv_offset,
            intW info) {

        info.val = 0;
        if (m < 0) {
            info.val = -1;
        } else if (n < 0) {
            info.val = -2;
        } else if (lda < Math.max(1, m)) {
            info.val = -4;
        }
        if (info.val != 0) {
            Xerbla.xerbla("DGETRF", -info.val);
            return;
        }

        // Quick return if possible
        if (m == 0 || n == 0) {
            return;
        }
        // Determine the block size for this environment
        int nb = Ilaenv.ilaenv(1, "DGETRF", " ", m, n, -1, -1);
        if (nb <= 1 || nb >= Math.min(m, n)) {
            // Use unblocked code
            Dgetf2.dgetf2(m, n, a, _a_offset, lda, ipiv, _ipiv_offset, info);
        } else {
            // Use blocked code
            intW iinfo = new intW(0);
            int j = 1;
            for (int p = ((Math.min(m, n) - 1) + nb) / nb; p > 0; p--) {
                int jb = Math.min((Math.min(m, n) - j) + 1, nb);
                // Factor diagonal and subdiagonal blocks and test
                // for exact singularity
                Dgetf2.dgetf2(m - j + 1, jb, a, j - 1 + (j - 1) * lda + _a_offset, lda, ipiv, j - 1 + _ipiv_offset,
                        iinfo);
                // Adjust INFO and the pivot indices
                if (info.val == 0 && iinfo.val > 0) {
                    info.val = (iinfo.val + j) - 1;
                }
                int i = j;
                for (int q = Math.min(m, j + jb - 1) - j + 1; q > 0; q--) {
                    ipiv[i - 1 + _ipiv_offset] = j - 1 + ipiv[i - 1 + _ipiv_offset];
                    i++;
                }

                // Apply interchanges to columns 1:J-1
                Dlaswp.dlaswp(j - 1, a, _a_offset, lda, j, j + jb - 1, ipiv, _ipiv_offset, 1);

                if (j + jb <= n) {
                    // Apply interchanges to columns J+JB:N
                    Dlaswp.dlaswp(n - j - jb + 1, a, (j + jb - 1) * lda + _a_offset, lda, j, j + jb - 1, ipiv,
                            _ipiv_offset, 1);
                    // Compute block row of U
                    Dtrsm.dtrsm("Left", "Lower", "No transpose", "Unit", jb, n - j - jb + 1, 1.0, a,
                            j - 1 + (j - 1) * lda + _a_offset, lda, a, j - 1 + (j + jb - 1) * lda + _a_offset, lda);

                    if (j + jb <= m) {
                        // Update trailing submatrix
                        Dgemm.dgemm("No transpose", "No transpose", m - j - jb + 1, n - j - jb + 1, jb, -1.0, a,
                                j + jb - 1 + (j - 1) * lda + _a_offset, lda, a, j - 1 + (j + jb - 1) * lda + _a_offset,
                                lda, 1.0, a, j + jb - 1 + (j + jb - 1) * lda + _a_offset, lda);
                    }
                }
                j += nb;
            }
        }
    }
}

package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

// DGESV computes the solution to a real system of linear equations
//    A * X = B,
// where A is an N-by-N matrix and X and B are N-by-NRHS matrices.
//
// The LU decomposition with partial pivoting and row interchanges is
// used to factor A as
//    A = P * L * U,
// where P is a permutation matrix, L is unit lower triangular, and U is
// upper triangular.  The factored form of A is then used to solve the
// system of equations A * X = B.
public final class Dgesv {

    public static void dgesv(int n, int nrhs, double[] a, int _a_offset, int lda, int[] ipiv, int _ipiv_offset,
            double[] b, int _b_offset, int ldb, intW info) {

        info.val = 0;
        if (n < 0) {
            info.val = -1;
        } else if (nrhs < 0) {
            info.val = -2;
        } else if (lda < Math.max(1, n)) {
            info.val = -4;
        } else if (ldb < Math.max(1, n)) {
            info.val = -7;
        }

        if (info.val != 0) {
            Xerbla.xerbla("DGESV ", -info.val);
            return;
        }

        // Compute the LU factorization of A
        Dgetrf.dgetrf(n, n, a, _a_offset, lda, ipiv, _ipiv_offset, info);
        if (info.val == 0) {
            // Solve the system A*X = B, overwriting B with X
            Dgetrs.dgetrs("No transpose", n, nrhs, a, _a_offset, lda, ipiv, _ipiv_offset, b, _b_offset, ldb, info);
        }
    }
}

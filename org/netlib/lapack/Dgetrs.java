package org.netlib.lapack;

import org.netlib.blas.Dtrsm;
import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

// DGETRS solves a system of linear equations
//    A * X = B  or  A**T * X = B
// with a general N-by-N matrix A using the LU factorization
// computed by DGETRF.
public final class Dgetrs {

    public static void dgetrs(String trans, int n, int nrhs, double[] a, int _a_offset, int lda, int[] ipiv,
            int _ipiv_offset, double[] b, int _b_offset, int ldb, intW info) {

        info.val = 0;
        boolean notran = Lsame.lsame(trans, "N");
        if (!notran && !Lsame.lsame(trans, "T") && !Lsame.lsame(trans, "C")) {
            info.val = -1;
        } else if (n < 0) {
            info.val = -2;
        } else if (nrhs < 0) {
            info.val = -3;
        } else if (lda < Math.max(1, n)) {
            info.val = -5;
        } else if (ldb < Math.max(1, n)) {
            info.val = -8;
        }

        if (info.val != 0) {
            Xerbla.xerbla("DGETRS", -info.val);
            return;
        }
        // Quick return if possible
        if (n == 0 || nrhs == 0) {
            return;
        }

        if (notran) {
            // Solve A * X = B
            // Apply row interchanges to the right hand sides
            Dlaswp.dlaswp(nrhs, b, _b_offset, ldb, 1, n, ipiv, _ipiv_offset, 1);
            // Solve L*X = B, overwriting B with X
            Dtrsm.dtrsm("Left", "Lower", "No transpose", "Unit", n, nrhs, 1.0, a, _a_offset, lda, b, _b_offset, ldb);
            // Solve U*X = B, overwriting B with X
            Dtrsm.dtrsm("Left", "Upper", "No transpose", "Non-unit", n, nrhs, 1.0, a, _a_offset, lda, b, _b_offset,
                    ldb);
        } else {
            // Solve A**T * X = B
            // Solve U**T *X = B, overwriting B with X
            Dtrsm.dtrsm("Left", "Upper", "Transpose", "Non-unit", n, nrhs, 1.0, a, _a_offset, lda, b, _b_offset, ldb);
            // Solve L**T *X = B, overwriting B with X
            Dtrsm.dtrsm("Left", "Lower", "Transpose", "Unit", n, nrhs, 1.0, a, _a_offset, lda, b, _b_offset, ldb);
            // Apply row interchanges to the solution vectors
            Dlaswp.dlaswp(nrhs, b, _b_offset, ldb, 1, n, ipiv, _ipiv_offset, -1);
        }
    }
}

package org.netlib.lapack;

import org.netlib.blas.Dtrsm;
import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

// DTRTRS solves a triangular system of the form
//   A * X = B  or  A**T * X = B,
// where A is a triangular matrix of order N, and B is an N-by-NRHS
// matrix.  A check is made to verify that A is nonsingular.
public final class Dtrtrs {

    public static void dtrtrs(String uplo, String trans, String diag, int n, int nrhs, double[] a, int _a_offset,
            int lda, double[] b, int _b_offset, int ldb, intW info) {

        info.val = 0;
        boolean nounit = Lsame.lsame(diag, "N");
        if (!Lsame.lsame(uplo, "U") && !Lsame.lsame(uplo, "L")) {
            info.val = -1;
        } else if (!Lsame.lsame(trans, "N") && !Lsame.lsame(trans, "T") && !Lsame.lsame(trans, "C")) {
            info.val = -2;
        } else if (!nounit && !Lsame.lsame(diag, "U")) {
            info.val = -3;
        } else if (n < 0) {
            info.val = -4;
        } else if (nrhs < 0) {
            info.val = -5;
        } else if (lda < Math.max(1, n)) {
            info.val = -7;
        } else if (ldb < Math.max(1, n)) {
            info.val = -9;
        }
        if (info.val != 0) {
            Xerbla.xerbla("DTRTRS", -info.val);
            return;
        }
        if (n == 0) {
            return;
        }
        if (nounit) {
            info.val = 1;
            for (int p = n; p > 0; p--) {
                if (a[(info.val - 1) + (info.val - 1) * lda + _a_offset] == 0.0) {
                    return;
                }
                info.val = info.val + 1;
            }
        }
        info.val = 0;
        // Solve A * x = b or A**T * x = b
        Dtrsm.dtrsm("Left", uplo, trans, diag, n, nrhs, 1.0, a, _a_offset, lda, b, _b_offset, ldb);
    }
}

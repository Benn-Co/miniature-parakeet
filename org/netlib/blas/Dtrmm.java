package org.netlib.blas;

import org.netlib.err.Xerbla;

// DTRMM performs one of the matrix-matrix operations
// B := alpha*op( A )*B,  or  B := alpha*B*op( A ),
// where  alpha  is a scalar, B is an m by n matrix, A is a unit, or
// non-unit, upper or lower triangular matrix and op( A ) is one  of
// op( A ) = A  or  op( A ) = A**T.
public final class Dtrmm {

    /**
     * <pre><code>
     *  Purpose
     *  =======
     *
     *  DTRMM  performs one of the matrix-matrix operations
     *
     *     B := alpha*op( A )*B,   or   B := alpha*B*op( A ),
     *
     *  where  alpha  is a scalar,  B  is an m by n matrix,  A  is a unit, or
     *  non-unit,  upper or lower triangular matrix  and  op( A )  is one  of
     *
     *     op( A ) = A   or   op( A ) = A'.
     *
     *  Arguments
     *  ==========
     *
     *  SIDE   - CHARACTER*1.
     *           On entry,  SIDE specifies whether  op( A ) multiplies B from
     *           the left or right as follows:
     *
     *              SIDE = 'L' or 'l'   B := alpha*op( A )*B.
     *
     *              SIDE = 'R' or 'r'   B := alpha*B*op( A ).
     *
     *           Unchanged on exit.
     *
     *  UPLO   - CHARACTER*1.
     *           On entry, UPLO specifies whether the matrix A is an upper or
     *           lower triangular matrix as follows:
     *
     *              UPLO = 'U' or 'u'   A is an upper triangular matrix.
     *
     *              UPLO = 'L' or 'l'   A is a lower triangular matrix.
     *
     *           Unchanged on exit.
     *
     *  TRANSA - CHARACTER*1.
     *           On entry, TRANSA specifies the form of op( A ) to be used in
     *           the matrix multiplication as follows:
     *
     *              TRANSA = 'N' or 'n'   op( A ) = A.
     *
     *              TRANSA = 'T' or 't'   op( A ) = A'.
     *
     *              TRANSA = 'C' or 'c'   op( A ) = A'.
     *
     *           Unchanged on exit.
     *
     *  DIAG   - CHARACTER*1.
     *           On entry, DIAG specifies whether or not A is unit triangular
     *           as follows:
     *
     *              DIAG = 'U' or 'u'   A is assumed to be unit triangular.
     *
     *              DIAG = 'N' or 'n'   A is not assumed to be unit
     *                                  triangular.
     *
     *           Unchanged on exit.
     *
     *  M      - INTEGER.
     *           On entry, M specifies the number of rows of B. M must be at
     *           least zero.
     *           Unchanged on exit.
     *
     *  N      - INTEGER.
     *           On entry, N specifies the number of columns of B.  N must be
     *           at least zero.
     *           Unchanged on exit.
     *
     *  ALPHA  - DOUBLE PRECISION.
     *           On entry,  ALPHA specifies the scalar  alpha. When  alpha is
     *           zero then  A is not referenced and  B need not be set before
     *           entry.
     *           Unchanged on exit.
     *
     *  A      - DOUBLE PRECISION array of DIMENSION ( LDA, k ), where k is m
     *           when  SIDE = 'L' or 'l'  and is  n  when  SIDE = 'R' or 'r'.
     *           Before entry  with  UPLO = 'U' or 'u',  the  leading  k by k
     *           upper triangular part of the array  A must contain the upper
     *           triangular matrix  and the strictly lower triangular part of
     *           A is not referenced.
     *           Before entry  with  UPLO = 'L' or 'l',  the  leading  k by k
     *           lower triangular part of the array  A must contain the lower
     *           triangular matrix  and the strictly upper triangular part of
     *           A is not referenced.
     *           Note that when  DIAG = 'U' or 'u',  the diagonal elements of
     *           A  are not referenced either,  but are assumed to be  unity.
     *           Unchanged on exit.
     *
     *  LDA    - INTEGER.
     *           On entry, LDA specifies the first dimension of A as declared
     *           in the calling (sub) program.  When  SIDE = 'L' or 'l'  then
     *           LDA  must be at least  max( 1, m ),  when  SIDE = 'R' or 'r'
     *           then LDA must be at least max( 1, n ).
     *           Unchanged on exit.
     *
     *  B      - DOUBLE PRECISION array of DIMENSION ( LDB, n ).
     *           Before entry,  the leading  m by n part of the array  B must
     *           contain the matrix  B,  and  on exit  is overwritten  by the
     *           transformed matrix.
     *
     *  LDB    - INTEGER.
     *           On entry, LDB specifies the first dimension of B as declared
     *           in  the  calling  (sub)  program.   LDB  must  be  at  least
     *           max( 1, m ).
     *           Unchanged on exit.
     *
     *
     *  Level 3 Blas routine.
     *
     *  -- Written on 8-February-1989.
     *     Jack Dongarra, Argonne National Laboratory.
     *     Iain Duff, AERE Harwell.
     *     Jeremy Du Croz, Numerical Algorithms Group Ltd.
     *     Sven Hammarling, Numerical Algorithms Group Ltd.
     *
     *
     *     .. External Functions ..
     * </code>
     * </pre>
     *
     * @param side
     * @param uplo
     * @param transa
     * @param diag
     * @param m
     * @param n
     * @param alpha
     * @param a
     * @param _a_offset
     * @param lda
     * @param b
     * @param _b_offset
     * @param ldb
     */
    public static void dtrmm(String side, String uplo, String transa, String diag, int m, int n, double alpha,
            double[] a, int _a_offset, int lda, double[] b, int _b_offset, int ldb) {

        boolean lside = Lsame.lsame(side, "L");
        boolean nounit = Lsame.lsame(diag, "N");
        boolean upper = Lsame.lsame(uplo, "U");
        boolean notrans = Lsame.lsame(transa, "N");
        int info = 0;
        if (!lside && !Lsame.lsame(side, "R")) {
            info = 1;
        } else if (!upper && !Lsame.lsame(uplo, "L")) {
            info = 2;
        } else if (!notrans && !Lsame.lsame(transa, "T") && !Lsame.lsame(transa, "C")) {
            info = 3;
        } else if (!nounit && !Lsame.lsame(diag, "U")) {
            info = 4;
        } else if (m < 0) {
            info = 5;
        } else if (n < 0) {
            info = 6;
        } else if (lda < Math.max(1, (lside) ? m : n)) {
            info = 9;
        } else if (ldb < Math.max(1, m)) {
            info = 11;
        }

        if (info != 0) {
            Xerbla.xerbla("DTRMM ", info);
            return;
        }

        // Quick return if possible
        if (n == 0) {
            return;
        }

        if ((lside && Math.min(m, n) > 190) || (!lside && Math.min(m, n) > 280)) {
            Trmm.trmm(lside, !upper, !notrans, !nounit, m, n, alpha, a, _a_offset, lda, b, _b_offset, ldb);
        } else {
            DtrmmNetlib.dtrmm(lside, upper, notrans, nounit, m, n, alpha, a, _a_offset, lda, b, _b_offset, ldb);
        }
    }
}

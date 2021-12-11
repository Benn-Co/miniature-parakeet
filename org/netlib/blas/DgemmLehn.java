package org.netlib.blas;

final class DgemmLehn {
    /**
     * @param m
     *            the number of rows of the matrix op(A) and of the matrix C
     * @param n
     *            the number of columns of the matrix op(B) and the number of
     *            columns of the matrix C
     * @param k
     *            the number of columns of the matrix op(A) and the number of
     *            rows of the matrix op(B)
     */
    static void dgemm(boolean notA, boolean notB, int m, int n, int k, double alpha, double[] A, int _a_offset, int ldA,
            double[] B, int _b_offset, int ldB, double beta, double[] C, int _c_offset, int ldC) {

        if (notB) {
            if (notA) {
                // Form C := alpha*A*B + beta*C.
                Dgemm4x4.dgemm(m, n, k, alpha, _a_offset, A, 1, ldA, _b_offset, B, 1, ldB, beta, _c_offset, C, 1, ldC);
            } else {
                // Form C := alpha*A**T*B + beta*C
                Dgemm4x4.dgemm(m, n, k, alpha, _a_offset, A, ldA, 1, _b_offset, B, 1, ldB, beta, _c_offset, C, 1, ldC);
            }
        } else {
            if (notA) {
                // Form C := alpha*A*B**T + beta*C
                Dgemm4x4.dgemm(m, n, k, alpha, _a_offset, A, 1, ldA, _b_offset, B, ldB, 1, beta, _c_offset, C, 1, ldC);
            } else {
                // Form C := alpha*A**T*B**T + beta*C
                Dgemm4x4.dgemm(m, n, k, alpha, _a_offset, A, ldA, 1, _b_offset, B, ldB, 1, beta, _c_offset, C, 1, ldC);
            }
        }
    }
}

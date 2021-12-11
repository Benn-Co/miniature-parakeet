package org.netlib.blas;

final class DgemmNetlib {

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
    static void dgemm(boolean notA, boolean notB, int m, int n, int k, double alpha, double[] a, int _a_offset, int lda,
            double[] b, int _b_offset, int ldb, double beta, double[] c, int _c_offset, int ldc) {

        // Quick return if alpha == 0
        if (alpha == 0.0) {
            if (beta == 0.0) {
                int v = 1;
                for (int o = n; o > 0; o--) {
                    int i = 1;
                    for (int p = m; p > 0; p--) {
                        c[(i - 1) + (v - 1) * ldc + _c_offset] = 0.0;
                        i++;
                    }

                    v++;
                }

            } else {
                int v = 1;
                for (int o = n; o > 0; o--) {
                    int i = 1;
                    for (int p = m; p > 0; p--) {
                        c[(i - 1) + (v - 1) * ldc + _c_offset] = beta * c[(i - 1) + (v - 1) * ldc + _c_offset];
                        i++;
                    }

                    v++;
                }

            }
            return;
        }

        // Start the operations

        if (notB) {
            if (notA) {
                // Form C := alpha*A*B + beta*C
                int u = 1;
                for (int o = n; o > 0; o--) {
                    if (beta == 0.0) {
                        int i = 1;
                        for (int p = m; p > 0; p--) {
                            c[(i - 1) + (u - 1) * ldc + _c_offset] = 0.0;
                            i++;
                        }

                    } else if (beta != 1.0) {
                        int i = 1;
                        for (int p = m; p > 0; p--) {
                            c[(i - 1) + (u - 1) * ldc + _c_offset] = beta * c[(i - 1) + (u - 1) * ldc + _c_offset];
                            i++;
                        }

                    }
                    int w = 1;
                    for (int p = k; p > 0; p--) {
                        if (b[(w - 1) + (u - 1) * ldb + _b_offset] != 0.0) {
                            double tmp = alpha * b[(w - 1) + (u - 1) * ldb + _b_offset];
                            int i = 1;
                            for (int q = m; q > 0; q--) {
                                c[(i - 1) + (u - 1) * ldc + _c_offset] = c[(i - 1) + (u - 1) * ldc + _c_offset]
                                        + tmp * a[(i - 1) + (w - 1) * lda + _a_offset];
                                i++;
                            }

                        }
                        w++;
                    }

                    u++;
                }

            } else {
                // Form C := alpha*A**T*B + beta*C
                int u = 1;
                for (int o = n; o > 0; o--) {
                    int w = 1;
                    for (int p = m; p > 0; p--) {
                        double tmp = 0.0;
                        int i = 1;
                        for (int q = k; q > 0; q--) {
                            tmp += a[(i - 1) + (w - 1) * lda + _a_offset] * b[(i - 1) + (u - 1) * ldb + _b_offset];
                            i++;
                        }

                        if (beta == 0.0) {
                            c[(w - 1) + (u - 1) * ldc + _c_offset] = alpha * tmp;
                        } else {
                            c[(w - 1) + (u - 1) * ldc + _c_offset] = alpha * tmp
                                    + beta * c[(w - 1) + (u - 1) * ldc + _c_offset];
                        }
                        w++;
                    }

                    u++;
                }

            }
        } else if (notA) {
            // Form C := alpha*A*B**T + beta*C
            int u = 1;
            for (int o = n; o > 0; o--) {
                if (beta == 0.0) {
                    int i = 1;
                    for (int p = m; p > 0; p--) {
                        c[(i - 1) + (u - 1) * ldc + _c_offset] = 0.0;
                        i++;
                    }

                } else if (beta != 1.0) {
                    int i = 1;
                    for (int p = m; p > 0; p--) {
                        c[(i - 1) + (u - 1) * ldc + _c_offset] = beta * c[(i - 1) + (u - 1) * ldc + _c_offset];
                        i++;
                    }

                }
                int w = 1;
                for (int p = k; p > 0; p--) {
                    if (b[(u - 1) + (w - 1) * ldb + _b_offset] != 0.0) {
                        double tmp = alpha * b[(u - 1) + (w - 1) * ldb + _b_offset];
                        int i = 1;
                        for (int q = m; q > 0; q--) {
                            c[(i - 1) + (u - 1) * ldc + _c_offset] = c[(i - 1) + (u - 1) * ldc + _c_offset]
                                    + tmp * a[(i - 1) + (w - 1) * lda + _a_offset];
                            i++;
                        }

                    }
                    w++;
                }

                u++;
            }

        } else {
            // Form C := alpha*A**T*B**T + beta*C
            int u = 1;
            for (int o = n; o > 0; o--) {
                int w = 1;
                for (int p = m; p > 0; p--) {
                    double tmp = 0.0;
                    int i = 1;
                    for (int q = k; q > 0; q--) {
                        tmp += a[(i - 1) + (w - 1) * lda + _a_offset] * b[(u - 1) + (i - 1) * ldb + _b_offset];
                        i++;
                    }

                    if (beta == 0.0) {
                        c[(w - 1) + (u - 1) * ldc + _c_offset] = alpha * tmp;
                    } else {
                        c[(w - 1) + (u - 1) * ldc + _c_offset] = alpha * tmp
                                + beta * c[(w - 1) + (u - 1) * ldc + _c_offset];
                    }
                    w++;
                }

                u++;
            }
        }
    }
}

package org.netlib.blas;

import org.netlib.err.Xerbla;

// DTRSM solves one of the matrix equations
// op( A )*X = alpha*B,  or  X*op( A ) = alpha*B,
// where alpha is a scalar, X and B are m by n matrices,
// A is a unit, or non-unit, upper or lower triangular matrix
// and op( A ) is one of op( A ) = A  or  op( A ) = A**T.
// The matrix X is overwritten on B.
public final class Dtrsm {

    public static void dtrsm(String side, String uplo, String transa, String diag, int m, int n, double alpha,
            double[] a, int _a_offset, int lda, double[] b, int _b_offset, int ldb) {

        // Test the input parameters
        boolean lside = Lsame.lsame(side, "L");
        boolean upper = Lsame.lsame(uplo, "U");
        boolean notrans = Lsame.lsame(transa, "N");
        boolean nounit = Lsame.lsame(diag, "N");
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
            Xerbla.xerbla("DTRSM ", info);
            return;
        }
        // Quick return if possible
        if (m == 0 || n == 0) {
            return;
        }
        // And when alpha == 0
        if (alpha == 0.0) {
            int j = 1;
            for (int p = n; p > 0; p--) {
                int i = 1;
                for (int q = m; q > 0; q--) {
                    b[i - 1 + (j - 1) * ldb + _b_offset] = 0.0;
                    i++;
                }

                j++;
            }

            return;
        }
        // Start the operations
        if (lside) {
            if (notrans) {
                // Form B := alpha*inv( A )*B
                if (upper) {
                    int j = 1;
                    for (int p = n; p > 0; p--) {
                        if (alpha != 1.0) {
                            int i = 1;
                            for (int q = m; q > 0; q--) {
                                b[i - 1 + (j - 1) * ldb + _b_offset] = alpha * b[i - 1 + (j - 1) * ldb + _b_offset];
                                i++;
                            }

                        }
                        int k = m;
                        for (int r = m; r > 0; r--) {
                            if (b[k - 1 + (j - 1) * ldb + _b_offset] != 0.0) {
                                if (nounit) {
                                    b[k - 1 + (j - 1) * ldb + _b_offset] = b[k - 1 + (j - 1) * ldb + _b_offset]
                                            / a[k - 1 + (k - 1) * lda + _a_offset];
                                }
                                int i = 1;
                                for (int s = k - 1; s > 0; s--) {
                                    b[i - 1 + (j - 1) * ldb + _b_offset] = b[i - 1 + (j - 1) * ldb + _b_offset]
                                            - b[k - 1 + (j - 1) * ldb + _b_offset]
                                                    * a[i - 1 + (k - 1) * lda + _a_offset];
                                    i++;
                                }

                            }
                            k--;
                        }

                        j++;
                    }

                } else {
                    int j = 1;
                    for (int p = n; p > 0; p--) {
                        if (alpha != 1.0) {
                            int i = 1;
                            for (int q = m; q > 0; q--) {
                                b[i - 1 + (j - 1) * ldb + _b_offset] = alpha * b[i - 1 + (j - 1) * ldb + _b_offset];
                                i++;
                            }

                        }
                        int k = 1;
                        for (int r = m; r > 0; r--) {
                            if (b[k - 1 + (j - 1) * ldb + _b_offset] != 0.0) {
                                if (nounit) {
                                    b[k - 1 + (j - 1) * ldb + _b_offset] = b[k - 1 + (j - 1) * ldb + _b_offset]
                                            / a[k - 1 + (k - 1) * lda + _a_offset];
                                }
                                int i = k + 1;
                                for (int s = m - k; s > 0; s--) {
                                    b[i - 1 + (j - 1) * ldb + _b_offset] = b[i - 1 + (j - 1) * ldb + _b_offset]
                                            - b[k - 1 + (j - 1) * ldb + _b_offset]
                                                    * a[i - 1 + (k - 1) * lda + _a_offset];
                                    i++;
                                }

                            }
                            k++;
                        }

                        j++;
                    }

                }
            } else if (upper) {
                // Form B := alpha*inv( A**T )*B
                int j = 1;
                for (int p = n; p > 0; p--) {
                    int i = 1;
                    for (int q = m; q > 0; q--) {
                        double temp = alpha * b[i - 1 + (j - 1) * ldb + _b_offset];
                        int k = 1;
                        for (int r = i - 1; r > 0; r--) {
                            temp -= a[k - 1 + (i - 1) * lda + _a_offset] * b[k - 1 + (j - 1) * ldb + _b_offset];
                            k++;
                        }

                        if (nounit) {
                            temp /= a[i - 1 + (i - 1) * lda + _a_offset];
                        }
                        b[i - 1 + (j - 1) * ldb + _b_offset] = temp;
                        i++;
                    }

                    j++;
                }

            } else {
                int j = 1;
                for (int p = n; p > 0; p--) {
                    int i = m;
                    for (int q = m; q > 0; q--) {
                        double temp = alpha * b[i - 1 + (j - 1) * ldb + _b_offset];
                        int k = i + 1;
                        for (int r = m - i; r > 0; r--) {
                            temp -= a[k - 1 + (i - 1) * lda + _a_offset] * b[k - 1 + (j - 1) * ldb + _b_offset];
                            k++;
                        }

                        if (nounit) {
                            temp /= a[i - 1 + (i - 1) * lda + _a_offset];
                        }
                        b[i - 1 + (j - 1) * ldb + _b_offset] = temp;
                        i--;
                    }

                    j++;
                }

            }
        } else if (notrans) {
            // Form B := alpha*B*inv( A )
            if (upper) {
                int j = 1;
                for (int p = n; p > 0; p--) {
                    if (alpha != 1.0) {
                        int i = 1;
                        for (int q = m; q > 0; q--) {
                            b[i - 1 + (j - 1) * ldb + _b_offset] = alpha * b[i - 1 + (j - 1) * ldb + _b_offset];
                            i++;
                        }

                    }
                    int k = 1;
                    for (int q = j - 1; q > 0; q--) {
                        if (a[k - 1 + (j - 1) * lda + _a_offset] != 0.0) {
                            int i = 1;
                            for (int r = m; r > 0; r--) {
                                b[i - 1 + (j - 1) * ldb + _b_offset] = b[i - 1 + (j - 1) * ldb + _b_offset]
                                        - a[k - 1 + (j - 1) * lda + _a_offset] * b[i - 1 + (k - 1) * ldb + _b_offset];
                                i++;
                            }

                        }
                        k++;
                    }

                    if (nounit) {
                        double temp = 1.0 / a[j - 1 + (j - 1) * lda + _a_offset];
                        int i = 1;
                        for (int s = m; s > 0; s--) {
                            b[i - 1 + (j - 1) * ldb + _b_offset] = temp * b[i - 1 + (j - 1) * ldb + _b_offset];
                            i++;
                        }

                    }
                    j++;
                }

            } else {
                int j = n;
                for (int p = n; p > 0; p--) {
                    if (alpha != 1.0) {
                        int i = 1;
                        for (int q = m; q > 0; q--) {
                            b[i - 1 + (j - 1) * ldb + _b_offset] = alpha * b[i - 1 + (j - 1) * ldb + _b_offset];
                            i++;
                        }

                    }
                    int k = j + 1;
                    for (int r = n - j; r > 0; r--) {
                        if (a[k - 1 + (j - 1) * lda + _a_offset] != 0.0) {
                            int ii = 1;
                            for (int s = m; s > 0; s--) {
                                b[ii - 1 + (j - 1) * ldb + _b_offset] = b[ii - 1 + (j - 1) * ldb + _b_offset]
                                        - a[k - 1 + (j - 1) * lda + _a_offset] * b[ii - 1 + (k - 1) * ldb + _b_offset];
                                ii++;
                            }

                        }
                        k++;
                    }

                    if (nounit) {
                        double temp = 1.0 / a[j - 1 + (j - 1) * lda + _a_offset];
                        int i = 1;
                        for (int s = m; s > 0; s--) {
                            b[i - 1 + (j - 1) * ldb + _b_offset] = temp * b[i - 1 + (j - 1) * ldb + _b_offset];
                            i++;
                        }

                    }
                    j--;
                }

            }
        } else if (upper) {
            // Form B := alpha*B*inv( A**T )
            int k = n;
            for (int p = n; p > 0; p--) {
                if (nounit) {
                    double temp = 1.0 / a[k - 1 + (k - 1) * lda + _a_offset];
                    int i = 1;
                    for (int q = m; q > 0; q--) {
                        b[i - 1 + (k - 1) * ldb + _b_offset] = temp * b[i - 1 + (k - 1) * ldb + _b_offset];
                        i++;
                    }

                }
                int j = 1;
                for (int r = k - 1; r > 0; r--) {
                    if (a[j - 1 + (k - 1) * lda + _a_offset] != 0.0) {
                        double temp = a[j - 1 + (k - 1) * lda + _a_offset];
                        int ii = 1;
                        for (int s = m; s > 0; s--) {
                            b[ii - 1 + (j - 1) * ldb + _b_offset] = b[ii - 1 + (j - 1) * ldb + _b_offset]
                                    - temp * b[ii - 1 + (k - 1) * ldb + _b_offset];
                            ii++;
                        }

                    }
                    j++;
                }

                if (alpha != 1.0) {
                    int i = 1;
                    for (int s = m; s > 0; s--) {
                        b[i - 1 + (k - 1) * ldb + _b_offset] = alpha * b[i - 1 + (k - 1) * ldb + _b_offset];
                        i++;
                    }

                }
                k--;
            }

        } else {
            int k = 1;
            for (int p = n; p > 0; p--) {
                if (nounit) {
                    double temp = 1.0 / a[k - 1 + (k - 1) * lda + _a_offset];
                    int i = 1;
                    for (int q = m; q > 0; q--) {
                        b[i - 1 + (k - 1) * ldb + _b_offset] = temp * b[i - 1 + (k - 1) * ldb + _b_offset];
                        i++;
                    }

                }
                int j = k + 1;
                for (int r = n - k; r > 0; r--) {
                    if (a[j - 1 + (k - 1) * lda + _a_offset] != 0.0) {
                        double temp = a[j - 1 + (k - 1) * lda + _a_offset];
                        int ii = 1;
                        for (int s = m; s > 0; s--) {
                            b[ii - 1 + (j - 1) * ldb + _b_offset] = b[ii - 1 + (j - 1) * ldb + _b_offset]
                                    - temp * b[ii - 1 + (k - 1) * ldb + _b_offset];
                            ii++;
                        }

                    }
                    j++;
                }

                if (alpha != 1.0) {
                    int i = 1;
                    for (int s = m; s > 0; s--) {
                        b[i - 1 + (k - 1) * ldb + _b_offset] = alpha * b[i - 1 + (k - 1) * ldb + _b_offset];
                        i++;
                    }

                }
                k++;
            }

        }
    }
}

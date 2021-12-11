package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dsymm
{
	public static void dsymm(String side, String uplo, int m, int n, double alpha, double[] a, int _a_offset, int lda,
			double[] b, int _b_offset, int ldb, double beta, double[] c, int _c_offset, int ldc) {

        int i6 = 0;
        boolean flag3 = false;
        if (Lsame.lsame(side, "L"))
            i6 = m;
        else
            i6 = n;
        flag3 = Lsame.lsame(uplo, "U");
        int byte0 = 0;
        if (!Lsame.lsame(side, "L") && !Lsame.lsame(side, "R"))
            byte0 = 1;
        else
        if (!flag3 && !Lsame.lsame(uplo, "L"))
            byte0 = 2;
        else
        if (m < 0)
            byte0 = 3;
        else
        if (n < 0)
            byte0 = 4;
        else
        if (lda < Math.max(1, i6))
            byte0 = 7;
        else
        if (ldb < Math.max(1, m))
            byte0 = 9;
        else
        if(ldc < Math.max(1, m))
            byte0 = 12;
        if (byte0 != 0)
        {
            Xerbla.xerbla("DSYMM ", byte0);
            return;
        }
        if (((m == 0) || (n == 0)) || ((alpha == 0.0) && (beta == 1.0)))
            return;
        if (alpha == 0.0)
        {
            if(beta == 0.0)
            {
                int i4 = 1;
                for(int j6 = n; j6 > 0; j6--)
                {
                    int i2 = 1;
                    for(int k7 = m; k7 > 0; k7--)
                    {
                        c[(i2 - 1) + (i4 - 1) * ldc + _c_offset] = 0.0;
                        i2++;
                    }

                    i4++;
                }

            } else
            {
                int j4 = 1;
                for(int k6 = n; k6 > 0; k6--)
                {
                    int j2 = 1;
                    for(int l7 = (m - 1) + 1; l7 > 0; l7--)
                    {
                        c[(j2 - 1) + (j4 - 1) * ldc + _c_offset] = beta * c[(j2 - 1) + (j4 - 1) * ldc + _c_offset];
                        j2++;
                    }

                    j4++;
                }

            }
            return;
        }
        if (Lsame.lsame(side, "L"))
        {
            if(flag3)
            {
                int k4 = 1;
                for(int l6 = n; l6 > 0; l6--)
                {
                    int k2 = 1;
                    for(int i8 = m; i8 > 0; i8--)
                    {
                        double d3 = alpha * b[(k2 - 1) + (k4 - 1) * ldb + _b_offset];
                        double d9 = 0.0;
                        int j5 = 1;
                        for(int k9 = k2 - 1; k9 > 0; k9--)
                        {
                            c[(j5 - 1) + (k4 - 1) * ldc + _c_offset] = c[(j5 - 1) + (k4 - 1) * ldc + _c_offset] + d3 * a[(j5 - 1) + (k2 - 1) * lda + _a_offset];
                            d9 += b[(j5 - 1) + (k4 - 1) * ldb + _b_offset] * a[(j5 - 1) + (k2 - 1) * lda + _a_offset];
                            j5++;
                        }

                        if(beta == 0.0)
                            c[(k2 - 1) + (k4 - 1) * ldc + _c_offset] = d3 * a[(k2 - 1) + (k2 - 1) * lda + _a_offset] + alpha * d9;
                        else
                            c[(k2 - 1) + (k4 - 1) * ldc + _c_offset] = beta * c[(k2 - 1) + (k4 - 1) * ldc + _c_offset] + d3 * a[(k2 - 1) + (k2 - 1) * lda + _a_offset] + alpha * d9;
                        k2++;
                    }

                    k4++;
                }

            } else
            {
                int l4 = 1;
                for(int i7 = n; i7 > 0; i7--)
                {
                    int l2 = m;
                    for(int j8 = ((1 - m) + -1) / -1; j8 > 0; j8--)
                    {
                        double d4 = alpha * b[(l2 - 1) + (l4 - 1) * ldb + _b_offset];
                        double d10 = 0.0;
                        int k5 = l2 + 1;
                        for(int l9 = (m - (l2 + 1)) + 1; l9 > 0; l9--)
                        {
                            c[(k5 - 1) + (l4 - 1) * ldc + _c_offset] = c[(k5 - 1) + (l4 - 1) * ldc + _c_offset] + d4 * a[(k5 - 1) + (l2 - 1) * lda + _a_offset];
                            d10 += b[(k5 - 1) + (l4 - 1) * ldb + _b_offset] * a[(k5 - 1) + (l2 - 1) * lda + _a_offset];
                            k5++;
                        }

                        if(beta == 0.0)
                            c[(l2 - 1) + (l4 - 1) * ldc + _c_offset] = d4 * a[(l2 - 1) + (l2 - 1) * lda + _a_offset] + alpha * d10;
                        else
                            c[(l2 - 1) + (l4 - 1) * ldc + _c_offset] = beta * c[(l2 - 1) + (l4 - 1) * ldc + _c_offset] + d4 * a[(l2 - 1) + (l2 - 1) * lda + _a_offset] + alpha * d10;
                        l2--;
                    }

                    l4++;
                }

            }
        } else
        {
            int i5 = 1;
            for(int j7 = n; j7 > 0; j7--)
            {
                double d5 = alpha * a[(i5 - 1) + (i5 - 1) * lda + _a_offset];
                if(beta == 0.0)
                {
                    int i3 = 1;
                    for(int k8 = m; k8 > 0; k8--)
                    {
                        c[(i3 - 1) + (i5 - 1) * ldc + _c_offset] = d5 * b[(i3 - 1) + (i5 - 1) * ldb + _b_offset];
                        i3++;
                    }

                } else
                {
                    int j3 = 1;
                    for(int l8 = m; l8 > 0; l8--)
                    {
                        c[(j3 - 1) + (i5 - 1) * ldc + _c_offset] = beta * c[(j3 - 1) + (i5 - 1) * ldc + _c_offset] + d5 * b[(j3 - 1) + (i5 - 1) * ldb + _b_offset];
                        j3++;
                    }

                }
                int l5 = 1;
                for(int i9 = i5 - 1; i9 > 0; i9--)
                {
                    double d6;
                    if(flag3)
                        d6 = alpha * a[(l5 - 1) + (i5 - 1) * lda + _a_offset];
                    else
                        d6 = alpha * a[(i5 - 1) + (l5 - 1) * lda + _a_offset];
                    int k3 = 1;
                    for (int i10 = m; i10 > 0; i10--)
                    {
                        c[(k3 - 1) + (i5 - 1) * ldc + _c_offset] = c[(k3 - 1) + (i5 - 1) * ldc + _c_offset] + d6 * b[(k3 - 1) + (l5 - 1) * ldb + _b_offset];
                        k3++;
                    }

                    l5++;
                }

                l5 = i5 + 1;
                for (int j9 = (n - (i5 + 1)) + 1; j9 > 0; j9--)
                {
                    double d7;
                    if (flag3)
                        d7 = alpha * a[(i5 - 1) + (l5 - 1) * lda + _a_offset];
                    else
                        d7 = alpha * a[(l5 - 1) + (i5 - 1) * lda + _a_offset];
                    int l3 = 1;
                    for (int j10 = (m - 1) + 1; j10 > 0; j10--)
                    {
                        c[(l3 - 1) + (i5 - 1) * ldc + _c_offset] = c[(l3 - 1) + (i5 - 1) * ldc + _c_offset] + d7 * b[(l3 - 1) + (l5 - 1) * ldb + _b_offset];
                        l3++;
                    }

                    l5++;
                }

                i5++;
            }

        }
    }
}

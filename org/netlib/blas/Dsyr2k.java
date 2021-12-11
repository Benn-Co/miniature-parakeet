package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dsyr2k
{
	public static void dsyr2k(String uplo, String trans, int n, int k, double alpha, double[] a, int _a_offset, int lda,
			double[] b, int _b_offset, int ldb, double beta, double[] c, int _c_offset, int ldc) {

        int i8 = 0;
        boolean flag3 = false;
        if (Lsame.lsame(trans, "N"))
            i8 = n;
        else
            i8 = k;
        flag3 = Lsame.lsame(uplo, "U");
        int byte0 = 0;
        if (!flag3 && !Lsame.lsame(uplo, "L"))
            byte0 = 1;
        else
        if ((!Lsame.lsame(trans, "N") && !Lsame.lsame(trans, "T")) && !Lsame.lsame(trans, "C"))
            byte0 = 2;
        else
        if (n < 0)
            byte0 = 3;
        else
        if (k < 0)
            byte0 = 4;
        else
        if (lda < Math.max(1, i8))
            byte0 = 7;
        else
        if (ldb < Math.max(1, i8))
            byte0 = 9;
        else
        if (ldc < Math.max(1, n))
            byte0 = 12;
        if (byte0 != 0)
        {
            Xerbla.xerbla("DSYR2K", byte0);
            return;
        }
        if ((n == 0) || (((alpha == 0.0) || (k == 0)) && (beta == 1.0)))
            return;
        if(alpha == 0.0)
        {
            if(flag3)
            {
                if(beta == 0.0)
                {
                    int i5 = 1;
                    for(int j8 = n; j8 > 0; j8--)
                    {
                        int i2 = 1;
                        for(int j10 = i5; j10 > 0; j10--)
                        {
                            c[(i2 - 1) + (i5 - 1) * ldc + _c_offset] = 0.0;
                            i2++;
                        }

                        i5++;
                    }

                } else
                {
                    int j5 = 1;
                    for(int k8 = n; k8 > 0; k8--)
                    {
                        int j2 = 1;
                        for(int k10 = j5; k10 > 0; k10--)
                        {
                            c[(j2 - 1) + (j5 - 1) * ldc + _c_offset] = beta * c[(j2 - 1) + (j5 - 1) * ldc + _c_offset];
                            j2++;
                        }

                        j5++;
                    }

                }
            } else
            if(beta == 0.0)
            {
                int k5 = 1;
                for(int l8 = n; l8 > 0; l8--)
                {
                    int k2 = k5;
                    for(int l10 = (n - k5) + 1; l10 > 0; l10--)
                    {
                        c[(k2 - 1) + (k5 - 1) * ldc + _c_offset] = 0.0;
                        k2++;
                    }

                    k5++;
                }

            } else
            {
                int l5 = 1;
                for(int i9 = n; i9 > 0; i9--)
                {
                    int l2 = l5;
                    for(int i11 = (n - l5) + 1; i11 > 0; i11--)
                    {
                        c[(l2 - 1) + (l5 - 1) * ldc + _c_offset] = beta * c[(l2 - 1) + (l5 - 1) * ldc + _c_offset];
                        l2++;
                    }

                    l5++;
                }

            }
            return;
        }
        if (Lsame.lsame(trans, "N"))
        {
            if(flag3)
            {
                int i6 = 1;
                for(int j9 = n; j9 > 0; j9--)
                {
                    if(beta == 0.0)
                    {
                        int i3 = 1;
                        for(int j11 = i6; j11 > 0; j11--)
                        {
                            c[(i3 - 1) + (i6 - 1) * ldc + _c_offset] = 0.0;
                            i3++;
                        }

                    } else
                    if(beta != 1.0)
                    {
                        int j3 = 1;
                        for(int k11 = i6; k11 > 0; k11--)
                        {
                            c[(j3 - 1) + (i6 - 1) * ldc + _c_offset] = beta * c[(j3 - 1) + (i6 - 1) * ldc + _c_offset];
                            j3++;
                        }

                    }
                    int i7 = 1;
                    for(int l11 = k; l11 > 0; l11--)
                    {
                        if((a[(i6 - 1) + (i7 - 1) * lda + _a_offset] != 0.0) || (b[(i6 - 1) + (i7 - 1) * ldb + _b_offset] != 0.0))
                        {
                            double d3 = alpha * b[(i6 - 1) + (i7 - 1) * ldb + _b_offset];
                            double d8 = alpha * a[(i6 - 1) + (i7 - 1) * lda + _a_offset];
                            int k3 = 1;
                            for(int j13 = i6; j13 > 0; j13--)
                            {
                                c[(k3 - 1) + (i6 - 1) * ldc + _c_offset] = c[(k3 - 1) + (i6 - 1) * ldc + _c_offset] + a[(k3 - 1) + (i7 - 1) * lda + _a_offset] * d3 + b[(k3 - 1) + (i7 - 1) * ldb + _b_offset] * d8;
                                k3++;
                            }

                        }
                        i7++;
                    }

                    i6++;
                }

            } else
            {
                int j6 = 1;
                for(int k9 = n; k9 > 0; k9--)
                {
                    if(beta == 0.0)
                    {
                        int l3 = j6;
                        for(int i12 = (n - j6) + 1; i12 > 0; i12--)
                        {
                            c[(l3 - 1) + (j6 - 1) * ldc + _c_offset] = 0.0;
                            l3++;
                        }

                    } else
                    if(beta != 1.0)
                    {
                        int i4 = j6;
                        for(int j12 = (n - j6) + 1; j12 > 0; j12--)
                        {
                            c[(i4 - 1) + (j6 - 1) * ldc + _c_offset] = beta * c[(i4 - 1) + (j6 - 1) * ldc + _c_offset];
                            i4++;
                        }

                    }
                    int j7 = 1;
                    for(int k12 = k; k12 > 0; k12--)
                    {
                        if((a[(j6 - 1) + (j7 - 1) * lda + _a_offset] != 0.0) || (b[(j6 - 1) + (j7 - 1) * ldb + _b_offset] != 0.0))
                        {
                            double d4 = alpha * b[(j6 - 1) + (j7 - 1) * ldb + _b_offset];
                            double d9 = alpha * a[(j6 - 1) + (j7 - 1) * lda + _a_offset];
                            int j4 = j6;
                            for(int k13 = (n - j6) + 1; k13 > 0; k13--)
                            {
                                c[(j4 - 1) + (j6 - 1) * ldc + _c_offset] = c[(j4 - 1) + (j6 - 1) * ldc + _c_offset] + a[(j4 - 1) + (j7 - 1) * lda + _a_offset] * d4 + b[(j4 - 1) + (j7 - 1) * ldb + _b_offset] * d9;
                                j4++;
                            }

                        }
                        j7++;
                    }

                    j6++;
                }

            }
        } else
        if(flag3)
        {
            int k6 = 1;
            for(int l9 = n; l9 > 0; l9--)
            {
                int k4 = 1;
                for(int l12 = (k6 - 1) + 1; l12 > 0; l12--)
                {
                    double d5 = 0.0;
                    double d10 = 0.0;
                    int k7 = 1;
                    for(int l13 = k; l13 > 0; l13--)
                    {
                        d5 += a[(k7 - 1) + (k4 - 1) * lda + _a_offset] * b[(k7 - 1) + (k6 - 1) * ldb + _b_offset];
                        d10 += b[(k7 - 1) + (k4 - 1) * ldb + _b_offset] * a[(k7 - 1) + (k6 - 1) * lda + _a_offset];
                        k7++;
                    }

                    if(beta == 0.0)
                        c[(k4 - 1) + (k6 - 1) * ldc + _c_offset] = alpha * d5 + alpha * d10;
                    else
                        c[(k4 - 1) + (k6 - 1) * ldc + _c_offset] = beta * c[(k4 - 1) + (k6 - 1) * ldc + _c_offset] + alpha * d5 + alpha * d10;
                    k4++;
                }

                k6++;
            }

        } else
        {
            int l6 = 1;
            for (int i10 = n; i10 > 0; i10--)
            {
                int l4 = l6;
                for (int i13 = (n - l6) + 1; i13 > 0; i13--)
                {
                    double d6 = 0.0;
                    double d11 = 0.0;
                    int l7 = 1;
                    for (int i14 = k; i14 > 0; i14--)
                    {
                        d6 += a[(l7 - 1) + (l4 - 1) * lda + _a_offset] * b[(l7 - 1) + (l6 - 1) * ldb + _b_offset];
                        d11 += b[(l7 - 1) + (l4 - 1) * ldb + _b_offset] * a[(l7 - 1) + (l6 - 1) * lda + _a_offset];
                        l7++;
                    }

                    if (beta == 0.0)
                        c[(l4 - 1) + (l6 - 1) * ldc + _c_offset] = alpha * d6 + alpha * d11;
                    else
                        c[(l4 - 1) + (l6 - 1) * ldc + _c_offset] = beta * c[(l4 - 1) + (l6 - 1) * ldc + _c_offset] + alpha * d6 + alpha * d11;
                    l4++;
                }

                l6++;
            }

        }
    }
}

package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dsyrk
{
	public static void dsyrk(String uplo, String trans, int n, int k, double alpha, double[] a, int _a_offset, int lda,
			double beta, double[] c, int _c_offset, int ldc) {

        int k7 = 0;
        boolean flag3 = false;
        if (Lsame.lsame(trans, "N"))
            k7 = n;
        else
            k7 = k;
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
        if (lda < Math.max(1, k7))
            byte0 = 7;
        else
        if (ldc < Math.max(1, n))
            byte0 = 10;
        if (byte0 != 0)
        {
            Xerbla.xerbla("DSYRK ", byte0);
            return;
        }
        if ((n == 0) || (((alpha == 0.0) || (k == 0)) && (beta == 1.0)))
            return;
        if (alpha == 0.0)
        {
            if(flag3)
            {
                if(beta == 0.0)
                {
                    int k4 = 1;
                    for(int l7 = n; l7 > 0; l7--)
                    {
                        int k1 = 1;
                        for(int l9 = k4; l9 > 0; l9--)
                        {
                            c[(k1 - 1) + (k4 - 1) * ldc + _c_offset] = 0.0;
                            k1++;
                        }

                        k4++;
                    }

                } else
                {
                    int l4 = 1;
                    for(int i8 = n; i8 > 0; i8--)
                    {
                        int l1 = 1;
                        for(int i10 = l4; i10 > 0; i10--)
                        {
                            c[(l1 - 1) + (l4 - 1) * ldc + _c_offset] = beta * c[(l1 - 1) + (l4 - 1) * ldc + _c_offset];
                            l1++;
                        }

                        l4++;
                    }

                }
            } else
            if(beta == 0.0)
            {
                int i5 = 1;
                for(int j8 = n; j8 > 0; j8--)
                {
                    int i2 = i5;
                    for(int j10 = (n - i5) + 1; j10 > 0; j10--)
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
                    int j2 = j5;
                    for(int k10 = (n - j5) + 1; k10 > 0; k10--)
                    {
                        c[(j2 - 1) + (j5 - 1) * ldc + _c_offset] = beta * c[(j2 - 1) + (j5 - 1) * ldc + _c_offset];
                        j2++;
                    }

                    j5++;
                }

            }
            return;
        }
        if (Lsame.lsame(trans, "N"))
        {
            if(flag3)
            {
                int k5 = 1;
                for(int l8 = n; l8 > 0; l8--)
                {
                    if(beta == 0.0)
                    {
                        int k2 = 1;
                        for (int l10 = k5; l10 > 0; l10--)
                        {
                            c[(k2 - 1) + (k5 - 1) * ldc + _c_offset] = 0.0;
                            k2++;
                        }

                    } else
                    if (beta != 1.0)
                    {
                        int l2 = 1;
                        for(int i11 = k5; i11 > 0; i11--)
                        {
                            c[(l2 - 1) + (k5 - 1) * ldc + _c_offset] = beta * c[(l2 - 1) + (k5 - 1) * ldc + _c_offset];
                            l2++;
                        }

                    }
                    int k6 = 1;
                    for (int j11 = k; j11 > 0; j11--)
                    {
                        if(a[(k5 - 1) + (k6 - 1) * lda + _a_offset] != 0.0)
                        {
                            double d3 = alpha * a[(k5 - 1) + (k6 - 1) * lda + _a_offset];
                            int i3 = 1;
                            for (int l12 = k5; l12 > 0; l12--)
                            {
                                c[(i3 - 1) + (k5 - 1) * ldc + _c_offset] = c[(i3 - 1) + (k5 - 1) * ldc + _c_offset] + d3 * a[(i3 - 1) + (k6 - 1) * lda + _a_offset];
                                i3++;
                            }

                        }
                        k6++;
                    }

                    k5++;
                }

            } else
            {
                int l5 = 1;
                for (int i9 = n; i9 > 0; i9--)
                {
                    if(beta == 0.0)
                    {
                        int j3 = l5;
                        for (int k11 = (n - l5) + 1; k11 > 0; k11--)
                        {
                            c[(j3 - 1) + (l5 - 1) * ldc + _c_offset] = 0.0;
                            j3++;
                        }

                    } else
                    if (beta != 1.0)
                    {
                        int k3 = l5;
                        for (int l11 = (n - l5) + 1; l11 > 0; l11--)
                        {
                            c[(k3 - 1) + (l5 - 1) * ldc + _c_offset] = beta * c[(k3 - 1) + (l5 - 1) * ldc + _c_offset];
                            k3++;
                        }

                    }
                    int l6 = 1;
                    for (int i12 = k; i12 > 0; i12--)
                    {
                        if(a[(l5 - 1) + (l6 - 1) * lda + _a_offset] != 0.0)
                        {
                            double d4 = alpha * a[(l5 - 1) + (l6 - 1) * lda + _a_offset];
                            int l3 = l5;
                            for (int i13 = (n - l5) + 1; i13 > 0; i13--)
                            {
                                c[(l3 - 1) + (l5 - 1) * ldc + _c_offset] = c[(l3 - 1) + (l5 - 1) * ldc + _c_offset] + d4 * a[(l3 - 1) + (l6 - 1) * lda + _a_offset];
                                l3++;
                            }

                        }
                        l6++;
                    }

                    l5++;
                }

            }
        } else
        if (flag3)
        {
            int i6 = 1;
            for (int j9 = n; j9 > 0; j9--)
            {
                int i4 = 1;
                for (int j12 = i6; j12 > 0; j12--)
                {
                    double d5 = 0.0;
                    int i7 = 1;
                    for (int j13 = k; j13 > 0; j13--)
                    {
                        d5 += a[(i7 - 1) + (i4 - 1) * lda + _a_offset] * a[(i7 - 1) + (i6 - 1) * lda + _a_offset];
                        i7++;
                    }

                    if(beta == 0.0)
                        c[(i4 - 1) + (i6 - 1) * ldc + _c_offset] = alpha * d5;
                    else
                        c[(i4 - 1) + (i6 - 1) * ldc + _c_offset] = alpha * d5 + beta * c[(i4 - 1) + (i6 - 1) * ldc + _c_offset];
                    i4++;
                }

                i6++;
            }

        } else
        {
            int j6 = 1;
            for (int k9 = n; k9 > 0; k9--)
            {
                int j4 = j6;
                for (int k12 = (n - j6) + 1; k12 > 0; k12--)
                {
                    double d6 = 0.0;
                    int j7 = 1;
                    for (int k13 = k; k13 > 0; k13--)
                    {
                        d6 += a[(j7 - 1) + (j4 - 1) * lda + _a_offset] * a[(j7 - 1) + (j6 - 1) * lda + _a_offset];
                        j7++;
                    }

                    if (beta == 0.0)
                        c[(j4 - 1) + (j6 - 1) * ldc + _c_offset] = alpha * d6;
                    else
                        c[(j4 - 1) + (j6 - 1) * ldc + _c_offset] = alpha * d6 + beta * c[(j4 - 1) + (j6 - 1) * ldc + _c_offset];
                    j4++;
                }

                j6++;
            }

        }
    }
}

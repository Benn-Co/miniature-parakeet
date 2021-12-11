package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dgbmv
{
	public static void dgbmv(String trans, int m, int n, int kl, int ku, double alpha, double[] a, int _a_offset,
			int lda, double[] x, int _x_offset, int incx, double beta, double[] y, int _y_offset, int incy) {

        int byte0 = 0;
        int l7 = 0;
        int i8 = 0;
        int j8 = 0;
        int k8 = 0;
        int l8 = 0;
        byte0 = 0;
        if (!Lsame.lsame(trans, "N") && !Lsame.lsame(trans, "T") && !Lsame.lsame(trans, "C"))
            byte0 = 1;
        else
        if (m < 0)
            byte0 = 2;
        else
        if (n < 0)
            byte0 = 3;
        else
        if (kl < 0)
            byte0 = 4;
        else
        if (ku < 0)
            byte0 = 5;
        else
        if (lda < kl + ku + 1)
            byte0 = 8;
        else
        if (incx == 0)
            byte0 = 10;
        else
        if (incy == 0)
            byte0 = 13;
        if (byte0 != 0)
        {
            Xerbla.xerbla("DGBMV ", byte0);
            return;
        }
        if (((m == 0) || (n == 0)) || ((alpha == 0.0) && (beta == 1.0)))
            return;
        if (Lsame.lsame(trans, "N"))
        {
            k8 = n;
            l8 = m;
        } else
        {
            k8 = m;
            l8 = n;
        }
        if (incx > 0)
            i8 = 1;
        else
            i8 = 1 - (k8 - 1) * incx;
        if (incy > 0)
            j8 = 1;
        else
            j8 = 1 - (l8 - 1) * incy;
        if (beta != 1.0)
            if (incy == 1)
            {
                if (beta == 0.0)
                {
                    int k2 = 1;
                    for (int i9 = l8; i9 > 0; i9--)
                    {
                        y[(k2 - 1) + _y_offset] = 0.0;
                        k2++;
                    }

                } else
                {
                    int l2 = 1;
                    for (int j9 = l8; j9 > 0; j9--)
                    {
                        y[(l2 - 1) + _y_offset] = beta * y[(l2 - 1) + _y_offset];
                        l2++;
                    }

                }
            } else
            {
                int l4 = j8;
                if (beta == 0.0)
                {
                    for (int k9 = l8; k9 > 0; k9--)
                    {
                        y[(l4 - 1) + _y_offset] = 0.0;
                        l4 += incy;
                    }

                } else
                {
                    for (int l9 = l8; l9 > 0; l9--)
                    {
                        y[(l4 - 1) + _y_offset] = beta * y[(l4 - 1) + _y_offset];
                        l4 += incy;
                    }

                }
            }
        if (alpha == 0.0)
            return;
        l7 = ku + 1;
        if (Lsame.lsame(trans, "N"))
        {
            int j6 = i8;
            if (incy == 1)
            {
                int j5 = 1;
                for (int i10 = n; i10 > 0; i10--)
                {
                    if (x[(j6 - 1) + _x_offset] != 0.0)
                    {
                        double d3 = alpha * x[(j6 - 1) + _x_offset];
                        int l6 = l7 - j5;
                        int k3 = Math.max(1, j5 - ku);
                        for (int i11 = (Math.min(m, j5 + kl) - Math.max(1, j5 - ku)) + 1; i11 > 0; i11--)
                        {
                            y[(k3 - 1) + _y_offset] = y[(k3 - 1) + _y_offset] + d3 * a[((l6 + k3) - 1) + (j5 - 1) * lda + _a_offset];
                            k3++;
                        }

                    }
                    j6 += incx;
                    j5++;
                }

            } else
            {
                int k5 = 1;
                for (int j10 = n; j10 > 0; j10--)
                {
                    if (x[(j6 - 1) + _x_offset] != 0.0)
                    {
                        double d4 = alpha * x[(j6 - 1) + _x_offset];
                        int i5 = j8;
                        int i7 = l7 - k5;
                        int l3 = Math.max(1, k5 - ku);
                        for (int j11 = (Math.min(m, k5 + kl) - Math.max(1, k5 - ku)) + 1; j11 > 0; j11--)
                        {
                            y[(i5 - 1) + _y_offset] = y[(i5 - 1) + _y_offset] + d4 * a[((i7 + l3) - 1) + (k5 - 1) * lda + _a_offset];
                            i5 += incy;
                            l3++;
                        }

                    }
                    j6 += incx;
                    if (k5 > ku)
                        j8 += incy;
                    k5++;
                }

            }
        } else
        {
            int k6 = j8;
            if (incx == 1)
            {
                int l5 = 1;
                for (int k10 = n; k10 > 0; k10--)
                {
                    double d5 = 0.0;
                    int j7 = l7 - l5;
                    int i4 = Math.max(1, l5 - ku);
                    for (int k11 = (Math.min(m, l5 + kl) - Math.max(1, l5 - ku)) + 1; k11 > 0; k11--)
                    {
                        d5 += a[((j7 + i4) - 1) + (l5 - 1) * lda + _a_offset] * x[(i4 - 1) + _x_offset];
                        i4++;
                    }

                    y[(k6 - 1) + _y_offset] = y[(k6 - 1) + _y_offset] + alpha * d5;
                    k6 += incy;
                    l5++;
                }

            } else
            {
                int i6 = 1;
                for (int l10 = n; l10 > 0; l10--)
                {
                    double d6 = 0.0;
                    int k4 = i8;
                    int k7 = l7 - i6;
                    int j4 = Math.max(1, i6 - ku);
                    for (int l11 = (Math.min(m, i6 + kl) - Math.max(1, i6 - ku)) + 1; l11 > 0; l11--)
                    {
                        d6 += a[((k7 + j4) - 1) + (i6 - 1) * lda + _a_offset] * x[(k4 - 1) + _x_offset];
                        k4 += incx;
                        j4++;
                    }

                    y[(k6 - 1) + _y_offset] = y[(k6 - 1) + _y_offset] + alpha * d6;
                    k6 += incy;
                    if (i6 > ku)
                        i8 += incx;
                    i6++;
                }

            }
        }
    }
}

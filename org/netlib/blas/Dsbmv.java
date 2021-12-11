package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dsbmv
{
	public static void dsbmv(String uplo, int n, int k, double alpha, double[] a, int _a_offset, int lda, double[] x,
			int _x_offset, int incx, double beta, double[] y, int _y_offset, int incy) {

        int byte0 = 0;
        int k7 = 0;
        int l7 = 0;
        byte0 = 0;
        if (!Lsame.lsame(uplo, "U") && !Lsame.lsame(uplo, "L"))
            byte0 = 1;
        else
        if (n < 0)
            byte0 = 2;
        else
        if (k < 0)
            byte0 = 3;
        else
        if(lda < k + 1)
            byte0 = 6;
        else
        if (incx == 0)
            byte0 = 8;
        else
        if (incy == 0)
            byte0 = 11;
        if (byte0 != 0)
        {
            Xerbla.xerbla("DSBMV ", byte0);
            return;
        }
        if ((n == 0) || ((alpha == 0.0) && (beta == 1.0)))
            return;
        if(incx > 0)
            k7 = 1;
        else
            k7 = 1 - (n - 1) * incx;
        if(incy > 0)
            l7 = 1;
        else
            l7 = 1 - (n - 1) * incy;
        if(beta != 1.0)
            if(incy == 1)
            {
                if(beta == 0.0)
                {
                    int i2 = 1;
                    for(int i9 = n; i9 > 0; i9--)
                    {
                        y[(i2 - 1) + _y_offset] = 0.0;
                        i2++;
                    }

                } else
                {
                    int j2 = 1;
                    for(int j9 = n; j9 > 0; j9--)
                    {
                        y[(j2 - 1) + _y_offset] = beta * y[(j2 - 1) + _y_offset];
                        j2++;
                    }

                }
            } else
            {
                int k4 = l7;
                if(beta == 0.0)
                {
                    for(int k9 = n; k9 > 0; k9--)
                    {
                        y[(k4 - 1) + _y_offset] = 0.0;
                        k4 += incy;
                    }

                } else
                {
                    for(int l9 = n; l9 > 0; l9--)
                    {
                        y[(k4 - 1) + _y_offset] = beta * y[(k4 - 1) + _y_offset];
                        k4 += incy;
                    }

                }
            }
        if (alpha == 0.0)
            return;
        if (Lsame.lsame(uplo, "U"))
        {
            int j7 = k + 1;
            if ((incx == 1) && (incy == 1))
            {
                int j5 = 1;
                for(int i10 = n; i10 > 0; i10--)
                {
                    double d3 = alpha * x[(j5 - 1) + _x_offset];
                    double d8 = 0.0;
                    int i8 = j7 - j5;
                    int i3 = Math.max(1, j5 - k);
                    for(int i11 = (j5 - 1 - Math.max(1, j5 - k)) + 1; i11 > 0; i11--)
                    {
                        y[(i3 - 1) + _y_offset] = y[(i3 - 1) + _y_offset] + d3 * a[((i8 + i3) - 1) + (j5 - 1) * lda + _a_offset];
                        d8 += a[((i8 + i3) - 1) + (j5 - 1) * lda + _a_offset] * x[(i3 - 1) + _x_offset];
                        i3++;
                    }

                    y[(j5 - 1) + _y_offset] = y[(j5 - 1) + _y_offset] + d3 * a[(j7 - 1) + (j5 - 1) * lda + _a_offset] + alpha * d8;
                    j5++;
                }

            } else
            {
                int j6 = k7;
                int l6 = l7;
                int k5 = 1;
                for(int j10 = n; j10 > 0; j10--)
                {
                    double d4 = alpha * x[(j6 - 1) + _x_offset];
                    double d9 = 0.0;
                    int i4 = k7;
                    int l4 = l7;
                    int j8 = j7 - k5;
                    int j3 = Math.max(1, k5 - k);
                    for(int j11 = (k5 - 1 - Math.max(1, k5 - k)) + 1; j11 > 0; j11--)
                    {
                        y[(l4 - 1) + _y_offset] = y[(l4 - 1) + _y_offset] + d4 * a[((j8 + j3) - 1) + (k5 - 1) * lda + _a_offset];
                        d9 += a[((j8 + j3) - 1) + (k5 - 1) * lda + _a_offset] * x[(i4 - 1) + _x_offset];
                        i4 += incx;
                        l4 += incy;
                        j3++;
                    }

                    y[(l6 - 1) + _y_offset] = y[(l6 - 1) + _y_offset] + d4 * a[(j7 - 1) + (k5 - 1) * lda + _a_offset] + alpha * d9;
                    j6 += incx;
                    l6 += incy;
                    if(k5 > k)
                    {
                        k7 += incx;
                        l7 += incy;
                    }
                    k5++;
                }

            }
        } else
        if ((incx == 1) && (incy == 1))
        {
            int l5 = 1;
            for(int k10 = n; k10 > 0; k10--)
            {
                double d5 = alpha * x[(l5 - 1) + _x_offset];
                double d10 = 0.0;
                y[(l5 - 1) + _y_offset] = y[(l5 - 1) + _y_offset] + d5 * a[(1 - 1) + (l5 - 1) * lda + _a_offset];
                int k8 = 1 - l5;
                int k3 = l5 + 1;
                for(int k11 = (Math.min(n, l5 + k) - (l5 + 1)) + 1; k11 > 0; k11--)
                {
                    y[(k3 - 1) + _y_offset] = y[(k3 - 1) + _y_offset] + d5 * a[((k8 + k3) - 1) + (l5 - 1) * lda + _a_offset];
                    d10 += a[((k8 + k3) - 1) + (l5 - 1) * lda + _a_offset] * x[(k3 - 1) + _x_offset];
                    k3++;
                }

                y[(l5 - 1) + _y_offset] = y[(l5 - 1) + _y_offset] + alpha * d10;
                l5++;
            }

        } else
        {
            int k6 = k7;
            int i7 = l7;
            int i6 = 1;
            for (int l10 = n; l10 > 0; l10--)
            {
                double d6 = alpha * x[(k6 - 1) + _x_offset];
                double d11 = 0.0;
                y[(i7 - 1) + _y_offset] = y[(i7 - 1) + _y_offset] + d6 * a[(1 - 1) + (i6 - 1) * lda + _a_offset];
                int l8 = 1 - i6;
                int j4 = k6;
                int i5 = i7;
                int l3 = i6 + 1;
                for (int l11 = (Math.min(n, i6 + k) - (i6 + 1)) + 1; l11 > 0; l11--)
                {
                    j4 += incx;
                    i5 += incy;
                    y[(i5 - 1) + _y_offset] = y[(i5 - 1) + _y_offset] + d6 * a[((l8 + l3) - 1) + (i6 - 1) * lda + _a_offset];
                    d11 += a[((l8 + l3) - 1) + (i6 - 1) * lda + _a_offset] * x[(j4 - 1) + _x_offset];
                    l3++;
                }

                y[(i7 - 1) + _y_offset] = y[(i7 - 1) + _y_offset] + alpha * d11;
                k6 += incx;
                i7 += incy;
                i6++;
            }

        }
    }
}

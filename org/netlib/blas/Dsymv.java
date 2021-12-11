package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dsymv
{
	public static void dsymv(String uplo, int n, double alpha, double[] a, int _a_offset, int lda, double[] x,
			int _x_offset, int incx, double beta, double[] y, int _y_offset, int incy) {

        int i7 = 0;
        int j7 = 0;
        int byte0 = 0;
        if (!Lsame.lsame(uplo, "U") && !Lsame.lsame(uplo, "L"))
            byte0 = 1;
        else
        if (n < 0)
            byte0 = 2;
        else
        if (lda < Math.max(1, n))
            byte0 = 5;
        else
        if (incx == 0)
            byte0 = 7;
        else
        if (incy == 0)
            byte0 = 10;
        if (byte0 != 0)
        {
            Xerbla.xerbla("DSYMV ", byte0);
            return;
        }
        if (n == 0 || (alpha == 0.0 && beta == 1.0))
            return;
        if (incx > 0)
            i7 = 1;
        else
            i7 = 1 - (n - 1) * incx;
        if(incy > 0)
            j7 = 1;
        else
            j7 = 1 - (n - 1) * incy;
        if(beta != 1.0)
            if(incy == 1)
            {
                if(beta == 0.0)
                {
                    int l1 = 1;
                    for(int k7 = n; k7 > 0; k7--)
                    {
                        y[(l1 - 1) + _y_offset] = 0.0;
                        l1++;
                    }

                } else
                {
                    int i2 = 1;
                    for(int l7 = n; l7 > 0; l7--)
                    {
                        y[(i2 - 1) + _y_offset] = beta * y[(i2 - 1) + _y_offset];
                        i2++;
                    }

                }
            } else
            {
                int j4 = j7;
                if(beta == 0.0)
                {
                    for(int i8 = n; i8 > 0; i8--)
                    {
                        y[(j4 - 1) + _y_offset] = 0.0;
                        j4 += incy;
                    }

                } else
                {
                    for(int j8 = n; j8 > 0; j8--)
                    {
                        y[(j4 - 1) + _y_offset] = beta * y[(j4 - 1) + _y_offset];
                        j4 += incy;
                    }

                }
            }
        if (alpha == 0.0)
            return;
        if (Lsame.lsame(uplo, "U"))
        {
            if((incx == 1) && (incy == 1))
            {
                int i5 = 1;
                for(int k8 = n; k8 > 0; k8--)
                {
                    double d3 = alpha * x[(i5 - 1) + _x_offset];
                    double d8 = 0.0;
                    int l2 = 1;
                    for(int k9 = i5 - 1; k9 > 0; k9--)
                    {
                        y[(l2 - 1) + _y_offset] = y[(l2 - 1) + _y_offset] + d3 * a[(l2 - 1) + (i5 - 1) * lda + _a_offset];
                        d8 += a[(l2 - 1) + (i5 - 1) * lda + _a_offset] * x[(l2 - 1) + _x_offset];
                        l2++;
                    }

                    y[(i5 - 1) + _y_offset] = y[(i5 - 1) + _y_offset] + d3 * a[(i5 - 1) + (i5 - 1) * lda + _a_offset] + alpha * d8;
                    i5++;
                }

            } else
            {
                int i6 = i7;
                int k6 = j7;
                int j5 = 1;
                for(int l8 = n; l8 > 0; l8--)
                {
                    double d4 = alpha * x[(i6 - 1) + _x_offset];
                    double d9 = 0.0;
                    int l3 = i7;
                    int k4 = j7;
                    int i3 = 1;
                    for(int l9 = j5 - 1; l9 > 0; l9--)
                    {
                        y[(k4 - 1) + _y_offset] = y[(k4 - 1) + _y_offset] + d4 * a[(i3 - 1) + (j5 - 1) * lda + _a_offset];
                        d9 += a[(i3 - 1) + (j5 - 1) * lda + _a_offset] * x[(l3 - 1) + _x_offset];
                        l3 += incx;
                        k4 += incy;
                        i3++;
                    }

                    y[(k6 - 1) + _y_offset] = y[(k6 - 1) + _y_offset] + d4 * a[(j5 - 1) + (j5 - 1) * lda + _a_offset] + alpha * d9;
                    i6 += incx;
                    k6 += incy;
                    j5++;
                }

            }
        } else
        if ((incx == 1) && (incy == 1))
        {
            int k5 = 1;
            for(int i9 = n; i9 > 0; i9--)
            {
                double d5 = alpha * x[(k5 - 1) + _x_offset];
                double d10 = 0.0;
                y[(k5 - 1) + _y_offset] = y[(k5 - 1) + _y_offset] + d5 * a[(k5 - 1) + (k5 - 1) * lda + _a_offset];
                int j3 = k5 + 1;
                for(int i10 = (n - (k5 + 1)) + 1; i10 > 0; i10--)
                {
                    y[(j3 - 1) + _y_offset] = y[(j3 - 1) + _y_offset] + d5 * a[(j3 - 1) + (k5 - 1) * lda + _a_offset];
                    d10 += a[(j3 - 1) + (k5 - 1) * lda + _a_offset] * x[(j3 - 1) + _x_offset];
                    j3++;
                }

                y[(k5 - 1) + _y_offset] = y[(k5 - 1) + _y_offset] + alpha * d10;
                k5++;
            }

        } else
        {
            int j6 = i7;
            int l6 = j7;
            int l5 = 1;
            for (int j9 = n; j9 > 0; j9--)
            {
                double d6 = alpha * x[(j6 - 1) + _x_offset];
                double d11 = 0.0;
                y[(l6 - 1) + _y_offset] = y[(l6 - 1) + _y_offset] + d6 * a[(l5 - 1) + (l5 - 1) * lda + _a_offset];
                int i4 = j6;
                int l4 = l6;
                int k3 = l5 + 1;
                for (int j10 = (n - (l5 + 1)) + 1; j10 > 0; j10--)
                {
                    i4 += incx;
                    l4 += incy;
                    y[(l4 - 1) + _y_offset] = y[(l4 - 1) + _y_offset] + d6 * a[(k3 - 1) + (l5 - 1) * lda + _a_offset];
                    d11 += a[(k3 - 1) + (l5 - 1) * lda + _a_offset] * x[(i4 - 1) + _x_offset];
                    k3++;
                }

                y[(l6 - 1) + _y_offset] = y[(l6 - 1) + _y_offset] + alpha * d11;
                j6 += incx;
                l6 += incy;
                l5++;
            }

        }
    }
}

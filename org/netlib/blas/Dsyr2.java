package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dsyr2
{
	public static void dsyr2(String uplo, int n, double alpha, double[] x, int _x_offset, int incx, double[] y,
			int _y_offset, int incy, double[] a, int _a_offset, int lda) {

        int l4 = 0;
        int i5 = 0;
        int j5 = 0;
        int k5 = 0;
        int byte0 = 0;
        if (!Lsame.lsame(uplo, "U") && !Lsame.lsame(uplo, "L"))
            byte0 = 1;
        else
        if (n < 0)
            byte0 = 2;
        else
        if (incx == 0)
            byte0 = 5;
        else
        if (incy == 0)
            byte0 = 7;
        else
        if (lda < Math.max(1, n))
            byte0 = 9;
        if (byte0 != 0)
        {
            Xerbla.xerbla("DSYR2 ", byte0);
            return;
        }
        if (n == 0 || alpha == 0.0)
            return;
        if (incx != 1 || incy != 1)
        {
            if(incx > 0)
                j5 = 1;
            else
                j5 = 1 - (n - 1) * incx;
            if(incy > 0)
                k5 = 1;
            else
                k5 = 1 - (n - 1) * incy;
            l4 = j5;
            i5 = k5;
        }
        if(Lsame.lsame(uplo, "U"))
        {
            if((incx == 1) && (incy == 1))
            {
                int l3 = 1;
                for(int l5 = n; l5 > 0; l5--)
                {
                    if((x[(l3 - 1) + _x_offset] != 0.0) || (y[(l3 - 1) + _y_offset] != 0.0))
                    {
                        double d2 = alpha * y[(l3 - 1) + _y_offset];
                        double d7 = alpha * x[(l3 - 1) + _x_offset];
                        int l1 = 1;
                        for(int l6 = l3; l6 > 0; l6--)
                        {
                            a[(l1 - 1) + (l3 - 1) * lda + _a_offset] = a[(l1 - 1) + (l3 - 1) * lda + _a_offset] + x[(l1 - 1) + _x_offset] * d2 + y[(l1 - 1) + _y_offset] * d7;
                            l1++;
                        }

                    }
                    l3++;
                }

            } else
            {
                int i4 = 1;
                for(int i6 = n; i6 > 0; i6--)
                {
                    if((x[(l4 - 1) + _x_offset] != 0.0) || (y[(i5 - 1) + _y_offset] != 0.0))
                    {
                        double d3 = alpha * y[(i5 - 1) + _y_offset];
                        double d8 = alpha * x[(l4 - 1) + _x_offset];
                        int l2 = j5;
                        int j3 = k5;
                        int i2 = 1;
                        for(int i7 = i4; i7 > 0; i7--)
                        {
                            a[(i2 - 1) + (i4 - 1) * lda + _a_offset] = a[(i2 - 1) + (i4 - 1) * lda + _a_offset] + x[(l2 - 1) + _x_offset] * d3 + y[(j3 - 1) + _y_offset] * d8;
                            l2 += incx;
                            j3 += incy;
                            i2++;
                        }

                    }
                    l4 += incx;
                    i5 += incy;
                    i4++;
                }

            }
        } else
        if((incx == 1) && (incy == 1))
        {
            int j4 = 1;
            for(int j6 = n; j6 > 0; j6--)
            {
                if((x[(j4 - 1) + _x_offset] != 0.0) || (y[(j4 - 1) + _y_offset] != 0.0))
                {
                    double d4 = alpha * y[(j4 - 1) + _y_offset];
                    double d9 = alpha * x[(j4 - 1) + _x_offset];
                    int j2 = j4;
                    for(int j7 = (n - j4) + 1; j7 > 0; j7--)
                    {
                        a[(j2 - 1) + (j4 - 1) * lda + _a_offset] = a[(j2 - 1) + (j4 - 1) * lda + _a_offset] + x[(j2 - 1) + _x_offset] * d4 + y[(j2 - 1) + _y_offset] * d9;
                        j2++;
                    }

                }
                j4++;
            }

        } else
        {
            int k4 = 1;
            for (int k6 = n; k6 > 0; k6--)
            {
                if ((x[(l4 - 1) + _x_offset] != 0.0) || (y[(i5 - 1) + _y_offset] != 0.0))
                {
                    double d5 = alpha * y[(i5 - 1) + _y_offset];
                    double d10 = alpha * x[(l4 - 1) + _x_offset];
                    int i3 = l4;
                    int k3 = i5;
                    int k2 = k4;
                    for (int k7 = (n - k4) + 1; k7 > 0; k7--)
                    {
                        a[(k2 - 1) + (k4 - 1) * lda + _a_offset] = a[(k2 - 1) + (k4 - 1) * lda + _a_offset] + x[(i3 - 1) + _x_offset] * d5 + y[(k3 - 1) + _y_offset] * d10;
                        i3 += incx;
                        k3 += incy;
                        k2++;
                    }

                }
                l4 += incx;
                i5 += incy;
                k4++;
            }

        }
    }
}

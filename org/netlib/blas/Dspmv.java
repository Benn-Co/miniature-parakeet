package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dspmv
{
	public static void dspmv(String uplo, int n, double alpha, double[] ap, int _ap_offset, double[] x, int _x_offset,
			int incx, double beta, double[] y, int _y_offset, int incy) {

        int byte0 = 0;
        int j7 = 0;
        int k7 = 0;
        int l7 = 0;
        byte0 = 0;
        if (!Lsame.lsame(uplo, "U") && !Lsame.lsame(uplo, "L"))
            byte0 = 1;
        else
        if (n < 0)
            byte0 = 2;
        else
        if (incx == 0)
            byte0 = 6;
        else
        if (incy == 0)
            byte0 = 9;
        if (byte0 != 0)
        {
            Xerbla.xerbla("DSPMV ", byte0);
            return;
        }
        if ((n == 0) || ((alpha == 0.0) && (beta == 1.0)))
            return;
        if (incx > 0)
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
                    int k1 = 1;
                    for(int i8 = n; i8 > 0; i8--)
                    {
                        y[(k1 - 1) + _y_offset] = 0.0;
                        k1++;
                    }

                } else
                {
                    int l1 = 1;
                    for(int j8 = n; j8 > 0; j8--)
                    {
                        y[(l1 - 1) + _y_offset] = beta * y[(l1 - 1) + _y_offset];
                        l1++;
                    }

                }
            } else
            {
                int k3 = l7;
                if(beta == 0.0)
                {
                    for(int k8 = n; k8 > 0; k8--)
                    {
                        y[(k3 - 1) + _y_offset] = 0.0;
                        k3 += incy;
                    }

                } else
                {
                    for(int l8 = n; l8 > 0; l8--)
                    {
                        y[(k3 - 1) + _y_offset] = beta * y[(k3 - 1) + _y_offset];
                        k3 += incy;
                    }

                }
            }
        if (alpha == 0.0)
            return;
        j7 = 1;
        if (Lsame.lsame(uplo, "U"))
        {
            if((incx == 1) && (incy == 1))
            {
                int j4 = 1;
                for(int i9 = n; i9 > 0; i9--)
                {
                    double d3 = alpha * x[(j4 - 1) + _x_offset];
                    double d8 = 0.0;
                    int j6 = j7;
                    int k2 = 1;
                    for(int i10 = j4 - 1; i10 > 0; i10--)
                    {
                        y[(k2 - 1) + _y_offset] = y[(k2 - 1) + _y_offset] + d3 * ap[(j6 - 1) + _ap_offset];
                        d8 += ap[(j6 - 1) + _ap_offset] * x[(k2 - 1) + _x_offset];
                        j6++;
                        k2++;
                    }

                    y[(j4 - 1) + _y_offset] = y[(j4 - 1) + _y_offset] + d3 * ap[((j7 + j4) - 1 - 1) + _ap_offset] + alpha * d8;
                    j7 += j4;
                    j4++;
                }

            } else
            {
                int j5 = k7;
                int l5 = l7;
                int k4 = 1;
                for(int j9 = n; j9 > 0; j9--)
                {
                    double d4 = alpha * x[(j5 - 1) + _x_offset];
                    double d9 = 0.0;
                    int i3 = k7;
                    int l3 = l7;
                    int k6 = j7;
                    for(int j10 = ((j7 + k4) - 2 - j7) + 1; j10 > 0; j10--)
                    {
                        y[(l3 - 1) + _y_offset] = y[(l3 - 1) + _y_offset] + d4 * ap[(k6 - 1) + _ap_offset];
                        d9 += ap[(k6 - 1) + _ap_offset] * x[(i3 - 1) + _x_offset];
                        i3 += incx;
                        l3 += incy;
                        k6++;
                    }

                    y[(l5 - 1) + _y_offset] = y[(l5 - 1) + _y_offset] + d4 * ap[((j7 + k4) - 1 - 1) + _ap_offset] + alpha * d9;
                    j5 += incx;
                    l5 += incy;
                    j7 += k4;
                    k4++;
                }

            }
        } else
        if((incx == 1) && (incy == 1))
        {
            int l4 = 1;
            for(int k9 = n; k9 > 0; k9--)
            {
                double d5 = alpha * x[(l4 - 1) + _x_offset];
                double d10 = 0.0;
                y[(l4 - 1) + _y_offset] = y[(l4 - 1) + _y_offset] + d5 * ap[(j7 - 1) + _ap_offset];
                int l6 = j7 + 1;
                int l2 = l4 + 1;
                for(int k10 = (n - (l4 + 1)) + 1; k10 > 0; k10--)
                {
                    y[(l2 - 1) + _y_offset] = y[(l2 - 1) + _y_offset] + d5 * ap[(l6 - 1) + _ap_offset];
                    d10 += ap[(l6 - 1) + _ap_offset] * x[(l2 - 1) + _x_offset];
                    l6++;
                    l2++;
                }

                y[(l4 - 1) + _y_offset] = y[(l4 - 1) + _y_offset] + alpha * d10;
                j7 += (n - l4) + 1;
                l4++;
            }

        } else
        {
            int k5 = k7;
            int i6 = l7;
            int i5 = 1;
            for (int l9 = n; l9 > 0; l9--)
            {
                double d6 = alpha * x[(k5 - 1) + _x_offset];
                double d11 = 0.0;
                y[(i6 - 1) + _y_offset] = y[(i6 - 1) + _y_offset] + d6 * ap[(j7 - 1) + _ap_offset];
                int j3 = k5;
                int i4 = i6;
                int i7 = j7 + 1;
                for (int l10 = ((j7 + n) - i5 - (j7 + 1)) + 1; l10 > 0; l10--)
                {
                    j3 += incx;
                    i4 += incy;
                    y[(i4 - 1) + _y_offset] = y[(i4 - 1) + _y_offset] + d6 * ap[(i7 - 1) + _ap_offset];
                    d11 += ap[(i7 - 1) + _ap_offset] * x[(j3 - 1) + _x_offset];
                    i7++;
                }

                y[(i6 - 1) + _y_offset] = y[(i6 - 1) + _y_offset] + alpha * d11;
                k5 += incx;
                i6 += incy;
                j7 += (n - i5) + 1;
                i5++;
            }

        }
    }
}

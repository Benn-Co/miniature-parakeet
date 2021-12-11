package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dspr2
{
	public static void dspr2(String uplo, int n, double alpha, double[] x, int _x_offset, int incx, double[] y,
			int _y_offset, int incy, double[] ap, int _ap_offset) {

        int byte0 = 0;
        int i4 = 0;
        int j4 = 0;
        int k5 = 0;
        int l5 = 0;
        int i6 = 0;
        byte0 = 0;
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
        if (byte0 != 0)
        {
            Xerbla.xerbla("DSPR2 ", byte0);
            return;
        }
        if (n == 0 || alpha == 0.0)
            return;
        if (incx != 1 || incy != 1)
        {
            if(incx > 0)
                l5 = 1;
            else
                l5 = 1 - (n - 1) * incx;
            if(incy > 0)
                i6 = 1;
            else
                i6 = 1 - (n - 1) * incy;
            i4 = l5;
            j4 = i6;
        }
        k5 = 1;
        if(Lsame.lsame(uplo, "U"))
        {
            if((incx == 1) && (incy == 1))
            {
                int i3 = 1;
                for(int j6 = n; j6 > 0; j6--)
                {
                    if((x[(i3 - 1) + _x_offset] != 0.0) || (y[(i3 - 1) + _y_offset] != 0.0))
                    {
                        double d2 = alpha * y[(i3 - 1) + _y_offset];
                        double d7 = alpha * x[(i3 - 1) + _x_offset];
                        int k4 = k5;
                        int k1 = 1;
                        for(int j7 = i3; j7 > 0; j7--)
                        {
                            ap[(k4 - 1) + _ap_offset] = ap[(k4 - 1) + _ap_offset] + x[(k1 - 1) + _x_offset] * d2 + y[(k1 - 1) + _y_offset] * d7;
                            k4++;
                            k1++;
                        }

                    }
                    k5 += i3;
                    i3++;
                }

            } else
            {
                int j3 = 1;
                for(int k6 = n; k6 > 0; k6--)
                {
                    if((x[(i4 - 1) + _x_offset] != 0.0) || (y[(j4 - 1) + _y_offset] != 0.0))
                    {
                        double d3 = alpha * y[(j4 - 1) + _y_offset];
                        double d8 = alpha * x[(i4 - 1) + _x_offset];
                        int i2 = l5;
                        int k2 = i6;
                        int l4 = k5;
                        for(int k7 = ((k5 + j3) - 1 - k5) + 1; k7 > 0; k7--)
                        {
                            ap[(l4 - 1) + _ap_offset] = ap[(l4 - 1) + _ap_offset] + x[(i2 - 1) + _x_offset] * d3 + y[(k2 - 1) + _y_offset] * d8;
                            i2 += incx;
                            k2 += incy;
                            l4++;
                        }

                    }
                    i4 += incx;
                    j4 += incy;
                    k5 += j3;
                    j3++;
                }

            }
        } else
        if((incx == 1) && (incy == 1))
        {
            int k3 = 1;
            for(int l6 = n; l6 > 0; l6--)
            {
                if((x[(k3 - 1) + _x_offset] != 0.0) || (y[(k3 - 1) + _y_offset] != 0.0))
                {
                    double d4 = alpha * y[(k3 - 1) + _y_offset];
                    double d9 = alpha * x[(k3 - 1) + _x_offset];
                    int i5 = k5;
                    int l1 = k3;
                    for(int l7 = (n - k3) + 1; l7 > 0; l7--)
                    {
                        ap[(i5 - 1) + _ap_offset] = ap[(i5 - 1) + _ap_offset] + x[(l1 - 1) + _x_offset] * d4 + y[(l1 - 1) + _y_offset] * d9;
                        i5++;
                        l1++;
                    }

                }
                k5 = ((k5 + n) - k3) + 1;
                k3++;
            }

        } else
        {
            int l3 = 1;
            for (int i7 = n; i7 > 0; i7--)
            {
                if ((x[(i4 - 1) + _x_offset] != 0.0) || (y[(j4 - 1) + _y_offset] != 0.0))
                {
                    double d5 = alpha * y[(j4 - 1) + _y_offset];
                    double d10 = alpha * x[(i4 - 1) + _x_offset];
                    int j2 = i4;
                    int l2 = j4;
                    int j5 = k5;
                    for (int i8 = ((k5 + n) - l3 - k5) + 1; i8 > 0; i8--)
                    {
                        ap[(j5 - 1) + _ap_offset] = ap[(j5 - 1) + _ap_offset] + x[(j2 - 1) + _x_offset] * d5 + y[(l2 - 1) + _y_offset] * d10;
                        j2 += incx;
                        l2 += incy;
                        j5++;
                    }

                }
                i4 += incx;
                j4 += incy;
                k5 = ((k5 + n) - l3) + 1;
                l3++;
            }

        }
    }
}

package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dspr
{
	public static void dspr(String uplo, int n, double alpha, double[] x, int _x_offset, int incx, double[] ap,
			int _ap_offset) {

        int byte0 = 0;
        int k4 = 0;
        int l4 = 0;
        if (!Lsame.lsame(uplo, "U") && !Lsame.lsame(uplo, "L"))
            byte0 = 1;
        else
        if (n < 0)
            byte0 = 2;
        else
        if (incx == 0)
            byte0 = 5;
        if (byte0 != 0)
        {
            Xerbla.xerbla("DSPR  ", byte0);
            return;
        }
        if (n == 0 || alpha == 0.0)
            return;
        if (incx <= 0)
            l4 = 1 - (n - 1) * incx;
        else
        if (incx != 1)
            l4 = 1;
        k4 = 1;
        if (Lsame.lsame(uplo, "U"))
        {
            if(incx == 1)
            {
                int i2 = 1;
                for(int i5 = n; i5 > 0; i5--)
                {
                    if(x[(i2 - 1) + _x_offset] != 0.0)
                    {
                        double d2 = alpha * x[(i2 - 1) + _x_offset];
                        int k3 = k4;
                        int i1 = 1;
                        for(int i6 = (i2 - 1) + 1; i6 > 0; i6--)
                        {
                            ap[(k3 - 1) + _ap_offset] = ap[(k3 - 1) + _ap_offset] + x[(i1 - 1) + _x_offset] * d2;
                            k3++;
                            i1++;
                        }

                    }
                    k4 += i2;
                    i2++;
                }

            } else
            {
                int i3 = l4;
                int j2 = 1;
                for(int j5 = n; j5 > 0; j5--)
                {
                    if(x[(i3 - 1) + _x_offset] != 0.0)
                    {
                        double d3 = alpha * x[(i3 - 1) + _x_offset];
                        int k1 = l4;
                        int l3 = k4;
                        for(int j6 = ((k4 + j2) - 1 - k4) + 1; j6 > 0; j6--)
                        {
                            ap[(l3 - 1) + _ap_offset] = ap[(l3 - 1) + _ap_offset] + x[(k1 - 1) + _x_offset] * d3;
                            k1 += incx;
                            l3++;
                        }

                    }
                    i3 += incx;
                    k4 += j2;
                    j2++;
                }

            }
        } else
        if(incx == 1)
        {
            int k2 = 1;
            for(int k5 = n; k5 > 0; k5--)
            {
                if(x[(k2 - 1) + _x_offset] != 0.0)
                {
                    double d4 = alpha * x[(k2 - 1) + _x_offset];
                    int i4 = k4;
                    int j1 = k2;
                    for(int k6 = (n - k2) + 1; k6 > 0; k6--)
                    {
                        ap[(i4 - 1) + _ap_offset] = ap[(i4 - 1) + _ap_offset] + x[(j1 - 1) + _x_offset] * d4;
                        i4++;
                        j1++;
                    }

                }
                k4 = ((k4 + n) - k2) + 1;
                k2++;
            }

        } else
        {
            int j3 = l4;
            int l2 = 1;
            for (int l5 = n; l5 > 0; l5--)
            {
                if (x[(j3 - 1) + _x_offset] != 0.0)
                {
                    double d5 = alpha * x[(j3 - 1) + _x_offset];
                    int l1 = j3;
                    int j4 = k4;
                    for (int l6 = ((k4 + n) - l2 - k4) + 1; l6 > 0; l6--)
                    {
                        ap[(j4 - 1) + _ap_offset] = ap[(j4 - 1) + _ap_offset] + x[(l1 - 1) + _x_offset] * d5;
                        l1 += incx;
                        j4++;
                    }

                }
                j3 += incx;
                k4 = ((k4 + n) - l2) + 1;
                l2++;
            }

        }
    }
}

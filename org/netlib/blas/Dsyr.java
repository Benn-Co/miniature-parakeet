package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dsyr
{
	public static void dsyr(String uplo, int n, double alpha, double[] x, int _x_offset, int incx, double[] a,
			int _a_offset, int lda) {

        int j4 = 0;
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
        if (lda < Math.max(1, n))
            byte0 = 7;
        if (byte0 != 0)
        {
            Xerbla.xerbla("DSYR  ", byte0);
            return;
        }
        if (n == 0 || alpha == 0.0)
            return;
        if (incx <= 0)
            j4 = 1 - (n - 1) * incx;
        else
        if (incx != 1)
            j4 = 1;
        if (Lsame.lsame(uplo, "U"))
        {
            if(incx == 1)
            {
                int l2 = 1;
                for(int k4 = n; k4 > 0; k4--)
                {
                    if(x[(l2 - 1) + _x_offset] != 0.0)
                    {
                        double d2 = alpha * x[(l2 - 1) + _x_offset];
                        int j1 = 1;
                        for (int k5 = (l2 - 1) + 1; k5 > 0; k5--)
                        {
                            a[(j1 - 1) + (l2 - 1) * lda + _a_offset] = a[(j1 - 1) + (l2 - 1) * lda + _a_offset] + x[(j1 - 1) + _x_offset] * d2;
                            j1++;
                        }

                    }
                    l2++;
                }

            } else
            {
                int l3 = j4;
                int i3 = 1;
                for (int l4 = n; l4 > 0; l4--)
                {
                    if (x[(l3 - 1) + _x_offset] != 0.0)
                    {
                        double d3 = alpha * x[(l3 - 1) + _x_offset];
                        int j2 = j4;
                        int k1 = 1;
                        for (int l5 = (i3 - 1) + 1; l5 > 0; l5--)
                        {
                            a[(k1 - 1) + (i3 - 1) * lda + _a_offset] = a[(k1 - 1) + (i3 - 1) * lda + _a_offset] + x[(j2 - 1) + _x_offset] * d3;
                            j2 += incx;
                            k1++;
                        }

                    }
                    l3 += incx;
                    i3++;
                }

            }
        } else
        if(incx == 1)
        {
            int j3 = 1;
            for(int i5 = n; i5 > 0; i5--)
            {
                if(x[(j3 - 1) + _x_offset] != 0.0)
                {
                    double d4 = alpha * x[(j3 - 1) + _x_offset];
                    int l1 = j3;
                    for (int i6 = (n - j3) + 1; i6 > 0; i6--)
                    {
                        a[(l1 - 1) + (j3 - 1) * lda + _a_offset] = a[(l1 - 1) + (j3 - 1) * lda + _a_offset] + x[(l1 - 1) + _x_offset] * d4;
                        l1++;
                    }

                }
                j3++;
            }

        } else
        {
            int i4 = j4;
            int k3 = 1;
            for (int j5 = n; j5 > 0; j5--)
            {
                if (x[(i4 - 1) + _x_offset] != 0.0)
                {
                    double d5 = alpha * x[(i4 - 1) + _x_offset];
                    int k2 = i4;
                    int i2 = k3;
                    for (int j6 = (n - k3) + 1; j6 > 0; j6--)
                    {
                        a[(i2 - 1) + (k3 - 1) * lda + _a_offset] = a[(i2 - 1) + (k3 - 1) * lda + _a_offset] + x[(k2 - 1) + _x_offset] * d5;
                        k2 += incx;
                        i2++;
                    }

                }
                i4 += incx;
                k3++;
            }

        }
    }
}

package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dtbmv
{
	public static void dtbmv(String uplo, String trans, String diag, int n, int k, double[] a, int _a_offset, int lda,
			double[] x, int _x_offset, int incx) {

        int i8 = 0;
        boolean flag = false;
        int byte0 = 0;
        if (!Lsame.lsame(uplo, "U") && !Lsame.lsame(uplo, "L"))
            byte0 = 1;
        else
        if (!Lsame.lsame(trans, "N") && !Lsame.lsame(trans, "T") && !Lsame.lsame(trans, "C"))
            byte0 = 2;
        else
        if (!Lsame.lsame(diag, "U") && !Lsame.lsame(diag, "N"))
            byte0 = 3;
        else
        if (n < 0)
            byte0 = 4;
        else
        if (k < 0)
            byte0 = 5;
        else
        if (lda < k + 1)
            byte0 = 7;
        else
        if (incx == 0)
            byte0 = 9;
        if (byte0 != 0)
        {
            Xerbla.xerbla("DTBMV ", byte0);
            return;
        }
        if (n == 0)
            return;
        flag = Lsame.lsame(diag, "N");
        if (incx <= 0)
            i8 = 1 - (n - 1) * incx;
        else
        if (incx != 1)
            i8 = 1;
        if (Lsame.lsame(trans, "N"))
        {
            if(Lsame.lsame(uplo, "U"))
            {
                int k7 = k + 1;
                if(incx == 1)
                {
                    int k4 = 1;
                    for(int j10 = n; j10 > 0; j10--)
                    {
                        if(x[(k4 - 1) + _x_offset] != 0.0)
                        {
                            double d1 = x[(k4 - 1) + _x_offset];
                            int j8 = k7 - k4;
                            int k1 = Math.max(1, k4 - k);
                            for(int j12 = (k4 - 1 - Math.max(1, k4 - k)) + 1; j12 > 0; j12--)
                            {
                                x[(k1 - 1) + _x_offset] = x[(k1 - 1) + _x_offset] + d1 * a[((j8 + k1) - 1) + (k4 - 1) * lda + _a_offset];
                                k1++;
                            }

                            if(flag)
                                x[(k4 - 1) + _x_offset] = x[(k4 - 1) + _x_offset] * a[(k7 - 1) + (k4 - 1) * lda + _a_offset];
                        }
                        k4++;
                    }

                } else
                {
                    int k6 = i8;
                    int l4 = 1;
                    for(int k10 = n; k10 > 0; k10--)
                    {
                        if(x[(k6 - 1) + _x_offset] != 0.0)
                        {
                            double d2 = x[(k6 - 1) + _x_offset];
                            int k3 = i8;
                            int k8 = k7 - l4;
                            int l1 = Math.max(1, l4 - k);
                            for(int k12 = (l4 - 1 - Math.max(1, l4 - k)) + 1; k12 > 0; k12--)
                            {
                                x[(k3 - 1) + _x_offset] = x[(k3 - 1) + _x_offset] + d2 * a[((k8 + l1) - 1) + (l4 - 1) * lda + _a_offset];
                                k3 += incx;
                                l1++;
                            }

                            if(flag)
                                x[(k6 - 1) + _x_offset] = x[(k6 - 1) + _x_offset] * a[(k7 - 1) + (l4 - 1) * lda + _a_offset];
                        }
                        k6 += incx;
                        if(l4 > k)
                            i8 += incx;
                        l4++;
                    }

                }
            } else
            if(incx == 1)
            {
                int i5 = n;
                for(int l10 = ((1 - n) + -1) / -1; l10 > 0; l10--)
                {
                    if(x[(i5 - 1) + _x_offset] != 0.0)
                    {
                        double d3 = x[(i5 - 1) + _x_offset];
                        int l8 = 1 - i5;
                        int i2 = Math.min(n, i5 + k);
                        for(int l12 = (((i5 + 1) - Math.min(n, i5 + k)) + -1) / -1; l12 > 0; l12--)
                        {
                            x[(i2 - 1) + _x_offset] = x[(i2 - 1) + _x_offset] + d3 * a[((l8 + i2) - 1) + (i5 - 1) * lda + _a_offset];
                            i2--;
                        }

                        if(flag)
                            x[(i5 - 1) + _x_offset] = x[(i5 - 1) + _x_offset] * a[(i5 - 1) * lda + _a_offset];
                    }
                    i5--;
                }

            } else
            {
                i8 += (n - 1) * incx;
                int l6 = i8;
                int j5 = n;
                for(int i11 = ((1 - n) + -1) / -1; i11 > 0; i11--)
                {
                    if(x[(l6 - 1) + _x_offset] != 0.0)
                    {
                        double d4 = x[(l6 - 1) + _x_offset];
                        int l3 = i8;
                        int i9 = 1 - j5;
                        int j2 = Math.min(n, j5 + k);
                        for(int i13 = (((j5 + 1) - Math.min(n, j5 + k)) + -1) / -1; i13 > 0; i13--)
                        {
                            x[(l3 - 1) + _x_offset] = x[(l3 - 1) + _x_offset] + d4 * a[((i9 + j2) - 1) + (j5 - 1) * lda + _a_offset];
                            l3 -= incx;
                            j2--;
                        }

                        if(flag)
                            x[(l6 - 1) + _x_offset] = x[(l6 - 1) + _x_offset] * a[(1 - 1) + (j5 - 1) * lda + _a_offset];
                    }
                    l6 -= incx;
                    if(n - j5 >= k)
                        i8 -= incx;
                    j5--;
                }

            }
        } else
        if(Lsame.lsame(uplo, "U"))
        {
            int l7 = k + 1;
            if(incx == 1)
            {
                int k5 = n;
                for(int j11 = ((1 - n) + -1) / -1; j11 > 0; j11--)
                {
                    double d5 = x[(k5 - 1) + _x_offset];
                    int j9 = l7 - k5;
                    if(flag)
                        d5 *= a[(l7 - 1) + (k5 - 1) * lda + _a_offset];
                    int k2 = k5 - 1;
                    for(int j13 = ((Math.max(1, k5 - k) - (k5 - 1)) + -1) / -1; j13 > 0; j13--)
                    {
                        d5 += a[((j9 + k2) - 1) + (k5 - 1) * lda + _a_offset] * x[(k2 - 1) + _x_offset];
                        k2--;
                    }

                    x[(k5 - 1) + _x_offset] = d5;
                    k5--;
                }

            } else
            {
                i8 += (n - 1) * incx;
                int i7 = i8;
                int l5 = n;
                for(int k11 = ((1 - n) + -1) / -1; k11 > 0; k11--)
                {
                    double d6 = x[(i7 - 1) + _x_offset];
                    i8 -= incx;
                    int i4 = i8;
                    int k9 = l7 - l5;
                    if(flag)
                        d6 *= a[(l7 - 1) + (l5 - 1) * lda + _a_offset];
                    int l2 = l5 - 1;
                    for(int k13 = ((Math.max(1, l5 - k) - (l5 - 1)) + -1) / -1; k13 > 0; k13--)
                    {
                        d6 += a[((k9 + l2) - 1) + (l5 - 1) * lda + _a_offset] * x[(i4 - 1) + _x_offset];
                        i4 -= incx;
                        l2--;
                    }

                    x[(i7 - 1) + _x_offset] = d6;
                    i7 -= incx;
                    l5--;
                }

            }
        } else
        if(incx == 1)
        {
            int i6 = 1;
            for(int l11 = n; l11 > 0; l11--)
            {
                double d7 = x[(i6 - 1) + _x_offset];
                int l9 = 1 - i6;
                if(flag)
                    d7 *= a[(1 - 1) + (i6 - 1) * lda + _a_offset];
                int i3 = i6 + 1;
                for(int l13 = (Math.min(n, i6 + k) - (i6 + 1)) + 1; l13 > 0; l13--)
                {
                    d7 += a[((l9 + i3) - 1) + (i6 - 1) * lda + _a_offset] * x[(i3 - 1) + _x_offset];
                    i3++;
                }

                x[(i6 - 1) + _x_offset] = d7;
                i6++;
            }

        } else
        {
            int j7 = i8;
            int j6 = 1;
            for (int i12 = n; i12 > 0; i12--)
            {
                double d8 = x[(j7 - 1) + _x_offset];
                i8 += incx;
                int j4 = i8;
                int i10 = 1 - j6;
                if (flag)
                    d8 *= a[(j6 - 1) * lda + _a_offset];
                int j3 = j6 + 1;
                for (int i14 = (Math.min(n, j6 + k) - (j6 + 1)) + 1; i14 > 0; i14--)
                {
                    d8 += a[((i10 + j3) - 1) + (j6 - 1) * lda + _a_offset] * x[(j4 - 1) + _x_offset];
                    j4 += incx;
                    j3++;
                }

                x[(j7 - 1) + _x_offset] = d8;
                j7 += incx;
                j6++;
            }

        }
    }
}

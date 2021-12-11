package org.netlib.blas;

import org.netlib.err.Xerbla;

public final class Dtpmv
{
	public static void dtpmv(String uplo, String trans, String diag, int n, double[] ap, int _ap_offset, double[] x,
			int _x_offset, int incx) {

        int byte0 = 0;
        int i9 = 0;
        boolean flag = false;
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
        if (incx == 0)
            byte0 = 7;
        if (byte0 != 0)
        {
            Xerbla.xerbla("DTPMV ", byte0);
            return;
        }
        if (n == 0)
            return;
        flag = Lsame.lsame(diag, "N");
        if (incx <= 0)
            i9 = 1 - (n - 1) * incx;
        else
        if (incx != 1)
            i9 = 1;
        if (Lsame.lsame(trans, "N"))
        {
            if(Lsame.lsame(uplo, "U"))
            {
                int i8 = 1;
                if(incx == 1)
                {
                    int i3 = 1;
                    for(int j9 = n; j9 > 0; j9--)
                    {
                        if(x[(i3 - 1) + _x_offset] != 0.0)
                        {
                            double d1 = x[(i3 - 1) + _x_offset];
                            int i6 = i8;
                            int i1 = 1;
                            for(int j11 = i3 - 1; j11 > 0; j11--)
                            {
                                x[(i1 - 1) + _x_offset] = x[(i1 - 1) + _x_offset] + d1 * ap[(i6 - 1) + _ap_offset];
                                i6++;
                                i1++;
                            }

                            if(flag)
                                x[(i3 - 1) + _x_offset] = x[(i3 - 1) + _x_offset] * ap[((i8 + i3) - 1 - 1) + _ap_offset];
                        }
                        i8 += i3;
                        i3++;
                    }

                } else
                {
                    int i5 = i9;
                    int j3 = 1;
                    for(int k9 = n; k9 > 0; k9--)
                    {
                        if(x[(i5 - 1) + _x_offset] != 0.0)
                        {
                            double d2 = x[(i5 - 1) + _x_offset];
                            int i2 = i9;
                            int j6 = i8;
                            for(int k11 = ((i8 + j3) - 2 - i8) + 1; k11 > 0; k11--)
                            {
                                x[(i2 - 1) + _x_offset] = x[(i2 - 1) + _x_offset] + d2 * ap[(j6 - 1) + _ap_offset];
                                i2 += incx;
                                j6++;
                            }

                            if(flag)
                                x[(i5 - 1) + _x_offset] = x[(i5 - 1) + _x_offset] * ap[((i8 + j3) - 1 - 1) + _ap_offset];
                        }
                        i5 += incx;
                        i8 += j3;
                        j3++;
                    }

                }
            } else
            {
                int j8 = (n * (n + 1)) / 2;
                if(incx == 1)
                {
                    int k3 = n;
                    for(int l9 = ((1 - n) + -1) / -1; l9 > 0; l9--)
                    {
                        if(x[(k3 - 1) + _x_offset] != 0.0)
                        {
                            double d3 = x[(k3 - 1) + _x_offset];
                            int k6 = j8;
                            int j1 = n;
                            for(int l11 = (((k3 + 1) - n) + -1) / -1; l11 > 0; l11--)
                            {
                                x[(j1 - 1) + _x_offset] = x[(j1 - 1) + _x_offset] + d3 * ap[(k6 - 1) + _ap_offset];
                                k6--;
                                j1--;
                            }

                            if(flag)
                                x[(k3 - 1) + _x_offset] = x[(k3 - 1) + _x_offset] * ap[(((j8 - n) + k3) - 1) + _ap_offset];
                        }
                        j8 -= (n - k3) + 1;
                        k3--;
                    }

                } else
                {
                    i9 += (n - 1) * incx;
                    int j5 = i9;
                    int l3 = n;
                    for(int i10 = ((1 - n) + -1) / -1; i10 > 0; i10--)
                    {
                        if(x[(j5 - 1) + _x_offset] != 0.0)
                        {
                            double d4 = x[(j5 - 1) + _x_offset];
                            int j2 = i9;
                            int l6 = j8;
                            for(int i12 = ((j8 - (n - (l3 + 1)) - j8) + -1) / -1; i12 > 0; i12--)
                            {
                                x[(j2 - 1) + _x_offset] = x[(j2 - 1) + _x_offset] + d4 * ap[(l6 - 1) + _ap_offset];
                                j2 -= incx;
                                l6--;
                            }

                            if(flag)
                                x[(j5 - 1) + _x_offset] = x[(j5 - 1) + _x_offset] * ap[(((j8 - n) + l3) - 1) + _ap_offset];
                        }
                        j5 -= incx;
                        j8 -= (n - l3) + 1;
                        l3--;
                    }

                }
            }
        } else
        if(Lsame.lsame(uplo, "U"))
        {
            int k8 = (n * (n + 1)) / 2;
            if(incx == 1)
            {
                int i4 = n;
                for(int j10 = ((1 - n) + -1) / -1; j10 > 0; j10--)
                {
                    double d5 = x[(i4 - 1) + _x_offset];
                    if(flag)
                        d5 *= ap[(k8 - 1) + _ap_offset];
                    int i7 = k8 - 1;
                    int k1 = i4 - 1;
                    for(int j12 = ((1 - (i4 - 1)) + -1) / -1; j12 > 0; j12--)
                    {
                        d5 += ap[(i7 - 1) + _ap_offset] * x[(k1 - 1) + _x_offset];
                        i7--;
                        k1--;
                    }

                    x[(i4 - 1) + _x_offset] = d5;
                    k8 -= i4;
                    i4--;
                }

            } else
            {
                int k5 = i9 + (n - 1) * incx;
                int j4 = n;
                for(int k10 = ((1 - n) + -1) / -1; k10 > 0; k10--)
                {
                    double d6 = x[(k5 - 1) + _x_offset];
                    int k2 = k5;
                    if(flag)
                        d6 *= ap[(k8 - 1) + _ap_offset];
                    int j7 = k8 - 1;
                    for(int k12 = ((((k8 - j4) + 1) - (k8 - 1)) + -1) / -1; k12 > 0; k12--)
                    {
                        k2 -= incx;
                        d6 += ap[(j7 - 1) + _ap_offset] * x[(k2 - 1) + _x_offset];
                        j7--;
                    }

                    x[(k5 - 1) + _x_offset] = d6;
                    k5 -= incx;
                    k8 -= j4;
                    j4--;
                }

            }
        } else
        {
            int l8 = 1;
            if(incx == 1)
            {
                int k4 = 1;
                for(int l10 = (n - 1) + 1; l10 > 0; l10--)
                {
                    double d7 = x[(k4 - 1) + _x_offset];
                    if(flag)
                        d7 *= ap[(l8 - 1) + _ap_offset];
                    int k7 = l8 + 1;
                    int l1 = k4 + 1;
                    for(int l12 = (n - (k4 + 1)) + 1; l12 > 0; l12--)
                    {
                        d7 += ap[(k7 - 1) + _ap_offset] * x[(l1 - 1) + _x_offset];
                        k7++;
                        l1++;
                    }

                    x[(k4 - 1) + _x_offset] = d7;
                    l8 += (n - k4) + 1;
                    k4++;
                }

            } else
            {
                int l5 = i9;
                int l4 = 1;
                for (int i11 = n; i11 > 0; i11--)
                {
                    double d8 = x[(l5 - 1) + _x_offset];
                    int l2 = l5;
                    if (flag)
                        d8 *= ap[(l8 - 1) + _ap_offset];
                    int l7 = l8 + 1;
                    for (int i13 = ((l8 + n) - l4 - (l8 + 1)) + 1; i13 > 0; i13--)
                    {
                        l2 += incx;
                        d8 += ap[(l7 - 1) + _ap_offset] * x[(l2 - 1) + _x_offset];
                        l7++;
                    }

                    x[(l5 - 1) + _x_offset] = d8;
                    l5 += incx;
                    l8 += (n - l4) + 1;
                    l4++;
                }

            }
        }
    }
}

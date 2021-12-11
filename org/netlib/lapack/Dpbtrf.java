package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dpbtrf
{
    public static void dpbtrf(String s, int i, int j, double ad[], int k, int l, intW intw)
    {
label0:
        {
            intW intw1 = new intW(0);
            int k4 = 0;
            double ad1[] = new double[33 * 32];
            intw.val = 0;
            if(Lsame.lsame(s, "U") ^ true && Lsame.lsame(s, "L") ^ true)
                intw.val = -1;
            else
            if(i < 0)
                intw.val = -2;
            else
            if(j < 0)
                intw.val = -3;
            else
            if(l < j + 1)
                intw.val = -5;
            if(intw.val != 0)
            {
                Xerbla.xerbla("DPBTRF", -intw.val);
                return;
            }
            if(i == 0)
                return;
            k4 = Ilaenv.ilaenv(1, "DPBTRF", s, i, j, -1, -1);
            k4 = Math.min(k4, 32);
            if((k4 <= 1) || (k4 > j))
                Dpbtf2.dpbtf2(s, i, j, ad, k, l, intw);
            else
            if(Lsame.lsame(s, "U"))
            {
                int k3 = 1;
                for(int l4 = (k4 - 1) + 1; l4 > 0; l4--)
                {
                    int i1 = 1;
                    for(int l5 = (k3 - 1 - 1) + 1; l5 > 0; l5--)
                    {
                        ad1[(i1 - 1) + (k3 - 1) * 33] = 0.0D;
                        i1++;
                    }

                    k3++;
                }

                int j1 = 1;
                for(int i5 = ((i - 1) + k4) / k4; i5 > 0; i5--)
                {
                    int i3 = Math.min(k4, (i - j1) + 1);
                    Dpotf2.dpotf2(s, i3, ad, ((j + 1) - 1) + (j1 - 1) * l + k, l - 1, intw1);
                    if(intw1.val != 0)
                    {
                        intw.val = (j1 + intw1.val) - 1;
                        break label0;
                    }
                    if(j1 + i3 <= i)
                    {
                        int i2 = Math.min(j - i3, (i - j1 - i3) + 1);
                        int k2 = Math.min(i3, (i - j1 - j) + 1);
                        if(i2 > 0)
                        {
                            Dtrsm.dtrsm("Left", "Upper", "Transpose", "Non-unit", i3, i2, 1.0D, ad, ((j + 1) - 1) + (j1 - 1) * l + k, l - 1, ad, ((j + 1) - i3 - 1) + ((j1 + i3) - 1) * l + k, l - 1);
                            Dsyrk.dsyrk("Upper", "Transpose", i2, i3, -1D, ad, ((j + 1) - i3 - 1) + ((j1 + i3) - 1) * l + k, l - 1, 1.0D, ad, ((j + 1) - 1) + ((j1 + i3) - 1) * l + k, l - 1);
                        }
                        if(k2 > 0)
                        {
                            int i4 = 1;
                            for(int i6 = (k2 - 1) + 1; i6 > 0; i6--)
                            {
                                intw1.val = i4;
                                for(int j7 = (i3 - i4) + 1; j7 > 0; j7--)
                                {
                                    ad1[(intw1.val - 1) + (i4 - 1) * 33] = ad[(((intw1.val - i4) + 1) - 1) + ((i4 + j1 + j) - 1 - 1) * l + k];
                                    intw1.val = intw1.val + 1;
                                }

                                i4++;
                            }

                            Dtrsm.dtrsm("Left", "Upper", "Transpose", "Non-unit", i3, k2, 1.0D, ad, ((j + 1) - 1) + (j1 - 1) * l + k, l - 1, ad1, 0, 33);
                            if(i2 > 0)
                                Dgemm.dgemm("Transpose", "No Transpose", i2, k2, i3, -1D, ad, ((j + 1) - i3 - 1) + ((j1 + i3) - 1) * l + k, l - 1, ad1, 0, 33, 1.0D, ad, ((1 + i3) - 1) + ((j1 + j) - 1) * l + k, l - 1);
                            Dsyrk.dsyrk("Upper", "Transpose", k2, i3, -1D, ad1, 0, 33, 1.0D, ad, ((j + 1) - 1) + ((j1 + j) - 1) * l + k, l - 1);
                            i4 = 1;
                            for(int j6 = (k2 - 1) + 1; j6 > 0; j6--)
                            {
                                intw1.val = i4;
                                for(int k7 = (i3 - i4) + 1; k7 > 0; k7--)
                                {
                                    ad[(((intw1.val - i4) + 1) - 1) + ((i4 + j1 + j) - 1 - 1) * l + k] = ad1[(intw1.val - 1) + (i4 - 1) * 33];
                                    intw1.val = intw1.val + 1;
                                }

                                i4++;
                            }

                        }
                    }
                    j1 += k4;
                }

            } else
            {
                int l3 = 1;
                for(int j5 = (k4 - 1) + 1; j5 > 0; j5--)
                {
                    int k1 = l3 + 1;
                    for(int k6 = (k4 - (l3 + 1)) + 1; k6 > 0; k6--)
                    {
                        ad1[(k1 - 1) + (l3 - 1) * 33] = 0.0D;
                        k1++;
                    }

                    l3++;
                }

                int l1 = 1;
                for(int k5 = ((i - 1) + k4) / k4; k5 > 0; k5--)
                {
                    int j3 = Math.min(k4, (i - l1) + 1);
                    Dpotf2.dpotf2(s, j3, ad, (1 - 1) + (l1 - 1) * l + k, l - 1, intw1);
                    if(intw1.val != 0)
                    {
                        intw.val = (l1 + intw1.val) - 1;
                        break label0;
                    }
                    if(l1 + j3 <= i)
                    {
                        int j2 = Math.min(j - j3, (i - l1 - j3) + 1);
                        int l2 = Math.min(j3, (i - l1 - j) + 1);
                        if(j2 > 0)
                        {
                            Dtrsm.dtrsm("Right", "Lower", "Transpose", "Non-unit", j2, j3, 1.0D, ad, (1 - 1) + (l1 - 1) * l + k, l - 1, ad, ((1 + j3) - 1) + (l1 - 1) * l + k, l - 1);
                            Dsyrk.dsyrk("Lower", "No Transpose", j2, j3, -1D, ad, ((1 + j3) - 1) + (l1 - 1) * l + k, l - 1, 1.0D, ad, (1 - 1) + ((l1 + j3) - 1) * l + k, l - 1);
                        }
                        if(l2 > 0)
                        {
                            int j4 = 1;
                            for(int l6 = (j3 - 1) + 1; l6 > 0; l6--)
                            {
                                intw1.val = 1;
                                for(int l7 = (Math.min(j4, l2) - 1) + 1; l7 > 0; l7--)
                                {
                                    ad1[(intw1.val - 1) + (j4 - 1) * 33] = ad[((((j + 1) - j4) + intw1.val) - 1) + ((j4 + l1) - 1 - 1) * l + k];
                                    intw1.val = intw1.val + 1;
                                }

                                j4++;
                            }

                            Dtrsm.dtrsm("Right", "Lower", "Transpose", "Non-unit", l2, j3, 1.0D, ad, (l1 - 1) * l + k, l - 1, ad1, 0, 33);
                            if(j2 > 0)
                                Dgemm.dgemm("No transpose", "Transpose", l2, j2, j3, -1D, ad1, 0, 33, ad, ((1 + j3) - 1) + (l1 - 1) * l + k, l - 1, 1.0D, ad, ((1 + j) - j3 - 1) + ((l1 + j3) - 1) * l + k, l - 1);
                            Dsyrk.dsyrk("Lower", "No Transpose", l2, j3, -1D, ad1, 0, 33, 1.0D, ad, ((l1 + j) - 1) * l + k, l - 1);
                            j4 = 1;
                            for(int i7 = (j3 - 1) + 1; i7 > 0; i7--)
                            {
                                intw1.val = 1;
                                for(int i8 = (Math.min(j4, l2) - 1) + 1; i8 > 0; i8--)
                                {
                                    ad[((((j + 1) - j4) + intw1.val) - 1) + ((j4 + l1) - 2) * l + k] = ad1[(intw1.val - 1) + (j4 - 1) * 33];
                                    intw1.val = intw1.val + 1;
                                }

                                j4++;
                            }

                        }
                    }
                    l1 += k4;
                }

            }
            return;
        }
    }
}

package org.netlib.arpack;

import org.netlib.blas.*;
import org.netlib.lapack.*;
import org.netlib.util.*;

public final class Dnapps
{
    public static void dnapps(int i, intW intw, int j, double ad[], int k, double ad1[], int l, double ad2[], 
            int i1, int j1, double ad3[], int k1, int l1, double ad4[], int i2, 
            double ad5[], int j2, int k2, double ad6[], int l2, double ad7[], int i3)
    {
label0:
        {
            intW intw1 = new intW(0);
            intW intw2 = new intW(0);
            intW intw3 = new intW(0);
            int k3 = 0;
            intW intw4 = new intW(0);
            int l3 = 0;
            int i4 = 0;
            boolean flag2 = false;
            doubleW doublew = new doubleW(0.0D);
            doubleW doublew1 = new doubleW(0.0D);
            doubleW doublew2 = new doubleW(0.0D);
            doubleW doublew3 = new doubleW(0.0D);
            doubleW doublew4 = new doubleW(0.0D);
            double ad8[] = new double[3];
            doubleW doublew5 = new doubleW(0.0D);
            Etime.etime();
            if(first)
            {
                unfl.val = Dlamch.dlamch("safe minimum");
                ovfl.val = 1.0D / unfl.val;
                Dlabad.dlabad(unfl, ovfl);
                ulp = Dlamch.dlamch("precision");
                smlnum = unfl.val * ((double)i / ulp);
                first = false;
            }
            Second.second(t0);
            i4 = arpack_debug.mnapps.val;
            l3 = intw.val + j;
            Dlaset.dlaset("All", l3, l3, 0.0D, 1.0D, ad5, j2, k2);
            if(j == 0)
                break label0;
            flag2 = false;
            intw4.val = 1;
            for(int k4 = (j - 1) + 1; k4 > 0; k4--)
            {
label1:
                {
                    doublew4.val = ad[(intw4.val - 1) + k];
                    doublew3.val = ad1[(intw4.val - 1) + l];
                    if(i4 > 2)
                    {
                        ivout_adapter(arpack_debug.logfil.val, 1, intw4, arpack_debug.ndigit.val, "_napps: shift number.");
                        dvout_adapter(arpack_debug.logfil.val, 1, doublew4, arpack_debug.ndigit.val, "_napps: The real part of the shift ");
                        dvout_adapter(arpack_debug.logfil.val, 1, doublew3, arpack_debug.ndigit.val, "_napps: The imaginary part of the shift ");
                    }
                    if(flag2)
                    {
                        flag2 = false;
                        break label1;
                    }
                    if((intw4.val < j) && (Math.abs(doublew3.val) > 0.0D))
                        flag2 = true;
                    else
                    if((intw4.val == j) && (Math.abs(doublew3.val) > 0.0D))
                    {
                        intw.val = intw.val + 1;
                        break label1;
                    }
                    intw3.val = 1;
                    do
                    {
label2:
                        {
                            intw1.val = intw3.val;
                            for(int k5 = (l3 - 1 - intw3.val) + 1; k5 > 0; k5--)
                            {
                                double d20 = Math.abs(ad3[(intw1.val - 1) + (intw1.val - 1) * l1 + k1]) + Math.abs(ad3[((intw1.val + 1) - 1) + ((intw1.val + 1) - 1) * l1 + k1]);
                                if(d20 == 0.0D)
                                    d20 = Dlanhs.dlanhs("1", (l3 - intw4.val) + 1, ad3, k1, l1, ad6, l2);
                                if(Math.abs(ad3[((intw1.val + 1) - 1) + (intw1.val - 1) * l1 + k1]) <= Math.max(ulp * d20, smlnum))
                                {
                                    if(i4 > 0)
                                    {
                                        ivout_adapter(arpack_debug.logfil.val, 1, intw1, arpack_debug.ndigit.val, "_napps: matrix splitting at row/column no.");
                                        ivout_adapter(arpack_debug.logfil.val, 1, intw4, arpack_debug.ndigit.val, "_napps: matrix splitting with shift number.");
                                        Dvout.dvout(arpack_debug.logfil.val, 1, ad3, ((intw1.val + 1) - 1) + (intw1.val - 1) * l1 + k1, arpack_debug.ndigit.val, "_napps: off diagonal element.");
                                    }
                                    intw2.val = intw1.val;
                                    ad3[((intw1.val + 1) - 1) + (intw1.val - 1) * l1 + k1] = 0.0D;
                                    break label2;
                                }
                                intw1.val = intw1.val + 1;
                            }

                            intw2.val = l3;
                        }
                        if(i4 > 2)
                        {
                            ivout_adapter(arpack_debug.logfil.val, 1, intw3, arpack_debug.ndigit.val, "_napps: Start of current block ");
                            ivout_adapter(arpack_debug.logfil.val, 1, intw2, arpack_debug.ndigit.val, "_napps: End of current block ");
                        }
                        if((intw3.val != intw2.val) && ((intw3.val + 1 != intw2.val) || (Math.abs(doublew3.val) <= 0.0D)))
                        {
                            double d5 = ad3[(intw3.val - 1) + (intw3.val - 1) * l1 + k1];
                            double d9 = ad3[((intw3.val + 1) - 1) + (intw3.val - 1) * l1 + k1];
                            if(Math.abs(doublew3.val) <= 0.0D)
                            {
                                double d1 = d5 - doublew4.val;
                                double d3 = d9;
                                intw1.val = intw3.val;
                                for(int l5 = (intw2.val - 1 - intw3.val) + 1; l5 > 0; l5--)
                                {
                                    Dlartg.dlartg(d1, d3, doublew, doublew2, doublew1);
                                    if(intw1.val > intw3.val)
                                    {
                                        if(doublew1.val < 0.0D)
                                        {
                                            doublew1.val = -doublew1.val;
                                            doublew.val = -doublew.val;
                                            doublew2.val = -doublew2.val;
                                        }
                                        ad3[(intw1.val - 1) + (intw1.val - 1 - 1) * l1 + k1] = doublew1.val;
                                        ad3[((intw1.val + 1) - 1) + (intw1.val - 1 - 1) * l1 + k1] = 0.0D;
                                    }
                                    k3 = intw1.val;
                                    for(int j6 = (l3 - intw1.val) + 1; j6 > 0; j6--)
                                    {
                                        double d15 = doublew.val * ad3[(intw1.val - 1) + (k3 - 1) * l1 + k1] + doublew2.val * ad3[((intw1.val + 1) - 1) + (k3 - 1) * l1 + k1];
                                        ad3[((intw1.val + 1) - 1) + (k3 - 1) * l1 + k1] = -(doublew2.val * ad3[(intw1.val - 1) + (k3 - 1) * l1 + k1]) + doublew.val * ad3[((intw1.val + 1) - 1) + (k3 - 1) * l1 + k1];
                                        ad3[(intw1.val - 1) + (k3 - 1) * l1 + k1] = d15;
                                        k3++;
                                    }

                                    k3 = 1;
                                    for(int k6 = (Math.min(intw1.val + 2, intw2.val) - 1) + 1; k6 > 0; k6--)
                                    {
                                        double d16 = doublew.val * ad3[(k3 - 1) + (intw1.val - 1) * l1 + k1] + doublew2.val * ad3[(k3 - 1) + ((intw1.val + 1) - 1) * l1 + k1];
                                        ad3[(k3 - 1) + ((intw1.val + 1) - 1) * l1 + k1] = -(doublew2.val * ad3[(k3 - 1) + (intw1.val - 1) * l1 + k1]) + doublew.val * ad3[(k3 - 1) + ((intw1.val + 1) - 1) * l1 + k1];
                                        ad3[(k3 - 1) + (intw1.val - 1) * l1 + k1] = d16;
                                        k3++;
                                    }

                                    k3 = 1;
                                    for(int l6 = (Math.min(intw1.val + intw4.val, l3) - 1) + 1; l6 > 0; l6--)
                                    {
                                        double d17 = doublew.val * ad5[(k3 - 1) + (intw1.val - 1) * k2 + j2] + doublew2.val * ad5[(k3 - 1) + ((intw1.val + 1) - 1) * k2 + j2];
                                        ad5[(k3 - 1) + ((intw1.val + 1) - 1) * k2 + j2] = -(doublew2.val * ad5[(k3 - 1) + (intw1.val - 1) * k2 + j2]) + doublew.val * ad5[(k3 - 1) + ((intw1.val + 1) - 1) * k2 + j2];
                                        ad5[(k3 - 1) + (intw1.val - 1) * k2 + j2] = d17;
                                        k3++;
                                    }

                                    if(intw1.val < intw2.val - 1)
                                    {
                                        d1 = ad3[((intw1.val + 1) - 1) + (intw1.val - 1) * l1 + k1];
                                        d3 = ad3[((intw1.val + 2) - 1) + (intw1.val - 1) * l1 + k1];
                                    }
                                    intw1.val = intw1.val + 1;
                                }

                            } else
                            {
                                double d7 = ad3[(intw3.val - 1) + ((intw3.val + 1) - 1) * l1 + k1];
                                double d11 = ad3[((intw3.val + 1) - 1) + ((intw3.val + 1) - 1) * l1 + k1];
                                double d13 = ad3[((intw3.val + 2) - 1) + ((intw3.val + 1) - 1) * l1 + k1];
                                doublew2.val = (double)2.0F * doublew4.val;
                                double d18 = Dlapy2.dlapy2(doublew4.val, doublew3.val);
                                ad8[1 - 1] = (d5 * (d5 - doublew2.val) + d18 * d18) / d9 + d7;
                                ad8[2 - 1] = (d5 + d11) - doublew2.val;
                                ad8[3 - 1] = d13;
                                intw1.val = intw3.val;
                                for(int i6 = (intw2.val - 1 - intw3.val) + 1; i6 > 0; i6--)
                                {
                                    int j4 = Math.min(3, (intw2.val - intw1.val) + 1);
                                    dlarfg_adapter(j4, ad8, 1 - 1, ad8, 2 - 1, 1, doublew5);
                                    if(intw1.val > intw3.val)
                                    {
                                        ad3[(intw1.val - 1) + (intw1.val - 1 - 1) * l1 + k1] = ad8[1 - 1];
                                        ad3[((intw1.val + 1) - 1) + (intw1.val - 1 - 1) * l1 + k1] = 0.0D;
                                        if(intw1.val < intw2.val - 1)
                                            ad3[((intw1.val + 2) - 1) + (intw1.val - 1 - 1) * l1 + k1] = 0.0D;
                                    }
                                    ad8[1 - 1] = 1.0D;
                                    Dlarf.dlarf("Left", j4, (l3 - intw1.val) + 1, ad8, 0, 1, doublew5.val, ad3, (intw1.val - 1) + (intw1.val - 1) * l1 + k1, l1, ad6, l2);
                                    int j3 = Math.min(intw1.val + 3, intw2.val);
                                    Dlarf.dlarf("Right", j3, j4, ad8, 0, 1, doublew5.val, ad3, (1 - 1) + (intw1.val - 1) * l1 + k1, l1, ad6, l2);
                                    Dlarf.dlarf("Right", l3, j4, ad8, 0, 1, doublew5.val, ad5, (1 - 1) + (intw1.val - 1) * k2 + j2, k2, ad6, l2);
                                    if(intw1.val < intw2.val - 1)
                                    {
                                        ad8[1 - 1] = ad3[((intw1.val + 1) - 1) + (intw1.val - 1) * l1 + k1];
                                        ad8[2 - 1] = ad3[((intw1.val + 2) - 1) + (intw1.val - 1) * l1 + k1];
                                        if(intw1.val < intw2.val - 2)
                                            ad8[3 - 1] = ad3[((intw1.val + 3) - 1) + (intw1.val - 1) * l1 + k1];
                                    }
                                    intw1.val = intw1.val + 1;
                                }

                            }
                        }
                        intw3.val = intw2.val + 1;
                    } while(intw2.val < l3);
                }
                intw4.val = intw4.val + 1;
            }

            k3 = 1;
            for(int l4 = (intw.val - 1) + 1; l4 > 0; l4--)
            {
                if(ad3[((k3 + 1) - 1) + (k3 - 1) * l1 + k1] < 0.0D)
                {
                    Dscal.dscal((l3 - k3) + 1, -1D, ad3, ((k3 + 1) - 1) + (k3 - 1) * l1 + k1, l1);
                    Dscal.dscal(Math.min(k3 + 2, l3), -1D, ad3, (1 - 1) + ((k3 + 1) - 1) * l1 + k1, 1);
                    Dscal.dscal(Math.min(k3 + j + 1, l3), -1D, ad5, (1 - 1) + ((k3 + 1) - 1) * k2 + j2, 1);
                }
                k3++;
            }

            intw1.val = 1;
            for(int i5 = (intw.val - 1) + 1; i5 > 0; i5--)
            {
                double d21 = Math.abs(ad3[(intw1.val - 1) + (intw1.val - 1) * l1 + k1]) + Math.abs(ad3[((intw1.val + 1) - 1) + ((intw1.val + 1) - 1) * l1 + k1]);
                if(d21 == 0.0D)
                    d21 = Dlanhs.dlanhs("1", intw.val, ad3, k1, l1, ad6, l2);
                if(ad3[((intw1.val + 1) - 1) + (intw1.val - 1) * l1 + k1] <= Math.max(ulp * d21, smlnum))
                    ad3[((intw1.val + 1) - 1) + (intw1.val - 1) * l1 + k1] = 0.0D;
                intw1.val = intw1.val + 1;
            }

            if(ad3[((intw.val + 1) - 1) + (intw.val - 1) * l1 + k1] > 0.0D)
                Dgemv.dgemv("N", i, l3, 1.0D, ad2, i1, j1, ad5, (1 - 1) + ((intw.val + 1) - 1) * k2 + j2, 1, 0.0D, ad7, ((i + 1) - 1) + i3, 1);
            intw1.val = 1;
            for(int j5 = (intw.val - 1) + 1; j5 > 0; j5--)
            {
                Dgemv.dgemv("N", i, (l3 - intw1.val) + 1, 1.0D, ad2, i1, j1, ad5, (1 - 1) + (((intw.val - intw1.val) + 1) - 1) * k2 + j2, 1, 0.0D, ad7, i3, 1);
                Dcopy.dcopy(i, ad7, i3, 1, ad2, (1 - 1) + (((l3 - intw1.val) + 1) - 1) * j1 + i1, 1);
                intw1.val = intw1.val + 1;
            }

            Dlacpy.dlacpy("A", i, intw.val, ad2, (1 - 1) + (((l3 - intw.val) + 1) - 1) * j1 + i1, j1, ad2, i1, j1);
            if(ad3[((intw.val + 1) - 1) + (intw.val - 1) * l1 + k1] > 0.0D)
                Dcopy.dcopy(i, ad7, ((i + 1) - 1) + i3, 1, ad2, (1 - 1) + ((intw.val + 1) - 1) * j1 + i1, 1);
            Dscal.dscal(i, ad5[(l3 - 1) + (intw.val - 1) * k2 + j2], ad4, i2, 1);
            if(ad3[((intw.val + 1) - 1) + (intw.val - 1) * l1 + k1] > 0.0D)
                Daxpy.daxpy(i, ad3[((intw.val + 1) - 1) + (intw.val - 1) * l1 + k1], ad2, (1 - 1) + ((intw.val + 1) - 1) * j1 + i1, 1, ad4, i2, 1);
            if(i4 > 1)
            {
                Dvout.dvout(arpack_debug.logfil.val, 1, ad5, (l3 - 1) + (intw.val - 1) * k2 + j2, arpack_debug.ndigit.val, "_napps: sigmak = (e_{kev+p}^T*Q)*e_{kev}");
                Dvout.dvout(arpack_debug.logfil.val, 1, ad3, ((intw.val + 1) - 1) + (intw.val - 1) * l1 + k1, arpack_debug.ndigit.val, "_napps: betak = e_{kev+1}^T*H*e_{kev}");
                ivout_adapter(arpack_debug.logfil.val, 1, intw, arpack_debug.ndigit.val, "_napps: Order of the final Hessenberg matrix ");
                if(i4 > 2)
                    Dmout.dmout(arpack_debug.logfil.val, intw.val, intw.val, ad3, k1, l1, arpack_debug.ndigit.val, "_napps: updated Hessenberg matrix H for next iteration");
            }
        }
        Second.second(t1);
        arpack_timing.tnapps.val = arpack_timing.tnapps.val + (t1.val - t0.val);
    }

    private static void ivout_adapter(int i, int j, intW intw, int k, String s)
    {
        int ai[] = {
            intw.val
        };
        Ivout.ivout(i, j, ai, 0, k, s);
        intw.val = ai[0];
    }

    private static void dvout_adapter(int i, int j, doubleW doublew, int k, String s)
    {
        double ad[] = {
            doublew.val
        };
        Dvout.dvout(i, j, ad, 0, k, s);
        doublew.val = ad[0];
    }

    private static void dlarfg_adapter(int i, double ad[], int j, double ad1[], int k, int l, doubleW doublew)
    {
        doubleW doublew1 = new doubleW(ad[j]);
        Dlarfg.dlarfg(i, doublew1, ad1, k, l, doublew);
        ad[j] = doublew1.val;
    }

    public static floatW t0 = new floatW(0.0F);
    public static floatW t1 = new floatW(0.0F);
    public static float t2 = 0.0F;
    public static float t3 = 0.0F;
    public static float t4 = 0.0F;
    public static float t5 = 0.0F;
    public static boolean first = true;
    public static doubleW ovfl = new doubleW(0.0D);
    public static double smlnum = 0.0D;
    public static double ulp = 0.0D;
    public static doubleW unfl = new doubleW(0.0D);
}

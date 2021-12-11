package org.netlib.arpack;

import org.netlib.blas.*;
import org.netlib.lapack.*;
import org.netlib.util.*;

public final class Dsapps
{
    public static void dsapps(int i, int j, int k, double ad[], int l, double ad1[], int i1, int j1, 
            double ad2[], int k1, int l1, double ad3[], int i2, double ad4[], int j2, 
            int k2, double ad5[], int l2)
    {
label0:
        {
            intW intw = new intW(0);
            int k3 = 0;
            intW intw1 = new intW(0);
            int j4 = 0;
            int k4 = 0;
            doubleW doublew = new doubleW(0.0D);
            doubleW doublew1 = new doubleW(0.0D);
            doubleW doublew2 = new doubleW(0.0D);
            Etime.etime();
            if(first)
            {
                epsmch = Dlamch.dlamch("Epsilon-Machine");
                first = false;
            }
            k3 = 1;
            Second.second(t0);
            k4 = arpack_debug.msapps.val;
            j4 = j + k;
            Dlaset.dlaset("All", j4, j4, 0.0D, 1.0D, ad4, j2, k2);
            if(k == 0)
                break label0;
            intw1.val = 1;
            for(int l4 = (k - 1) + 1; l4 > 0; l4--)
            {
                int j3 = k3;
                int i3;
                do
                {
label1:
                    {
                        intw.val = j3;
                        for(int k5 = (j4 - 1 - j3) + 1; k5 > 0; k5--)
                        {
                            double d15 = Math.abs(ad2[(intw.val - 1) + (2 - 1) * l1 + k1]) + Math.abs(ad2[((intw.val + 1) - 1) + (2 - 1) * l1 + k1]);
                            if(ad2[((intw.val + 1) - 1) + (1 - 1) * l1 + k1] <= epsmch * d15)
                            {
                                if(k4 > 0)
                                {
                                    ivout_adapter(arpack_debug.logfil.val, 1, intw, arpack_debug.ndigit.val, "_sapps: deflation at row/column no.");
                                    ivout_adapter(arpack_debug.logfil.val, 1, intw1, arpack_debug.ndigit.val, "_sapps: occured before shift number.");
                                    Dvout.dvout(arpack_debug.logfil.val, 1, ad2, ((intw.val + 1) - 1) + (1 - 1) * l1 + k1, arpack_debug.ndigit.val, "_sapps: the corresponding off diagonal element");
                                }
                                ad2[((intw.val + 1) - 1) + (1 - 1) * l1 + k1] = 0.0D;
                                i3 = intw.val;
                                break label1;
                            }
                            intw.val = intw.val + 1;
                        }

                        i3 = j4;
                    }
                    if(j3 < i3)
                    {
                        double d18 = ad2[(j3 - 1) + (2 - 1) * l1 + k1] - ad[(intw1.val - 1) + l];
                        double d21 = ad2[((j3 + 1) - 1) + (1 - 1) * l1 + k1];
                        Dlartg.dlartg(d18, d21, doublew, doublew2, doublew1);
                        double d1 = doublew.val * ad2[(j3 - 1) + (2 - 1) * l1 + k1] + doublew2.val * ad2[((j3 + 1) - 1) + (1 - 1) * l1 + k1];
                        double d6 = doublew.val * ad2[((j3 + 1) - 1) + (1 - 1) * l1 + k1] + doublew2.val * ad2[((j3 + 1) - 1) + (2 - 1) * l1 + k1];
                        double d12 = doublew.val * ad2[((j3 + 1) - 1) + (2 - 1) * l1 + k1] - doublew2.val * ad2[((j3 + 1) - 1) + (1 - 1) * l1 + k1];
                        double d9 = doublew.val * ad2[((j3 + 1) - 1) + (1 - 1) * l1 + k1] - doublew2.val * ad2[(j3 - 1) + (2 - 1) * l1 + k1];
                        ad2[(j3 - 1) + (2 - 1) * l1 + k1] = doublew.val * d1 + doublew2.val * d6;
                        ad2[((j3 + 1) - 1) + (2 - 1) * l1 + k1] = doublew.val * d12 - doublew2.val * d9;
                        ad2[((j3 + 1) - 1) + (1 - 1) * l1 + k1] = doublew.val * d9 + doublew2.val * d12;
                        int l3 = 1;
                        for(int l5 = (Math.min(j3 + intw1.val, j4) - 1) + 1; l5 > 0; l5--)
                        {
                            double d2 = doublew.val * ad4[(l3 - 1) + (j3 - 1) * k2 + j2] + doublew2.val * ad4[(l3 - 1) + ((j3 + 1) - 1) * k2 + j2];
                            ad4[(l3 - 1) + ((j3 + 1) - 1) * k2 + j2] = -(doublew2.val * ad4[(l3 - 1) + (j3 - 1) * k2 + j2]) + doublew.val * ad4[(l3 - 1) + ((j3 + 1) - 1) * k2 + j2];
                            ad4[(l3 - 1) + (j3 - 1) * k2 + j2] = d2;
                            l3++;
                        }

                        intw.val = j3 + 1;
                        for(int i6 = (i3 - 1 - (j3 + 1)) + 1; i6 > 0; i6--)
                        {
                            double d19 = ad2[(intw.val - 1) + (1 - 1) * l1 + k1];
                            double d22 = doublew2.val * ad2[((intw.val + 1) - 1) + (1 - 1) * l1 + k1];
                            ad2[((intw.val + 1) - 1) + (1 - 1) * l1 + k1] = doublew.val * ad2[((intw.val + 1) - 1) + (1 - 1) * l1 + k1];
                            Dlartg.dlartg(d19, d22, doublew, doublew2, doublew1);
                            if(doublew1.val < 0.0D)
                            {
                                doublew1.val = -doublew1.val;
                                doublew.val = -doublew.val;
                                doublew2.val = -doublew2.val;
                            }
                            ad2[(intw.val - 1) + (1 - 1) * l1 + k1] = doublew1.val;
                            double d3 = doublew.val * ad2[(intw.val - 1) + (2 - 1) * l1 + k1] + doublew2.val * ad2[((intw.val + 1) - 1) + (1 - 1) * l1 + k1];
                            double d7 = doublew.val * ad2[((intw.val + 1) - 1) + (1 - 1) * l1 + k1] + doublew2.val * ad2[((intw.val + 1) - 1) + (2 - 1) * l1 + k1];
                            double d10 = doublew.val * ad2[((intw.val + 1) - 1) + (1 - 1) * l1 + k1] - doublew2.val * ad2[(intw.val - 1) + (2 - 1) * l1 + k1];
                            double d13 = doublew.val * ad2[((intw.val + 1) - 1) + (2 - 1) * l1 + k1] - doublew2.val * ad2[((intw.val + 1) - 1) + (1 - 1) * l1 + k1];
                            ad2[(intw.val - 1) + (2 - 1) * l1 + k1] = doublew.val * d3 + doublew2.val * d7;
                            ad2[((intw.val + 1) - 1) + (2 - 1) * l1 + k1] = doublew.val * d13 - doublew2.val * d10;
                            ad2[((intw.val + 1) - 1) + (1 - 1) * l1 + k1] = doublew.val * d10 + doublew2.val * d13;
                            int i4 = 1;
                            for(int k6 = (Math.min(intw.val + intw1.val, j4) - 1) + 1; k6 > 0; k6--)
                            {
                                double d4 = doublew.val * ad4[(i4 - 1) + (intw.val - 1) * k2 + j2] + doublew2.val * ad4[(i4 - 1) + ((intw.val + 1) - 1) * k2 + j2];
                                ad4[(i4 - 1) + ((intw.val + 1) - 1) * k2 + j2] = -(doublew2.val * ad4[(i4 - 1) + (intw.val - 1) * k2 + j2]) + doublew.val * ad4[(i4 - 1) + ((intw.val + 1) - 1) * k2 + j2];
                                ad4[(i4 - 1) + (intw.val - 1) * k2 + j2] = d4;
                                i4++;
                            }

                            intw.val = intw.val + 1;
                        }

                    }
                    j3 = i3 + 1;
                    if(ad2[(i3 - 1) + (1 - 1) * l1 + k1] < 0.0D)
                    {
                        ad2[(i3 - 1) + (1 - 1) * l1 + k1] = -ad2[(i3 - 1) + (1 - 1) * l1 + k1];
                        Dscal.dscal(j4, -1D, ad4, (1 - 1) + (i3 - 1) * k2 + j2, 1);
                    }
                } while(i3 < j4);
                intw.val = k3;
                for(int j6 = (j4 - 1 - k3) + 1; j6 > 0; j6--)
                {
                    if(ad2[((intw.val + 1) - 1) + (1 - 1) * l1 + k1] > 0.0D)
                        break;
                    k3++;
                    intw.val = intw.val + 1;
                }

                intw1.val = intw1.val + 1;
            }

            intw.val = k3;
            for(int i5 = (j4 - 1 - k3) + 1; i5 > 0; i5--)
            {
                double d16 = Math.abs(ad2[(intw.val - 1) + (2 - 1) * l1 + k1]) + Math.abs(ad2[((intw.val + 1) - 1) + (2 - 1) * l1 + k1]);
                if(ad2[((intw.val + 1) - 1) + (1 - 1) * l1 + k1] <= epsmch * d16)
                {
                    if(k4 > 0)
                    {
                        ivout_adapter(arpack_debug.logfil.val, 1, intw, arpack_debug.ndigit.val, "_sapps: deflation at row/column no.");
                        Dvout.dvout(arpack_debug.logfil.val, 1, ad2, ((intw.val + 1) - 1) + (1 - 1) * l1 + k1, arpack_debug.ndigit.val, "_sapps: the corresponding off diagonal element");
                    }
                    ad2[((intw.val + 1) - 1) + (1 - 1) * l1 + k1] = 0.0D;
                }
                intw.val = intw.val + 1;
            }

            if(ad2[((j + 1) - 1) + (1 - 1) * l1 + k1] > 0.0D)
                Dgemv.dgemv("N", i, j4, 1.0D, ad1, i1, j1, ad4, (1 - 1) + ((j + 1) - 1) * k2 + j2, 1, 0.0D, ad5, ((i + 1) - 1) + l2, 1);
            intw.val = 1;
            for(int j5 = (j - 1) + 1; j5 > 0; j5--)
            {
                Dgemv.dgemv("N", i, (j4 - intw.val) + 1, 1.0D, ad1, i1, j1, ad4, (1 - 1) + (((j - intw.val) + 1) - 1) * k2 + j2, 1, 0.0D, ad5, l2, 1);
                Dcopy.dcopy(i, ad5, l2, 1, ad1, (1 - 1) + (((j4 - intw.val) + 1) - 1) * j1 + i1, 1);
                intw.val = intw.val + 1;
            }

            Dlacpy.dlacpy("All", i, j, ad1, (1 - 1) + ((k + 1) - 1) * j1 + i1, j1, ad1, i1, j1);
            if(ad2[((j + 1) - 1) + (1 - 1) * l1 + k1] > 0.0D)
                Dcopy.dcopy(i, ad5, ((i + 1) - 1) + l2, 1, ad1, (1 - 1) + ((j + 1) - 1) * j1 + i1, 1);
            Dscal.dscal(i, ad4[(j4 - 1) + (j - 1) * k2 + j2], ad3, i2, 1);
            if(ad2[((j + 1) - 1) + (1 - 1) * l1 + k1] > 0.0D)
                Daxpy.daxpy(i, ad2[((j + 1) - 1) + (1 - 1) * l1 + k1], ad1, (1 - 1) + ((j + 1) - 1) * j1 + i1, 1, ad3, i2, 1);
            if(k4 > 1)
            {
                Dvout.dvout(arpack_debug.logfil.val, 1, ad4, (j4 - 1) + (j - 1) * k2 + j2, arpack_debug.ndigit.val, "_sapps: sigmak of the updated residual vector");
                Dvout.dvout(arpack_debug.logfil.val, 1, ad2, ((j + 1) - 1) + (1 - 1) * l1 + k1, arpack_debug.ndigit.val, "_sapps: betak of the updated residual vector");
                Dvout.dvout(arpack_debug.logfil.val, j, ad2, (1 - 1) + (2 - 1) * l1 + k1, arpack_debug.ndigit.val, "_sapps: updated main diagonal of H for next iteration");
                if(j > 1)
                    Dvout.dvout(arpack_debug.logfil.val, j - 1, ad2, (2 - 1) + (1 - 1) * l1 + k1, arpack_debug.ndigit.val, "_sapps: updated sub diagonal of H for next iteration");
            }
            Second.second(t1);
            arpack_timing.tsapps.val = arpack_timing.tsapps.val + (t1.val - t0.val);
        }
    }

    private static void ivout_adapter(int i, int j, intW intw, int k, String s)
    {
        int ai[] = {
            intw.val
        };
        Ivout.ivout(i, j, ai, 0, k, s);
        intw.val = ai[0];
    }

    public static floatW t0 = new floatW(0.0F);
    public static floatW t1 = new floatW(0.0F);
    public static float t2 = 0.0F;
    public static float t3 = 0.0F;
    public static float t4 = 0.0F;
    public static float t5 = 0.0F;
    public static boolean first = true;
    public static double epsmch = 0.0D;
}

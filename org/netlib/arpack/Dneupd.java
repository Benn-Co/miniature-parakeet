package org.netlib.arpack;

import org.netlib.blas.*;
import org.netlib.lapack.*;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dneupd
{
    public static void dneupd(boolean flag, String s, boolean aflag[], int i, double ad[], int j, double ad1[], int k, 
            double ad2[], int l, int i1, double d, double d1, 
            double ad3[], int j1, String s1, int k1, String s2, intW intw, double d2, double ad4[], int l1, int i2, double ad5[], int j2, int k2, 
            int ai[], int l2, int ai1[], int i3, double ad6[], int j3, double ad7[], 
            int k3, int l3, intW intw1)
    {
label0:
        {
            String s3 = new String("      ");
            int i4 = 0;
            intW intw2 = new intW(0);
            int j4 = 0;
            int k4 = 0;
            int l4 = 0;
            int i5 = 0;
            intW intw3 = new intW(0);
            int j5 = 0;
            int k5 = 0;
            int ai2[] = new int[1];
            int l7 = 0;
            int i8 = 0;
            int j8 = 0;
            int k8 = 0;
            intW intw4 = new intW(0);
            int l8 = 0;
            int i9 = 0;
            int k9 = 0;
            int l9 = 0;
            int i10 = 0;
            intW intw5 = new intW(0);
            intW intw6 = new intW(0);
            doubleW doublew = new doubleW(0.0D);
            double d3 = 0.0D;
            doubleW doublew1 = new doubleW(0.0D);
            double ad8[] = new double[1 * 1];
            double d12 = 0.0D;
            k8 = arpack_debug.mneupd.val;
            j8 = ai[(7 - 1) + l2];
            intw3.val = ai[(5 - 1) + l2];
            intw1.val = 0;
            d12 = Dlamch.dlamch("Epsilon-Machine");
            d12 = Math.pow(d12, 2D / 3D);
            intw2.val = 0;
            if(intw3.val <= 0)
                intw2.val = -14;
            else
            if(k1 <= 0)
                intw2.val = -1;
            else
            if(intw.val <= 0)
                intw2.val = -2;
            else
            if((i2 <= intw.val + 1) || (i2 > k1))
                intw2.val = -3;
            else
            if(((((s2.regionMatches(0, "LM", 0, 2) ^ true && s2.regionMatches(0, "SM", 0, 2) ^ true) && s2.regionMatches(0, "LR", 0, 2) ^ true) && s2.regionMatches(0, "SR", 0, 2) ^ true) && s2.regionMatches(0, "LI", 0, 2) ^ true) && s2.regionMatches(0, "SI", 0, 2) ^ true)
                intw2.val = -5;
            else
            if(s1.regionMatches(0, "I", 0, 1) ^ true && s1.regionMatches(0, "G", 0, 1) ^ true)
                intw2.val = -6;
            else
            if(l3 < 3 * (int)Math.pow(i2, 2) + 6 * i2)
                intw2.val = -7;
            else
            if(((s.regionMatches(0, "A", 0, 1) ^ true && s.regionMatches(0, "P", 0, 1) ^ true) && s.regionMatches(0, "S", 0, 1) ^ true) && flag)
                intw2.val = -13;
            else
            if(s.regionMatches(0, "S", 0, 1))
                intw2.val = -12;
            if((j8 == 1) || (j8 == 2))
                s3 = "REGULR";
            else
            if((j8 == 3) && (d1 == 0.0D))
                s3 = "SHIFTI";
            else
            if(j8 == 3)
                s3 = "REALPT";
            else
            if(j8 == 4)
                s3 = "IMAGPT";
            else
                intw2.val = -10;
            if((j8 == 1) && s1.regionMatches(0, "G", 0, 1))
                intw2.val = -11;
            if(intw2.val != 0)
            {
                intw1.val = intw2.val;
                break label0;
            }
            j4 = ai1[(5 - 1) + i3];
            l8 = ai1[(6 - 1) + i3];
            i9 = ai1[(7 - 1) + i3];
            i4 = ai1[(8 - 1) + i3];
            l7 = i2;
            i8 = i2;
            l4 = i4 + l7;
            i5 = l4 + l7;
            k4 = i5 + l7;
            k5 = k4 + l7;
            j5 = k5 + l7 * i2;
            ai1[(9 - 1) + i3] = l4;
            ai1[(10 - 1) + i3] = i5;
            ai1[(11 - 1) + i3] = k4;
            ai1[(12 - 1) + i3] = k5;
            ai1[(13 - 1) + i3] = j5;

            k9 = ai1[(14 - 1) + i3] + i2 * i2;
            l9 = k9 + i2;
            i10 = l9 + i2;
            d3 = ad7[((j4 + 2) - 1) + k3];
            ad7[((j4 + 2) - 1) + k3] = 0.0D;
            if(k8 > 2)
            {
                Dvout.dvout(arpack_debug.logfil.val, i2, ad7, (k9 - 1) + k3, arpack_debug.ndigit.val, "_neupd: Real part of Ritz values passed in from _NAUPD.");
                Dvout.dvout(arpack_debug.logfil.val, i2, ad7, (l9 - 1) + k3, arpack_debug.ndigit.val, "_neupd: Imag part of Ritz values passed in from _NAUPD.");
                Dvout.dvout(arpack_debug.logfil.val, i2, ad7, (i10 - 1) + k3, arpack_debug.ndigit.val, "_neupd: Ritz estimates passed in from _NAUPD.");
            }
            if(flag)
            {
                boolean flag10 = false;
                int i6 = 1;
                for(int l10 = (i2 - 1) + 1; l10 > 0; l10--)
                {
                    ad7[((i4 + i6) - 1 - 1) + k3] = i6;
                    aflag[(i6 - 1) + i] = false;
                    i6++;
                }

                intw6.val = i2 - intw.val;
                int j10 = 0;
                Dngets.dngets(j10, s2, intw, intw6, ad7, (k9 - 1) + k3, ad7, (l9 - 1) + k3, ad7, (i4 - 1) + k3, ad7, k3, ad7, ((intw6.val + 1) - 1) + k3);
                if(k8 > 2)
                {
                    Dvout.dvout(arpack_debug.logfil.val, i2, ad7, (k9 - 1) + k3, arpack_debug.ndigit.val, "_neupd: Real part of Ritz values after calling _NGETS.");
                    Dvout.dvout(arpack_debug.logfil.val, i2, ad7, (l9 - 1) + k3, arpack_debug.ndigit.val, "_neupd: Imag part of Ritz values after calling _NGETS.");
                    Dvout.dvout(arpack_debug.logfil.val, i2, ad7, (i4 - 1) + k3, arpack_debug.ndigit.val, "_neupd: Ritz value indices after calling _NGETS.");
                }
                intw5.val = 0;
                i6 = 1;
                for(int i11 = (i2 - 1) + 1; i11 > 0; i11--)
                {
                    double d11 = Math.max(d12, Dlapy2.dlapy2(ad7[((k9 + i2) - i6 - 1) + k3], ad7[((l9 + i2) - i6 - 1) + k3]));
                    int k10 = (int)ad7[((i4 + i2) - i6 - 1) + k3];
                    if((intw5.val < intw3.val) && (ad7[((i10 + k10) - 1 - 1) + k3] <= d2 * d11))
                    {
                        aflag[(k10 - 1) + i] = true;
                        intw5.val = intw5.val + 1;
                        if(k10 > intw.val)
                            flag10 = true;
                    }
                    i6++;
                }

                if(k8 > 2)
                {
                    ivout_adapter(arpack_debug.logfil.val, 1, intw5, arpack_debug.ndigit.val, "_neupd: Number of specified eigenvalues");
                    ivout_adapter(arpack_debug.logfil.val, 1, intw3, arpack_debug.ndigit.val, "_neupd: Number of \"converged\" eigenvalues");
                }
                if(intw5.val != intw3.val)
                {
                    intw1.val = -15;
                    break label0;
                }
                Dcopy.dcopy(l7 * i2, ad7, (j4 - 1) + k3, 1, ad7, (k5 - 1) + k3, 1);
                Dlaset.dlaset("All", i2, i2, 0.0D, 1.0D, ad7, (j5 - 1) + k3, i8);
                Dlahqr.dlahqr(true, true, i2, 1, i2, ad7, (k5 - 1) + k3, l7, ad7, (l4 - 1) + k3, ad7, (i5 - 1) + k3, 1, i2, ad7, (j5 - 1) + k3, i8, intw2);
                Dcopy.dcopy(i2, ad7, ((j5 + i2) - 1 - 1) + k3, i8, ad7, (k4 - 1) + k3, 1);
                if(intw2.val != 0)
                {
                    intw1.val = -8;
                    break label0;
                }
                if(k8 > 1)
                {
                    Dvout.dvout(arpack_debug.logfil.val, i2, ad7, (l4 - 1) + k3, arpack_debug.ndigit.val, "_neupd: Real part of the eigenvalues of H");
                    Dvout.dvout(arpack_debug.logfil.val, i2, ad7, (i5 - 1) + k3, arpack_debug.ndigit.val, "_neupd: Imaginary part of the Eigenvalues of H");
                    Dvout.dvout(arpack_debug.logfil.val, i2, ad7, (k4 - 1) + k3, arpack_debug.ndigit.val, "_neupd: Last row of the Schur vector matrix");
                    if(k8 > 3)
                        Dmout.dmout(arpack_debug.logfil.val, i2, i2, ad7, (k5 - 1) + k3, l7, arpack_debug.ndigit.val, "_neupd: The upper quasi-triangular matrix ");
                }
                if(flag10)
                {
                    Dtrsen.dtrsen("None", "V", aflag, i, i2, ad7, (k5 - 1) + k3, l7, ad7, (j5 - 1) + k3, i8, ad7, (l4 - 1) + k3, ad7, (i5 - 1) + k3, intw3, doublew, doublew1, ad7, (k4 - 1) + k3, i2, ai2, 0, 1, intw2);
                    if(intw2.val == 1)
                    {
                        intw1.val = 1;
                        break label0;
                    }
                    if(k8 > 2)
                    {
                        Dvout.dvout(arpack_debug.logfil.val, i2, ad7, (l4 - 1) + k3, arpack_debug.ndigit.val, "_neupd: Real part of the eigenvalues of H--reordered");
                        Dvout.dvout(arpack_debug.logfil.val, i2, ad7, (i5 - 1) + k3, arpack_debug.ndigit.val, "_neupd: Imag part of the eigenvalues of H--reordered");
                        if(k8 > 3)
                            Dmout.dmout(arpack_debug.logfil.val, i2, i2, ad7, (k5 - 1) + k3, i8, arpack_debug.ndigit.val, "_neupd: Quasi-triangular matrix after re-ordering");
                    }
                }
                Dcopy.dcopy(i2, ad7, ((j5 + i2) - 1 - 1) + k3, i8, ad7, (k4 - 1) + k3, 1);
                if(s3.regionMatches(0, "REGULR", 0, 6))
                {
                    Dcopy.dcopy(intw3.val, ad7, (l4 - 1) + k3, 1, ad, j, 1);
                    Dcopy.dcopy(intw3.val, ad7, (i5 - 1) + k3, 1, ad1, k, 1);
                }
                Dgeqr2.dgeqr2(i2, intw3.val, ad7, (j5 - 1) + k3, i8, ad3, j1, ad3, ((i2 + 1) - 1) + j1, intw2);
                Dorm2r.dorm2r("Right", "Notranspose", k1, i2, intw3.val, ad7, (j5 - 1) + k3, i8, ad3, j1, ad5, j2, k2, ad6, ((k1 + 1) - 1) + j3, intw2);
                Dlacpy.dlacpy("All", k1, intw3.val, ad5, j2, k2, ad2, l, i1);
                i6 = 1;
                for(int j11 = (intw3.val - 1) + 1; j11 > 0; j11--)
                {
                    if(ad7[((j5 + (i6 - 1) * i8 + i6) - 1 - 1) + k3] < 0.0D)
                    {
                        Dscal.dscal(intw3.val, -1D, ad7, ((k5 + i6) - 1 - 1) + k3, i8);
                        Dscal.dscal(intw3.val, -1D, ad7, ((k5 + (i6 - 1) * i8) - 1) + k3, 1);
                    }
                    i6++;
                }

                if(s.regionMatches(0, "A", 0, 1))
                {
                    int j6 = 1;
                    for(int k11 = (i2 - 1) + 1; k11 > 0; k11--)
                    {
                        if(j6 <= intw3.val)
                            aflag[(j6 - 1) + i] = true;
                        else
                            aflag[(j6 - 1) + i] = false;
                        j6++;
                    }

                    Dtrevc.dtrevc("Right", "Select", aflag, i, i2, ad7, (k5 - 1) + k3, i8, ad8, 0, 1, ad7, (j5 - 1) + k3, i8, i2, intw4, ad3, j1, intw2);
                    if(intw2.val != 0)
                    {
                        intw1.val = -9;
                        break label0;
                    }
                    boolean flag2 = false;
                    j6 = 1;
                    for(int l11 = (intw3.val - 1) + 1; l11 > 0; l11--)
                    {
                        if(ad7[((i5 + j6) - 1 - 1) + k3] == 0.0D)
                        {
                            double d5 = Dnrm2.dnrm2(i2, ad7, ((j5 + (j6 - 1) * i8) - 1) + k3, 1);
                            Dscal.dscal(i2, 1.0D / d5, ad7, ((j5 + (j6 - 1) * i8) - 1) + k3, 1);
                        } else
                        if(!flag2)
                        {
                            double d6 = Dlapy2.dlapy2(Dnrm2.dnrm2(i2, ad7, ((j5 + (j6 - 1) * i8) - 1) + k3, 1), Dnrm2.dnrm2(i2, ad7, ((j5 + j6 * i8) - 1) + k3, 1));
                            Dscal.dscal(i2, 1.0D / d6, ad7, ((j5 + (j6 - 1) * i8) - 1) + k3, 1);
                            Dscal.dscal(i2, 1.0D / d6, ad7, ((j5 + j6 * i8) - 1) + k3, 1);
                            flag2 = true;
                        } else
                        {
                            flag2 = false;
                        }
                        j6++;
                    }

                    Dgemv.dgemv("T", i2, intw3.val, 1.0D, ad7, (j5 - 1) + k3, i8, ad7, (k4 - 1) + k3, 1, 0.0D, ad3, j1, 1);
                    flag2 = false;
                    j6 = 1;
                    for(int i12 = (intw3.val - 1) + 1; i12 > 0; i12--)
                    {
                        if(ad7[((i5 + j6) - 1 - 1) + k3] != 0.0D)
                            if(!flag2)
                            {
                                ad3[(j6 - 1) + j1] = Dlapy2.dlapy2(ad3[(j6 - 1) + j1], ad3[((j6 + 1) - 1) + j1]);
                                ad3[((j6 + 1) - 1) + j1] = ad3[(j6 - 1) + j1];
                                flag2 = true;
                            } else
                            {
                                flag2 = false;
                            }
                        j6++;
                    }

                    if(k8 > 2)
                    {
                        Dcopy.dcopy(i2, ad7, ((j5 + i2) - 1 - 1) + k3, i8, ad7, (k4 - 1) + k3, 1);
                        Dvout.dvout(arpack_debug.logfil.val, i2, ad7, (k4 - 1) + k3, arpack_debug.ndigit.val, "_neupd: Last row of the eigenvector matrix for T");
                        if(k8 > 3)
                            Dmout.dmout(arpack_debug.logfil.val, i2, i2, ad7, (j5 - 1) + k3, i8, arpack_debug.ndigit.val, "_neupd: The eigenvector matrix for T");
                    }
                    Dcopy.dcopy(intw3.val, ad3, j1, 1, ad7, (k4 - 1) + k3, 1);
                    Dgeqr2.dgeqr2(i2, intw3.val, ad7, (j5 - 1) + k3, i8, ad3, j1, ad3, ((i2 + 1) - 1) + j1, intw2);
                    Dorm2r.dorm2r("Right", "Notranspose", k1, i2, intw3.val, ad7, (j5 - 1) + k3, i8, ad3, j1, ad2, l, i1, ad6, ((k1 + 1) - 1) + j3, intw2);
                    Dtrmm.dtrmm("Right", "Upper", "No transpose", "Non-unit", k1, intw3.val, 1.0D, ad7, (j5 - 1) + k3, i8, ad2, l, i1);
                }
            } else
            {
                Dcopy.dcopy(intw3.val, ad7, (l8 - 1) + k3, 1, ad, j, 1);
                Dcopy.dcopy(intw3.val, ad7, (i9 - 1) + k3, 1, ad1, k, 1);
                Dcopy.dcopy(intw3.val, ad7, (l8 - 1) + k3, 1, ad7, (l4 - 1) + k3, 1);
                Dcopy.dcopy(intw3.val, ad7, (i9 - 1) + k3, 1, ad7, (i5 - 1) + k3, 1);
                Dcopy.dcopy(intw3.val, ad7, (i4 - 1) + k3, 1, ad7, (k4 - 1) + k3, 1);
            }
            if(s3.regionMatches(0, "REGULR", 0, 6))
            {
                if(flag)
                    Dscal.dscal(i2, d3, ad7, (k4 - 1) + k3, 1);
            } else
            {
                if(s3.regionMatches(0, "SHIFTI", 0, 6))
                {
                    if(flag)
                        Dscal.dscal(i2, d3, ad7, (k4 - 1) + k3, 1);
                    int l6 = 1;
                    for(int j12 = (i2 - 1) + 1; j12 > 0; j12--)
                    {
                        double d7 = Dlapy2.dlapy2(ad7[((l4 + l6) - 1 - 1) + k3], ad7[((i5 + l6) - 1 - 1) + k3]);
                        ad7[((k4 + l6) - 1 - 1) + k3] = Math.abs(ad7[((k4 + l6) - 1 - 1) + k3]) / d7 / d7;
                        l6++;
                    }

                } else
                if(s3.regionMatches(0, "REALPT", 0, 6))
                {
                    // no-op

                } else
                if(s3.regionMatches(0, "IMAGPT", 0, 6))
                {
                    // no-op

                }
                if(s3.regionMatches(0, "SHIFTI", 0, 6))
                {
                    int k7 = 1;
                    for(int i13 = (i2 - 1) + 1; i13 > 0; i13--)
                    {
                        double d8 = Dlapy2.dlapy2(ad7[((l4 + k7) - 1 - 1) + k3], ad7[((i5 + k7) - 1 - 1) + k3]);
                        ad7[((l4 + k7) - 1 - 1) + k3] = ad7[((l4 + k7) - 1 - 1) + k3] / d8 / d8 + d;
                        ad7[((i5 + k7) - 1 - 1) + k3] = -(ad7[((i5 + k7) - 1 - 1) + k3] / d8 / d8) + d1;
                        k7++;
                    }

                    Dcopy.dcopy(intw3.val, ad7, (l4 - 1) + k3, 1, ad, j, 1);
                    Dcopy.dcopy(intw3.val, ad7, (i5 - 1) + k3, 1, ad1, k, 1);
                } else
                if(s3.regionMatches(0, "REALPT", 0, 6) || s3.regionMatches(0, "IMAGPT", 0, 6))
                {
                    Dcopy.dcopy(intw3.val, ad7, (l4 - 1) + k3, 1, ad, j, 1);
                    Dcopy.dcopy(intw3.val, ad7, (i5 - 1) + k3, 1, ad1, k, 1);
                }
            }
            if(s3.regionMatches(0, "SHIFTI", 0, 6) && (k8 > 1))
            {
                Dvout.dvout(arpack_debug.logfil.val, intw3.val, ad, j, arpack_debug.ndigit.val, "_neupd: Untransformed real part of the Ritz valuess.");
                Dvout.dvout(arpack_debug.logfil.val, intw3.val, ad1, k, arpack_debug.ndigit.val, "_neupd: Untransformed imag part of the Ritz valuess.");
                Dvout.dvout(arpack_debug.logfil.val, intw3.val, ad7, (k4 - 1) + k3, arpack_debug.ndigit.val, "_neupd: Ritz estimates of untransformed Ritz values.");
            } else
            if(s3.regionMatches(0, "REGULR", 0, 6) && (k8 > 1))
            {
                Dvout.dvout(arpack_debug.logfil.val, intw3.val, ad, j, arpack_debug.ndigit.val, "_neupd: Real parts of converged Ritz values.");
                Dvout.dvout(arpack_debug.logfil.val, intw3.val, ad1, k, arpack_debug.ndigit.val, "_neupd: Imag parts of converged Ritz values.");
                Dvout.dvout(arpack_debug.logfil.val, intw3.val, ad7, (k4 - 1) + k3, arpack_debug.ndigit.val, "_neupd: Associated Ritz estimates.");
            }
            if((flag && s.regionMatches(0, "A", 0, 1)) && s3.regionMatches(0, "SHIFTI", 0, 6))
            {
                boolean flag3 = false;
                int k6 = 1;
                for(int j13 = (intw3.val - 1) + 1; j13 > 0; j13--)
                {
                    if(ad7[((i5 + k6) - 1 - 1) + k3] == 0.0D)
                        ad3[(k6 - 1) + j1] = ad7[((j5 + (k6 - 1) * i8 + i2) - 1 - 1) + k3] / ad7[((l4 + k6) - 1 - 1) + k3];
                    else
                    if(!flag3)
                    {
                        double d9 = Dlapy2.dlapy2(ad7[((l4 + k6) - 1 - 1) + k3], ad7[((i5 + k6) - 1 - 1) + k3]);
                        ad3[(k6 - 1) + j1] = (ad7[((j5 + (k6 - 1) * i8 + i2) - 1 - 1) + k3] * ad7[((l4 + k6) - 1 - 1) + k3] + ad7[((j5 + k6 * i8 + i2) - 1 - 1) + k3] * ad7[((i5 + k6) - 1 - 1) + k3]) / d9 / d9;
                        ad3[((k6 + 1) - 1) + j1] = (ad7[((j5 + k6 * i8 + i2) - 1 - 1) + k3] * ad7[((l4 + k6) - 1 - 1) + k3] - ad7[((j5 + (k6 - 1) * i8 + i2) - 1 - 1) + k3] * ad7[((i5 + k6) - 1 - 1) + k3]) / d9 / d9;
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    k6++;
                }

                Dger.dger(k1, intw3.val, 1.0D, ad4, l1, 1, ad3, j1, 1, ad2, l, i1);
            }
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

    public static float t0 = 0.0F;
    public static float t1 = 0.0F;
    public static float t2 = 0.0F;
    public static float t3 = 0.0F;
    public static float t4 = 0.0F;
    public static float t5 = 0.0F;
}

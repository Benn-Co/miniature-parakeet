package org.netlib.arpack;

import org.netlib.blas.*;
import org.netlib.lapack.*;
import org.netlib.util.*;

public final class Dneigh
{
    public static void dneigh(double d, intW intw, double ad[], int i, int j, double ad1[], int k, 
            double ad2[], int l, double ad3[], int i1, double ad4[], int j1, int k1, 
            double ad5[], int l1, intW intw1)
    {
        boolean aflag[] = new boolean[1];
        int j2 = 0;
        double ad6[] = new double[1];
        Etime.etime();
        Second.second(t0);
        j2 = arpack_debug.mneigh.val;
        if(j2 > 2)
            Dmout.dmout(arpack_debug.logfil.val, intw.val, intw.val, ad, i, j, arpack_debug.ndigit.val, "_neigh: Entering upper Hessenberg matrix H ");
        Dlacpy.dlacpy("All", intw.val, intw.val, ad, i, j, ad5, l1, intw.val);
        Dlaqrb.dlaqrb(true, intw.val, 1, intw.val, ad5, l1, intw.val, ad1, k, ad2, l, ad3, i1, intw1);
        if(intw1.val == 0)
        {
            if(j2 > 1)
                Dvout.dvout(arpack_debug.logfil.val, intw.val, ad3, i1, arpack_debug.ndigit.val, "_neigh: last row of the Schur matrix for H");
            Dtrevc.dtrevc("R", "A", aflag, 0, intw.val, ad5, l1, intw.val, ad6, 0, intw.val, ad4, j1, k1, intw.val, intw, ad5, ((intw.val * intw.val + 1) - 1) + l1, intw1);
            if(intw1.val == 0)
            {
                boolean flag2 = false;
                int i2 = 1;
                for(int k2 = (intw.val - 1) + 1; k2 > 0; k2--)
                {
                    if(Math.abs(ad2[(i2 - 1) + l]) <= 0.0D)
                    {
                        double d2 = Dnrm2.dnrm2(intw.val, ad4, (1 - 1) + (i2 - 1) * k1 + j1, 1);
                        Dscal.dscal(intw.val, 1.0D / d2, ad4, (1 - 1) + (i2 - 1) * k1 + j1, 1);
                    } else
                    if(!flag2)
                    {
                        double d3 = Dlapy2.dlapy2(Dnrm2.dnrm2(intw.val, ad4, (1 - 1) + (i2 - 1) * k1 + j1, 1), Dnrm2.dnrm2(intw.val, ad4, (1 - 1) + ((i2 + 1) - 1) * k1 + j1, 1));
                        Dscal.dscal(intw.val, 1.0D / d3, ad4, (1 - 1) + (i2 - 1) * k1 + j1, 1);
                        Dscal.dscal(intw.val, 1.0D / d3, ad4, (1 - 1) + ((i2 + 1) - 1) * k1 + j1, 1);
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    i2++;
                }

                Dgemv.dgemv("T", intw.val, intw.val, 1.0D, ad4, j1, k1, ad3, i1, 1, 0.0D, ad5, l1, 1);
                if(j2 > 1)
                    Dvout.dvout(arpack_debug.logfil.val, intw.val, ad5, l1, arpack_debug.ndigit.val, "_neigh: Last row of the eigenvector matrix for H");
                flag2 = false;
                i2 = 1;
                for(int l2 = (intw.val - 1) + 1; l2 > 0; l2--)
                {
                    if(Math.abs(ad2[(i2 - 1) + l]) <= 0.0D)
                        ad3[(i2 - 1) + i1] = d * Math.abs(ad5[(i2 - 1) + l1]);
                    else
                    if(!flag2)
                    {
                        ad3[(i2 - 1) + i1] = d * Dlapy2.dlapy2(ad5[(i2 - 1) + l1], ad5[((i2 + 1) - 1) + l1]);
                        ad3[((i2 + 1) - 1) + i1] = ad3[(i2 - 1) + i1];
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    i2++;
                }

                if(j2 > 2)
                {
                    Dvout.dvout(arpack_debug.logfil.val, intw.val, ad1, k, arpack_debug.ndigit.val, "_neigh: Real part of the eigenvalues of H");
                    Dvout.dvout(arpack_debug.logfil.val, intw.val, ad2, l, arpack_debug.ndigit.val, "_neigh: Imaginary part of the eigenvalues of H");
                    Dvout.dvout(arpack_debug.logfil.val, intw.val, ad3, i1, arpack_debug.ndigit.val, "_neigh: Ritz estimates for the eigenvalues of H");
                }
                Second.second(t1);
                arpack_timing.tneigh.val = arpack_timing.tneigh.val + (t1.val - t0.val);
            }
        }
    }

    public static floatW t0 = new floatW(0.0F);
    public static floatW t1 = new floatW(0.0F);
    public static float t2 = 0.0F;
    public static float t3 = 0.0F;
    public static float t4 = 0.0F;
    public static float t5 = 0.0F;
}

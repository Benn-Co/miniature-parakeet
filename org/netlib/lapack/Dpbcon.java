package org.netlib.lapack;

import org.netlib.blas.Idamax;
import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dpbcon
{
    public static void dpbcon(String s, int i, int j, double ad[], int k, int l, double d, 
            doubleW doublew, double ad1[], int i1, int ai[], int j1, intW intw)
    {
label0:
        {
            boolean flag = false;
            String s1 = new String(" ");
            intW intw1 = new intW(0);
            doubleW doublew1 = new doubleW(0.0D);
            doubleW doublew2 = new doubleW(0.0D);
            doubleW doublew3 = new doubleW(0.0D);
            double d3 = 0.0D;
            int ai1[] = new int[3];
            intw.val = 0;
            flag = Lsame.lsame(s, "U");
            if(flag ^ true && Lsame.lsame(s, "L") ^ true)
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
            else
            if(d < 0.0D)
                intw.val = -6;
            if(intw.val != 0)
            {
                Xerbla.xerbla("DPBCON", -intw.val);
                return;
            }
            doublew.val = 0.0D;
            if(i == 0)
            {
                doublew.val = 1.0D;
                return;
            }
            if(d == 0.0D)
                return;
            d3 = Dlamch.dlamch("Safe minimum");
            intw1.val = 0;
            s1 = "N";
            do
            {
                Dlacn2.dlacn2(i, ad1, ((i + 1) - 1) + i1, ad1, i1, ai, j1, doublew1, intw1, ai1, 0);
                if(intw1.val == 0)
                    break;
                if(flag)
                {
                    Dlatbs.dlatbs("Upper", "Transpose", "Non-unit", s1, i, j, ad, k, l, ad1, i1, doublew2, ad1, ((2 * i + 1) - 1) + i1, intw);
                    s1 = "Y";
                    Dlatbs.dlatbs("Upper", "No transpose", "Non-unit", s1, i, j, ad, k, l, ad1, i1, doublew3, ad1, ((2 * i + 1) - 1) + i1, intw);
                } else
                {
                    Dlatbs.dlatbs("Lower", "No transpose", "Non-unit", s1, i, j, ad, k, l, ad1, i1, doublew2, ad1, ((2 * i + 1) - 1) + i1, intw);
                    s1 = "Y";
                    Dlatbs.dlatbs("Lower", "Transpose", "Non-unit", s1, i, j, ad, k, l, ad1, i1, doublew3, ad1, ((2 * i + 1) - 1) + i1, intw);
                }
                double d2 = doublew2.val * doublew3.val;
                if(d2 != 1.0D)
                {
                    int k1 = Idamax.idamax(i, ad1, i1, 1);
                    if((d2 < Math.abs(ad1[(k1 - 1) + i1]) * d3) || (d2 == 0.0D))
                        break label0;
                    Drscl.drscl(i, d2, ad1, i1, 1);
                }
            } while(true);
            if(doublew1.val != 0.0D)
                doublew.val = 1.0D / doublew1.val / d;
        }
    }
}

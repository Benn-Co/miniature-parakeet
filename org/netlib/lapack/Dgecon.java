package org.netlib.lapack;

import org.netlib.blas.Idamax;
import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dgecon
{
    public static void dgecon(String s, int i, double ad[], int j, int k, double d, doubleW doublew, 
            double ad1[], int l, int ai[], int i1, intW intw)
    {
label0:
        {
            boolean flag = false;
            String s1 = new String(" ");
            intW intw1 = new intW(0);
            byte byte0 = 0;
            doubleW doublew1 = new doubleW(0.0D);
            doubleW doublew2 = new doubleW(0.0D);
            double d3 = 0.0D;
            doubleW doublew3 = new doubleW(0.0D);
            int ai1[] = new int[3];
            intw.val = 0;
            flag = s.regionMatches(0, "1", 0, 1) || Lsame.lsame(s, "O");
            if(flag ^ true && Lsame.lsame(s, "I") ^ true)
                intw.val = -1;
            else
            if(i < 0)
                intw.val = -2;
            else
            if(k < Math.max(1, i))
                intw.val = -4;
            else
            if(d < 0.0D)
                intw.val = -5;
            if(intw.val != 0)
            {
                Xerbla.xerbla("DGECON", -intw.val);
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
            doublew1.val = 0.0D;
            s1 = "N";
            if(flag)
                byte0 = 1;
            else
                byte0 = 2;
            intw1.val = 0;
            do
            {
                Dlacn2.dlacn2(i, ad1, ((i + 1) - 1) + l, ad1, l, ai, i1, doublew1, intw1, ai1, 0);
                if(intw1.val == 0)
                    break;
                if(intw1.val == byte0)
                {
                    Dlatrs.dlatrs("Lower", "No transpose", "Unit", s1, i, ad, j, k, ad1, l, doublew2, ad1, ((2 * i + 1) - 1) + l, intw);
                    Dlatrs.dlatrs("Upper", "No transpose", "Non-unit", s1, i, ad, j, k, ad1, l, doublew3, ad1, ((3 * i + 1) - 1) + l, intw);
                } else
                {
                    Dlatrs.dlatrs("Upper", "Transpose", "Non-unit", s1, i, ad, j, k, ad1, l, doublew3, ad1, ((3 * i + 1) - 1) + l, intw);
                    Dlatrs.dlatrs("Lower", "Transpose", "Unit", s1, i, ad, j, k, ad1, l, doublew2, ad1, ((2 * i + 1) - 1) + l, intw);
                }
                double d2 = doublew2.val * doublew3.val;
                s1 = "Y";
                if(d2 != 1.0D)
                {
                    int j1 = Idamax.idamax(i, ad1, l, 1);
                    if((d2 < Math.abs(ad1[(j1 - 1) + l]) * d3) || (d2 == 0.0D))
                        break label0;
                    Drscl.drscl(i, d2, ad1, l, 1);
                }
            } while(true);
            if(doublew1.val != 0.0D)
                doublew.val = 1.0D / doublew1.val / d;
        }
    }
}

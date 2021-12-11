package org.netlib.lapack;

import org.netlib.blas.*;
import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dgbcon
{
    public static void dgbcon(String s, int i, int j, int k, double ad[], int l, int i1, int ai[], 
            int j1, double d, doubleW doublew, double ad1[], int k1, int ai1[], 
            int l1, intW intw)
    {
label0:
        {
            boolean flag = false;
            boolean flag1 = false;
            String s1 = new String(" ");
            intW intw1 = new intW(0);
            byte byte0 = 0;
            int j3 = 0;
            doubleW doublew1 = new doubleW(0.0D);
            doubleW doublew2 = new doubleW(0.0D);
            double d1 = 0.0D;
            int ai2[] = new int[3];
            intw.val = 0;
            flag1 = s.regionMatches(0, "1", 0, 1) || Lsame.lsame(s, "O");
            if(flag1 ^ true && Lsame.lsame(s, "I") ^ true)
                intw.val = -1;
            else
            if(i < 0)
                intw.val = -2;
            else
            if(j < 0)
                intw.val = -3;
            else
            if(k < 0)
                intw.val = -4;
            else
            if(i1 < 2 * j + k + 1)
                intw.val = -6;
            else
            if(d < 0.0D)
                intw.val = -8;
            if(intw.val != 0)
            {
                Xerbla.xerbla("DGBCON", -intw.val);
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
            d1 = Dlamch.dlamch("Safe minimum");
            doublew1.val = 0.0D;
            s1 = "N";
            if(flag1)
                byte0 = 1;
            else
                byte0 = 2;
            j3 = j + k + 1;
            flag = j > 0;
            intw1.val = 0;
            do
            {
                Dlacn2.dlacn2(i, ad1, ((i + 1) - 1) + k1, ad1, k1, ai1, l1, doublew1, intw1, ai2, 0);
                if(intw1.val == 0)
                    break;
                if(intw1.val == byte0)
                {
                    if(flag)
                    {
                        int j2 = 1;
                        for(int i4 = (i - 1 - 1) + 1; i4 > 0; i4--)
                        {
                            int k3 = Math.min(j, i - j2);
                            int l2 = ai[(j2 - 1) + j1];
                            double d3 = ad1[(l2 - 1) + k1];
                            if(l2 != j2)
                            {
                                ad1[(l2 - 1) + k1] = ad1[(j2 - 1) + k1];
                                ad1[(j2 - 1) + k1] = d3;
                            }
                            Daxpy.daxpy(k3, -d3, ad, ((j3 + 1) - 1) + (j2 - 1) * i1 + l, 1, ad1, ((j2 + 1) - 1) + k1, 1);
                            j2++;
                        }

                    }
                    Dlatbs.dlatbs("Upper", "No transpose", "Non-unit", s1, i, j + k, ad, l, i1, ad1, k1, doublew2, ad1, ((2 * i + 1) - 1) + k1, intw);
                } else
                {
                    Dlatbs.dlatbs("Upper", "Transpose", "Non-unit", s1, i, j + k, ad, l, i1, ad1, k1, doublew2, ad1, ((2 * i + 1) - 1) + k1, intw);
                    if(flag)
                    {
                        int k2 = i - 1;
                        for(int j4 = ((1 - (i - 1)) + -1) / -1; j4 > 0; j4--)
                        {
                            int l3 = Math.min(j, i - k2);
                            ad1[(k2 - 1) + k1] = ad1[(k2 - 1) + k1] - Ddot.ddot(l3, ad, ((j3 + 1) - 1) + (k2 - 1) * i1 + l, 1, ad1, ((k2 + 1) - 1) + k1, 1);
                            int i3 = ai[(k2 - 1) + j1];
                            if(i3 != k2)
                            {
                                double d4 = ad1[(i3 - 1) + k1];
                                ad1[(i3 - 1) + k1] = ad1[(k2 - 1) + k1];
                                ad1[(k2 - 1) + k1] = d4;
                            }
                            k2--;
                        }

                    }
                }
                s1 = "Y";
                if(doublew2.val != 1.0D)
                {
                    int i2 = Idamax.idamax(i, ad1, k1, 1);
                    if((doublew2.val < Math.abs(ad1[(i2 - 1) + k1]) * d1) || (doublew2.val == 0.0D))
                        break label0;
                    Drscl.drscl(i, doublew2.val, ad1, k1, 1);
                }
            } while(true);
            if(doublew1.val != 0.0D)
                doublew.val = 1.0D / doublew1.val / d;
        }
    }
}

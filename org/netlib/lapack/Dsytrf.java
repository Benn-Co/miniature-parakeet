package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dsytrf
{
    public static void dsytrf(String s, int i, double ad[], int j, int k, int ai[], int l, double ad1[], 
            int i1, int j1, intW intw)
    {
        boolean flag = false;
        boolean flag1 = false;
        intW intw1 = new intW(0);
        int k1 = 0;
        intW intw2 = new intW(0);
        int k2 = 0;
        int l2 = 0;
        int i3 = 0;
        int j3 = 0;
        intw.val = 0;
        flag1 = Lsame.lsame(s, "U");
        flag = j1 == -1;
        if(flag1 ^ true && Lsame.lsame(s, "L") ^ true)
            intw.val = -1;
        else
        if(i < 0)
            intw.val = -2;
        else
        if(k < Math.max(1, i))
            intw.val = -4;
        else
        if((j1 < 1) && flag ^ true)
            intw.val = -7;
        if(intw.val == 0)
        {
            i3 = Ilaenv.ilaenv(1, "DSYTRF", s, i, -1, -1, -1);
            l2 = i * i3;
            ad1[(1 - 1) + i1] = l2;
        }
        if(intw.val != 0)
        {
            Xerbla.xerbla("DSYTRF", -intw.val);
            return;
        }
        if(flag)
            return;
        j3 = 2;
        k2 = i;
        if((i3 > 1) && (i3 < i))
        {
            k1 = k2 * i3;
            if(j1 < k1)
            {
                i3 = Math.max(j1 / k2, 1);
                j3 = Math.max(2, Ilaenv.ilaenv(2, "DSYTRF", s, i, -1, -1, -1));
            }
        } else
        {
            k1 = 1;
        }
        if(i3 < j3)
            i3 = i;
        if(flag1)
        {
            int i2 = i;
            while(i2 >= 1) 
            {
                if(i2 > i3)
                {
                    Dlasyf.dlasyf(s, i2, i3, intw2, ad, j, k, ai, l, ad1, i1, k2, intw1);
                } else
                {
                    Dsytf2.dsytf2(s, i2, ad, j, k, ai, l, intw1);
                    intw2.val = i2;
                }
                if((intw.val == 0) && (intw1.val > 0))
                    intw.val = intw1.val;
                i2 -= intw2.val;
            }
        } else
        {
            int j2 = 1;
            while(j2 <= i) 
            {
                if(j2 <= i - i3)
                {
                    Dlasyf.dlasyf(s, (i - j2) + 1, i3, intw2, ad, (j2 - 1) + (j2 - 1) * k + j, k, ai, (j2 - 1) + l, ad1, i1, k2, intw1);
                } else
                {
                    Dsytf2.dsytf2(s, (i - j2) + 1, ad, (j2 - 1) + (j2 - 1) * k + j, k, ai, (j2 - 1) + l, intw1);
                    intw2.val = (i - j2) + 1;
                }
                if((intw.val == 0) && (intw1.val > 0))
                    intw.val = (intw1.val + j2) - 1;
                int l1 = j2;
                for(int k3 = ((j2 + intw2.val) - 1 - j2) + 1; k3 > 0; k3--)
                {
                    if(ai[(l1 - 1) + l] > 0)
                        ai[(l1 - 1) + l] = (ai[(l1 - 1) + l] + j2) - 1;
                    else
                        ai[(l1 - 1) + l] = (ai[(l1 - 1) + l] - j2) + 1;
                    l1++;
                }

                j2 += intw2.val;
            }
        }
        ad1[i1] = l2;
    }
}

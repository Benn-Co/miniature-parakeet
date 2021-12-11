package org.netlib.lapack;

import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dlasrt
{
    public static void dlasrt(String s, int i, double ad[], int j, intW intw)
    {
        int j3 = 0;
        int ai[] = new int[2 * 32];
        intw.val = 0;
        int byte0 = -1;
        if(Lsame.lsame(s, "D"))
            byte0 = 0;
        else
        if(Lsame.lsame(s, "I"))
            byte0 = 1;
        if(byte0 == -1)
            intw.val = -1;
        else
        if(i < 0)
            intw.val = -2;
        if(intw.val != 0)
        {
            Xerbla.xerbla("DLASRT", -intw.val);
            return;
        }
        if(i <= 1)
            return;
        j3 = 1;
        ai[(1 - 1) + (1 - 1) * 2] = 1;
        ai[(2 - 1) + (1 - 1) * 2] = i;
        do
        {
            int i3 = ai[(1 - 1) + (j3 - 1) * 2];
            int k = ai[(2 - 1) + (j3 - 1) * 2];
            j3--;
            if((k - i3 <= 20) && (k - i3 > 0))
            {
                if(byte0 == 0)
                {
                    int l = i3 + 1;
                    for(int k3 = (k - (i3 + 1)) + 1; k3 > 0; k3--)
                    {
                        int i2 = l;
                        for(int i4 = (((i3 + 1) - l) + -1) / -1; i4 > 0; i4--)
                        {
                            if(ad[(i2 - 1) + j] <= ad[(i2 - 1 - 1) + j])
                                break;
                            double d7 = ad[(i2 - 1) + j];
                            ad[(i2 - 1) + j] = ad[(i2 - 2) + j];
                            ad[(i2 - 2) + j] = d7;
                            i2--;
                        }

                        l++;
                    }

                } else
                {
                    int i1 = i3 + 1;
                    for(int l3 = (k - (i3 + 1)) + 1; l3 > 0; l3--)
                    {
                        int j2 = i1;
                        for(int j4 = (((i3 + 1) - i1) + -1) / -1; j4 > 0; j4--)
                        {
                            if(ad[(j2 - 1) + j] >= ad[(j2 - 1 - 1) + j])
                                break;
                            double d8 = ad[(j2 - 1) + j];
                            ad[(j2 - 1) + j] = ad[(j2 - 2) + j];
                            ad[(j2 - 2) + j] = d8;
                            j2--;
                        }

                        i1++;
                    }

                }
            } else
            if(k - i3 > 20)
            {
                double d1 = ad[(i3 - 1) + j];
                double d3 = ad[(k - 1) + j];
                int j1 = (i3 + k) / 2;
                double d5 = ad[(j1 - 1) + j];
                double d9;
                if(d1 < d3)
                {
                    if(d5 < d1)
                        d9 = d1;
                    else
                    if(d5 < d3)
                        d9 = d5;
                    else
                        d9 = d3;
                } else
                if(d5 < d3)
                    d9 = d3;
                else
                if(d5 < d1)
                    d9 = d5;
                else
                    d9 = d1;
                if(byte0 == 0)
                {
                    int k1 = i3 - 1;
                    int k2 = k + 1;
                    do
                    {
                        do
                            k2--;
                        while(ad[(k2 - 1) + j] < d9);
                        do
                            k1++;
                        while(ad[(k1 - 1) + j] > d9);
                        if(k1 >= k2)
                            break;
                        double d11 = ad[(k1 - 1) + j];
                        ad[(k1 - 1) + j] = ad[(k2 - 1) + j];
                        ad[(k2 - 1) + j] = d11;
                    } while(true);
                    if(k2 - i3 > k - k2 - 1)
                    {
                        j3++;
                        ai[(j3 - 1) * 2] = i3;
                        ai[1 + (j3 - 1) * 2] = k2;
                        j3++;
                        ai[(j3 - 1) * 2] = k2 + 1;
                        ai[1 + (j3 - 1) * 2] = k;
                    } else
                    {
                        j3++;
                        ai[(j3 - 1) * 2] = k2 + 1;
                        ai[1 + (j3 - 1) * 2] = k;
                        j3++;
                        ai[(j3 - 1) * 2] = i3;
                        ai[1 + (j3 - 1) * 2] = k2;
                    }
                } else
                {
                    int l1 = i3 - 1;
                    int l2 = k + 1;
                    do
                    {
                        do
                            l2--;
                        while(ad[(l2 - 1) + j] > d9);
                        do
                            l1++;
                        while(ad[(l1 - 1) + j] < d9);
                        if(l1 >= l2)
                            break;
                        double d12 = ad[(l1 - 1) + j];
                        ad[(l1 - 1) + j] = ad[(l2 - 1) + j];
                        ad[(l2 - 1) + j] = d12;
                    } while(true);
                    if(l2 - i3 > k - l2 - 1)
                    {
                        j3++;
                        ai[(j3 - 1) * 2] = i3;
                        ai[1 + (j3 - 1) * 2] = l2;
                        j3++;
                        ai[(j3 - 1) * 2] = l2 + 1;
                        ai[1 + (j3 - 1) * 2] = k;
                    } else
                    {
                        j3++;
                        ai[(j3 - 1) * 2] = l2 + 1;
                        ai[1 + (j3 - 1) * 2] = k;
                        j3++;
                        ai[(j3 - 1) * 2] = i3;
                        ai[1 + (j3 - 1) * 2] = l2;
                    }
                }
            }
        } while (j3 > 0);
    }
}

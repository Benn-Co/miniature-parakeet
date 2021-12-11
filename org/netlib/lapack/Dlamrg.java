package org.netlib.lapack;

public final class Dlamrg
{
    public static void dlamrg(int i, int j, double ad[], int k, int l, int i1, int ai[], int j1)
    {
        int k1 = 0;
        int l1 = 0;
        int i2 = 0;
        int j2 = 0;
        int k2 = 0;
        j2 = i;
        k2 = j;
        if(l > 0)
            l1 = 1;
        else
            l1 = i;
        if(i1 > 0)
            i2 = 1 + i;
        else
            i2 = i + j;
        k1 = 1;
        while((j2 > 0) && (k2 > 0)) 
            if(ad[(l1 - 1) + k] <= ad[(i2 - 1) + k])
            {
                ai[(k1 - 1) + j1] = l1;
                k1++;
                l1 += l;
                j2--;
            } else
            {
                ai[(k1 - 1) + j1] = i2;
                k1++;
                i2 += i1;
                k2--;
            }
        if(j2 == 0)
        {
            j2 = 1;
            for(int i3 = (k2 - 1) + 1; i3 > 0; i3--)
            {
                ai[(k1 - 1) + j1] = i2;
                k1++;
                i2 += i1;
                j2++;
            }

        } else
        {
            for(int j3 = (j2 - 1) + 1; j3 > 0; j3--)
            {
                ai[(k1 - 1) + j1] = l1;
                k1++;
                l1 += l;
            }

        }
    }
}

package org.netlib.arpack;

import org.netlib.lapack.Dlamch;
import org.netlib.util.*;

public final class Dsaupd {

    public static void dsaupd(intW intw, String s, int i, String s1, int j, doubleW doublew, double ad[], int k, int l,
            double ad1[], int i1, int j1, int ai[], int k1, int ai1[], int l1, double ad2[], int i2, double ad3[],
            int j2, int k2, intW intw1) {
        label0: {
            Etime.etime();
            if (intw.val == 0) {
                Dstats.dstats();
                Second.second(t0);
                msglvl = arpack_debug.msaupd.val;
                ierr = 0;
                ishift = ai[(1 - 1) + k1];
                mxiter.val = ai[(3 - 1) + k1];
                nb = 1;
                iupd = 1;
                mode = ai[(7 - 1) + k1];
                if (i <= 0)
                    ierr = -1;
                else if (j <= 0)
                    ierr = -2;
                else if ((l <= j) || (l > i))
                    ierr = -3;
                np.val = l - j;
                if (mxiter.val <= 0)
                    ierr = -4;
                if ((((s1.regionMatches(0, "LM", 0, 2) ^ true && s1.regionMatches(0, "SM", 0, 2) ^ true)
                        && s1.regionMatches(0, "LA", 0, 2) ^ true) && s1.regionMatches(0, "SA", 0, 2) ^ true)
                        && s1.regionMatches(0, "BE", 0, 2) ^ true)
                    ierr = -5;
                if (s.regionMatches(0, "I", 0, 1) ^ true && s.regionMatches(0, "G", 0, 1) ^ true)
                    ierr = -6;
                if (k2 < (int) Math.pow(l, 2) + 8 * l)
                    ierr = -7;
                if ((mode < 1) || (mode > 5))
                    ierr = -10;
                else if ((mode == 1) && s.regionMatches(0, "G", 0, 1))
                    ierr = -11;
                else if ((ishift < 0) || (ishift > 1))
                    ierr = -12;
                else if ((j == 1) && s1.regionMatches(0, "BE", 0, 2))
                    ierr = -13;
                if (ierr != 0) {
                    intw1.val = ierr;
                    intw.val = 99;
                    break label0;
                }
                if (nb <= 0)
                    nb = 1;
                if (doublew.val <= 0.0D)
                    doublew.val = Dlamch.dlamch("EpsMach");
                np.val = l - j;
                nev0.val = j;
                int l2 = 1;
                for (int i3 = (((int) Math.pow(l, 2) + 8 * l) - 1) + 1; i3 > 0; i3--) {
                    ad3[(l2 - 1) + j2] = 0.0D;
                    l2++;
                }

                ldh = l;
                ldq = l;
                ih = 1;
                ritz = ih + 2 * ldh;
                bounds = ritz + l;
                iq = bounds + l;
                iw = iq + (int) Math.pow(l, 2);
                next = iw + 3 * l;
                ai1[(4 - 1) + l1] = next;
                ai1[(5 - 1) + l1] = ih;
                ai1[(6 - 1) + l1] = ritz;
                ai1[(7 - 1) + l1] = bounds;
                ai1[(11 - 1) + l1] = iw;
            }
            Dsaup2.dsaup2(intw, s, i, s1, nev0, np, doublew.val, ad, k, mode, iupd, ishift, mxiter, ad1, i1, j1, ad3,
                    (ih - 1) + j2, ldh, ad3, (ritz - 1) + j2, ad3, (bounds - 1) + j2, ad3, (iq - 1) + j2, ldq, ad3,
                    (iw - 1) + j2, ai1, l1, ad2, i2, intw1);
            if (intw.val == 3)
                ai[(8 - 1) + k1] = np.val;
            if (intw.val == 99) {
                ai[(3 - 1) + k1] = mxiter.val;
                ai[(5 - 1) + k1] = np.val;
                ai[(9 - 1) + k1] = arpack_timing.nopx.val;
                ai[(10 - 1) + k1] = arpack_timing.nbx.val;
                ai[(11 - 1) + k1] = arpack_timing.nrorth.val;
                if (intw1.val >= 0) {
                    if (intw1.val == 2)
                        intw1.val = 3;
                    Second.second(t1);
                    arpack_timing.tsaupd.val = t1.val - t0.val;
                }
            }
        }
    }

    public static floatW t0 = new floatW(0.0F);
    public static floatW t1 = new floatW(0.0F);
    public static float t2 = 0.0F;
    public static float t3 = 0.0F;
    public static float t4 = 0.0F;
    public static float t5 = 0.0F;
    public static int bounds = 0;
    public static int ierr = 0;
    public static int ih = 0;
    public static int iq = 0;
    public static int ishift = 0;
    public static int iupd = 0;
    public static int iw = 0;
    public static int ldh = 0;
    public static int ldq = 0;
    public static int msglvl = 0;
    public static intW mxiter = new intW(0);
    public static int mode = 0;
    public static int nb = 0;
    public static intW nev0 = new intW(0);
    public static int next = 0;
    public static intW np = new intW(0);
    public static int ritz = 0;
}

package org.netlib.lapack;

import org.netlib.util.Util;

// This program sets problem and machine dependent parameters
// useful for xHSEQR and related subroutines for eigenvalue
// problems. It is called whenever
// IPARMQ is called with 12 <= ISPEC <= 16
public final class Iparmq {

    public static int iparmq(int ispec, String name, String opts, int n, int ilo, int ihi, int lwork) {

        int nh = 0;
        int ns = 0;
        int iparmq = 0;
        if (ispec == 15 || ispec == 13 || ispec == 16) {
            nh = (ihi - ilo) + 1;
            ns = 2;
            if (nh >= 30) {
                ns = 4;
            }
            if (nh >= 60) {
                ns = 10;
            }
            if (nh >= 150) {
                ns = Math.max(10, nh / Util.nint((float) Math.log(nh) / (float) Math.log(2.0f)));
            }
            if (nh >= 590) {
                ns = 64;
            }
            if (nh >= 3000) {
                ns = 128;
            }
            if (nh >= 6000) {
                ns = 256;
            }
            ns = Math.max(2, ns - ns % 2);
        }
        if (ispec == 12) {
            iparmq = 75;
        } else if (ispec == 14) {
            iparmq = 14;
        } else if (ispec == 15) {
            iparmq = ns;
        } else if (ispec == 13) {
            if (nh <= 500) {
                iparmq = ns;
            } else {
                iparmq = (3 * ns) / 2;
            }
        } else if (ispec == 16) {
            iparmq = 0;
            if (ns >= 14) {
                iparmq = 1;
            }
            if (ns >= 14) {
                iparmq = 2;
            }
        } else {
            iparmq = -1;
        }
        return iparmq;
    }
}

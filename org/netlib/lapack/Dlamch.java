package org.netlib.lapack;

import org.netlib.blas.Lsame;

public final class Dlamch {

    public static double dlamch(String cmach) {

        if (Lsame.lsame(cmach, "E")) {
            return 1.1102230246251565E-16;
        } else if (Lsame.lsame(cmach, "S")) {
            return 2.2250738585072014E-308;
        } else if (Lsame.lsame(cmach, "B")) {
            return 2.0;
        } else if (Lsame.lsame(cmach, "P")) {
            return 2.220446049250313E-16;
        } else if (Lsame.lsame(cmach, "N")) {
            return 53.0;
        } else if (Lsame.lsame(cmach, "R")) {
            return 1.0;
        } else if (Lsame.lsame(cmach, "M")) {
            return -1021.0;
        } else if (Lsame.lsame(cmach, "U")) {
            return 2.2250738585072014E-308;
        } else if (Lsame.lsame(cmach, "L")) {
            return 1024.0;
        } else if (Lsame.lsame(cmach, "O")) {
            return 1.7976931348623157E308;
        }

        return 0.0;
    }
}

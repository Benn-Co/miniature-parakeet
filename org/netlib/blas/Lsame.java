package org.netlib.blas;

public final class Lsame {
    public static boolean lsame(String s, String s1) {
        return s1.substring(0, 1).equalsIgnoreCase(s.substring(0, 1));
    }
}

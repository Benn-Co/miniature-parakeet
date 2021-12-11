package org.netlib.lapack;

public final class Lsame {
    public static boolean lsame(String s, String s1) {
    	return org.netlib.blas.Lsame.lsame(s, s1);
    }
}

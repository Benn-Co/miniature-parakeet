package org.netlib.err;

public final class Xerbla {
	public static void xerbla(String s, int i) {
		String msg = " ** On entry to '" + s + "' parameter number '" + i
				+ "' had an illegal value";
		System.err.println(msg);
		throw new IllegalArgumentException(msg);
	}
}

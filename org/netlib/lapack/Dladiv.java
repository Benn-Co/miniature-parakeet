package org.netlib.lapack;

import org.netlib.util.doubleW;

public final class Dladiv {
	public static void dladiv(double d, double d1, double d2, double d3,
			doubleW doublew, doubleW doublew1) {
		if (Math.abs(d3) < Math.abs(d2)) {
			double d5 = d3 / d2;
			double d8 = d2 + d3 * d5;
			doublew.val = (d + d1 * d5) / d8;
			doublew1.val = (d1 - d * d5) / d8;
		} else {
			double d6 = d2 / d3;
			double d9 = d3 + d2 * d6;
			doublew.val = (d1 + d * d6) / d9;
			doublew1.val = (-d + d1 * d6) / d9;
		}
	}
}

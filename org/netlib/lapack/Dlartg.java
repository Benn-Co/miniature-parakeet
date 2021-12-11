package org.netlib.lapack;

import org.netlib.util.doubleW;

public final class Dlartg {
	public static void dlartg(double d, double d1, doubleW doublew,
			doubleW doublew1, doubleW doublew2) {
		double d2 = 0.0D;
		double d7 = 0.0D;
		double d8 = 0.0D;
		double d9 = 0.0D;
		d7 = Dlamch.dlamch("S");
		d2 = Dlamch.dlamch("E");
		d8 = Math.pow(Dlamch.dlamch("B"),
				(int) (Math.log(d7 / d2) / Math.log(Dlamch.dlamch("B")) / 2D));
		d9 = 1.0D / d8;
		if (d1 == 0.0D) {
			doublew.val = 1.0D;
			doublew1.val = 0.0D;
			doublew2.val = d;
		} else if (d == 0.0D) {
			doublew.val = 0.0D;
			doublew1.val = 1.0D;
			doublew2.val = d1;
		} else {
			double d4 = d;
			double d6 = d1;
			double d11 = Math.max(Math.abs(d4), Math.abs(d6));
			if (d11 >= d9) {
				int i = 0;
				do {
					i++;
					d4 *= d8;
					d6 *= d8;
					d11 = Math.max(Math.abs(d4), Math.abs(d6));
				} while (d11 >= d9);
				doublew2.val = Math.sqrt(Math.pow(d4, 2) + Math.pow(d6, 2));
				doublew.val = d4 / doublew2.val;
				doublew1.val = d6 / doublew2.val;
				for (int i1 = (i - 1) + 1; i1 > 0; i1--) {
					doublew2.val = doublew2.val * d9;
				}

			} else if (d11 <= d8) {
				int j = 0;
				double d12;
				do {
					j++;
					d4 *= d9;
					d6 *= d9;
					d12 = Math.max(Math.abs(d4), Math.abs(d6));
				} while (d12 <= d8);
				doublew2.val = Math.sqrt(Math.pow(d4, 2) + Math.pow(d6, 2));
				doublew.val = d4 / doublew2.val;
				doublew1.val = d6 / doublew2.val;
				for (int j1 = (j - 1) + 1; j1 > 0; j1--) {
					doublew2.val = doublew2.val * d8;
				}

			} else {
				doublew2.val = Math.sqrt(Math.pow(d4, 2) + Math.pow(d6, 2));
				doublew.val = d4 / doublew2.val;
				doublew1.val = d6 / doublew2.val;
			}
			if ((Math.abs(d) > Math.abs(d1)) && (doublew.val < 0.0D)) {
				doublew.val = -doublew.val;
				doublew1.val = -doublew1.val;
				doublew2.val = -doublew2.val;
			}
		}
	}
}

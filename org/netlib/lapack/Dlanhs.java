package org.netlib.lapack;

import org.netlib.blas.Lsame;
import org.netlib.util.doubleW;

public final class Dlanhs {
	public static double dlanhs(String s, int i, double ad[], int j, int k,
			double ad1[], int l) {
		doubleW doublew = new doubleW(0.0D);
		doubleW doublew1 = new doubleW(0.0D);
		double d = 0.0D;
		double d1 = 0.0D;
		if (i == 0)
			d = 0.0D;
		else if (Lsame.lsame(s, "M")) {
			d = 0.0D;
			int l1 = 1;
			for (int l2 = (i - 1) + 1; l2 > 0; l2--) {
				int i1 = 1;
				for (int j4 = (Math.min(i, l1 + 1) - 1) + 1; j4 > 0; j4--) {
					d = Math.max(d, Math.abs(ad[(i1 - 1) + (l1 - 1) * k + j]));
					i1++;
				}

				l1++;
			}

		} else if (Lsame.lsame(s, "O") || s.regionMatches(0, "1", 0, 1)) {
			d = 0.0D;
			int i2 = 1;
			for (int i3 = (i - 1) + 1; i3 > 0; i3--) {
				doublew1.val = 0.0D;
				int j1 = 1;
				for (int k4 = (Math.min(i, i2 + 1) - 1) + 1; k4 > 0; k4--) {
					doublew1.val = doublew1.val
							+ Math.abs(ad[(j1 - 1) + (i2 - 1) * k + j]);
					j1++;
				}

				d = Math.max(d, doublew1.val);
				i2++;
			}

		} else if (Lsame.lsame(s, "I")) {
			int k1 = 1;
			for (int j3 = (i - 1) + 1; j3 > 0; j3--) {
				ad1[(k1 - 1) + l] = 0.0D;
				k1++;
			}

			int j2 = 1;
			for (int k3 = (i - 1) + 1; k3 > 0; k3--) {
				k1 = 1;
				for (int l4 = (Math.min(i, j2 + 1) - 1) + 1; l4 > 0; l4--) {
					ad1[(k1 - 1) + l] = ad1[(k1 - 1) + l]
							+ Math.abs(ad[(k1 - 1) + (j2 - 1) * k + j]);
					k1++;
				}

				j2++;
			}

			d = 0.0D;
			k1 = 1;
			for (int l3 = (i - 1) + 1; l3 > 0; l3--) {
				d = Math.max(d, ad1[(k1 - 1) + l]);
				k1++;
			}

		} else if (Lsame.lsame(s, "F") || Lsame.lsame(s, "E")) {
			doublew.val = 0.0D;
			doublew1.val = 1.0D;
			int k2 = 1;
			for (int i4 = (i - 1) + 1; i4 > 0; i4--) {
				Dlassq.dlassq(Math.min(i, k2 + 1), ad, (1 - 1) + (k2 - 1) * k
						+ j, 1, doublew, doublew1);
				k2++;
			}

			d = doublew.val * Math.sqrt(doublew1.val);
		}
		d1 = d;
		return d1;
	}
}

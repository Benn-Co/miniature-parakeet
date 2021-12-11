package org.netlib.lapack;

import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlaln2 {
	public static void dlaln2(boolean flag, int i, int j, double d, double d1,
			double ad[], int k, int l, double d2, double d3, double ad1[],
			int i1, int j1, double d4, double d5, double ad2[], int k1, int l1,
			doubleW doublew, doubleW doublew1, intW intw) {
		double d13 = 0.0D;
		double d51 = 0.0D;
		double d52 = 0.0D;
		doubleW doublew2 = new doubleW(0.0D);
		doubleW doublew3 = new doubleW(0.0D);
		d52 = 2D * Dlamch.dlamch("Safe minimum");
		d13 = 1.0D / d52;
		d51 = Math.max(d, d52);
		intw.val = 0;
		doublew.val = 1.0D;
		if (i == 1) {
			if (j == 1) {
				double d44 = d1 * ad[(1 - 1) + (1 - 1) * l + k] - d4 * d2;
				double d33 = Math.abs(d44);
				if (d33 < d51) {
					d44 = d51;
					d33 = d51;
					intw.val = 1;
				}
				double d15 = Math.abs(ad1[(1 - 1) + (1 - 1) * j1 + i1]);
				if (((d33 < 1.0D) && (d15 > 1.0D)) && (d15 > d13 * d33))
					doublew.val = 1.0D / d15;
				ad2[(1 - 1) + (1 - 1) * l1 + k1] = (ad1[(1 - 1) + (1 - 1) * j1
						+ i1] * doublew.val)
						/ d44;
				doublew1.val = Math.abs(ad2[(1 - 1) + (1 - 1) * l1 + k1]);
			} else {
				double d45 = d1 * ad[(1 - 1) + (1 - 1) * l + k] - d4 * d2;
				double d42 = -(d5 * d2);
				double d34 = Math.abs(d45) + Math.abs(d42);
				if (d34 < d51) {
					d45 = d51;
					d42 = 0.0D;
					d34 = d51;
					intw.val = 1;
				}
				double d16 = Math.abs(ad1[(1 - 1) + (1 - 1) * j1 + i1])
						+ Math.abs(ad1[(1 - 1) + (2 - 1) * j1 + i1]);
				if (((d34 < 1.0D) && (d16 > 1.0D)) && (d16 > d13 * d34))
					doublew.val = 1.0D / d16;
				dladiv_adapter(doublew.val * ad1[(1 - 1) + (1 - 1) * j1 + i1],
						doublew.val * ad1[(1 - 1) + (2 - 1) * j1 + i1], d45,
						d42, ad2, (1 - 1) + (1 - 1) * l1 + k1, ad2, (1 - 1)
								+ (2 - 1) * l1 + k1);
				doublew1.val = Math.abs(ad2[(1 - 1) + (1 - 1) * l1 + k1])
						+ Math.abs(ad2[(1 - 1) + (2 - 1) * l1 + k1]);
			}
		} else {
			cr_crv[(1 - 1) + (1 - 1) * 2] = d1 * ad[(1 - 1) + (1 - 1) * l + k]
					- d4 * d2;
			cr_crv[(2 - 1) + (2 - 1) * 2] = d1 * ad[(2 - 1) + (2 - 1) * l + k]
					- d4 * d3;
			if (flag) {
				cr_crv[(1 - 1) + (2 - 1) * 2] = d1
						* ad[(2 - 1) + (1 - 1) * l + k];
				cr_crv[(2 - 1) + (1 - 1) * 2] = d1
						* ad[(1 - 1) + (2 - 1) * l + k];
			} else {
				cr_crv[(2 - 1) + (1 - 1) * 2] = d1
						* ad[(2 - 1) + (1 - 1) * l + k];
				cr_crv[(1 - 1) + (2 - 1) * 2] = d1
						* ad[(1 - 1) + (2 - 1) * l + k];
			}
			if (j == 1) {
				double d30 = 0.0D;
				int i2 = 0;
				int k2 = 1;
				for (int i3 = (4 - 1) + 1; i3 > 0; i3--) {
					if (Math.abs(cr_crv[k2 - 1]) > d30) {
						d30 = Math.abs(cr_crv[k2 - 1]);
						i2 = k2;
					}
					k2++;
				}

				if (d30 < d51) {
					double d17 = Math.max(
							Math.abs(ad1[(1 - 1) + (1 - 1) * j1 + i1]),
							Math.abs(ad1[(2 - 1) + (1 - 1) * j1 + i1]));
					if (((d51 < 1.0D) && (d17 > 1.0D)) && (d17 > d13 * d51))
						doublew.val = 1.0D / d17;
					double d54 = doublew.val / d51;
					ad2[(1 - 1) + (1 - 1) * l1 + k1] = d54
							* ad1[(1 - 1) + (1 - 1) * j1 + i1];
					ad2[(2 - 1) + (1 - 1) * l1 + k1] = d54
							* ad1[(2 - 1) + (1 - 1) * j1 + i1];
					doublew1.val = d54 * d17;
					intw.val = 1;
					return;
				}
				double d73 = cr_crv[i2 - 1];
				double d36 = cr_crv[ipivot[(2 - 1) + (i2 - 1) * 4] - 1];
				double d79 = cr_crv[ipivot[(3 - 1) + (i2 - 1) * 4] - 1];
				double d39 = cr_crv[ipivot[(4 - 1) + (i2 - 1) * 4] - 1];
				double d76 = 1.0D / d73;
				double d49 = d76 * d36;
				double d84 = d39 - d79 * d49;
				if (Math.abs(d84) < d51) {
					d84 = d51;
					intw.val = 1;
				}
				double d20;
				double d23;
				if (rswap[i2 - 1]) {
					d20 = ad1[(2 - 1) + (1 - 1) * j1 + i1];
					d23 = ad1[(1 - 1) + (1 - 1) * j1 + i1];
				} else {
					d20 = ad1[(1 - 1) + (1 - 1) * j1 + i1];
					d23 = ad1[(2 - 1) + (1 - 1) * j1 + i1];
				}
				d23 -= d49 * d20;
				double d7 = Math
						.max(Math.abs(d20 * (d84 * d76)), Math.abs(d23));
				if (((d7 > 1.0D) && (Math.abs(d84) < 1.0D))
						&& (d7 >= d13 * Math.abs(d84)))
					doublew.val = 1.0D / d7;
				doublew3.val = (d23 * doublew.val) / d84;
				double d89 = doublew.val * d20 * d76 - doublew3.val
						* (d76 * d79);
				if (zswap[i2 - 1]) {
					ad2[(1 - 1) + (1 - 1) * l1 + k1] = doublew3.val;
					ad2[(2 - 1) + (1 - 1) * l1 + k1] = d89;
				} else {
					ad2[(1 - 1) + (1 - 1) * l1 + k1] = d89;
					ad2[(2 - 1) + (1 - 1) * l1 + k1] = doublew3.val;
				}
				doublew1.val = Math.max(Math.abs(d89), Math.abs(doublew3.val));
				if (((doublew1.val > 1.0D) && (d30 > 1.0D))
						&& (doublew1.val > d13 / d30)) {
					double d55 = d30 / d13;
					ad2[(1 - 1) + (1 - 1) * l1 + k1] = d55
							* ad2[(1 - 1) + (1 - 1) * l1 + k1];
					ad2[(2 - 1) + (1 - 1) * l1 + k1] = d55
							* ad2[(2 - 1) + (1 - 1) * l1 + k1];
					doublew1.val = d55 * doublew1.val;
					doublew.val = d55 * doublew.val;
				}
			} else {
				ci_civ[(1 - 1) + (1 - 1) * 2] = -(d5 * d2);
				ci_civ[(2 - 1) + (1 - 1) * 2] = 0.0D;
				ci_civ[(1 - 1) + (2 - 1) * 2] = 0.0D;
				ci_civ[(2 - 1) + (2 - 1) * 2] = -(d5 * d3);
				double d31 = 0.0D;
				int j2 = 0;
				int l2 = 1;
				for (int j3 = (4 - 1) + 1; j3 > 0; j3--) {
					if (Math.abs(cr_crv[l2 - 1]) + Math.abs(ci_civ[l2 - 1]) > d31) {
						d31 = Math.abs(cr_crv[l2 - 1])
								+ Math.abs(ci_civ[l2 - 1]);
						j2 = l2;
					}
					l2++;
				}

				if (d31 < d51) {
					double d18 = Math
							.max(Math.abs(ad1[(1 - 1) + (1 - 1) * j1 + i1])
									+ Math.abs(ad1[(1 - 1) + (2 - 1) * j1 + i1]),
									Math.abs(ad1[(2 - 1) + (1 - 1) * j1 + i1])
											+ Math.abs(ad1[(2 - 1) + (2 - 1)
													* j1 + i1]));
					if (((d51 < 1.0D) && (d18 > 1.0D)) && (d18 > d13 * d51))
						doublew.val = 1.0D / d18;
					double d56 = doublew.val / d51;
					ad2[(1 - 1) + (1 - 1) * l1 + k1] = d56
							* ad1[(1 - 1) + (1 - 1) * j1 + i1];
					ad2[(2 - 1) + (1 - 1) * l1 + k1] = d56
							* ad1[(2 - 1) + (1 - 1) * j1 + i1];
					ad2[(1 - 1) + (2 - 1) * l1 + k1] = d56
							* ad1[(1 - 1) + (2 - 1) * j1 + i1];
					ad2[(2 - 1) + (2 - 1) * l1 + k1] = d56
							* ad1[(2 - 1) + (2 - 1) * j1 + i1];
					doublew1.val = d56 * d18;
					intw.val = 1;
					return;
				}
				double d74 = cr_crv[j2 - 1];
				double d63 = ci_civ[j2 - 1];
				double d37 = cr_crv[ipivot[(2 - 1) + (j2 - 1) * 4] - 1];
				double d26 = ci_civ[ipivot[(2 - 1) + (j2 - 1) * 4] - 1];
				double d80 = cr_crv[ipivot[(3 - 1) + (j2 - 1) * 4] - 1];
				double d67 = ci_civ[ipivot[(3 - 1) + (j2 - 1) * 4] - 1];
				double d40 = cr_crv[ipivot[(4 - 1) + (j2 - 1) * 4] - 1];
				double d28 = ci_civ[ipivot[(4 - 1) + (j2 - 1) * 4] - 1];
				double d47;
				double d50;
				double d65;
				double d69;
				double d71;
				double d77;
				double d82;
				double d85;
				if ((j2 == 1) || (j2 == 4)) {
					if (Math.abs(d74) > Math.abs(d63)) {
						double d57 = d63 / d74;
						d77 = 1.0D / (d74 * (1.0D + Math.pow(d57, 2)));
						d65 = -(d57 * d77);
					} else {
						double d58 = d74 / d63;
						d65 = -(1.0D / (d63 * (1.0D + Math.pow(d58, 2))));
						d77 = -(d58 * d65);
					}
					d50 = d37 * d77;
					d47 = d37 * d65;
					d82 = d80 * d77;
					d69 = d80 * d65;
					d85 = d40 - d80 * d50;
					d71 = d28 - d80 * d47;
				} else {
					d77 = 1.0D / d74;
					d65 = 0.0D;
					d50 = d37 * d77;
					d47 = d26 * d77;
					d82 = d80 * d77;
					d69 = d67 * d77;
					d85 = (d40 - d80 * d50) + d67 * d47;
					d71 = -(d80 * d47) - d67 * d50;
				}
				double d61 = Math.abs(d85) + Math.abs(d71);
				if (d61 < d51) {
					d85 = d51;
					d71 = 0.0D;
					intw.val = 1;
				}
				double d10;
				double d12;
				double d21;
				double d24;
				if (rswap[j2 - 1]) {
					d24 = ad1[(1 - 1) + (1 - 1) * j1 + i1];
					d21 = ad1[(2 - 1) + (1 - 1) * j1 + i1];
					d12 = ad1[(1 - 1) + (2 - 1) * j1 + i1];
					d10 = ad1[(2 - 1) + (2 - 1) * j1 + i1];
				} else {
					d21 = ad1[(1 - 1) + (1 - 1) * j1 + i1];
					d24 = ad1[(2 - 1) + (1 - 1) * j1 + i1];
					d10 = ad1[(1 - 1) + (2 - 1) * j1 + i1];
					d12 = ad1[(2 - 1) + (2 - 1) * j1 + i1];
				}
				d24 = (d24 - d50 * d21) + d47 * d10;
				d12 = d12 - d47 * d21 - d50 * d10;
				double d8 = Math.max((Math.abs(d21) + Math.abs(d10))
						* (d61 * (Math.abs(d77) + Math.abs(d65))),
						Math.abs(d24) + Math.abs(d12));
				if (((d8 > 1.0D) && (d61 < 1.0D)) && (d8 >= d13 * d61)) {
					doublew.val = 1.0D / d8;
					d21 = doublew.val * d21;
					d10 = doublew.val * d10;
					d24 = doublew.val * d24;
					d12 = doublew.val * d12;
				}
				Dladiv.dladiv(d24, d12, d85, d71, doublew3, doublew2);
				double d90 = (d77 * d21 - d65 * d10 - d82 * doublew3.val) + d69
						* doublew2.val;
				double d87 = (d65 * d21 + d77 * d10) - d69 * doublew3.val - d82
						* doublew2.val;
				if (zswap[j2 - 1]) {
					ad2[(1 - 1) + (1 - 1) * l1 + k1] = doublew3.val;
					ad2[(2 - 1) + (1 - 1) * l1 + k1] = d90;
					ad2[(1 - 1) + (2 - 1) * l1 + k1] = doublew2.val;
					ad2[(2 - 1) + (2 - 1) * l1 + k1] = d87;
				} else {
					ad2[(1 - 1) + (1 - 1) * l1 + k1] = d90;
					ad2[(2 - 1) + (1 - 1) * l1 + k1] = doublew3.val;
					ad2[(1 - 1) + (2 - 1) * l1 + k1] = d87;
					ad2[(2 - 1) + (2 - 1) * l1 + k1] = doublew2.val;
				}
				doublew1.val = Math.max(Math.abs(d90) + Math.abs(d87),
						Math.abs(doublew3.val) + Math.abs(doublew2.val));
				if (((doublew1.val > 1.0D) && (d31 > 1.0D))
						&& (doublew1.val > d13 / d31)) {
					double d59 = d31 / d13;
					ad2[(1 - 1) + (1 - 1) * l1 + k1] = d59
							* ad2[(1 - 1) + (1 - 1) * l1 + k1];
					ad2[(2 - 1) + (1 - 1) * l1 + k1] = d59
							* ad2[(2 - 1) + (1 - 1) * l1 + k1];
					ad2[(1 - 1) + (2 - 1) * l1 + k1] = d59
							* ad2[(1 - 1) + (2 - 1) * l1 + k1];
					ad2[(2 - 1) + (2 - 1) * l1 + k1] = d59
							* ad2[(2 - 1) + (2 - 1) * l1 + k1];
					doublew1.val = d59 * doublew1.val;
					doublew.val = d59 * doublew.val;
				}
			}
		}
	}

	private static void dladiv_adapter(double d, double d1, double d2,
			double d3, double ad[], int i, double ad1[], int j) {
		doubleW doublew = new doubleW(ad[i]);
		doubleW doublew1 = new doubleW(ad1[j]);
		Dladiv.dladiv(d, d1, d2, d3, doublew, doublew1);
		ad[i] = doublew.val;
		ad1[j] = doublew1.val;
	}

	public static boolean rswap[] = { false, true, false, true };
	public static boolean zswap[] = { false, false, true, true };
	public static int ipivot[] = { 1, 2, 3, 4, 2, 1, 4, 3, 3, 4, 1, 2, 4, 3, 2,
			1 };
	public static double ci_civ[] = new double[2 * 2];
	public static double cr_crv[] = new double[2 * 2];
}

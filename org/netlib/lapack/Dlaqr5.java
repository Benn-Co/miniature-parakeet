package org.netlib.lapack;

import org.netlib.blas.Dgemm;
import org.netlib.blas.Dtrmm;
import org.netlib.util.doubleW;

public final class Dlaqr5 {
	public static void dlaqr5(boolean flag, boolean flag1, int i, int j, int k,
			int l, int i1, double ad[], int j1, double ad1[], int k1,
			double ad2[], int l1, int i2, int j2, int k2, double ad3[], int l2,
			int i3, double ad4[], int j3, int k3, double ad5[], int l3, int i4,
			int j4, double ad6[], int k4, int l4, int i5, double ad7[], int j5,
			int k5) {
		doubleW doublew = new doubleW(0.0D);
		doubleW doublew1 = new doubleW(0.0D);
		doubleW doublew2 = new doubleW(0.0D);
		doubleW doublew3 = new doubleW(0.0D);
		double d22 = 0.0D;
		double d29 = 0.0D;
		int l5 = 0;
		int k6 = 0;
		int k14 = 0;
		int l17 = 0;
		int j18 = 0;
		boolean flag26 = false;
		boolean flag27 = false;
		double ad8[] = new double[3];
		if (i1 < 2)
			return;
		if (k >= l)
			return;
		l5 = 1;
		for (int l18 = ((i1 - 2 - 1) + 2) / 2; l18 > 0; l18--) {
			if (ad1[(l5 - 1) + k1] != -ad1[((l5 + 1) - 1) + k1]) {
				double d24 = ad[(l5 - 1) + j1];
				ad[(l5 - 1) + j1] = ad[((l5 + 1) - 1) + j1];
				ad[((l5 + 1) - 1) + j1] = ad[((l5 + 2) - 1) + j1];
				ad[((l5 + 2) - 1) + j1] = d24;
				d24 = ad1[(l5 - 1) + k1];
				ad1[(l5 - 1) + k1] = ad1[((l5 + 1) - 1) + k1];
				ad1[((l5 + 1) - 1) + k1] = ad1[((l5 + 2) - 1) + k1];
				ad1[((l5 + 2) - 1) + k1] = d24;
			}
			l5 += 2;
		}

		j18 = i1 - i1 % 2;
		doublew3.val = Dlamch.dlamch("SAFE MINIMUM");
		doublew2.val = 1.0D / doublew3.val;
		Dlabad.dlabad(doublew3, doublew2);
		d29 = Dlamch.dlamch("PRECISION");
		d22 = doublew3.val * (j / d29);
		flag26 = (i == 1) || (i == 2);
		flag27 = (j18 > 2) && (i == 2);
		if (k + 2 <= l)
			ad2[((k + 2) - 1) + (k - 1) * i2 + l1] = 0.0D;
		l17 = j18 / 2;
		k14 = 6 * l17 - 3;
		k6 = (3 * (1 - l17) + k) - 1;
		for (int i19 = ((l - 2 - ((3 * (1 - l17) + k) - 1)) + (3 * l17 - 2))
				/ (3 * l17 - 2); i19 > 0; i19--) {
			int i18 = k6 + k14;
			if (flag26)
				Dlaset.dlaset("ALL", k14, k14, 0.0D, 1.0D, ad5, l3, i4);
			int k15 = k6;
			for (int j19 = (Math.min((k6 + 3 * l17) - 3, l - 2) - k6) + 1; j19 > 0; j19--) {
				int k17 = Math.max(1, ((k - 1 - k15) + 2) / 3 + 1);
				int k16 = Math.min(l17, (l - k15) / 3);
				int j16 = k16 + 1;
				boolean flag29 = (k16 < l17) && (k15 + 3 * (j16 - 1) == l - 2);
				int i16 = k17;
				for (int i21 = (k16 - k17) + 1; i21 > 0; i21--) {
					int j13 = k15 + 3 * (i16 - 1);
					if (j13 == k - 1) {
						Dlaqr1.dlaqr1(3, ad2, (k - 1) + (k - 1) * i2 + l1, i2,
								ad[(2 * i16 - 1 - 1) + j1],
								ad1[(2 * i16 - 1 - 1) + k1], ad[(2 * i16 - 1)
										+ j1], ad1[(2 * i16 - 1) + k1], ad4,
								(1 - 1) + (i16 - 1) * k3 + j3);
						doublew.val = ad4[(1 - 1) + (i16 - 1) * k3 + j3];
						dlarfg_adapter(3, doublew, ad4, (2 - 1) + (i16 - 1)
								* k3 + j3, 1, ad4, (1 - 1) + (i16 - 1) * k3
								+ j3);
					} else {
						doublew1.val = ad2[((j13 + 1) - 1) + (j13 - 1) * i2
								+ l1];
						ad4[(2 - 1) + (i16 - 1) * k3 + j3] = ad2[((j13 + 2) - 1)
								+ (j13 - 1) * i2 + l1];
						ad4[(3 - 1) + (i16 - 1) * k3 + j3] = ad2[((j13 + 3) - 1)
								+ (j13 - 1) * i2 + l1];
						dlarfg_adapter(3, doublew1, ad4, (2 - 1) + (i16 - 1)
								* k3 + j3, 1, ad4, (1 - 1) + (i16 - 1) * k3
								+ j3);
						if ((ad4[(1 - 1) + (i16 - 1) * k3 + j3] != 0.0D)
								&& ((ad4[(3 - 1) + (i16 - 1) * k3 + j3] != 0.0D) || ((ad2[((j13 + 3) - 1)
										+ ((j13 + 1) - 1) * i2 + l1] == 0.0D) && (ad2[((j13 + 3) - 1)
										+ ((j13 + 2) - 1) * i2 + l1] == 0.0D)))) {
							ad2[((j13 + 1) - 1) + (j13 - 1) * i2 + l1] = doublew1.val;
							ad2[((j13 + 2) - 1) + (j13 - 1) * i2 + l1] = 0.0D;
							ad2[((j13 + 3) - 1) + (j13 - 1) * i2 + l1] = 0.0D;
						} else {
							Dlaqr1.dlaqr1(3, ad2, ((j13 + 1) - 1)
									+ ((j13 + 1) - 1) * i2 + l1, i2,
									ad[(2 * i16 - 1 - 1) + j1],
									ad1[(2 * i16 - 1 - 1) + k1],
									ad[(2 * i16 - 1) + j1], ad1[(2 * i16 - 1)
											+ k1], ad8, 0);
							double d20 = Math.abs(ad8[1 - 1])
									+ Math.abs(ad8[2 - 1])
									+ Math.abs(ad8[3 - 1]);
							if (d20 != 0.0D) {
								ad8[1 - 1] = ad8[1 - 1] / d20;
								ad8[2 - 1] = ad8[2 - 1] / d20;
								ad8[3 - 1] = ad8[3 - 1] / d20;
							}
							if (Math.abs(ad2[((j13 + 1) - 1) + (j13 - 1) * i2
									+ l1])
									* (Math.abs(ad8[2 - 1]) + Math
											.abs(ad8[3 - 1])) > d29
									* Math.abs(ad8[1 - 1])
									* (Math.abs(ad2[(j13 - 1) + (j13 - 1) * i2
											+ l1])
											+ Math.abs(ad2[((j13 + 1) - 1)
													+ ((j13 + 1) - 1) * i2 + l1]) + Math
												.abs(ad2[((j13 + 2) - 1)
														+ ((j13 + 2) - 1) * i2
														+ l1]))) {
								if ((ad4[(2 - 1) + (i16 - 1) * k3 + j3] == 0.0D)
										&& (ad4[(3 - 1) + (i16 - 1) * k3 + j3] == 0.0D)) {
									ad4[(1 - 1) + (i16 - 1) * k3 + j3] = 0.0D;
								} else {
									ad2[((j13 + 1) - 1) + (j13 - 1) * i2 + l1] = doublew1.val;
									ad2[((j13 + 2) - 1) + (j13 - 1) * i2 + l1] = 0.0D;
									ad2[((j13 + 3) - 1) + (j13 - 1) * i2 + l1] = 0.0D;
								}
							} else {
								doublew.val = ad8[1 - 1];
								dlarfg_adapter(3, doublew, ad8, 2 - 1, 1, ad8,
										1 - 1);
								double d9 = ad2[((j13 + 1) - 1) + (j13 - 1)
										* i2 + l1]
										+ ad2[((j13 + 2) - 1) + (j13 - 1) * i2
												+ l1]
										* ad8[2 - 1]
										+ ad2[((j13 + 3) - 1) + (j13 - 1) * i2
												+ l1] * ad8[3 - 1];
								ad2[((j13 + 1) - 1) + (j13 - 1) * i2 + l1] = ad2[((j13 + 1) - 1)
										+ (j13 - 1) * i2 + l1]
										- ad8[1 - 1] * d9;
								ad2[((j13 + 2) - 1) + (j13 - 1) * i2 + l1] = 0.0D;
								ad2[((j13 + 3) - 1) + (j13 - 1) * i2 + l1] = 0.0D;
								ad4[(1 - 1) + (i16 - 1) * k3 + j3] = ad8[1 - 1];
								ad4[(2 - 1) + (i16 - 1) * k3 + j3] = ad8[2 - 1];
								ad4[(3 - 1) + (i16 - 1) * k3 + j3] = ad8[3 - 1];
							}
						}
					}
					i16++;
				}

				int k13 = k15 + 3 * (j16 - 1);
				if (flag29) {
					if (k13 == k - 1) {
						Dlaqr1.dlaqr1(2, ad2, ((k13 + 1) - 1) + ((k13 + 1) - 1)
								* i2 + l1, i2, ad[(2 * j16 - 1 - 1) + j1],
								ad1[(2 * j16 - 1 - 1) + k1], ad[(2 * j16 - 1)
										+ j1], ad1[(2 * j16 - 1) + k1], ad4,
								(1 - 1) + (j16 - 1) * k3 + j3);
						doublew1.val = ad4[(1 - 1) + (j16 - 1) * k3 + j3];
						dlarfg_adapter(2, doublew1, ad4, (2 - 1) + (j16 - 1)
								* k3 + j3, 1, ad4, (1 - 1) + (j16 - 1) * k3
								+ j3);
					} else {
						doublew1.val = ad2[((k13 + 1) - 1) + (k13 - 1) * i2
								+ l1];
						ad4[(2 - 1) + (j16 - 1) * k3 + j3] = ad2[((k13 + 2) - 1)
								+ (k13 - 1) * i2 + l1];
						dlarfg_adapter(2, doublew1, ad4, (2 - 1) + (j16 - 1)
								* k3 + j3, 1, ad4, (1 - 1) + (j16 - 1) * k3
								+ j3);
						ad2[((k13 + 1) - 1) + (k13 - 1) * i2 + l1] = doublew1.val;
						ad2[((k13 + 2) - 1) + (k13 - 1) * i2 + l1] = 0.0D;
					}
				} else {
					ad4[(1 - 1) + (j16 - 1) * k3 + j3] = 0.0D;
				}
				int j9;
				if (flag26)
					j9 = Math.min(i18, l);
				else if (flag)
					j9 = j;
				else
					j9 = l;
				int l6 = Math.max(k, k15);
				for (int j21 = (j9 - Math.max(k, k15)) + 1; j21 > 0; j21--) {
					int l16 = Math.min(k16, ((l6 - k15) + 2) / 3);
					i16 = k17;
					for (int j23 = (l16 - k17) + 1; j23 > 0; j23--) {
						k13 = k15 + 3 * (i16 - 1);
						double d10 = ad4[(1 - 1) + (i16 - 1) * k3 + j3]
								* (ad2[((k13 + 1) - 1) + (l6 - 1) * i2 + l1]
										+ ad4[(2 - 1) + (i16 - 1) * k3 + j3]
										* ad2[((k13 + 2) - 1) + (l6 - 1) * i2
												+ l1] + ad4[(3 - 1) + (i16 - 1)
										* k3 + j3]
										* ad2[((k13 + 3) - 1) + (l6 - 1) * i2
												+ l1]);
						ad2[((k13 + 1) - 1) + (l6 - 1) * i2 + l1] = ad2[((k13 + 1) - 1)
								+ (l6 - 1) * i2 + l1]
								- d10;
						ad2[((k13 + 2) - 1) + (l6 - 1) * i2 + l1] = ad2[((k13 + 2) - 1)
								+ (l6 - 1) * i2 + l1]
								- d10 * ad4[(2 - 1) + (i16 - 1) * k3 + j3];
						ad2[((k13 + 3) - 1) + (l6 - 1) * i2 + l1] = ad2[((k13 + 3) - 1)
								+ (l6 - 1) * i2 + l1]
								- d10 * ad4[(3 - 1) + (i16 - 1) * k3 + j3];
						i16++;
					}

					l6++;
				}

				if (flag29) {
					k13 = k15 + 3 * (j16 - 1);
					int i7 = Math.max(k13 + 1, k);
					for (int k21 = (j9 - Math.max(k13 + 1, k)) + 1; k21 > 0; k21--) {
						double d11 = ad4[(1 - 1) + (j16 - 1) * k3 + j3]
								* (ad2[((k13 + 1) - 1) + (i7 - 1) * i2 + l1] + ad4[(2 - 1)
										+ (j16 - 1) * k3 + j3]
										* ad2[((k13 + 2) - 1) + (i7 - 1) * i2
												+ l1]);
						ad2[((k13 + 1) - 1) + (i7 - 1) * i2 + l1] = ad2[((k13 + 1) - 1)
								+ (i7 - 1) * i2 + l1]
								- d11;
						ad2[((k13 + 2) - 1) + (i7 - 1) * i2 + l1] = ad2[((k13 + 2) - 1)
								+ (i7 - 1) * i2 + l1]
								- d11 * ad4[(2 - 1) + (j16 - 1) * k3 + j3];
						i7++;
					}

				}
				int l12;
				if (flag26)
					l12 = Math.max(k, k6);
				else if (flag)
					l12 = 1;
				else
					l12 = k;
				i16 = k17;
				for (int l21 = (k16 - k17) + 1; l21 > 0; l21--) {
					if (ad4[(1 - 1) + (i16 - 1) * k3 + j3] != 0.0D) {
						k13 = k15 + 3 * (i16 - 1);
						int j7 = l12;
						for (int k23 = (Math.min(l, k13 + 3) - l12) + 1; k23 > 0; k23--) {
							double d12 = ad4[(1 - 1) + (i16 - 1) * k3 + j3]
									* (ad2[(j7 - 1) + ((k13 + 1) - 1) * i2 + l1]
											+ ad4[(2 - 1) + (i16 - 1) * k3 + j3]
											* ad2[(j7 - 1) + ((k13 + 2) - 1)
													* i2 + l1] + ad4[(3 - 1)
											+ (i16 - 1) * k3 + j3]
											* ad2[(j7 - 1) + ((k13 + 3) - 1)
													* i2 + l1]);
							ad2[(j7 - 1) + ((k13 + 1) - 1) * i2 + l1] = ad2[(j7 - 1)
									+ ((k13 + 1) - 1) * i2 + l1]
									- d12;
							ad2[(j7 - 1) + ((k13 + 2) - 1) * i2 + l1] = ad2[(j7 - 1)
									+ ((k13 + 2) - 1) * i2 + l1]
									- d12 * ad4[(2 - 1) + (i16 - 1) * k3 + j3];
							ad2[(j7 - 1) + ((k13 + 3) - 1) * i2 + l1] = ad2[(j7 - 1)
									+ ((k13 + 3) - 1) * i2 + l1]
									- d12 * ad4[(3 - 1) + (i16 - 1) * k3 + j3];
							j7++;
						}

						if (flag26) {
							int l14 = k13 - k6;
							int k7 = Math.max(1, k - k6);
							for (int l23 = (k14 - Math.max(1, k - k6)) + 1; l23 > 0; l23--) {
								double d13 = ad4[(1 - 1) + (i16 - 1) * k3 + j3]
										* (ad5[(k7 - 1) + ((l14 + 1) - 1) * i4
												+ l3]
												+ ad4[(2 - 1) + (i16 - 1) * k3
														+ j3]
												* ad5[(k7 - 1)
														+ ((l14 + 2) - 1) * i4
														+ l3] + ad4[(3 - 1)
												+ (i16 - 1) * k3 + j3]
												* ad5[(k7 - 1)
														+ ((l14 + 3) - 1) * i4
														+ l3]);
								ad5[(k7 - 1) + ((l14 + 1) - 1) * i4 + l3] = ad5[(k7 - 1)
										+ ((l14 + 1) - 1) * i4 + l3]
										- d13;
								ad5[(k7 - 1) + ((l14 + 2) - 1) * i4 + l3] = ad5[(k7 - 1)
										+ ((l14 + 2) - 1) * i4 + l3]
										- d13
										* ad4[(2 - 1) + (i16 - 1) * k3 + j3];
								ad5[(k7 - 1) + ((l14 + 3) - 1) * i4 + l3] = ad5[(k7 - 1)
										+ ((l14 + 3) - 1) * i4 + l3]
										- d13
										* ad4[(3 - 1) + (i16 - 1) * k3 + j3];
								k7++;
							}

						} else if (flag1) {
							int l7 = j2;
							for (int i24 = (k2 - j2) + 1; i24 > 0; i24--) {
								double d14 = ad4[(1 - 1) + (i16 - 1) * k3 + j3]
										* (ad3[(l7 - 1) + ((k13 + 1) - 1) * i3
												+ l2]
												+ ad4[(2 - 1) + (i16 - 1) * k3
														+ j3]
												* ad3[(l7 - 1)
														+ ((k13 + 2) - 1) * i3
														+ l2] + ad4[(3 - 1)
												+ (i16 - 1) * k3 + j3]
												* ad3[(l7 - 1)
														+ ((k13 + 3) - 1) * i3
														+ l2]);
								ad3[(l7 - 1) + ((k13 + 1) - 1) * i3 + l2] = ad3[(l7 - 1)
										+ ((k13 + 1) - 1) * i3 + l2]
										- d14;
								ad3[(l7 - 1) + ((k13 + 2) - 1) * i3 + l2] = ad3[(l7 - 1)
										+ ((k13 + 2) - 1) * i3 + l2]
										- d14
										* ad4[(2 - 1) + (i16 - 1) * k3 + j3];
								ad3[(l7 - 1) + ((k13 + 3) - 1) * i3 + l2] = ad3[(l7 - 1)
										+ ((k13 + 3) - 1) * i3 + l2]
										- d14
										* ad4[(3 - 1) + (i16 - 1) * k3 + j3];
								l7++;
							}

						}
					}
					i16++;
				}

				k13 = k15 + 3 * (j16 - 1);
				if (flag29 && (ad4[(1 - 1) + (j16 - 1) * k3 + j3] != 0.0D)) {
					int i8 = l12;
					for (int i22 = (Math.min(l, k13 + 3) - l12) + 1; i22 > 0; i22--) {
						double d15 = ad4[(1 - 1) + (j16 - 1) * k3 + j3]
								* (ad2[(i8 - 1) + ((k13 + 1) - 1) * i2 + l1] + ad4[(2 - 1)
										+ (j16 - 1) * k3 + j3]
										* ad2[(i8 - 1) + ((k13 + 2) - 1) * i2
												+ l1]);
						ad2[(i8 - 1) + ((k13 + 1) - 1) * i2 + l1] = ad2[(i8 - 1)
								+ ((k13 + 1) - 1) * i2 + l1]
								- d15;
						ad2[(i8 - 1) + ((k13 + 2) - 1) * i2 + l1] = ad2[(i8 - 1)
								+ ((k13 + 2) - 1) * i2 + l1]
								- d15 * ad4[(2 - 1) + (j16 - 1) * k3 + j3];
						i8++;
					}

					if (flag26) {
						int i15 = k13 - k6;
						int j8 = Math.max(1, k - k6);
						for (int j22 = (k14 - Math.max(1, k - k6)) + 1; j22 > 0; j22--) {
							double d16 = ad4[(1 - 1) + (j16 - 1) * k3 + j3]
									* (ad5[(j8 - 1) + ((i15 + 1) - 1) * i4 + l3] + ad4[(2 - 1)
											+ (j16 - 1) * k3 + j3]
											* ad5[(j8 - 1) + ((i15 + 2) - 1)
													* i4 + l3]);
							ad5[(j8 - 1) + ((i15 + 1) - 1) * i4 + l3] = ad5[(j8 - 1)
									+ ((i15 + 1) - 1) * i4 + l3]
									- d16;
							ad5[(j8 - 1) + ((i15 + 2) - 1) * i4 + l3] = ad5[(j8 - 1)
									+ ((i15 + 2) - 1) * i4 + l3]
									- d16 * ad4[(2 - 1) + (j16 - 1) * k3 + j3];
							j8++;
						}

					} else if (flag1) {
						int k8 = j2;
						for (int k22 = (k2 - j2) + 1; k22 > 0; k22--) {
							double d17 = ad4[(1 - 1) + (j16 - 1) * k3 + j3]
									* (ad3[(k8 - 1) + ((k13 + 1) - 1) * i3 + l2] + ad4[(2 - 1)
											+ (j16 - 1) * k3 + j3]
											* ad3[(k8 - 1) + ((k13 + 2) - 1)
													* i3 + l2]);
							ad3[(k8 - 1) + ((k13 + 1) - 1) * i3 + l2] = ad3[(k8 - 1)
									+ ((k13 + 1) - 1) * i3 + l2]
									- d17;
							ad3[(k8 - 1) + ((k13 + 2) - 1) * i3 + l2] = ad3[(k8 - 1)
									+ ((k13 + 2) - 1) * i3 + l2]
									- d17 * ad4[(2 - 1) + (j16 - 1) * k3 + j3];
							k8++;
						}

					}
				}
				int j17 = k17;
				if (k15 + 3 * (j17 - 1) < k)
					j17++;
				int i17 = k16;
				if (flag29)
					i17++;
				if (k15 == l - 2)
					i17++;
				i16 = j17;
				for (int l22 = (i17 - j17) + 1; l22 > 0; l22--) {
					int l13 = Math.min(l - 1, k15 + 3 * (i16 - 1));
					if (ad2[((l13 + 1) - 1) + (l13 - 1) * i2 + l1] != 0.0D) {
						double d26 = Math.abs(ad2[(l13 - 1) + (l13 - 1) * i2
								+ l1])
								+ Math.abs(ad2[((l13 + 1) - 1)
										+ ((l13 + 1) - 1) * i2 + l1]);
						if (d26 == 0.0D) {
							if (l13 >= k + 1)
								d26 += Math.abs(ad2[(l13 - 1) + (l13 - 1 - 1)
										* i2 + l1]);
							if (l13 >= k + 2)
								d26 += Math.abs(ad2[(l13 - 1) + (l13 - 2 - 1)
										* i2 + l1]);
							if (l13 >= k + 3)
								d26 += Math.abs(ad2[(l13 - 1) + (l13 - 3 - 1)
										* i2 + l1]);
							if (l13 <= l - 2)
								d26 += Math.abs(ad2[((l13 + 2) - 1)
										+ ((l13 + 1) - 1) * i2 + l1]);
							if (l13 <= l - 3)
								d26 += Math.abs(ad2[((l13 + 3) - 1)
										+ ((l13 + 1) - 1) * i2 + l1]);
							if (l13 <= l - 4)
								d26 += Math.abs(ad2[((l13 + 4) - 1)
										+ ((l13 + 1) - 1) * i2 + l1]);
						}
						if (Math.abs(ad2[((l13 + 1) - 1) + (l13 - 1) * i2 + l1]) <= Math
								.max(d22, d29 * d26)) {
							double d3 = Math.max(
									Math.abs(ad2[((l13 + 1) - 1) + (l13 - 1)
											* i2 + l1]),
									Math.abs(ad2[(l13 - 1) + ((l13 + 1) - 1)
											* i2 + l1]));
							double d5 = Math.min(
									Math.abs(ad2[((l13 + 1) - 1) + (l13 - 1)
											* i2 + l1]),
									Math.abs(ad2[(l13 - 1) + ((l13 + 1) - 1)
											* i2 + l1]));
							double d1 = Math
									.max(Math.abs(ad2[((l13 + 1) - 1)
											+ ((l13 + 1) - 1) * i2 + l1]),
											Math.abs(ad2[(l13 - 1) + (l13 - 1)
													* i2 + l1]
													- ad2[((l13 + 1) - 1)
															+ ((l13 + 1) - 1)
															* i2 + l1]));
							double d7 = Math
									.min(Math.abs(ad2[((l13 + 1) - 1)
											+ ((l13 + 1) - 1) * i2 + l1]),
											Math.abs(ad2[(l13 - 1) + (l13 - 1)
													* i2 + l1]
													- ad2[((l13 + 1) - 1)
															+ ((l13 + 1) - 1)
															* i2 + l1]));
							double d21 = d1 + d3;
							double d28 = d7 * (d1 / d21);
							if ((d28 == 0.0D)
									|| (d5 * (d3 / d21) <= Math.max(d22, d29
											* d28)))
								ad2[((l13 + 1) - 1) + (l13 - 1) * i2 + l1] = 0.0D;
						}
					}
					i16++;
				}

				i17 = Math.min(l17, (l - k15 - 1) / 3);
				i16 = k17;
				for (int i23 = (i17 - k17) + 1; i23 > 0; i23--) {
					int i14 = k15 + 3 * (i16 - 1);
					double d18 = ad4[(1 - 1) + (i16 - 1) * k3 + j3]
							* ad4[(3 - 1) + (i16 - 1) * k3 + j3]
							* ad2[((i14 + 4) - 1) + ((i14 + 3) - 1) * i2 + l1];
					ad2[((i14 + 4) - 1) + ((i14 + 1) - 1) * i2 + l1] = -d18;
					ad2[((i14 + 4) - 1) + ((i14 + 2) - 1) * i2 + l1] = -(d18 * ad4[(2 - 1)
							+ (i16 - 1) * k3 + j3]);
					ad2[((i14 + 4) - 1) + ((i14 + 3) - 1) * i2 + l1] = ad2[((i14 + 4) - 1)
							+ ((i14 + 3) - 1) * i2 + l1]
							- d18 * ad4[(3 - 1) + (i16 - 1) * k3 + j3];
					i16++;
				}

				k15++;
			}

			if (flag26) {
				int k9;
				int i13;
				if (flag) {
					i13 = 1;
					k9 = j;
				} else {
					i13 = k;
					k9 = l;
				}
				if (((flag27 ^ true || (k6 < k)) || (i18 > l)) || (j18 <= 2)) {
					int j14 = Math.max(1, k - k6);
					int k18 = (k14 - Math.max(0, i18 - l) - j14) + 1;
					int l9 = Math.min(i18, l) + 1;
					for (int k19 = ((k9 - (Math.min(i18, l) + 1)) + i5) / i5; k19 > 0; k19--) {
						int j10 = Math.min(i5, (k9 - l9) + 1);
						Dgemm.dgemm("C", "N", k18, j10, k18, 1.0D, ad5,
								(j14 - 1) + (j14 - 1) * i4 + l3, i4, ad2,
								((k6 + j14) - 1) + (l9 - 1) * i2 + l1, i2,
								0.0D, ad7, j5, k5);
						Dlacpy.dlacpy("ALL", k18, j10, ad7, j5, k5, ad2,
								((k6 + j14) - 1) + (l9 - 1) * i2 + l1, i2);
						l9 += i5;
					}

					int l11 = i13;
					for (int l19 = ((Math.max(k, k6) - 1 - i13) + j4) / j4; l19 > 0; l19--) {
						int k10 = Math.min(j4, Math.max(k, k6) - l11);
						Dgemm.dgemm("N", "N", k10, k18, k18, 1.0D, ad2,
								(l11 - 1) + ((k6 + j14) - 1) * i2 + l1, i2,
								ad5, (j14 - 1) + (j14 - 1) * i4 + l3, i4, 0.0D,
								ad6, k4, l4);
						Dlacpy.dlacpy("ALL", k10, k18, ad6, k4, l4, ad2,
								(l11 - 1) + ((k6 + j14) - 1) * i2 + l1, i2);
						l11 += j4;
					}

					if (flag1) {
						int i12 = j2;
						for (int i20 = ((k2 - j2) + j4) / j4; i20 > 0; i20--) {
							int l10 = Math.min(j4, (k2 - i12) + 1);
							Dgemm.dgemm("N", "N", l10, k18, k18, 1.0D, ad3,
									(i12 - 1) + ((k6 + j14) - 1) * i3 + l2, i3,
									ad5, (j14 - 1) + (j14 - 1) * i4 + l3, i4,
									0.0D, ad6, k4, l4);
							Dlacpy.dlacpy("ALL", l10, k18, ad6, k4, l4, ad3,
									(i12 - 1) + ((k6 + j14) - 1) * i3 + l2, i3);
							i12 += j4;
						}

					}
				} else {
					int i6 = (k14 + 1) / 2;
					int j6 = k14;
					int l8 = j6 - i6;
					int i9 = k14;
					int l15 = i9 - l8 - (j18 + 1);
					int j15 = j18 + 1;
					int i10 = Math.min(i18, l) + 1;
					for (int j20 = ((k9 - (Math.min(i18, l) + 1)) + i5) / i5; j20 > 0; j20--) {
						int i11 = Math.min(i5, (k9 - i10) + 1);
						Dlacpy.dlacpy("ALL", j15, i11, ad2, ((k6 + 1 + l8) - 1)
								+ (i10 - 1) * i2 + l1, i2, ad7, ((l15 + 1) - 1)
								+ (1 - 1) * k5 + j5, k5);
						Dlaset.dlaset("ALL", l15, i11, 0.0D, 0.0D, ad7, j5, k5);
						Dtrmm.dtrmm("L", "U", "C", "N", j15, i11, 1.0D, ad5,
								((l8 + 1) - 1) + ((1 + l15) - 1) * i4 + l3, i4,
								ad7, ((l15 + 1) - 1) + (1 - 1) * k5 + j5, k5);
						Dgemm.dgemm("C", "N", i6, i11, l8, 1.0D, ad5, l3, i4,
								ad2, ((k6 + 1) - 1) + (i10 - 1) * i2 + l1, i2,
								1.0D, ad7, j5, k5);
						Dlacpy.dlacpy("ALL", l8, i11, ad2, ((k6 + 1) - 1)
								+ (i10 - 1) * i2 + l1, i2, ad7, ((i6 + 1) - 1)
								+ (1 - 1) * k5 + j5, k5);
						Dtrmm.dtrmm("L", "L", "C", "N", l8, i11, 1.0D, ad5,
								(1 - 1) + ((i6 + 1) - 1) * i4 + l3, i4, ad7,
								((i6 + 1) - 1) + (1 - 1) * k5 + j5, k5);
						Dgemm.dgemm("C", "N", j6 - i6, i11, i9 - l8, 1.0D, ad5,
								((l8 + 1) - 1) + ((i6 + 1) - 1) * i4 + l3, i4,
								ad2, ((k6 + 1 + l8) - 1) + (i10 - 1) * i2 + l1,
								i2, 1.0D, ad7, ((i6 + 1) - 1) + (1 - 1) * k5
										+ j5, k5);
						Dlacpy.dlacpy("ALL", k14, i11, ad7, j5, k5, ad2,
								((k6 + 1) - 1) + (i10 - 1) * i2 + l1, i2);
						i10 += i5;
					}

					int j12 = i13;
					for (int k20 = ((Math.max(k6, k) - 1 - i13) + j4) / j4; k20 > 0; k20--) {
						int j11 = Math.min(j4, Math.max(k6, k) - j12);
						Dlacpy.dlacpy("ALL", j11, j15, ad2, (j12 - 1)
								+ ((k6 + 1 + l8) - 1) * i2 + l1, i2, ad6,
								(1 - 1) + ((1 + l15) - 1) * l4 + k4, l4);
						Dlaset.dlaset("ALL", j11, l15, 0.0D, 0.0D, ad6, k4, l4);
						Dtrmm.dtrmm("R", "U", "N", "N", j11, j15, 1.0D, ad5,
								((l8 + 1) - 1) + ((1 + l15) - 1) * i4 + l3, i4,
								ad6, (1 - 1) + ((1 + l15) - 1) * l4 + k4, l4);
						Dgemm.dgemm("N", "N", j11, i6, l8, 1.0D, ad2, (j12 - 1)
								+ ((k6 + 1) - 1) * i2 + l1, i2, ad5, l3, i4,
								1.0D, ad6, k4, l4);
						Dlacpy.dlacpy("ALL", j11, l8, ad2, (j12 - 1)
								+ ((k6 + 1) - 1) * i2 + l1, i2, ad6, (1 - 1)
								+ ((1 + i6) - 1) * l4 + k4, l4);
						Dtrmm.dtrmm("R", "L", "N", "N", j11, j6 - i6, 1.0D,
								ad5, (1 - 1) + ((i6 + 1) - 1) * i4 + l3, i4,
								ad6, (1 - 1) + ((1 + i6) - 1) * l4 + k4, l4);
						Dgemm.dgemm("N", "N", j11, j6 - i6, i9 - l8, 1.0D, ad2,
								(j12 - 1) + ((k6 + 1 + l8) - 1) * i2 + l1, i2,
								ad5, ((l8 + 1) - 1) + ((i6 + 1) - 1) * i4 + l3,
								i4, 1.0D, ad6, (1 - 1) + ((1 + i6) - 1) * l4
										+ k4, l4);
						Dlacpy.dlacpy("ALL", j11, k14, ad6, k4, l4, ad2,
								(j12 - 1) + ((k6 + 1) - 1) * i2 + l1, i2);
						j12 += j4;
					}

					if (flag1) {
						int k12 = j2;
						for (int l20 = ((k2 - j2) + j4) / j4; l20 > 0; l20--) {
							int k11 = Math.min(j4, (k2 - k12) + 1);
							Dlacpy.dlacpy("ALL", k11, j15, ad3, (k12 - 1)
									+ ((k6 + 1 + l8) - 1) * i3 + l2, i3, ad6,
									(1 - 1) + ((1 + l15) - 1) * l4 + k4, l4);
							Dlaset.dlaset("ALL", k11, l15, 0.0D, 0.0D, ad6, k4,
									l4);
							Dtrmm.dtrmm("R", "U", "N", "N", k11, j15, 1.0D,
									ad5, ((l8 + 1) - 1) + ((1 + l15) - 1) * i4
											+ l3, i4, ad6, (1 - 1)
											+ ((1 + l15) - 1) * l4 + k4, l4);
							Dgemm.dgemm("N", "N", k11, i6, l8, 1.0D, ad3,
									(k12 - 1) + ((k6 + 1) - 1) * i3 + l2, i3,
									ad5, l3, i4, 1.0D, ad6, k4, l4);
							Dlacpy.dlacpy("ALL", k11, l8, ad3, (k12 - 1)
									+ ((k6 + 1) - 1) * i3 + l2, i3, ad6,
									(1 - 1) + ((1 + i6) - 1) * l4 + k4, l4);
							Dtrmm.dtrmm("R", "L", "N", "N", k11, j6 - i6, 1.0D,
									ad5, (1 - 1) + ((i6 + 1) - 1) * i4 + l3,
									i4, ad6,
									(1 - 1) + ((1 + i6) - 1) * l4 + k4, l4);
							Dgemm.dgemm("N", "N", k11, j6 - i6, i9 - l8, 1.0D,
									ad3, (k12 - 1) + ((k6 + 1 + l8) - 1) * i3
											+ l2, i3, ad5, ((l8 + 1) - 1)
											+ ((i6 + 1) - 1) * i4 + l3, i4,
									1.0D, ad6, (1 - 1) + ((1 + i6) - 1) * l4
											+ k4, l4);
							Dlacpy.dlacpy("ALL", k11, k14, ad6, k4, l4, ad3,
									(k12 - 1) + ((k6 + 1) - 1) * i3 + l2, i3);
							k12 += j4;
						}

					}
				}
			}
			k6 += 3 * l17 - 2;
		}

	}

	private static void dlarfg_adapter(int i, doubleW doublew, double ad[],
			int j, int k, double ad1[], int l) {
		doubleW doublew1 = new doubleW(ad1[l]);
		Dlarfg.dlarfg(i, doublew, ad, j, k, doublew1);
		ad1[l] = doublew1.val;
	}
}

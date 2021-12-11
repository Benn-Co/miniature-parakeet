package org.netlib.lapack;

import org.netlib.blas.Dcopy;
import org.netlib.blas.Drot;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlahqr {
	public static void dlahqr(boolean flag, boolean flag1, int i, int j, int k,
			double ad[], int l, int i1, double ad1[], int j1, double ad2[],
			int k1, int l1, int i2, double ad3[], int j2, int k2, intW intw) {
		doubleW doublew = new doubleW(0.0D);
		double d30 = 0.0D;
		doubleW doublew1 = new doubleW(0.0D);
		doubleW doublew2 = new doubleW(0.0D);
		double d31 = 0.0D;
		doubleW doublew3 = new doubleW(0.0D);
		doubleW doublew4 = new doubleW(0.0D);
		double d47 = 0.0D;
		int l2 = 0;
		int i3 = 0;
		int j3 = 0;
		int l3 = 0;
		int l5 = 0;
		int j6 = 0;
		double ad4[] = new double[3];
		intw.val = 0;
		if (i == 0)
			return;
		if (j == k) {
			ad1[(j - 1) + j1] = ad[(j - 1) + (j - 1) * i1 + l];
			ad2[(j - 1) + k1] = 0.0D;
			return;
		}
		l3 = j;
		for (int k6 = (k - 3 - j) + 1; k6 > 0; k6--) {
			ad[((l3 + 2) - 1) + (l3 - 1) * i1 + l] = 0.0D;
			ad[((l3 + 3) - 1) + (l3 - 1) * i1 + l] = 0.0D;
			l3++;
		}

		if (j <= k - 2)
			ad[(k - 1) + (k - 2 - 1) * i1 + l] = 0.0D;
		l5 = (k - j) + 1;
		j6 = (i2 - l1) + 1;
		doublew2.val = Dlamch.dlamch("SAFE MINIMUM");
		doublew1.val = 1.0D / doublew2.val;
		Dlabad.dlabad(doublew2, doublew1);
		d47 = Dlamch.dlamch("PRECISION");
		d31 = doublew2.val * (l5 / d47);
		if (flag) {
			i3 = 1;
			j3 = i;
		}
		l2 = k;
		label0: do {
			int j5;
			label1: {
				j5 = j;
				if (l2 < j)
					break label0;
				int k3 = 0;
				for (int l6 = (30 - 0) + 1; l6 > 0; l6--) {
					int i5 = l2;
					for (int i7 = (((j5 + 1) - l2) + -1) / -1; i7 > 0; i7--) {
						if (Math.abs(ad[(i5 - 1) + (i5 - 1 - 1) * i1 + l]) <= d31)
							break;
						double d46 = Math.abs(ad[(i5 - 1 - 1) + (i5 - 1 - 1)
								* i1 + l])
								+ Math.abs(ad[(i5 - 1) + (i5 - 1) * i1 + l]);
						if (d46 == 0.0D) {
							if (i5 - 2 >= j)
								d46 += Math.abs(ad[(i5 - 1 - 1) + (i5 - 2 - 1)
										* i1 + l]);
							if (i5 + 1 <= k)
								d46 += Math.abs(ad[((i5 + 1) - 1) + (i5 - 1)
										* i1 + l]);
						}
						if (Math.abs(ad[(i5 - 1) + (i5 - 1 - 1) * i1 + l]) <= d47
								* d46) {
							double d3 = Math.max(
									Math.abs(ad[(i5 - 1) + (i5 - 1 - 1) * i1
											+ l]),
									Math.abs(ad[(i5 - 1 - 1) + (i5 - 1) * i1
											+ l]));
							double d5 = Math.min(
									Math.abs(ad[(i5 - 1) + (i5 - 1 - 1) * i1
											+ l]),
									Math.abs(ad[(i5 - 1 - 1) + (i5 - 1) * i1
											+ l]));
							double d1 = Math
									.max(Math.abs(ad[(i5 - 1) + (i5 - 1) * i1
											+ l]),
											Math.abs(ad[(i5 - 1 - 1)
													+ (i5 - 1 - 1) * i1 + l]
													- ad[(i5 - 1) + (i5 - 1)
															* i1 + l]));
							double d7 = Math
									.min(Math.abs(ad[(i5 - 1) + (i5 - 1) * i1
											+ l]),
											Math.abs(ad[(i5 - 1 - 1)
													+ (i5 - 1 - 1) * i1 + l]
													- ad[(i5 - 1) + (i5 - 1)
															* i1 + l]));
							d30 = d1 + d3;
							if (d5 * (d3 / d30) <= Math.max(d31, d47
									* (d7 * (d1 / d30))))
								break;
						}
						i5--;
					}

					j5 = i5;
					if (j5 > j)
						ad[(j5 - 1) + (j5 - 1 - 1) * i1 + l] = 0.0D;
					if (j5 >= l2 - 1)
						break label1;
					if (flag ^ true) {
						i3 = j5;
						j3 = l2;
					}
					double d11;
					double d13;
					double d15;
					double d19;
					if ((k3 == 10) || (k3 == 20)) {
						d11 = 0.75D * d30 + ad[(l2 - 1) + (l2 - 1) * i1 + l];
						d13 = -0.4375D * d30;
						d15 = d30;
						d19 = d11;
					} else {
						d11 = ad[(l2 - 1 - 1) + (l2 - 1 - 1) * i1 + l];
						d15 = ad[(l2 - 1) + (l2 - 1 - 1) * i1 + l];
						d13 = ad[(l2 - 1 - 1) + (l2 - 1) * i1 + l];
						d19 = ad[(l2 - 1) + (l2 - 1) * i1 + l];
					}
					d30 = Math.abs(d11) + Math.abs(d13) + Math.abs(d15)
							+ Math.abs(d19);
					double d21;
					double d23;
					double d25;
					double d27;
					if (d30 == 0.0D) {
						d23 = 0.0D;
						d21 = 0.0D;
						d27 = 0.0D;
						d25 = 0.0D;
					} else {
						d11 /= d30;
						d15 /= d30;
						d13 /= d30;
						d19 /= d30;
						double d44 = (d11 + d19) / 2D;
						double d9 = (d11 - d44) * (d19 - d44) - d13 * d15;
						double d29 = Math.sqrt(Math.abs(d9));
						if (d9 >= 0.0D) {
							d23 = d44 * d30;
							d27 = d23;
							d21 = d29 * d30;
							d25 = -d21;
						} else {
							d23 = d44 + d29;
							d27 = d44 - d29;
							if (Math.abs(d23 - d19) <= Math.abs(d27 - d19)) {
								d23 *= d30;
								d27 = d23;
							} else {
								d27 *= d30;
								d23 = d27;
							}
							d21 = 0.0D;
							d25 = 0.0D;
						}
					}
					int k5 = l2 - 2;
					for (int j7 = ((j5 - (l2 - 2)) + -1) / -1; j7 > 0; j7--) {
						double d17 = ad[((k5 + 1) - 1) + (k5 - 1) * i1 + l];
						d30 = Math.abs(ad[(k5 - 1) + (k5 - 1) * i1 + l] - d27)
								+ Math.abs(d25) + Math.abs(d17);
						d17 = ad[((k5 + 1) - 1) + (k5 - 1) * i1 + l] / d30;
						ad4[1 - 1] = (d17
								* ad[(k5 - 1) + ((k5 + 1) - 1) * i1 + l] + (ad[(k5 - 1)
								+ (k5 - 1) * i1 + l] - d23)
								* ((ad[(k5 - 1) + (k5 - 1) * i1 + l] - d27) / d30))
								- d21 * (d25 / d30);
						ad4[2 - 1] = d17
								* ((ad[(k5 - 1) + (k5 - 1) * i1 + l] + ad[((k5 + 1) - 1)
										+ ((k5 + 1) - 1) * i1 + l])
										- d23 - d27);
						ad4[3 - 1] = d17
								* ad[((k5 + 2) - 1) + ((k5 + 1) - 1) * i1 + l];
						d30 = Math.abs(ad4[1 - 1]) + Math.abs(ad4[2 - 1])
								+ Math.abs(ad4[3 - 1]);
						ad4[1 - 1] = ad4[1 - 1] / d30;
						ad4[2 - 1] = ad4[2 - 1] / d30;
						ad4[3 - 1] = ad4[3 - 1] / d30;
						if ((k5 == j5)
								|| (Math.abs(ad[(k5 - 1) + (k5 - 1 - 1) * i1
										+ l])
										* (Math.abs(ad4[2 - 1]) + Math
												.abs(ad4[3 - 1])) <= d47
										* Math.abs(ad4[1 - 1])
										* (Math.abs(ad[(k5 - 1 - 1)
												+ (k5 - 1 - 1) * i1 + l])
												+ Math.abs(ad[(k5 - 1)
														+ (k5 - 1) * i1 + l]) + Math
													.abs(ad[((k5 + 1) - 1)
															+ ((k5 + 1) - 1)
															* i1 + l]))))
							break;
						k5--;
					}

					i5 = k5;
					for (int k7 = (l2 - 1 - k5) + 1; k7 > 0; k7--) {
						int i6 = Math.min(3, (l2 - i5) + 1);
						if (i5 > k5)
							Dcopy.dcopy(i6, ad, (i5 - 1) + (i5 - 1 - 1) * i1
									+ l, 1, ad4, 0, 1);
						dlarfg_adapter(i6, ad4, 1 - 1, ad4, 2 - 1, 1, doublew4);
						if (i5 > k5) {
							ad[(i5 - 1) + (i5 - 1 - 1) * i1 + l] = ad4[1 - 1];
							ad[((i5 + 1) - 1) + (i5 - 1 - 1) * i1 + l] = 0.0D;
							if (i5 < l2 - 1)
								ad[((i5 + 2) - 1) + (i5 - 1 - 1) * i1 + l] = 0.0D;
						} else if (k5 > j5)
							ad[(i5 - 1) + (i5 - 1 - 1) * i1 + l] = -ad[(i5 - 1)
									+ (i5 - 1 - 1) * i1 + l];
						double d49 = ad4[2 - 1];
						double d40 = doublew4.val * d49;
						if (i6 == 3) {
							double d51 = ad4[3 - 1];
							double d42 = doublew4.val * d51;
							int i4 = i5;
							for (int l7 = (j3 - i5) + 1; l7 > 0; l7--) {
								double d33 = ad[(i5 - 1) + (i4 - 1) * i1 + l]
										+ d49
										* ad[((i5 + 1) - 1) + (i4 - 1) * i1 + l]
										+ d51
										* ad[((i5 + 2) - 1) + (i4 - 1) * i1 + l];
								ad[(i5 - 1) + (i4 - 1) * i1 + l] = ad[(i5 - 1)
										+ (i4 - 1) * i1 + l]
										- d33 * doublew4.val;
								ad[((i5 + 1) - 1) + (i4 - 1) * i1 + l] = ad[((i5 + 1) - 1)
										+ (i4 - 1) * i1 + l]
										- d33 * d40;
								ad[((i5 + 2) - 1) + (i4 - 1) * i1 + l] = ad[((i5 + 2) - 1)
										+ (i4 - 1) * i1 + l]
										- d33 * d42;
								i4++;
							}

							i4 = i3;
							for (int i8 = (Math.min(i5 + 3, l2) - i3) + 1; i8 > 0; i8--) {
								double d34 = ad[(i4 - 1) + (i5 - 1) * i1 + l]
										+ d49
										* ad[(i4 - 1) + ((i5 + 1) - 1) * i1 + l]
										+ d51
										* ad[(i4 - 1) + ((i5 + 2) - 1) * i1 + l];
								ad[(i4 - 1) + (i5 - 1) * i1 + l] = ad[(i4 - 1)
										+ (i5 - 1) * i1 + l]
										- d34 * doublew4.val;
								ad[(i4 - 1) + ((i5 + 1) - 1) * i1 + l] = ad[(i4 - 1)
										+ ((i5 + 1) - 1) * i1 + l]
										- d34 * d40;
								ad[(i4 - 1) + ((i5 + 2) - 1) * i1 + l] = ad[(i4 - 1)
										+ ((i5 + 2) - 1) * i1 + l]
										- d34 * d42;
								i4++;
							}

							if (flag1) {
								int j4 = l1;
								for (int j8 = (i2 - l1) + 1; j8 > 0; j8--) {
									double d35 = ad3[(j4 - 1) + (i5 - 1) * k2
											+ j2]
											+ d49
											* ad3[(j4 - 1) + ((i5 + 1) - 1)
													* k2 + j2]
											+ d51
											* ad3[(j4 - 1) + ((i5 + 2) - 1)
													* k2 + j2];
									ad3[(j4 - 1) + (i5 - 1) * k2 + j2] = ad3[(j4 - 1)
											+ (i5 - 1) * k2 + j2]
											- d35 * doublew4.val;
									ad3[(j4 - 1) + ((i5 + 1) - 1) * k2 + j2] = ad3[(j4 - 1)
											+ ((i5 + 1) - 1) * k2 + j2]
											- d35 * d40;
									ad3[(j4 - 1) + ((i5 + 2) - 1) * k2 + j2] = ad3[(j4 - 1)
											+ ((i5 + 2) - 1) * k2 + j2]
											- d35 * d42;
									j4++;
								}

							}
						} else if (i6 == 2) {
							int k4 = i5;
							for (int k8 = (j3 - i5) + 1; k8 > 0; k8--) {
								double d36 = ad[(i5 - 1) + (k4 - 1) * i1 + l]
										+ d49
										* ad[((i5 + 1) - 1) + (k4 - 1) * i1 + l];
								ad[(i5 - 1) + (k4 - 1) * i1 + l] = ad[(i5 - 1)
										+ (k4 - 1) * i1 + l]
										- d36 * doublew4.val;
								ad[((i5 + 1) - 1) + (k4 - 1) * i1 + l] = ad[((i5 + 1) - 1)
										+ (k4 - 1) * i1 + l]
										- d36 * d40;
								k4++;
							}

							k4 = i3;
							for (int l8 = (l2 - i3) + 1; l8 > 0; l8--) {
								double d37 = ad[(k4 - 1) + (i5 - 1) * i1 + l]
										+ d49
										* ad[(k4 - 1) + ((i5 + 1) - 1) * i1 + l];
								ad[(k4 - 1) + (i5 - 1) * i1 + l] = ad[(k4 - 1)
										+ (i5 - 1) * i1 + l]
										- d37 * doublew4.val;
								ad[(k4 - 1) + ((i5 + 1) - 1) * i1 + l] = ad[(k4 - 1)
										+ ((i5 + 1) - 1) * i1 + l]
										- d37 * d40;
								k4++;
							}

							if (flag1) {
								int l4 = l1;
								for (int i9 = (i2 - l1) + 1; i9 > 0; i9--) {
									double d38 = ad3[(l4 - 1) + (i5 - 1) * k2
											+ j2]
											+ d49
											* ad3[(l4 - 1) + ((i5 + 1) - 1)
													* k2 + j2];
									ad3[(l4 - 1) + (i5 - 1) * k2 + j2] = ad3[(l4 - 1)
											+ (i5 - 1) * k2 + j2]
											- d38 * doublew4.val;
									ad3[(l4 - 1) + ((i5 + 1) - 1) * k2 + j2] = ad3[(l4 - 1)
											+ ((i5 + 1) - 1) * k2 + j2]
											- d38 * d40;
									l4++;
								}

							}
						}
						i5++;
					}

					k3++;
				}

				intw.val = l2;
				return;
			}
			if (j5 == l2) {
				ad1[(l2 - 1) + j1] = ad[(l2 - 1) + (l2 - 1) * i1 + l];
				ad2[(l2 - 1) + k1] = 0.0D;
			} else if (j5 == l2 - 1) {
				dlanv2_adapter(ad, (l2 - 1 - 1) + (l2 - 1 - 1) * i1 + l, ad,
						(l2 - 1 - 1) + (l2 - 1) * i1 + l, ad, (l2 - 1)
								+ (l2 - 1 - 1) * i1 + l, ad, (l2 - 1)
								+ (l2 - 1) * i1 + l, ad1, (l2 - 1 - 1) + j1,
						ad2, (l2 - 1 - 1) + k1, ad1, (l2 - 1) + j1, ad2,
						(l2 - 1) + k1, doublew, doublew3);
				if (flag) {
					if (j3 > l2)
						Drot.drot(j3 - l2, ad, (l2 - 1 - 1) + ((l2 + 1) - 1)
								* i1 + l, i1, ad, (l2 - 1) + ((l2 + 1) - 1)
								* i1 + l, i1, doublew.val, doublew3.val);
					Drot.drot(l2 - i3 - 1, ad,
							(i3 - 1) + (l2 - 1 - 1) * i1 + l, 1, ad, (i3 - 1)
									+ (l2 - 1) * i1 + l, 1, doublew.val,
							doublew3.val);
				}
				if (flag1)
					Drot.drot(j6, ad3, (l1 - 1) + (l2 - 1 - 1) * k2 + j2, 1,
							ad3, (l1 - 1) + (l2 - 1) * k2 + j2, 1, doublew.val,
							doublew3.val);
			}
			l2 = j5 - 1;
		} while (true);
	}

	private static void dlarfg_adapter(int i, double ad[], int j, double ad1[],
			int k, int l, doubleW doublew) {
		doubleW doublew1 = new doubleW(ad[j]);
		Dlarfg.dlarfg(i, doublew1, ad1, k, l, doublew);
		ad[j] = doublew1.val;
	}

	private static void dlanv2_adapter(double ad[], int i, double ad1[], int j,
			double ad2[], int k, double ad3[], int l, double ad4[], int i1,
			double ad5[], int j1, double ad6[], int k1, double ad7[], int l1,
			doubleW doublew, doubleW doublew1) {
		doubleW doublew2 = new doubleW(ad[i]);
		doubleW doublew3 = new doubleW(ad1[j]);
		doubleW doublew4 = new doubleW(ad2[k]);
		doubleW doublew5 = new doubleW(ad3[l]);
		doubleW doublew6 = new doubleW(ad4[i1]);
		doubleW doublew7 = new doubleW(ad5[j1]);
		doubleW doublew8 = new doubleW(ad6[k1]);
		doubleW doublew9 = new doubleW(ad7[l1]);
		Dlanv2.dlanv2(doublew2, doublew3, doublew4, doublew5, doublew6,
				doublew7, doublew8, doublew9, doublew, doublew1);
		ad[i] = doublew2.val;
		ad1[j] = doublew3.val;
		ad2[k] = doublew4.val;
		ad3[l] = doublew5.val;
		ad4[i1] = doublew6.val;
		ad5[j1] = doublew7.val;
		ad6[k1] = doublew8.val;
		ad7[l1] = doublew9.val;
	}
}

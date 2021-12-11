package org.netlib.lapack;

import org.netlib.blas.Dcopy;
import org.netlib.blas.Dswap;
import org.netlib.blas.Idamax;
import org.netlib.util.Util;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlasy2 {
	public static void dlasy2(boolean flag, boolean flag1, int i, int j, int k,
			double ad[], int l, int i1, double ad1[], int j1, int k1,
			double ad2[], int l1, int i2, doubleW doublew, double ad3[],
			int j2, int k2, doubleW doublew1, intW intw) {
		int k3;
		int k4;
		double d1;
		double d5;
		double d9;
		int ai[];
		double ad4[];
		double ad5[];
		double ad6[];
		label0: {
			double d7;
			double ad7[];
			label1: {
				label2: {
					label3: {
						k3 = 0;
						k4 = 0;
						int l4 = 0;
						double d = 0.0D;
						d1 = 0.0D;
						double d2 = 0.0D;
						d5 = 0.0D;
						d9 = 0.0D;
						double d10 = 0.0D;
						ai = new int[4];
						ad4 = new double[4];
						ad5 = new double[4 * 4];
						ad6 = new double[4];
						ad7 = new double[2];
						intw.val = 0;
						if ((j == 0) || (k == 0))
							return;
						d1 = Dlamch.dlamch("P");
						d9 = Dlamch.dlamch("S") / d1;
						d5 = i;
						l4 = (j + j + k) - 2;
						int k5 = l4;
						if (k5 != 1) {
							if (k5 == 2)
								break label3;
							if (k5 == 3)
								break label2;
							if (k5 == 4)
								break label0;
						}
						d10 = ad[(1 - 1) + (1 - 1) * i1 + l] + d5
								* ad1[(1 - 1) + (1 - 1) * k1 + j1];
						d = Math.abs(d10);
						if (d <= d9) {
							d10 = d9;
							d = d9;
							intw.val = 1;
						}
						doublew.val = 1.0D;
						d2 = Math.abs(ad2[(1 - 1) + (1 - 1) * i2 + l1]);
						if (d9 * d2 > d)
							doublew.val = 1.0D / d2;
						ad3[(1 - 1) + (1 - 1) * k2 + j2] = (ad2[(1 - 1)
								+ (1 - 1) * i2 + l1] * doublew.val)
								/ d10;
						doublew1.val = Math
								.abs(ad3[(1 - 1) + (1 - 1) * k2 + j2]);
						return;
					}
					d7 = Math.max(
							d1
									* Math.max(Math.max(Util.max(
											Math.abs(ad[(1 - 1) + (1 - 1) * i1
													+ l]),
											Math.abs(ad1[(1 - 1) + (1 - 1) * k1
													+ j1]),
											Math.abs(ad1[(1 - 1) + (2 - 1) * k1
													+ j1])), Math
											.abs(ad1[(2 - 1) + (1 - 1) * k1
													+ j1])), Math
											.abs(ad1[(2 - 1) + (2 - 1) * k1
													+ j1])), d9);
					ad6[1 - 1] = ad[(1 - 1) + (1 - 1) * i1 + l] + d5
							* ad1[(1 - 1) + (1 - 1) * k1 + j1];
					ad6[4 - 1] = ad[(1 - 1) + (1 - 1) * i1 + l] + d5
							* ad1[(2 - 1) + (2 - 1) * k1 + j1];
					if (flag1) {
						ad6[2 - 1] = d5 * ad1[(2 - 1) + (1 - 1) * k1 + j1];
						ad6[3 - 1] = d5 * ad1[(1 - 1) + (2 - 1) * k1 + j1];
					} else {
						ad6[2 - 1] = d5 * ad1[(1 - 1) + (2 - 1) * k1 + j1];
						ad6[3 - 1] = d5 * ad1[(2 - 1) + (1 - 1) * k1 + j1];
					}
					ad4[1 - 1] = ad2[(1 - 1) + (1 - 1) * i2 + l1];
					ad4[2 - 1] = ad2[(1 - 1) + (2 - 1) * i2 + l1];
					break label1;
				}
				d7 = Math.max(
						d1
								* Math.max(Math.max(
										Util.max(
												Math.abs(ad1[(1 - 1) + (1 - 1)
														* k1 + j1]),
												Math.abs(ad[(1 - 1) + (1 - 1)
														* i1 + l]),
												Math.abs(ad[(1 - 1) + (2 - 1)
														* i1 + l])), Math
												.abs(ad[(2 - 1) + (1 - 1) * i1
														+ l])), Math
										.abs(ad[(2 - 1) + (2 - 1) * i1 + l])),
						d9);
				ad6[1 - 1] = ad[(1 - 1) + (1 - 1) * i1 + l] + d5
						* ad1[(1 - 1) + (1 - 1) * k1 + j1];
				ad6[4 - 1] = ad[(2 - 1) + (2 - 1) * i1 + l] + d5
						* ad1[(1 - 1) + (1 - 1) * k1 + j1];
				if (flag) {
					ad6[2 - 1] = ad[(1 - 1) + (2 - 1) * i1 + l];
					ad6[3 - 1] = ad[(2 - 1) + (1 - 1) * i1 + l];
				} else {
					ad6[2 - 1] = ad[(2 - 1) + (1 - 1) * i1 + l];
					ad6[3 - 1] = ad[(1 - 1) + (2 - 1) * i1 + l];
				}
				ad4[1 - 1] = ad2[(1 - 1) + (1 - 1) * i2 + l1];
				ad4[2 - 1] = ad2[(2 - 1) + (1 - 1) * i2 + l1];
			}
			int j3 = Idamax.idamax(4, ad6, 0, 1);
			double d18 = ad6[j3 - 1];
			if (Math.abs(d18) <= d7) {
				intw.val = 1;
				d18 = d7;
			}
			double d20 = ad6[locu12[j3 - 1] - 1];
			double d4 = ad6[locl21[j3 - 1] - 1] / d18;
			double d22 = ad6[locu22[j3 - 1] - 1] - d20 * d4;
			boolean flag5 = xswpiv[j3 - 1];
			boolean flag3 = bswpiv[j3 - 1];
			if (Math.abs(d22) <= d7) {
				intw.val = 1;
				d22 = d7;
			}
			if (flag3) {
				double d12 = ad4[2 - 1];
				ad4[2 - 1] = ad4[1 - 1] - d4 * d12;
				ad4[1 - 1] = d12;
			} else {
				ad4[2 - 1] = ad4[2 - 1] - d4 * ad4[1 - 1];
			}
			doublew.val = 1.0D;
			if ((2D * d9 * Math.abs(ad4[2 - 1]) > Math.abs(d22))
					|| (2D * d9 * Math.abs(ad4[1 - 1]) > Math.abs(d18))) {
				doublew.val = 0.5D / Math.max(Math.abs(ad4[1 - 1]),
						Math.abs(ad4[2 - 1]));
				ad4[1 - 1] = ad4[1 - 1] * doublew.val;
				ad4[2 - 1] = ad4[2 - 1] * doublew.val;
			}
			ad7[2 - 1] = ad4[2 - 1] / d22;
			ad7[1 - 1] = ad4[1 - 1] / d18 - (d20 / d18) * ad7[2 - 1];
			if (flag5) {
				double d13 = ad7[2 - 1];
				ad7[2 - 1] = ad7[1 - 1];
				ad7[1 - 1] = d13;
			}
			ad3[(1 - 1) + (1 - 1) * k2 + j2] = ad7[1 - 1];
			if (j == 1) {
				ad3[(1 - 1) + (2 - 1) * k2 + j2] = ad7[2 - 1];
				doublew1.val = Math.abs(ad3[(1 - 1) + (1 - 1) * k2 + j2])
						+ Math.abs(ad3[(1 - 1) + (2 - 1) * k2 + j2]);
			} else {
				ad3[(2 - 1) + (1 - 1) * k2 + j2] = ad7[2 - 1];
				doublew1.val = Math.max(
						Math.abs(ad3[(1 - 1) + (1 - 1) * k2 + j2]),
						Math.abs(ad3[(2 - 1) + (1 - 1) * k2 + j2]));
			}
			return;
		}
		double d8 = Math.max(
				Util.max(Math.abs(ad1[(1 - 1) + (1 - 1) * k1 + j1]),
						Math.abs(ad1[(1 - 1) + (2 - 1) * k1 + j1]),
						Math.abs(ad1[(2 - 1) + (1 - 1) * k1 + j1])),
				Math.abs(ad1[(2 - 1) + (2 - 1) * k1 + j1]));
		d8 = Math.max(Math.max(
				Util.max(d8, Math.abs(ad[(1 - 1) + (1 - 1) * i1 + l]),
						Math.abs(ad[(1 - 1) + (2 - 1) * i1 + l])),
				Math.abs(ad[(2 - 1) + (1 - 1) * i1 + l])), Math.abs(ad[(2 - 1)
				+ (2 - 1) * i1 + l]));
		d8 = Math.max(d1 * d8, d9);
		ad4[1 - 1] = 0.0D;
		Dcopy.dcopy(16, ad4, 0, 0, ad5, 0, 1);
		ad5[(1 - 1) + (1 - 1) * 4] = ad[(1 - 1) + (1 - 1) * i1 + l] + d5
				* ad1[(1 - 1) + (1 - 1) * k1 + j1];
		ad5[(2 - 1) + (2 - 1) * 4] = ad[(2 - 1) + (2 - 1) * i1 + l] + d5
				* ad1[(1 - 1) + (1 - 1) * k1 + j1];
		ad5[(3 - 1) + (3 - 1) * 4] = ad[(1 - 1) + (1 - 1) * i1 + l] + d5
				* ad1[(2 - 1) + (2 - 1) * k1 + j1];
		ad5[(4 - 1) + (4 - 1) * 4] = ad[(2 - 1) + (2 - 1) * i1 + l] + d5
				* ad1[(2 - 1) + (2 - 1) * k1 + j1];
		if (flag) {
			ad5[(1 - 1) + (2 - 1) * 4] = ad[(2 - 1) + (1 - 1) * i1 + l];
			ad5[(2 - 1) + (1 - 1) * 4] = ad[(1 - 1) + (2 - 1) * i1 + l];
			ad5[(3 - 1) + (4 - 1) * 4] = ad[(2 - 1) + (1 - 1) * i1 + l];
			ad5[(4 - 1) + (3 - 1) * 4] = ad[(1 - 1) + (2 - 1) * i1 + l];
		} else {
			ad5[(1 - 1) + (2 - 1) * 4] = ad[(1 - 1) + (2 - 1) * i1 + l];
			ad5[(2 - 1) + (1 - 1) * 4] = ad[(2 - 1) + (1 - 1) * i1 + l];
			ad5[(3 - 1) + (4 - 1) * 4] = ad[(1 - 1) + (2 - 1) * i1 + l];
			ad5[(4 - 1) + (3 - 1) * 4] = ad[(2 - 1) + (1 - 1) * i1 + l];
		}
		if (flag1) {
			ad5[(1 - 1) + (3 - 1) * 4] = d5 * ad1[(1 - 1) + (2 - 1) * k1 + j1];
			ad5[(2 - 1) + (4 - 1) * 4] = d5 * ad1[(1 - 1) + (2 - 1) * k1 + j1];
			ad5[(3 - 1) + (1 - 1) * 4] = d5 * ad1[(2 - 1) + (1 - 1) * k1 + j1];
			ad5[(4 - 1) + (2 - 1) * 4] = d5 * ad1[(2 - 1) + (1 - 1) * k1 + j1];
		} else {
			ad5[(1 - 1) + (3 - 1) * 4] = d5 * ad1[(2 - 1) + (1 - 1) * k1 + j1];
			ad5[(2 - 1) + (4 - 1) * 4] = d5 * ad1[(2 - 1) + (1 - 1) * k1 + j1];
			ad5[(3 - 1) + (1 - 1) * 4] = d5 * ad1[(1 - 1) + (2 - 1) * k1 + j1];
			ad5[(4 - 1) + (2 - 1) * 4] = d5 * ad1[(1 - 1) + (2 - 1) * k1 + j1];
		}
		ad4[1 - 1] = ad2[(1 - 1) + (1 - 1) * i2 + l1];
		ad4[2 - 1] = ad2[(2 - 1) + (1 - 1) * i2 + l1];
		ad4[3 - 1] = ad2[(1 - 1) + (2 - 1) * i2 + l1];
		ad4[4 - 1] = ad2[(2 - 1) + (2 - 1) * i2 + l1];
		int l2 = 1;
		for (int l5 = (3 - 1) + 1; l5 > 0; l5--) {
			double d24 = 0.0D;
			int i3 = l2;
			for (int k6 = (4 - l2) + 1; k6 > 0; k6--) {
				int j4 = l2;
				for (int j7 = (4 - l2) + 1; j7 > 0; j7--) {
					if (Math.abs(ad5[(i3 - 1) + (j4 - 1) * 4]) >= d24) {
						d24 = Math.abs(ad5[(i3 - 1) + (j4 - 1) * 4]);
						k3 = i3;
						k4 = j4;
					}
					j4++;
				}

				i3++;
			}

			if (k3 != l2) {
				Dswap.dswap(4, ad5, (k3 - 1) + (1 - 1) * 4, 4, ad5, (l2 - 1)
						+ (1 - 1) * 4, 4);
				double d14 = ad4[l2 - 1];
				ad4[l2 - 1] = ad4[k3 - 1];
				ad4[k3 - 1] = d14;
			}
			if (k4 != l2)
				Dswap.dswap(4, ad5, (1 - 1) + (k4 - 1) * 4, 1, ad5, (1 - 1)
						+ (l2 - 1) * 4, 1);
			ai[l2 - 1] = k4;
			if (Math.abs(ad5[(l2 - 1) + (l2 - 1) * 4]) < d8) {
				intw.val = 1;
				ad5[(l2 - 1) + (l2 - 1) * 4] = d8;
			}
			int l3 = l2 + 1;
			for (int l6 = (4 - (l2 + 1)) + 1; l6 > 0; l6--) {
				ad5[(l3 - 1) + (l2 - 1) * 4] = ad5[(l3 - 1) + (l2 - 1) * 4]
						/ ad5[(l2 - 1) + (l2 - 1) * 4];
				ad4[l3 - 1] = ad4[l3 - 1] - ad5[(l3 - 1) + (l2 - 1) * 4]
						* ad4[l2 - 1];
				int i5 = l2 + 1;
				for (int k7 = (4 - (l2 + 1)) + 1; k7 > 0; k7--) {
					ad5[(l3 - 1) + (i5 - 1) * 4] = ad5[(l3 - 1) + (i5 - 1) * 4]
							- ad5[(l3 - 1) + (l2 - 1) * 4]
							* ad5[(l2 - 1) + (i5 - 1) * 4];
					i5++;
				}

				l3++;
			}

			l2++;
		}

		if (Math.abs(ad5[(4 - 1) + (4 - 1) * 4]) < d8)
			ad5[(4 - 1) + (4 - 1) * 4] = d8;
		doublew.val = 1.0D;
		if ((((8D * d9 * Math.abs(ad4[1 - 1]) > Math.abs(ad5[(1 - 1) + (1 - 1)
				* 4])) || (8D * d9 * Math.abs(ad4[2 - 1]) > Math
				.abs(ad5[(2 - 1) + (2 - 1) * 4]))) || (8D * d9
				* Math.abs(ad4[3 - 1]) > Math.abs(ad5[(3 - 1) + (3 - 1) * 4])))
				|| (8D * d9 * Math.abs(ad4[4 - 1]) > Math.abs(ad5[(4 - 1)
						+ (4 - 1) * 4]))) {
			doublew.val = 1.0D / 8D / Math.max(
					Util.max(Math.abs(ad4[1 - 1]), Math.abs(ad4[2 - 1]),
							Math.abs(ad4[3 - 1])), Math.abs(ad4[4 - 1]));
			ad4[1 - 1] = ad4[1 - 1] * doublew.val;
			ad4[2 - 1] = ad4[2 - 1] * doublew.val;
			ad4[3 - 1] = ad4[3 - 1] * doublew.val;
			ad4[4 - 1] = ad4[4 - 1] * doublew.val;
		}
		l2 = 1;
		for (int i6 = (4 - 1) + 1; i6 > 0; i6--) {
			int j5 = 5 - l2;
			double d15 = 1.0D / ad5[(j5 - 1) + (j5 - 1) * 4];
			ad6[j5 - 1] = ad4[j5 - 1] * d15;
			int i4 = j5 + 1;
			for (int i7 = (4 - (j5 + 1)) + 1; i7 > 0; i7--) {
				ad6[j5 - 1] = ad6[j5 - 1] - d15 * ad5[(j5 - 1) + (i4 - 1) * 4]
						* ad6[i4 - 1];
				i4++;
			}

			l2++;
		}

		l2 = 1;
		for (int j6 = (3 - 1) + 1; j6 > 0; j6--) {
			if (ai[4 - l2 - 1] != 4 - l2) {
				double d16 = ad6[4 - l2 - 1];
				ad6[4 - l2 - 1] = ad6[ai[4 - l2 - 1] - 1];
				ad6[ai[4 - l2 - 1] - 1] = d16;
			}
			l2++;
		}

		ad3[(1 - 1) + (1 - 1) * k2 + j2] = ad6[1 - 1];
		ad3[(2 - 1) + (1 - 1) * k2 + j2] = ad6[2 - 1];
		ad3[(1 - 1) + (2 - 1) * k2 + j2] = ad6[3 - 1];
		ad3[(2 - 1) + (2 - 1) * k2 + j2] = ad6[4 - 1];
		doublew1.val = Math.max(Math.abs(ad6[1 - 1]) + Math.abs(ad6[3 - 1]),
				Math.abs(ad6[2 - 1]) + Math.abs(ad6[4 - 1]));
	}

	public static boolean bswpiv[] = { false, true, false, true };
	public static boolean xswpiv[] = { false, false, true, true };
	public static int locl21[] = { 2, 1, 4, 3 };
	public static int locu12[] = { 3, 4, 1, 2 };
	public static int locu22[] = { 4, 3, 2, 1 };
}

package org.netlib.lapack;

import org.netlib.util.Util;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlaqr0 {
	public static void dlaqr0(boolean flag, boolean flag1, int i, int j, int k,
			double ad[], int l, int i1, double ad1[], int j1, double ad2[],
			int k1, int l1, int i2, double ad3[], int j2, int k2, double ad4[],
			int l2, int i3, intW intw) {
		int j8;
		label0: {
			doubleW doublew = new doubleW(0.0D);
			doubleW doublew1 = new doubleW(0.0D);
			doubleW doublew2 = new doubleW(0.0D);
			doubleW doublew3 = new doubleW(0.0D);
			doubleW doublew4 = new doubleW(0.0D);
			doubleW doublew5 = new doubleW(0.0D);
			intW intw1 = new intW(0);
			int j4 = 0;
			int i5 = 0;
			int j5 = 0;
			intW intw2 = new intW(0);
			intW intw3 = new intW(0);
			j8 = 0;
			int k8 = 0;
			int k9 = 0;
			int l9 = 0;
			int j10 = 0;
			int k10 = 0;
			int j11 = 0;
			int k11 = 0;
			int l11 = 0;
			boolean flag17 = false;
			String s = new String("  ");
			double ad5[] = new double[1 * 1];
			intw.val = 0;
			if (i == 0) {
				ad4[(1 - 1) + l2] = 1.0D;
				return;
			}
			if (flag)
				s = Util.stringInsert(s, "S", 1, 1);
			else
				s = Util.stringInsert(s, "E", 1, 1);
			if (flag1)
				s = Util.stringInsert(s, "V", 2, 2);
			else
				s = Util.stringInsert(s, "N", 2, 2);
			if (i <= 11) {
				j8 = 1;
				if (i3 != -1)
					Dlahqr.dlahqr(flag, flag1, i, j, k, ad, l, i1, ad1, j1,
							ad2, k1, l1, i2, ad3, j2, k2, intw);
				break label0;
			}
			intw.val = 0;
			l11 = Ilaenv.ilaenv(13, "DLAQR0", s, i, j, k, i3);
			l11 = Math.max(2, l11);
			l11 = Util.min((k - j) + 1, (i - 1) / 3, l11);
			j11 = l11;
			k10 = Ilaenv.ilaenv(15, "DLAQR0", s, i, j, k, i3);
			k10 = Util.min(k10, (i + 6) / 9, k - j);
			k10 = Math.max(2, k10 - k10 % 2);
			Dlaqr3.dlaqr3(flag, flag1, i, j, k, l11 + 1, ad, l, i1, l1, i2,
					ad3, j2, k2, intw3, intw2, ad1, j1, ad2, k1, ad, l, i1, i,
					ad, l, i1, i, ad, l, i1, ad4, l2, -1);
			j8 = Math.max((3 * k10) / 2, (int) ad4[(1 - 1) + l2]);
			if (i3 == -1) {
				ad4[(1 - 1) + l2] = j8;
				return;
			}
			l9 = Ilaenv.ilaenv(12, "DLAQR0", s, i, j, k, i3);
			l9 = Math.max(11, l9);
			k9 = Ilaenv.ilaenv(14, "DLAQR0", s, i, j, k, i3);
			k9 = Math.max(0, k9);
			i5 = Ilaenv.ilaenv(16, "DLAQR0", s, i, j, k, i3);
			i5 = Math.max(0, i5);
			i5 = Math.min(2, i5);
			k11 = Math.min((i - 1) / 3, i3 / 2);
			j10 = Math.min((i + 6) / 9, (2 * i3) / 3);
			j10 -= j10 % 2;
			k8 = 1;
			j4 = Math.max(30, 2 * 6) * Math.max(10, (k - j) + 1);
			j5 = k;
			for (int i12 = (j4 - 1) + 1; i12 > 0; i12--) {
				int k4;
				label1: {
					if (j5 < j)
						break label0;
					k4 = j5;
					for (int j12 = (((j + 1) - j5) + -1) / -1; j12 > 0; j12--) {
						if (ad[(k4 - 1) + (k4 - 1 - 1) * i1 + l] == 0.0D)
							break label1;
						k4--;
					}

					k4 = j;
				}
				int k6 = k4;
				int l8 = (j5 - k6) + 1;
				if ((k8 < 5) || (l8 < j11)) {
					flag17 = true;
					if (l8 <= Math.min(l9, k11)) {
						j11 = l8;
					} else {
						j11 = Util.min(l11, l8, k11);
						if (j11 < k11)
							if (j11 >= l8 - 1) {
								j11 = l8;
							} else {
								int k7 = (j5 - j11) + 1;
								if (Math.abs(ad[(k7 - 1) + (k7 - 1 - 1) * i1
										+ l]) > Math.abs(ad[(k7 - 1 - 1)
										+ (k7 - 2 - 1) * i1 + l]))
									j11++;
							}
					}
				} else if (flag17 && (j11 < Math.min(k11, l8))) {
					j11 = Util.min(k11, l8, 2 * j11);
				} else {
					flag17 = false;
					if ((j11 == l8) && (l8 > 2))
						j11 = l8 - 1;
				}
				int i7 = (i - j11) + 1;
				int i6 = j11 + 1;
				int i9 = (i - j11 - 1 - i6) + 1;
				int l7 = j11 + 2;
				int l10 = (i - j11 - l7) + 1;
				Dlaqr3.dlaqr3(flag, flag1, i, k6, j5, j11, ad, l, i1, l1, i2,
						ad3, j2, k2, intw3, intw2, ad1, j1, ad2, k1, ad,
						(i7 - 1) + (1 - 1) * i1 + l, i1, i9, ad, (i7 - 1)
								+ (i6 - 1) * i1 + l, i1, l10, ad, (l7 - 1)
								+ (1 - 1) * i1 + l, i1, ad4, l2, i3);
				j5 -= intw2.val;
				int l5 = (j5 - intw3.val) + 1;
				if ((intw2.val == 0)
						|| ((100 * intw2.val <= j11 * k9) && ((j5 - k6) + 1 > Math
								.min(l9, k11)))) {
					int i10 = Util.min(j10, k10, Math.max(2, j5 - k6));
					i10 -= i10 % 2;
					if (k8 % 6 == 0) {
						l5 = (j5 - i10) + 1;
						int j3 = j5;
						for (int k12 = ((Math.max(l5 + 1, k6 + 2) - j5) + -2)
								/ -2; k12 > 0; k12--) {
							double d1 = Math.abs(ad[(j3 - 1) + (j3 - 1 - 1)
									* i1 + l])
									+ Math.abs(ad[(j3 - 1 - 1) + (j3 - 2 - 1)
											* i1 + l]);
							doublew.val = 0.75D * d1
									+ ad[(j3 - 1) + (j3 - 1) * i1 + l];
							doublew1.val = d1;
							doublew2.val = -0.4375D * d1;
							doublew4.val = doublew.val;
							dlanv2_adapter(doublew, doublew1, doublew2,
									doublew4, ad1, (j3 - 1 - 1) + j1, ad2,
									(j3 - 1 - 1) + k1, ad1, (j3 - 1) + j1, ad2,
									(j3 - 1) + k1, doublew3, doublew5);
							j3 += -2;
						}

						if (l5 == k6) {
							ad1[((l5 + 1) - 1) + j1] = ad[((l5 + 1) - 1)
									+ ((l5 + 1) - 1) * i1 + l];
							ad2[((l5 + 1) - 1) + k1] = 0.0D;
							ad1[(l5 - 1) + j1] = ad1[((l5 + 1) - 1) + j1];
							ad2[(l5 - 1) + k1] = ad2[((l5 + 1) - 1) + k1];
						}
					} else {
						if ((j5 - l5) + 1 <= i10 / 2) {
							l5 = (j5 - i10) + 1;
							int j6 = (i - i10) + 1;
							Dlacpy.dlacpy("A", i10, i10, ad, (l5 - 1)
									+ (l5 - 1) * i1 + l, i1, ad, (j6 - 1)
									+ (1 - 1) * i1 + l, i1);
							if (i10 > l9)
								Dlaqr4.dlaqr4(false, false, i10, 1, i10, ad,
										(j6 - 1) + (1 - 1) * i1 + l, i1, ad1,
										(l5 - 1) + j1, ad2, (l5 - 1) + k1, 1,
										1, ad5, 0, 1, ad4, l2, i3, intw1);
							else
								Dlahqr.dlahqr(false, false, i10, 1, i10, ad,
										(j6 - 1) + (1 - 1) * i1 + l, i1, ad1,
										(l5 - 1) + j1, ad2, (l5 - 1) + k1, 1,
										1, ad5, 0, 1, intw1);
							l5 += intw1.val;
							if (l5 >= j5) {
								doublew.val = ad[(j5 - 1 - 1) + (j5 - 1 - 1)
										* i1 + l];
								doublew2.val = ad[(j5 - 1) + (j5 - 1 - 1) * i1
										+ l];
								doublew1.val = ad[(j5 - 1 - 1) + (j5 - 1) * i1
										+ l];
								doublew4.val = ad[(j5 - 1) + (j5 - 1) * i1 + l];
								dlanv2_adapter(doublew, doublew1, doublew2,
										doublew4, ad1, (j5 - 1 - 1) + j1, ad2,
										(j5 - 1 - 1) + k1, ad1, (j5 - 1) + j1,
										ad2, (j5 - 1) + k1, doublew3, doublew5);
								l5 = j5 - 1;
							}
						}
						if ((j5 - l5) + 1 > i10) {
							boolean flag19 = false;
							int l4 = j5;
							for (int l12 = (((l5 + 1) - j5) + -1) / -1; l12 > 0; l12--) {
								if (flag19)
									break;
								flag19 = true;
								int k3 = l5;
								for (int j13 = (l4 - 1 - l5) + 1; j13 > 0; j13--) {
									if (Math.abs(ad1[(k3 - 1) + j1])
											+ Math.abs(ad2[(k3 - 1) + k1]) < Math
											.abs(ad1[((k3 + 1) - 1) + j1])
											+ Math.abs(ad2[((k3 + 1) - 1) + k1])) {
										flag19 = false;
										double d3 = ad1[(k3 - 1) + j1];
										ad1[(k3 - 1) + j1] = ad1[((k3 + 1) - 1)
												+ j1];
										ad1[((k3 + 1) - 1) + j1] = d3;
										d3 = ad2[(k3 - 1) + k1];
										ad2[(k3 - 1) + k1] = ad2[((k3 + 1) - 1)
												+ k1];
										ad2[((k3 + 1) - 1) + k1] = d3;
									}
									k3++;
								}

								l4--;
							}

						}
						int l3 = j5;
						for (int i13 = (((l5 + 2) - j5) + -2) / -2; i13 > 0; i13--) {
							if (ad2[(l3 - 1) + k1] != -ad2[(l3 - 1 - 1) + k1]) {
								double d4 = ad1[(l3 - 1) + j1];
								ad1[(l3 - 1) + j1] = ad1[(l3 - 1 - 1) + j1];
								ad1[(l3 - 1 - 1) + j1] = ad1[(l3 - 2 - 1) + j1];
								ad1[(l3 - 2 - 1) + j1] = d4;
								d4 = ad2[(l3 - 1) + k1];
								ad2[(l3 - 1) + k1] = ad2[(l3 - 1 - 1) + k1];
								ad2[(l3 - 1 - 1) + k1] = ad2[(l3 - 2 - 1) + k1];
								ad2[(l3 - 2 - 1) + k1] = d4;
							}
							l3 += -2;
						}

					}
					if (((j5 - l5) + 1 == 2) && (ad2[(j5 - 1) + k1] == 0.0D))
						if (Math.abs(ad1[(j5 - 1) + j1]
								- ad[(j5 - 1) + (j5 - 1) * i1 + l]) < Math
								.abs(ad1[(j5 - 1 - 1) + j1]
										- ad[(j5 - 1) + (j5 - 1) * i1 + l]))
							ad1[(j5 - 1 - 1) + j1] = ad1[(j5 - 1) + j1];
						else
							ad1[(j5 - 1) + j1] = ad1[(j5 - 1 - 1) + j1];
					i10 = Math.min(i10, (j5 - l5) + 1);
					i10 -= i10 % 2;
					l5 = (j5 - i10) + 1;
					int k5 = 3 * i10 - 3;
					int l6 = (i - k5) + 1;
					int j7 = k5 + 1;
					int j9 = (((i - k5) + 1) - 4 - (k5 + 1)) + 1;
					int i8 = k5 + 4;
					int i11 = (i - k5 - i8) + 1;
					Dlaqr5.dlaqr5(flag, flag1, i5, i, k6, j5, i10, ad1,
							(l5 - 1) + j1, ad2, (l5 - 1) + k1, ad, l, i1, l1,
							i2, ad3, j2, k2, ad4, l2, 3, ad, (l6 - 1) + (1 - 1)
									* i1 + l, i1, i11, ad, (i8 - 1) + (1 - 1)
									* i1 + l, i1, j9, ad, (l6 - 1) + (j7 - 1)
									* i1 + l, i1);
				}
				if (intw2.val > 0)
					k8 = 1;
				else
					k8++;
			}

			intw.val = j5;
		}
		ad4[(1 - 1) + l2] = j8;
	}

	private static void dlanv2_adapter(doubleW doublew, doubleW doublew1,
			doubleW doublew2, doubleW doublew3, double ad[], int i,
			double ad1[], int j, double ad2[], int k, double ad3[], int l,
			doubleW doublew4, doubleW doublew5) {
		doubleW doublew6 = new doubleW(ad[i]);
		doubleW doublew7 = new doubleW(ad1[j]);
		doubleW doublew8 = new doubleW(ad2[k]);
		doubleW doublew9 = new doubleW(ad3[l]);
		Dlanv2.dlanv2(doublew, doublew1, doublew2, doublew3, doublew6,
				doublew7, doublew8, doublew9, doublew4, doublew5);
		ad[i] = doublew6.val;
		ad1[j] = doublew7.val;
		ad2[k] = doublew8.val;
		ad3[l] = doublew9.val;
	}
}

package org.netlib.lapack;

import org.netlib.blas.Drot;
import org.netlib.util.Util;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlaexc {
	public static void dlaexc(boolean flag, int i, double ad[], int j, int k,
			double ad1[], int l, int i1, int j1, int k1, int l1, double ad2[],
			int i2, intW intw) {
		label0: {
			label1: {
				int j2;
				doubleW doublew;
				doubleW doublew2;
				doubleW doublew7;
				doubleW doublew8;
				doubleW doublew9;
				doubleW doublew10;
				label2: {
					int k2;
					int i3;
					doubleW doublew1;
					doubleW doublew4;
					doubleW doublew5;
					doubleW doublew6;
					double d8;
					double ad3[];
					double ad5[];
					double ad6[];
					double ad7[];
					label3: {
						doubleW doublew3;
						double ad4[];
						label4: {
							intW intw1 = new intW(0);
							j2 = 0;
							k2 = 0;
							i3 = 0;
							int k3 = 0;
							int l3 = 0;
							doublew = new doubleW(0.0D);
							double d = 0.0D;
							double d1 = 0.0D;
							doublew1 = new doubleW(0.0D);
							double d2 = 0.0D;
							doublew2 = new doubleW(0.0D);
							double d3 = 0.0D;
							doublew3 = new doubleW(0.0D);
							doublew4 = new doubleW(0.0D);
							doublew5 = new doubleW(0.0D);
							doublew6 = new doubleW(0.0D);
							d8 = 0.0D;
							doublew7 = new doubleW(0.0D);
							doublew8 = new doubleW(0.0D);
							doublew9 = new doubleW(0.0D);
							doublew10 = new doubleW(0.0D);
							doubleW doublew11 = new doubleW(0.0D);
							ad3 = new double[4 * 4];
							ad4 = new double[3];
							ad5 = new double[3];
							ad6 = new double[3];
							ad7 = new double[2 * 2];
							intw.val = 0;
							if (((i == 0) || (k1 == 0)) || (l1 == 0))
								return;
							if (j1 + k1 > i)
								return;
							j2 = j1 + 1;
							k2 = j1 + 2;
							i3 = j1 + 3;
							if ((k1 == 1) && (l1 == 1)) {
								d3 = ad[(j1 - 1) + (j1 - 1) * k + j];
								double d5 = ad[(j2 - 1) + (j2 - 1) * k + j];
								Dlartg.dlartg(ad[(j1 - 1) + (j2 - 1) * k + j],
										d5 - d3, doublew, doublew2, doublew6);
								if (k2 <= i)
									Drot.drot(i - j1 - 1, ad, (j1 - 1)
											+ (k2 - 1) * k + j, k, ad, (j2 - 1)
											+ (k2 - 1) * k + j, k, doublew.val,
											doublew2.val);
								Drot.drot(j1 - 1, ad, (1 - 1) + (j1 - 1) * k
										+ j, 1, ad, (1 - 1) + (j2 - 1) * k + j,
										1, doublew.val, doublew2.val);
								ad[(j1 - 1) + (j1 - 1) * k + j] = d5;
								ad[(j2 - 1) + (j2 - 1) * k + j] = d3;
								if (flag)
									Drot.drot(i, ad1, (1 - 1) + (j1 - 1) * i1
											+ l, 1, ad1, (1 - 1) + (j2 - 1)
											* i1 + l, 1, doublew.val,
											doublew2.val);
								break label1;
							}
							l3 = k1 + l1;
							Dlacpy.dlacpy("Full", l3, l3, ad, (j1 - 1)
									+ (j1 - 1) * k + j, k, ad3, 0, 4);
							d = Dlange
									.dlange("Max", l3, l3, ad3, 0, 4, ad2, i2);
							d1 = Dlamch.dlamch("P");
							d2 = Dlamch.dlamch("S") / d1;
							d8 = Math.max(10D * d1 * d, d2);
							Dlasy2.dlasy2(false, false, -1, k1, l1, ad3, 0, 4,
									ad3, ((k1 + 1) - 1) + ((k1 + 1) - 1) * 4,
									4, ad3, (1 - 1) + ((k1 + 1) - 1) * 4, 4,
									doublew1, ad7, 0, 2, doublew11, intw1);
							k3 = (k1 + k1 + l1) - 3;
							int i4 = k3;
							if (i4 != 1) {
								if (i4 == 2)
									break label4;
								if (i4 == 3)
									break label3;
							}
							ad4[1 - 1] = doublew1.val;
							ad4[2 - 1] = ad7[(1 - 1) + (1 - 1) * 2];
							ad4[3 - 1] = ad7[(1 - 1) + (2 - 1) * 2];
							dlarfg_adapter(3, ad4, 3 - 1, ad4, 0, 1, doublew3);
							ad4[3 - 1] = 1.0D;
							d3 = ad[(j1 - 1) + (j1 - 1) * k + j];
							Dlarfx.dlarfx("L", 3, 3, ad4, 0, doublew3.val, ad3,
									0, 4, ad2, i2);
							Dlarfx.dlarfx("R", 3, 3, ad4, 0, doublew3.val, ad3,
									0, 4, ad2, i2);
							if (Util.max(Math.abs(ad3[(3 - 1) + (1 - 1) * 4]),
									Math.abs(ad3[(3 - 1) + (2 - 1) * 4]),
									Math.abs(ad3[(3 - 1) + (3 - 1) * 4] - d3)) > d8)
								break label0;
							Dlarfx.dlarfx("L", 3, (i - j1) + 1, ad4, 0,
									doublew3.val, ad, (j1 - 1) + (j1 - 1) * k
											+ j, k, ad2, i2);
							Dlarfx.dlarfx("R", j2, 3, ad4, 0, doublew3.val, ad,
									(1 - 1) + (j1 - 1) * k + j, k, ad2, i2);
							ad[(k2 - 1) + (j1 - 1) * k + j] = 0.0D;
							ad[(k2 - 1) + (j2 - 1) * k + j] = 0.0D;
							ad[(k2 - 1) + (k2 - 1) * k + j] = d3;
							if (flag)
								Dlarfx.dlarfx("R", i, 3, ad4, 0, doublew3.val,
										ad1, (1 - 1) + (j1 - 1) * i1 + l, i1,
										ad2, i2);
							break label2;
						}
						ad4[1 - 1] = -ad7[(1 - 1) + (1 - 1) * 2];
						ad4[2 - 1] = -ad7[(2 - 1) + (1 - 1) * 2];
						ad4[3 - 1] = doublew1.val;
						dlarfg_adapter(3, ad4, 1 - 1, ad4, 2 - 1, 1, doublew3);
						ad4[1 - 1] = 1.0D;
						double d7 = ad[(k2 - 1) + (k2 - 1) * k + j];
						Dlarfx.dlarfx("L", 3, 3, ad4, 0, doublew3.val, ad3, 0,
								4, ad2, i2);
						Dlarfx.dlarfx("R", 3, 3, ad4, 0, doublew3.val, ad3, 0,
								4, ad2, i2);
						if (Util.max(Math.abs(ad3[(2 - 1) + (1 - 1) * 4]),
								Math.abs(ad3[(3 - 1) + (1 - 1) * 4]),
								Math.abs(ad3[(1 - 1) + (1 - 1) * 4] - d7)) > d8)
							break label0;
						Dlarfx.dlarfx("R", k2, 3, ad4, 0, doublew3.val, ad,
								(1 - 1) + (j1 - 1) * k + j, k, ad2, i2);
						Dlarfx.dlarfx("L", 3, i - j1, ad4, 0, doublew3.val, ad,
								(j1 - 1) + (j2 - 1) * k + j, k, ad2, i2);
						ad[(j1 - 1) + (j1 - 1) * k + j] = d7;
						ad[(j2 - 1) + (j1 - 1) * k + j] = 0.0D;
						ad[(k2 - 1) + (j1 - 1) * k + j] = 0.0D;
						if (flag)
							Dlarfx.dlarfx("R", i, 3, ad4, 0, doublew3.val, ad1,
									(1 - 1) + (j1 - 1) * i1 + l, i1, ad2, i2);
						break label2;
					}
					ad5[1 - 1] = -ad7[(1 - 1) + (1 - 1) * 2];
					ad5[2 - 1] = -ad7[(2 - 1) + (1 - 1) * 2];
					ad5[3 - 1] = doublew1.val;
					dlarfg_adapter(3, ad5, 1 - 1, ad5, 2 - 1, 1, doublew4);
					ad5[1 - 1] = 1.0D;
					doublew6.val = -(doublew4.val * (ad7[(1 - 1) + (2 - 1) * 2] + ad5[2 - 1]
							* ad7[(2 - 1) + (2 - 1) * 2]));
					ad6[1 - 1] = -(doublew6.val * ad5[2 - 1])
							- ad7[(2 - 1) + (2 - 1) * 2];
					ad6[2 - 1] = -(doublew6.val * ad5[3 - 1]);
					ad6[3 - 1] = doublew1.val;
					dlarfg_adapter(3, ad6, 1 - 1, ad6, 2 - 1, 1, doublew5);
					ad6[1 - 1] = 1.0D;
					Dlarfx.dlarfx("L", 3, 4, ad5, 0, doublew4.val, ad3, 0, 4,
							ad2, i2);
					Dlarfx.dlarfx("R", 4, 3, ad5, 0, doublew4.val, ad3, 0, 4,
							ad2, i2);
					Dlarfx.dlarfx("L", 3, 4, ad6, 0, doublew5.val, ad3, (2 - 1)
							+ (1 - 1) * 4, 4, ad2, i2);
					Dlarfx.dlarfx("R", 4, 3, ad6, 0, doublew5.val, ad3, (1 - 1)
							+ (2 - 1) * 4, 4, ad2, i2);
					if (Math.max(
							Util.max(Math.abs(ad3[(3 - 1) + (1 - 1) * 4]),
									Math.abs(ad3[(3 - 1) + (2 - 1) * 4]),
									Math.abs(ad3[(4 - 1) + (1 - 1) * 4])),
							Math.abs(ad3[(4 - 1) + (2 - 1) * 4])) > d8)
						break label0;
					Dlarfx.dlarfx("L", 3, (i - j1) + 1, ad5, 0, doublew4.val,
							ad, (j1 - 1) + (j1 - 1) * k + j, k, ad2, i2);
					Dlarfx.dlarfx("R", i3, 3, ad5, 0, doublew4.val, ad, (1 - 1)
							+ (j1 - 1) * k + j, k, ad2, i2);
					Dlarfx.dlarfx("L", 3, (i - j1) + 1, ad6, 0, doublew5.val,
							ad, (j2 - 1) + (j1 - 1) * k + j, k, ad2, i2);
					Dlarfx.dlarfx("R", i3, 3, ad6, 0, doublew5.val, ad, (1 - 1)
							+ (j2 - 1) * k + j, k, ad2, i2);
					ad[(k2 - 1) + (j1 - 1) * k + j] = 0.0D;
					ad[(k2 - 1) + (j2 - 1) * k + j] = 0.0D;
					ad[(i3 - 1) + (j1 - 1) * k + j] = 0.0D;
					ad[(i3 - 1) + (j2 - 1) * k + j] = 0.0D;
					if (flag) {
						Dlarfx.dlarfx("R", i, 3, ad5, 0, doublew4.val, ad1,
								(1 - 1) + (j1 - 1) * i1 + l, i1, ad2, i2);
						Dlarfx.dlarfx("R", i, 3, ad6, 0, doublew5.val, ad1,
								(1 - 1) + (j2 - 1) * i1 + l, i1, ad2, i2);
					}
				}
				if (l1 == 2) {
					dlanv2_adapter(ad, (j1 - 1) + (j1 - 1) * k + j, ad,
							(j1 - 1) + (j2 - 1) * k + j, ad, (j2 - 1)
									+ (j1 - 1) * k + j, ad, (j2 - 1) + (j2 - 1)
									* k + j, doublew9, doublew7, doublew10,
							doublew8, doublew, doublew2);
					Drot.drot(i - j1 - 1, ad,
							(j1 - 1) + ((j1 + 2) - 1) * k + j, k, ad, (j2 - 1)
									+ ((j1 + 2) - 1) * k + j, k, doublew.val,
							doublew2.val);
					Drot.drot(j1 - 1, ad, (1 - 1) + (j1 - 1) * k + j, 1, ad,
							(1 - 1) + (j2 - 1) * k + j, 1, doublew.val,
							doublew2.val);
					if (flag)
						Drot.drot(i, ad1, (1 - 1) + (j1 - 1) * i1 + l, 1, ad1,
								(1 - 1) + (j2 - 1) * i1 + l, 1, doublew.val,
								doublew2.val);
				}
				if (k1 == 2) {
					int l2 = j1 + l1;
					int j3 = l2 + 1;
					dlanv2_adapter(ad, (l2 - 1) + (l2 - 1) * k + j, ad,
							(l2 - 1) + (j3 - 1) * k + j, ad, (j3 - 1)
									+ (l2 - 1) * k + j, ad, (j3 - 1) + (j3 - 1)
									* k + j, doublew9, doublew7, doublew10,
							doublew8, doublew, doublew2);
					if (l2 + 2 <= i)
						Drot.drot(i - l2 - 1, ad, (l2 - 1) + ((l2 + 2) - 1) * k
								+ j, k, ad, (j3 - 1) + ((l2 + 2) - 1) * k + j,
								k, doublew.val, doublew2.val);
					Drot.drot(l2 - 1, ad, (1 - 1) + (l2 - 1) * k + j, 1, ad,
							(1 - 1) + (j3 - 1) * k + j, 1, doublew.val,
							doublew2.val);
					if (flag)
						Drot.drot(i, ad1, (1 - 1) + (l2 - 1) * i1 + l, 1, ad1,
								(1 - 1) + (j3 - 1) * i1 + l, 1, doublew.val,
								doublew2.val);
				}
			}
			return;
		}
		intw.val = 1;
	}

	private static void dlarfg_adapter(int i, double ad[], int j, double ad1[],
			int k, int l, doubleW doublew) {
		doubleW doublew1 = new doubleW(ad[j]);
		Dlarfg.dlarfg(i, doublew1, ad1, k, l, doublew);
		ad[j] = doublew1.val;
	}

	private static void dlanv2_adapter(double ad[], int i, double ad1[], int j,
			double ad2[], int k, double ad3[], int l, doubleW doublew,
			doubleW doublew1, doubleW doublew2, doubleW doublew3,
			doubleW doublew4, doubleW doublew5) {
		doubleW doublew6 = new doubleW(ad[i]);
		doubleW doublew7 = new doubleW(ad1[j]);
		doubleW doublew8 = new doubleW(ad2[k]);
		doubleW doublew9 = new doubleW(ad3[l]);
		Dlanv2.dlanv2(doublew6, doublew7, doublew8, doublew9, doublew,
				doublew1, doublew2, doublew3, doublew4, doublew5);
		ad[i] = doublew6.val;
		ad1[j] = doublew7.val;
		ad2[k] = doublew8.val;
		ad3[l] = doublew9.val;
	}
}

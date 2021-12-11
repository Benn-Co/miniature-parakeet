package org.netlib.lapack;

import org.netlib.blas.Dcopy;
import org.netlib.blas.Dgemm;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dlaqr2 {
	public static void dlaqr2(boolean flag, boolean flag1, int i, int j, int k,
			int l, double ad[], int i1, int j1, int k1, int l1, double ad1[],
			int i2, int j2, intW intw, intW intw1, double ad2[], int k2,
			double ad3[], int l2, double ad4[], int i3, int j3, int k3,
			double ad5[], int l3, int i4, int j4, double ad6[], int k4, int l4,
			double ad7[], int i5, int j5) {
		doubleW doublew = new doubleW(0.0D);
		doubleW doublew1 = new doubleW(0.0D);
		doubleW doublew2 = new doubleW(0.0D);
		doubleW doublew3 = new doubleW(0.0D);
		doubleW doublew4 = new doubleW(0.0D);
		doubleW doublew5 = new doubleW(0.0D);
		double d7 = 0.0D;
		doubleW doublew6 = new doubleW(0.0D);
		doubleW doublew7 = new doubleW(0.0D);
		double d8 = 0.0D;
		doubleW doublew8 = new doubleW(0.0D);
		doubleW doublew9 = new doubleW(0.0D);
		double d9 = 0.0D;
		int k5 = 0;
		intW intw2 = new intW(0);
		intW intw3 = new intW(0);
		intW intw4 = new intW(0);
		intW intw5 = new intW(0);
		int l5 = 0;
		int i6 = 0;
		int j8 = 0;
		int j9 = 0;
		i6 = Math.min(l, (k - j) + 1);
		if (i6 <= 2) {
			j9 = 1;
		} else {
			Dgehrd.dgehrd(i6, 1, i6 - 1, ad5, l3, i4, ad7, i5, ad7, i5, -1,
					intw4);
			int l8 = (int) ad7[(1 - 1) + i5];
			Dorghr.dorghr(i6, 1, i6 - 1, ad5, l3, i4, ad7, i5, ad7, i5, -1,
					intw4);
			int i9 = (int) ad7[(1 - 1) + i5];
			j9 = i6 + Math.max(l8, i9);
		}
		if (j5 == -1) {
			ad7[(1 - 1) + i5] = j9;
			return;
		}
		intw.val = 0;
		intw1.val = 0;
		if (j > k)
			return;
		if (l < 1)
			return;
		doublew7.val = Dlamch.dlamch("SAFE MINIMUM");
		doublew6.val = 1.0D / doublew7.val;
		Dlabad.dlabad(doublew7, doublew6);
		d9 = Dlamch.dlamch("PRECISION");
		d8 = doublew7.val * (i / d9);
		i6 = Math.min(l, (k - j) + 1);
		j8 = (k - i6) + 1;
		if (j8 == j)
			d7 = 0.0D;
		else
			d7 = ad[(j8 - 1) + (j8 - 1 - 1) * j1 + i1];
		if (k == j8) {
			ad2[(j8 - 1) + k2] = ad[(j8 - 1) + (j8 - 1) * j1 + i1];
			ad3[(j8 - 1) + l2] = 0.0D;
			intw.val = 1;
			intw1.val = 0;
			if (Math.abs(d7) <= Math.max(d8,
					d9 * Math.abs(ad[(j8 - 1) + (j8 - 1) * j1 + i1]))) {
				intw.val = 0;
				intw1.val = 1;
				if (j8 > j)
					ad[(j8 - 1) + (j8 - 1 - 1) * j1 + i1] = 0.0D;
			}
			return;
		}
		Dlacpy.dlacpy("U", i6, i6, ad, (j8 - 1) + (j8 - 1) * j1 + i1, j1, ad5,
				l3, i4);
		Dcopy.dcopy(i6 - 1, ad, ((j8 + 1) - 1) + (j8 - 1) * j1 + i1, j1 + 1,
				ad5, (2 - 1) + (1 - 1) * i4 + l3, i4 + 1);
		Dlaset.dlaset("A", i6, i6, 0.0D, 1.0D, ad4, i3, j3);
		Dlahqr.dlahqr(true, true, i6, 1, i6, ad5, l3, i4, ad2, (j8 - 1) + k2,
				ad3, (j8 - 1) + l2, 1, i6, ad4, i3, j3, intw5);
		l5 = 1;
		for (int k9 = (i6 - 3 - 1) + 1; k9 > 0; k9--) {
			ad5[((l5 + 2) - 1) + (l5 - 1) * i4 + l3] = 0.0D;
			ad5[((l5 + 3) - 1) + (l5 - 1) * i4 + l3] = 0.0D;
			l5++;
		}

		if (i6 > 2)
			ad5[(i6 - 1) + (i6 - 2 - 1) * i4 + l3] = 0.0D;
		intw.val = i6;
		intw3.val = intw5.val + 1;
		while (intw3.val > intw.val) {
			boolean flag11;
			if (intw.val == 1)
				flag11 = false;
			else
				flag11 = ad5[(intw.val - 1) + (intw.val - 1 - 1) * i4 + l3] != 0.0D;
			if (flag11 ^ true) {
				double d5 = Math.abs(ad5[(intw.val - 1) + (intw.val - 1) * i4
						+ l3]);
				if (d5 == 0.0D)
					d5 = Math.abs(d7);
				if (Math.abs(d7 * ad4[(1 - 1) + (intw.val - 1) * j3 + i3]) <= Math
						.max(d8, d9 * d5)) {
					intw.val = intw.val - 1;
				} else {
					intw2.val = intw.val;
					Dtrexc.dtrexc("V", i6, ad5, l3, i4, ad4, i3, j3, intw2,
							intw3, ad7, i5, intw4);
					intw3.val = intw3.val + 1;
				}
			} else {
				double d6 = Math.abs(ad5[(intw.val - 1) + (intw.val - 1) * i4
						+ l3])
						+ Math.sqrt(Math.abs(ad5[(intw.val - 1)
								+ (intw.val - 1 - 1) * i4 + l3]))
						* Math.sqrt(Math.abs(ad5[(intw.val - 1 - 1)
								+ (intw.val - 1) * i4 + l3]));
				if (d6 == 0.0D)
					d6 = Math.abs(d7);
				if (Math.max(
						Math.abs(d7 * ad4[(1 - 1) + (intw.val - 1) * j3 + i3]),
						Math.abs(d7
								* ad4[(1 - 1) + (intw.val - 1 - 1) * j3 + i3])) <= Math
						.max(d8, d9 * d6)) {
					intw.val = intw.val - 2;
				} else {
					intw2.val = intw.val;
					Dtrexc.dtrexc("V", i6, ad5, l3, i4, ad4, i3, j3, intw2,
							intw3, ad7, i5, intw4);
					intw3.val = intw3.val + 2;
				}
			}
		}
		if (intw.val == 0)
			d7 = 0.0D;
		if (intw.val < i6) {
			boolean flag13 = false;
			k5 = intw.val + 1;
			while (!flag13) {
				flag13 = true;
				int l6 = k5 - 1;
				k5 = intw5.val + 1;
				int j6;
				if (k5 == intw.val)
					j6 = k5 + 1;
				else if (ad5[((k5 + 1) - 1) + (k5 - 1) * i4 + l3] == 0.0D)
					j6 = k5 + 1;
				else
					j6 = k5 + 2;
				while (j6 <= l6) {
					double d1;
					if (j6 == k5 + 1)
						d1 = Math.abs(ad5[(k5 - 1) + (k5 - 1) * i4 + l3]);
					else
						d1 = Math.abs(ad5[(k5 - 1) + (k5 - 1) * i4 + l3])
								+ Math.sqrt(Math.abs(ad5[((k5 + 1) - 1)
										+ (k5 - 1) * i4 + l3]))
								* Math.sqrt(Math.abs(ad5[(k5 - 1)
										+ ((k5 + 1) - 1) * i4 + l3]));
					double d3;
					if (j6 == l6)
						d3 = Math.abs(ad5[(j6 - 1) + (j6 - 1) * i4 + l3]);
					else if (ad5[((j6 + 1) - 1) + (j6 - 1) * i4 + l3] == 0.0D)
						d3 = Math.abs(ad5[(j6 - 1) + (j6 - 1) * i4 + l3]);
					else
						d3 = Math.abs(ad5[(j6 - 1) + (j6 - 1) * i4 + l3])
								+ Math.sqrt(Math.abs(ad5[((j6 + 1) - 1)
										+ (j6 - 1) * i4 + l3]))
								* Math.sqrt(Math.abs(ad5[(j6 - 1)
										+ ((j6 + 1) - 1) * i4 + l3]));
					if (d1 >= d3) {
						k5 = j6;
					} else {
						flag13 = false;
						intw2.val = k5;
						intw3.val = j6;
						Dtrexc.dtrexc("V", i6, ad5, l3, i4, ad4, i3, j3, intw2,
								intw3, ad7, i5, intw4);
						if (intw4.val == 0)
							k5 = intw3.val;
						else
							k5 = j6;
					}
					if (k5 == l6)
						j6 = k5 + 1;
					else if (ad5[((k5 + 1) - 1) + (k5 - 1) * i4 + l3] == 0.0D)
						j6 = k5 + 1;
					else
						j6 = k5 + 2;
				}
			}
		}
		k5 = i6;
		while (k5 < intw5.val + 1)
			if (k5 == intw5.val + 1) {
				ad2[((j8 + k5) - 1 - 1) + k2] = ad5[(k5 - 1) + (k5 - 1) * i4
						+ l3];
				ad3[((j8 + k5) - 1 - 1) + l2] = 0.0D;
				k5--;
			} else if (ad5[(k5 - 1) + (k5 - 1 - 1) * i4 + l3] == 0.0D) {
				ad2[((j8 + k5) - 1 - 1) + k2] = ad5[(k5 - 1) + (k5 - 1) * i4
						+ l3];
				ad3[((j8 + k5) - 1 - 1) + l2] = 0.0D;
				k5--;
			} else {
				doublew.val = ad5[(k5 - 1 - 1) + (k5 - 1 - 1) * i4 + l3];
				doublew3.val = ad5[(k5 - 1) + (k5 - 1 - 1) * i4 + l3];
				doublew1.val = ad5[(k5 - 1 - 1) + (k5 - 1) * i4 + l3];
				doublew5.val = ad5[(k5 - 1) + (k5 - 1) * i4 + l3];
				dlanv2_adapter(doublew, doublew1, doublew3, doublew5, ad2,
						((j8 + k5) - 2 - 1) + k2, ad3,
						((j8 + k5) - 2 - 1) + l2, ad2,
						((j8 + k5) - 1 - 1) + k2, ad3,
						((j8 + k5) - 1 - 1) + l2, doublew4, doublew8);
				k5 -= 2;
			}
		if ((intw.val < i6) || (d7 == 0.0D)) {
			if ((intw.val > 1) && (d7 != 0.0D)) {
				Dcopy.dcopy(intw.val, ad4, i3, j3, ad7, i5, 1);
				doublew2.val = ad7[(1 - 1) + i5];
				Dlarfg.dlarfg(intw.val, doublew2, ad7, (2 - 1) + i5, 1,
						doublew9);
				ad7[(1 - 1) + i5] = 1.0D;
				Dlaset.dlaset("L", i6 - 2, i6 - 2, 0.0D, 0.0D, ad5, (3 - 1)
						+ (1 - 1) * i4 + l3, i4);
				Dlarf.dlarf("L", intw.val, i6, ad7, i5, 1, doublew9.val, ad5,
						l3, i4, ad7, ((i6 + 1) - 1) + i5);
				Dlarf.dlarf("R", intw.val, intw.val, ad7, i5, 1, doublew9.val,
						ad5, l3, i4, ad7, ((i6 + 1) - 1) + i5);
				Dlarf.dlarf("R", i6, intw.val, ad7, i5, 1, doublew9.val, ad4,
						i3, j3, ad7, ((i6 + 1) - 1) + i5);
				Dgehrd.dgehrd(i6, 1, intw.val, ad5, l3, i4, ad7, i5, ad7,
						((i6 + 1) - 1) + i5, j5 - i6, intw4);
			}
			if (j8 > 1)
				ad[(j8 - 1) + (j8 - 1 - 1) * j1 + i1] = d7
						* ad4[(1 - 1) + (1 - 1) * j3 + i3];
			Dlacpy.dlacpy("U", i6, i6, ad5, l3, i4, ad, (j8 - 1) + (j8 - 1)
					* j1 + i1, j1);
			Dcopy.dcopy(i6 - 1, ad5, (2 - 1) + (1 - 1) * i4 + l3, i4 + 1, ad,
					((j8 + 1) - 1) + (j8 - 1) * j1 + i1, j1 + 1);
			if ((intw.val > 1) && (d7 != 0.0D)) {
				Dorghr.dorghr(i6, 1, intw.val, ad5, l3, i4, ad7, i5, ad7,
						((i6 + 1) - 1) + i5, j5 - i6, intw4);
				Dgemm.dgemm("N", "N", i6, intw.val, intw.val, 1.0D, ad4, i3,
						j3, ad5, l3, i4, 0.0D, ad6, k4, l4);
				Dlacpy.dlacpy("A", i6, intw.val, ad6, k4, l4, ad4, i3, j3);
			}
			int k8;
			if (flag)
				k8 = 1;
			else
				k8 = j;
			int l7 = k8;
			for (int l9 = ((j8 - 1 - k8) + j4) / j4; l9 > 0; l9--) {
				int i7 = Math.min(j4, j8 - l7);
				Dgemm.dgemm("N", "N", i7, i6, i6, 1.0D, ad, (l7 - 1) + (j8 - 1)
						* j1 + i1, j1, ad4, i3, j3, 0.0D, ad6, k4, l4);
				Dlacpy.dlacpy("A", i7, i6, ad6, k4, l4, ad, (l7 - 1) + (j8 - 1)
						* j1 + i1, j1);
				l7 += j4;
			}

			if (flag) {
				int k6 = k + 1;
				for (int i10 = ((i - (k + 1)) + k3) / k3; i10 > 0; i10--) {
					int j7 = Math.min(k3, (i - k6) + 1);
					Dgemm.dgemm("C", "N", i6, j7, i6, 1.0D, ad4, i3, j3, ad,
							(j8 - 1) + (k6 - 1) * j1 + i1, j1, 0.0D, ad5, l3,
							i4);
					Dlacpy.dlacpy("A", i6, j7, ad5, l3, i4, ad, (j8 - 1)
							+ (k6 - 1) * j1 + i1, j1);
					k6 += k3;
				}

			}
			if (flag1) {
				int i8 = k1;
				for (int j10 = ((l1 - k1) + j4) / j4; j10 > 0; j10--) {
					int k7 = Math.min(j4, (l1 - i8) + 1);
					Dgemm.dgemm("N", "N", k7, i6, i6, 1.0D, ad1, (i8 - 1)
							+ (j8 - 1) * j2 + i2, j2, ad4, i3, j3, 0.0D, ad6,
							k4, l4);
					Dlacpy.dlacpy("A", k7, i6, ad6, k4, l4, ad1, (i8 - 1)
							+ (j8 - 1) * j2 + i2, j2);
					i8 += j4;
				}

			}
		}
		intw1.val = i6 - intw.val;
		intw.val = intw.val - intw5.val;
		ad7[(1 - 1) + i5] = j9;
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

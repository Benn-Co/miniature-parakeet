package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dgebd2 {
	public static void dgebd2(int i, int j, double ad[], int k, int l,
			double ad1[], int i1, double ad2[], int j1, double ad3[], int k1,
			double ad4[], int l1, double ad5[], int i2, intW intw) {
		intw.val = 0;
		if (i < 0)
			intw.val = -1;
		else if (j < 0)
			intw.val = -2;
		else if (l < Math.max(1, i))
			intw.val = -4;
		if (intw.val < 0) {
			Xerbla.xerbla("DGEBD2", -intw.val);
			return;
		}
		if (i >= j) {
			int j2 = 1;
			for (int l2 = (j - 1) + 1; l2 > 0; l2--) {
				dlarfg_adapter((i - j2) + 1, ad, (j2 - 1) + (j2 - 1) * l + k,
						ad, (Math.min(j2 + 1, i) - 1) + (j2 - 1) * l + k, 1,
						ad3, (j2 - 1) + k1);
				ad1[(j2 - 1) + i1] = ad[(j2 - 1) + (j2 - 1) * l + k];
				ad[(j2 - 1) + (j2 - 1) * l + k] = 1.0D;
				if (j2 < j)
					Dlarf.dlarf("Left", (i - j2) + 1, j - j2, ad, (j2 - 1)
							+ (j2 - 1) * l + k, 1, ad3[(j2 - 1) + k1], ad,
							(j2 - 1) + ((j2 + 1) - 1) * l + k, l, ad5, i2);
				ad[(j2 - 1) + (j2 - 1) * l + k] = ad1[(j2 - 1) + i1];
				if (j2 < j) {
					dlarfg_adapter(j - j2, ad, (j2 - 1) + ((j2 + 1) - 1) * l
							+ k, ad, (j2 - 1) + (Math.min(j2 + 2, j) - 1) * l
							+ k, l, ad4, (j2 - 1) + l1);
					ad2[(j2 - 1) + j1] = ad[(j2 - 1) + ((j2 + 1) - 1) * l + k];
					ad[(j2 - 1) + ((j2 + 1) - 1) * l + k] = 1.0D;
					Dlarf.dlarf("Right", i - j2, j - j2, ad, (j2 - 1)
							+ ((j2 + 1) - 1) * l + k, l, ad4[(j2 - 1) + l1],
							ad, ((j2 + 1) - 1) + ((j2 + 1) - 1) * l + k, l,
							ad5, i2);
					ad[(j2 - 1) + ((j2 + 1) - 1) * l + k] = ad2[(j2 - 1) + j1];
				} else {
					ad4[(j2 - 1) + l1] = 0.0D;
				}
				j2++;
			}

		} else {
			int k2 = 1;
			for (int i3 = (i - 1) + 1; i3 > 0; i3--) {
				dlarfg_adapter((j - k2) + 1, ad, (k2 - 1) + (k2 - 1) * l + k,
						ad, (k2 - 1) + (Math.min(k2 + 1, j) - 1) * l + k, l,
						ad4, (k2 - 1) + l1);
				ad1[(k2 - 1) + i1] = ad[(k2 - 1) + (k2 - 1) * l + k];
				ad[(k2 - 1) + (k2 - 1) * l + k] = 1.0D;
				if (k2 < i)
					Dlarf.dlarf("Right", i - k2, (j - k2) + 1, ad, (k2 - 1)
							+ (k2 - 1) * l + k, l, ad4[(k2 - 1) + l1], ad,
							((k2 + 1) - 1) + (k2 - 1) * l + k, l, ad5, i2);
				ad[(k2 - 1) + (k2 - 1) * l + k] = ad1[(k2 - 1) + i1];
				if (k2 < i) {
					dlarfg_adapter(i - k2, ad, ((k2 + 1) - 1) + (k2 - 1) * l
							+ k, ad, (Math.min(k2 + 2, i) - 1) + (k2 - 1) * l
							+ k, 1, ad3, (k2 - 1) + k1);
					ad2[(k2 - 1) + j1] = ad[((k2 + 1) - 1) + (k2 - 1) * l + k];
					ad[((k2 + 1) - 1) + (k2 - 1) * l + k] = 1.0D;
					Dlarf.dlarf("Left", i - k2, j - k2, ad, ((k2 + 1) - 1)
							+ (k2 - 1) * l + k, 1, ad3[(k2 - 1) + k1], ad,
							((k2 + 1) - 1) + ((k2 + 1) - 1) * l + k, l, ad5, i2);
					ad[((k2 + 1) - 1) + (k2 - 1) * l + k] = ad2[(k2 - 1) + j1];
				} else {
					ad3[(k2 - 1) + k1] = 0.0D;
				}
				k2++;
			}

		}
	}

	private static void dlarfg_adapter(int i, double ad[], int j, double ad1[],
			int k, int l, double ad2[], int i1) {
		doubleW doublew = new doubleW(ad[j]);
		doubleW doublew1 = new doubleW(ad2[i1]);
		Dlarfg.dlarfg(i, doublew, ad1, k, l, doublew1);
		ad[j] = doublew.val;
		ad2[i1] = doublew1.val;
	}
}

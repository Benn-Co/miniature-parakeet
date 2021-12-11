package org.netlib.lapack;

import org.netlib.blas.Dscal;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dorgr2 {
	public static void dorgr2(int i, int j, int k, double ad[], int l, int i1,
			double ad1[], int j1, double ad2[], int k1, intW intw) {
		int l1 = 0;
		intw.val = 0;
		if (i < 0)
			intw.val = -1;
		else if (j < i)
			intw.val = -2;
		else if ((k < 0) || (k > i))
			intw.val = -3;
		else if (i1 < Math.max(1, i))
			intw.val = -5;
		if (intw.val != 0) {
			Xerbla.xerbla("DORGR2", -intw.val);
			return;
		}
		if (i <= 0)
			return;
		if (k < i) {
			int j2 = 1;
			for (int i3 = (j - 1) + 1; i3 > 0; i3--) {
				int k2 = 1;
				for (int k3 = (i - k - 1) + 1; k3 > 0; k3--) {
					ad[(k2 - 1) + (j2 - 1) * i1 + l] = 0.0D;
					k2++;
				}

				if ((j2 > j - i) && (j2 <= j - k))
					ad[(((i - j) + j2) - 1) + (j2 - 1) * i1 + l] = 1.0D;
				j2++;
			}

		}
		l1 = 1;
		for (int j3 = (k - 1) + 1; j3 > 0; j3--) {
			int i2 = (i - k) + l1;
			ad[(i2 - 1) + (((j - i) + i2) - 1) * i1 + l] = 1.0D;
			Dlarf.dlarf("Right", i2 - 1, (j - i) + i2, ad, (i2 - 1) + (1 - 1)
					* i1 + l, i1, ad1[(l1 - 1) + j1], ad, l, i1, ad2, k1);
			Dscal.dscal(((j - i) + i2) - 1, -ad1[(l1 - 1) + j1], ad, (i2 - 1)
					+ (1 - 1) * i1 + l, i1);
			ad[(i2 - 1) + (((j - i) + i2) - 1) * i1 + l] = 1.0D - ad1[(l1 - 1)
					+ j1];
			int l2 = (j - i) + i2 + 1;
			for (int l3 = (j - ((j - i) + i2 + 1)) + 1; l3 > 0; l3--) {
				ad[(i2 - 1) + (l2 - 1) * i1 + l] = 0.0D;
				l2++;
			}

			l1++;
		}
	}
}

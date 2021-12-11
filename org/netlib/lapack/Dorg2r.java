package org.netlib.lapack;

import org.netlib.blas.Dscal;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dorg2r {
	public static void dorg2r(int i, int j, int k, double ad[], int l, int i1,
			double ad1[], int j1, double ad2[], int k1, intW intw) {
		int l1 = 0;
		int i2 = 0;
		intw.val = 0;
		if (i < 0)
			intw.val = -1;
		else if ((j < 0) || (j > i))
			intw.val = -2;
		else if ((k < 0) || (k > j))
			intw.val = -3;
		else if (i1 < Math.max(1, i))
			intw.val = -5;
		if (intw.val != 0) {
			Xerbla.xerbla("DORG2R", -intw.val);
			return;
		}
		if (j <= 0)
			return;
		i2 = k + 1;
		for (int l2 = (j - (k + 1)) + 1; l2 > 0; l2--) {
			int j2 = 1;
			for (int j3 = i; j3 > 0; j3--) {
				ad[(j2 - 1) + (i2 - 1) * i1 + l] = 0.0;
				j2++;
			}

			ad[(i2 - 1) + (i2 - 1) * i1 + l] = 1.0;
			i2++;
		}

		l1 = k;
		for (int i3 = ((1 - k) + -1) / -1; i3 > 0; i3--) {
			if (l1 < j) {
				ad[(l1 - 1) + (l1 - 1) * i1 + l] = 1.0;
				Dlarf.dlarf("Left", (i - l1) + 1, j - l1, ad, (l1 - 1)
						+ (l1 - 1) * i1 + l, 1, ad1[(l1 - 1) + j1], ad,
						(l1 - 1) + ((l1 + 1) - 1) * i1 + l, i1, ad2, k1);
			}
			if (l1 < i)
				Dscal.dscal(i - l1, -ad1[(l1 - 1) + j1], ad, ((l1 + 1) - 1)
						+ (l1 - 1) * i1 + l, 1);
			ad[(l1 - 1) + (l1 - 1) * i1 + l] = 1.0 - ad1[(l1 - 1) + j1];
			int k2 = 1;
			for (int k3 = l1 - 1; k3 > 0; k3--) {
				ad[(k2 - 1) + (l1 - 1) * i1 + l] = 0.0;
				k2++;
			}

			l1--;
		}
	}
}

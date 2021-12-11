package org.netlib.lapack;

import org.netlib.blas.Dger;
import org.netlib.blas.Dscal;
import org.netlib.blas.Dswap;
import org.netlib.blas.Idamax;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgbtf2 {
	public static void dgbtf2(int i, int j, int k, int l, double ad[], int i1,
			int j1, int ai[], int k1, intW intw) {
		int j2 = 0;
		int l2 = 0;
		int j3 = 0;
		j3 = l + k;
		intw.val = 0;
		if (i < 0)
			intw.val = -1;
		else if (j < 0)
			intw.val = -2;
		else if (k < 0)
			intw.val = -3;
		else if (l < 0)
			intw.val = -4;
		else if (j1 < k + j3 + 1)
			intw.val = -6;
		if (intw.val != 0) {
			Xerbla.xerbla("DGBTF2", -intw.val);
			return;
		}
		if ((i == 0) || (j == 0))
			return;
		j2 = l + 2;
		for (int k3 = (Math.min(j3, j) - (l + 2)) + 1; k3 > 0; k3--) {
			int l1 = (j3 - j2) + 2;
			for (int i4 = (k - ((j3 - j2) + 2)) + 1; i4 > 0; i4--) {
				ad[(l1 - 1) + (j2 - 1) * j1 + i1] = 0.0D;
				l1++;
			}

			j2++;
		}

		l2 = 1;
		j2 = 1;
		for (int l3 = (Math.min(i, j) - 1) + 1; l3 > 0; l3--) {
			if (j2 + j3 <= j) {
				int i2 = 1;
				for (int j4 = (k - 1) + 1; j4 > 0; j4--) {
					ad[(i2 - 1) + ((j2 + j3) - 1) * j1 + i1] = 0.0D;
					i2++;
				}

			}
			int i3 = Math.min(k, i - j2);
			int k2 = Idamax.idamax(i3 + 1, ad, ((j3 + 1) - 1) + (j2 - 1) * j1
					+ i1, 1);
			ai[(j2 - 1) + k1] = (k2 + j2) - 1;
			if (ad[((j3 + k2) - 1) + (j2 - 1) * j1 + i1] != 0.0D) {
				l2 = Math.max(l2, Math.min((j2 + l + k2) - 1, j));
				if (k2 != 1)
					Dswap.dswap((l2 - j2) + 1, ad, ((j3 + k2) - 1) + (j2 - 1)
							* j1 + i1, j1 - 1, ad, ((j3 + 1) - 1) + (j2 - 1)
							* j1 + i1, j1 - 1);
				if (i3 > 0) {
					Dscal.dscal(i3, 1.0D / ad[((j3 + 1) - 1) + (j2 - 1) * j1
							+ i1], ad, ((j3 + 2) - 1) + (j2 - 1) * j1 + i1, 1);
					if (l2 > j2)
						Dger.dger(i3, l2 - j2, -1D, ad, ((j3 + 2) - 1)
								+ (j2 - 1) * j1 + i1, 1, ad, (j3 - 1)
								+ ((j2 + 1) - 1) * j1 + i1, j1 - 1, ad,
								((j3 + 1) - 1) + ((j2 + 1) - 1) * j1 + i1,
								j1 - 1);
				}
			} else if (intw.val == 0)
				intw.val = j2;
			j2++;
		}

	}
}

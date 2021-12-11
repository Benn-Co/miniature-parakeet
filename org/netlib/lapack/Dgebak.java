package org.netlib.lapack;

import org.netlib.blas.Dscal;
import org.netlib.blas.Dswap;
import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgebak {
	public static void dgebak(String s, String s1, int i, int j, int k,
			double ad[], int l, int i1, double ad1[], int j1, int k1, intW intw) {
		boolean flag = false;
		boolean flag1 = false;
		flag1 = Lsame.lsame(s1, "R");
		flag = Lsame.lsame(s1, "L");
		intw.val = 0;
		if (((Lsame.lsame(s, "N") ^ true && Lsame.lsame(s, "P") ^ true) && Lsame
				.lsame(s, "S") ^ true) && Lsame.lsame(s, "B") ^ true)
			intw.val = -1;
		else if (flag1 ^ true && flag ^ true)
			intw.val = -2;
		else if (i < 0)
			intw.val = -3;
		else if ((j < 1) || (j > Math.max(1, i)))
			intw.val = -4;
		else if ((k < Math.min(j, i)) || (k > i))
			intw.val = -5;
		else if (i1 < 0)
			intw.val = -7;
		else if (k1 < Math.max(1, i))
			intw.val = -9;
		if (intw.val != 0) {
			Xerbla.xerbla("DGEBAK", -intw.val);
			return;
		}
		if (i == 0)
			return;
		if (i1 == 0)
			return;
		if (Lsame.lsame(s, "N"))
			return;
		if ((j != k) && (Lsame.lsame(s, "S") || Lsame.lsame(s, "B"))) {
			if (flag1) {
				int l1 = j;
				for (int l3 = (k - j) + 1; l3 > 0; l3--) {
					double d1 = ad[(l1 - 1) + l];
					Dscal.dscal(i1, d1, ad1, (l1 - 1) + (1 - 1) * k1 + j1, k1);
					l1++;
				}

			}
			if (flag) {
				int i2 = j;
				for (int i4 = (k - j) + 1; i4 > 0; i4--) {
					double d2 = 1.0D / ad[(i2 - 1) + l];
					Dscal.dscal(i1, d2, ad1, (i2 - 1) + (1 - 1) * k1 + j1, k1);
					i2++;
				}

			}
		}
		if (Lsame.lsame(s, "P") || Lsame.lsame(s, "B")) {
			if (flag1) {
				int l2 = 1;
				for (int j4 = (i - 1) + 1; j4 > 0; j4--) {
					int j2 = l2;
					if ((j2 < j) || (j2 > k)) {
						if (j2 < j)
							j2 = j - l2;
						int j3 = (int) ad[(j2 - 1) + l];
						if (j3 != j2)
							Dswap.dswap(i1, ad1, (j2 - 1) + (1 - 1) * k1 + j1,
									k1, ad1, (j3 - 1) + (1 - 1) * k1 + j1, k1);
					}
					l2++;
				}

			}
			if (flag) {
				int i3 = 1;
				for (int k4 = (i - 1) + 1; k4 > 0; k4--) {
					int k2 = i3;
					if ((k2 < j) || (k2 > k)) {
						if (k2 < j)
							k2 = j - i3;
						int k3 = (int) ad[(k2 - 1) + l];
						if (k3 != k2)
							Dswap.dswap(i1, ad1, (k2 - 1) + (1 - 1) * k1 + j1,
									k1, ad1, (k3 - 1) + (1 - 1) * k1 + j1, k1);
					}
					i3++;
				}

			}
		}
	}
}

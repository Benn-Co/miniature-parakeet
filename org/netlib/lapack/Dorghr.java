package org.netlib.lapack;

import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dorghr {
	public static void dorghr(int i, int j, int k, double ad[], int l, int i1,
			double ad1[], int j1, double ad2[], int k1, int l1, intW intw) {
		boolean flag = false;
		intW intw1 = new intW(0);
		int l2 = 0;
		int i3 = 0;
		int k3 = 0;
		intw.val = 0;
		k3 = k - j;
		flag = l1 == -1;
		if (i < 0)
			intw.val = -1;
		else if ((j < 1) || (j > Math.max(1, i)))
			intw.val = -2;
		else if ((k < Math.min(j, i)) || (k > i))
			intw.val = -3;
		else if (i1 < Math.max(1, i))
			intw.val = -5;
		else if ((l1 < Math.max(1, k3)) && flag ^ true)
			intw.val = -8;
		if (intw.val == 0) {
			int j3 = 32;
			i3 = Math.max(1, k3) * j3;
			ad2[(1 - 1) + k1] = i3;
		}
		if (intw.val != 0) {
			Xerbla.xerbla("DORGHR", -intw.val);
			return;
		}
		if (flag)
			return;
		if (i == 0) {
			ad2[(1 - 1) + k1] = 1;
			return;
		}
		l2 = k;
		for (int l3 = (((j + 1) - k) + -1) / -1; l3 > 0; l3--) {
			int i2 = 1;
			for (int k4 = (l2 - 1 - 1) + 1; k4 > 0; k4--) {
				ad[(i2 - 1) + (l2 - 1) * i1 + l] = 0.0D;
				i2++;
			}

			i2 = l2 + 1;
			for (int l4 = (k - (l2 + 1)) + 1; l4 > 0; l4--) {
				ad[(i2 - 1) + (l2 - 1) * i1 + l] = ad[(i2 - 1) + (l2 - 1 - 1)
						* i1 + l];
				i2++;
			}

			i2 = k + 1;
			for (int i5 = (i - (k + 1)) + 1; i5 > 0; i5--) {
				ad[(i2 - 1) + (l2 - 1) * i1 + l] = 0.0D;
				i2++;
			}

			l2--;
		}

		l2 = 1;
		for (int i4 = (j - 1) + 1; i4 > 0; i4--) {
			int j2 = 1;
			for (int j5 = (i - 1) + 1; j5 > 0; j5--) {
				ad[(j2 - 1) + (l2 - 1) * i1 + l] = 0.0D;
				j2++;
			}

			ad[(l2 - 1) + (l2 - 1) * i1 + l] = 1.0D;
			l2++;
		}

		l2 = k + 1;
		for (int j4 = (i - (k + 1)) + 1; j4 > 0; j4--) {
			int k2 = 1;
			for (int k5 = (i - 1) + 1; k5 > 0; k5--) {
				ad[(k2 - 1) + (l2 - 1) * i1 + l] = 0.0D;
				k2++;
			}

			ad[(l2 - 1) + (l2 - 1) * i1 + l] = 1.0D;
			l2++;
		}

		if (k3 > 0)
			Dorgqr.dorgqr(k3, k3, k3, ad, ((j + 1) - 1) + ((j + 1) - 1) * i1
					+ l, i1, ad1, (j - 1) + j1, ad2, k1, l1, intw1);
		ad2[(1 - 1) + k1] = i3;
	}
}

package org.netlib.lapack;

import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dtrexc {
	public static void dtrexc(String s, int i, double ad[], int j, int k,
			double ad1[], int l, int i1, intW intw, intW intw1, double ad2[],
			int j1, intW intw2) {
		boolean flag = false;
		int k1 = 0;
		byte byte0 = 0;
		byte byte1 = 0;
		intw2.val = 0;
		flag = Lsame.lsame(s, "V");
		if (flag ^ true && Lsame.lsame(s, "N") ^ true)
			intw2.val = -1;
		else if (i < 0)
			intw2.val = -2;
		else if (k < Math.max(1, i))
			intw2.val = -4;
		else if ((i1 < 1) || (flag && (i1 < Math.max(1, i))))
			intw2.val = -6;
		else if ((intw.val < 1) || (intw.val > i))
			intw2.val = -7;
		else if ((intw1.val < 1) || (intw1.val > i))
			intw2.val = -8;
		if (intw2.val != 0) {
			Xerbla.xerbla("DTREXC", -intw2.val);
			return;
		}
		if (i <= 1)
			return;
		if ((intw.val > 1)
				&& (ad[(intw.val - 1) + (intw.val - 1 - 1) * k + j] != 0.0D))
			intw.val = intw.val - 1;
		byte0 = 1;
		if ((intw.val < i)
				&& (ad[((intw.val + 1) - 1) + (intw.val - 1) * k + j] != 0.0D))
			byte0 = 2;
		if ((intw1.val > 1)
				&& (ad[(intw1.val - 1) + (intw1.val - 1 - 1) * k + j] != 0.0D))
			intw1.val = intw1.val - 1;
		byte1 = 1;
		if ((intw1.val < i)
				&& (ad[((intw1.val + 1) - 1) + (intw1.val - 1) * k + j] != 0.0D))
			byte1 = 2;
		if (intw.val == intw1.val)
			return;
		if (intw.val < intw1.val) {
			if ((byte0 == 2) && (byte1 == 1))
				intw1.val = intw1.val - 1;
			if ((byte0 == 1) && (byte1 == 2))
				intw1.val = intw1.val + 1;
			k1 = intw.val;
			do
				if ((byte0 == 1) || (byte0 == 2)) {
					byte byte2 = 1;
					if ((k1 + byte0 + 1 <= i)
							&& (ad[((k1 + byte0 + 1) - 1) + ((k1 + byte0) - 1)
									* k + j] != 0.0D))
						byte2 = 2;
					Dlaexc.dlaexc(flag, i, ad, j, k, ad1, l, i1, k1, byte0,
							byte2, ad2, j1, intw2);
					if (intw2.val != 0) {
						intw1.val = k1;
						return;
					}
					k1 += byte2;
					if ((byte0 == 2)
							&& (ad[((k1 + 1) - 1) + (k1 - 1) * k + j] == 0.0D))
						byte0 = 3;
				} else {
					byte byte3 = 1;
					if ((k1 + 3 <= i)
							&& (ad[((k1 + 3) - 1) + ((k1 + 2) - 1) * k + j] != 0.0D))
						byte3 = 2;
					Dlaexc.dlaexc(flag, i, ad, j, k, ad1, l, i1, k1 + 1, 1,
							byte3, ad2, j1, intw2);
					if (intw2.val != 0) {
						intw1.val = k1;
						return;
					}
					if (byte3 == 1) {
						Dlaexc.dlaexc(flag, i, ad, j, k, ad1, l, i1, k1, 1,
								byte3, ad2, j1, intw2);
						k1++;
					} else {
						if (ad[((k1 + 2) - 1) + ((k1 + 1) - 1) * k + j] == 0.0D)
							byte3 = 1;
						if (byte3 == 2) {
							Dlaexc.dlaexc(flag, i, ad, j, k, ad1, l, i1, k1, 1,
									byte3, ad2, j1, intw2);
							if (intw2.val != 0) {
								intw1.val = k1;
								return;
							}
							k1 += 2;
						} else {
							Dlaexc.dlaexc(flag, i, ad, j, k, ad1, l, i1, k1, 1,
									1, ad2, j1, intw2);
							Dlaexc.dlaexc(flag, i, ad, j, k, ad1, l, i1,
									k1 + 1, 1, 1, ad2, j1, intw2);
							k1 += 2;
						}
					}
				}
			while (k1 < intw1.val);
		} else {
			k1 = intw.val;
			do
				if ((byte0 == 1) || (byte0 == 2)) {
					byte byte4 = 1;
					if ((k1 >= 3)
							&& (ad[(k1 - 1 - 1) + (k1 - 2 - 1) * k + j] != 0.0D))
						byte4 = 2;
					Dlaexc.dlaexc(flag, i, ad, j, k, ad1, l, i1, k1 - byte4,
							byte4, byte0, ad2, j1, intw2);
					if (intw2.val != 0) {
						intw1.val = k1;
						return;
					}
					k1 -= byte4;
					if ((byte0 == 2)
							&& (ad[((k1 + 1) - 1) + (k1 - 1) * k + j] == 0.0D))
						byte0 = 3;
				} else {
					byte byte5 = 1;
					if ((k1 >= 3)
							&& (ad[(k1 - 1 - 1) + (k1 - 2 - 1) * k + j] != 0.0D))
						byte5 = 2;
					Dlaexc.dlaexc(flag, i, ad, j, k, ad1, l, i1, k1 - byte5,
							byte5, 1, ad2, j1, intw2);
					if (intw2.val != 0) {
						intw1.val = k1;
						return;
					}
					if (byte5 == 1) {
						Dlaexc.dlaexc(flag, i, ad, j, k, ad1, l, i1, k1, byte5,
								1, ad2, j1, intw2);
						k1--;
					} else {
						if (ad[(k1 - 1) + (k1 - 1 - 1) * k + j] == 0.0D)
							byte5 = 1;
						if (byte5 == 2) {
							Dlaexc.dlaexc(flag, i, ad, j, k, ad1, l, i1,
									k1 - 1, 2, 1, ad2, j1, intw2);
							if (intw2.val != 0) {
								intw1.val = k1;
								return;
							}
							k1 -= 2;
						} else {
							Dlaexc.dlaexc(flag, i, ad, j, k, ad1, l, i1, k1, 1,
									1, ad2, j1, intw2);
							Dlaexc.dlaexc(flag, i, ad, j, k, ad1, l, i1,
									k1 - 1, 1, 1, ad2, j1, intw2);
							k1 -= 2;
						}
					}
				}
			while (k1 > intw1.val);
		}
		intw1.val = k1;
	}
}

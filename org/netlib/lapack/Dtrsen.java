package org.netlib.lapack;

import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dtrsen {
	public static void dtrsen(String s, String s1, boolean aflag[], int i,
			int j, double ad[], int k, int l, double ad1[], int i1, int j1,
			double ad2[], int k1, double ad3[], int l1, intW intw,
			doubleW doublew, doubleW doublew1, double ad4[], int i2, int j2,
			int ai[], int k2, int l2, intW intw1) {
		int k3;
		int l3;
		label0: {
			boolean flag = false;
			boolean flag1 = false;
			boolean flag4 = false;
			boolean flag5 = false;
			boolean flag6 = false;
			boolean flag7 = false;
			intW intw2 = new intW(0);
			int i3 = 0;
			intW intw3 = new intW(0);
			intW intw4 = new intW(0);
			intW intw5 = new intW(0);
			k3 = 0;
			l3 = 0;
			int i4 = 0;
			int j4 = 0;
			int k4 = 0;
			doubleW doublew2 = new doubleW(0.0D);
			doubleW doublew3 = new doubleW(0.0D);
			int ai1[] = new int[3];
			flag4 = Lsame.lsame(s, "B");
			flag6 = Lsame.lsame(s, "E") || flag4;
			flag7 = Lsame.lsame(s, "V") || flag4;
			flag5 = Lsame.lsame(s1, "V");
			intw1.val = 0;
			flag = j2 == -1;
			if ((Lsame.lsame(s, "N") ^ true && flag6 ^ true) && flag7 ^ true)
				intw1.val = -1;
			else if (Lsame.lsame(s1, "N") ^ true && flag5 ^ true)
				intw1.val = -2;
			else if (j < 0)
				intw1.val = -4;
			else if (l < Math.max(1, j))
				intw1.val = -6;
			else if ((j1 < 1) || (flag5 && (j1 < j))) {
				intw1.val = -8;
			} else {
				intw.val = 0;
				flag1 = false;
				i3 = 1;
				for (int l4 = (j - 1) + 1; l4 > 0; l4--) {
					if (flag1)
						flag1 = false;
					else if (i3 < j) {
						if (ad[((i3 + 1) - 1) + (i3 - 1) * l + k] == 0.0D) {
							if (aflag[(i3 - 1) + i])
								intw.val = intw.val + 1;
						} else {
							flag1 = true;
							if (aflag[(i3 - 1) + i]
									|| aflag[((i3 + 1) - 1) + i])
								intw.val = intw.val + 2;
						}
					} else if (aflag[(j - 1) + i])
						intw.val = intw.val + 1;
					i3++;
				}

				i4 = intw.val;
				j4 = j - intw.val;
				k4 = i4 * j4;
				if (flag7) {
					l3 = Math.max(1, 2 * k4);
					k3 = Math.max(1, k4);
				} else if (Lsame.lsame(s, "N")) {
					l3 = Math.max(1, j);
					k3 = 1;
				} else if (Lsame.lsame(s, "E")) {
					l3 = Math.max(1, k4);
					k3 = 1;
				}
				if ((j2 < l3) && flag ^ true)
					intw1.val = -15;
				else if ((l2 < k3) && flag ^ true)
					intw1.val = -17;
			}
			if (intw1.val == 0) {
				ad4[(1 - 1) + i2] = l3;
				ai[(1 - 1) + k2] = k3;
			}
			if (intw1.val != 0) {
				Xerbla.xerbla("DTRSEN", -intw1.val);
				return;
			}
			if (flag)
				return;
			if ((intw.val == j) || (intw.val == 0)) {
				if (flag6)
					doublew.val = 1.0D;
				if (flag7)
					doublew1.val = Dlange.dlange("1", j, j, ad, k, l, ad4, i2);
				break label0;
			}
			intw5.val = 0;
			flag1 = false;
			i3 = 1;
			for (int i5 = (j - 1) + 1; i5 > 0; i5--) {
				if (flag1) {
					flag1 = false;
				} else {
					boolean flag3 = aflag[(i3 - 1) + i];
					if ((i3 < j)
							&& (ad[((i3 + 1) - 1) + (i3 - 1) * l + k] != 0.0D)) {
						flag1 = true;
						flag3 = flag3 || aflag[((i3 + 1) - 1) + i];
					}
					if (flag3) {
						intw5.val = intw5.val + 1;
						intw2.val = 0;
						intw4.val = i3;
						if (i3 != intw5.val)
							Dtrexc.dtrexc(s1, j, ad, k, l, ad1, i1, j1, intw4,
									intw5, ad4, i2, intw2);
						if ((intw2.val == 1) || (intw2.val == 2)) {
							intw1.val = 1;
							if (flag6)
								doublew.val = 0.0D;
							if (flag7)
								doublew1.val = 0.0D;
							break label0;
						}
						if (flag1)
							intw5.val = intw5.val + 1;
					}
				}
				i3++;
			}

			if (flag6) {
				Dlacpy.dlacpy("F", i4, j4, ad,
						(1 - 1) + ((i4 + 1) - 1) * l + k, l, ad4, i2, i4);
				Dtrsyl.dtrsyl("N", "N", -1, i4, j4, ad, k, l, ad,
						((i4 + 1) - 1) + ((i4 + 1) - 1) * l + k, l, ad4, i2,
						i4, doublew3, intw2);
				double d1 = Dlange.dlange("F", i4, j4, ad4, i2, i4, ad4, i2);
				if (d1 == 0.0D)
					doublew.val = 1.0D;
				else
					doublew.val = doublew3.val
							/ (Math.sqrt((doublew3.val * doublew3.val) / d1
									+ d1) * Math.sqrt(d1));
			}
			if (flag7) {
				doublew2.val = 0.0D;
				intw3.val = 0;
				do {
					Dlacn2.dlacn2(k4, ad4, ((k4 + 1) - 1) + i2, ad4, i2, ai,
							k2, doublew2, intw3, ai1, 0);
					if (intw3.val == 0)
						break;
					if (intw3.val == 1)
						Dtrsyl.dtrsyl("N", "N", -1, i4, j4, ad, k, l, ad,
								((i4 + 1) - 1) + ((i4 + 1) - 1) * l + k, l,
								ad4, i2, i4, doublew3, intw2);
					else
						Dtrsyl.dtrsyl("T", "T", -1, i4, j4, ad, k, l, ad,
								((i4 + 1) - 1) + ((i4 + 1) - 1) * l + k, l,
								ad4, i2, i4, doublew3, intw2);
				} while (true);
				doublew1.val = doublew3.val / doublew2.val;
			}
		}
		int j3 = 1;
		for (int j5 = (j - 1) + 1; j5 > 0; j5--) {
			ad2[(j3 - 1) + k1] = ad[(j3 - 1) + (j3 - 1) * l + k];
			ad3[(j3 - 1) + l1] = 0.0D;
			j3++;
		}

		j3 = 1;
		for (int k5 = (j - 1 - 1) + 1; k5 > 0; k5--) {
			if (ad[((j3 + 1) - 1) + (j3 - 1) * l + k] != 0.0D) {
				ad3[(j3 - 1) + l1] = Math.sqrt(Math.abs(ad[(j3 - 1)
						+ ((j3 + 1) - 1) * l + k]))
						* Math.sqrt(Math.abs(ad[((j3 + 1) - 1) + (j3 - 1) * l
								+ k]));
				ad3[((j3 + 1) - 1) + l1] = -ad3[(j3 - 1) + l1];
			}
			j3++;
		}

		ad4[(1 - 1) + i2] = l3;
		ai[(1 - 1) + k2] = k3;
	}
}

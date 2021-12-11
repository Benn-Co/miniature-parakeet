package org.netlib.lapack;

import org.netlib.blas.Dgemv;
import org.netlib.blas.Dger;
import org.netlib.blas.Lsame;

public final class Dlarfx {
	public static void dlarfx(String s, int i, int j, double ad[], int k,
			double d, double ad1[], int l, int i1, double ad2[], int j1) {
		if (d == 0.0D)
			return;
		if (Lsame.lsame(s, "L")) {
			int k6 = i;
			if (k6 != 1) {
				if (k6 != 2) {
					if (k6 != 3) {
						if (k6 != 4) {
							if (k6 != 5) {
								if (k6 != 6) {
									if (k6 != 7) {
										if (k6 != 8) {
											if (k6 != 9) {
												if (k6 != 10) {
													Dgemv.dgemv("Transpose", i,
															j, 1.0D, ad1, l,
															i1, ad, k, 1, 0.0D,
															ad2, j1, 1);
													Dger.dger(i, j, -d, ad, k,
															1, ad2, j1, 1, ad1,
															l, i1);
												} else {
													double d149 = ad[(1 - 1)
															+ k];
													double d30 = d * d149;
													double d171 = ad[(2 - 1)
															+ k];
													double d53 = d * d171;
													double d189 = ad[(3 - 1)
															+ k];
													double d71 = d * d189;
													double d205 = ad[(4 - 1)
															+ k];
													double d87 = d * d205;
													double d219 = ad[(5 - 1)
															+ k];
													double d101 = d * d219;
													double d231 = ad[(6 - 1)
															+ k];
													double d113 = d * d231;
													double d241 = ad[(7 - 1)
															+ k];
													double d123 = d * d241;
													double d249 = ad[(8 - 1)
															+ k];
													double d131 = d * d249;
													double d255 = ad[(9 - 1)
															+ k];
													double d137 = d * d255;
													double d160 = ad[(10 - 1)
															+ k];
													double d42 = d * d160;
													int l3 = 1;
													for (int i9 = (j - 1) + 1; i9 > 0; i9--) {
														double d10 = d149
																* ad1[(1 - 1)
																		+ (l3 - 1)
																		* i1
																		+ l]
																+ d171
																* ad1[(2 - 1)
																		+ (l3 - 1)
																		* i1
																		+ l]
																+ d189
																* ad1[(3 - 1)
																		+ (l3 - 1)
																		* i1
																		+ l]
																+ d205
																* ad1[(4 - 1)
																		+ (l3 - 1)
																		* i1
																		+ l]
																+ d219
																* ad1[(5 - 1)
																		+ (l3 - 1)
																		* i1
																		+ l]
																+ d231
																* ad1[(6 - 1)
																		+ (l3 - 1)
																		* i1
																		+ l]
																+ d241
																* ad1[(7 - 1)
																		+ (l3 - 1)
																		* i1
																		+ l]
																+ d249
																* ad1[(8 - 1)
																		+ (l3 - 1)
																		* i1
																		+ l]
																+ d255
																* ad1[(9 - 1)
																		+ (l3 - 1)
																		* i1
																		+ l]
																+ d160
																* ad1[(10 - 1)
																		+ (l3 - 1)
																		* i1
																		+ l];
														ad1[(1 - 1) + (l3 - 1)
																* i1 + l] = ad1[(1 - 1)
																+ (l3 - 1)
																* i1
																+ l]
																- d10 * d30;
														ad1[(2 - 1) + (l3 - 1)
																* i1 + l] = ad1[(2 - 1)
																+ (l3 - 1)
																* i1
																+ l]
																- d10 * d53;
														ad1[(3 - 1) + (l3 - 1)
																* i1 + l] = ad1[(3 - 1)
																+ (l3 - 1)
																* i1
																+ l]
																- d10 * d71;
														ad1[(4 - 1) + (l3 - 1)
																* i1 + l] = ad1[(4 - 1)
																+ (l3 - 1)
																* i1
																+ l]
																- d10 * d87;
														ad1[(5 - 1) + (l3 - 1)
																* i1 + l] = ad1[(5 - 1)
																+ (l3 - 1)
																* i1
																+ l]
																- d10 * d101;
														ad1[(6 - 1) + (l3 - 1)
																* i1 + l] = ad1[(6 - 1)
																+ (l3 - 1)
																* i1
																+ l]
																- d10 * d113;
														ad1[(7 - 1) + (l3 - 1)
																* i1 + l] = ad1[(7 - 1)
																+ (l3 - 1)
																* i1
																+ l]
																- d10 * d123;
														ad1[(8 - 1) + (l3 - 1)
																* i1 + l] = ad1[(8 - 1)
																+ (l3 - 1)
																* i1
																+ l]
																- d10 * d131;
														ad1[(9 - 1) + (l3 - 1)
																* i1 + l] = ad1[(9 - 1)
																+ (l3 - 1)
																* i1
																+ l]
																- d10 * d137;
														ad1[(10 - 1) + (l3 - 1)
																* i1 + l] = ad1[(10 - 1)
																+ (l3 - 1)
																* i1
																+ l]
																- d10 * d42;
														l3++;
													}

												}
											} else {
												double d148 = ad[(1 - 1) + k];
												double d29 = d * d148;
												double d170 = ad[(2 - 1) + k];
												double d52 = d * d170;
												double d188 = ad[(3 - 1) + k];
												double d70 = d * d188;
												double d204 = ad[(4 - 1) + k];
												double d86 = d * d204;
												double d218 = ad[(5 - 1) + k];
												double d100 = d * d218;
												double d230 = ad[(6 - 1) + k];
												double d112 = d * d230;
												double d240 = ad[(7 - 1) + k];
												double d122 = d * d240;
												double d248 = ad[(8 - 1) + k];
												double d130 = d * d248;
												double d254 = ad[(9 - 1) + k];
												double d136 = d * d254;
												int k3 = 1;
												for (int l8 = (j - 1) + 1; l8 > 0; l8--) {
													double d9 = d148
															* ad1[(1 - 1)
																	+ (k3 - 1)
																	* i1 + l]
															+ d170
															* ad1[(2 - 1)
																	+ (k3 - 1)
																	* i1 + l]
															+ d188
															* ad1[(3 - 1)
																	+ (k3 - 1)
																	* i1 + l]
															+ d204
															* ad1[(4 - 1)
																	+ (k3 - 1)
																	* i1 + l]
															+ d218
															* ad1[(5 - 1)
																	+ (k3 - 1)
																	* i1 + l]
															+ d230
															* ad1[(6 - 1)
																	+ (k3 - 1)
																	* i1 + l]
															+ d240
															* ad1[(7 - 1)
																	+ (k3 - 1)
																	* i1 + l]
															+ d248
															* ad1[(8 - 1)
																	+ (k3 - 1)
																	* i1 + l]
															+ d254
															* ad1[(9 - 1)
																	+ (k3 - 1)
																	* i1 + l];
													ad1[(1 - 1) + (k3 - 1) * i1
															+ l] = ad1[(1 - 1)
															+ (k3 - 1) * i1 + l]
															- d9 * d29;
													ad1[(2 - 1) + (k3 - 1) * i1
															+ l] = ad1[(2 - 1)
															+ (k3 - 1) * i1 + l]
															- d9 * d52;
													ad1[(3 - 1) + (k3 - 1) * i1
															+ l] = ad1[(3 - 1)
															+ (k3 - 1) * i1 + l]
															- d9 * d70;
													ad1[(4 - 1) + (k3 - 1) * i1
															+ l] = ad1[(4 - 1)
															+ (k3 - 1) * i1 + l]
															- d9 * d86;
													ad1[(5 - 1) + (k3 - 1) * i1
															+ l] = ad1[(5 - 1)
															+ (k3 - 1) * i1 + l]
															- d9 * d100;
													ad1[(6 - 1) + (k3 - 1) * i1
															+ l] = ad1[(6 - 1)
															+ (k3 - 1) * i1 + l]
															- d9 * d112;
													ad1[(7 - 1) + (k3 - 1) * i1
															+ l] = ad1[(7 - 1)
															+ (k3 - 1) * i1 + l]
															- d9 * d122;
													ad1[(8 - 1) + (k3 - 1) * i1
															+ l] = ad1[(8 - 1)
															+ (k3 - 1) * i1 + l]
															- d9 * d130;
													ad1[(9 - 1) + (k3 - 1) * i1
															+ l] = ad1[(9 - 1)
															+ (k3 - 1) * i1 + l]
															- d9 * d136;
													k3++;
												}

											}
										} else {
											double d147 = ad[(1 - 1) + k];
											double d28 = d * d147;
											double d169 = ad[(2 - 1) + k];
											double d51 = d * d169;
											double d187 = ad[(3 - 1) + k];
											double d69 = d * d187;
											double d203 = ad[(4 - 1) + k];
											double d85 = d * d203;
											double d217 = ad[(5 - 1) + k];
											double d99 = d * d217;
											double d229 = ad[(6 - 1) + k];
											double d111 = d * d229;
											double d239 = ad[(7 - 1) + k];
											double d121 = d * d239;
											double d247 = ad[(8 - 1) + k];
											double d129 = d * d247;
											int j3 = 1;
											for (int k8 = (j - 1) + 1; k8 > 0; k8--) {
												double d8 = d147
														* ad1[(1 - 1)
																+ (j3 - 1) * i1
																+ l]
														+ d169
														* ad1[(2 - 1)
																+ (j3 - 1) * i1
																+ l]
														+ d187
														* ad1[(3 - 1)
																+ (j3 - 1) * i1
																+ l]
														+ d203
														* ad1[(4 - 1)
																+ (j3 - 1) * i1
																+ l]
														+ d217
														* ad1[(5 - 1)
																+ (j3 - 1) * i1
																+ l]
														+ d229
														* ad1[(6 - 1)
																+ (j3 - 1) * i1
																+ l]
														+ d239
														* ad1[(7 - 1)
																+ (j3 - 1) * i1
																+ l]
														+ d247
														* ad1[(8 - 1)
																+ (j3 - 1) * i1
																+ l];
												ad1[(1 - 1) + (j3 - 1) * i1 + l] = ad1[(1 - 1)
														+ (j3 - 1) * i1 + l]
														- d8 * d28;
												ad1[(2 - 1) + (j3 - 1) * i1 + l] = ad1[(2 - 1)
														+ (j3 - 1) * i1 + l]
														- d8 * d51;
												ad1[(3 - 1) + (j3 - 1) * i1 + l] = ad1[(3 - 1)
														+ (j3 - 1) * i1 + l]
														- d8 * d69;
												ad1[(4 - 1) + (j3 - 1) * i1 + l] = ad1[(4 - 1)
														+ (j3 - 1) * i1 + l]
														- d8 * d85;
												ad1[(5 - 1) + (j3 - 1) * i1 + l] = ad1[(5 - 1)
														+ (j3 - 1) * i1 + l]
														- d8 * d99;
												ad1[(6 - 1) + (j3 - 1) * i1 + l] = ad1[(6 - 1)
														+ (j3 - 1) * i1 + l]
														- d8 * d111;
												ad1[(7 - 1) + (j3 - 1) * i1 + l] = ad1[(7 - 1)
														+ (j3 - 1) * i1 + l]
														- d8 * d121;
												ad1[(8 - 1) + (j3 - 1) * i1 + l] = ad1[(8 - 1)
														+ (j3 - 1) * i1 + l]
														- d8 * d129;
												j3++;
											}

										}
									} else {
										double d146 = ad[(1 - 1) + k];
										double d27 = d * d146;
										double d168 = ad[(2 - 1) + k];
										double d50 = d * d168;
										double d186 = ad[(3 - 1) + k];
										double d68 = d * d186;
										double d202 = ad[(4 - 1) + k];
										double d84 = d * d202;
										double d216 = ad[(5 - 1) + k];
										double d98 = d * d216;
										double d228 = ad[(6 - 1) + k];
										double d110 = d * d228;
										double d238 = ad[(7 - 1) + k];
										double d120 = d * d238;
										int i3 = 1;
										for (int j8 = (j - 1) + 1; j8 > 0; j8--) {
											double d7 = d146
													* ad1[(1 - 1) + (i3 - 1)
															* i1 + l]
													+ d168
													* ad1[(2 - 1) + (i3 - 1)
															* i1 + l]
													+ d186
													* ad1[(3 - 1) + (i3 - 1)
															* i1 + l]
													+ d202
													* ad1[(4 - 1) + (i3 - 1)
															* i1 + l]
													+ d216
													* ad1[(5 - 1) + (i3 - 1)
															* i1 + l]
													+ d228
													* ad1[(6 - 1) + (i3 - 1)
															* i1 + l]
													+ d238
													* ad1[(7 - 1) + (i3 - 1)
															* i1 + l];
											ad1[(1 - 1) + (i3 - 1) * i1 + l] = ad1[(1 - 1)
													+ (i3 - 1) * i1 + l]
													- d7 * d27;
											ad1[(2 - 1) + (i3 - 1) * i1 + l] = ad1[(2 - 1)
													+ (i3 - 1) * i1 + l]
													- d7 * d50;
											ad1[(3 - 1) + (i3 - 1) * i1 + l] = ad1[(3 - 1)
													+ (i3 - 1) * i1 + l]
													- d7 * d68;
											ad1[(4 - 1) + (i3 - 1) * i1 + l] = ad1[(4 - 1)
													+ (i3 - 1) * i1 + l]
													- d7 * d84;
											ad1[(5 - 1) + (i3 - 1) * i1 + l] = ad1[(5 - 1)
													+ (i3 - 1) * i1 + l]
													- d7 * d98;
											ad1[(6 - 1) + (i3 - 1) * i1 + l] = ad1[(6 - 1)
													+ (i3 - 1) * i1 + l]
													- d7 * d110;
											ad1[(7 - 1) + (i3 - 1) * i1 + l] = ad1[(7 - 1)
													+ (i3 - 1) * i1 + l]
													- d7 * d120;
											i3++;
										}

									}
								} else {
									double d145 = ad[(1 - 1) + k];
									double d26 = d * d145;
									double d167 = ad[(2 - 1) + k];
									double d49 = d * d167;
									double d185 = ad[(3 - 1) + k];
									double d67 = d * d185;
									double d201 = ad[(4 - 1) + k];
									double d83 = d * d201;
									double d215 = ad[(5 - 1) + k];
									double d97 = d * d215;
									double d227 = ad[(6 - 1) + k];
									double d109 = d * d227;
									int l2 = 1;
									for (int i8 = (j - 1) + 1; i8 > 0; i8--) {
										double d6 = d145
												* ad1[(1 - 1) + (l2 - 1) * i1
														+ l]
												+ d167
												* ad1[(2 - 1) + (l2 - 1) * i1
														+ l]
												+ d185
												* ad1[(3 - 1) + (l2 - 1) * i1
														+ l]
												+ d201
												* ad1[(4 - 1) + (l2 - 1) * i1
														+ l]
												+ d215
												* ad1[(5 - 1) + (l2 - 1) * i1
														+ l]
												+ d227
												* ad1[(6 - 1) + (l2 - 1) * i1
														+ l];
										ad1[(1 - 1) + (l2 - 1) * i1 + l] = ad1[(1 - 1)
												+ (l2 - 1) * i1 + l]
												- d6 * d26;
										ad1[(2 - 1) + (l2 - 1) * i1 + l] = ad1[(2 - 1)
												+ (l2 - 1) * i1 + l]
												- d6 * d49;
										ad1[(3 - 1) + (l2 - 1) * i1 + l] = ad1[(3 - 1)
												+ (l2 - 1) * i1 + l]
												- d6 * d67;
										ad1[(4 - 1) + (l2 - 1) * i1 + l] = ad1[(4 - 1)
												+ (l2 - 1) * i1 + l]
												- d6 * d83;
										ad1[(5 - 1) + (l2 - 1) * i1 + l] = ad1[(5 - 1)
												+ (l2 - 1) * i1 + l]
												- d6 * d97;
										ad1[(6 - 1) + (l2 - 1) * i1 + l] = ad1[(6 - 1)
												+ (l2 - 1) * i1 + l]
												- d6 * d109;
										l2++;
									}

								}
							} else {
								double d144 = ad[(1 - 1) + k];
								double d25 = d * d144;
								double d166 = ad[(2 - 1) + k];
								double d48 = d * d166;
								double d184 = ad[(3 - 1) + k];
								double d66 = d * d184;
								double d200 = ad[(4 - 1) + k];
								double d82 = d * d200;
								double d214 = ad[(5 - 1) + k];
								double d96 = d * d214;
								int k2 = 1;
								for (int l7 = (j - 1) + 1; l7 > 0; l7--) {
									double d5 = d144
											* ad1[(1 - 1) + (k2 - 1) * i1 + l]
											+ d166
											* ad1[(2 - 1) + (k2 - 1) * i1 + l]
											+ d184
											* ad1[(3 - 1) + (k2 - 1) * i1 + l]
											+ d200
											* ad1[(4 - 1) + (k2 - 1) * i1 + l]
											+ d214
											* ad1[(5 - 1) + (k2 - 1) * i1 + l];
									ad1[(1 - 1) + (k2 - 1) * i1 + l] = ad1[(1 - 1)
											+ (k2 - 1) * i1 + l]
											- d5 * d25;
									ad1[(2 - 1) + (k2 - 1) * i1 + l] = ad1[(2 - 1)
											+ (k2 - 1) * i1 + l]
											- d5 * d48;
									ad1[(3 - 1) + (k2 - 1) * i1 + l] = ad1[(3 - 1)
											+ (k2 - 1) * i1 + l]
											- d5 * d66;
									ad1[(4 - 1) + (k2 - 1) * i1 + l] = ad1[(4 - 1)
											+ (k2 - 1) * i1 + l]
											- d5 * d82;
									ad1[(5 - 1) + (k2 - 1) * i1 + l] = ad1[(5 - 1)
											+ (k2 - 1) * i1 + l]
											- d5 * d96;
									k2++;
								}

							}
						} else {
							double d143 = ad[(1 - 1) + k];
							double d24 = d * d143;
							double d165 = ad[(2 - 1) + k];
							double d47 = d * d165;
							double d183 = ad[(3 - 1) + k];
							double d65 = d * d183;
							double d199 = ad[(4 - 1) + k];
							double d81 = d * d199;
							int j2 = 1;
							for (int k7 = (j - 1) + 1; k7 > 0; k7--) {
								double d4 = d143
										* ad1[(1 - 1) + (j2 - 1) * i1 + l]
										+ d165
										* ad1[(2 - 1) + (j2 - 1) * i1 + l]
										+ d183
										* ad1[(3 - 1) + (j2 - 1) * i1 + l]
										+ d199
										* ad1[(4 - 1) + (j2 - 1) * i1 + l];
								ad1[(1 - 1) + (j2 - 1) * i1 + l] = ad1[(1 - 1)
										+ (j2 - 1) * i1 + l]
										- d4 * d24;
								ad1[(2 - 1) + (j2 - 1) * i1 + l] = ad1[(2 - 1)
										+ (j2 - 1) * i1 + l]
										- d4 * d47;
								ad1[(3 - 1) + (j2 - 1) * i1 + l] = ad1[(3 - 1)
										+ (j2 - 1) * i1 + l]
										- d4 * d65;
								ad1[(4 - 1) + (j2 - 1) * i1 + l] = ad1[(4 - 1)
										+ (j2 - 1) * i1 + l]
										- d4 * d81;
								j2++;
							}

						}
					} else {
						double d142 = ad[(1 - 1) + k];
						double d23 = d * d142;
						double d164 = ad[(2 - 1) + k];
						double d46 = d * d164;
						double d182 = ad[(3 - 1) + k];
						double d64 = d * d182;
						int i2 = 1;
						for (int j7 = (j - 1) + 1; j7 > 0; j7--) {
							double d3 = d142 * ad1[(1 - 1) + (i2 - 1) * i1 + l]
									+ d164 * ad1[(2 - 1) + (i2 - 1) * i1 + l]
									+ d182 * ad1[(3 - 1) + (i2 - 1) * i1 + l];
							ad1[(1 - 1) + (i2 - 1) * i1 + l] = ad1[(1 - 1)
									+ (i2 - 1) * i1 + l]
									- d3 * d23;
							ad1[(2 - 1) + (i2 - 1) * i1 + l] = ad1[(2 - 1)
									+ (i2 - 1) * i1 + l]
									- d3 * d46;
							ad1[(3 - 1) + (i2 - 1) * i1 + l] = ad1[(3 - 1)
									+ (i2 - 1) * i1 + l]
									- d3 * d64;
							i2++;
						}

					}
				} else {
					double d141 = ad[(1 - 1) + k];
					double d22 = d * d141;
					double d163 = ad[(2 - 1) + k];
					double d45 = d * d163;
					int l1 = 1;
					for (int i7 = (j - 1) + 1; i7 > 0; i7--) {
						double d2 = d141 * ad1[(1 - 1) + (l1 - 1) * i1 + l]
								+ d163 * ad1[(2 - 1) + (l1 - 1) * i1 + l];
						ad1[(1 - 1) + (l1 - 1) * i1 + l] = ad1[(1 - 1)
								+ (l1 - 1) * i1 + l]
								- d2 * d22;
						ad1[(2 - 1) + (l1 - 1) * i1 + l] = ad1[(2 - 1)
								+ (l1 - 1) * i1 + l]
								- d2 * d45;
						l1++;
					}

				}
			} else {
				double d21 = 1.0D - d * ad[(1 - 1) + k] * ad[(1 - 1) + k];
				int k1 = 1;
				for (int l6 = (j - 1) + 1; l6 > 0; l6--) {
					ad1[(1 - 1) + (k1 - 1) * i1 + l] = d21
							* ad1[(1 - 1) + (k1 - 1) * i1 + l];
					k1++;
				}

			}
		} else {
			int j9 = j;
			if (j9 != 1) {
				if (j9 != 2) {
					if (j9 != 3) {
						if (j9 != 4) {
							if (j9 != 5) {
								if (j9 != 6) {
									if (j9 != 7) {
										if (j9 != 8) {
											if (j9 != 9) {
												if (j9 != 10) {
													Dgemv.dgemv("No transpose",
															i, j, 1.0D, ad1, l,
															i1, ad, k, 1, 0.0D,
															ad2, j1, 1);
													Dger.dger(i, j, -d, ad2,
															j1, 1, ad, k, 1,
															ad1, l, i1);
												} else {
													double d158 = ad[(1 - 1)
															+ k];
													double d40 = d * d158;
													double d180 = ad[(2 - 1)
															+ k];
													double d62 = d * d180;
													double d197 = ad[(3 - 1)
															+ k];
													double d79 = d * d197;
													double d212 = ad[(4 - 1)
															+ k];
													double d94 = d * d212;
													double d225 = ad[(5 - 1)
															+ k];
													double d107 = d * d225;
													double d236 = ad[(6 - 1)
															+ k];
													double d118 = d * d236;
													double d245 = ad[(7 - 1)
															+ k];
													double d127 = d * d245;
													double d252 = ad[(8 - 1)
															+ k];
													double d134 = d * d252;
													double d257 = ad[(9 - 1)
															+ k];
													double d139 = d * d257;
													double d161 = ad[(10 - 1)
															+ k];
													double d43 = d * d161;
													int j6 = 1;
													for (int l11 = (i - 1) + 1; l11 > 0; l11--) {
														double d19 = d158
																* ad1[(j6 - 1)
																		+ (1 - 1)
																		* i1
																		+ l]
																+ d180
																* ad1[(j6 - 1)
																		+ (2 - 1)
																		* i1
																		+ l]
																+ d197
																* ad1[(j6 - 1)
																		+ (3 - 1)
																		* i1
																		+ l]
																+ d212
																* ad1[(j6 - 1)
																		+ (4 - 1)
																		* i1
																		+ l]
																+ d225
																* ad1[(j6 - 1)
																		+ (5 - 1)
																		* i1
																		+ l]
																+ d236
																* ad1[(j6 - 1)
																		+ (6 - 1)
																		* i1
																		+ l]
																+ d245
																* ad1[(j6 - 1)
																		+ (7 - 1)
																		* i1
																		+ l]
																+ d252
																* ad1[(j6 - 1)
																		+ (8 - 1)
																		* i1
																		+ l]
																+ d257
																* ad1[(j6 - 1)
																		+ (9 - 1)
																		* i1
																		+ l]
																+ d161
																* ad1[(j6 - 1)
																		+ (10 - 1)
																		* i1
																		+ l];
														ad1[(j6 - 1) + (1 - 1)
																* i1 + l] = ad1[(j6 - 1)
																+ (1 - 1)
																* i1
																+ l]
																- d19 * d40;
														ad1[(j6 - 1) + (2 - 1)
																* i1 + l] = ad1[(j6 - 1)
																+ (2 - 1)
																* i1
																+ l]
																- d19 * d62;
														ad1[(j6 - 1) + (3 - 1)
																* i1 + l] = ad1[(j6 - 1)
																+ (3 - 1)
																* i1
																+ l]
																- d19 * d79;
														ad1[(j6 - 1) + (4 - 1)
																* i1 + l] = ad1[(j6 - 1)
																+ (4 - 1)
																* i1
																+ l]
																- d19 * d94;
														ad1[(j6 - 1) + (5 - 1)
																* i1 + l] = ad1[(j6 - 1)
																+ (5 - 1)
																* i1
																+ l]
																- d19 * d107;
														ad1[(j6 - 1) + (6 - 1)
																* i1 + l] = ad1[(j6 - 1)
																+ (6 - 1)
																* i1
																+ l]
																- d19 * d118;
														ad1[(j6 - 1) + (7 - 1)
																* i1 + l] = ad1[(j6 - 1)
																+ (7 - 1)
																* i1
																+ l]
																- d19 * d127;
														ad1[(j6 - 1) + (8 - 1)
																* i1 + l] = ad1[(j6 - 1)
																+ (8 - 1)
																* i1
																+ l]
																- d19 * d134;
														ad1[(j6 - 1) + (9 - 1)
																* i1 + l] = ad1[(j6 - 1)
																+ (9 - 1)
																* i1
																+ l]
																- d19 * d139;
														ad1[(j6 - 1) + (10 - 1)
																* i1 + l] = ad1[(j6 - 1)
																+ (10 - 1)
																* i1
																+ l]
																- d19 * d43;
														j6++;
													}

												}
											} else {
												double d157 = ad[(1 - 1) + k];
												double d39 = d * d157;
												double d179 = ad[(2 - 1) + k];
												double d61 = d * d179;
												double d196 = ad[(3 - 1) + k];
												double d78 = d * d196;
												double d211 = ad[(4 - 1) + k];
												double d93 = d * d211;
												double d224 = ad[(5 - 1) + k];
												double d106 = d * d224;
												double d235 = ad[(6 - 1) + k];
												double d117 = d * d235;
												double d244 = ad[(7 - 1) + k];
												double d126 = d * d244;
												double d251 = ad[(8 - 1) + k];
												double d133 = d * d251;
												double d256 = ad[(9 - 1) + k];
												double d138 = d * d256;
												int i6 = 1;
												for (int k11 = (i - 1) + 1; k11 > 0; k11--) {
													double d18 = d157
															* ad1[(i6 - 1)
																	+ (1 - 1)
																	* i1 + l]
															+ d179
															* ad1[(i6 - 1)
																	+ (2 - 1)
																	* i1 + l]
															+ d196
															* ad1[(i6 - 1)
																	+ (3 - 1)
																	* i1 + l]
															+ d211
															* ad1[(i6 - 1)
																	+ (4 - 1)
																	* i1 + l]
															+ d224
															* ad1[(i6 - 1)
																	+ (5 - 1)
																	* i1 + l]
															+ d235
															* ad1[(i6 - 1)
																	+ (6 - 1)
																	* i1 + l]
															+ d244
															* ad1[(i6 - 1)
																	+ (7 - 1)
																	* i1 + l]
															+ d251
															* ad1[(i6 - 1)
																	+ (8 - 1)
																	* i1 + l]
															+ d256
															* ad1[(i6 - 1)
																	+ (9 - 1)
																	* i1 + l];
													ad1[(i6 - 1) + (1 - 1) * i1
															+ l] = ad1[(i6 - 1)
															+ (1 - 1) * i1 + l]
															- d18 * d39;
													ad1[(i6 - 1) + (2 - 1) * i1
															+ l] = ad1[(i6 - 1)
															+ (2 - 1) * i1 + l]
															- d18 * d61;
													ad1[(i6 - 1) + (3 - 1) * i1
															+ l] = ad1[(i6 - 1)
															+ (3 - 1) * i1 + l]
															- d18 * d78;
													ad1[(i6 - 1) + (4 - 1) * i1
															+ l] = ad1[(i6 - 1)
															+ (4 - 1) * i1 + l]
															- d18 * d93;
													ad1[(i6 - 1) + (5 - 1) * i1
															+ l] = ad1[(i6 - 1)
															+ (5 - 1) * i1 + l]
															- d18 * d106;
													ad1[(i6 - 1) + (6 - 1) * i1
															+ l] = ad1[(i6 - 1)
															+ (6 - 1) * i1 + l]
															- d18 * d117;
													ad1[(i6 - 1) + (7 - 1) * i1
															+ l] = ad1[(i6 - 1)
															+ (7 - 1) * i1 + l]
															- d18 * d126;
													ad1[(i6 - 1) + (8 - 1) * i1
															+ l] = ad1[(i6 - 1)
															+ (8 - 1) * i1 + l]
															- d18 * d133;
													ad1[(i6 - 1) + (9 - 1) * i1
															+ l] = ad1[(i6 - 1)
															+ (9 - 1) * i1 + l]
															- d18 * d138;
													i6++;
												}

											}
										} else {
											double d156 = ad[(1 - 1) + k];
											double d38 = d * d156;
											double d178 = ad[(2 - 1) + k];
											double d60 = d * d178;
											double d195 = ad[(3 - 1) + k];
											double d77 = d * d195;
											double d210 = ad[(4 - 1) + k];
											double d92 = d * d210;
											double d223 = ad[(5 - 1) + k];
											double d105 = d * d223;
											double d234 = ad[(6 - 1) + k];
											double d116 = d * d234;
											double d243 = ad[(7 - 1) + k];
											double d125 = d * d243;
											double d250 = ad[(8 - 1) + k];
											double d132 = d * d250;
											int l5 = 1;
											for (int j11 = (i - 1) + 1; j11 > 0; j11--) {
												double d17 = d156
														* ad1[(l5 - 1)
																+ (1 - 1) * i1
																+ l]
														+ d178
														* ad1[(l5 - 1)
																+ (2 - 1) * i1
																+ l]
														+ d195
														* ad1[(l5 - 1)
																+ (3 - 1) * i1
																+ l]
														+ d210
														* ad1[(l5 - 1)
																+ (4 - 1) * i1
																+ l]
														+ d223
														* ad1[(l5 - 1)
																+ (5 - 1) * i1
																+ l]
														+ d234
														* ad1[(l5 - 1)
																+ (6 - 1) * i1
																+ l]
														+ d243
														* ad1[(l5 - 1)
																+ (7 - 1) * i1
																+ l]
														+ d250
														* ad1[(l5 - 1)
																+ (8 - 1) * i1
																+ l];
												ad1[(l5 - 1) + (1 - 1) * i1 + l] = ad1[(l5 - 1)
														+ (1 - 1) * i1 + l]
														- d17 * d38;
												ad1[(l5 - 1) + (2 - 1) * i1 + l] = ad1[(l5 - 1)
														+ (2 - 1) * i1 + l]
														- d17 * d60;
												ad1[(l5 - 1) + (3 - 1) * i1 + l] = ad1[(l5 - 1)
														+ (3 - 1) * i1 + l]
														- d17 * d77;
												ad1[(l5 - 1) + (4 - 1) * i1 + l] = ad1[(l5 - 1)
														+ (4 - 1) * i1 + l]
														- d17 * d92;
												ad1[(l5 - 1) + (5 - 1) * i1 + l] = ad1[(l5 - 1)
														+ (5 - 1) * i1 + l]
														- d17 * d105;
												ad1[(l5 - 1) + (6 - 1) * i1 + l] = ad1[(l5 - 1)
														+ (6 - 1) * i1 + l]
														- d17 * d116;
												ad1[(l5 - 1) + (7 - 1) * i1 + l] = ad1[(l5 - 1)
														+ (7 - 1) * i1 + l]
														- d17 * d125;
												ad1[(l5 - 1) + (8 - 1) * i1 + l] = ad1[(l5 - 1)
														+ (8 - 1) * i1 + l]
														- d17 * d132;
												l5++;
											}

										}
									} else {
										double d155 = ad[(1 - 1) + k];
										double d37 = d * d155;
										double d177 = ad[(2 - 1) + k];
										double d59 = d * d177;
										double d194 = ad[(3 - 1) + k];
										double d76 = d * d194;
										double d209 = ad[(4 - 1) + k];
										double d91 = d * d209;
										double d222 = ad[(5 - 1) + k];
										double d104 = d * d222;
										double d233 = ad[(6 - 1) + k];
										double d115 = d * d233;
										double d242 = ad[(7 - 1) + k];
										double d124 = d * d242;
										int k5 = 1;
										for (int i11 = (i - 1) + 1; i11 > 0; i11--) {
											double d16 = d155
													* ad1[(k5 - 1) + (1 - 1)
															* i1 + l]
													+ d177
													* ad1[(k5 - 1) + (2 - 1)
															* i1 + l]
													+ d194
													* ad1[(k5 - 1) + (3 - 1)
															* i1 + l]
													+ d209
													* ad1[(k5 - 1) + (4 - 1)
															* i1 + l]
													+ d222
													* ad1[(k5 - 1) + (5 - 1)
															* i1 + l]
													+ d233
													* ad1[(k5 - 1) + (6 - 1)
															* i1 + l]
													+ d242
													* ad1[(k5 - 1) + (7 - 1)
															* i1 + l];
											ad1[(k5 - 1) + (1 - 1) * i1 + l] = ad1[(k5 - 1)
													+ (1 - 1) * i1 + l]
													- d16 * d37;
											ad1[(k5 - 1) + (2 - 1) * i1 + l] = ad1[(k5 - 1)
													+ (2 - 1) * i1 + l]
													- d16 * d59;
											ad1[(k5 - 1) + (3 - 1) * i1 + l] = ad1[(k5 - 1)
													+ (3 - 1) * i1 + l]
													- d16 * d76;
											ad1[(k5 - 1) + (4 - 1) * i1 + l] = ad1[(k5 - 1)
													+ (4 - 1) * i1 + l]
													- d16 * d91;
											ad1[(k5 - 1) + (5 - 1) * i1 + l] = ad1[(k5 - 1)
													+ (5 - 1) * i1 + l]
													- d16 * d104;
											ad1[(k5 - 1) + (6 - 1) * i1 + l] = ad1[(k5 - 1)
													+ (6 - 1) * i1 + l]
													- d16 * d115;
											ad1[(k5 - 1) + (7 - 1) * i1 + l] = ad1[(k5 - 1)
													+ (7 - 1) * i1 + l]
													- d16 * d124;
											k5++;
										}

									}
								} else {
									double d154 = ad[(1 - 1) + k];
									double d36 = d * d154;
									double d176 = ad[(2 - 1) + k];
									double d58 = d * d176;
									double d193 = ad[(3 - 1) + k];
									double d75 = d * d193;
									double d208 = ad[(4 - 1) + k];
									double d90 = d * d208;
									double d221 = ad[(5 - 1) + k];
									double d103 = d * d221;
									double d232 = ad[(6 - 1) + k];
									double d114 = d * d232;
									int j5 = 1;
									for (int l10 = (i - 1) + 1; l10 > 0; l10--) {
										double d15 = d154
												* ad1[(j5 - 1) + (1 - 1) * i1
														+ l]
												+ d176
												* ad1[(j5 - 1) + (2 - 1) * i1
														+ l]
												+ d193
												* ad1[(j5 - 1) + (3 - 1) * i1
														+ l]
												+ d208
												* ad1[(j5 - 1) + (4 - 1) * i1
														+ l]
												+ d221
												* ad1[(j5 - 1) + (5 - 1) * i1
														+ l]
												+ d232
												* ad1[(j5 - 1) + (6 - 1) * i1
														+ l];
										ad1[(j5 - 1) + (1 - 1) * i1 + l] = ad1[(j5 - 1)
												+ (1 - 1) * i1 + l]
												- d15 * d36;
										ad1[(j5 - 1) + (2 - 1) * i1 + l] = ad1[(j5 - 1)
												+ (2 - 1) * i1 + l]
												- d15 * d58;
										ad1[(j5 - 1) + (3 - 1) * i1 + l] = ad1[(j5 - 1)
												+ (3 - 1) * i1 + l]
												- d15 * d75;
										ad1[(j5 - 1) + (4 - 1) * i1 + l] = ad1[(j5 - 1)
												+ (4 - 1) * i1 + l]
												- d15 * d90;
										ad1[(j5 - 1) + (5 - 1) * i1 + l] = ad1[(j5 - 1)
												+ (5 - 1) * i1 + l]
												- d15 * d103;
										ad1[(j5 - 1) + (6 - 1) * i1 + l] = ad1[(j5 - 1)
												+ (6 - 1) * i1 + l]
												- d15 * d114;
										j5++;
									}

								}
							} else {
								double d153 = ad[(1 - 1) + k];
								double d35 = d * d153;
								double d175 = ad[(2 - 1) + k];
								double d57 = d * d175;
								double d192 = ad[(3 - 1) + k];
								double d74 = d * d192;
								double d207 = ad[(4 - 1) + k];
								double d89 = d * d207;
								double d220 = ad[(5 - 1) + k];
								double d102 = d * d220;
								int i5 = 1;
								for (int k10 = (i - 1) + 1; k10 > 0; k10--) {
									double d14 = d153
											* ad1[(i5 - 1) + (1 - 1) * i1 + l]
											+ d175
											* ad1[(i5 - 1) + (2 - 1) * i1 + l]
											+ d192
											* ad1[(i5 - 1) + (3 - 1) * i1 + l]
											+ d207
											* ad1[(i5 - 1) + (4 - 1) * i1 + l]
											+ d220
											* ad1[(i5 - 1) + (5 - 1) * i1 + l];
									ad1[(i5 - 1) + (1 - 1) * i1 + l] = ad1[(i5 - 1)
											+ (1 - 1) * i1 + l]
											- d14 * d35;
									ad1[(i5 - 1) + (2 - 1) * i1 + l] = ad1[(i5 - 1)
											+ (2 - 1) * i1 + l]
											- d14 * d57;
									ad1[(i5 - 1) + (3 - 1) * i1 + l] = ad1[(i5 - 1)
											+ (3 - 1) * i1 + l]
											- d14 * d74;
									ad1[(i5 - 1) + (4 - 1) * i1 + l] = ad1[(i5 - 1)
											+ (4 - 1) * i1 + l]
											- d14 * d89;
									ad1[(i5 - 1) + (5 - 1) * i1 + l] = ad1[(i5 - 1)
											+ (5 - 1) * i1 + l]
											- d14 * d102;
									i5++;
								}

							}
						} else {
							double d152 = ad[(1 - 1) + k];
							double d34 = d * d152;
							double d174 = ad[(2 - 1) + k];
							double d56 = d * d174;
							double d191 = ad[(3 - 1) + k];
							double d73 = d * d191;
							double d206 = ad[(4 - 1) + k];
							double d88 = d * d206;
							int l4 = 1;
							for (int j10 = (i - 1) + 1; j10 > 0; j10--) {
								double d13 = d152
										* ad1[(l4 - 1) + (1 - 1) * i1 + l]
										+ d174
										* ad1[(l4 - 1) + (2 - 1) * i1 + l]
										+ d191
										* ad1[(l4 - 1) + (3 - 1) * i1 + l]
										+ d206
										* ad1[(l4 - 1) + (4 - 1) * i1 + l];
								ad1[(l4 - 1) + (1 - 1) * i1 + l] = ad1[(l4 - 1)
										+ (1 - 1) * i1 + l]
										- d13 * d34;
								ad1[(l4 - 1) + (2 - 1) * i1 + l] = ad1[(l4 - 1)
										+ (2 - 1) * i1 + l]
										- d13 * d56;
								ad1[(l4 - 1) + (3 - 1) * i1 + l] = ad1[(l4 - 1)
										+ (3 - 1) * i1 + l]
										- d13 * d73;
								ad1[(l4 - 1) + (4 - 1) * i1 + l] = ad1[(l4 - 1)
										+ (4 - 1) * i1 + l]
										- d13 * d88;
								l4++;
							}

						}
					} else {
						double d151 = ad[(1 - 1) + k];
						double d33 = d * d151;
						double d173 = ad[(2 - 1) + k];
						double d55 = d * d173;
						double d190 = ad[(3 - 1) + k];
						double d72 = d * d190;
						int k4 = 1;
						for (int i10 = (i - 1) + 1; i10 > 0; i10--) {
							double d12 = d151
									* ad1[(k4 - 1) + (1 - 1) * i1 + l] + d173
									* ad1[(k4 - 1) + (2 - 1) * i1 + l] + d190
									* ad1[(k4 - 1) + (3 - 1) * i1 + l];
							ad1[(k4 - 1) + (1 - 1) * i1 + l] = ad1[(k4 - 1)
									+ (1 - 1) * i1 + l]
									- d12 * d33;
							ad1[(k4 - 1) + (2 - 1) * i1 + l] = ad1[(k4 - 1)
									+ (2 - 1) * i1 + l]
									- d12 * d55;
							ad1[(k4 - 1) + (3 - 1) * i1 + l] = ad1[(k4 - 1)
									+ (3 - 1) * i1 + l]
									- d12 * d72;
							k4++;
						}

					}
				} else {
					double d150 = ad[(1 - 1) + k];
					double d32 = d * d150;
					double d172 = ad[(2 - 1) + k];
					double d54 = d * d172;
					int j4 = 1;
					for (int l9 = (i - 1) + 1; l9 > 0; l9--) {
						double d11 = d150 * ad1[(j4 - 1) + (1 - 1) * i1 + l]
								+ d172 * ad1[(j4 - 1) + (2 - 1) * i1 + l];
						ad1[(j4 - 1) + (1 - 1) * i1 + l] = ad1[(j4 - 1)
								+ (1 - 1) * i1 + l]
								- d11 * d32;
						ad1[(j4 - 1) + (2 - 1) * i1 + l] = ad1[(j4 - 1)
								+ (2 - 1) * i1 + l]
								- d11 * d54;
						j4++;
					}

				}
			} else {
				double d31 = 1.0D - d * ad[(1 - 1) + k] * ad[(1 - 1) + k];
				int i4 = 1;
				for (int k9 = (i - 1) + 1; k9 > 0; k9--) {
					ad1[(i4 - 1) + (1 - 1) * i1 + l] = d31
							* ad1[(i4 - 1) + (1 - 1) * i1 + l];
					i4++;
				}

			}
		}
	}
}

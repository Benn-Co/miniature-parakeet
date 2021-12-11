package org.netlib.lapack;

import org.netlib.blas.Ddot;
import org.netlib.blas.Dscal;
import org.netlib.blas.Lsame;
import org.netlib.err.Xerbla;
import org.netlib.util.Util;
import org.netlib.util.doubleW;
import org.netlib.util.intW;

public final class Dtrsyl {

    public static void dtrsyl(String s, String s1, int i, int j, int k, double ad[], int l, int i1, double ad1[],
            int j1, int k1, double ad2[], int l1, int i2, doubleW doublew, intW intw) {

        boolean flag = false;
        boolean flag1 = false;
        intW intw1 = new intW(0);
        doubleW doublew1 = new doubleW(0.0);
        double d15 = 0.0;
        doubleW doublew2 = new doubleW(0.0);
        double d16 = 0.0;
        double d17 = 0.0;
        doubleW doublew3 = new doubleW(0.0);
        doubleW doublew4 = new doubleW(0.0);
        double ad3[] = new double[1];
        double ad4[] = new double[2 * 2];
        double ad5[] = new double[2 * 2];
        flag = Lsame.lsame(s, "N");
        flag1 = Lsame.lsame(s1, "N");
        intw.val = 0;
        if ((!flag && !Lsame.lsame(s, "T")) && !Lsame.lsame(s, "C"))
            intw.val = -1;
        else if ((!flag1 && !Lsame.lsame(s1, "T")) && !Lsame.lsame(s1, "C"))
            intw.val = -2;
        else if (i != 1 && i != -1)
            intw.val = -3;
        else if (j < 0)
            intw.val = -4;
        else if (k < 0)
            intw.val = -5;
        else if (i1 < Math.max(1, j))
            intw.val = -7;
        else if (k1 < Math.max(1, k))
            intw.val = -9;
        else if (i2 < Math.max(1, j))
            intw.val = -11;
        if (intw.val != 0) {
            Xerbla.xerbla("DTRSYL", -intw.val);
            return;
        }
        if (j == 0 || k == 0) {
            return;
        }
        d15 = Dlamch.dlamch("P");
        doublew3.val = Dlamch.dlamch("S");
        doublew1.val = 1.0 / doublew3.val;
        Dlabad.dlabad(doublew3, doublew1);
        doublew3.val = (doublew3.val * (j * k)) / d15;
        doublew1.val = 1.0 / doublew3.val;
        d17 = Util.max(doublew3.val, d15 * Dlange.dlange("M", j, j, ad, l, i1, ad3, 0),
                d15 * Dlange.dlange("M", k, k, ad1, j1, k1, ad3, 0));
        doublew.val = 1.0;
        d16 = i;
        if (flag && flag1) {
            int j13 = 1;
            int j10 = 1;
            for (int j14 = k; j14 > 0; j14--) {
                if (j10 >= j13) {
                    int j11;
                    int j12;
                    if (j10 == k) {
                        j11 = j10;
                        j12 = j10;
                    } else if (ad1[j10 + (j10 - 1) * k1 + j1] != 0.0) {
                        j11 = j10;
                        j12 = j10 + 1;
                        j13 = j10 + 2;
                    } else {
                        j11 = j10;
                        j12 = j10;
                        j13 = j10 + 1;
                    }
                    int j9 = j;
                    int j6 = j;
                    for (int j15 = j; j15 > 0; j15--) {
                        if (j6 <= j9) {
                            int j7;
                            int j8;
                            if (j6 == 1) {
                                j7 = j6;
                                j8 = j6;
                            } else if (ad[(j6 - 1) + (j6 - 2) * i1 + l] != 0.0) {
                                j7 = j6 - 1;
                                j8 = j6;
                                j9 = j6 - 2;
                            } else {
                                j7 = j6;
                                j8 = j6;
                                j9 = j6 - 1;
                            }
                            if (j11 == j12 && j7 == j8) {
                                double d19 = Ddot.ddot(j - j7, ad, (j7 - 1) + (Math.min(j7 + 1, j) - 1) * i1 + l, i1,
                                        ad2, (Math.min(j7 + 1, j) - 1) + (j11 - 1) * i2 + l1, 1);
                                double d36 = Ddot.ddot(j11 - 1, ad2, (j7 - 1) + l1, i2, ad1, (j11 - 1) * k1 + j1, 1);
                                ad4[0] = ad2[(j7 - 1) + (j11 - 1) * i2 + l1] - (d19 + d16 * d36);
                                doublew2.val = 1.0;
                                double d1 = ad[(j7 - 1) + (j7 - 1) * i1 + l]
                                        + d16 * ad1[(j11 - 1) + (j11 - 1) * k1 + j1];
                                double d6 = Math.abs(d1);
                                if (d6 <= d17) {
                                    d1 = d17;
                                    d6 = d17;
                                    intw.val = 1;
                                }
                                double d11 = Math.abs(ad4[0]);
                                if ((d6 < 1.0 && d11 > 1.0) && (d11 > doublew1.val * d6))
                                    doublew2.val = 1.0 / d11;
                                ad5[0] = (ad4[0] * doublew2.val) / d1;
                                if (doublew2.val != 1.0) {
                                    int j2 = 1;
                                    for (int j16 = k; j16 > 0; j16--) {
                                        Dscal.dscal(j, doublew2.val, ad2, (j2 - 1) * i2 + l1, 1);
                                        j2++;
                                    }

                                    doublew.val = doublew.val * doublew2.val;
                                }
                                ad2[(j7 - 1) + (j11 - 1) * i2 + l1] = ad5[0];
                            } else if (j11 == j12 && j7 != j8) {
                                double d20 = Ddot.ddot(j - j8, ad, (j7 - 1) + (Math.min(j8 + 1, j) - 1) * i1 + l, i1,
                                        ad2, (Math.min(j8 + 1, j) - 1) + (j11 - 1) * i2 + l1, 1);
                                double d37 = Ddot.ddot(j11 - 1, ad2, (j7 - 1) + l1, i2, ad1, (j11 - 1) * k1 + j1, 1);
                                ad4[0] = ad2[(j7 - 1) + (j11 - 1) * i2 + l1] - (d20 + d16 * d37);
                                d20 = Ddot.ddot(j - j8, ad, (j8 - 1) + (Math.min(j8 + 1, j) - 1) * i1 + l, i1, ad2,
                                        (Math.min(j8 + 1, j) - 1) + (j11 - 1) * i2 + l1, 1);
                                d37 = Ddot.ddot(j11 - 1, ad2, (j8 - 1) + l1, i2, ad1, (j11 - 1) * k1 + j1, 1);
                                ad4[1] = ad2[(j8 - 1) + (j11 - 1) * i2 + l1] - (d20 + d16 * d37);
                                Dlaln2.dlaln2(false, 2, 1, d17, 1.0, ad, (j7 - 1) + (j7 - 1) * i1 + l, i1, 1.0, 1.0,
                                        ad4, 0, 2, -(d16 * ad1[(j11 - 1) + (j11 - 1) * k1 + j1]), 0.0, ad5, 0, 2,
                                        doublew2, doublew4, intw1);
                                if (intw1.val != 0)
                                    intw.val = 1;
                                if (doublew2.val != 1.0) {
                                    int k2 = 1;
                                    for (int k16 = k; k16 > 0; k16--) {
                                        Dscal.dscal(j, doublew2.val, ad2, (k2 - 1) * i2 + l1, 1);
                                        k2++;
                                    }

                                    doublew.val = doublew.val * doublew2.val;
                                }
                                ad2[(j7 - 1) + (j11 - 1) * i2 + l1] = ad5[0];
                                ad2[(j8 - 1) + (j11 - 1) * i2 + l1] = ad5[1];
                            } else if (j11 != j12 && j7 == j8) {
                                double d21 = Ddot.ddot(j - j7, ad, (j7 - 1) + (Math.min(j7 + 1, j) - 1) * i1 + l, i1,
                                        ad2, (Math.min(j7 + 1, j) - 1) + (j11 - 1) * i2 + l1, 1);
                                double d38 = Ddot.ddot(j11 - 1, ad2, (j7 - 1) + l1, i2, ad1, (j11 - 1) * k1 + j1, 1);
                                ad4[0] = d16 * (ad2[(j7 - 1) + (j11 - 1) * i2 + l1] - (d21 + d16 * d38));
                                d21 = Ddot.ddot(j - j7, ad, (j7 - 1) + (Math.min(j7 + 1, j) - 1) * i1 + l, i1, ad2,
                                        (Math.min(j7 + 1, j) - 1) + (j12 - 1) * i2 + l1, 1);
                                d38 = Ddot.ddot(j11 - 1, ad2, (j7 - 1) + l1, i2, ad1, (j12 - 1) * k1 + j1, 1);
                                ad4[1] = d16 * (ad2[(j7 - 1) + (j12 - 1) * i2 + l1] - (d21 + d16 * d38));
                                Dlaln2.dlaln2(true, 2, 1, d17, 1.0, ad1, (j11 - 1) + (j11 - 1) * k1 + j1, k1, 1.0, 1.0,
                                        ad4, 0, 2, -(d16 * ad[(j7 - 1) + (j7 - 1) * i1 + l]), 0.0, ad5, 0, 2, doublew2,
                                        doublew4, intw1);
                                if (intw1.val != 0)
                                    intw.val = 1;
                                if (doublew2.val != 1.0) {
                                    int l2 = 1;
                                    for (int l16 = k; l16 > 0; l16--) {
                                        Dscal.dscal(j, doublew2.val, ad2, (l2 - 1) * i2 + l1, 1);
                                        l2++;
                                    }

                                    doublew.val = doublew.val * doublew2.val;
                                }
                                ad2[(j7 - 1) + (j11 - 1) * i2 + l1] = ad5[0];
                                ad2[(j7 - 1) + (j12 - 1) * i2 + l1] = ad5[1];
                            } else if (j11 != j12 && j7 != j8) {
                                double d22 = Ddot.ddot(j - j8, ad, (j7 - 1) + (Math.min(j8 + 1, j) - 1) * i1 + l, i1,
                                        ad2, (Math.min(j8 + 1, j) - 1) + (j11 - 1) * i2 + l1, 1);
                                double d39 = Ddot.ddot(j11 - 1, ad2, (j7 - 1) + l1, i2, ad1, (j11 - 1) * k1 + j1, 1);
                                ad4[0] = ad2[(j7 - 1) + (j11 - 1) * i2 + l1] - (d22 + d16 * d39);
                                d22 = Ddot.ddot(j - j8, ad, (j7 - 1) + (Math.min(j8 + 1, j) - 1) * i1 + l, i1, ad2,
                                        (Math.min(j8 + 1, j) - 1) + (j12 - 1) * i2 + l1, 1);
                                d39 = Ddot.ddot(j11 - 1, ad2, (j7 - 1) + l1, i2, ad1, (j12 - 1) * k1 + j1, 1);
                                ad4[2] = ad2[(j7 - 1) + (j12 - 1) * i2 + l1] - (d22 + d16 * d39);
                                d22 = Ddot.ddot(j - j8, ad, (j8 - 1) + (Math.min(j8 + 1, j) - 1) * i1 + l, i1, ad2,
                                        (Math.min(j8 + 1, j) - 1) + (j11 - 1) * i2 + l1, 1);
                                d39 = Ddot.ddot(j11 - 1, ad2, (j8 - 1) + l1, i2, ad1, (j11 - 1) * k1 + j1, 1);
                                ad4[1] = ad2[(j8 - 1) + (j11 - 1) * i2 + l1] - (d22 + d16 * d39);
                                d22 = Ddot.ddot(j - j8, ad, (j8 - 1) + (Math.min(j8 + 1, j) - 1) * i1 + l, i1, ad2,
                                        (Math.min(j8 + 1, j) - 1) + (j12 - 1) * i2 + l1, 1);
                                d39 = Ddot.ddot(j11 - 1, ad2, (j8 - 1) + l1, i2, ad1, (1 - 1) + (j12 - 1) * k1 + j1, 1);
                                ad4[3] = ad2[(j8 - 1) + (j12 - 1) * i2 + l1] - (d22 + d16 * d39);
                                Dlasy2.dlasy2(false, false, i, 2, 2, ad, (j7 - 1) + (j7 - 1) * i1 + l, i1, ad1,
                                        (j11 - 1) + (j11 - 1) * k1 + j1, k1, ad4, 0, 2, doublew2, ad5, 0, 2, doublew4,
                                        intw1);
                                if (intw1.val != 0)
                                    intw.val = 1;
                                if (doublew2.val != 1.0) {
                                    int i3 = 1;
                                    for (int i17 = k; i17 > 0; i17--) {
                                        Dscal.dscal(j, doublew2.val, ad2, (i3 - 1) * i2 + l1, 1);
                                        i3++;
                                    }

                                    doublew.val = doublew.val * doublew2.val;
                                }
                                ad2[(j7 - 1) + (j11 - 1) * i2 + l1] = ad5[0];
                                ad2[(j7 - 1) + (j12 - 1) * i2 + l1] = ad5[2];
                                ad2[(j8 - 1) + (j11 - 1) * i2 + l1] = ad5[1];
                                ad2[(j8 - 1) + (j12 - 1) * i2 + l1] = ad5[3];
                            }
                        }
                        j6--;
                    }

                }
                j10++;
            }

        } else if (!flag && flag1) {
            int k13 = 1;
            int k10 = 1;
            for (int k14 = k; k14 > 0; k14--) {
                if (k10 >= k13) {
                    int k11;
                    int k12;
                    if (k10 == k) {
                        k11 = k10;
                        k12 = k10;
                    } else if (ad1[k10 + (k10 - 1) * k1 + j1] != 0.0) {
                        k11 = k10;
                        k12 = k10 + 1;
                        k13 = k10 + 2;
                    } else {
                        k11 = k10;
                        k12 = k10;
                        k13 = k10 + 1;
                    }
                    int k9 = 1;
                    int k6 = 1;
                    for (int k15 = j; k15 > 0; k15--) {
                        if (k6 >= k9) {
                            int k7;
                            int k8;
                            if (k6 == j) {
                                k7 = k6;
                                k8 = k6;
                            } else if (ad[k6 + (k6 - 1) * i1 + l] != 0.0) {
                                k7 = k6;
                                k8 = k6 + 1;
                                k9 = k6 + 2;
                            } else {
                                k7 = k6;
                                k8 = k6;
                                k9 = k6 + 1;
                            }
                            if (k11 == k12 && k7 == k8) {
                                double d23 = Ddot.ddot(k7 - 1, ad, (k7 - 1) * i1 + l, 1, ad2, (k11 - 1) * i2 + l1, 1);
                                double d40 = Ddot.ddot(k11 - 1, ad2, (k7 - 1) + l1, i2, ad1, (k11 - 1) * k1 + j1, 1);
                                ad4[0] = ad2[(k7 - 1) + (k11 - 1) * i2 + l1] - (d23 + d16 * d40);
                                doublew2.val = 1.0;
                                double d2 = ad[(k7 - 1) + (k7 - 1) * i1 + l]
                                        + d16 * ad1[(k11 - 1) + (k11 - 1) * k1 + j1];
                                double d7 = Math.abs(d2);
                                if (d7 <= d17) {
                                    d2 = d17;
                                    d7 = d17;
                                    intw.val = 1;
                                }
                                double d12 = Math.abs(ad4[0]);
                                if ((d7 < 1.0 && d12 > 1.0) && (d12 > doublew1.val * d7))
                                    doublew2.val = 1.0 / d12;
                                ad5[0] = (ad4[0] * doublew2.val) / d2;
                                if (doublew2.val != 1.0) {
                                    int j3 = 1;
                                    for (int j17 = k; j17 > 0; j17--) {
                                        Dscal.dscal(j, doublew2.val, ad2, (j3 - 1) * i2 + l1, 1);
                                        j3++;
                                    }

                                    doublew.val = doublew.val * doublew2.val;
                                }
                                ad2[(k7 - 1) + (k11 - 1) * i2 + l1] = ad5[0];
                            } else if (k11 == k12 && k7 != k8) {
                                double d24 = Ddot.ddot(k7 - 1, ad, (k7 - 1) * i1 + l, 1, ad2, (k11 - 1) * i2 + l1, 1);
                                double d41 = Ddot.ddot(k11 - 1, ad2, (k7 - 1) + l1, i2, ad1, (k11 - 1) * k1 + j1, 1);
                                ad4[0] = ad2[(k7 - 1) + (k11 - 1) * i2 + l1] - (d24 + d16 * d41);
                                d24 = Ddot.ddot(k7 - 1, ad, (k8 - 1) * i1 + l, 1, ad2, (k11 - 1) * i2 + l1, 1);
                                d41 = Ddot.ddot(k11 - 1, ad2, (k8 - 1) + l1, i2, ad1, (k11 - 1) * k1 + j1, 1);
                                ad4[1] = ad2[(k8 - 1) + (k11 - 1) * i2 + l1] - (d24 + d16 * d41);
                                Dlaln2.dlaln2(true, 2, 1, d17, 1.0, ad, (k7 - 1) + (k7 - 1) * i1 + l, i1, 1.0, 1.0, ad4,
                                        0, 2, -(d16 * ad1[(k11 - 1) + (k11 - 1) * k1 + j1]), 0.0, ad5, 0, 2, doublew2,
                                        doublew4, intw1);
                                if (intw1.val != 0)
                                    intw.val = 1;
                                if (doublew2.val != 1.0) {
                                    int k3 = 1;
                                    for (int k17 = k; k17 > 0; k17--) {
                                        Dscal.dscal(j, doublew2.val, ad2, (k3 - 1) * i2 + l1, 1);
                                        k3++;
                                    }

                                    doublew.val = doublew.val * doublew2.val;
                                }
                                ad2[(k7 - 1) + (k11 - 1) * i2 + l1] = ad5[0];
                                ad2[(k8 - 1) + (k11 - 1) * i2 + l1] = ad5[1];
                            } else if (k11 != k12 && k7 == k8) {
                                double d25 = Ddot.ddot(k7 - 1, ad, (k7 - 1) * i1 + l, 1, ad2, (k11 - 1) * i2 + l1, 1);
                                double d42 = Ddot.ddot(k11 - 1, ad2, (k7 - 1) + l1, i2, ad1, (k11 - 1) * k1 + j1, 1);
                                ad4[0] = d16 * (ad2[(k7 - 1) + (k11 - 1) * i2 + l1] - (d25 + d16 * d42));
                                d25 = Ddot.ddot(k7 - 1, ad, (k7 - 1) * i1 + l, 1, ad2, (k12 - 1) * i2 + l1, 1);
                                d42 = Ddot.ddot(k11 - 1, ad2, (k7 - 1) + l1, i2, ad1, (k12 - 1) * k1 + j1, 1);
                                ad4[1] = d16 * (ad2[(k7 - 1) + (k12 - 1) * i2 + l1] - (d25 + d16 * d42));
                                Dlaln2.dlaln2(true, 2, 1, d17, 1.0, ad1, (k11 - 1) + (k11 - 1) * k1 + j1, k1, 1.0, 1.0,
                                        ad4, 0, 2, -(d16 * ad[(k7 - 1) + (k7 - 1) * i1 + l]), 0.0, ad5, 0, 2, doublew2,
                                        doublew4, intw1);
                                if (intw1.val != 0)
                                    intw.val = 1;
                                if (doublew2.val != 1.0) {
                                    int l3 = 1;
                                    for (int l17 = k; l17 > 0; l17--) {
                                        Dscal.dscal(j, doublew2.val, ad2, (l3 - 1) * i2 + l1, 1);
                                        l3++;
                                    }

                                    doublew.val = doublew.val * doublew2.val;
                                }
                                ad2[(k7 - 1) + (k11 - 1) * i2 + l1] = ad5[0];
                                ad2[(k7 - 1) + (k12 - 1) * i2 + l1] = ad5[1];
                            } else if (k11 != k12 && k7 != k8) {
                                double d26 = Ddot.ddot(k7 - 1, ad, (k7 - 1) * i1 + l, 1, ad2, (k11 - 1) * i2 + l1, 1);
                                double d43 = Ddot.ddot(k11 - 1, ad2, (k7 - 1) + l1, i2, ad1, (k11 - 1) * k1 + j1, 1);
                                ad4[0] = ad2[(k7 - 1) + (k11 - 1) * i2 + l1] - (d26 + d16 * d43);
                                d26 = Ddot.ddot(k7 - 1, ad, (k7 - 1) * i1 + l, 1, ad2, (k12 - 1) * i2 + l1, 1);
                                d43 = Ddot.ddot(k11 - 1, ad2, (k7 - 1) + l1, i2, ad1, (k12 - 1) * k1 + j1, 1);
                                ad4[2] = ad2[(k7 - 1) + (k12 - 1) * i2 + l1] - (d26 + d16 * d43);
                                d26 = Ddot.ddot(k7 - 1, ad, (k8 - 1) * i1 + l, 1, ad2, (k11 - 1) * i2 + l1, 1);
                                d43 = Ddot.ddot(k11 - 1, ad2, (k8 - 1) + l1, i2, ad1, (k11 - 1) * k1 + j1, 1);
                                ad4[1] = ad2[(k8 - 1) + (k11 - 1) * i2 + l1] - (d26 + d16 * d43);
                                d26 = Ddot.ddot(k7 - 1, ad, (k8 - 1) * i1 + l, 1, ad2, (k12 - 1) * i2 + l1, 1);
                                d43 = Ddot.ddot(k11 - 1, ad2, (k8 - 1) + l1, i2, ad1, (k12 - 1) * k1 + j1, 1);
                                ad4[3] = ad2[(k8 - 1) + (k12 - 1) * i2 + l1] - (d26 + d16 * d43);
                                Dlasy2.dlasy2(true, false, i, 2, 2, ad, (k7 - 1) + (k7 - 1) * i1 + l, i1, ad1,
                                        (k11 - 1) + (k11 - 1) * k1 + j1, k1, ad4, 0, 2, doublew2, ad5, 0, 2, doublew4,
                                        intw1);
                                if (intw1.val != 0)
                                    intw.val = 1;
                                if (doublew2.val != 1.0) {
                                    int i4 = 1;
                                    for (int i18 = k; i18 > 0; i18--) {
                                        Dscal.dscal(j, doublew2.val, ad2, (i4 - 1) * i2 + l1, 1);
                                        i4++;
                                    }

                                    doublew.val = doublew.val * doublew2.val;
                                }
                                ad2[(k7 - 1) + (k11 - 1) * i2 + l1] = ad5[0];
                                ad2[(k7 - 1) + (k12 - 1) * i2 + l1] = ad5[2];
                                ad2[(k8 - 1) + (k11 - 1) * i2 + l1] = ad5[1];
                                ad2[(k8 - 1) + (k12 - 1) * i2 + l1] = ad5[3];
                            }
                        }
                        k6++;
                    }

                }
                k10++;
            }

        } else if (!flag && !flag1) {
            int l13 = k;
            int l10 = k;
            for (int l14 = k; l14 > 0; l14--) {
                if (l10 <= l13) {
                    int l11;
                    int l12;
                    if (l10 == 1) {
                        l11 = l10;
                        l12 = l10;
                    } else if (ad1[(l10 - 1) + (l10 - 2) * k1 + j1] != 0.0) {
                        l11 = l10 - 1;
                        l12 = l10;
                        l13 = l10 - 2;
                    } else {
                        l11 = l10;
                        l12 = l10;
                        l13 = l10 - 1;
                    }
                    int l9 = 1;
                    int l6 = 1;
                    for (int l15 = j; l15 > 0; l15--) {
                        if (l6 >= l9) {
                            int l7;
                            int l8;
                            if (l6 == j) {
                                l7 = l6;
                                l8 = l6;
                            } else if (ad[l6 + (l6 - 1) * i1 + l] != 0.0) {
                                l7 = l6;
                                l8 = l6 + 1;
                                l9 = l6 + 2;
                            } else {
                                l7 = l6;
                                l8 = l6;
                                l9 = l6 + 1;
                            }
                            if (l11 == l12 && l7 == l8) {
                                double d27 = Ddot.ddot(l7 - 1, ad, (l7 - 1) * i1 + l, 1, ad2, (l11 - 1) * i2 + l1, 1);
                                double d44 = Ddot.ddot(k - l11, ad2, (l7 - 1) + (Math.min(l11 + 1, k) - 1) * i2 + l1,
                                        i2, ad1, (l11 - 1) + (Math.min(l11 + 1, k) - 1) * k1 + j1, k1);
                                ad4[0] = ad2[(l7 - 1) + (l11 - 1) * i2 + l1] - (d27 + d16 * d44);
                                doublew2.val = 1.0;
                                double d3 = ad[(l7 - 1) + (l7 - 1) * i1 + l]
                                        + d16 * ad1[(l11 - 1) + (l11 - 1) * k1 + j1];
                                double d8 = Math.abs(d3);
                                if (d8 <= d17) {
                                    d3 = d17;
                                    d8 = d17;
                                    intw.val = 1;
                                }
                                double d13 = Math.abs(ad4[0]);
                                if ((d8 < 1.0 && d13 > 1.0) && (d13 > doublew1.val * d8))
                                    doublew2.val = 1.0 / d13;
                                ad5[0] = (ad4[0] * doublew2.val) / d3;
                                if (doublew2.val != 1.0) {
                                    int j4 = 1;
                                    for (int j18 = k; j18 > 0; j18--) {
                                        Dscal.dscal(j, doublew2.val, ad2, (j4 - 1) * i2 + l1, 1);
                                        j4++;
                                    }

                                    doublew.val = doublew.val * doublew2.val;
                                }
                                ad2[(l7 - 1) + (l11 - 1) * i2 + l1] = ad5[0];
                            } else if (l11 == l12 && l7 != l8) {
                                double d28 = Ddot.ddot(l7 - 1, ad, (l7 - 1) * i1 + l, 1, ad2, (l11 - 1) * i2 + l1, 1);
                                double d45 = Ddot.ddot(k - l12, ad2, (l7 - 1) + (Math.min(l12 + 1, k) - 1) * i2 + l1,
                                        i2, ad1, (l11 - 1) + (Math.min(l12 + 1, k) - 1) * k1 + j1, k1);
                                ad4[0] = ad2[(l7 - 1) + (l11 - 1) * i2 + l1] - (d28 + d16 * d45);
                                d28 = Ddot.ddot(l7 - 1, ad, (l8 - 1) * i1 + l, 1, ad2, (l11 - 1) * i2 + l1, 1);
                                d45 = Ddot.ddot(k - l12, ad2, (l8 - 1) + (Math.min(l12 + 1, k) - 1) * i2 + l1, i2, ad1,
                                        (l11 - 1) + (Math.min(l12 + 1, k) - 1) * k1 + j1, k1);
                                ad4[1] = ad2[(l8 - 1) + (l11 - 1) * i2 + l1] - (d28 + d16 * d45);
                                Dlaln2.dlaln2(true, 2, 1, d17, 1.0, ad, (l7 - 1) + (l7 - 1) * i1 + l, i1, 1.0, 1.0, ad4,
                                        0, 2, -(d16 * ad1[(l11 - 1) + (l11 - 1) * k1 + j1]), 0.0, ad5, 0, 2, doublew2,
                                        doublew4, intw1);
                                if (intw1.val != 0)
                                    intw.val = 1;
                                if (doublew2.val != 1.0) {
                                    int k4 = 1;
                                    for (int k18 = k; k18 > 0; k18--) {
                                        Dscal.dscal(j, doublew2.val, ad2, (k4 - 1) * i2 + l1, 1);
                                        k4++;
                                    }

                                    doublew.val = doublew.val * doublew2.val;
                                }
                                ad2[(l7 - 1) + (l11 - 1) * i2 + l1] = ad5[0];
                                ad2[(l8 - 1) + (l11 - 1) * i2 + l1] = ad5[1];
                            } else if (l11 != l12 && l7 == l8) {
                                double d29 = Ddot.ddot(l7 - 1, ad, (l7 - 1) * i1 + l, 1, ad2, (l11 - 1) * i2 + l1, 1);
                                double d46 = Ddot.ddot(k - l12, ad2, (l7 - 1) + (Math.min(l12 + 1, k) - 1) * i2 + l1,
                                        i2, ad1, (l11 - 1) + (Math.min(l12 + 1, k) - 1) * k1 + j1, k1);
                                ad4[0] = d16 * (ad2[(l7 - 1) + (l11 - 1) * i2 + l1] - (d29 + d16 * d46));
                                d29 = Ddot.ddot(l7 - 1, ad, (l7 - 1) * i1 + l, 1, ad2, (l12 - 1) * i2 + l1, 1);
                                d46 = Ddot.ddot(k - l12, ad2, (l7 - 1) + (Math.min(l12 + 1, k) - 1) * i2 + l1, i2, ad1,
                                        (l12 - 1) + (Math.min(l12 + 1, k) - 1) * k1 + j1, k1);
                                ad4[1] = d16 * (ad2[(l7 - 1) + (l12 - 1) * i2 + l1] - (d29 + d16 * d46));
                                Dlaln2.dlaln2(false, 2, 1, d17, 1.0, ad1, (l11 - 1) + (l11 - 1) * k1 + j1, k1, 1.0, 1.0,
                                        ad4, 0, 2, -(d16 * ad[(l7 - 1) + (l7 - 1) * i1 + l]), 0.0, ad5, 0, 2, doublew2,
                                        doublew4, intw1);
                                if (intw1.val != 0)
                                    intw.val = 1;
                                if (doublew2.val != 1.0) {
                                    int l4 = 1;
                                    for (int l18 = k; l18 > 0; l18--) {
                                        Dscal.dscal(j, doublew2.val, ad2, (l4 - 1) * i2 + l1, 1);
                                        l4++;
                                    }

                                    doublew.val = doublew.val * doublew2.val;
                                }
                                ad2[(l7 - 1) + (l11 - 1) * i2 + l1] = ad5[0];
                                ad2[(l7 - 1) + (l12 - 1) * i2 + l1] = ad5[1];
                            } else if (l11 != l12 && l7 != l8) {
                                double d30 = Ddot.ddot(l7 - 1, ad, (l7 - 1) * i1 + l, 1, ad2, (l11 - 1) * i2 + l1, 1);
                                double d47 = Ddot.ddot(k - l12, ad2, (l7 - 1) + (Math.min(l12 + 1, k) - 1) * i2 + l1,
                                        i2, ad1, (l11 - 1) + (Math.min(l12 + 1, k) - 1) * k1 + j1, k1);
                                ad4[0] = ad2[(l7 - 1) + (l11 - 1) * i2 + l1] - (d30 + d16 * d47);
                                d30 = Ddot.ddot(l7 - 1, ad, (l7 - 1) * i1 + l, 1, ad2, (l12 - 1) * i2 + l1, 1);
                                d47 = Ddot.ddot(k - l12, ad2, (l7 - 1) + (Math.min(l12 + 1, k) - 1) * i2 + l1, i2, ad1,
                                        (l12 - 1) + (Math.min(l12 + 1, k) - 1) * k1 + j1, k1);
                                ad4[2] = ad2[(l7 - 1) + (l12 - 1) * i2 + l1] - (d30 + d16 * d47);
                                d30 = Ddot.ddot(l7 - 1, ad, (l8 - 1) * i1 + l, 1, ad2, (l11 - 1) * i2 + l1, 1);
                                d47 = Ddot.ddot(k - l12, ad2, (l8 - 1) + (Math.min(l12 + 1, k) - 1) * i2 + l1, i2, ad1,
                                        (l11 - 1) + (Math.min(l12 + 1, k) - 1) * k1 + j1, k1);
                                ad4[1] = ad2[(l8 - 1) + (l11 - 1) * i2 + l1] - (d30 + d16 * d47);
                                d30 = Ddot.ddot(l7 - 1, ad, (l8 - 1) * i1 + l, 1, ad2, (l12 - 1) * i2 + l1, 1);
                                d47 = Ddot.ddot(k - l12, ad2, (l8 - 1) + (Math.min(l12 + 1, k) - 1) * i2 + l1, i2, ad1,
                                        (l12 - 1) + (Math.min(l12 + 1, k) - 1) * k1 + j1, k1);
                                ad4[3] = ad2[(l8 - 1) + (l12 - 1) * i2 + l1] - (d30 + d16 * d47);
                                Dlasy2.dlasy2(true, true, i, 2, 2, ad, (l7 - 1) + (l7 - 1) * i1 + l, i1, ad1,
                                        (l11 - 1) + (l11 - 1) * k1 + j1, k1, ad4, 0, 2, doublew2, ad5, 0, 2, doublew4,
                                        intw1);
                                if (intw1.val != 0)
                                    intw.val = 1;
                                if (doublew2.val != 1.0) {
                                    int i5 = 1;
                                    for (int i19 = k; i19 > 0; i19--) {
                                        Dscal.dscal(j, doublew2.val, ad2, (i5 - 1) * i2 + l1, 1);
                                        i5++;
                                    }

                                    doublew.val = doublew.val * doublew2.val;
                                }
                                ad2[(l7 - 1) + (l11 - 1) * i2 + l1] = ad5[0];
                                ad2[(l7 - 1) + (l12 - 1) * i2 + l1] = ad5[2];
                                ad2[(l8 - 1) + (l11 - 1) * i2 + l1] = ad5[1];
                                ad2[(l8 - 1) + (l12 - 1) * i2 + l1] = ad5[3];
                            }
                        }
                        l6++;
                    }

                }
                l10--;
            }

        } else if (flag && !flag1) {
            int i14 = k;
            int i11 = k;
            for (int i15 = k; i15 > 0; i15--) {
                if (i11 <= i14) {
                    int i12;
                    int i13;
                    if (i11 == 1) {
                        i12 = i11;
                        i13 = i11;
                    } else if (ad1[(i11 - 1) + (i11 - 2) * k1 + j1] != 0.0) {
                        i12 = i11 - 1;
                        i13 = i11;
                        i14 = i11 - 2;
                    } else {
                        i12 = i11;
                        i13 = i11;
                        i14 = i11 - 1;
                    }
                    int i10 = j;
                    int i7 = j;
                    for (int i16 = j; i16 > 0; i16--) {
                        if (i7 <= i10) {
                            int i8;
                            int i9;
                            if (i7 == 1) {
                                i8 = i7;
                                i9 = i7;
                            } else if (ad[(i7 - 1) + (i7 - 2) * i1 + l] != 0.0) {
                                i8 = i7 - 1;
                                i9 = i7;
                                i10 = i7 - 2;
                            } else {
                                i8 = i7;
                                i9 = i7;
                                i10 = i7 - 1;
                            }
                            if (i12 == i13 && i8 == i9) {
                                double d31 = Ddot.ddot(j - i8, ad, (i8 - 1) + (Math.min(i8 + 1, j) - 1) * i1 + l, i1,
                                        ad2, (Math.min(i8 + 1, j) - 1) + (i12 - 1) * i2 + l1, 1);
                                double d48 = Ddot.ddot(k - i12, ad2, (i8 - 1) + (Math.min(i12 + 1, k) - 1) * i2 + l1,
                                        i2, ad1, (i12 - 1) + (Math.min(i12 + 1, k) - 1) * k1 + j1, k1);
                                ad4[0] = ad2[(i8 - 1) + (i12 - 1) * i2 + l1] - (d31 + d16 * d48);
                                doublew2.val = 1.0;
                                double d4 = ad[(i8 - 1) + (i8 - 1) * i1 + l]
                                        + d16 * ad1[(i12 - 1) + (i12 - 1) * k1 + j1];
                                double d9 = Math.abs(d4);
                                if (d9 <= d17) {
                                    d4 = d17;
                                    d9 = d17;
                                    intw.val = 1;
                                }
                                double d14 = Math.abs(ad4[0]);
                                if ((d9 < 1.0 && d14 > 1.0) && (d14 > doublew1.val * d9))
                                    doublew2.val = 1.0 / d14;
                                ad5[0] = (ad4[0] * doublew2.val) / d4;
                                if (doublew2.val != 1.0) {
                                    int j5 = 1;
                                    for (int j19 = k; j19 > 0; j19--) {
                                        Dscal.dscal(j, doublew2.val, ad2, (j5 - 1) * i2 + l1, 1);
                                        j5++;
                                    }

                                    doublew.val = doublew.val * doublew2.val;
                                }
                                ad2[(i8 - 1) + (i12 - 1) * i2 + l1] = ad5[0];
                            } else if (i12 == i13 && i8 != i9) {
                                double d32 = Ddot.ddot(j - i9, ad, (i8 - 1) + (Math.min(i9 + 1, j) - 1) * i1 + l, i1,
                                        ad2, (Math.min(i9 + 1, j) - 1) + (i12 - 1) * i2 + l1, 1);
                                double d49 = Ddot.ddot(k - i13, ad2, (i8 - 1) + (Math.min(i13 + 1, k) - 1) * i2 + l1,
                                        i2, ad1, (i12 - 1) + (Math.min(i13 + 1, k) - 1) * k1 + j1, k1);
                                ad4[0] = ad2[(i8 - 1) + (i12 - 1) * i2 + l1] - (d32 + d16 * d49);
                                d32 = Ddot.ddot(j - i9, ad, (i9 - 1) + (Math.min(i9 + 1, j) - 1) * i1 + l, i1, ad2,
                                        (Math.min(i9 + 1, j) - 1) + (i12 - 1) * i2 + l1, 1);
                                d49 = Ddot.ddot(k - i13, ad2, (i9 - 1) + (Math.min(i13 + 1, k) - 1) * i2 + l1, i2, ad1,
                                        (i12 - 1) + (Math.min(i13 + 1, k) - 1) * k1 + j1, k1);
                                ad4[1] = ad2[(i9 - 1) + (i12 - 1) * i2 + l1] - (d32 + d16 * d49);
                                Dlaln2.dlaln2(false, 2, 1, d17, 1.0, ad, (i8 - 1) + (i8 - 1) * i1 + l, i1, 1.0, 1.0,
                                        ad4, 0, 2, -(d16 * ad1[(i12 - 1) + (i12 - 1) * k1 + j1]), 0.0, ad5, 0, 2,
                                        doublew2, doublew4, intw1);
                                if (intw1.val != 0)
                                    intw.val = 1;
                                if (doublew2.val != 1.0) {
                                    int k5 = 1;
                                    for (int k19 = k; k19 > 0; k19--) {
                                        Dscal.dscal(j, doublew2.val, ad2, (k5 - 1) * i2 + l1, 1);
                                        k5++;
                                    }

                                    doublew.val = doublew.val * doublew2.val;
                                }
                                ad2[(i8 - 1) + (i12 - 1) * i2 + l1] = ad5[0];
                                ad2[(i9 - 1) + (i12 - 1) * i2 + l1] = ad5[1];
                            } else if (i12 != i13 && i8 == i9) {
                                double d33 = Ddot.ddot(j - i8, ad, (i8 - 1) + (Math.min(i8 + 1, j) - 1) * i1 + l, i1,
                                        ad2, (Math.min(i8 + 1, j) - 1) + (i12 - 1) * i2 + l1, 1);
                                double d50 = Ddot.ddot(k - i13, ad2, (i8 - 1) + (Math.min(i13 + 1, k) - 1) * i2 + l1,
                                        i2, ad1, (i12 - 1) + (Math.min(i13 + 1, k) - 1) * k1 + j1, k1);
                                ad4[0] = d16 * (ad2[(i8 - 1) + (i12 - 1) * i2 + l1] - (d33 + d16 * d50));
                                d33 = Ddot.ddot(j - i8, ad, (i8 - 1) + (Math.min(i8 + 1, j) - 1) * i1 + l, i1, ad2,
                                        (Math.min(i8 + 1, j) - 1) + (i13 - 1) * i2 + l1, 1);
                                d50 = Ddot.ddot(k - i13, ad2, (i8 - 1) + (Math.min(i13 + 1, k) - 1) * i2 + l1, i2, ad1,
                                        (i13 - 1) + (Math.min(i13 + 1, k) - 1) * k1 + j1, k1);
                                ad4[1] = d16 * (ad2[(i8 - 1) + (i13 - 1) * i2 + l1] - (d33 + d16 * d50));
                                Dlaln2.dlaln2(false, 2, 1, d17, 1.0, ad1, (i12 - 1) + (i12 - 1) * k1 + j1, k1, 1.0, 1.0,
                                        ad4, 0, 2, -(d16 * ad[(i8 - 1) + (i8 - 1) * i1 + l]), 0.0, ad5, 0, 2, doublew2,
                                        doublew4, intw1);
                                if (intw1.val != 0)
                                    intw.val = 1;
                                if (doublew2.val != 1.0) {
                                    int l5 = 1;
                                    for (int l19 = k; l19 > 0; l19--) {
                                        Dscal.dscal(j, doublew2.val, ad2, (l5 - 1) * i2 + l1, 1);
                                        l5++;
                                    }

                                    doublew.val = doublew.val * doublew2.val;
                                }
                                ad2[(i8 - 1) + (i12 - 1) * i2 + l1] = ad5[0];
                                ad2[(i8 - 1) + (i13 - 1) * i2 + l1] = ad5[1];
                            } else if (i12 != i13 && i8 != i9) {
                                double d34 = Ddot.ddot(j - i9, ad, (i8 - 1) + (Math.min(i9 + 1, j) - 1) * i1 + l, i1,
                                        ad2, (Math.min(i9 + 1, j) - 1) + (i12 - 1) * i2 + l1, 1);
                                double d51 = Ddot.ddot(k - i13, ad2, (i8 - 1) + (Math.min(i13 + 1, k) - 1) * i2 + l1,
                                        i2, ad1, (i12 - 1) + (Math.min(i13 + 1, k) - 1) * k1 + j1, k1);
                                ad4[0] = ad2[(i8 - 1) + (i12 - 1) * i2 + l1] - (d34 + d16 * d51);
                                d34 = Ddot.ddot(j - i9, ad, (i8 - 1) + (Math.min(i9 + 1, j) - 1) * i1 + l, i1, ad2,
                                        (Math.min(i9 + 1, j) - 1) + (i13 - 1) * i2 + l1, 1);
                                d51 = Ddot.ddot(k - i13, ad2, (i8 - 1) + (Math.min(i13 + 1, k) - 1) * i2 + l1, i2, ad1,
                                        (i13 - 1) + (Math.min(i13 + 1, k) - 1) * k1 + j1, k1);
                                ad4[2] = ad2[(i8 - 1) + (i13 - 1) * i2 + l1] - (d34 + d16 * d51);
                                d34 = Ddot.ddot(j - i9, ad, (i9 - 1) + (Math.min(i9 + 1, j) - 1) * i1 + l, i1, ad2,
                                        (Math.min(i9 + 1, j) - 1) + (i12 - 1) * i2 + l1, 1);
                                d51 = Ddot.ddot(k - i13, ad2, (i9 - 1) + (Math.min(i13 + 1, k) - 1) * i2 + l1, i2, ad1,
                                        (i12 - 1) + (Math.min(i13 + 1, k) - 1) * k1 + j1, k1);
                                ad4[1] = ad2[(i9 - 1) + (i12 - 1) * i2 + l1] - (d34 + d16 * d51);
                                d34 = Ddot.ddot(j - i9, ad, (i9 - 1) + (Math.min(i9 + 1, j) - 1) * i1 + l, i1, ad2,
                                        (Math.min(i9 + 1, j) - 1) + (i13 - 1) * i2 + l1, 1);
                                d51 = Ddot.ddot(k - i13, ad2, (i9 - 1) + (Math.min(i13 + 1, k) - 1) * i2 + l1, i2, ad1,
                                        (i13 - 1) + (Math.min(i13 + 1, k) - 1) * k1 + j1, k1);
                                ad4[3] = ad2[(i9 - 1) + (i13 - 1) * i2 + l1] - (d34 + d16 * d51);
                                Dlasy2.dlasy2(false, true, i, 2, 2, ad, (i8 - 1) + (i8 - 1) * i1 + l, i1, ad1,
                                        (i12 - 1) + (i12 - 1) * k1 + j1, k1, ad4, 0, 2, doublew2, ad5, 0, 2, doublew4,
                                        intw1);
                                if (intw1.val != 0)
                                    intw.val = 1;
                                if (doublew2.val != 1.0) {
                                    int i6 = 1;
                                    for (int i20 = k; i20 > 0; i20--) {
                                        Dscal.dscal(j, doublew2.val, ad2, (i6 - 1) * i2 + l1, 1);
                                        i6++;
                                    }

                                    doublew.val = doublew.val * doublew2.val;
                                }
                                ad2[(i8 - 1) + (i12 - 1) * i2 + l1] = ad5[0];
                                ad2[(i8 - 1) + (i13 - 1) * i2 + l1] = ad5[2];
                                ad2[(i9 - 1) + (i12 - 1) * i2 + l1] = ad5[1];
                                ad2[(i9 - 1) + (i13 - 1) * i2 + l1] = ad5[3];
                            }
                        }
                        i7--;
                    }

                }
                i11--;
            }
        }
    }
}

package org.netlib.lapack;

import org.netlib.blas.Dcopy;
import org.netlib.blas.Dgemm;
import org.netlib.blas.Dtrmm;
import org.netlib.blas.Lsame;

// DLARFB applies a real block reflector H or its transpose H**T
// to a real m by n matrix C, from either the left or the right.
public final class Dlarfb {

    public static void dlarfb(String side, String trans, String direct, String storev, int m, int n, int k, double[] v,
            int _v_offset, int ldv, double[] t, int _t_offset, int ldt, double[] c, int _c_offset, int ldc,
            double[] work, int _work_offset, int ldwork) {

        if (m <= 0 || n <= 0) {
            return;
        }

        String transt;
        if (Lsame.lsame(trans, "N")) {
            transt = "T";
        } else {
            transt = "N";
        }

        if (Lsame.lsame(storev, "C")) {
            if (Lsame.lsame(direct, "F")) {
                if (Lsame.lsame(side, "L")) {
                    int j = 1;
                    for (int p = k; p > 0; p--) {
                        Dcopy.dcopy(n, c, (j - 1) + _c_offset, ldc, work, (j - 1) * ldwork + _work_offset, 1);
                        j++;
                    }

                    Dtrmm.dtrmm("Right", "Lower", "No transpose", "Unit", n, k, 1.0, v, _v_offset, ldv, work,
                            _work_offset, ldwork);
                    if (m > k) {
                        Dgemm.dgemm("Transpose", "No transpose", n, k, m - k, 1.0, c, k + _c_offset, ldc, v,
                                k + _v_offset, ldv, 1.0, work, _work_offset, ldwork);
                    }
                    Dtrmm.dtrmm("Right", "Upper", transt, "Non-unit", n, k, 1.0, t, _t_offset, ldt, work, _work_offset,
                            ldwork);
                    if (m > k) {
                        Dgemm.dgemm("No transpose", "Transpose", m - k, n, k, -1.0, v, k + _v_offset, ldv, work,
                                _work_offset, ldwork, 1.0, c, k + _c_offset, ldc);
                    }
                    Dtrmm.dtrmm("Right", "Lower", "Transpose", "Unit", n, k, 1.0, v, _v_offset, ldv, work, _work_offset,
                            ldwork);
                    j = 1;
                    for (int p = k; p > 0; p--) {
                        int i = 1;
                        for (int q = n; q > 0; q--) {
                            c[(j - 1) + (i - 1) * ldc + _c_offset] = c[(j - 1) + (i - 1) * ldc + _c_offset]
                                    - work[(i - 1) + (j - 1) * ldwork + _work_offset];
                            i++;
                        }

                        j++;
                    }

                } else if (Lsame.lsame(side, "R")) {
                    int j = 1;
                    for (int p = k; p > 0; p--) {
                        Dcopy.dcopy(m, c, (j - 1) * ldc + _c_offset, 1, work, (j - 1) * ldwork + _work_offset, 1);
                        j++;
                    }

                    Dtrmm.dtrmm("Right", "Lower", "No transpose", "Unit", m, k, 1.0, v, _v_offset, ldv, work,
                            _work_offset, ldwork);
                    if (n > k) {
                        Dgemm.dgemm("No transpose", "No transpose", m, k, n - k, 1.0, c, k * ldc + _c_offset, ldc, v,
                                k * ldv + _v_offset, ldv, 1.0, work, _work_offset, ldwork);
                    }
                    Dtrmm.dtrmm("Right", "Upper", trans, "Non-unit", m, k, 1.0, t, _t_offset, ldt, work, _work_offset,
                            ldwork);
                    if (n > k) {
                        Dgemm.dgemm("No transpose", "Transpose", m, n - k, k, -1.0, work, _work_offset, ldwork, v,
                                k + _v_offset, ldv, 1.0, c, k * ldc + _c_offset, ldc);
                    }
                    Dtrmm.dtrmm("Right", "Lower", "Transpose", "Unit", m, k, 1.0, v, _v_offset, ldv, work, _work_offset,
                            ldwork);
                    j = 1;
                    for (int p = k; p > 0; p--) {
                        int i = 1;
                        for (int q = m; q > 0; q--) {
                            c[(i - 1) + (j - 1) * ldc + _c_offset] = c[(i - 1) + (j - 1) * ldc + _c_offset]
                                    - work[(i - 1) + (j - 1) * ldwork + _work_offset];
                            i++;
                        }

                        j++;
                    }

                }
            } else if (Lsame.lsame(side, "L")) {
                int j = 1;
                for (int p = k; p > 0; p--) {
                    Dcopy.dcopy(n, c, ((m - k) + j - 1) + _c_offset, ldc, work, (j - 1) * ldwork + _work_offset, 1);
                    j++;
                }

                Dtrmm.dtrmm("Right", "Upper", "No transpose", "Unit", n, k, 1.0, v, (m - k) + _v_offset, ldv, work,
                        _work_offset, ldwork);
                if (m > k) {
                    Dgemm.dgemm("Transpose", "No transpose", n, k, m - k, 1.0, c, _c_offset, ldc, v, _v_offset, ldv,
                            1.0, work, _work_offset, ldwork);
                }
                Dtrmm.dtrmm("Right", "Lower", transt, "Non-unit", n, k, 1.0, t, _t_offset, ldt, work, _work_offset,
                        ldwork);
                if (m > k) {
                    Dgemm.dgemm("No transpose", "Transpose", m - k, n, k, -1.0, v, _v_offset, ldv, work, _work_offset,
                            ldwork, 1.0, c, _c_offset, ldc);
                }
                Dtrmm.dtrmm("Right", "Upper", "Transpose", "Unit", n, k, 1.0, v, (m - k) + _v_offset, ldv, work,
                        _work_offset, ldwork);
                j = 1;
                for (int p = k; p > 0; p--) {
                    int i = 1;
                    for (int q = n; q > 0; q--) {
                        c[(((m - k) + j) - 1) + (i - 1) * ldc
                                + _c_offset] = c[(((m - k) + j) - 1) + (i - 1) * ldc + _c_offset]
                                        - work[(i - 1) + (j - 1) * ldwork + _work_offset];
                        i++;
                    }

                    j++;
                }

            } else if (Lsame.lsame(side, "R")) {
                int j = 1;
                for (int p = k; p > 0; p--) {
                    Dcopy.dcopy(m, c, (((n - k) + j) - 1) * ldc + _c_offset, 1, work, (j - 1) * ldwork + _work_offset,
                            1);
                    j++;
                }

                Dtrmm.dtrmm("Right", "Upper", "No transpose", "Unit", m, k, 1.0, v, (n - k) + _v_offset, ldv, work,
                        _work_offset, ldwork);
                if (n > k) {
                    Dgemm.dgemm("No transpose", "No transpose", m, k, n - k, 1.0, c, _c_offset, ldc, v, _v_offset, ldv,
                            1.0, work, _work_offset, ldwork);
                }
                Dtrmm.dtrmm("Right", "Lower", trans, "Non-unit", m, k, 1.0, t, _t_offset, ldt, work, _work_offset,
                        ldwork);
                if (n > k) {
                    Dgemm.dgemm("No transpose", "Transpose", m, n - k, k, -1.0, work, _work_offset, ldwork, v,
                            _v_offset, ldv, 1.0, c, _c_offset, ldc);
                }
                Dtrmm.dtrmm("Right", "Upper", "Transpose", "Unit", m, k, 1.0, v, (n - k) + _v_offset, ldv, work,
                        _work_offset, ldwork);
                j = 1;
                for (int p = k; p > 0; p--) {
                    int i = 1;
                    for (int q = m; q > 0; q--) {
                        c[(i - 1) + (((n - k) + j) - 1) * ldc
                                + _c_offset] = c[(i - 1) + (((n - k) + j) - 1) * ldc + _c_offset]
                                        - work[(i - 1) + (j - 1) * ldwork + _work_offset];
                        i++;
                    }

                    j++;
                }

            }
        } else if (Lsame.lsame(storev, "R"))
            if (Lsame.lsame(direct, "F")) {
                if (Lsame.lsame(side, "L")) {
                    int j = 1;
                    for (int p = k; p > 0; p--) {
                        Dcopy.dcopy(n, c, (j - 1) + _c_offset, ldc, work, (j - 1) * ldwork + _work_offset, 1);
                        j++;
                    }

                    Dtrmm.dtrmm("Right", "Upper", "Transpose", "Unit", n, k, 1.0, v, _v_offset, ldv, work, _work_offset,
                            ldwork);
                    if (m > k) {
                        Dgemm.dgemm("Transpose", "Transpose", n, k, m - k, 1.0, c, k + _c_offset, ldc, v,
                                k * ldv + _v_offset, ldv, 1.0, work, _work_offset, ldwork);
                    }
                    Dtrmm.dtrmm("Right", "Upper", transt, "Non-unit", n, k, 1.0, t, _t_offset, ldt, work, _work_offset,
                            ldwork);
                    if (m > k) {
                        Dgemm.dgemm("Transpose", "Transpose", m - k, n, k, -1.0, v, k * ldv + _v_offset, ldv, work,
                                _work_offset, ldwork, 1.0, c, k + _c_offset, ldc);
                    }
                    Dtrmm.dtrmm("Right", "Upper", "No transpose", "Unit", n, k, 1.0, v, _v_offset, ldv, work,
                            _work_offset, ldwork);
                    j = 1;
                    for (int p = k; p > 0; p--) {
                        int i = 1;
                        for (int q = n; q > 0; q--) {
                            c[(j - 1) + (i - 1) * ldc + _c_offset] = c[(j - 1) + (i - 1) * ldc + _c_offset]
                                    - work[(i - 1) + (j - 1) * ldwork + _work_offset];
                            i++;
                        }

                        j++;
                    }

                } else if (Lsame.lsame(side, "R")) {
                    int j = 1;
                    for (int p = k; p > 0; p--) {
                        Dcopy.dcopy(m, c, (j - 1) * ldc + _c_offset, 1, work, (j - 1) * ldwork + _work_offset, 1);
                        j++;
                    }

                    Dtrmm.dtrmm("Right", "Upper", "Transpose", "Unit", m, k, 1.0, v, _v_offset, ldv, work, _work_offset,
                            ldwork);
                    if (n > k) {
                        Dgemm.dgemm("No transpose", "Transpose", m, k, n - k, 1.0, c, k * ldc + _c_offset, ldc, v,
                                k * ldv + _v_offset, ldv, 1.0, work, _work_offset, ldwork);
                    }
                    Dtrmm.dtrmm("Right", "Upper", trans, "Non-unit", m, k, 1.0, t, _t_offset, ldt, work, _work_offset,
                            ldwork);
                    if (n > k) {
                        Dgemm.dgemm("No transpose", "No transpose", m, n - k, k, -1.0, work, _work_offset, ldwork, v,
                                k * ldv + _v_offset, ldv, 1.0, c, k * ldc + _c_offset, ldc);
                    }
                    Dtrmm.dtrmm("Right", "Upper", "No transpose", "Unit", m, k, 1.0, v, _v_offset, ldv, work,
                            _work_offset, ldwork);
                    j = 1;
                    for (int p = k; p > 0; p--) {
                        int i = 1;
                        for (int q = m; q > 0; q--) {
                            c[(i - 1) + (j - 1) * ldc + _c_offset] = c[(i - 1) + (j - 1) * ldc + _c_offset]
                                    - work[(i - 1) + (j - 1) * ldwork + _work_offset];
                            i++;
                        }

                        j++;
                    }

                }
            } else if (Lsame.lsame(side, "L")) {
                int j = 1;
                for (int p = k; p > 0; p--) {
                    Dcopy.dcopy(n, c, (m - k) + j - 1 + _c_offset, ldc, work, (j - 1) * ldwork + _work_offset, 1);
                    j++;
                }

                Dtrmm.dtrmm("Right", "Lower", "Transpose", "Unit", n, k, 1.0, v, (m - k) * ldv + _v_offset, ldv, work,
                        _work_offset, ldwork);
                if (m > k) {
                    Dgemm.dgemm("Transpose", "Transpose", n, k, m - k, 1.0, c, _c_offset, ldc, v, _v_offset, ldv, 1.0,
                            work, _work_offset, ldwork);
                }
                Dtrmm.dtrmm("Right", "Lower", transt, "Non-unit", n, k, 1.0, t, _t_offset, ldt, work, _work_offset,
                        ldwork);
                if (m > k) {
                    Dgemm.dgemm("Transpose", "Transpose", m - k, n, k, -1.0, v, _v_offset, ldv, work, _work_offset,
                            ldwork, 1.0, c, _c_offset, ldc);
                }
                Dtrmm.dtrmm("Right", "Lower", "No transpose", "Unit", n, k, 1.0, v, (m - k) * ldv + _v_offset, ldv,
                        work, _work_offset, ldwork);
                j = 1;
                for (int p = k; p > 0; p--) {
                    int i = 1;
                    for (int q = n; q > 0; q--) {
                        c[((m - k) + j - 1) + (i - 1) * ldc
                                + _c_offset] = c[((m - k) + j - 1) + (i - 1) * ldc + _c_offset]
                                        - work[(i - 1) + (j - 1) * ldwork + _work_offset];
                        i++;
                    }

                    j++;
                }

            } else if (Lsame.lsame(side, "R")) {
                int j = 1;
                for (int p = k; p > 0; p--) {
                    Dcopy.dcopy(m, c, ((n - k) + j - 1) * ldc + _c_offset, 1, work, (j - 1) * ldwork + _work_offset, 1);
                    j++;
                }

                Dtrmm.dtrmm("Right", "Lower", "Transpose", "Unit", m, k, 1.0, v, (n - k) * ldv + _v_offset, ldv, work,
                        _work_offset, ldwork);
                if (n > k) {
                    Dgemm.dgemm("No transpose", "Transpose", m, k, n - k, 1.0, c, _c_offset, ldc, v, _v_offset, ldv,
                            1.0, work, _work_offset, ldwork);
                }
                Dtrmm.dtrmm("Right", "Lower", trans, "Non-unit", m, k, 1.0, t, _t_offset, ldt, work, _work_offset,
                        ldwork);
                if (n > k) {
                    Dgemm.dgemm("No transpose", "No transpose", m, n - k, k, -1.0, work, _work_offset, ldwork, v,
                            _v_offset, ldv, 1.0, c, _c_offset, ldc);
                }
                Dtrmm.dtrmm("Right", "Lower", "No transpose", "Unit", m, k, 1.0, v, (n - k) * ldv + _v_offset, ldv,
                        work, _work_offset, ldwork);
                j = 1;
                for (int p = k; p > 0; p--) {
                    int i = 1;
                    for (int q = m; q > 0; q--) {
                        c[(i - 1) + ((n - k) + j - 1) * ldc
                                + _c_offset] = c[(i - 1) + ((n - k) + j - 1) * ldc + _c_offset]
                                        - work[(i - 1) + (j - 1) * ldwork + _work_offset];
                        i++;
                    }

                    j++;
                }

            }
    }
}

package org.netlib.lapack;

import org.netlib.blas.Dgemv;
import org.netlib.blas.Dger;
import org.netlib.blas.Lsame;

// DLARF applies a real elementary reflector H to a
// real m by n matrix C, from either the left or the
// right. H is represented in the form
//
//       H = I - tau * v * v**T
//
// where tau is a real scalar and v is a real vector.
//
// If tau = 0, then H is taken to be the unit matrix.
public final class Dlarf {

    public static void dlarf(String side, int m, int n, double[] v, int _v_offset, int incv, double tau, double[] c,
            int _c_offset, int ldc, double[] work, int _work_offset) {

        if (Lsame.lsame(side, "L")) {
            if (tau != 0.0) {
                Dgemv.dgemv("Transpose", m, n, 1.0, c, _c_offset, ldc, v, _v_offset, incv, 0.0, work, _work_offset, 1);
                Dger.dger(m, n, -tau, v, _v_offset, incv, work, _work_offset, 1, c, _c_offset, ldc);
            }
        } else if (tau != 0.0) {
            Dgemv.dgemv("No transpose", m, n, 1.0, c, _c_offset, ldc, v, _v_offset, incv, 0.0, work, _work_offset, 1);
            Dger.dger(m, n, -tau, work, _work_offset, 1, v, _v_offset, incv, c, _c_offset, ldc);
        }
    }
}

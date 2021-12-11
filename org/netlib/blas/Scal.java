package org.netlib.blas;

//
// Compute X *= alpha
//
final class Scal {

    static void scal(int n, double alpha, double[] x, int xOff, int incX) {
        if (alpha != 1.0 && alpha != 0.0) {
            for (int i = 0; i < n; ++i) {
                x[xOff + i * incX] *= alpha;
            }
        } else if (alpha == 0.0) {
            for (int i = 0; i < n; ++i) {
                x[xOff + i * incX] *= 0.0;
            }
        }
    }

    private Scal() {
        throw new AssertionError();
    }
}

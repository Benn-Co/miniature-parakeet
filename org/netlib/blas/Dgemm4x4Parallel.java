package org.netlib.blas;

import java.util.ArrayList;
import java.util.concurrent.Future;

import org.netlib.blas.DgemmTasks.TaskConfig;

final class Dgemm4x4Parallel {

    //
    // Compute C <- beta*C + alpha*A*B
    //
    static int dgemm(int nb, int kb, int mb, int _nc, int _kc, int _mc, double alpha, int offA, double[] A, int incRowA,
            int incColA, int offB, double[] B, int incRowB, int incColB, double beta, int offC, double[] C, int incRowC,
            int incColC) {

        if (nb <= 1 && kb <= 1 && mb <= 1) {
            throw new AssertionError("nb=" + nb + ", kb=" + kb + ", mb=" + mb);
        }
        if (DgemmTasks.availableCores() < 2) {
            throw new AssertionError("can't parallelize: cores = " + DgemmTasks.availableCores());
        }

        DgemmTasks.TaskConfig[] cfgs = DgemmTasks.split(nb, kb, mb);
        ArrayList<Future<Integer>> results = new ArrayList<>(cfgs.length);
        for (TaskConfig cfg : cfgs) {
            Dgemm4x4Worker task = new Dgemm4x4Worker(cfg, _nc, _kc, _mc, alpha, offA, A, incRowA, incColA, offB, B,
                    incRowB, incColB, beta, offC, C, incRowC, incColC);
            Future<Integer> calls = ThreadPool.submit(task);
            results.add(calls);
        }
        int micro_kernel_calls = 0;
        for (Future<Integer> res : results) {
            try {
                micro_kernel_calls += res.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return micro_kernel_calls;
    }
}

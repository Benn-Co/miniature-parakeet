package org.netlib.blas;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// simplest thing that can possibly work
final class ThreadPool {

    static Future<Integer> submit(Callable<Integer> computation) {
        return exec.submit(computation);
    }

    private static final ThreadPoolExecutor exec = new ThreadPoolExecutor(DgemmTasks.availableCores(),
            2 * DgemmTasks.availableCores(), 2, TimeUnit.MINUTES, new SynchronousQueue<Runnable>(),
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r);
                    t.setName(ThreadPool.class.getName() + "-" + cnt.getAndIncrement());
                    t.setDaemon(true);
                    return t;
                }
            });

    private static final AtomicInteger cnt = new AtomicInteger(1);
}

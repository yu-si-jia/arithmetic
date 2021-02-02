package juc.lockk.reentrantlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author andor
 * @date 2020/9/3
 * @desc
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            TestRunnable testRunnable = new TestRunnable();
            executorService.submit(testRunnable);
        }
        executorService.shutdown();

    }
}

class TestRunnable implements Runnable {
    long count = 0;
    Lock reentrantLockDemo = new ReentrantLock(false);

    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            reentrantLockDemo.lock();
            try {
                count++;
                System.out.println(String.format("tname: %s, count:%d", Thread.currentThread().getName(), count));
            } finally {
                reentrantLockDemo.unlock();
            }
        }
    }
}


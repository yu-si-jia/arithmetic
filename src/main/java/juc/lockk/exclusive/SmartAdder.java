package juc.lockk.exclusive;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author andor
 * @date 2020/9/3
 * @desc
 */
public class SmartAdder {
    private volatile int counter;
    private SmartLock lock;

    public SmartAdder() {
        lock = new SmartLock();
    }

    public void increase() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unLock();
        }
    }

    public int getCounter() {
        return this.counter;
    }

    public static void main(String[] args) {
        int threadCount = 20;
        int addCount = 100;
        SmartAdder smartAdder = new SmartAdder();
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount*2; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < addCount; j++) {
                    smartAdder.increase();
                }
                countDownLatch.countDown();
            });
        }
        try {
            // 等待任务执行完
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count:" + smartAdder.getCounter());
        executorService.shutdown();

    }
}

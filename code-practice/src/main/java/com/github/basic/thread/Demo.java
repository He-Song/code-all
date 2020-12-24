package com.github.basic.thread;

import java.util.concurrent.*;

/**
 * @Author: hesong
 * @Describe:
 * @Date: 2020/12/14 9:58
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        // cyclicBarrierTest();
        // countDownLatchTest();
        // semaphoreTest();

        threadPoolCountDownLatch();

    }

    private static void threadPoolCountDownLatch() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10));
        int count = 15;
        CountDownLatch countDownLatch = new CountDownLatch(count);

        Long old = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {

            threadPoolExecutor.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        System.out.println("循环完成 等待所有结束");
        countDownLatch.await();
        System.out.println("所有线程执行完成" + (System.currentTimeMillis() - old));
        threadPoolExecutor.shutdownNow();
    }

    private static void semaphoreTest() {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    // do something...
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "，进入停车");
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "，停车结束，离开");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    semaphore.release();
                }

            }, String.valueOf(i)).start();
        }
    }

    private static void countDownLatchTest() throws InterruptedException {
        final int count = 10;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(new WorkRunnable(countDownLatch, i)).start();
        }
        System.out.println("for 循环完成");
        countDownLatch.await();
        System.out.println("所有线程执行完成");
    }

    static class WorkRunnable implements Runnable {

        private CountDownLatch countDownLatch;

        private final int i;

        public WorkRunnable(CountDownLatch countDownLatch, int i) {
            this.countDownLatch = countDownLatch;
            this.i = i;
        }

        @Override
        public void run() {
            try {
                work(i);
            } catch (Exception e) {
                System.out.println("报错了");
            } finally {
                countDownLatch.countDown();
            }
        }

        private void work(int i) {
            System.out.println(String.format("第%s个线程在工作", i));
        }
    }

    private static void cyclicBarrierTest() {
        // 定义个数
        int count = 7;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count, () -> System.out.println("搜集完成"));
        for (int i = 0; i < count; i++) {
            int temp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ", i = " + temp);
                try {

                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }

}

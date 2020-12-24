package com.github.basic.thread;

import java.util.Locale;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程的启动方式
 * 1. runnable
 * 2. thread
 * 3. callable
 * 4. 线程池
 */
class MyThread implements Runnable {

    @Override
    public void run() {

    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            flag = false;
        }
    }
}

class MyThread3 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "************* callable come in");
        return "返回信息";
    }
}

/**
 * @Author: hesong
 * @Describe:
 * @Date: 2020/12/15 11:06
 */
public class MyThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // ThreadExecutorTest();
        System.out.println(test());
        System.out.println(test());
        System.out.println(String.format(Locale.ENGLISH, "%s 嘻嘻", "中文"));
    }

    private static Long test() {
        final AtomicLong l = new AtomicLong();

        return l.incrementAndGet();
    }

    private static void ThreadExecutorTest() throws InterruptedException, ExecutionException {
        // MyThread2 myThread2 = new MyThread2();
        // myThread2.start();
        System.out.println(Runtime.getRuntime().availableProcessors());
        FutureTask<String> futureTask = new FutureTask<>(new MyThread3());
        Thread thread = new Thread(futureTask, "AAA");
        thread.start();
        System.out.println(futureTask.get());
        // thread.start();
        System.out.println(futureTask.get());

        // 四种拒绝策略
        new ThreadPoolExecutor.CallerRunsPolicy();
        new ThreadPoolExecutor.AbortPolicy();
        new ThreadPoolExecutor.DiscardOldestPolicy();
        new ThreadPoolExecutor.DiscardPolicy();

        // Executors 工具类自带的四种线程池
        Executors.newFixedThreadPool(1);
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(5);
    }

}

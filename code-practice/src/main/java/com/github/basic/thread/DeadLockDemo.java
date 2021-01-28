package com.github.basic.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: hesong
 * @Describe: 死锁Demo
 * @Date: 2021/1/4 14:51
 */
class HoldLockThread implements Runnable {

    private String lockA;

    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            List a = new ArrayList<>();
            // a.forEach();
            System.out
                .println(String.format("当前线程：%s 持有锁： %s,尝试获取锁：%s", Thread.currentThread().getName(), lockA, lockB));

            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(String.format("当前线程：%s 成功获取锁：%s", Thread.currentThread().getName(), lockB));

            }

        }

    }
}

/**
 * 死锁demo
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        // String lockC = "lockC";

        new Thread(new HoldLockThread(lockA, lockB), "AAA").start();
        new Thread(new HoldLockThread(lockB, lockA), "BBB").start();
    }
}
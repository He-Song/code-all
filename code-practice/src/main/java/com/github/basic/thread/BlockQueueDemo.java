package com.github.basic.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: hesong
 * @Describe:
 * @Date: 2020/12/14 11:26
 *
 * 题目：多线程之间按顺序调用，实现A>B>C 三个线程启动，要求如下
 * AAA 打印5次， BB 打印10次， CCC打印15次
 * 紧接着
 * AAA 打印5次， BB 打印10次， CCC打印15次
 * ......
 * 来10轮
 *
 */
public class BlockQueueDemo {
    public static void main(String[] args) {
        PrintClass printClass = new PrintClass();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // do something...
                printClass.printXTimes(1);
            }
        }, "AAA").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // do something...
                printClass.printXTimes(2);
            }
        }, "BBB").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // do something...
                printClass.printXTimes(3);
            }
        }, "CCC").start();
    }

    private static void blockingQueueTest() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.element());
    }
}

class PrintClass {
    private int number = 1;

    private static Lock lock = new ReentrantLock();

    private static Condition[] conditions = new Condition[3];

    static {
        conditions[0] = lock.newCondition();
        conditions[1] = lock.newCondition();
        conditions[2] = lock.newCondition();
    }

    // 1判断
    public void printXTimes(int num) {
        lock.lock();
        try {
            while (this.number != num) {
                conditions[num - 1].await();
            }

            // 2干活
            print(num * 5);
            // 3通知
            this.number = number + 1 > 3 ? 1 : ++number;
            conditions[number - 1].signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    void print(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(Thread.currentThread().getName() + "打印第" + (i + 1) + "次");
        }
    }

}

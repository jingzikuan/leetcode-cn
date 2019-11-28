package com.jzk.exec.leetcode.thread.p1116.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

import org.apache.log4j.Logger;

import com.jzk.exec.leetcode.thread.lock.Task;

public class ZeroEvenOddTest {
    Logger logger = Logger.getLogger(ZeroEvenOddTest.class);
    
    private final Lock lock = new ReentrantLock();
    private final Condition zeroCondition = lock.newCondition();
    private final Condition evenCondition = lock.newCondition();
    private final Condition oddCondition = lock.newCondition();
    private static int index = 0;
    private int n;
    
    public ZeroEvenOddTest(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        System.out.println("zero lock.lock() before");
        lock.lock();
        System.out.println("zero lock.lock() end");
        try {
            while(index < n) {
                index++;
                printNumber.accept(0);
                if(index % 2 == 0) {
                    System.out.println("zero invoke evenCondition.signal()");
                    evenCondition.signal();
                } else {
                    System.out.println("zero invoke oddCondition.signal()");
                    oddCondition.signal();
                }
                System.out.println("zero invoke zeroCondition.await()");
                zeroCondition.await();
            }
        }finally {
            System.out.println("zero finally");
            index++;
            oddCondition.signal();
            evenCondition.signal();
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        System.out.println("even lock.lock() before");
        lock.lock();
        System.out.println("even lock.lock() end");
        try {
            if(index == 0) {
                System.out.println("even index == 0, zeroCondition.signal(), evenCondition.await()");
                zeroCondition.signal();
                evenCondition.await();
            }
            while(index <= n) {
                logger.error("even: index=" + index);
                printNumber.accept(index);
                System.out.println("even invoke zeroCondition.signal()");
                zeroCondition.signal();
                System.out.println("even invoke evenCondition.await()");
                evenCondition.await();
            }
        }finally {
            System.out.println("even finally");
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        System.out.println("odd lock.lock() before");
        lock.lock();
        System.out.println("odd lock.lock() end");
        try {
            if(index == 0) {
                System.out.println("odd index == 0, zeroCondition.signal(), oddCondition.await()");
                zeroCondition.signal();
                oddCondition.await();
            }
            while(index <= n) {
                logger.error("odd: index=" + index);
                printNumber.accept(index);
                System.out.println("odd invoke zeroCondition.signal()");
                zeroCondition.signal();
                System.out.println("odd invoke oddCondition.await()");
                oddCondition.await();
            }
        }finally {
            System.out.println("odd finally");
            lock.unlock();
        }
    }
}

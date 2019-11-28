package com.jzk.exec.leetcode.thread.p1116;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private final Lock lock = new ReentrantLock();
    private final Condition zeroCondition = lock.newCondition();
    private final Condition evenCondition = lock.newCondition();
    private final Condition oddCondition = lock.newCondition();
    private static int index = 0;
    private int n;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while(index < n) {
                index++;
                printNumber.accept(0);
                if(index % 2 == 0) {
                    evenCondition.signal();
                } else {
                    oddCondition.signal();
                }
                zeroCondition.await();
            }
        }finally {
            index++;
            oddCondition.signal();
            evenCondition.signal();
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            if(index == 0) {
                zeroCondition.signal();
                evenCondition.await();
            }
            while(index <= n) {
                printNumber.accept(index);
                zeroCondition.signal();
                evenCondition.await();
            }
        }finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            if(index == 0) {
                zeroCondition.signal();
                oddCondition.await();
            }
            while(index <= n) {
                printNumber.accept(index);
                zeroCondition.signal();
                oddCondition.await();
            }
        }finally {
            lock.unlock();
        }
    }
}
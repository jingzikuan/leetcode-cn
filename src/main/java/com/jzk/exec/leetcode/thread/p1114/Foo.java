package com.jzk.exec.leetcode.thread.p1114;

import java.util.concurrent.CountDownLatch;

class Foo {
    public CountDownLatch countDownLatch1 = new CountDownLatch(1);
    public CountDownLatch countDownLatch2 = new CountDownLatch(1);
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        countDownLatch1.await();
        countDownLatch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

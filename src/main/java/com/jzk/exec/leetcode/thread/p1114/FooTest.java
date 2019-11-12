package com.jzk.exec.leetcode.thread.p1114;

import java.util.concurrent.CountDownLatch;

class FooTest {
    public CountDownLatch countDownLatch1 = new CountDownLatch(1);
    public CountDownLatch countDownLatch2 = new CountDownLatch(2);
    public FooTest() {

    }
    public void one() { System.out.println("one"); }
    public void two() { System.out.println("two"); }
    public void three() { System.out.println("three"); }
    
    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[] {1,2,3};
        FooTest foo = new FooTest();
        ThreadA a = new ThreadA(foo);
        ThreadB b = new ThreadB(foo);
        ThreadC c = new ThreadC(foo);
        a.start();
        b.start();
        c.start();
    }
}

class ThreadA extends Thread{
    private FooTest foo;
    
    public ThreadA(FooTest foo) {
        this.foo = foo;
    }
    
    @Override
    public void run() {
        foo.one();
        foo.countDownLatch1.countDown();
        foo.countDownLatch2.countDown();
    }
}

class ThreadB extends Thread{
    private FooTest foo;
    
    public ThreadB(FooTest foo) {
        this.foo = foo;
    }
    
    @Override
    public void run() {
        try {
            foo.countDownLatch1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        foo.two();
        foo.countDownLatch2.countDown();
    }
}

class ThreadC extends Thread{
    private FooTest foo;
    
    public ThreadC(FooTest foo) {
        this.foo = foo;
    }
    
    @Override
    public void run() {
        try {
            foo.countDownLatch1.await();
            foo.countDownLatch2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        foo.three();
    }
}

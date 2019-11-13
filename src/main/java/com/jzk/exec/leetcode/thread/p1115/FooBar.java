package com.jzk.exec.leetcode.thread.p1115;

public class FooBar {
    private Object lock = new Object();
    private boolean fooing = true;
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while(!fooing) {
                    lock.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooing = false;
                lock.notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while(fooing) {
                    lock.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                fooing = true;
                lock.notify();
            }
        }
    }
}
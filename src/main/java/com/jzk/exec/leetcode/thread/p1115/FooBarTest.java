package com.jzk.exec.leetcode.thread.p1115;

public class FooBarTest {
    private Object lock = new Object();
    private boolean fooing = true;
    private int n;

    public FooBarTest(int n) {
        this.n = n;
    }
    
    public void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while(!fooing) {
                    lock.wait();
                }
                System.out.print("foo");
                fooing = false;
                lock.notify();
            }
        }
    }
    
    public void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while(fooing) {
                    lock.wait();
                }
                System.out.print("bar");
                fooing = true;
                lock.notify();
            }
        }
    }
    
    public static void main(String[] args) {
        FooBarTest foobar = new FooBarTest(8);
        ThreadA a = new ThreadA(foobar);
        ThreadB b = new ThreadB(foobar);
        a.start();
        b.start();
    }
}
class ThreadA extends Thread{
    private FooBarTest foobar;
    
    public ThreadA(FooBarTest foobar) {
        this.foobar = foobar;
    }
    @Override
    public void run() {
        try {
            foobar.foo();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
class ThreadB extends Thread{
    private FooBarTest foobar;
    
    public ThreadB(FooBarTest foobar) {
        this.foobar = foobar;
    }
    @Override
    public void run() {
        try {
            foobar.bar();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
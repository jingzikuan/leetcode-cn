package com.jzk.exec.leetcode.thread.p1115;

public class FooBarTestN {
    private Object lock = new Object();
    private int order = 1;
    private int n;

    public FooBarTestN(int n) {
        this.n = n;
    }
    
    public void one() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while(order != 1) {
                    lock.wait();
                }
                System.out.print("1");
                order = 2;
                lock.notifyAll();
            }
        }
    }
    
    public void two() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while(order != 2) {
                    lock.wait();
                }
                System.out.print("2");
                order = 3;
                lock.notifyAll();
            }
        }
    }

    public void three() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while(order != 3) {
                    lock.wait();
                }
                System.out.print("3-");
                order = 1;
                lock.notifyAll();
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        FooBarTestN foobar = new FooBarTestN(81);
        ThreadC1 c1 = new ThreadC1(foobar);
        ThreadC2 c2 = new ThreadC2(foobar);
        ThreadC3 c3 = new ThreadC3(foobar);

        c1.start();
        c2.start();
        c3.start();
        
    }
}
class ThreadC1 extends Thread{
    private FooBarTestN foobar;
    
    public ThreadC1(FooBarTestN foobar) {
        this.foobar = foobar;
    }
    @Override
    public void run() {
        try {
            foobar.one();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
class ThreadC2 extends Thread{
    private FooBarTestN foobar;
    
    public ThreadC2(FooBarTestN foobar) {
        this.foobar = foobar;
    }
    @Override
    public void run() {
        try {
            foobar.two();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
class ThreadC3 extends Thread{
    private FooBarTestN foobar;
    
    public ThreadC3(FooBarTestN foobar) {
        this.foobar = foobar;
    }
    @Override
    public void run() {
        try {
            foobar.three();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
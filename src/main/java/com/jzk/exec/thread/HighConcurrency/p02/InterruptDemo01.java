package com.jzk.exec.thread.HighConcurrency.p02;

public class InterruptDemo01 {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    //if(Thread.currentThread().isInterrupted()) {
                    if(Thread.interrupted()) {
                        System.out.println("Interruted!"); 
                        break;
                    }
                    Thread.yield();
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
        t.interrupt();
    }

}

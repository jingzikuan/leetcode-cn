package com.jzk.exec.thread.HighConcurrency.p02;

public class InterruptDemo02 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        /**对于可取消的阻塞状态中的线程, 
                         * 比如等待在这些函数上的线程, Thread.sleep(), Object.wait(), Thread.join(), 
                         * 这个线程收到中断信号后, 
                         * 会抛出InterruptedException, 同时会把中断状态置回为false.
                         */
                        
                        System.out.println("Interruted When Sleep: " + e.getLocalizedMessage());
                        //设置中断状态，抛出异常后会清除中断标记位
                        System.out.println("before isInterrupted = " + Thread.currentThread().isInterrupted());
                        Thread.currentThread().interrupt();
                        System.out.println("after  isInterrupted = " + Thread.currentThread().isInterrupted());
                    }
                    Thread.yield();
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Interruted!");
                        break;
                    }
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
        t.interrupt();
        System.out.println("main t.isInterrupted = " + t.isInterrupted());
    }
}

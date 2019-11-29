package com.jzk.exec.thread.multithread.p02;

class Thread2 implements Runnable{
    private String name;
 
    public Thread2(String name) {
        this.name=name;
    }
 
    @Override
    public void run() {
          for (int i = 0; i < 12; i++) {
                System.out.println(name + "运行  :  " + i);
                try {
                    Thread.sleep((int) Math.random() * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread tc = new Thread(new Thread2("C"));
        Thread td = new Thread(new Thread2("D"));
//        tc.setPriority(Thread.MAX_PRIORITY);
//        td.setPriority(Thread.MIN_PRIORITY);
        td.start();
        tc.start();
        td.interrupt();
        tc.interrupt();
        
    }
}

package com.jzk.exec.thread.multithread.p01;

import org.apache.log4j.Logger;

public class Main {
    static Logger logger = Logger.getLogger(Main.class);
    static class Thread1 extends Thread{
        private String name;
        public Thread1(String name) {
           this.name=name;
        }
        public void run() {
            for (int i = 0; i < 5; i++) {
                logger.info(name + "运行  :  " + i);
                try {
                    sleep((int) Math.random() * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
           
        }
    }
    public static void main(String[] args) {
        Thread1 mTh1=new Thread1("A");
        Thread1 mTh2=new Thread1("B");
        mTh1.start();
        mTh1.start();
    }

}

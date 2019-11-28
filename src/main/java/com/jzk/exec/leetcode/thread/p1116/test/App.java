package com.jzk.exec.leetcode.thread.p1116.test;

import java.util.function.IntConsumer;

import org.apache.log4j.Logger;

public class App {
    private static Logger logger = Logger.getLogger(App.class);
    public static void main(String[] args) throws InterruptedException {
        IntConsumer printNumber = n -> logger.info(n);
        
        ZeroEvenOddTest test = new ZeroEvenOddTest(5);
        Thread t1 = new Thread("zero") {
            public void run() {
                try {
                    test.zero(printNumber);
                } catch (InterruptedException e) {
                    logger.error(e.getLocalizedMessage(), e);
                }
            }
        };
        Thread t2 = new Thread("even") {
            public void run() {
                try {
                    test.even(printNumber);
                } catch (InterruptedException e) {
                    logger.error(e.getLocalizedMessage(), e);;
                }
            }
        };
        Thread t3 = new Thread("odd") {
            public void run() {
                try {
                    test.odd(printNumber);
                } catch (InterruptedException e) {
                    logger.error(e.getLocalizedMessage(), e);;
                }
            }
        };
        t2.start();
        t1.start();
        t3.start();
    }

}

package com.jzk.exec.leetcode.thread.lock;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;


public class Task {
    Logger logger = Logger.getLogger(Task.class);
    
    private final Lock lock = new ReentrantLock();
    private final Condition addCondition = lock.newCondition();
    private final Condition subCondition = lock.newCondition();
    
    private static int num = 0;
    private List<String> lists = new LinkedList<String>();
    
    public void add() {
        lock.lock();
        try {
            while(lists.size() == 10) {//当集合已满,则"添加"线程等待
                addCondition.await();
            }
            
            num++;
            lists.add("add Banana" + num);
            logger.info("The Lists Size is " + lists.size());
            logger.info("The Current Thread is " + Thread.currentThread().getName());
            logger.info("==============================");
            this.subCondition.signal();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {//释放锁
            lock.unlock();
        }
    }
    
    public void sub() {
        lock.lock();
        try {
            while(lists.size() == 0) {//当集合为空时,"减少"线程等待
                subCondition.await();
            }
            
            String str = lists.get(0);
            lists.remove(0);
            logger.info("The Token Banana is [" + str + "]");
            logger.info("The Current Thread is " + Thread.currentThread().getName());
            logger.info("==============================");
            num--;
            addCondition.signal();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

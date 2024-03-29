package com.jzk.exec.leetcode.thread.lock;

public class SubThread implements Runnable {
    
    private Task task;
    
    public SubThread(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.sub();
    }
}

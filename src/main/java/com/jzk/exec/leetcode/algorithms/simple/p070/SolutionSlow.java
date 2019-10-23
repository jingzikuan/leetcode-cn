package com.jzk.exec.leetcode.algorithms.simple.p070;

public class SolutionSlow {
    public int climbStairs(int n) {
        return step(n, 0);
    }

    public int step(int total, int i) {
        //System.out.println("step total="+total + ", i="+i);
        int sum = 0;
        if(i + 1 <= total) {
            //System.out.println("step total="+total + ", i="+i + ", step 1");
            sum = sum + step(total, i+1);
        }
        if(i + 2 <= total) {
            //System.out.println("step total="+total + ", i="+i + ", step 2");
            sum = sum + step(total, i+2);
        }
        if(i + 1 == total || i + 2 == total) {
            //System.out.println("step total="+total + ", i="+i + ", add 1 step");
            sum++;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        
        int s = new SolutionSlow().climbStairs(7);
        System.out.println("end s="+s);
    }
}

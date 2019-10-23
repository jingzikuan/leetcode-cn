package com.jzk.exec.leetcode.algorithms.simple.p070;

public class Solution {
    public int climbStairs(int n) {
        int t = 1;
        int p1 = 0;
        int p2 = 0;
        for(int i=1; i<=n; i++) {
            p2 = p1;
            p1 = t;
            t = p1 + p2;
        }
        return t;
    }
    
    public static void main(String[] args) {
        
        int s = new Solution().climbStairs(5);
        System.out.println("end s="+s);
    }
}

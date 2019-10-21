package com.jzk.exec.leetcode.algorithms.simple.p007;

class Solution {
    public int reverse(int x) {
        int ret=0;
        int m=0;
        while(x!=0) {
            m=x%10;
            x = x/10;
            if(ret>Integer.MAX_VALUE/10) return 0;
            if(ret==Integer.MAX_VALUE/10 && m>7) return 0;
            if(ret<Integer.MIN_VALUE/10) return 0;
            if(ret==Integer.MIN_VALUE/10 && m<-8) return 0;
            ret = ret*10 + m;
        }
        return ret;
    }
}
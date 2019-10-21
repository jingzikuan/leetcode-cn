package com.jzk.exec.leetcode.algorithms.middle.p008;

class Solution {
    public int myAtoi(String str) {
        if(str == null) {
            return 0;
        }
        str = str.trim();
        if(str.length() == 0) {
            return 0;
        }
        long res = 0L;
        int begin = 0;
        int sig = 1;
        if('+' == str.charAt(0)) {
            begin = 1;
        }
        if('-' == str.charAt(0)) {
            sig = -1;
            begin = 1;
        }
        for(int i=begin; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c < 48 || c > 57) {
                break;
            }
            int num = c - 48;
            res = res*10 + num;
            if(res * sig > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if(res * sig < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int)(res * sig);
    }
}
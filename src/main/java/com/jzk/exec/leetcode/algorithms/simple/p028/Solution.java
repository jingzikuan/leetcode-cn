package com.jzk.exec.leetcode.algorithms.simple.p028;

public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) {
            return -1;
        }
        if(needle.length() == 0) {
            return 0;
        }
        if(haystack.length() < needle.length()) {
            return -1;
        }
        
        char first = needle.charAt(0);
        int fromIndex = 0;
        while(true) {
            int i = haystack.indexOf(first, fromIndex);
            if(i == -1) {
                return -1;
            }
            if(i + needle.length() > haystack.length()) {
                return -1;
            }
            String sub = haystack.substring(i, i + needle.length());
            if(needle.equals(sub)) {
                return i;
            }
            fromIndex = i+1;
        }
    }
}

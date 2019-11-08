package com.jzk.exec.leetcode.algorithms.simple.p038;

public class Solution {
    public String countAndSay(int n) {
        String cur = "1";
        for(int i=2; i<=n; i++) {
            cur = next(cur);
        }
        return cur;
    }
    
    public String next(String str) {
        String result = "";
        char c = str.charAt(0);
        int count = 1;
        for(int i=1; i<str.length(); i++) {
            if(c == str.charAt(i)) {
                count ++;
            }else {
                result = result + count + c;
                count = 1;
                c = str.charAt(i);
            }
        }
        result = result + count + c;
        return result;
    }
    
    public static void main(String[] arts) {
        Solution s = new Solution();
        String str = s.next("1211");
        System.out.println("==" + str);
    }
}

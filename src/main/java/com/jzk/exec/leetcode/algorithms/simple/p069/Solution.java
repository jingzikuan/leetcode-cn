package com.jzk.exec.leetcode.algorithms.simple.p069;

class Solution {
    public int mySqrt(int x) {
        long pre = 1;
        long min = 0;
        long max = x;
        if(x <= 1){
            return x;
        }
        int i=1;
        while(true){
            System.out.println(i++);
            if(min * min < x){
                pre = min;
                min = min + (max-min)/2;
                System.out.println("min = min * 2; min=" + min +"," + "max=" + max +",pre=" + pre);
                if(min * min == x || (min * min < x && (min+1) * (min+1) > x)){
                    return (int)min;
                }
                if(min * min > x){
                    min = pre+1;
                    System.out.println("min * min > x; min=" + min +"," + "max=" + max +",pre=" + pre);
                    if(min * min == x || (min * min < x && (min+1) * (min+1) > x)){
                        return (int)min;
                    }
                }else {
                    min = min+1;
                    System.out.println("min * min > x; min=" + min +"," + "max=" + max +",pre=" + pre);
                    if(min * min == x || (min * min < x && (min+1) * (min+1) > x)){
                        return (int)min;
                    }
                }
            }
            if(max * max > x){
                pre = max;
                max = min + (max - min)/2;
                System.out.println("max = min + (max - min)/2;min=" + min +"," + "max=" + max +",pre=" + pre);
                if(max * max == x || (max * max < x && (max+1) * (max+1) > x)){
                    return (int)max;
                }
                if(max * max < x){
                    max = pre-1;
                    System.out.println("max * max < x; min=" + min +"," + "max=" + max +",pre=" + pre);
                    if(max * max == x || (max * max < x && (max+1) * (max+1) > x)){
                        return (int)max;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
//        int x = 2147395599;
        int x = 2147395599;
        System.out.println("mySqrt(" + x +"):" + new Solution().mySqrt(x));
    }
}
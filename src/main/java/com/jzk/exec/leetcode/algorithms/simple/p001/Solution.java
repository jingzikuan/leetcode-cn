package com.jzk.exec.leetcode.algorithms.simple.p001;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] resultArr = new int[2];
        for(int i=0; i<nums.length; i++){
            for(int k=i+1; k<nums.length; k++){
                if(nums[i] + nums[k] == target){
                    resultArr[0] = i;
                    resultArr[1] = k;
                    return resultArr;
                }
            }
        }
        return null;
    }
}
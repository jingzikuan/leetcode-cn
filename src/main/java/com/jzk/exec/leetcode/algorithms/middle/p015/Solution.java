package com.jzk.exec.leetcode.algorithms.middle.p015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            while (i > 0 && i < nums.length - 2 && nums[i] == nums[i - 1])
                i++;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {

                if (nums[i] + nums[j] + nums[k] > 0)
                    k--;
                else if (nums[i] + nums[j] + nums[k] < 0)
                    j++;
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    resultList.add(list);
                    j++;
                    k--;

                }
                while (j < k && j > i + 1 && nums[j] == nums[j - 1])
                    j++;
                while (j < k && k < nums.length - 1 && nums[k] == nums[k + 1])
                    k--;
            }
        }
        return resultList;
    }
}

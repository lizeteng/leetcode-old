package com.lizeteng.leetcode.easy._001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 示例：
 * 给定 nums = [2, 7, 11, 15]，target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 *
 * @author lizeteng
 * @date 2018/11/08
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }

            map.put(target - nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] {2, 7, 8, 9}, 11)));
    }
}

package com.lizeteng.leetcode.easy._035;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 假设数组中无重复数据。
 *
 * 示例1：
 * 输入：[1, 3, 5, 6]，5
 * 输出：2
 *
 * 示例2：
 * 输入：[1, 3, 5, 6]，2
 * 输出：1
 *
 * 示例3：
 * 输入：[1, 3, 5, 6]，7
 * 输出：4
 *
 * 示例4：
 * 输入：[1, 3, 5, 6]，0
 * 输出：0
 *
 *
 * @author lizeteng
 * @date 2018/11/29
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + ((high - low) >> 1);

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low] >= target ? low : low + 1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 6};

        System.out.println(new Solution().searchInsert(array, 5));
    }
}

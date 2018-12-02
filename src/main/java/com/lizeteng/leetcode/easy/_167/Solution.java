package com.lizeteng.leetcode.easy._167;

import java.util.Arrays;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明：
 * 1、返回的下标值（index1 和 index2）不是从零开始的。
 * 2、假设每个输入只对应唯一的答案，而且不可以重复使用相同的元素。
 *
 * 示例：
 * 输入：numbers = [2, 7, 11, 15]，target = 9
 * 输出：[1, 2]
 * 解释：2 与 7 之和等于目标数 9。因此 index1 = 1，index2 = 2。
 *
 * @author lizeteng
 * @date 2018/12/02
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        int low = 0;
        int high = numbers.length - 1;

        while (low < high) {
            int sum = numbers[low] + numbers[high];

            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 11, 15};

        System.out.println(Arrays.toString(new Solution().twoSum(array, 9)));
    }
}

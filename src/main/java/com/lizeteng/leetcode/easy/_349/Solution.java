package com.lizeteng.leetcode.easy._349;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例1：
 * 输入：nums1 = [1, 2, 2, 1]，nums2 = [2, 2]
 * 输出：[2]
 *
 * 示例2：
 * 输入：nums1 = [4, 9, 5], nums2 = [9, 4, 9, 8, 4]
 * 输出：[9, 4]
 *
 * 说明：
 * 1、输出结果中的每个元素一定是唯一的。
 * 2、不考虑输出结果的顺序。
 *
 * @author lizeteng
 * @date 2018/11/19
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(nums1.length);

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        List<Integer> tempList = new ArrayList<>(set.size());

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                set.remove(nums2[i]);

                tempList.add(nums2[i]);
            }
        }

        int[] result = new int[tempList.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = tempList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new Solution().intersection(new int[] {1, 2, 2, 1}, new int[] {2, 2})));
    }
}

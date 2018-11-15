package com.lizeteng.leetcode.hard._239;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口最大值。
 *
 * 示例：
 * 输入：nums = [1, 3, -1, -3, 5, 3, 6, 7]，和 k = 3
 * 输出：[3, 3, 5, 5, 6, 7]
 * 解释：
 * 滑动窗口的位置        最大值
 * ------------        -----
 * [1 3 -1] -3 5 3 6 7   3
 * 1 [3 -1 -3] 5 3 6 7   3
 * 1 3 [-1 -3 5] 3 6 7   5
 * 1 3 -1 [-3 5 3] 6 7   5
 * 1 3 -1 -3 [5 3 6] 7   6
 * 1 3 -1 -3 5 [3 6 7]   7
 *
 * 注意：
 * 假设 k 总是有效的， 1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 *
 * 进阶：
 * 在线性时间复杂度内解决此题。
 *
 * @author lizeteng
 * @date 2018/11/12
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> window = new ArrayDeque<>(k);

        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i >= k && window.peekFirst() <= i - k) {
                window.pollFirst();
            }

            while (!window.isEmpty() && nums[i] >= nums[window.peekLast()]) {
                window.pollLast();
            }

            window.offerLast(i);

            if (i >= k - 1) {
                result[j++] = nums[window.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 3, 1, 2, 0, 5};

        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(array, 3)));
    }
}

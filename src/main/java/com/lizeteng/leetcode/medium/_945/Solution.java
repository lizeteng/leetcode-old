package com.lizeteng.leetcode.medium._945;

import java.util.Arrays;

/**
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 示例1：
 * 输入：[1, 2, 2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 *
 * 示例2：
 * 输入：[3, 2, 1, 2, 1, 7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 *      可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 *
 * 提示：
 * 1、0 <= A.length <= 40000
 * 2、0 <= A[i] < 40000
 *
 * @author lizeteng
 * @date 2018/12/08
 */
public class Solution {

    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);

        int result = 0;
        int max = A[0];

        for (int i = 1; i < A.length; i++) {
            while (A[i] <= max) {
                A[i] = A[i] + 1;

                result++;
            }

            max = A[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }
}

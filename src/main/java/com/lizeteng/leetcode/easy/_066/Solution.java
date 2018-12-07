package com.lizeteng.leetcode.easy._066;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例1：
 * 输入：[1, 2, 3]
 * 输出：[1, 2, 4]
 * 解释：输入数组表示数字 123。
 *
 * 示例2：
 * 输入：[4, 3, 2, 1]
 * 输出：[4, 3, 2, 2]
 * 解释：输入数组表示数字 4321。
 *
 * @author lizeteng
 * @date 2018/12/07
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int tempInt = digits[i] + 1;

            if ((tempInt / 10) > 0) {
                digits[i] = tempInt % 10;
            } else {
                digits[i] = tempInt;

                return digits;
            }
        }

        int[] newArray = new int[digits.length + 1];
        newArray[0] = 1;

        for (int i = 1; i < digits.length; i++) {
            newArray[i] = digits[i - 1];
        }

        return newArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[] {1, 2, 3})));
    }
}

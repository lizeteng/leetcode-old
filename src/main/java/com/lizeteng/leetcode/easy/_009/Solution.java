package com.lizeteng.leetcode.easy._009;

/**
 * 判断一个整数是否是回文数。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例1：
 * 输入：121
 * 输出：true
 *
 * 示例2：
 * 输入：-121
 * 输出：false
 * 解释：从左向右读，为 -121。从右向左读，为 121-。因此它不是一个回文数。
 *
 * 示例3：
 * 输入：10
 * 输出：false
 * 解释：从右向左读，为 01。因此它不是一个回文数。
 *
 * @author lizeteng
 * @date 2018/11/10
 */
public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;

        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(100));
    }
}

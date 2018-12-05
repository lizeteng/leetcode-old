package com.lizeteng.leetcode.easy._069;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例1：
 * 输入：4
 * 输出：2
 *
 * 示例2：
 * 输入：8
 * 输出：2
 * 说明：8 的平方根是 2.82842...，由于返回类型是整数，小数部分将被舍去。
 *
 * @author lizeteng
 * @date 2018/12/05
 */
public class Solution {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int low = 1;
        int high = x;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (mid > x / mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(8));
    }
}

package com.lizeteng.leetcode.easy._007;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 * 示例1：
 * 输入：123
 * 输出：321
 *
 * 示例2：
 * 输入：-123
 * 输出：-321
 *
 * 示例3：
 * 输入：120
 * 输出：21
 *
 * 注意：
 * 假设环境只能存储 32 位有符号整数，其数值范围是 [-2^31, 2^31 - 1]。
 * 根据假设，如果反转后的整数溢出，则返回0。
 *
 * @author lizeteng
 * @date 2018/11/09
 */
public class Solution {

    public int reverse(int x) {
        int result = 0;
        int minResult = Integer.MIN_VALUE / 10;
        int maxResult = Integer.MAX_VALUE / 10;
        int tempInt;

        while (x != 0) {
            tempInt = x % 10;
            x /= 10;

            if ((result < minResult) || ((result == minResult) && (tempInt < -8))) {
                return 0;
            }

            if ((result > maxResult) || ((result == maxResult) && (tempInt > 7))) {
                return 0;
            }

            result = result * 10 + tempInt;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-2147483412));
    }
}

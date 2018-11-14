package com.lizeteng.leetcode.easy._434;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 假定字符串里不包括任何不可打印的字符。
 *
 * 示例：
 * 输入："Hello, my name is John"
 * 输出：5
 *
 * @author lizeteng
 * @date 2018/11/14
 */
public class Solution {

    public int countSegments(String s) {
        int length;

        if (s == null || (length = s.length()) == 0) {
            return 0;
        }

        int lowLength = length - 1;
        int count = 0;

        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == ' ' && i < lowLength && s.charAt(i + 1) != ' ') {
                count++;
            }
        }

        if (s.charAt(0) != ' ') {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSegments("                "));
    }
}

package com.lizeteng.leetcode.medium._003;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *
 * 示例1：
 * 输入："abcabcbb"
 * 输出：3
 * 解释：无重复字符的最长子串是 "abc"，其长度为 3。
 *
 * 示例2：
 * 输入："bbbbb"
 * 输出：1
 * 解释：无重复字符的最长子串是 "b"，其长度为 1。
 *
 * 示例3：
 * 输入："pwwkew"
 * 输出：3
 * 解释：无重复字符的最长子串是 "wke"，其长度为 3。（请注意，答案必须是一个子串，"pwke" 是一个子序列而不是子串）
 *
 * @author lizeteng
 * @date 2018/11/08
 */
public class Solution {

    public int lengthOfLongestSubstring(String str) {
        int length = str.length();
        int temp = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>(length);

        for (int i = 0; i < length; i++) {
            if (map.containsKey(str.charAt(i))) {
                temp = Math.max(map.get(str.charAt(i)), temp);
            }

            max = Math.max(max, i - temp + 1);
            map.put(str.charAt(i), i + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abba"));
    }
}

package com.lizeteng.leetcode.easy._242;

/**
 * 给定两个字符串 s 和 t，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例1：
 * 输入：s = "anagram"，t = "nagaram"
 * 输出：true
 *
 * 示例2：
 * 输入：s = "rat"，t = "car"
 * 输出：false
 *
 * 进阶：
 * 调整解法来应对字符串包含 unicode 字符的情况。
 *
 * @author lizeteng
 * @date 2018/11/13
 */
public class Solution {

    public boolean isAnagram(String s, String t) {
        int length = s.length();

        if (length != t.length()) {
            return false;
        }

        int[] sArray = new int[26];
        int[] tArray = new int[26];

        for (int i = 0; i < length; i++){
            sArray[s.charAt(i) - 'a']++;
            tArray[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
    }
}

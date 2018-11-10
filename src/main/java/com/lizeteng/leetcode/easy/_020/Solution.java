package com.lizeteng.leetcode.easy._020;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 1、左括号必须用相同类型的右括号闭合。
 * 2、左括号必须以正确的顺序闭合。
 *
 * 注意：
 * 空字符串可被认为是有效字符串。
 *
 * 示例1：
 * 输入："()"
 * 输出：true
 *
 * 示例2：
 * 输入："()[]{}"
 * 输出：true
 *
 * 示例3：
 * 输入："(]"
 * 输出：false
 *
 * 示例4：
 * 输入："([)]"
 * 输出：false
 *
 * 示例5：
 * 输入："{[]}"
 * 输出：true
 *
 * @author lizeteng
 * @date 2018/11/10
 */
public class Solution {

    public boolean isValid(String s) {
        int length = s.length();
        LinkedList<Character> linkedStack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < length; i++) {
            if (!map.containsKey(s.charAt(i))) {
                linkedStack.push(s.charAt(i));
            } else {
                if (linkedStack.size() == 0 || !map.get(s.charAt(i)).equals(linkedStack.pop())) {
                    return false;
                }
            }
        }

        return linkedStack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("}"));
    }
}

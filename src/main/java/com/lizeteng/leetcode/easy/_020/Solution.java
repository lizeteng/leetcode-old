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
    
    private static final Map<Character, Character> PARENTHESES = new HashMap<>(3);

    static {
        PARENTHESES.put(')', '(');
        PARENTHESES.put(']', '[');
        PARENTHESES.put('}', '{');
    }

    public boolean isValid(String s) {
        int length = s.length();
        LinkedList<Character> linkedStack = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            char tempChar = s.charAt(i);

            if (!PARENTHESES.containsKey(tempChar)) {
                linkedStack.push(tempChar);
            } else {
                if (linkedStack.size() == 0 || !PARENTHESES.get(tempChar).equals(linkedStack.pop())) {
                    return false;
                }
            }
        }

        return linkedStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("}"));
    }
}

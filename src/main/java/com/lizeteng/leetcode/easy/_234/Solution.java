package com.lizeteng.leetcode.easy._234;

import com.lizeteng.leetcode.base.ListNode;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例1：
 * 输入：1 -> 2
 * 输出：false
 *
 * 示例2：
 * 输入：1 -> 2 -> 2 -> 1
 * 输出：true
 *
 * 进阶：
 * 用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题
 *
 * @author lizeteng
 * @date 2018/11/17
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, next = null;

        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        while (prev != null) {
            if (prev.val != head.val) {
                return false;
            }

            prev = prev.next;
            head = head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);

        System.out.println(new Solution().isPalindrome(listNode));
    }
}

package com.lizeteng.leetcode.easy._141;

import com.lizeteng.leetcode.base.ListNode;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * @author lizeteng
 * @date 2018/11/12
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = listNode;

        System.out.println(new Solution().hasCycle(listNode));
    }
}

package com.lizeteng.leetcode.medium._019;

import com.lizeteng.leetcode.base.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 * 给定一个链表：1 -> 2 -> 3 -> 4 -> 5，和 n = 2。
 * 当删除了倒数第二个节点后，链表就变为 1 -> 2 -> 3 -> 5。
 *
 * 说明：
 * 给定的 n 保证是有效的。
 *
 * @author lizeteng
 * @date 2018/11/08
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        ListNode slow = head;
        ListNode prev = null;

        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = prev.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);

        new Solution().removeNthFromEnd(listNode, 2).printAll();
    }
}

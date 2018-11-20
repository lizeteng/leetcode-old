package com.lizeteng.leetcode.medium._143;

import com.lizeteng.leetcode.base.ListNode;
import com.lizeteng.leetcode.util.ListNodeUtils;

/**
 * 给定一个单链表 L：L0 → L1 → … → Ln-1 → Ln，将其重新排列后变为：L0 →  Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例1：
 * 给定链表 1 -> 2 -> 3 -> 4，重新排列为 1 -> 4 -> 2 -> 3。
 *
 * 示例2:
 * 给定链表 1 -> 2 -> 3 -> 4 -> 5，重新排列为 1 -> 5 -> 2 -> 4 -> 3。
 *
 * @author lizeteng
 * @date 2018/11/20
 */
public class Solution {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l2 = slow.next, prev = null;
        slow.next = null;

        while (l2 != null) {
            ListNode next = l2.next;

            l2.next = prev;
            prev = l2;
            l2 = next;
        }

        l2 = prev;

        ListNode l1 = head;

        while (l1 != null && l2 != null) {
            ListNode next = l1.next;

            l1.next = l2;
            l2 = l2.next;
            l1.next.next = next;
            l1 = next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.getListNode(1, 2, 3, 4, 5);

        ListNodeUtils.printAll(listNode);

        new Solution().reorderList(listNode);

        ListNodeUtils.printAll(listNode);
    }
}

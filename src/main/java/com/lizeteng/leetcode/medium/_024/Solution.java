package com.lizeteng.leetcode.medium._024;

import com.lizeteng.leetcode.base.ListNode;
import com.lizeteng.leetcode.util.ListNodeUtils;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 示例：
 * 给定 1->2->3->4，返回 2->1->4->3。
 *
 * 说明：
 * 1、算法只能使用常数的额外空间。
 * 2、不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author lizeteng
 * @date 2018/11/10
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode prev = new ListNode(0), result = prev;
        prev.next = head;

        while (prev.next != null && prev.next.next != null) {
            ListNode current = prev.next;
            ListNode nextNext = prev.next.next.next;
            
            prev.next = prev.next.next;
            prev.next.next = current;
            prev.next.next.next = nextNext;
            prev = prev.next.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.getListNode(1, 2, 3, 4);

        ListNodeUtils.printAll(listNode);

        ListNodeUtils.printAll(new Solution().swapPairs(listNode));
    }
}

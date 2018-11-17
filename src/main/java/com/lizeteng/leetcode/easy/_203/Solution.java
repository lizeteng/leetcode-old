package com.lizeteng.leetcode.easy._203;

import com.lizeteng.leetcode.base.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例：
 * 输入：1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6，val = 6
 * 输出：1 -> 2 -> 6 -> 3 -> 4 -> 5
 *
 * @author lizeteng
 * @date 2018/11/17
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode tempListNode = new ListNode(0);
        tempListNode.next = head;
        head = tempListNode;

        while (tempListNode.next != null) {
            if (tempListNode.next.val == val) {
                tempListNode.next = tempListNode.next.next;
            } else {
                tempListNode = tempListNode.next;
            }
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);

        listNode.printAll();

        new Solution().removeElements(listNode, 5).printAll();
    }
}

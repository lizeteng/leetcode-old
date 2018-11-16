package com.lizeteng.leetcode.easy._876;

import com.lizeteng.leetcode.base.ListNode;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 示例1：
 * 输入：[1, 2, 3, 4, 5]
 * 输出：此列表中的结点 3（序列化形式：[3, 4, 5]）返回的结点值为 3（测评系统对该结点序列化表述是 [3, 4, 5]）。
 *      注意，返回了一个 ListNode 类型的对象 ans，这样：ans.val = 3，ans.next.val = 4，ans.next.next.val = 5，以及 ans.next.next.next = NULL。
 *
 * 示例2：
 * 输入：[1, 2, 3, 4, 5, 6]
 * 输出：此列表中的结点 4（序列化形式：[4, 5, 6]）由于该列表有两个中间结点，值分别为 3 和 4，返回第二个结点。
 *
 * 提示：
 * 给定链表的结点数介于 1 和 100 之间。
 *
 * @author lizeteng
 * @date 2018/11/16
 */
public class Solution {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);

        listNode.printAll();

        new Solution().middleNode(listNode).printAll();
    }
}

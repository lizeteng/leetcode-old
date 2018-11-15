package com.lizeteng.leetcode.easy._206;

import com.lizeteng.leetcode.base.ListNode;

/**
 * @TODO 进阶未完成。
 *
 * 反转一个单链表。
 *
 * 示例：
 * 输入：1 -> 2 -> 3 -> 4 -> 5 -> NULL
 * 输出：5 -> 4 -> 3 -> 2 -> 1 -> NULL
 *
 * 进阶：
 * 用迭代或递归两种方法解决。
 *
 * @author lizeteng
 * @date 2018/11/12
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, next;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        listNode.printAll();

        new Solution().reverseList(listNode).printAll();
    }
}

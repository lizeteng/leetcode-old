package com.lizeteng.leetcode.medium._002;

import com.lizeteng.leetcode.base.ListNode;
import com.lizeteng.leetcode.util.ListNodeUtils;

/**
 * 给定两个非空链表来表示两个非负整数。
 * 位数按照逆序方式存储，它们的每个节点只存储单个数字。
 * 将两数相加返回一个新的链表。
 * 假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author lizeteng
 * @date 2018/11/08
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0), result = l3;
        boolean notNull1 = l1 != null, notNull2 = l2 != null;

        while (notNull1 || notNull2) {
            int tempInt = (notNull1 ? l1.val : 0) + (notNull2 ? l2.val : 0) + l3.val;

            l1 = notNull1 ? l1.next : null;
            l2 = notNull2 ? l2.next : null;

            notNull1 = l1 != null;
            notNull2 = l2 != null;

            if (tempInt >= 10) {
                l3.val = tempInt - 10;
                l3.next = new ListNode(1);
            } else {
                l3.val = tempInt;
                l3.next = (notNull1 || notNull2) ? new ListNode(0) : null;
            }

            l3 = l3.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNodeUtils.getListNode(9);
        ListNode l2 = ListNodeUtils.getListNode(9);

        ListNodeUtils.printAll(new Solution().addTwoNumbers(l1, l2));
    }
}

package com.lizeteng.leetcode.easy._021;

import com.lizeteng.leetcode.base.ListNode;
import com.lizeteng.leetcode.util.ListNodeUtils;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 * 输入：1->2->4，1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author lizeteng
 * @date 2018/11/09
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode result = new ListNode(0), tempListNode = result;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                tempListNode.next = l2;
                l2 = l2.next;
            } else {
                tempListNode.next = l1;
                l1 = l1.next;
            }

            tempListNode = tempListNode.next;
        }

        if (l1 == null) {
            tempListNode.next = l2;
        } else {
            tempListNode.next = l1;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNodeUtils.getListNode(1, 2, 4);
        ListNode l2 = ListNodeUtils.getListNode(1, 3, 4);

        ListNodeUtils.printAll(new Solution().mergeTwoLists(l1, l2));
    }
}

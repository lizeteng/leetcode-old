package com.lizeteng.leetcode.medium._082;

import com.lizeteng.leetcode.base.ListNode;
import com.lizeteng.leetcode.util.ListNodeUtils;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例1：
 * 输入：1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
 * 输出：1 -> 2 -> 5
 *
 * 示例2：
 * 输入：1 -> 1 -> 1 -> 2 -> 3
 * 输出：2 -> 3
 *
 * @author lizeteng
 * @date 2018/11/21
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(0), tempListNode = result;
        result.next = head;

        while (tempListNode.next != null && tempListNode.next.next != null) {
            if (tempListNode.next.val == tempListNode.next.next.val) {
                int tempInt = tempListNode.next.val;

                while (tempListNode.next != null && tempListNode.next.val == tempInt) {
                    tempListNode.next = tempListNode.next.next;
                }
            } else {
                tempListNode = tempListNode.next;
            }
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.getListNode(1, 1, 1, 2, 3);

        ListNodeUtils.printAll(listNode);

        ListNodeUtils.printAll(new Solution().deleteDuplicates(listNode));
    }
}

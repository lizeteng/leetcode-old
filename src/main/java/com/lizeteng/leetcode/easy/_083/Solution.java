package com.lizeteng.leetcode.easy._083;

import com.lizeteng.leetcode.base.ListNode;
import com.lizeteng.leetcode.util.ListNodeUtils;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例1：
 * 输入：1 -> 1 -> 2
 * 输出：1 -> 2
 *
 * 示例2：
 * 输入：1 -> 1 -> 2 -> 3 -> 3
 * 输出：1 -> 2 -> 3
 *
 * @author lizeteng
 * @date 2018/11/18
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode tempListNode = head;

        while (tempListNode != null && tempListNode.next != null) {
            if (tempListNode.val == tempListNode.next.val) {
                tempListNode.next = tempListNode.next.next;
            } else {
                tempListNode = tempListNode.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.getListNode(1, 1, 2, 3, 3);

        ListNodeUtils.printAll(listNode);
        ListNodeUtils.printAll(new Solution().deleteDuplicates(listNode));
    }
}

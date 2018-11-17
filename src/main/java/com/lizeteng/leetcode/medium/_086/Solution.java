package com.lizeteng.leetcode.medium._086;

import com.lizeteng.leetcode.base.ListNode;
import com.lizeteng.leetcode.util.ListNodeUtils;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例：
 * 输入：head = 1 -> 4 -> 3 -> 2 -> 5 -> 2，x = 3
 * 输出：1 -> 2 -> 2 -> 4 -> 3 -> 5
 *
 * @author lizeteng
 * @date 2018/11/13
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode left = null;
        ListNode leftHead = null;
        ListNode right = null;
        ListNode rightHead = null;

        while (head != null) {
            if (head.val >= x) {
                if (right != null) {
                    right.next = head;
                    right = right.next;
                } else {
                    rightHead = head;
                    right = head;
                }
            } else {
                if (left != null) {
                    left.next = head;
                    left = left.next;
                } else {
                    leftHead = head;
                    left = head;
                }
            }

            head = head.next;
        }

        if (right != null) {
            right.next = null;
        }

        if (left != null) {
            left.next = rightHead;
        } else {
            return rightHead;
        }

        return leftHead;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.getListNode(1, 4, 3, 2, 5, 2);

        ListNodeUtils.printAll(listNode);

        ListNodeUtils.printAll(new Solution().partition(listNode, 3));
    }
}

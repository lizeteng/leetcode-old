package com.lizeteng.leetcode.medium._061;

import com.lizeteng.leetcode.base.ListNode;
import com.lizeteng.leetcode.util.ListNodeUtils;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例1：
 * 输入：1 -> 2 -> 3 -> 4 -> 5 -> NULL，k = 2
 * 输出：4 -> 5 -> 1 -> 2 -> 3 -> NULL
 * 解释：向右旋转 1 步：5 -> 1 -> 2 -> 3 -> 4 -> NULL
 *      向右旋转 2 步：4 -> 5 -> 1 -> 2 -> 3 -> NULL
 *
 * 示例2：
 * 输入：0 -> 1 -> 2 -> NULL，k = 4
 * 输出：2 -> 0 -> 1 -> NULL
 * 解释：向右旋转 1 步：2 -> 0 -> 1 -> NULL
 *      向右旋转 2 步：1 -> 2 -> 0 -> NULL
 *      向右旋转 3 步：0 -> 1 -> 2 -> NULL
 *      向右旋转 4 步：2 -> 0 -> 1 -> NULL
 *
 *
 * @author lizeteng
 * @date 2018/11/20
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tempListNode = head;
        int size = 1;

        while (tempListNode != null && tempListNode.next != null) {
            tempListNode = tempListNode.next;

            size++;
        }

        k %= size;

        if (k == 0) {
            return head;
        }

        tempListNode.next = head;
        tempListNode = head;

        for (int i = 1; i < size - k; i++) {
            tempListNode = tempListNode.next;
        }

        ListNode result = tempListNode.next;

        tempListNode.next = null;

        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.getListNode(1, 2, 3, 4, 5);

        ListNodeUtils.printAll(listNode);

        ListNodeUtils.printAll(new Solution().rotateRight(listNode, 2));
    }
}

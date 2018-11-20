package com.lizeteng.leetcode.medium._092;

import com.lizeteng.leetcode.base.ListNode;
import com.lizeteng.leetcode.util.ListNodeUtils;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明：
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例：
 * 输入：1 -> 2 -> 3 -> 4 -> 5 -> NULL, m = 2, n = 4
 * 输出：1 -> 4 -> 3 -> 2 -> 5 -> NULL
 *
 * @author lizeteng
 * @date 2018/11/20
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(0), tempListNode = result;
        result.next = head;

        for (int i = 1; i < m; i++) {
            tempListNode = tempListNode.next;
        }

        ListNode current = tempListNode.next, prev = null, next = null;

        for (int i = 0; i < n - m + 1; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        tempListNode.next.next = next;
        tempListNode.next = prev;

        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.getListNode(1, 2, 3, 4, 5);

        ListNodeUtils.printAll(listNode);

        ListNodeUtils.printAll(new Solution().reverseBetween(listNode, 2, 4));
    }
}

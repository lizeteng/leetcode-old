package com.lizeteng.leetcode.easy._203;

import com.lizeteng.leetcode.base.ListNode;
import com.lizeteng.leetcode.util.ListNodeUtils;

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
        ListNode listNode = ListNodeUtils.getListNode(1, 2, 3, 4, 5, 6);

        ListNodeUtils.printAll(listNode);

        ListNodeUtils.printAll(new Solution().removeElements(listNode, 5));
    }
}

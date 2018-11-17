package com.lizeteng.leetcode.easy._141;

import com.lizeteng.leetcode.base.ListNode;
import com.lizeteng.leetcode.util.ListNodeUtils;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 进阶：
 * 不使用额外空间解决此题。
 *
 * @author lizeteng
 * @date 2018/11/12
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.getListNode(1, 2);

        System.out.println(new Solution().hasCycle(listNode));
    }
}

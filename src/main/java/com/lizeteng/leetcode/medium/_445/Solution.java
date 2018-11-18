package com.lizeteng.leetcode.medium._445;

import com.lizeteng.leetcode.base.ListNode;
import com.lizeteng.leetcode.util.ListNodeUtils;

import java.util.LinkedList;

/**
 * 给定两个非空链表来代表两个非负整数。
 * 数字最高位位于链表开始位置。
 * 它们的每个节点只存储单个数字。
 * 将这两数相加会返回一个新的链表。
 * 假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * 进阶：
 * 输入链表不能修改，也就是不能对列表中的节点进行翻转。
 *
 * @author lizeteng
 * @date 2018/11/18
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<ListNode> l1LinkedStack = new LinkedList<>();
        LinkedList<ListNode> l2LinkedStack = new LinkedList<>();

        while (l1 != null) {
            l1LinkedStack.push(l1);

            l1 = l1.next;
        }

        while (l2 != null) {
            l2LinkedStack.push(l2);

            l2 = l2.next;
        }

        ListNode result = new ListNode(0);
        boolean l1LinkedStackEmpty = l1LinkedStack.isEmpty();
        boolean l2LinkedStackEmpty = l2LinkedStack.isEmpty();
        int sum = 0;

        while (!l1LinkedStackEmpty || !l2LinkedStackEmpty || sum != 0) {
            sum +=
                    (l1LinkedStackEmpty ? 0 : l1LinkedStack.pop().val)
                            + (l2LinkedStackEmpty ? 0 : l2LinkedStack.pop().val);
            ListNode tempListNode = new ListNode(sum % 10);

            l1LinkedStackEmpty = l1LinkedStack.isEmpty();
            l2LinkedStackEmpty = l2LinkedStack.isEmpty();

            tempListNode.next = result.next;
            result.next = tempListNode;

            sum /= 10;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNodeUtils.getListNode(7, 2, 4, 3);
        ListNode l2 = ListNodeUtils.getListNode(5, 6, 4);

        ListNodeUtils.printAll(new Solution().addTwoNumbers(l1, l2));
    }
}

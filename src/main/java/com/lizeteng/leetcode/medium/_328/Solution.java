package com.lizeteng.leetcode.medium._328;

import com.lizeteng.leetcode.base.ListNode;
import com.lizeteng.leetcode.util.ListNodeUtils;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例1：
 * 输入：1 -> 2 -> 3 -> 4 -> 5 -> NULL
 * 输出：1 -> 3 -> 5 -> 2 -> 4 -> NULL
 *
 * 示例2：
 * 输入：2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7 -> NULL
 * 输出：2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4 -> NULL
 *
 * 说明：
 * 1、应当保持奇数节点和偶数节点的相对顺序。
 * 2、链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * @author lizeteng
 * @date 2018/11/17
 */
public class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddListNode = head, evenListNode = head.next, evenListNodeHead = evenListNode;

        while (evenListNode != null && evenListNode.next != null) {
            oddListNode = oddListNode.next = evenListNode.next;
            evenListNode = evenListNode.next = oddListNode.next;
        }

        oddListNode.next = evenListNodeHead;

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.getListNode(2, 1, 3, 5, 6, 4, 7);

        ListNodeUtils.printAll(listNode);

        ListNodeUtils.printAll(new Solution().oddEvenList(listNode));
    }
}

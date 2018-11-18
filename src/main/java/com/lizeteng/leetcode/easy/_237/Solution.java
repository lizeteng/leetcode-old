package com.lizeteng.leetcode.easy._237;

import com.lizeteng.leetcode.base.ListNode;
import com.lizeteng.leetcode.util.ListNodeUtils;

/**
 * 编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，给定要求被删除的节点。
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为：4 -> 5 -> 1 -> 9
 *
 * 示例1：
 * 输入：head = [4, 5, 1, 9]，node = 5
 * 输出：[4, 1, 9]
 * 解释：给定链表中值为 5 的第二个节点，调用函数后，该链表变为 4 -> 1 -> 9。
 *
 * 示例2：
 * 输入：head = [4, 5, 1, 9]，node = 1
 * 输出：[4, 5, 9]
 * 解释：给定链表中值为 1 的第三个节点，调用函数后，该链表变为 4 -> 5 -> 9。
 *
 * 说明：
 * 1、链表至少包含两个节点。
 * 2、链表中所有节点的值都是唯一的。
 * 3、给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 4、不要从函数中返回任何结果。
 *
 * @author lizeteng
 * @date 2018/11/16
 */
public class Solution {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.getListNode(4, 5, 1, 9);

        ListNodeUtils.printAll(listNode);

        new Solution().deleteNode(listNode.next);

        ListNodeUtils.printAll(listNode);
    }
}

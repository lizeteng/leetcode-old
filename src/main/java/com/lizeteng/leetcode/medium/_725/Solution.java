package com.lizeteng.leetcode.medium._725;

import com.lizeteng.leetcode.base.ListNode;
import com.lizeteng.leetcode.util.ListNodeUtils;

/**
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * 返回一个符合上述规则的链表的列表。
 *
 * 示例1：
 * 输入：root = [1, 2, 3]，k = 5
 * 输出：[[1], [2], [3], [], []]
 * 解释：输入输出各部分都应该是链表，而不是数组。
 *      例如，输入的节点 root 的 val = 1，root.next.val = 2，root.next.next.val = 3，且 root.next.next.next = null。
 *      第一个输出 output[0] 是 output[0].val = 1，output[0].next = null。
 *      最后一个元素 output[4] 为 null，它代表了最后一个部分为空链表。
 *
 * 示例2：
 * 输入：root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]，k = 3
 * 输出：[[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释：输入被分成了几个连续的部分，并且每部分的长度差不超过 1。
 *      前面部分的长度大于等于后面部分的长度。
 *
 * 提示：
 * 1、root 的长度范围：[0, 1000]。
 * 2、输入的每个节点的大小范围：[0, 999]。
 * 3、k 的取值范围：[1, 50]。
 *
 * @author lizeteng
 * @date 2018/11/18
 */
public class Solution {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        ListNode  tempListNode = root;
        int size = 0;

        while (tempListNode != null) {
            tempListNode = tempListNode.next;

            size++;
        }

        tempListNode = root;
        int partSize = size / k;
        int morePart = size % k;
        int index = 0;

        while (tempListNode != null) {
            result[index] = tempListNode;

            for (int i = 0; i < partSize - 1; i++) {
                tempListNode = tempListNode.next;
            }

            if (partSize > 0 && morePart > 0) {
                tempListNode = tempListNode.next;

                morePart--;
            }

            ListNode next = tempListNode.next;
            tempListNode.next = null;
            tempListNode = next;

            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode tempListNode = ListNodeUtils.getListNode(1, 2, 3, 4);

        ListNodeUtils.printAll(tempListNode);

        ListNode[] tempListNodes = new Solution().splitListToParts(tempListNode, 5);

        for (ListNode node : tempListNodes) {
            ListNodeUtils.printAll(node);
        }
    }
}

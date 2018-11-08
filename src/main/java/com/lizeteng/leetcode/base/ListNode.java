package com.lizeteng.leetcode.base;

/**
 * 单链表节点
 *
 * @author lizeteng
 * @date 2018/11/08
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void printAll() {
        ListNode tempListNode = this;

        while (tempListNode != null) {
            System.out.print(tempListNode.val + " ");

            tempListNode = tempListNode.next;
        }
    }
}

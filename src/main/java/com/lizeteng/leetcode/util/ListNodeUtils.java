package com.lizeteng.leetcode.util;

import com.lizeteng.leetcode.base.ListNode;

/**
 * 单链表节点工具类
 * 
 * @author lizeteng
 * @date 2018/11/17
 */
public class ListNodeUtils {

    public static ListNode getListNode(Integer... integers) {
        if (integers == null || integers.length == 0) {
            return null;
        }

        ListNode head = new ListNode(integers[0]), tempListNode = head;

        for (int i = 1; i < integers.length; i++){
            tempListNode.next = new ListNode(integers[i]);
            tempListNode = tempListNode.next;
        }

        return head;
    }
    
    public static void printAll(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");

            head = head.next;
        }

        System.out.println();
    }
}
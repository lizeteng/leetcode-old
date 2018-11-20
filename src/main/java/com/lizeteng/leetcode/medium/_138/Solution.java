package com.lizeteng.leetcode.medium._138;

import com.lizeteng.leetcode.base.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深度拷贝。
 *
 * @author lizeteng
 * @date 2018/11/20
 */
public class Solution {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode tempRandomListNode = head;

        while (tempRandomListNode != null) {
            RandomListNode next = tempRandomListNode.next;

            tempRandomListNode.next = new RandomListNode(tempRandomListNode.label);
            tempRandomListNode.next.next = next;
            tempRandomListNode = next;
        }

        tempRandomListNode = head;

        while (tempRandomListNode != null) {
            if (tempRandomListNode.random != null) {
                tempRandomListNode.next.random = tempRandomListNode.random.next;
            }

            tempRandomListNode = tempRandomListNode.next.next;
        }

        RandomListNode result = new RandomListNode(0);
        tempRandomListNode = result;

        while (head != null) {
            tempRandomListNode.next = head.next;
            tempRandomListNode = tempRandomListNode.next;

            head = head.next = head.next.next;
        }

        return result.next;
    }

    public RandomListNode copyRandomListByMap(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode tempRandomListNode = head;

        while (tempRandomListNode != null) {
            map.put(tempRandomListNode, new RandomListNode(tempRandomListNode.label));

            tempRandomListNode = tempRandomListNode.next;
        }

        tempRandomListNode = head;

        while (tempRandomListNode != null) {
            map.get(tempRandomListNode).next = map.get(tempRandomListNode.next);
            map.get(tempRandomListNode).random = map.get(tempRandomListNode.random);

            tempRandomListNode = tempRandomListNode.next;
        }

        return map.get(head);
    }
}

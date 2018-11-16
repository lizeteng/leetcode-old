package com.lizeteng.leetcode.easy._707;

/**
 * 设计链表的实现，可以使用单链表或双链表。
 * 单链表的节点应该具有两个属性：val 和 next，val 是当前节点的值，next 是指向下一节点的指针/引用。
 * 如果使用双链表，则还需要一个 prev 以指示链表中的上一个节点。
 *
 * 在链表类中实现这些功能：
 * 1、get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * 2、addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * 3、addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * 4、addAtIndex(index, val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
 * 5、deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * 示例：
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2); //链表变为1-> 2-> 3
 * linkedList.get(1); //返回2
 * linkedList.deleteAtIndex(1); //现在链表是1-> 3
 * linkedList.get(1); //返回3
 *
 * 提示：
 * 1、所有值都在 [1, 1000] 之间。
 * 2、操作次数将在 [1, 1000] 之内。
 * 3、请不要使用内置的 LinkedList 库。
 *
 * @author lizeteng
 * @date 2018/11/16
 */
public class MyLinkedList {

    private ListNode head;

    private ListNode tail;

    private int size;

    public int get(int index) {
        if (!isElementIndex(index)) {
            return -1;
        }

        ListNode tempListNode = head;

        for (int i = 0; i < index; i++){
            tempListNode = tempListNode.next;
        }

        return tempListNode.val;
    }

    public void addAtHead(int val) {
        ListNode newListNode = new ListNode(val);
        newListNode.next = head;

        head = newListNode;

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    public void addAtTail(int val) {
        if (tail != null) {
            ListNode newListNode = new ListNode(val);

            tail.next = newListNode;
            tail = newListNode;

            size++;
        } else {
            addAtHead(val);
        }
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == size) {
            addAtTail(val);

            return;
        }

        ListNode prev = null, tempListNode = head;

        for (int i = 0; i < index; i++) {
            prev = tempListNode;
            tempListNode = tempListNode.next;
        }

        ListNode newListNode = new ListNode(val);
        newListNode.next = tempListNode;

        prev.next = newListNode;

        size++;
    }

    public void deleteAtIndex(int index) {
        if (!isElementIndex(index)) {
            return;
        }

        size--;

        if (head == tail) {
            head = null;
            tail = null;

            return;
        }

        ListNode prev = null, tempListNode = head;

        for (int i = 0; i < index; i++){
            prev = tempListNode;
            tempListNode = tempListNode.next;
        }

        if (tail == prev.next) {
            tail = prev;
        }

        prev.next = prev.next.next;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private class ListNode {

        private int val;

        private ListNode next;

        private ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addAtHead(1);

        myLinkedList.addAtTail(3);

        myLinkedList.addAtIndex(1,2);

        System.out.println(myLinkedList.get(1));

        myLinkedList.deleteAtIndex(1);

        System.out.println(myLinkedList.get(1));
    }
}

package com.lizeteng.leetcode.easy._225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈的下列操作：
 * 1、push(x) -- 元素 x 入栈。
 * 2、pop() -- 移除栈顶元素。
 * 3、top() -- 获取栈顶元素。
 * 4、empty() -- 返回栈是否为空。
 *
 * 注意：
 * 1、只能使用队列的基本操作 -- 也就是 push to back，peek/pop from front，size 和 is empty 这些操作是合法的。
 * 2、使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列，只要是标准的队列操作即可。
 * 3、所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * @author lizeteng
 * @date 2018/11/11
 */
public class MyStack {

    private Queue<Integer> linkedQueue = new LinkedList<>();

    public void push(int x) {
        linkedQueue.add(x);

        int size = linkedQueue.size();

        while (size--  > 1) {
            linkedQueue.add(linkedQueue.poll());
        }
    }

    public int pop() {
        return linkedQueue.poll();
    }

    public int top() {
        return linkedQueue.peek();
    }

    public boolean empty() {
        return linkedQueue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}

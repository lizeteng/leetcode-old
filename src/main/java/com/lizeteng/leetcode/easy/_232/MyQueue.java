package com.lizeteng.leetcode.easy._232;

import java.util.LinkedList;

/**
 * 使用栈实现队列的下列操作：
 * 1、push(x) -- 将一个元素放入队列的尾部。
 * 2、pop() -- 从队列首部移除元素。
 * 3、peek() -- 返回队列首部的元素。
 * 4、empty() -- 返回队列是否为空。
 *
 * 示例：
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek(); // 返回 1
 * queue.pop(); // 返回 1
 * queue.empty(); // 返回 false
 *
 * 说明：
 * 1、只能使用标准的栈操作 -- 也就是只有 push to top，peek/pop from top，size 和 is empty 操作是合法的。
 * 2、使用的语言也许不支持栈。可以使用list 或者 deque（双端队列）来模拟一个栈，只要是标作的栈操作即可。
 * 3、所有操作都是有效的（例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 * @author lizeteng
 * @date 2018/11/11
 */
public class MyQueue {

    private LinkedList<Integer> inputStack = new LinkedList<>();

    private LinkedList<Integer> outputStack = new LinkedList<>();

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        inputStackToOutputStack();

        return outputStack.pop();
    }

    public int peek() {
        inputStackToOutputStack();

        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    private void inputStackToOutputStack() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}

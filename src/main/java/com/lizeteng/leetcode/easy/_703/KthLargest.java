package com.lizeteng.leetcode.easy._703;

import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第K大元素的类（class）。
 * 注意是排序后的第K大元素，不是第K个不同的元素。
 * KthLargest 类需要一个同时接收整数 k 和整数数组 nums 的构造器，它包含数据流中的初始元素。
 * 每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 示例：
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * System.out.println(kthLargest.add(3); // returns 4
 * System.out.println(kthLargest.add(5); // returns 5
 * System.out.println(kthLargest.add(10); // returns 5
 * System.out.println(kthLargest.add(9); // returns 8
 * System.out.println(kthLargest.add(4); // returns 8
 *
 * 说明：
 * 假设 nums 的长度 ≥ k - 1 且 k ≥ 1。
 *
 * @author lizeteng
 * @date 2018/11/11
 */
public class KthLargest {

    private PriorityQueue<Integer> priorityQueue;

    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        priorityQueue = new PriorityQueue<>(k);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < k) {
            priorityQueue.add(val);
        } else if (priorityQueue.peek() < val) {
            priorityQueue.poll();
            priorityQueue.add(val);
        }

        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, array);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}

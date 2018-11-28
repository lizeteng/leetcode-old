package com.lizeteng.leetcode.easy._704;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例1：
 * 输入：nums = [-1, 0, 3, 5, 9, 12]，target = 9
 * 输出：4
 * 解释：9 出现在 nums 中并且下标为 4
 *
 * 示例2：
 * 输入：nums = [-1, 0, 3, 5, 9, 12], target = 2
 * 输出：-1
 * 解释：2 不存在 nums 中因此返回 -1
 *
 * 提示：
 * 1、你可以假设 nums 中的所有元素是不重复的。
 * 2、n 将在 [1, 10000] 之间。
 * 3、nums 的每个元素都将在 [-9999, 9999] 之间。
 *
 * @author lizeteng
 * @date 2018/11/28
 */
public class Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                low = mid + 1;
            }

            if (nums[mid] > target) {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 3, 5, 9, 12};

        System.out.println(new Solution().search(array, 0));
    }
}

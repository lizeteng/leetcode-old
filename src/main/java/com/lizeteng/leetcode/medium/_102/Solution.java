package com.lizeteng.leetcode.medium._102;

import com.lizeteng.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。（即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 给定二叉树：[3, 9, 20, null, null, 15, 7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15  7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9, 20],
 *   [15, 7]
 * ]
 *
 * @author lizeteng
 * @date 2018/11/13
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        levelOrderInternally(result, 0, root);

        return result;
    }

    private void levelOrderInternally(List<List<Integer>> result, int index, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        if (index >= result.size()) {
            result.add(new LinkedList<>());
        }

        result.get(index).add(treeNode.val);

        index++;

        levelOrderInternally(result, index, treeNode.left);
        levelOrderInternally(result, index, treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new Solution().levelOrder(root));
    }
}
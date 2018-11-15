package com.lizeteng.leetcode.medium._094;

import com.lizeteng.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序遍历。
 *
 * 示例：
 * 输入：[1, null, 2, 3]
 *      1
 *       \
 *        2
 *       /
 *      3
 * 输出：[1, 3, 2]
 *
 * 进阶：
 * 通过迭代算法完成。
 *
 * @author lizeteng
 * @date 2018/11/15
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode treeNode = root;
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> linkedStack = new LinkedList<>();

        while (treeNode != null || !linkedStack.isEmpty()) {
            while (treeNode != null) {
                linkedStack.push(treeNode);

                treeNode = treeNode.left;
            }

            treeNode = linkedStack.pop();

            result.add(treeNode.val);

            treeNode = treeNode.right;
        }

        return result;
    }

    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        inorderTraversalRecursionInternally(result, root);

        return result;
    }

    private void inorderTraversalRecursionInternally(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversalRecursionInternally(result, root.left);

        result.add(root.val);

        inorderTraversalRecursionInternally(result, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(new Solution().inorderTraversal(root));
        System.out.println(new Solution().inorderTraversalRecursion(root));
    }
}

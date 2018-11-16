package com.lizeteng.leetcode.hard._145;

import com.lizeteng.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的后序遍历。
 *
 * 示例：
 * 输入：[1, null, 2, 3]
 *     1
 *      \
 *       2
 *      /
 *     3
 * 输出：[3, 2, 1]
 *
 * 进阶：
 * 通过迭代算法完成。
 *
 * @author lizeteng
 * @date 2018/11/15
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode treeNode = root, lastTreeNode = null;
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> linkedStack = new LinkedList<>();

        while (treeNode != null || !linkedStack.isEmpty()) {
            if (treeNode != null) {
                linkedStack.push(treeNode);

                treeNode = treeNode.left;
            } else {
                TreeNode tempTreeNode = linkedStack.peek();

                if (tempTreeNode.right != null && tempTreeNode.right != lastTreeNode) {
                    treeNode = tempTreeNode.right;
                } else {
                    lastTreeNode = linkedStack.pop();

                    result.add(tempTreeNode.val);
                }
            }
        }

        return result;
    }

    public List<Integer> postorderTraversalRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        postorderTraversalRecursionInternally(result, root);

        return result;
    }

    private void postorderTraversalRecursionInternally(List<Integer> result, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        postorderTraversalRecursionInternally(result, treeNode.left);
        postorderTraversalRecursionInternally(result, treeNode.right);

        result.add(treeNode.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(new Solution().postorderTraversal(root));
        System.out.println(new Solution().postorderTraversalRecursion(root));
    }
}

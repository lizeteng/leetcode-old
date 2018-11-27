package com.lizeteng.leetcode.easy._101;

import com.lizeteng.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1, 2, 2, 3, 4, 4, 3] 是对称的。
 *      1
 *     / \
 *    2   2
 *   / \ / \
 *  3  4 4 3
 * 但是下面这个 [1, 2, 2, null, 3, null, 3] 则不是镜像对称的：
 *      1
 *     / \
 *    2   2
 *     \   \
 *      3   3
 *
 * @author lizeteng
 * @date 2018/11/26
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        treeNodeQueue.offer(root);

        while (!treeNodeQueue.isEmpty()) {
            TreeNode t1 = treeNodeQueue.poll();
            TreeNode t2 = treeNodeQueue.poll();

            if (t1 == null && t2 == null) {
                continue;
            }

            if (t1 == null || t2 == null) {
                return false;
            }

            if (t1.val != t2.val) {
                return false;
            }

            treeNodeQueue.offer(t1.left);
            treeNodeQueue.offer(t2.right);
            treeNodeQueue.offer(t1.right);
            treeNodeQueue.offer(t2.left);
        }
        
        return true;
    }

    public boolean isSymmetricByRecursive(TreeNode root) {
        return isSymmetricByRecursiveInternally(root, root);
    }

    private boolean isSymmetricByRecursiveInternally(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        return (t1.val == t2.val)
                && isSymmetricByRecursiveInternally(t1.right, t2.left)
                && isSymmetricByRecursiveInternally(t1.left, t2.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(new Solution().isSymmetric(root));
        System.out.println(new Solution().isSymmetricByRecursive(root));
    }
}

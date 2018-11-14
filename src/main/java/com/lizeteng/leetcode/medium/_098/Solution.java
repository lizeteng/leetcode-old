package com.lizeteng.leetcode.medium._098;

import com.lizeteng.leetcode.base.TreeNode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 * 1、节点的左子树只包含小于当前节点的数。
 * 2、节点的右子树只包含大于当前节点的数。
 * 3、所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例1：
 * 输入：
 *     2
 *    / \
 *   1   3
 * 输出：true
 *
 * 示例2：
 * 输入：
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出：false
 * 解释：输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5，但是其右子节点值为 4。
 *
 * @author lizeteng
 * @date 2018/11/14
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValidBSTInternally(root, null, null);
    }

    private boolean isValidBSTInternally(TreeNode treeNode, Integer min, Integer max) {
        if (treeNode == null) {
            return true;
        }

        if (min != null && treeNode.val <= min) {
            return false;
        }

        if (max != null && treeNode.val >= max) {
            return false;
        }

        return isValidBSTInternally(treeNode.left, min, treeNode.val)
                && isValidBSTInternally(treeNode.right, treeNode.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(new Solution().isValidBST(root));
    }
}

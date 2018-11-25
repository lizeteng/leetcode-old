package com.lizeteng.leetcode.easy._107;

import com.lizeteng.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3, 9, 20, null, null, 15, 7]，
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * 返回其自底向上的层次遍历为：
 * [
 *   [15, 7],
 *   [9, 20],
 *   [3]
 * ]
 *
 * @author lizeteng
 * @date 2018/11/24
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);

        while (!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            List<Integer> levelTreeNodes = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode current = treeNodeQueue.poll();

                levelTreeNodes.add(current.val);

                if (current.left != null) {
                    treeNodeQueue.offer(current.left);
                }

                if (current.right != null) {
                    treeNodeQueue.offer(current.right);
                }
            }

            result.add(levelTreeNodes);
        }

        int mid = result.size() / 2;

        for (int i = 0, j = result.size() - 1; i < mid; i++){
            List<Integer> tempList = result.get(j);

            result.set(j--, result.get(i));
            result.set(i, tempList);
        }

        return result;
    }

    public List<List<Integer>> levelOrderBottomByRecursive(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        levelOrderBottomByRecursiveInternally(result, 0, root);

        int mid = result.size() / 2;

        for (int i = 0, j = result.size() - 1; i < mid; i++){
            List<Integer> tempList = result.get(j);

            result.set(j--, result.get(i));
            result.set(i, tempList);
        }

        return result;
    }

    private void levelOrderBottomByRecursiveInternally(List<List<Integer>> result, int levelIndex, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        if (levelIndex >= result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(levelIndex).add(treeNode.val);

        levelIndex++;

        levelOrderBottomByRecursiveInternally(result, levelIndex, treeNode.left);
        levelOrderBottomByRecursiveInternally(result, levelIndex, treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new Solution().levelOrderBottom(root));
        System.out.println(new Solution().levelOrderBottomByRecursive(root));
    }
}

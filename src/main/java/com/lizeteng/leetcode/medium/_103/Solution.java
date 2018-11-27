package com.lizeteng.leetcode.medium._103;

import com.lizeteng.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3, 9, 20, null, null, 15, 7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20, 9],
 *   [15, 7]
 * ]
 *
 * @author lizeteng
 * @date 2018/11/27
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);

        boolean isRightStart = false;

        while (!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            List<Integer> levelTreeNodes = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode tempTreeNode = treeNodeQueue.poll();

                levelTreeNodes.add(tempTreeNode.val);

                if (tempTreeNode.left != null) {
                    treeNodeQueue.offer(tempTreeNode.left);
                }

                if (tempTreeNode.right != null) {
                    treeNodeQueue.offer(tempTreeNode.right);
                }
            }

            if (isRightStart) {
                int mid = levelTreeNodes.size() / 2;

                for (int i = 0, j = levelTreeNodes.size() - 1; i < mid; i++) {
                    int tempInt = levelTreeNodes.get(j);

                    levelTreeNodes.set(j--, levelTreeNodes.get(i));
                    levelTreeNodes.set(i, tempInt);
                }

                isRightStart = false;
            } else {
                isRightStart = true;
            }

            result.add(levelTreeNodes);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new Solution().zigzagLevelOrder(root));
    }
}

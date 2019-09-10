package TreeProblem;

import java.util.*;

public class LeftOrRightSideView_199 {
    // 二叉树的右视图
    //给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
    // 1. 右视图 递归解法
    public List<Integer> rightSideViewRecur(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightSideView(root, res, 0);
        return res;
    }

    private void rightSideView(TreeNode root, List<Integer> res, int level) {
        if (root == null)
            return;
        if (level == res.size()) {
            res.add(root.val);
        }
        rightSideView(root.right, res, level + 1);
        rightSideView(root.left, res, level + 1);
    }

    // 2.右视图 非递归解法
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return res;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
                if (size == 0) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    // 二叉树左视图
    // 1.左视图 递归解法
    public List<Integer> leftSideViewRecur(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        leftSideView(root, res, 0);
        return res;
    }

    private void leftSideView(TreeNode root, List<Integer> res, int level) {
        if (root == null)
            return;
        if (res.size() == level) {
            res.add(root.val);
        }
        leftSideView(root.left, res, level + 1);
        leftSideView(root.right, res, level + 1);
    }

    // 2.左视图 非递归解法
    public List<Integer> leftSideViewUnRecur(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                size--;
                if (size == 0) {
                    res.add(root.val);
                }
            }
        }
        return res;
    }
}

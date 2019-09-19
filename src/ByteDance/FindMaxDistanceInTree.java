package ByteDance;

import TreeProblem.TreeNode;

public class FindMaxDistanceInTree {
    //题目：如果我们把二叉树看做图，父子节点之间的连线看成是双向的，
    // 我们姑且定义“距离”为两个节点之间边的个数。
    // 写一个程序求一棵二叉树中相距最远的两个节点之间的距离。
    //计算一个二叉树的最大距离有两个情况：
    //
    //情况A: 路径经过左子树的最深节点，通过根节点，再到右子树的最深节点。
    //情况B: 路径不穿过根节点，而是左子树或右子树的最大距离路径，取其大者

    // 方法1 定义一个节点  包括左子树，右子树，左子树中的最长距离，右子树中的最长距离，该节点的值



    // 方法2
    // 要求的二叉树的最大距离其实就是求：肯定是某个节点左子树的高度加上右子树的高度加2，
    // 所以求出每个节点左子树和右子树的高度，取左右子树高度之和减2的最大值即可，假设空节点的高度为0

    public int getMaxDistance2(TreeNode root) {
        if (root == null)
            return 0;
        int maxDistance = 0;
        int height = getHeight(root, maxDistance);
        return maxDistance;
    }

    private int getHeight(TreeNode root, int maxDistance) {
        if (root == null)
            return 0;
        int left = getHeight(root.left, maxDistance);
        int right = getHeight(root.right, maxDistance);
        int distance = left + right;
        maxDistance = Math.max(maxDistance, distance);
        return left > right ? left + 1 : right + 1;
    }


}

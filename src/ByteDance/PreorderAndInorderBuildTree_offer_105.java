package ByteDance;

import TreeProblem.TreeNode;

import java.util.Arrays;

public class PreorderAndInorderBuildTree_offer_105 {
    // LeetCode 105
    //输入一棵二叉树前序遍历和中序遍历的结果，请重建该二叉树。
    //注意:
    //二叉树中每个节点的值都互不相同；
    //输入的前序遍历和中序遍历一定合法；
    //样例
    //给定：
    //前序遍历是：[3, 9, 20, 15, 7]
    //中序遍历是：[9, 3, 15, 20, 7]
    //返回：[3, 9, 20, null, null, 15, 7, null, null, null, null]
    //返回的二叉树如下所示：
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        if (preorder.length != inorder.length)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                //pre的0往后数i个是左子树的，copyOfRange包含前面的下标，不包含后面的下标
                //in的i往前数i个是左子树的。
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                //注意in是从i+1开始，因为i是现在的根，i+1开始才是右子树
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        return root;
    }
}

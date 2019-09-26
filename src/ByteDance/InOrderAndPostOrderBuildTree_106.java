package ByteDance;

import TreeProblem.TreeNode;

import java.util.Arrays;

public class InOrderAndPostOrderBuildTree_106 {
    //根据一棵树的中序遍历与后序遍历构造二叉树。
    //注意:
    //你可以假设树中没有重复的元素。
    //
    //例如，给出
    //
    //中序遍历 inorder = [9,3,15,20,7]
    //后序遍历 postorder = [9,15,7,20,3]
    //返回如下的二叉树：
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null)
            return null;
        if (inorder.length == 0 || postorder.length == 0)
            return null;
        if (inorder.length != postorder.length)
            return null;
        int len = postorder.length;
        TreeNode root = new TreeNode(postorder[len - 1]);
        for (int i = 0; i < len; i++) {
            if (inorder[i] == postorder[len - 1]) {
                root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, len), Arrays.copyOfRange(postorder, i, len - 1));
            }
        }
        return root;
    }
}

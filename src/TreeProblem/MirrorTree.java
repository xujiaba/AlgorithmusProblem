package TreeProblem;

public class MirrorTree {
    // 二叉树的镜像
    //输入一个二叉树，将它变换为它的镜像。
    //样例
    //输入树：
    //      8
    //     / \
    //    6  10
    //   / \ / \
    //  5  7 9 11
    // [8,6,10,5,7,9,11,null,null,null,null,null,null,null,null]
    //输出树：
    //      8
    //     / \
    //    10  6
    //   / \ / \
    //  11 9 7  5
    // [8,10,6,11,9,7,5,null,null,null,null,null,null,null,null]

    public void mirror(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null || root.right != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            mirror(root.left);
            mirror(root.right);
        }
    }
}

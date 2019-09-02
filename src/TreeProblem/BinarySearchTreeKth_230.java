package TreeProblem;

public class BinarySearchTreeKth_230 {
    //给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
    //
    //说明：
    //你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

    public int kthSmallest(TreeNode root, int k) {
        TreeNode res = KthNode(root, k);
        return  res.val;
    }

    int index = 0;
    public TreeNode KthNode(TreeNode root, int k) {
        if(root != null) {
            TreeNode node = KthNode(root.left, k);
            if(node != null)
                return node;
            index++;
            if(index == k){
                return root;
            }
            node = KthNode(root.right, k);
            if(node != null)
                return node;
        }
        return null;
    }
}

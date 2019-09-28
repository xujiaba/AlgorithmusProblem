package TreeProblem;

import TreeProblem.TreeNode;

public class JudgeSubtree_572 {
    //给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/subtree-of-another-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean res = false;
        if (s != null && t != null) {
            if (s.val == t.val) {
                res = doesTree1HasTree2(s, t);
            }
            if (!res) {
                res = isSubtree(s.left, t);
            }
            if (!res) {
                res = isSubtree(s.right, t);
            }
        }
        return res;
    }

    private boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root1== null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val)
            return false;
        return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
    }
}

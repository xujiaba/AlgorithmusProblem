package TreeProblem;

import java.util.LinkedList;
import java.util.Queue;

public class ISMirrorTree_101 {

    // 对称二叉树  101
    //给定一个二叉树，检查它是否是镜像对称的。
    //
    //例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    //
    //    1
    //   / \
    //  2   2
    // / \ / \
    //3  4 4  3
    //但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    //
    //    1
    //   / \
    //  2   2
    //   \   \
    //   3    3
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/symmetric-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    // 递归  O(n)   O(n)
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q ? true : false;
        }
        return p.val == q.val && symmetric(p.left, q.right) && symmetric(p.right, q.left);
    }


    // 迭代   O(n)    O(n)
    //除了递归的方法外，我们也可以利用队列进行迭代。队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像。
    // 最初，队列中包含的是 root 以及 root。该算法的工作原理类似于 BFS，但存在一些关键差异。
    // 每次提取两个结点并比较它们的值。然后，将两个结点的左右子结点按相反的顺序插入队列中。
    // 当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
    //
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

}

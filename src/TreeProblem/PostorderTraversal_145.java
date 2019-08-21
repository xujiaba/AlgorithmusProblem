package TreeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = root;  // 上一个弹出并打印的节点
            TreeNode stackPeek = null; // 当前栈顶结点
            stack.push(pre);
            while (!stack.isEmpty()) {
                stackPeek = stack.peek();
                if (stackPeek.left != null && pre != stackPeek.left && pre != stackPeek.right) {
                    stack.push(stackPeek.left);
                } else if (stackPeek.right != null && pre != stackPeek.right) {
                    stack.push(stackPeek.right);
                } else {
                    res.add(stack.pop().val);
                    pre = stackPeek;
                }
            }
        }
        return res;
    }
}

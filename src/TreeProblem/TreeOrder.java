package TreeProblem;

import java.util.Stack;

public class TreeOrder {
    public void preOrderRecur(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    public void preOrderUnRecur(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                System.out.println(cur.val);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
    }

    public void inOrderRecur(TreeNode root) {
        if (root == null)
            return;
        inOrderRecur(root.left);
        System.out.println(root.val);
        inOrderRecur(root.right);
    }

    public void inOrderUnRecur(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.println(root.val);
                    root = root.right;
                }
            }
        }
    }

    public void posOrderRecur(TreeNode root) {
        if (root == null)
            return;
        posOrderRecur(root.left);
        posOrderRecur(root.right);
        System.out.println(root.val);
    }

    public void posOrderUnRecur(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode lastPrint = root;  //代表最近一次被弹出并打印的节点
            TreeNode stackPeek = null; //Stack的栈顶节点
            while (!stack.isEmpty()) {
                stackPeek = stack.peek();
                if (stackPeek.left != null && lastPrint != stackPeek.left && lastPrint != stackPeek.right) {
                    stack.push(stackPeek.left);
                } else if (stackPeek.right != null && lastPrint != stackPeek.right) {
                    stack.push(stackPeek.right);
                } else {
                    System.out.println(stack.pop().val);
                    lastPrint = stackPeek;
                }
            }
        }
    }
}

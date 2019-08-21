package TreeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
    }

    public List<Integer> inorderTravesalStack(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root != null){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()){
                if (cur != null){
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }

}

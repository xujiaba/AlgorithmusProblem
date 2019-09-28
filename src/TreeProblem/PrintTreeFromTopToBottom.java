package TreeProblem;

import TreeProblem.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintTreeFromTopToBottom {
    // 之字形打印二叉树
    //请实现一个函数按照之字形顺序从上向下打印二叉树。
    //即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
    //样例
    //输入如下图所示二叉树[8, 12, 2, null, null, 6, 4, null, null, null, null]
    //    8
    //   / \
    //  12  2
    //     / \
    //    6   4
    //输出：[[8], [2, 12], [6, 4]]

    // 用两个栈分别存储

    public List<List<Integer>> printFromTopToBottom(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        if (root == null)
            return resList;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        int level = 1;
        s1.push(root);
        List<Integer> tmp = new ArrayList<>();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (level % 2 != 0) {
                // 奇数层
                while (!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    tmp.add(node.val);
                    if (node.left != null)
                        s2.push(node.left);
                    if (node.right != null)
                        s2.push(node.right);
                }
            } else {
                //偶数层
                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    tmp.add(node.val);
                    if (node.right != null)
                        s1.push(node.right);
                    if (node.left != null)
                        s1.push(node.left);
                }

            }
            if (!tmp.isEmpty()) {
                resList.add(new ArrayList<>(tmp));
                tmp.clear();
                level++;
            }
        }
        return resList;
    }
}

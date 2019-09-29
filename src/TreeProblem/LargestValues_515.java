package TreeProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues_515 {

    //打印二叉树每行最大值
    //您需要在二叉树的每一行中找到最大的值。
    //示例：
    //输入:
    //
    //          1
    //         / \
    //        3   2
    //       / \   \
    //      5   3   9
    //
    //输出: [1, 3, 9]
    //链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row

    // 层次遍历找出最大值即可
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size > 0){
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                max = Math.max(max, node.val);
                size--;
            }
            res.add(max);
        }
        return res;
    }

}

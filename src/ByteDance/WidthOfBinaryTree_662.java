package ByteDance;

import TreeProblem.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WidthOfBinaryTree_662 {
    // 二叉树的最大宽度 662
    //给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。
    // 这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
    //每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    /**
     * 假设将满二叉树表示成数组序列, 根节点所在的位置为 1,
     * 则任意位于 i节点的左右子节点的 index 为 2*i, 2*i+1。
     * 用一个 List 保存每层的左端点,易知二叉树有多少层 List 的元素就有多少个。
     * 那么可以在 dfs 的过程中记录每个节点的 index 及其所在的层level,
     * 如果 level > List.size() 说明当前节点就是新的一层的最左节点, 将其加入 List 中,
     * 否则判断当前节点的 index 减去 List 中对应层的最左节点的 index 的宽度是否大于最大宽度并更新
     **/

    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int maxWidth = 0;
        process(root, 1, 1, maxWidth, list);
        return maxWidth;
    }

    private void process(TreeNode root, int level, int index, int maxWidth, List<Integer> list) {
        if (root == null)
            return;
        if (level > list.size())
            list.add(index);
        maxWidth = Math.max(maxWidth, index - list.get(level - 1) + 1);
        process(root.left, level + 1, index * 2, maxWidth, list);
        process(root.right, level + 1, index * 2 + 1, maxWidth, list);
    }

}

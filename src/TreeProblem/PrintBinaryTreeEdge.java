package TreeProblem;

public class PrintBinaryTreeEdge {

    public void printEdge1(TreeNode head) {
        if (head == null) {
            return;
        }
        int height = getHeight(head, 0);
        TreeNode[][] edgeMap = new TreeNode[height][2];
        setEdgeMap(head, 0, edgeMap);
        // 打印左边边界节点
        for (int i = 0; i != edgeMap.length; i++) {
            System.out.print(edgeMap[i][0].val + " ");
        }
        //  打印非左右边界的叶节点
        printLeafNotInMap(head, 0, edgeMap);
        // 逆序打印右边界
        for (int i = edgeMap.length - 1; i != -1; i--) {
            if (edgeMap[i][0] != edgeMap[i][1]) {
                System.out.print(edgeMap[i][1].val + " ");
            }
        }
        System.out.println();
    }

    public int getHeight(TreeNode node, int h) {
        if (node == null)
            return h;
        return Math.max(getHeight(node.left, h + 1), getHeight(node.right, h + 1));
    }

    public void setEdgeMap(TreeNode node, int h, TreeNode[][] edgeMap) {
        if (node == null)
            return;
        edgeMap[h][0] = edgeMap[h][0] == null ? node : edgeMap[h][0];
        edgeMap[h][1] = node;
        setEdgeMap(node.left, h + 1, edgeMap);
        setEdgeMap(node.right, h + 1, edgeMap);
    }

    public void printLeafNotInMap(TreeNode node, int h, TreeNode[][] edgeMap) {
        if (node == null)
            return;
        if (node.left == null && node.right == null && node != edgeMap[h][0] && node != edgeMap[h][1]) {
            System.out.print(node.val + " ");
        }
        printLeafNotInMap(node.left, h + 1, edgeMap);
        printLeafNotInMap(node.right, h + 1, edgeMap);
    }

}


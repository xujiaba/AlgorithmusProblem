package ArrayProblem;

// 螺旋打印矩阵(顺时针打印矩阵) （转圈打印矩阵）
public class PrintMatrix {
    public void spiralOrderPrint(int[][] matrix) {
        // 左上角节点的坐标，（0,0） R 代表 行 row, C 代表列 column
        int tR = 0, tC = 0;
        // 右下角节点的坐标，
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        // 螺旋（顺时针）打印每一个矩阵
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) { // 子矩阵只有一行的时候
            for (int i = tC; i <= dC; i++) {
                System.out.println(m[tR][i] + " ");
            }
        } else if (tC == dC) { // 子矩阵只有一列的时候
            for (int i = tR; i <= dR; i++) {
                System.out.println(m[i][tC] + " ");
            }
        } else {   // 一般情况
            int curR = tR;
            int curC = tC;
            while (curC != dC) {
                System.out.println(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {
                System.out.println(m[curR][dC] + " ");
                curR++;
            }
            while (curC != tC) {
                System.out.println(m[dR][curC] + " ");
                curC--;
            }
            while (curR != tR) {
                System.out.println(m[curR][tC] + " ");
                curR--;
            }
        }
    }
}

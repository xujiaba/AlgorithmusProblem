package ArrayProblem;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderPrint_54 {

    //螺旋矩阵，螺旋打印矩阵 LeetCode 54
    //给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
    //
    //示例 1:
    //
    //输入:
    //[
    // [ 1, 2, 3 ],
    // [ 4, 5, 6 ],
    // [ 7, 8, 9 ]
    //]
    //输出: [1,2,3,6,9,8,7,4,5]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/spiral-matrix
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int tR = 0, tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            process(matrix, tR++, tC++, dR--, dC--, res);
        }
        return res;
    }

    private void process(int[][] matrix, int tR, int tC, int dR, int dC, List<Integer> res) {
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                res.add(matrix[tR][i]);
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                res.add(matrix[i][tC]);
            }
        } else {
            int curC = tC, curR = tR;
            while (curC != dC) {
                res.add(matrix[tR][curC++]);
            }
            while (curR != dR) {
                res.add(matrix[curR++][dC]);
            }
            while (curC != tC) {
                res.add(matrix[dR][curC--]);
            }
            while (curR != tR) {
                res.add(matrix[curR--][tC]);
            }
        }
    }
}

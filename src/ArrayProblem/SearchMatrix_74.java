package ArrayProblem;

public class SearchMatrix_74 {

    // LeetCode 74
    //编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
    //
    //每行中的整数从左到右按升序排列。
    //每行的第一个整数大于前一行的最后一个整数。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/search-a-2d-matrix

    // 把二维数组转化成以为数组来做， 在一维数组中下标在二维数组中为 row = index / cols, col = index % cols;
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0)
            return false;
        int cols = matrix[0].length;

        int left = 0, right = rows * cols - 1;
        int midIndex, midData;
        while (left <= right) {
            midIndex = left + ((right - left) >> 1);
            midData = matrix[midIndex / cols][midIndex % cols]; // 这个地方注意所在行跟所在列都跟列数有关
            if (midData < target) {
                left = midIndex + 1;
            } else if (midData > target) {
                right = midIndex - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}

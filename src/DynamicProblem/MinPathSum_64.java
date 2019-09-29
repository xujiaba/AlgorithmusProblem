package DynamicProblem;

public class MinPathSum_64 {

    // 最小路径和
    // 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    //说明：每次只能向下或者向右移动一步。
    //示例:
    //输入:
    //[
    //  [1,3,1],
    //  [1,5,1],
    //  [4,2,1]
    //]
    //输出: 7
    //解释: 因为路径 1→3→1→1→1 的总和最小。
    //链接：https://leetcode-cn.com/problems/minimum-path-sum

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[rows - 1][cols - 1] = grid[rows - 1][cols - 1];
        for (int i = rows - 2; i >= 0; i--) {
            dp[i][cols - 1] = grid[i][cols - 1] + dp[i + 1][cols - 1];
        }
        for (int i = cols - 2; i >= 0; i--) {
            dp[rows - 1][i] = grid[rows - 1][i] + dp[rows - 1][i + 1];
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }
        return dp[0][0];

    }
}

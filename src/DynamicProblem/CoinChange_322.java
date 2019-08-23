package DynamicProblem;

public class CoinChange_322 {
    //给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
    // 如果没有任何一种硬币组合能组成总金额，返回 -1。
    //
    // 暴力递归的方法
    public static int coinChange1(int[] coins, int amount) {
        if (coins == null || coins.length <= 0 || amount <= 0) {
            return -1;
        }
        return process(coins, 0, amount);
    }

    private static int process(int[] coins, int i, int rest) {
        if (i == coins.length) {
            return rest == 0 ? 0 : -1; //剩余需要找的钱为0，返回0张
        }
        int res = -1;
        for (int k = 0; k * coins[i] <= rest; k++) {
            int next = process(coins, i + 1, rest - k * coins[i]);
            if (next != -1) {
                res = res == -1 ? next + k : Math.min(res, next + k);
            }
        }
        return res;
    }

    // 改成动态规划的版本
    public static int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length <= 0 || amount < 0) {
            return -1;
        }
        int N = coins.length;
        int[][] dp = new int[N + 1][amount + 1];
        for (int col = 1; col <= amount; col++) {
            dp[N][col] = -1;
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int rest = 0; rest <= amount; rest++) {
                dp[i][rest] = -1;
                if (dp[i + 1][rest] != -1) {
                    dp[i][rest] = dp[i + 1][rest];
                }
                if (rest - coins[i] >= 0 && dp[i][rest - coins[i]] != -1) {
                    dp[i][rest] = dp[i][rest] == -1 ?
                            dp[i][rest - coins[i]] + 1 : Math.min(dp[i][rest], dp[i][rest - coins[i]] + 1);
                }
            }
        }
        return dp[0][amount];
    }

}

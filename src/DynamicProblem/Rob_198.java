package DynamicProblem;

public class Rob_198 {
    //你是一个专业的小偷，计划偷窃沿街的房屋。
    // 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
    // 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
    //给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
    //


    //暴力递归法
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return process(nums, 0);
    }

    private int process(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        return Math.max(nums[i] + process(nums, i + 2), process(nums, i + 1));
    }


    //动态规划法
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) { //这里代表把整个dp走完，因此需要注意nums的下标
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}

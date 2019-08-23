package DynamicProblem;

import java.util.Arrays;

public class LengthOfLIS_300 {

    //给定一个无序的整数数组，找到其中最长上升子序列的长度。
    //
    //示例:
    //
    //输入: [10,9,2,5,3,7,101,18]
    //输出: 4
    //解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。


    // 动态规划法 O(N^2)
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int value : dp) {
            res = Math.max(res, value);
        }
        return res;
    }
}

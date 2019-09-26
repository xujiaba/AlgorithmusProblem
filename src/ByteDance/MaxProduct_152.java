package ByteDance;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

public class MaxProduct_152 {

    // 乘积最大子序列
    //给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
    //示例 1:
    //输入: [2,3,-2,4]
    //输出: 6
    //解释: 子数组 [2,3] 有最大乘积 6。
    //示例 2:
    //输入: [-2,0,-1]
    //输出: 0
    //解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/maximum-product-subarray
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int curMax = 1, curMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                // 当前值 < 0， 此时交换 最大最小值
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }
            curMax = Math.max(nums[i] * curMax, nums[i]);
            curMin = Math.min(nums[i] * curMin, nums[i]);

            res = Math.max(res, curMax);
        }
        return res;
    }

}

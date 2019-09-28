package ArrayProblem;

public class MaxSubSum {
    //最大连续子序列和

    public int maxSubSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int tmpSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (tmpSum > 0) {
                tmpSum += nums[i];
            } else {
                tmpSum = nums[i];
            }
            maxSum = Math.max(maxSum, tmpSum);
        }
        return maxSum;
    }

    //最大连续子序列和 并返回其开始和结束的位置
    public int maxSubSum2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int tmpSum = 0;
        int start = 0, end = 0, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (tmpSum > 0) {
                tmpSum += nums[i];
            } else {
                tmpSum = nums[i];
                cur = i;
            }
            if (tmpSum > maxSum) {
                maxSum = tmpSum;
                start = cur;
                end = i;
            }
        }
        System.out.println("s = " + start + " e = " + end);
        return maxSum;
    }

}

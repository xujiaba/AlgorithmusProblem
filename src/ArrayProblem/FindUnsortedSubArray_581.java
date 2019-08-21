package ArrayProblem;

public class FindUnsortedSubArray_581 {
//    给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//    你找到的子数组应是最短的，请输出它的长度。
//
//    示例 1:
//    输入: [2, 6, 4, 8, 10, 9, 15]
//    输出: 5
//    解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
//    说明 :
//    输入的数组长度范围在 [1, 10,000]。
//    输入的数组可能包含重复元素 ，所以升序的意思是<=。

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int minIndex = -1;
        int min = nums[nums.length - 1];
        for (int i = nums.length - 2; i > -1; i--) {
            if (nums[i] > min) {
                minIndex = i;
            } else {
                min = Math.min(min, nums[i]);
            }
        }
        if (minIndex == -1) {
            return 0;
        }
        int maxIndex = -1;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < max) {
                maxIndex = i;
            } else {
                max = Math.max(max, nums[i]);
            }
        }
        return maxIndex - minIndex + 1;
    }
}

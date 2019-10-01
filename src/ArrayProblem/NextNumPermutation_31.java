package ArrayProblem;

import java.util.Arrays;

public class NextNumPermutation_31 {
    // 31. 下一个排列
    //实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
    //如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    //必须原地修改，只允许使用额外常数空间。
    //以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
    //1,2,3 → 1,3,2
    //3,2,1 → 1,2,3
    //1,1,5 → 1,5,1
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/next-permutation
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 找到第一个 比后一个数小的数
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {   // 找到最后一个大于 nums[i] 的数
                j--;
            }
            swap(nums, i, j);   // 交换
        }
        reverse(nums, i + 1);  // 因为交换后的序列是按照从大到小的顺序进行排列的，所以反转以下就变成最小的了
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

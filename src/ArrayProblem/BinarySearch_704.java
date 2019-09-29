package ArrayProblem;

public class BinarySearch_704 {

    // 二分搜索   704
    //给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，
    // 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
    //
    //链接：https://leetcode-cn.com/problems/binary-search

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {  // = 记得要加  重要！！！
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

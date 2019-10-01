package ArrayProblem;

public class SearchTargetInRotatedSortedArray_33 {
    //假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    //( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    //搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
    //你可以假设数组中不存在重复的元素。
    //你的算法时间复杂度必须是 O(log n) 级别。
    //示例 1:
    //输入: nums = [4,5,6,7,0,1,2], target = 0
    //输出: 4
    //示例 2:
    //输入: nums = [4,5,6,7,0,1,2], target = 3
    //输出: -1
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                if (nums[left] > nums[right] && (nums[mid] >= nums[left] && nums[left] > target)) {
                    // 确定在右边的情况，当旋转数组成立且左边界大于目标值
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                if (nums[left] > nums[right] && (nums[mid] < nums[left] && nums[right] < target)) {
                    // 确定在左边的情况， 当旋转数组成立且右边界小于目标值
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }
}

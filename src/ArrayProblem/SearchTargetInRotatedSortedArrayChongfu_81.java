package ArrayProblem;

public class SearchTargetInRotatedSortedArrayChongfu_81 {
    //假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    //( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
    //编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
    // 存在重复的元素。
    //示例 1:
    //输入: nums = [2,5,6,0,0,1,2], target = 0
    //输出: true
    //示例 2:
    //输入: nums = [2,5,6,0,0,1,2], target = 3
    //输出: false
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return true;
            }
            // 去重
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            // 前半部分有序
            if (nums[left] < nums[mid]) {
                // target在前半部分
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    // 否则去后半部分找
                    left = mid + 1;
                }
            } else {
                // 后半部分有序
                // target在后半部分
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    //否则去前半部分找
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}

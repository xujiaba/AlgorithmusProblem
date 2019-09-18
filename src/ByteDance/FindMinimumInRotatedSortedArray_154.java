package ByteDance;

public class FindMinimumInRotatedSortedArray_154 {
    //假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    //( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    //请找出其中最小的元素。
    //注意数组中可能存在重复的元素。
    //
    //示例 1：
    //输入: [1,3,5]
    //输出: 1
    //示例 2：
    //输入: [2,2,2,0,1]
    //输出: 0
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    //旋转排序数组 numsnums 可以被拆分为 2 个排序数组 nums1nums1 , 并且 nums1任一元素 >= nums2任一元素；
    // 因此，考虑二分法寻找此两数组的分界点 nums[i]nums[i] (即第 2 个数组的首个元素)。
    //设置 left, right 指针在 nums 数组两端，mid为每次二分的中点：
    //当 nums[mid] > nums[right]时，mid一定在第 1 个排序数组中，i 一定满足 mid < i <= right，因此执行 left = mid + 1；
    //当 nums[mid] < nums[right] 时，mid 一定在第 2 个排序数组中，ii 一定满足 left < i <= mid，因此执行 right = mid；
    //当 nums[mid] == nums[right] 时，是此题对比 153题 的难点（原因是此题中数组的元素可重复，难以判断分界点 ii 指针区间）；
    //  例如[1,0,1,1,1] 和 [1,1,1,0,1] ，在 left = 0, right = 4, mid = 2 时，无法判断 mid 在哪个排序数组中。
    //我们采用 right = right - 1 解决此问题，证明：
    //  此操作不会使数组越界：因为迭代条件保证了 right > left >= 0；
    //  此操作不会使最小值丢失：假设 nums[right]nums[right] 是最小值，有两种情况：
    //      若 nums[right] 是唯一最小值：那就不可能满足判断条件 nums[mid] == nums[right]，因为 mid < right（left != right 且 mid = (left + right) // 2 向下取整）；
    //      若 nums[right] 不是唯一最小值，由于 mid < right 而 nums[mid] == nums[right]，即还有最小值存在于[left,right−1] 区间，因此不会丢失最小值。
    //
    //作者：jyd
    //链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/154-find-minimum-in-rotated-sorted-array-ii-by-jyd/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right = right - 1;
            }
        }
        return nums[left];
    }
}

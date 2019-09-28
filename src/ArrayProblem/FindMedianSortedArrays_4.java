package ArrayProblem;

public class FindMedianSortedArrays_4 {

    // 寻找两个有序数组的中位数
    //给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
    //请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
    //你可以假设 nums1 和 nums2 不会同时为空。
    //示例 1:
    //nums1 = [1, 3]
    //nums2 = [2]
    //则中位数是 2.0
    //示例 2:
    //nums1 = [1, 2]
    //nums2 = [3, 4]
    //则中位数是 (2 + 3)/2 = 2.5
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int left = -1, right = -1;
        int aIndex = 0, bIndex = 0;
        for (int i = 0; i <= len / 2; i++) {  // 记得是 <= 否则当 len 为奇数时拿不到中间值
            left = right;
            if (aIndex < len1 && (bIndex >= len2 || nums1[aIndex] < nums2[bIndex])) {
                right = nums1[aIndex++];
            } else {
                right = nums2[bIndex++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }


}

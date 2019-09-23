package ByteDance;

public class KthLargestElementInAnArray_215 {
    // 数组中的第K个最大的元素 215
    //在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    //示例 1:
    //输入: [3,2,1,5,6,4] 和 k = 2
    //输出: 5
    //示例 2:
    //输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
    //输出: 4
    //说明:
    //你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    //利用快排的partition
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] nums, int left, int right, int kSmall) {
        if (left == right) {
            return nums[left];
        }
        swap(nums, left + (int) (Math.random() * (right - left + 1)), right);
        int[] p = partition(nums, left, right);
        if (kSmall == p[0] || kSmall == p[1] || (kSmall > p[0] && kSmall < p[1])) {
            return nums[kSmall];
        }
        if (kSmall < p[0]) {
            return quickSelect(nums, left, p[0] - 1, kSmall);
        }
        return quickSelect(nums, p[1] + 1, right, kSmall);
    }


    public int[] partition(int[] nums, int L, int R) {
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (nums[index] < nums[R]) {
                swap(nums, index++, ++less);
            } else if (nums[index] > nums[R]) {
                swap(nums, index, --more);
            } else {
                index++;
            }
        }
        swap(nums, more, R);
        return new int[]{less + 1, more};
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

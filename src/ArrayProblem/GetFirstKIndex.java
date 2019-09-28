package ArrayProblem;

public class GetFirstKIndex {
    //数字在排序数组中第一次出现的位置
    //输出一个有序数组中一个数字的第一次出现的位置或者返回-1.
    public int getFirstKIndex(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (nums[mid] == k) {
                while (mid - 1 >= 0 && nums[mid-1] == k){
                    mid--;
                }
                return mid;
            } else if (nums[mid] < k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}

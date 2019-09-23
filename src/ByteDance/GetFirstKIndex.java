package ByteDance;

public class GetFirstKIndex {
    //数字在排序数组中第一次出现的位置，如果没有找到返回比此数小的一个数的位置
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

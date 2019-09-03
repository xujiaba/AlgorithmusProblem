package ArrayProblem;

import java.util.HashMap;

public class MaxLength_325 {

    //未排序正数数组中累加和为定值的最长子数组长度
    public int getMaxlength(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }
        int left = 0, right = 0;
        int sum = arr[0];
        int len = 0;
        while (right < arr.length) {
            if (sum == k) {
                len = Math.max(len, right - left + 1);
                sum -= arr[left++];
            } else if (sum < k) {
                right++;
                if (right == arr.length) {
                    break;
                }
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }
        return len;
    }




    //Leetcode 325
    //未排序数组中累加和为给定值的最长子数组的长度
    // 利用HashMap 保存sum第一次出现的位置
    public int maxlength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int sum = 0;
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);   // 重要，否则将不会考虑从0位置开始的子数组
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(i - map.get(sum - k), len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }


}

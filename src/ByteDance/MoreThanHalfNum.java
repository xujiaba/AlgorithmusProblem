package ByteDance;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

public class MoreThanHalfNum {

    // 数组中出现次数超过一半的数字
    // 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    //假设数组非空，并且一定存在满足条件的数字。
    //思考题：
    //假设要求只能使用 O(n) 的时间和额外 O(1) 的空间，该怎么做呢？
    //样例
    //输入：[1,2,1,1,3]
    //输出：1


    // 方法1 使用partition
    public int moreThanHalfNum_Solution(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + ((right - left) >> 1);
        while (true) {
            swap(nums, left + (int) (Math.random() * (right - left + 1)), right);
            int[] p = partition(nums, left, right);
            if (mid >= p[0] && mid <= p[1]) {
                break;
            }
            if (mid < p[0]) {
                right = p[0] - 1;
            }
            if (mid > p[1]) {
                left = p[1] + 1;
            }
        }
        return nums[mid];
    }

    public int[] partition(int[] nums, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (nums[L] < nums[R]) {
                swap(nums, ++less, L++);
            } else if (nums[L] > nums[R]) {
                swap(nums, --more, L);
            } else {
                L++;
            }
        }
        swap(nums, R, more);
        return new int[]{less + 1, more};
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    // 方法 2
    //     * 一次再数组中删除两个不同的数，最后剩下的数有可能是超过一半的。所以要检验一下。 一个数出现次数大于一半，他肯定会被剩下来，但是剩下来的缺不一定满足。
    //     * 算法步骤：
    //     * 如果times为0，就把候选设为当前值。
    //     * 如果下个数和候选一样，times就++。
    //     * 如果下个数和候选不一样，times就--。相当于对子，同归于尽。因为超过一半的数肯定超过剩下的所有数。所以和这个数对，这个数肯定会剩下来。
    //     * 但是剩下的数不一定是，比如 1 2 3 剩下3 比如 1 2 1 3 3 3 2 2 也是剩下3.所以要余外的判断，看是否这个数真的超过。
    public int moreThanHalfNum_Solution2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int times = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (times == 0) {
                res = nums[i];
                times = 1;
            } else if (nums[i] == res) {
                times++;
            } else {
                times--;
            }
        }
        times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == res) {
                times++;
            }
        }
        return times * 2 > nums.length ? res : 0;
    }

}

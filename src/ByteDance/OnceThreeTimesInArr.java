package ByteDance;

public class OnceThreeTimesInArr {
    //在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。
    //请找出那个只出现一次的数字。
    //你可以假设满足条件的数字一定存在。
    //思考题：
    //如果要求只使用 O(n) 的时间和额外 O(1) 的空间，该怎么做呢？
    //样例
    //输入：[1,1,1,2,2,2,3,4,4,4]
    //输出：3
    //解：二进制每位相加，每位依次 % 3，有余数说明那一个数的该位为 1。
    public int findNumberAppearingOnce(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] bitSum = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                if ((nums[i] & bitMask) != 0)
                    bitSum[j] += 1;
                bitMask = bitMask << 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // 因为从高位开始，因此每次需要左移
            res = res << 1;
            res += bitSum[i] % 3;
        }
        return res;
    }
}

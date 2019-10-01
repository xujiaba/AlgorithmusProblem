package ArrayProblem;

public class MaximumSwap_670 {

    // LeetCode 670 最大交换  头条真题
    //https://leetcode-cn.com/problems/maximum-swap/
    // 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
    //示例 1 :
    //输入: 2736
    //输出: 7236
    //解释: 交换数字2和数字7。
    //给定数字的范围是 [0, 10^8]

    //我们将计算 last[d] = i，最后一次出现的数字 d（如果存在）的索引 i。
    //然后，从左到右扫描数字时，如果将来有较大的数字，我们将用最大的数字交换；如果有多个这样的数字，我们将用最开始遇到的数字交换。

    public int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray();
        int[] last = new int[10];

        for (int i = 0; i < arr.length; i++) {
            last[arr[i] - '0'] = i;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int d = 9; d > arr[i] - '0'; d--) {
                if (last[d] > i) {
                    swap(arr, i, last[d]);
                    return Integer.parseInt(new String(arr));
                }
            }
        }
        return num;
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

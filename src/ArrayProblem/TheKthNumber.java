package ArrayProblem;

import java.util.ArrayList;

public class TheKthNumber {
    // 剑指offer 数组中最小的k个数
    // 牛客链接 https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=11182&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || k > input.length)
            return res;
        int[] p = partition(input, 0, input.length - 1);
        while (k - 1 < p[0] || k - 1 > p[1]) {
            if (k - 1 < p[0]) {
                p = partition(input, 0, p[0] - 1);
            }
            if (k - 1 > p[1]) {
                p = partition(input, p[1] + 1, input.length - 1);
            }
        }
        if (k - 1 >= p[0] && k - 1 <= p[1]) {
            for (int i = 0; i < k; i++) {
                res.add(input[i]);
            }
        }
        return res;
    }

    private int[] partition(int[] arr, int L, int R) {
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

package ArrayProblem;

public class SortArrayByParityII_922 {
    // LeetCode 922 按奇偶排序数组II
    //给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
    //对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
    //你可以返回任何满足上述条件的数组作为答案。

    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length < 2) {
            return A;
        }
        partition(A, 0, A.length - 1);
        return A;
    }

    private void partition(int[] arr, int L, int R) {
        int even = L;
        int odd = R;
        int index = L;
        while (index < arr.length && even < R && odd > L) {
            if (arr[index] % 2 == 0) {
                swap(arr, even, index);
                if (index >= even) { // 需要考虑到even 跑到了index前面的情况
                    index++;
                }
                even += 2;
            } else {
                swap(arr, odd, index);
                odd -= 2;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

package ArrayProblem;

public class SortArrayByParity_905 {
    // LeetCode 905 按奇偶排序数组
    //给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
    //
    //你可以返回满足此条件的任何数组作为答案。


    // 实际上是一个partition过程，只不过跟快排里面的条件不一样，这一类问题可一抽象为 0 1问题
    // 如果在时间复杂度O（n） 空间复杂度O(1)的情况下，还要求数组中的元素还按照原来的顺序的话
    // 实际上问题就变成了实现快排的稳定性，01 stable sort， emmm。。。 介绍完之后可以要求面试官解答
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length < 2) {
            return A;
        }
        partition(A, 0, A.length - 1);
        return A;
    }

    private void partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R + 1;
        while (L < more) {
            if (arr[L] % 2 == 0) {
                swap(arr, ++less, L++);
            } else {
                swap(arr, --more, L);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

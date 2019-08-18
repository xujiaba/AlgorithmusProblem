package ArrayProblem;

public class CanThreePartsEqualsSum {

    //LeetCode 1013 将数组分成和相等的三个部分
//    给定一个整数数组 A，只有我们可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
//
//      形式上，如果我们可以找出索引 i+1 < j 且满足 
//      (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。

    public boolean canThreePartsEqualSum(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        int key = sum / 3;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            key -= arr[i];
            if (key == 0) {
                temp++;
                key = sum / 3;
            }
        }
        if (temp == 3) {
            return true;
        } else {
            return false;
        }
    }

}

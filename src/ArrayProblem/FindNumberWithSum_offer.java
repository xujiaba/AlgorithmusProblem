package ArrayProblem;

import java.util.ArrayList;

public class FindNumberWithSum_offer {

    //和为S的两个数字
    //输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
    //https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length < 2) {
            return res;
        }
        int left = 0, right = array.length-1;
        int min = Integer.MAX_VALUE;
        while (left < right) {
            int tmp = array[left] + array[right];
            if (tmp < sum) {
                left++;
            } else if (tmp > sum) {
                right--;
            } else {
                if (min > array[left] * array[right]) {
                    min = array[left] * array[right];
                    res.clear();
                    res.add(array[left]);
                    res.add(array[right]);
                }
                left++;
            }
        }
        return res;
    }
}

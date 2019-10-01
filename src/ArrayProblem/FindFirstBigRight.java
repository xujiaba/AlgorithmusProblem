package ArrayProblem;

import java.util.Stack;

public class FindFirstBigRight {
    // 找出数组中每个数右边第一个比它大的元素
    //  1、暴力遍历
    //我们很容易想到复杂度为O(n^2)的解法，遍历数组中的每一个后面所有元素，找到第一个大于它的，输出即可。
    public int[] findMaxRight(int[] array) {
        if (array == null) {
            return array;
        }
        int size = array.length;
        int[] result = new int[size];
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (array[j] > array[i]) {
                    result[i] = array[j];
                    break;
                }
            }
        }
        result[size - 1] = -1;//最后一个元素右边没有元素，所以肯定为-1
        return result;
    }
//    // 2.借助栈，时间复杂度O(n)
//    步骤如下：
//     （1）初始化栈，里面为第一个元素索引0值；
//     （2）遍历到下一个元素A[i]
//           1) 如果栈不为空且当前遍历的元素值A[i]大于栈顶的元素值A[stack.peek()]，说明当前元素正好是栈顶元素右边第一个比它大的元素，
//           将栈顶元素弹出，result[stack.pop()]=A[i]继续遍历的元素值A[i]是否大于新栈顶元素值A[stack.peek()]，
//           如果大于，说明A[i]也是比A[stack.peek()]右边第一个比它大的元素，将栈顶元素弹出，result[stack.pop()]=A[i]，
//           一直循环，直到不满足条件1），即栈顶为空或是当前遍历的元素值小于栈顶元素索引处的值。
//           2) 如果栈为空，说明前面的元素都找到了比它右边大的元素，则直接将当前元素的索引放入栈中；
//           3）如果当前遍历的元素值A[i]小于栈顶元素索引的值A[stack.peek()]，说明还未找到栈顶元素中右边第一个比它大的元素，
//           直接将当前遍历的元素的索引入栈即可stack.push(i); 将i++，重复步骤（2）
//      （3）直到遍历完所有元素，如果栈不为空，说明栈中保存的全是未找到右边第一个比它大的数组索引，我们依次将这些栈元素出栈，
//           并赋值result[stack.pop()]=-1即可。

    public int[] findMaxRightWithStack(int[] arr) {
        if (arr == null) {
            return arr;
        }
        int size = arr.length;
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int index = 1;
        while (index < size) {
            if (!stack.isEmpty() && arr[index] > arr[stack.peek()]) {
                result[stack.pop()] = arr[index];
            } else {
                stack.push(index);
                index++;
            }
        }
        if (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }
}

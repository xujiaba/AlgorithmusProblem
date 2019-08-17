import java.util.Stack;


public class ArrayProblem {



    // 找出数组中每个数右边第一个比它大的元素
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

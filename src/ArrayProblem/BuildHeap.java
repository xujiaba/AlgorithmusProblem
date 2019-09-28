package ArrayProblem;

public class BuildHeap {

    // 给定一个数组，调整该数组，使其满足堆的性质(初始化建堆)
    public int[] buildHeap(int[] arr) {
        if (arr == null || arr.length < 2)
            return arr;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        return arr;
    }
    private void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

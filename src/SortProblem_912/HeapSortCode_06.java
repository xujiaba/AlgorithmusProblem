package SortProblem_912;


import java.util.Arrays;

public class HeapSortCode_06 {

    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i); // 0 - i 把数组变成一个大根堆
        }
        int heapSize = nums.length;
        swap(nums, 0, --heapSize); // 将堆顶与堆的最后一个元素进行交换，并且将堆的长度-1；
        while (heapSize > 0) {
            heapify(nums, 0, heapSize); // 重新进行堆的调整
            swap(nums, 0, --heapSize);    // 再次将堆顶与堆的最后一个元素进行交换，并将堆的长度-1
        }

        return nums;
    }

    private static void heapInsert(int[] nums, int index) {
        while (nums[index] > nums[(index - 1) / 2]) {
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 堆结构的调整
    private static void heapify(int[] nums, int index, int size) {
        int left = index * 2 + 1; // 左孩子的下标
        while (left < size) {
            // 判断左右还在谁是最大的，注意右孩子不能越界
            int largest = left + 1 < size && nums[left + 1] > nums[left] ? left + 1 : left;
            //判断子节点与父节点的大小
            largest = nums[largest] > nums[index] ? largest : index;
            // 如果父节点比较大，直接返回
            if (largest == index) {
                break;
            }
            swap(nums, largest, index);
            index = largest;
            left = index * 2 + 1;
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            sortArray(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        sortArray(arr);
        printArray(arr);
    }
}

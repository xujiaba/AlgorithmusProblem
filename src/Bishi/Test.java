package Bishi;


import java.util.Arrays;
import java.util.HashMap;

import static StringProblem.StringAllPermutation.swap;

public class Test {


    public static void main(String[] args) {
        getMin(76421, 3);
    }

    public static void getMin(int num, int n) {
        String str = num + "";
        char[] arr = str.toCharArray();
        System.out.println(arr);
        char[] arr2 = arr.clone();
        Arrays.sort(arr2);
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < n; i++) {
            swap(arr, map.get(arr2[i]), i);
        }
        System.out.println(arr);
    }

}

package Bishi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(test(arr, N));

    }

    public static int test(int[] arr, int len) {
        if (arr == null || len < 1)
            return 0;
        int reLen = 1, div = 1;
        int maxLen = 0;
        for (int i = 1; i < len; i++) {
            if (arr[i] - arr[i - 1] == div) {
                reLen = reLen + 1;
            } else {
                reLen = 2;
            }
            div = arr[i] - arr[i - 1];
            if (maxLen <= reLen) {
                maxLen = reLen;

            }
        }
        return maxLen;
    }


}
package Bishi;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        getMax(arr, N, M);
    }

    private static void getMax(int[] arr, int n, int m) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }
        max = sum;
        for (int i = m; i < n; i++) {
            sum -= arr[i - m];
            sum += arr[i];
            max = Math.max(max, sum);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(max / (float) m));
    }

}
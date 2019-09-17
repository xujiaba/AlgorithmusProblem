package Bishi;


import java.math.BigInteger;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        if (N > 0 && M > 0) {
            int[] array = new int[N];
            for (int i = 1; i <= M; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                if (l < 0 || r > N || l > r) {
                    continue;
                } else {
                    change(array, l, r, i);
                }
            }

            BigInteger sum = new BigInteger("0");
            for (int i = 0; i < N; i++) {
                BigInteger cur = new BigInteger(String.valueOf(i * array[i]));
                sum = sum.add(cur);
            }
            System.out.println(sum.mod(new BigInteger(String.valueOf(100000009))));
        } else {
            System.out.println(0);
        }

    }

    public static void change(int[] arr, int left, int right, int num) {
        if (left <= right) {
            for (int i = left; i <= right; i++) {
                arr[i] = num;
            }
        }
    }
}

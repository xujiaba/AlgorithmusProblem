package Bishi;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();
        int[] weight = new int[N];
        int[] value = new int[N];
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            value[i] = N - i;
            nums[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }

        test3(m,N,weight,value,nums);
    }

    public static void test3(int V, int N, int[] weight, int[] value, int[] nums) {
        int[][] dp = new int[N + 1][V + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int maxV = Math.min(nums[i - 1], j / weight[i - 1]);
                    for (int k = 0; k < maxV + 1; k++) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k * weight[i - 1]] + k * value[i - 1]);
                    }
                }
            }
        }
        int maxValue = dp[N][V];
        int j = V;
        int count = 0;
        for (int i =N; i>0;i--){
            while (dp[i][j] > dp[i-1][j]){
                count++;
                j = j-weight[i-1];
            }
            if (j == 0)
                break;
        }
        System.out.println(count);
    }


//    public static void test(int volume, int N, int[] weight, int[] value) {
//        int[] dp = new int[volume + 1];
//        for (int i = 1; i < N + 1; i++) {
//            for (int j = volume; j >= weight[i - 1]; j--) {
//                dp[j] = Math.max(dp[j - weight[i - 1]] + value[i - 1], dp[j]);
//            }
//        }
//        System.out.println(dp[volume]);
//    }
}


//        int[][] dp = new int[N + 1][volume + 1];
//        for (int i = 1; i < N + 1; i++) {
//            for (int j = 1; j < volume + 1; j++) {
//                if (weight[i - 1] > j) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
//                }
//            }
//        }
//        int k = volume;
//        int maxUse = 0;
//        for (int i = N; i > 0; i--) {
//            if (dp[i][k] > dp[i - 1][k]) {
//                maxUse++;
//                k = k - weight[i - 1];
//            }
//            if (k == 0) {
//                break;
//            }
//        }
//        return maxUse;
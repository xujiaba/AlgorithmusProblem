package Bishi;

import java.util.ArrayList;
import java.util.Scanner;

/*
* 有n件物品和容量为m的背包 给出i件物品的重量以及价值 求解让装入背包的物品重量不超过背包容量 且价值最大
特点  但它的特点是每个物品只能选用一次
* */


public class Situation01 {

    //01背包
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//物品的总数量
        int m = scanner.nextInt();//背包的重量
        int weight[] = new int[50001];//重量
        int values[] = new int[50001];//价值
        for (int i = 1; i <= n; i++) {
            weight[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }
        int f[] = new int[50001];
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= weight[i]; j--) { //完全背包只修改了这一句的顺序，其余不变for(int j=a[i]; j<=m; j++)
                if (f[j - weight[i]] + values[i] > f[j]) {
                    f[j] = f[j - weight[i]] + values[i]; //多重背包就是在a[i]和b[i]前面加了数量
                }
            }
        }
        System.out.println(f[m]);
    }

    public static void DFS(int[] water, int[] cost, int start, int curIndex, int remain, ArrayList<Integer> visited) {

    }
}

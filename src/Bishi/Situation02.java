package Bishi;

import java.util.Scanner;

/*
* 有n件物品和容量为m的背包 给出i件物品的重量以及价值 求解让装入背包的物品重量不超过背包容量 且价值最大
特点 题干看似与01一样 但它的特点是每个物品可以无限选用
* */
public class Situation02 {
    //完全背包
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //物品的数量
        int m = scanner.nextInt();  //背包的重量
        int weight[] = new int[50001];   //重量
        int values[] = new int[50001];   //价值
        for (int i = 1; i <= n; i++) {
            weight[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }
        int f[] = new int[50001];
        for (int i = 1; i <= n; i++) {
            for (int j = weight[i]; j <= m; j++) {//完全背包只修改了这一句的顺序，其余不变for(int j=a[i]; j<=m; j++)
                if (f[j - weight[i]] + values[i] > f[j])
                    f[j] = f[j - weight[i]] + values[i];
            }
        }
        System.out.println(f[m]);
    }
}
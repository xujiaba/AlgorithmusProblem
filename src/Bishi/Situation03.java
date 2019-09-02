package Bishi;

import java.util.Scanner;

import static sun.swing.MenuItemLayoutHelper.max;

public class Situation03 {
    /*
     * 多重背包
     * 每件物品可以选择有限的次数
     * */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();//背包的重量
        int n = scanner.nextInt();//物品的总数量
        int[] a = new int[10001];//重量
        int[] b = new int[10001];//价值
        int[] c = new int[10001];//数量
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
            c[i] = scanner.nextInt();
        }
        int f[] = new int[10001];
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k <= c[i]; k++) {
                    if (j - k * a[i] < 0) break;
                    f[j] = max(f[j], f[j - k * a[i]] + k * b[i]);
                }
            }
        }
        System.out.println(f[m]);
    }
}

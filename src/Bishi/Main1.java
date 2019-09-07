package Bishi;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        s1 = s1.substring(1, s1.length() - 1);
        s2 = s2.substring(1, s2.length() - 1);
        String[] c1 = s1.split(",");
        String[] c2 = s2.split(",");
        int[] water = new int[c1.length];
        int[] cost = new int[c2.length];
        for (int i = 0; i < water.length; i++) {
            water[i] = Integer.parseInt(c1[i]);
        }
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Integer.parseInt(c2[i]);
        }
        test(water, cost);
    }

    public static void test(int[] water, int[] cost) {
        int totalWater = 0;
        int curWater = 0;
        int start = 0;
        for (int i = 0; i < water.length; i++) {
            curWater += (water[i] - cost[i]);
            totalWater += (water[i] - cost[i]);
            if (curWater < 0) {
                start = i + 1;
                curWater = 0;
            }
        }
        System.out.println(totalWater >= 0 ? start : -1);
    }

}

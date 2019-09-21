package Bishi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int left = sc.nextInt();
//        int right = sc.nextInt();
//        int k = sc.nextInt();
//
//        test(left, right, k);
        String s = "   I   LOVE    YOU .    ";
        String[] strings = s.trim().split(" ");
        for (String string : strings) {
            System.out.println(string + "   " + string.length());
        }
//        System.out.println((int)Math.sqrt(2));
    }

    public static void test(int left, int right, int k) {
        if (k > right) {
            System.out.println(0);
            return;
        }
        int num = 0;
        if (k == 2) {
            for (int i = left; i <= right; i++) {
                if (i % k == 0) {
                    num++;
                }
            }
        } else {
            for (int i = left; i <= right; i++) {
                if (i % k == 0) {
                    for (int j = 2; j < k; j++) {
                        if (i % j != 0) {
                            num++;
                        }
                    }
                }
            }
        }
        System.out.println(num);
    }


}
package Bishi;

import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] result = new String[T];
        int n, k;
        for (int i = 0; i < T; i++) {
            n = sc.nextInt();
            k = sc.nextInt();
            result[i] = test(n, k);
        }
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static String test(int n, int k) {
        int tmp;
        if (n == 1) {
            return (k - 1) + "";
        }
        if (n % 2 == 0) {
            tmp = (int) Math.pow(10, n / 2 - 1);
            tmp += k - 1;
            StringBuilder str = new StringBuilder(tmp + "");
            String res = str.toString() + str.reverse().toString();
            return res;
        } else {
            tmp = (int) Math.pow(10, n / 2);
            tmp += k - 1;
            StringBuilder str = new StringBuilder(tmp + "");
            String res = str.toString() + str.reverse().substring(1).toString();
            return res;
        }
    }

}

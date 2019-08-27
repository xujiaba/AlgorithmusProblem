package Bishi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String str2 = sc.nextLine();

        test(str2.toCharArray(), len, k);


    }

    public static void test(char[] s, int len, int k) {
        int dp = 0;
        int i = 1;
        while (i < len) {
            if (s[dp] == s[i]) {
                dp++;
            } else {
                dp = 0;
            }
            i++;
        }

        if (dp == len - 1) {
            char[] result = new char[len + k];
            System.arraycopy(s, 0, result, 0, len);
            int offset = 0;
            for (i = 0; i < k - 1; i++) {
                result[len + offset] = s[0];
                offset++;
            }
            System.out.println(result);
        } else {
            char[] result = new char[k * len - (k - 1) * dp];
            System.arraycopy(s, 0, result, 0, len);
            int offset = 0;
            for (i = 0; i < k - 1; i++) {
                System.arraycopy(s, dp, result, len + offset, len - dp);
                offset += (len - dp);
            }
            System.out.println(result);

        }
    }

}

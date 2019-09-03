package StringProblem;

public class AddStrings_415 {
    // 字符串相加 LeetCode 415
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        int s1 = num1.length() - 1;
        int s2 = num2.length() - 1;
        int ca = 0, n = 0, n1 = 0, n2 = 0;
        StringBuilder res = new StringBuilder();
        while (s1 >= 0 || s2 >= 0) {
            n1 = s1 >= 0 ? num1.charAt(s1--) - '0' : 0;
            n2 = s2 >= 0 ? num2.charAt(s2--) - '0' : 0;
            n = n1 + n2 + ca;
            res.append(n % 10);
            ca = n / 10;
        }
        if (ca > 0) {
            res.append(ca);
        }
        return res.reverse().toString();
    }
}

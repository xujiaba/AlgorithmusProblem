package StringProblem;

public class LeftRotateString_offer {
    //左旋转字符串
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || n < 1) {
            return str;
        }
        while (n > str.length()) {
            n = n - str.length();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(n));
        sb.append(str, 0, n);
        return sb.toString();
    }
}

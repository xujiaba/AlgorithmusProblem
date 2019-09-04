package StringProblem;

public class StringToInt_offer {
    //将字符串转换成一个整数
    //将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
    // 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
    //输入描述:
    //输入一个字符串,包括数字字母符号,可以为空
    //输出描述:
    //如果是合法的数值表达则返回该数字，否则返回0
    //https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e?tpId=13&tqId=11202&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking


    public static int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean flag = true;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-' && i == 0) {
                flag = false;
            } else if (str.charAt(i) == '+' && i == 0) {
                flag = true;
            } else {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    return 0;
                } else {
                    res = res * 10 + (str.charAt(i) - '0');
                }
            }
        }
        return flag ? res : -res;
    }

    public static void main(String[] args) {
        String s = "+123";
        System.out.println(s);
        int i = StrToInt(s);
        System.out.println(i);
    }
}

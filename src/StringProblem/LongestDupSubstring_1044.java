package StringProblem;

import java.util.Arrays;
import java.util.HashSet;

public class LongestDupSubstring_1044 {

    //最长重复子串：给出一个字符串S，返回其最长重复子串
    // 方法 后缀数组法
    //后缀数组法：将字符串所有的后缀字符串存放在一个数组里，然后进行排序，遍历数组，寻找相邻两个字符串的最长公共前缀子串即为字符串的最长重复子串。
    //以banana为例，其后缀字符串的数组为[“banana”, “anana”, “nana”, “ana”, “na”, “a”]，
    // 进行排序得[“a”, “ana”, “anana”, “banana”, “na”, “nana”]；
    // 不难看出相邻字符串的最长前缀重复子串为：“a”, “ana”, “”, “”, “na”，所以banana的最长重复子串为“ana”。
    //这里可能有个疑问，为什么通过相邻后缀字符串的最长前缀重复子串可以找到目标字符串的最长重复子串？
    // 直观点来理解，最长重复子串肯定是在两个不同的后缀字符串里，
    // 假设在A、B两个后缀字符串里，则A、B前面某一部分字符串必然是相同的，且经过排序两者必然是相邻的。
    // 简单进行证明，若最长重复子串（假设长L）在A、B两个后缀字符串里，但是排序后AB不相邻，则AB中间的字符串C必有A[0:L-1]=B[0:L-1]=C[0:L-1]，
    // 不可能有A[L]=C[L]，否则和最长长度为L矛盾，则依然有相邻的A、C包含最长重复子串。
    // 字符长很长的时候，存放后缀字符串的数组会很大，占内存很多。
    //————————————————
    //版权声明：本文为CSDN博主「老孙的博客」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
    //原文链接：https://blog.csdn.net/qq_34826261/article/details/97319790

    public String longestDupSubstring2(String S) {
        int len = S.length();
        int maxLen = 0;
        String res = "";
        if (len < 2)
            return res;
        String[] strs = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = S.substring(i);
        }
        Arrays.sort(strs);
        for (int i = 0; i < len - 1; i++) {
            int tmpLen = lenTwoStr(strs[i], strs[i + 1]);
            if (tmpLen > maxLen) {
                maxLen = tmpLen;
                res = strs[i].substring(0, maxLen);
            }
        }
        return res;
    }

    private int lenTwoStr(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        int i = 0;
        while (i < str1.length() && i < str2.length() && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }
        return i;
    }

}

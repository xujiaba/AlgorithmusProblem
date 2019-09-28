package StringProblem;

public class LongerSubWithoutDup {
    //47.最长不含重复字符的子字符串
    //请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
    //假设字符串中只包含从’a’到’z’的字符。
    //样例
    //输入："abcabc"
    //输出：3
    //解：动态规划，用f(i)表示以i个字符结尾不包含重复子字符串的最长长度，从左向右扫描
    //      1、若第i个字符在之前没出现过，则 f(i) = f(i-1) + 1;
    //      2、若第i个字符在之前出现过，
    //计算第i个字符距离上次出现之间的距离为d
    //      (a)若d <= f(i-1)，则说明第i个字符上次出现在f(i-1)对应的不重复字符串之内，那么这时候更新 f(i) = d
    //      (b)若d > f(i-1)，则无影响,f(i) = f(i-1) + 1

    public int longestSubstringWithoutDuplication(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int distance = 0, maxlen = 0;
        int[] position = new int[26];
        for (int i = 0; i < 26; ++i)
            position[i] = -1;

        for (int i = 0; i < s.length(); ++i) {
            int preIndex = position[s.charAt(i) - 'a'];
            if (preIndex < 0 || i - preIndex > distance)  //没出现过，或者d > f(i-1)
                distance++;
            else {                    //出现过了
                if (distance > maxlen)
                    maxlen = distance;
                distance = i - preIndex;    // f(i) = d;
            }
            position[s.charAt(i) - 'a'] = i;
        }
        if (distance > maxlen)
            maxlen = distance;
        return maxlen;
    }
}

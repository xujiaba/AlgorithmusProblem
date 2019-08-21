package StringProblem;

public class MaxUnique_3 {

    // LeetCode 3 字符串中最长无重复子串的长度
    // 1.因为是字符串，每一个字母都是char,因此建立一个256的数组(每个位置的初始值为-1)，来记录每一个字母上一次出现位置
    public int maxUnique(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        char[] chars = str.toCharArray();
        int maxLen = 0;
        int pre = -1;
        int curLen = 0;
        for (int i = 0; i < chars.length; i++) {
            pre = Math.max(pre, map[chars[i]]); // 最大的即为最近出现的位置
            curLen = i - pre;
            maxLen = Math.max(maxLen, curLen);
            map[chars[i]] = i;
        }
        return maxLen;
    }
}

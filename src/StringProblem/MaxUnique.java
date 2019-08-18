package StringProblem;

public class MaxUnique {

    // 字符串中最长无重复子串的长度
    public int maxUnique(String str){
        if (str ==null || str.length() == 0){
            return 0;
        }
        int[] map = new int[256];
        for (int i = 0; i < 256;i++){
            map[i] = -1;
        }
        char[] chars = str.toCharArray();
        int maxLen = 0;
        int pre = -1;
        int curLen = 0;
        for (int i =0; i < chars.length; i++){
            pre = Math.max(pre, map[chars[i]]);
            curLen = i - pre;
            maxLen = Math.max(maxLen, curLen);
            map[chars[i]] = i;
        }
        return maxLen;
    }
}

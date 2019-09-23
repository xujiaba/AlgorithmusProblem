package ByteDance;

public class PalindromicSubstrings_647 {

    // 回文子串  647
    //给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
    //具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
    //示例 1:
    //输入: "abc"
    //输出: 3
    //解释: 三个回文子串: "a", "b", "c".
    //示例 2:
    //输入: "aaa"
    //输出: 6
    //说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/palindromic-substrings
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            //以当前点i位置，向两边扩展,以i i+1位置向两边扩展
            res += countProcess(s, i, i);
            res += countProcess(s, i, i + 1);
        }
        return res;
    }

    private int countProcess(String s, int start, int end) {
        int count = 0;
        //start往左边跑，end往右边跑，注意边界
        while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) {
            count++;
        }
        return count;
    }

}

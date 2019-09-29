package StringProblem;

import java.util.Stack;

public class DecodeString_394 {
    //    LeetCode 394 字符串解码
    //    给定一个经过编码的字符串，返回它解码后的字符串。
    //
    //    编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
    //    你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
    //    此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
    //    示例:
    //    s = "3[a]2[bc]", 返回 "aaabcbc".
    //    s = "3[a2[c]]", 返回 "accaccacc".
    //    s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".


    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return "";
        int times = 0;
        Stack<Integer> stackTimes = new Stack<>();
        Stack<String> stackStrs = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stackTimes.push(times);
                stackStrs.push(res.toString());
                times = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int curTimes = stackTimes.pop();
                for (int i = 0; i < curTimes; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stackStrs.pop() + tmp);
            } else if (Character.isDigit(c)) {
                times = times * 10 + (c - '0');
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}

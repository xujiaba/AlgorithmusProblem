package StringProblem;

public class StringCompress_443 {
    //压缩字符串
    //给定一组字符，使用原地算法将其压缩。
    //压缩后的长度必须始终小于或等于原数组长度。
    //数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
    //在完成原地修改输入数组后，返回数组的新长度。
    //进阶：
    //你能否仅使用O(1) 空间解决问题？
    //示例 1：
    //输入：
    //["a","a","b","b","c","c","c"]
    //输出：
    //返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
    //说明：
    //"aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。

    //我们使用两个指针 read 和 write 分别标记读和写的位置。
    // 读写操作均从左到右进行：读入连续的一串字符，然后将压缩版写到数组中。最终，write 将指向输出答案的结尾。
    //
    //算法
    //保留指针 anchor，指向当前读到连续字符串的起始位置。
    //从左到右进行读取。当读到最后一个字符，或者下一个下一个字符与当前不同时，则到达连续区块的结尾。
    //当我们到达连续区块的结尾时，就从 write 写入压缩的结果。chars[anchor] 为字符，read - anchor + 1 （若大于 1）为长度。
    //链接：https://leetcode-cn.com/problems/string-compression/solution/ya-suo-zi-fu-chuan-by-leetcode/

    public int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }    // 多余的元素还没有修改   如a2b2c3c
//        System.out.println(String.valueOf(chars).substring(0,write));
        return write;
    }

}

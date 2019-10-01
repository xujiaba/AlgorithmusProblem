package ArrayProblem;

import java.util.HashSet;

public class InterSectionTwoArraysJiaoji_349 {

    // 两个数组的交集 349
    //给定两个数组，编写一个函数来计算它们的交集。
    //示例 1:
    //输入: nums1 = [1,2,2,1], nums2 = [2,2]
    //输出: [2]
    //示例 2:
    //输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    //输出: [9,4]
    //说明:
    //输出结果中的每个元素一定是唯一的。
    //我们可以不考虑输出结果的顺序。
    //链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        for (int i : nums1) {
            s1.add(i);
        }
        for (int i : nums2) {
            s2.add(i);
        }

        s1.retainAll(s2);
        int[] res = new int[s1.size()];
        int index = 0;
        for (Integer integer : s1) {
            res[index++] = integer;
        }
        return res;
    }


}

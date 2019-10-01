package ArrayProblem;

import java.util.ArrayList;

public class SumEqualsS_offer {
    //和为S的连续正数序列
    // 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
    //https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11194&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (sum < 3) {
            return res;
        }
        ArrayList<Integer> tmp = new ArrayList<>();
        int mid = sum >> 1;
        int low = 1;
        int high = 2;
        int cur = low + high;
        while (low <= mid) {
            if (cur == sum) {
                for (int i = low; i <= high; i++) {
                    tmp.add(i);
                }
                res.add(new ArrayList<>(tmp));
                tmp.clear();
            }
            while (cur > sum && low <= mid) {
                cur -= low;
                low++;
                if (cur == sum) {
                    for (int i = low; i <= high; i++) {
                        tmp.add(i);
                    }
                    res.add(new ArrayList<>(tmp));
                    tmp.clear();
                }
            }
            high++;
            cur += high;
        }
        return res;
    }
}

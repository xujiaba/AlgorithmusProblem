package ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2_40 {

    // 组合总和   找出给定数组里所有和为target两个数的组合，数字不能重用
    // 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //candidates 中的每个数字在每个组合中只能使用一次。
    //说明：
    //所有数字（包括目标数）都是正整数。
    //解集不能包含重复的组合。 
    //示例 1:
    //输入: candidates = [10,1,2,7,6,1,5], target = 8,
    //所求解集为:
    //[
    //  [1, 7],
    //  [1, 2, 5],
    //  [2, 6],
    //  [1, 1, 6]
    //]
    //示例 2:
    //输入: candidates = [2,5,2,1,2], target = 5,
    //所求解集为:
    //[
    //  [1,2,2],
    //  [5]
    //]
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/combination-sum-ii
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return lists;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        process(0, candidates, target, list);
        return lists;
    }

    private void process(int start, int[] candidates, int target, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            list.clear();
        } else {
            for (int i = start; i < candidates.length; i++) {
                //因为这个数和上个数相同，所以从这个数开始的所有情况，在上个数里面都考虑过了，需要跳过
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                process(i + 1, candidates, target - candidates[i], list);
            }
        }

    }

}

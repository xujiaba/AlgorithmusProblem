package ByteDance;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {

    //给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //
    //candidates 中的数字可以无限制重复被选取。
    //
    //说明：
    //
    //所有数字（包括 target）都是正整数。
    //解集不能包含重复的组合。 
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/combination-sum
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    //https://leetcode-cn.com/circle/article/GV6eQ2/    递归回溯的一些套路


    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return lists;
        }

        List<Integer> list = new ArrayList<>();
        process(0, candidates, target, list);
        return lists;
    }

    private void process(int start, int[] candidates, int target, List<Integer> list) {
        //递归的终止条件
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                //因为每个数字都可以使用无数次，所以递归还可以从当前元素开始
                process(i, candidates, target - candidates[i], list);
                //这就是导致 list 数字一直变多的原因。
                // 因此，在每次递归完成，我们要进行一次回溯。把最新加的那个数删除。此时代码结构变成这样。
                list.remove(list.size() - 1);
            }
        }

    }

}

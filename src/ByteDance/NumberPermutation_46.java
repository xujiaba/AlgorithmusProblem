package ByteDance;

import java.util.ArrayList;
import java.util.List;

public class NumberPermutation_46 {
    //给定一个没有重复数字的序列，返回其所有可能的全排列。
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums != null || nums.length > 1) {
            process(nums, 0, res);
        }
        return res;
    }

    public void process(int[] nums, int start, List<List<Integer>> res) {
        //判断递归出口，当start == len - 1时，也就是要做的全排列只有一个值 ，那么就可以输出了
        if (start == nums.length -1) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            res.add(tmp);
        } else {
            /*
             * 没有到递归出口时，这一段代码是关键
             * for循环模拟的是：
             * { r1, perm(p1) } + { r2, perm(p2) } + {r3, perm(p3) } + …… + {rn, perm(pn) }
             * 从r1, r2, r3 一直到 rn 作为第一位，求剩下的全排列
             */
            for (int j = start; j < nums.length; j++) {
                swap(nums, start, j);  //通过交换，依次将每个数放在第一位
                process(nums, start + 1, res); //递归调用
                swap(nums, start, j);   //交换回来，保证原数组不会变，以进行下一轮全排列
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}

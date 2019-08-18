package StringProblem;

import java.util.ArrayList;
import java.util.Collections;

public class StringAllPermutation {
    public ArrayList<String> permutation(String str) {
        ArrayList<String> ans = new ArrayList<>();//所有排列的可能都在这里
        if (str != null || str.length() > 0) {
            permutationProcess(ans, str.toCharArray(), 0);
            Collections.sort(ans);
        }
        return ans;
    }

    public static void permutationProcess(ArrayList<String> ans, char[] chars, int index) {
        if (index == chars.length - 1) {
            String val = String.valueOf(chars);
            if (!ans.contains(val)) {
                ans.add(val);
            }
        } else {
            for (int j = index; j < chars.length; j++) {
                swap(chars, index, j);//依次选一个数固定住
                permutationProcess(ans, chars, index + 1);//让后面的进行全排列
                swap(chars, index, j);//恢复原来的模样，回溯关键
            }
        }

    }

    public static void swap(char[] cha, int i, int j) {
        char temp = cha[i];
        cha[i] = cha[j];
        cha[j] = temp;
    }

}

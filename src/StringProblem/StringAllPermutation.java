package StringProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StringAllPermutation {
    // 字符串全排列，可能有重复的
    public static ArrayList<String> permutation(String str) {
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

    public static void process(String s){
        String[] s1 = s.trim().split(",");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length; i++){
            sb.append(s1[i]);
        }
        String str = sb.toString();
        ArrayList<String> res = permutation(str);
        int index = res.indexOf(str);
        char[] chars = new char[str.length()];
        if (index == -1) {
            System.out.println("");
        } else if (index == res.size() - 1) {
            chars = res.get(0).toCharArray();
            System.out.println(res.get(0));
        } else {
            chars = res.get(index+1).toCharArray();
        }
        for (int i = 0; i <chars.length-1;i++){
            System.out.print(chars[i]+",");
        }
        System.out.print(chars[chars.length-1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            process(s);
        }

    }

}

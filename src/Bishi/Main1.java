package Bishi;

import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            next(s);
        }

    }

    static ArrayList<String> list = new ArrayList<>();

    private static void fullPerm(String str, int i) {
        if (i == str.length()) {
            list.add(str);
            return;
        } else {
            for (int j = i; j < str.length(); j++) {
                str = swap(str, i, j);
                fullPerm(str, i + 1);
                str = swap(str, i, j);
            }
            return;
        }
    }

    private static String swap(String str, int i, int j) {
        char[] s = str.toCharArray();
        char tmp = s[i];
        s[i] = s[j];
        s[j] =tmp;
        return String.valueOf(s);

    }

    private static void next(String s) {
        String[] s1 = s.trim().split(",");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length; i++){
            sb.append(s1[i]);
        }
        String str = sb.toString();
        fullPerm(str, 0);
        Collections.sort(list);
        int index = list.indexOf(str);
        char[] chars = new char[str.length()];
        if (index == -1) {
            System.out.println("");
        } else if (index == list.size() - 1) {
            chars = list.get(0).toCharArray();
            System.out.println(list.get(0));
        } else {
            chars = list.get(index+1).toCharArray();
        }
        for (int i = 0; i <chars.length-1;i++){
            System.out.print(chars[i]+",");
        }
        System.out.print(chars[chars.length-1]);

    }


}

package Bishi;

import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        letterCom(string);
        System.out.println(output);
    }

    private static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    private static List<String> output = new ArrayList<>();

    public static void backTrack(String comb, String next) {
        if (next.length() == 0) {
            output.add(comb);
        } else {
            String digit = next.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backTrack(comb + letter, next.substring(1));
            }
        }
    }

    public static List<String> letterCom(String digits) {
        if (digits.length() != 0) {
            backTrack("", digits);
        }
        return output;
    }

}
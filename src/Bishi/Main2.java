package Bishi;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

    }

    public static void reBase(String str) {
        if (str == null || str.length() == 0) {
            System.out.println("");
        }
        String pattern = "^,[0-9a-zA-z]+;$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        if (m.find()) {
            System.out.println();
        }

    }
}

package Bishi;

import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(test(str.trim()));
    }

    public static String test(String IP) {
        if (IP == null || IP.length() <= 0)
            return "Neither";
        if (isIPV4(IP))
            return "IPV4";
        if (isIPV6(IP))
            return "IPV6";
        return "Neither";
    }

    private static boolean isIPV4(String IP) {
        if (IP.startsWith(":") || IP.startsWith(".") || IP.endsWith(":") || IP.endsWith(".")) {
            return false;
        }
        String[] splitted = IP.split("\\.");
        if (splitted.length != 4)
            return false;
        for (String val : splitted) {
            if ("".equals(val) || val.length() > 3 || (val.length() > 1 && val.startsWith("0")))
                return false;
            for (int i = 0; i < val.length(); i++) {
                if (!(val.charAt(i) >= '0' && val.charAt(i) <= '9'))
                    return false;
            }
            if (Integer.parseInt(val) > 255)
                return false;
        }
        return true;
    }

    private static boolean isIPV6(String IP) {
        if (IP.startsWith(":") || IP.startsWith(".") || IP.endsWith(":") || IP.endsWith(".")) {
            return false;
        }
        String[] splitted = IP.split(":");
        if (splitted.length != 8)
            return false;
        for (String val : splitted) {
            if (val.length() <= 0 || val.length() >4){
                return false;
            }
            for (int i =0; i < val.length(); i++){
                char c = val.charAt(i);
                if (c < '0' || (c > '9' && c < 'a') || c > 'f')
                    return false;
            }
        }
        return true;
    }
}
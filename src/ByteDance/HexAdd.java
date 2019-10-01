package ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HexAdd {

    static Character[] chars = {'0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'};
    static List<Character> list = Arrays.asList(chars);

    public static String hexAdd(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int i = s1.length - 1;
        int j = s2.length - 1;
        int ca = 0;
        int sum = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 && j >= 0) {
            char index1 = s1[i];
            char index2 = s2[j];
            int c1 = list.get(index1);
            int c2 = list.get(index2);
            sum = c1 + c2 + ca;
            res.append(list.get(sum % 36));
            ca = sum / 36;
            i--;
            j--;
        }
        while (i >= 0) {
            sum = list.get(s1[i]) + ca;
            res.append(list.get(sum % 36));
            ca = sum / 36;
            i--;
        }
        while (j >= 0) {
            sum = list.get(s2[j]) + ca;
            res.append(list.get(sum % 36));
            ca = sum / 36;
            j--;
        }
        if (ca != 0) {
            res.append('1');
        }
        return res.reverse().toString();
    }


}

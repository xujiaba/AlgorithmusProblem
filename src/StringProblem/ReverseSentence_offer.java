package StringProblem;

public class ReverseSentence_offer {
    //字符串反转

    public String ReverseSentence(String str) {
        String[] s = str.split(" ");
        if (s.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            sb.append(s[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

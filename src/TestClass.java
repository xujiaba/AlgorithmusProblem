import StringProblem.StringAllPermutation;

import java.util.ArrayList;

public class TestClass {
    public static void main(String[] args) {
        String str = "abca";
        ArrayList<String> permutation = StringAllPermutation.permutation(str);
        System.out.println(permutation.toString());

    }
}

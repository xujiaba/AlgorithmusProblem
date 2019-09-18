package Bishi;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


class Node {
    public int a, b;

    public Node(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            nodes[i] = new Node(a, b);
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.b > o2.b) {
                    return -1;
                } else if (o1.b < o2.b) {
                    return 1;
                } else {
                    if (o1.a < o2.a) {
                        return -1;
                    } else if (o1.a > o2.a) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        int count = n;
        int sum = 0;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            count--;
            sum += nodes[i].a;
            ans += nodes[i].b;
            if (count <= sum) {
                break;
            }
        }
        System.out.println(ans);
    }


}

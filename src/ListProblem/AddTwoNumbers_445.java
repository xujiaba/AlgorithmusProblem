package ListProblem;

import java.util.Stack;

public class AddTwoNumbers_445 {
    // 两数相加   LeetCode 445
//    给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
//    你可以假设除了数字 0 之外，这两个数字都不会以零开头。
//    进阶:
//    如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
//    示例:
//    输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//    输出: 7 -> 8 -> 0 -> 7

    // 1. 可以反转链表的情况
    public ListNode addTwoNumbersWithReverse(ListNode l1, ListNode l2) {
        int ca = 0, n = 0, n1 = 0, n2 = 0;
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode c1 = l1, c2 = l2, pre = null, node = null;
        while (c1 != null || c2 != null) {
            n1 = c1 != null ? c1.val : 0;
            n2 = c2 != null ? c2.val : 0;
            n = n1 + n2 + ca;
            pre = node;
            node = new ListNode(n % 10);
            node.next = pre;
            ca = n / 10;
            c1 = c1 != null ? c1.next : null;
            c2 = c2 != null ? c2.next : null;
        }
        if (ca > 0) {
            pre = node;
            node = new ListNode(ca);
            node.next = pre;
        }
        reverseList(l1);
        reverseList(l2);
        return node;
    }

    // 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //2. 进阶 不允许使用反转链表的情况 利用两个栈分别存储当前值
    public ListNode addTwoNumbersWithoutReverse(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int ca = 0, n = 0, n1 = 0, n2 = 0;
        ListNode node = null, pre = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            pre = node;
            node = new ListNode(n % 10);
            node.next = pre;
            ca = n / 10;
        }
        if (ca > 0) {
            pre = node;
            node = new ListNode(ca);
            node.next = pre;
        }
        return node;
    }
}

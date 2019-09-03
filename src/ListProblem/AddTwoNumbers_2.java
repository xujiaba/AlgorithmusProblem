package ListProblem;

public class AddTwoNumbers_2 {
    // 两数相加   LeetCode 2
//    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//    示例：
//
//    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//    输出：7 -> 0 -> 8
//    原因：342 + 465 = 807

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode cur = preHead;
        int ca = 0, n1 = 0, n2 = 0, n = 0;
        while (c1 != null || c2 != null) {
            n1 = c1 != null ? c1.val : 0;
            n2 = c2 != null ? c2.val : 0;
            n = n1 + n2 + ca;
            cur.next = new ListNode(n % 10);
            cur = cur.next;
            ca = n / 10;
            c1 = c1 != null ? c1.next : null;
            c2 = c2 != null ? c2.next : null;
        }
        if (ca > 0) {
            cur.next = new ListNode(ca);
        }
        return preHead.next;
    }


}

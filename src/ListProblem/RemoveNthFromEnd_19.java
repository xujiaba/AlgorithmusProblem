package ListProblem;

public class RemoveNthFromEnd_19 {
    // 双指针方法   在双指针基础上添加一个前驱节点
    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        if (head == null || n < 1)
            return head;
        ListNode preNode = new ListNode(-1); // 防止头指针被删除的情况
        preNode.next = head;
        ListNode fast = preNode;
        // 快指针先走n+1步，相当于
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        ListNode slow = preNode;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return preNode.next;
    }

    // 左神的方法
    // 1.完整的遍历一次链表，同时每次遍历的时候都将n--;
    // 2.根据n的值分情况讨论，1）当 n > 0 时，说明n大于链表长度，不需要进行任何操作
    //                      2) 当 n = 0 时，说明该删除的节点为head,将head.next赋值给head 即可
    //                      3）当 n < 0 时，从头开始遍历链表，每次遍历时n++,当 n = 0时，该节点为需要删除节点的前一个节点，
    //                          将该节点的next变为该节点的next.next 即可
    // 3. 最后返回头结点head即可
    //
    public ListNode removeNthFromEnd_2(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode cur = head;
        while (cur != null) {
            n--;
            cur = cur.next;
        }
        if (n == 0) {
            head = head.next;
        }
        if (n < 0) {
            cur = head;
            while (++n != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}

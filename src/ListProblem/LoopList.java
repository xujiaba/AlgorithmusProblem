package ListProblem;

public class LoopList {

    // 找到环形链表环的入口节点
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            // 先判断有没有环
            slow = slow.next;
            fast = fast.next.next;
            // 找到环的入口节点
            if (slow == fast) {
                slow = pHead;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;    // 在这里返回
            }
        }
        return null;
    }
}

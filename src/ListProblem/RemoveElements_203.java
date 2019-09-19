package ListProblem;

public class RemoveElements_203 {
    //删除链表中等于给定值 val 的所有节点。
    //
    //示例:
    //
    //输入: 1->2->6->3->4->5->6, val = 6
    //输出: 1->2->3->4->5
    // https://leetcode-cn.com/problems/remove-linked-list-elements/
    public ListNode removeElements(ListNode head, int val) {
        while (head != null) {
            if (head.val != val)
                break;
            head = head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}

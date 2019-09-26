package ByteDance;

import ListProblem.ListNode;

import java.util.List;

public class ReverseList_206 {

    //反转一个单链表。
    //示例:
    //输入: 1->2->3->4->5->NULL
    //输出: 5->4->3->2->1->NULL
    //进阶:
    //你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/reverse-linked-list
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

    // 递归版本
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}

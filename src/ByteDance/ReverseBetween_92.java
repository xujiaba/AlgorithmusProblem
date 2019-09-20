package ByteDance;

import ListProblem.ListNode;

public class ReverseBetween_92 {

    //反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
    //
    //说明:
    //1 ≤ m ≤ n ≤ 链表长度。
    //
    //示例:
    //
    //输入: 1->2->3->4->5->NULL, m = 2, n = 4
    //输出: 1->4->3->2->5->NULL
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    // 时间复杂度 O(n)

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 1.空链表直接返回
        if (head == null) {
            return null;
        }
        // 2.找到需要反转的区间的第一个元素，以及他的前一个元素记为 cur 和 pre
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }
        // 3.标记这两个元素记为con 和 cur，并将后面需要反转的部分进行反转
        ListNode con = prev, tail = cur;
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }
        // 3.判断记录的需要反转的部分的前一个节点是否为空，为空则将该pre节点赋值给头节点
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        tail.next = cur;
        return head;
    }
}

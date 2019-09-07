package ListProblem;

public class ListNodePartition_86 {
    // LeetCode 86
    // 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
    //
    //你应当保留两个分区中每个节点的初始相对位置。

    // 1. 使用Node数组 然后针对数组进行partition操作， 分为小于区、等于区、大于区，每个区间内部无序
    // 时间复杂度 O(n) 空间复杂度 O(n)
    public ListNode listPartition1(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        ListNode[] nodes = new ListNode[i];
        cur = head;
        for (i = 0; i < nodes.length; i++) {
            nodes[i] = cur;
            cur = cur.next;
        }
        partition(nodes, x);
        for (i = 1; i < nodes.length; i++) {
            nodes[i - 1].next = nodes[i];
        }
        nodes[i - 1].next = null;
        return nodes[0];
    }

    private void partition(ListNode[] nodes, int target) {
        int less = -1;
        int more = nodes.length;
        int index = 0;
        while (index < more) {
            if (nodes[index].val < target) {
                swap(nodes, ++less, index++);
            } else if (nodes[index].val > target) {
                swap(nodes, --more, index);
            } else {
                index++;
            }
        }
    }

    private void swap(ListNode[] nodes, int i, int j) {
        ListNode tmp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = tmp;
    }

    // 分为 small equal big 三个部分，每个部分包括头尾节点，最终将三个部分进行连接即可
    public ListNode listPartition2(ListNode head, int x) {
        ListNode sH = null;
        ListNode sT = null;
        ListNode eH = null;
        ListNode eT = null;
        ListNode bH = null;
        ListNode bT = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < x) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.val == x) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }

}

package ListProblem;

public class FindFirstCommonNode_160 {
    // 输入两个链表，找出它们的第一个公共结点。
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        int lenA = 0;
        int lenB = 0;
        ListNode curA = pHead1;
        ListNode curB = pHead2;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        int diff = lenA - lenB;
        curA = pHead1;
        curB = pHead2;
        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                curA = curA.next;
            }
            while (curA != curB){
                curA = curA.next;
                curB = curB.next;
            }
        } else {
            diff = -diff;
            for (int i = 0; i < diff; i++) {
                curB = curB.next;
            }
            while (curA != curB){
                curA = curA.next;
                curB = curB.next;
            }
        }
        return curA;
    }



    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        int diff = lenA - lenB;
        curA = headA;
        curB = headB;
        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                curA = curA.next;
            }
            while (curA != curB){
                curA = curA.next;
                curB = curB.next;
            }
        } else {
            diff = -diff;
            for (int i = 0; i < diff; i++) {
                curB = curB.next;
            }
            while (curA != curB){
                curA = curA.next;
                curB = curB.next;
            }
        }
        return curA;
    }

}

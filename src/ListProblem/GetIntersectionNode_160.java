package ListProblem;

import ListProblem.ListNode;

public class GetIntersectionNode_160 {
    // 160 相交链表
    // 两个链表的公共点
    //编写一个程序，找到两个单链表相交的起始节点。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lenA = 0, lenB = 0;
        ListNode curA = headA, curB = headB;
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
            for (int i = 0; i < diff; i++){
                curA = curA.next;
            }
            while (curA != curB){
                curA = curA.next;
                curB = curB.next;
            }
        } else {
            for (int i = 0; i < -diff; i++){
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

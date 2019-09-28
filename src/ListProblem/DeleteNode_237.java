package ListProblem;

import ListProblem.ListNode;

public class DeleteNode_237 {
    //请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
    // 在不考虑尾节点的情况下，时间复杂度为O(1)
    // https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
    public void deleteNode(ListNode node) {
        if(node == null){
            return;
        }
        if (node.next != null){
            ListNode next = node.next;
            node.val = next.val;
            node.next = next.next;

            next.next = null;
        }
    }
}

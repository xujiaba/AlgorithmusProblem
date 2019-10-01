package ByteDance;


import java.util.HashMap;

class ListNode {
    int val;
    ListNode next, random;

    ListNode(int x) {
        this.val = x;
    }
}

public class CopyRandomList_138 {

    // 复制带随机指针的链表   138
    //给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
    //
    //要求返回这个链表的深拷贝。
    //利用哈希表，两次遍历原链表，时间复杂度O(n^2)
    public ListNode copyRandomList(ListNode head) {
        HashMap<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();
        ListNode node = head;
        while(node !=null) {
            map.put(node, new ListNode(node.val));
            node = node.next;
        }
        node = head;
        while(node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

}

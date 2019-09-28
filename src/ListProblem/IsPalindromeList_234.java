package ListProblem;

import ListProblem.ListNode;

public class IsPalindromeList_234 {

    // 234 回文链表
    //请判断一个链表是否为回文链表。
    //示例 1:
    //输入: 1->2  输出: false
    //示例 2:
    //输入: 1->2->2->1  输出: true
    //进阶：
    //你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/palindrome-linked-list
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        //1.快慢指针找到链表的中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //2.翻转链表前半部分
        ListNode pre = null;
        ListNode next = null;
        while (head != slow) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        // 如果链表的长度为奇数，去掉后半部分的第一个节点
        if (fast != null)
            slow = slow.next;
        //3.回文校验 此时 pre 是左半部分的第一个节点
        while (pre != null) {
            if (slow.val != pre.val)
                return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}

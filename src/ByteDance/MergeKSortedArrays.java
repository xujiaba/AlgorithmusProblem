package ByteDance;

import ListProblem.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    //合并 k 个排序数组，返回合并后的排序链表。请分析和描述算法的复杂度。
    //示例:
    //输入:
    //[
    //  1->4->5,
    //  1->3->4,
    //  2->6
    //]
    //输出: 1->1->2->3->4->4->5->6
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    /**
     * 方法 1：暴力 10 ms
     * * * 遍历所有链表，将所有节点的值放到一个数组中。
     * * * 将这个数组排序，然后遍历所有元素得到正确顺序的值。
     * * * 用遍历得到的值，创建一个新的有序链表。
     * 复杂度分析:
     * * 时间复杂度：O(NlogN) ，其中 N 是节点的总数目。
     * * * 遍历所有的值需花费 O(N)的时间。
     * * * 一个稳定的排序算法花费 O(NlogN) 的时间。
     * * * 遍历同时创建新的有序链表花费 O(N)的时间。
     * * 空间复杂度：O(N)。
     * * * 排序花费 O(N)空间（这取决于你选择的算法）。
     * * * 创建一个新的链表花费 O(N)的空间。
     **/
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        List<Integer> arrayList = new ArrayList<Integer>();
        for (ListNode list : lists) {
            while (list != null) {
                arrayList.add(list.val);
                list = list.next;
            }
        }
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrayList.get(i);
        }
        Arrays.sort(arr);
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return pre.next;
    }

    /**
     * 方法 2：利用优先级队列（最小堆） 6 ms
     * 算法
     * 时间复杂度：O(Nlogk) ，其中 k 是链表的数目。
     * * 弹出操作时，比较操作的代价会被优化到 O(logk) 。同时，找到最小值节点的时间开销仅仅为 O(1)。
     * * 最后的链表中总共有 N个节点。
     * 空间复杂度：
     * * O(n) 。创造一个新的链表需要 O(n)的开销。
     * * O(k) 。以上代码采用了重复利用原有节点，所以只要 O(1)的空间。同时优先队列（通常用堆实现）需要 O(k)的空间（远比大多数情况的 N要小）。
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node.val);
                node = node.next;
            }
        }
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (!queue.isEmpty()) {
            cur.next = new ListNode(queue.poll());
            cur = cur.next;
        }
        return pre.next;
    }

    /**
     * 方法 3：逐一两两合并链表   210 ms
     * 将合并 k 个链表的问题转化成合并 2 个链表 k-1 次
     * 复杂度分析:
     * 时间复杂度： O(kN) ，其中 k 是链表的数目。
     * * 我们可以在 O(n)的时间内合并两个有序链表，其中 n 是两个链表的总长度。
     * * 把所有合并过程所需的时间加起来，我们可以得到： O(∑i=1 k−1 (i∗(k/N) + k/N))=O(kN) 。
     * 空间复杂度：O(1)
     * * 我们可以在 O(1)空间内合并两个有序链表。
     */

    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = null;
        for (int i = 0; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    /**
     * 方法 4：分治 6 ms
     * 想法 & 算法
     * 这个方法沿用了上面的解法，但是进行了较大的优化。我们不需要对大部分节点重复遍历多次。
     * * 将 k个链表配对并将同一对中的链表合并。
     * * 第一轮合并以后，k 个链表被合并成了2/k个链表，平均长度为 2N/k ，然后是4/k个链表，8/k个链表等等。
     * * 重复这一过程，直到我们得到了最终的有序链表。
     * * 因此，我们在每一次配对合并的过程中都会遍历几乎全部 N 个节点，并重复这一过程 log K 次。
     * <p>
     * 复杂度分析
     * * 时间复杂度： O(Nlogk) ，其中 k 是链表的数目。
     * * * 我们可以在 O(n) 的时间内合并两个有序链表，其中 n 是两个链表中的总节点数。
     * * * 将所有的合并进程加起来，我们可以得到：O(∑i=1 logk N) = O (Nlogk) 。
     * * 空间复杂度：O(1)
     * * * 我们可以用 O(1)O(1) 的空间实现两个有序链表的合并。
     */

    public ListNode mergeKLists4(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int len = lists.length;
        int interval = 1;
        while (interval < len) {
            for (int i = 0; i + interval < len; i += 2 * interval) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return len != 0 ? lists[0] : null;
    }

}

package leetcode.链表;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ysj
 * @date 2021/9/7
 * @desc 23. 合并K个升序链表
 */
public class MergeKLists_23 {

    public ListNode mergeLists1(ListNode[] lists) {
        ListNode ans = null;

        for (int i = 0; i < lists.length; i++) {
            ans = merge2Lists(ans, lists[i]);
        }
        return ans;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dump = new ListNode(-1);
        ListNode p = dump;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            p = p.next;
        }
        return dump.next;
    }

    public ListNode merge2Lists(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null || listNode2 == null) {
            return listNode2 == null ? listNode1 : listNode2;
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val <= listNode2.val) {
                tail.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                tail.next = listNode2;
                listNode2 = listNode2.next;
            }
            tail = tail.next;
        }
        // 合并结束的直接放这里
        tail.next = listNode1 != null ? listNode1 : listNode2;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(5, null);
        ListNode b = new ListNode(4, null);
        ListNode r = new ListNode(7, null);
        ListNode f = new ListNode(8, null);
        ListNode c = new ListNode(3, a);
        ListNode d = new ListNode(2, b);
        ListNode e = new ListNode(1, c);
        ListNode h = new ListNode(6, r);
        ListNode m = new ListNode(7, f);
//        MergeKLists.merge2Lists(d, e);
    }
}

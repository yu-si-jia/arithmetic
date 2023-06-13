package leetcode.link;

/**
 * @author ysj
 * @date 2023/5/15
 * @desc 92. 反转链表 II
 */
public class 翻转两个链表中间位置_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, start = dummy;
        int n = right - left + 1;
        while (start.next != null && left-- > 0) {
            pre = start;
            start = start.next;
        }
        pre.next = reverseN(start, n);
        return dummy.next;
    }

    ListNode successor = null;

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode lastNode = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return lastNode;
    }


    public static void main(String[] args) {
        翻转两个链表中间位置_92 test = new 翻转两个链表中间位置_92();
        ListNode a = new ListNode(5, null);
        ListNode b = new ListNode(4, a);
        ListNode c = new ListNode(3, b);
        ListNode d = new ListNode(2, c);
        ListNode e = new ListNode(1, d);
        test.reverseBetween(e, 2, 4);
    }
}

package leetcode.链表;

/**
 * @author ysj
 * @date 2021/12/3
 * @desc 25. K 个一组翻转链表
 */
public class K个一组翻转链表_25 {


    public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            } else {
                b = b.next;
            }
        }
        ListNode newNode = reverseBetween(a, b);
        a.next = reverseKGroup1(b, k);
        return newNode;


    }

    public ListNode reverseBetween(ListNode a, ListNode b) {
        ListNode prev = null;
        ListNode curr = a;
        while (curr != b) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}

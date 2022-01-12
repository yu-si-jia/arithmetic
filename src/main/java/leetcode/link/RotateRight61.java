package leetcode.link;

/**
 * @author ysj
 * @date 2022/1/11
 * @desc 61. 旋转链表 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class RotateRight61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head.next == null || head == null || k == 0) return head;

        int length = 0;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        int num = length - (k%length);

        if (k%length == 0)  return head;

        ListNode p = head;
        for (int i = 0; i < num-1; i++) {
            p = p.next;
        }

        ListNode newHead = p.next;

        p.next = null;
        curr.next = head;
        return newHead;
    }
}

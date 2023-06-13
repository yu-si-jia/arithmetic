package leetcode.链表;

/**
 * @author ysj
 * @date 2022/1/11
 * @desc 61. 旋转链表 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class RotateRight61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head.next == null || k == 0) return head;

        int length = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        if (k % length == 0) return head;

        // 找到P为新的尾节点
        // 取模的操作为，如果移动的长度等于链表长度则为不移动，len=5 k = 2 则相当于移动两次 新节点是第3个位置 k=7同理
        int num = length - (k % length);
        ListNode p = head;
        // 指针的下一个，所以i<num-1, 新的尾结点=next
        for (int i = 0; i < num-1 ; i++) {
            p = p.next;
        }

        ListNode newHead = p.next;
        p.next = null;
        curr.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(new RotateRight61().rotateRight(node1,2));
    }
}

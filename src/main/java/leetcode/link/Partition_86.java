package leetcode.link;

/**
 * @author ysj
 * @date 2023/4/2
 * @desc 86. 分隔链表
 */
public class Partition_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dump1 = new ListNode(-1);
        ListNode dump2 = new ListNode(-1);
        ListNode p1 = dump1;
        ListNode p2 = dump2;

        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dump2.next;
        return dump1.next;
    }

}


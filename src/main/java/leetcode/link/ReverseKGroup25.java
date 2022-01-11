package leetcode.link;

/**
 * @author ysj
 * @date 2021/12/3
 * @desc 25. K 个一组翻转链表
 */
public class ReverseKGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            //pre 到 tail 为要翻转的节点
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            // 翻转链表 入参头结点 和尾结点 返回新的头结点和尾结点
            ListNode[] listNodes = myReverse(head, tail);
            head = listNodes[0];
            tail = listNodes[1];

            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;


        }

        return hair.next;

    }


    // 翻转链表
    private ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode curr = head;

        while (prev != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[]{tail, head};
    }
}

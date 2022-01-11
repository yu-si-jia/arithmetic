package leetcode.link;

/**
 * @author andor
 * @date 2021/6/24
 * @desc 206. 反转链表
 */
public class ReverseList206 {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode nodeTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nodeTemp;
        }
        return prev;

    }


    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }

    public static void main(String[] args) {
        ListNode a = new ListNode(5,null);
        ListNode b = new ListNode(4,a);
        ListNode c = new ListNode(3,b);
        ListNode d = new ListNode(2,c);
        ListNode e = new ListNode(1,d);

        reverseList2(e);

    }
}

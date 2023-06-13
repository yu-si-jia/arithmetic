package leetcode.link;

/**
 * @author ysj
 * @date 2023/5/15
 * @desc
 */
public class 链表中倒数第K个节点_offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode nthFromEnd = findNthFromEnd(head, k);
        return nthFromEnd;
    }


    ListNode findNthFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i< k ; i++){
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 !=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}

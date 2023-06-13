package leetcode.链表;


/**
 * @author andor
 * @date 2021/7/8
 * @desc 面试题 02.07. 链表相交
 */
public class GetIntersectionNode0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a!=b){
            a = a!=null?a.next: headB;
            b = b!=null?b.next: headA;

        }
        return a;

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }
}

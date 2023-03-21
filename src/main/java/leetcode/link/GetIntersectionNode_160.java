package leetcode.link;

/**
 * @author HeJiageng
 * @date 2023/3/21
 * @desc 160. 相交链表
 * 当A指针到A链表的尾结点的时候，让他=B链表的头结点，两个步伐一样
 * 相交就是链表交点
 */
public class GetIntersectionNode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}

package leetcode.链表;

/**
 * @author ysj
 * @date 2023/5/15
 * @desc
 */
public class 合并两个有序链表_25 {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val< l2.val){
            l1.next = mergeTwoLists1(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists1(l2.next,l1);
            return l2;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);

        ListNode preNode = preHead;
        while (l1 !=null && l2!=null){
            if (l1.val< l2.val){
                preNode.next = l1;
                l1 = l1.next;
            }else {
                preNode.next = l2;
                l2 = l2.next;
            }
            preNode = preNode.next;
        }
        preNode.next = l1==null? l2:l1;
        return preHead.next;
    }
}

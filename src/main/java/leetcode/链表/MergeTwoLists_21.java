package leetcode.链表;

/**
 * @author ysj
 * @date 2021/8/30
 * @desc 合并两个有序链表 21
 */
public class MergeTwoLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        if (l1.val< l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }

    public ListNode mergeTwoLists1(ListNode l1,ListNode l2){
        ListNode preHead = new ListNode(-1);

        ListNode prev = preHead;

        while (l1!=null &&l2!=null){
            if (l1.val< l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1==null?l2:l1;
        return preHead.next;
    }
}

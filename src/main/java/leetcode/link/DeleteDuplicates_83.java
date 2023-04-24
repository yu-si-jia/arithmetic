package leetcode.link;

/**
 * @author ysj
 * @date 2023/4/24
 * @desc 83. 删除排序链表中的重复元素
 */
public class DeleteDuplicates_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next==null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;

        while (second != null){
            if (first.val != second.val){
                first.next = second;
                first = first.next;
            }
            second = second.next;
        }
        first.next = null;
        return head;
    }
}

package leetcode.link;

/**
 * @author HeJiageng
 * @date 2023/3/20
 * @desc 141. 判断链表是否有环
 */
public class HasCycle_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}

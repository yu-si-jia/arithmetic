package leetcode.链表;

/**
 * @author ysj
 * @date 2023/6/14
 * @desc 234:回文链表
 */
public class 回文链表_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = null;
        while (slow != null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        slow = prev;

        while (head!=null){
            if (slow.val != head.val){
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
}

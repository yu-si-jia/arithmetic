package leetcode.link;

/**
 * @author HeJiageng
 * @date 2023/3/22
 * @desc 234. 回文链表
 * 找链表中间的点，快慢指针
 */
public class IsPalindrome_234 {
    public boolean isPalindrome(ListNode head) {
        if (head==null || head.next==null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow为链表中点， 从slow处反转链表
        ListNode prev = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        while (slow != null){
            if (slow.val!=head.val){
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;

    }

}

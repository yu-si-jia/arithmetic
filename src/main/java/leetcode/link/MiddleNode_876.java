package leetcode.link;

/**
 * @author ysj
 * @date 2023/4/12
 * @desc 876: 链表中间节点
 */
public class MiddleNode_876 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

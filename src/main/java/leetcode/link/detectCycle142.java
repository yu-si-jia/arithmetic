package leetcode.link;

/**
 * @author HeJiageng
 * @date 2021/8/3
 * @desc 142. 环形链表 II 找到链表入环口
 */
public class detectCycle142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode index = head;
                ListNode index2 = fast;
                while (index!=index2){
                    index = index.next;
                    index2 = index2.next;
                }
                return index;
            }
        }
        return null;

    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

package leetcode.link;

/**
 * @author andor
 * @date 2021/6/22
 * @desc 203. 移除链表元素
 */
public class RemoveElements203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head==null){
            return null;
        }
        head.next = removeElements(head.next,val);
        return head.val == val ? head: head.next;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

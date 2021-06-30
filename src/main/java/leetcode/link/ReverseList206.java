package leetcode.link;

/**
 * @author andor
 * @date 2021/6/24
 * @desc 206. 反转链表
 */
public class ReverseList206 {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode nodeTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nodeTemp;
        }
        return prev;

    }

    public static void main(String[] args) {
        ListNode a = new ListNode(5,null);
        ListNode b = new ListNode(4,a);
        ListNode c = new ListNode(3,b);
        ListNode d = new ListNode(2,c);
        ListNode e = new ListNode(1,d);

        reverseList(e);

    }


    static class ListNode {
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

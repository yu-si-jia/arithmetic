package leetcode.链表;


/**
 * @author andor
 * @date 2021/6/25
 * @desc 24. 两两交换链表中的节点
 */
public class SwapPairs24 {
    public static ListNode swapPairs(ListNode head) {

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;

        while (prev.next != null && prev.next.next != null) {
            ListNode temp = prev.next;
            ListNode temp1 = prev.next.next.next;

            prev.next = prev.next.next;
            prev.next.next = temp;
            prev.next.next.next = temp1;
            prev = prev.next.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(5,null);
        ListNode b = new ListNode(4,a);
        ListNode c = new ListNode(3,b);
        ListNode d = new ListNode(2,c);
        ListNode e = new ListNode(1,d);

        swapPairs(e);

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

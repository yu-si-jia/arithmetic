package arithstudy.middleNode;


/**
 * @author YuSiJia
 * @date 2020/3/23
 * @desc 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class Test01 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick!= null&&quick.next!=null){
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        Test01 test01 = new Test01();
        System.out.println(test01.middleNode(l1));

    }
}

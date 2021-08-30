package leetcode.link;

/**
 * @author ysj
 * @date 2021/8/9
 * @desc 2. 两数相加
 */
public class AddTwoNumbers_2 {
    //carry 记录进位
    //sum 记录余数

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static void main(String[] args) {
            ListNode a = new ListNode(5,null);
            ListNode b = new ListNode(4,a);
            ListNode c = new ListNode(3,b);

            ListNode d = new ListNode(2,null);
            ListNode e = new ListNode(1,d);
        addTwoNumbers(e,c);
        }
    }





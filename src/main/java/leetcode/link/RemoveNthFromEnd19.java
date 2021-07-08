package leetcode.link;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author andor
 * @date 2021/6/30
 * @desc 19：删除链表的倒数第N个节点
 * 1.计算链表长度，删除倒数第N个节点
 * 2.栈,先把所有节点入栈，再弹出
 * 3.双指针
 */
public class RemoveNthFromEnd19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dump;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode temp = stack.pop();
        temp.next = temp.next.next;
        return dump.next;
    }

    public static void main(String[] args) {
         ListNode a = new  ListNode(5,null);
         ListNode b = new  ListNode(4,a);
         ListNode c = new  ListNode(3,b);
         ListNode d = new  ListNode(2,c);
         ListNode e = new  ListNode(1,d);
         removeNthFromEnd(e,3);
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        int length = getNodeLength(head);
        ListNode dump = new ListNode(0, head);
        ListNode cur = dump;
        for (int i = 0; i < length - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode result = dump.next;
        return result;
    }

    private int getNodeLength(ListNode head) {
        int result = 1;
        ListNode cur = head;
        while (cur.next != null) {
            result++;
            cur = cur.next;
        }
        return result;
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

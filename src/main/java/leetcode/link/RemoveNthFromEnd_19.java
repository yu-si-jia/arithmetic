package leetcode.link;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ysj
 * @date 2023/4/11
 * @desc 19. 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }
        ListNode dump = new ListNode(-1);
        dump.next = head;
        // 要找倒数第n+1个节点，去删除， 所以要往前移动一位
        ListNode nthFromEnd = findNthFromEnd(dump, n + 1);
        nthFromEnd.next = nthFromEnd.next.next;
        return dump.next;
    }

    public ListNode findNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    /**
     * 用队列做
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dump = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dump;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0 ; i< n; i++){
            stack.pop();
        }

        ListNode pop = stack.pop();
        pop.next = pop.next.next;
        return dump.next;
    }
}

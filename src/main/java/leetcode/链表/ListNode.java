package leetcode.链表;

/**
 * @author ysj
 * @date 2021/8/30
 * @desc
 */
public  class ListNode {
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
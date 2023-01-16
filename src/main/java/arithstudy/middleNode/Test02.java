package arithstudy.middleNode;

/**
 * @author YuSiJia
 * @date 2020/3/23
 * @desc
 */
public class Test02 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode middleNode(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur!=null){
            ++n;
            cur = cur.next;
        }
        int k = 0;
        cur = head;
        while (k < n/2){
            ++k;
            cur = cur.next;
        }
        return cur;
    }
}

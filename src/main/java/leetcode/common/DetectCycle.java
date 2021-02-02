package leetcode.common;

/**
 * @author andor
 * @date 2020/10/10
 * @desc
 */


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class DetectCycle {
    Integer age;

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    Integer userID;

    public Integer getUserID() {
        return userID;
    }

    public static void main(String[] args) {
        DetectCycle detectCycle = new DetectCycle();
        detectCycle.userID=null;

        detectCycle.setAge(detectCycle.getUserID());
        System.out.println(detectCycle.getAge());
    }

}

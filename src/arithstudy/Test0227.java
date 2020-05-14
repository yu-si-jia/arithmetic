package arithstudy;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author YuSiJia
 * @date 2020/2/27
 * @desc
 */
public class Test0227 {
    /**
     * 剑指Offer 01：二维数组的查找
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        boolean fond = false;
        int row = 0;
        int col = array[0].length-1;
        while (col>=0&&row<array.length){
            int current = array[row][col];
            if (target>current){
                row++;
            }else if (target<current){
                col--;
            }else {
                fond = true;
                break;
            }
        }
        return fond;
    }

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        int num = 0;
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i)==' '){
                num++;
            }
        }

        char[] result = new char[str.length()+2*num];
        for (int i=str.length()-1; i>=0; i--){
            if (str.charAt(i)!=' '){
                result[i+num*2] = str.charAt(i);
            }else {
                num--;
                result[i+2*num] = '%';
                result[i+2*num+1] = '2';
                result[i+2*num+2] = '0';

            }
        }
        return new String(result);
    }

    class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode==null){
            return new ArrayList<>();
        }
        Stack stack = new Stack();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList result = new ArrayList();
        while (!stack.empty()){
            result.add(stack.pop());
        }
        return result;
    }
}

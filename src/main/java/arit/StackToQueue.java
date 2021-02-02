package arit;

import java.util.Stack;
/**
 * 用两个栈实现一个队列，完成两个函数appendTail和deletedHead,分别是在队列尾部插入节点
 * 和在队列头部删除节点的功能
*/
 public class StackToQueue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void appendTail(int m){
        stack1.push(m);
    }

    public Integer deletedHead() throws Exception {
        if(stack2.isEmpty()){
            //判断的重点！！！
            while(!stack1.isEmpty()){//当栈不为空时才往栈一里面插入
                stack2.push(stack1.pop());
            }
        }

        if(stack2.isEmpty()){
            throw new Exception("队列为空，不能删除");
        }
        return stack2.pop();
    }

    public static void main(String[] args) throws Exception{
        StackToQueue test  = new StackToQueue();
        test.appendTail(1);
        test.appendTail(2);
        test.appendTail(3);
        System.out.println(test.deletedHead());

    }

}

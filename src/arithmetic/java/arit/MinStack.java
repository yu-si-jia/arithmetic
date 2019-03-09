package arit;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
/**
 * 实现一个栈，可以进行push,pop 之外还可以进行getMin操作，
 * getMin方法调用之后返回当前栈的最小值
 *
 * 用辅助栈而不是Int 记录是由于可能重复添加同一个最小值
 * 在弹出后容易出错
 *
 *
 * 还有一种方式是ArrayList构建的栈
 * 可以使用索引来跟踪最小的数值
 * Stack封装的pop不能根据索引弹出 弹出的是索引并不是索引对应的数值
 */
public class MinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack(){
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int num){
        if (stackMin.empty()||num<getMin()){//如果最小值栈是空的话，将新的元素插入到最小值栈
            //如果num小于最小栈里最小的元素再添加
            //之所以是小于没有等于是因为如果弹出栈，最小栈也弹出，会出现错误
            stackMin.push(num);
        }
        stackData.push(num);
    }

    public Integer pop(){
        Integer num = stackData.pop();
        if (stackMin.peek()==num){//peek方法返回栈顶元素但是不删除
            stackMin.pop();

            //如果数据栈弹出的元素是最小栈的最小元素 那么两个栈同时弹出
        }
        return num;
    }

    public Integer getMin(){
        return stackMin.peek();
    }
}


class MinStack2{
    private List<Integer> data = new ArrayList<Integer>();
    private List<Integer> mins = new ArrayList<Integer>();

    public void push(int num){
        data.add(num);
        if (mins.size()==0){
            //初始化Mins
            mins.add(0);
        }else {
            int min = getMin();
            if (num < min){
                mins.add(data.size()-1);
            }
        }
    }

    public int pop(){
        if (data.size()==0){
            throw new EmptyStackException();
        }
        //pop时先获取索引
        int popIndex = data.size()-1;
        //获取Mins的栈顶元素，他是最小索引数值
        int minIndex = mins.get(mins.size()-1);
        //如果pop出去的是最小值的索引，mins才出站
        if (popIndex == minIndex){
            mins.remove(mins.size()-1);
        }

        return data.remove(data.size()-1);
    }

    public int getMin(){
        if (data.size()==0){
            throw new EmptyStackException();
        }
        int minIndex = mins.get(mins.size()-1);
        return data.get(minIndex);
    }
}

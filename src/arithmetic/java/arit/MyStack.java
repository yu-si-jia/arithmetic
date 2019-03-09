package arit;

public class MyStack {
    private Integer[] data;
    private int maxSize;
    private int top = 0;


    public MyStack(){
    }

    public MyStack(int maxsize){
        this.maxSize = maxsize;
        data = new Integer[maxsize];
    }

    public boolean push(Integer e){
        if(top == maxSize){
            throw new RuntimeException("栈已满，无法将元素入栈！");
        }else{
            data[top++]=e;

            return true;
        }
    }

    public Integer pop(){
        if (top == 0){
            throw new RuntimeException("栈已空");
        }
        System.out.println(top);
        return data[--top];
    }

    public Boolean empty(){
        return (top==-1)?true:false;
    }

    public int search(Integer num){
        return 0;
    }


    public static void main(String[] args) {
        MyStack myStack = new MyStack(20);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        System.out.println(myStack.pop());

    }
}

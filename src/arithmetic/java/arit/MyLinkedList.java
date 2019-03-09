package arit;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * java实现链表
 */


class MyLinkedList {
    private class Node {
        private Integer data;
        private Node next;

        public Node(Integer data) {
            this.data = data;
        }

        public Node() {
            data = null;
        }

    }


    private Node head;//表头指针
    private Node rear;//表尾指针
    private Node point;//临时指针
    private int length;//链表长度

    public MyLinkedList() {
        head = new Node();
        rear = head;
        length = 0;
    }

    /**
     * 向头节点添加数据
     *
     * @param num
     */
    public void insertFirst(Integer num) {
        Node point = new Node(num);
        point.next = head;
        head = point;
        length++;
    }

    /**
     * 添加尾部节点
     *
     * @param num
     */
    public void insertRear(Integer num) {
        Node point = new Node(num);
        rear.next = point;
        rear = point;
        length++;
    }

    /**
     * 遍历链表
     */
    public void getMyLinkedList() {
        point = head;

//        if (head != null) {
//            System.out.println(head.data);
//        }

        while (point.next != null) {
            System.out.print(point.next.data + " ");
            point = point.next;
        }
    }





    /**
     * 获得链表长度
     */
    public int getLength() {
        return length;
    }


    /**
     * 清空链表
     */
    public boolean clearMyLinkedList() {
        while (head.next != null) {
            head.next = head.next.next;
        }
        head = rear;
        if (length == 0) {
            return true;
        }
        return false;
    }


    /**
     * 在指定位置添加节点
     */

    public boolean insertIndex(int index, Integer num) {
        Node newNode = new Node(num);
        int i = 0;
        point = head;
        while (i != index) {
            point = point.next;
            i++;
        }
        newNode.next = point.next;
        point.next = newNode;
        return true;
    }

    /**
     * 删除指定位置节点
     */

    public Integer deleteIndex(int index) {
        int i = 0;
        point = head;
        while (i != index - 1) {
            point = point.next;
            i++;
        }
        Integer result = point.next.data;
        point.next = point.next.next;
        return result;
    }


    /**
     * 更改指定节点的元素
     */
    public Integer changeNode(int index, Integer num) {
        int i = 0;
        point = head;
        while (i != index - 1) {
            point = point.next;
            i++;
        }

        point.next.data = num;
        return point.next.data;
    }

}


class PrintLinkedList{
     static class Node{
        private int k;
        private Node next;

        public Node(int value,Node next) {
            this.k = value;
            this.next = next;
        }

        public Node(){}
    }
    public void printReversingLinkedList(Node head){
        Stack<Node> nodesStack = new Stack<Node>();

        while (head!=null){
            nodesStack.push(head);
            head = head.next;
        }
        while (!nodesStack.empty()){
            System.out.println(nodesStack.pop().k);
        }


    }

    public static void main(String[] args) {
        PrintLinkedList printLinkedList = new PrintLinkedList();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();

        node1.k = 1;
        node2.k = 2;
        node3.k = 3;
        node4.k = 4;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        printLinkedList.printReversingLinkedList(node1);




    }

}
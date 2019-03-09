package arit;


public class CircularLinkedList {
    private class Node {
        Node next;
        Integer value;

        public Node(Integer value) {
            this.value = value;
        }

        public Node() {
            value = null;
        }

    }


    private Node front;
    private Node rear;
    private Node point;
    private int length;

    public CircularLinkedList() {
        front = new Node();
        front.value = null;
        front.next = front;
    }

    public void insertFront(Integer value) {
        Node newNode = new Node(value);
        if (front.next == front) {
            front.next = newNode;
            newNode.next = front;
            length++;
        } else {
            newNode.next = front.next;
            front.next = newNode;
            length++;
        }
    }

    public void insertRear(Integer value) {
        Node newNode = new Node(value);
        if (front.next == front)//第一次插入元素
        {
            front.next = newNode;
            newNode.next = front;
            length++;
        } else//不是第一次插入元素
        {
            //temp引用在栈中，temp和header引用都指向堆中的initList()中new的Element对象
            point = front;
            while (point.next != front)//寻找最后一个元素
            {
                point = point.next;
            }
            point.next = newNode;
            newNode.next = front;//新插入的最后一个节点指向头结点
            length++;
        }
    }


    public void showList() {
        point = front;
        while (point.next != front) {
            System.out.print(point.next.value + "  ");
            point = point.next;
        }
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.insertRear(1);
        circularLinkedList.insertRear(2);
        circularLinkedList.insertRear(3);
        circularLinkedList.insertRear(4);
        circularLinkedList.insertRear(5);

        circularLinkedList.showList();
        System.out.println(circularLinkedList.length);
    }
}


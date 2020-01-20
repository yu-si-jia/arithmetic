package search;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.*;

public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(7,'f');
        binarySearchTree.insert(4,'a');
        binarySearchTree.insert(8,'s');
        binarySearchTree.insert(5,'d');
        binarySearchTree.insert(1,'f');
        binarySearchTree.insert(9,'g');
        binarySearchTree.insert(6,'h');
        binarySearchTree.insert(2,'j');
        binarySearchTree.insert(3,'k');

        System.out.print("前序遍历");
        binarySearchTree.preOrder();
        System.out.println();
        System.out.print("中序遍历");
        binarySearchTree.inOrder();
        System.out.println();
        System.out.print("后序遍历");
        binarySearchTree.postOrder();
        System.out.println();
        System.out.print("层序遍历");
        binarySearchTree.levelOrder();
        System.out.println();

        System.out.println(binarySearchTree.search(10));


    }



    private class Node {
        int key;
        char value;
        Node left;
        Node right;

        public Node(int key, char value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        public Node(Node node){
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }

    }

    int count;
    Node root;

    public BinarySearchTree() {
        root = null;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int key, char value) {
        root = insert(root, key, value);
    }

    public boolean contain(int key) {
        return contain(root, key);
    }

    //返回的是数值而不是键
    public char search(int key) {
        return search(root, key);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    /**
     * 层序遍历
     */
    public void levelOrder(){
        Deque<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.getFirst();//取出队首元素
            System.out.print(node.key+"  ");
            queue.pop();
            if (node.left!=null)
                queue.add(node.left);
            if (node.right!=null)
                queue.add(node.right);

        }
    }

    /**
     * 寻找二叉树的最小值
     * @return 最小值
     */

    public char minimum(){
        assert count!=0;
        Node minNode = minimum(root);
        return minNode.value;
    }


    /**
     * 寻找二叉树的最大值
     * @return 最大值的索引
     */

    public char maximum(){
        assert count!=0;
        Node maxNode = maximum(root);
        return maxNode.value;
    }

    /**
     * 删除二叉树最小值的结点
     */
    public void removeMin(){
        if (root != null){
            root = removeMin(root);
        }
    }


    /**
     * 删除二叉树最da值的结点
     */
    public void removeMax(){
        if (root != null){
            root = removeMax(root);
        }
    }

    /**
     * 从二叉树删除键为key的结点
     */
    public void remove(int key){
        root = remove(root,key);
    }


    /**
     * 对以node为根的二叉搜索树进行前序遍历
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key+"  ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 取整
     * @param key
     * @return
     */
    public int floor(int key){
        Node node = floor(root,key);
        if (node==null) return 0;

        return node.key;
    }

    /**
     * 对以node为根的二叉搜索树进行中序遍历
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key+"  ");
            inOrder(node.right);
        }
    }

    /**
     * 对以node为根的二叉搜索树进行后序遍历
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            inOrder(node.right);
            System.out.println(node.key+"  ");
        }
    }


    private Node insert(Node node, int key, char value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (key == node.key) {
            node.value = value;
        } else if (key < node.key) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }

        return node;
    }

    private boolean contain(Node node, int key) {
        if (node == null)
            return false;
        if (key == node.key) {
            return true;
        } else if (key > node.key)
            return contain(node.right, key);
        else
            return contain(node.left, key);
    }

    //以Node为跟的二叉搜索树中查找Key所对应的value
    private char search(Node node, int key) {
        if (node == null)
            new Exception("未检索到");
        if (key == node.key) {
            return node.value;
        } else if (key > node.key)
            return search(node.right, key);
        else
            return search(node.left, key);
    }

    private Node minimum(Node node){
        if (node.left==null){
            return node;
        }

        return minimum(node.left);
    }

    private Node maximum(Node node){
        if (node.right==null){
            return node;
        }

        return maximum(node.right);
    }

    /**
     * 删除以Node为羹的二分搜索树中最小的结点
     * 返回删除结点后新的二分搜索树的根
     */
    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            count--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除以Node为羹的二分搜索树中最da的结点
     * 返回删除结点后新的二分搜索树的根
     */
    private Node removeMax(Node node){
        if (node.right == null){
            Node leftNode = node.left;
            count--;
            return leftNode;
        }

        node.right = removeMin(node.right);
        return node;
    }

    private Node remove(Node node,int key){
        if (node == null)
            return null;
        if (key < node.key){
            node.left = remove(node.left,key);
            return node;
        }
        else if (key > node.key){
            node.right = remove(node.right,key);
            return node;
        }else {//key==node.key
            if (node.right == null){
                Node rightNode = node.right;
                //没有写delete结点
                count--;
                return rightNode;
            }
            if (node.left == null){
                Node leftNode = node.left;
                //没有写delete结点
                count--;
                return leftNode;
            }

            //node.left!=null&&node.right!=null
            Node deleteNode = node;
            Node succsessor = new Node(minimum(node.right));
            count++;

            succsessor.right = removeMin(node.right);
            succsessor.left = node.left;
            count--;

            return succsessor;
        }
    }

    private Node floor(Node node,int key){
        if (node == null) return null;
        if (key == node.key) return node;
        if (key < node.key){
            return floor(node.left,key);
        }

        Node t = floor(node.right,key);
        if (t!=null) return t;
        else return node;
    }

}



package arit;

import java.util.*;

public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
//
//        binarySearchTree.insert(7, 'f');
//        binarySearchTree.insert(4, 'a');
//        binarySearchTree.insert(8, 's');
//        binarySearchTree.insert(5, 'd');
//        binarySearchTree.insert(1, 'f');
//        binarySearchTree.insert(9, 'g');
//        binarySearchTree.insert(6, 'h');
//        binarySearchTree.insert(2, 'j');
//        binarySearchTree.insert(3, 'k');
//
//        System.out.println(binarySearchTree.maxDepth());
//        System.out.print("前序遍历");
//        binarySearchTree.preOrder();
//        System.out.println();
//        System.out.print("中序遍历");
//        binarySearchTree.inOrder();
//        System.out.println();
//        System.out.print("后序遍历");
//        binarySearchTree.postOrder();
//        System.out.println();
//        System.out.print("层序遍历");
//        binarySearchTree.levelOrder();
//        System.out.println();

        int[] a = {1,4,7,6,3,13,14,10,8};
        System.out.println(binarySearchTree.VerifySquenceOfBST(a));
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

        public Node(Node node) {
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

    public int maxDepth() {
        return maxDepth(root);
    }

    /**
     * 验证二叉搜索树
     * 解题思路：1.中序遍历是递增数组
     * 2.递归找左子树的最大值，右子树的最小值 判断最大值要小于跟结点，最小值要大于跟结点
     */
    public boolean isBinSearTree(String[] str, int index, int min, int max) {
        if (index >= str.length) return true;
        int val = Integer.parseInt(str[index]);
        if (val <= min || val >= max) {
            return false;
        }

        int left = 2 * index + 1;
        int right = 2 * index + 2;
        return isBinSearTree(str, left, min, val) && isBinSearTree(str, right, val, max);
    }

    /**
     * 判断数组是否是一个二叉排序树的合法后序遍历
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        return _VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean _VerifySquenceOfBST(int[] sequence, int start, int end) {
        if (end <= start) return true;
        int i = start;
        for (; i < end; i++) {
            if (sequence[i] > sequence[end]) {
                break;
            }
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }
        return _VerifySquenceOfBST(sequence, start, i - 1) && _VerifySquenceOfBST(sequence, i, end - 1);
    }


    /**
     * 找p,q的最近公共祖先结点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public Node lowestCommonAncestor1(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) return root;

        Node left = lowestCommonAncestor1(root.left, p, q);
        Node right = lowestCommonAncestor1(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;
        return root;
    }


    public Node lowestCommonAncestor2(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) return root;
        if (p.key < root.key && q.key < root.key) return lowestCommonAncestor2(root.left, p, q);
        if (p.key > root.key && q.key > root.key) return lowestCommonAncestor2(root.right, p, q);
        return root;
    }

    /**
     * 二叉树的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int minDepth(Node root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (right == 0 || left == 0) return right + left + 1;
        return Math.min(right, left) + 1;

    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        Deque<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.getFirst();//取出队首元素
            System.out.print(node.key + "  ");
            queue.pop();
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);

        }
    }

    /**
     * 寻找二叉树的最小值
     *
     * @return 最小值
     */

    public char minimum() {
        assert count != 0;
        Node minNode = minimum(root);
        return minNode.value;
    }


    /**
     * 寻找二叉树的最大值
     *
     * @return 最大值的索引
     */

    public char maximum() {
        assert count != 0;
        Node maxNode = maximum(root);
        return maxNode.value;
    }

    /**
     * 删除二叉树最小值的结点
     */
    public void removeMin() {
        if (root != null) {
            root = removeMin(root);
        }
    }


    /**
     * 删除二叉树最da值的结点
     */
    public void removeMax() {
        if (root != null) {
            root = removeMax(root);
        }
    }

    /**
     * 从二叉树删除键为key的结点
     */
    public void remove(int key) {
        root = remove(root, key);
    }


    /**
     * 对以node为根的二叉搜索树进行前序遍历
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + "  ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 取整
     *
     * @param key
     * @return
     */
    public int floor(int key) {
        Node node = floor(root, key);
        if (node == null) return 0;

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
            System.out.print(node.key + "  ");
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
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key + "  ");
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

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    /**
     * 删除以Node为羹的二分搜索树中最小的结点
     * 返回删除结点后新的二分搜索树的根
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
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
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            count--;
            return leftNode;
        }

        node.right = removeMin(node.right);
        return node;
    }

    private Node remove(Node node, int key) {
        if (node == null)
            return null;
        if (key < node.key) {
            node.left = remove(node.left, key);
            return node;
        } else if (key > node.key) {
            node.right = remove(node.right, key);
            return node;
        } else {//key==node.key
            if (node.right == null) {
                Node rightNode = node.right;
                //没有写delete结点
                count--;
                return rightNode;
            }
            if (node.left == null) {
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

    private Node floor(Node node, int key) {
        if (node == null) return null;
        if (key == node.key) return node;
        if (key < node.key) {
            return floor(node.left, key);
        }

        Node t = floor(node.right, key);
        if (t != null) return t;
        else return node;
    }

}



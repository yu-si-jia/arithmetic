package arit;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如：前序遍历序列｛ 1, 2, 4, 7, 3, 5, 6, 8｝
 * 和中序遍历序列｛4, 7, 2, 1, 5, 3, 8，6}，
 * 重建出二叉树并输出它的头结点
 */
public class BinaryTree {
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return 树的根结点
     */
    public static BinaryTreeNode construct(int[] preorder, int[] inorder) {
        // 输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 递归调用此方法，前序遍历得到跟结点，从中序遍历中找到跟结点，左右分别为左右子树
     *
     * @param preorder 前序遍历
     * @param ps       前序遍历的开始位置
     * @param pe       前序遍历的结束位置
     * @param inorder  中序遍历
     * @param is       中序遍历的开始位置
     * @param ie       中序遍历的结束位置
     * @return 树的根结点
     */
    public static BinaryTreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {

        // 开始位置大于结束位置说明已经没有需要处理的元素了
        if (ps > pe) return null;
        // 取前序遍历的第一个数字，就是当前的根结点
        int rootValue = preorder[ps];
        int rootIndex = is;
        // 在中序遍历的数组中找根结点的位置
        while (rootIndex <= ie && inorder[rootIndex] != rootValue) {
            rootIndex++;
        }
        // 如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常
        if (rootIndex > ie) {
            throw new RuntimeException("Invalid input");
        }
        // 创建当前的根结点，并且为结点赋值
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = rootValue;
        // 递归构建当前根结点的左子树，左子树的元素个数：index-is+1个
        // 左子树对应的前序遍历的位置在[ps+1, ps+index-is]
        // 左子树对应的中序遍历的位置在[is, index-1]
        node.left = construct(preorder, ps + 1, ps + rootIndex - is, inorder, is, rootIndex - 1);
        // 递归构建当前根结点的右子树，右子树的元素个数：ie-index个
        // 右子树对应的前序遍历的位置在[ps+index-is+1, pe]
        // 右子树对应的中序遍历的位置在[index+1, ie]
        node.right = construct(preorder, ps + rootIndex - is + 1, pe, inorder, rootIndex + 1, ie);
        // 返回创建的根结点
        return node;

    }

    /**
     * 给出后序和中序遍历构建二叉树
     * @param postorder
     * @param inorder
     * @return
     */
    public static BinaryTreeNode construct1(int[] postorder, int[] inorder) {
        if (postorder == null || inorder == null || postorder.length != inorder.length) {
            return null;
        }
        return construct(postorder, 0, postorder.length-1, inorder, 0, inorder.length- 1);
    }

    public static BinaryTreeNode construct1(int[] postorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe) return null;
        int rootValue = postorder[pe];
        int rootIndex = is;
        while (rootIndex <= ie && inorder[rootIndex] != rootValue) {
            rootIndex++;
        }

        if (rootIndex > ie) {
            throw new RuntimeException("Invalid input");
        }

        BinaryTreeNode node = new BinaryTreeNode();
        node.value = rootValue;
        node.left=construct(postorder,ps,ps + rootIndex - is-1, inorder, is, rootIndex - 1);
        node.right=construct(postorder,ps + rootIndex - is,pe,inorder, rootIndex + 1, ie);
        return node;
    }

    // 中序遍历二叉树
    public static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + " ");
            printTree(root.right);
        }

    }

    public List<Integer> preorderTraversal(BinaryTreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                res.add(root.value);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }


    // 普通二叉树
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    private static void test1() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 所有结点都没有右子结点
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    private static void test2() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 所有结点都没有左子结点
    //            1
    //             \
    //              2
    //               \
    //                3
    //                 \
    //                  4
    //                   \
    //                    5
    private static void test3() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 树中只有一个结点
    private static void test4() {
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 完全二叉树
    //              1
    //           /     \
    //          2       3
    //         / \     / \
    //        4   5   6   7
    private static void test5() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }

    // 输入空指针
    private static void test6() {
        construct(null, null);
    }

    // 输入的两个序列不匹配
    private static void test7() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);
    }


    public static void main(String[] args) {
        List <BinaryTreeNode> arr = new ArrayList<>();
        arr.add(1,null);


    }


    public int getTreeHeight (TreeNode root) {
        // write code here
        if(root == null){
            return 0;
        }
        return Math.max(getTreeHeight(root.left),getTreeHeight((root.right))+1);
    }

    public Some.ListNode revertLinkList (Some.ListNode root) {
        // write code here
        Stack<Some.ListNode> stack = new Stack<>();
        if (root == null){
            return null;
        }
        while (root!=null){
            stack.push(root);
            root = root.next;
        }
        if (!stack.isEmpty()){
            root = stack.pop();
        }
        Some.ListNode cur = root;
        while (!stack.isEmpty()){
            Some.ListNode node = stack.pop();
            node.next = null;
            cur.next = node;
            cur = node;
        }
        return root;
    }
}


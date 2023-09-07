package leetcode.二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ysj
 * @date 2023/9/6
 * @desc
 */
public class 中序后序构造二叉树_106 {
    static Map<Integer, Integer> inMap;

    /**
     * 中序： 【左子树】根【右子树】
     * 后序： 【左子树】【右子树】根
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;
        inMap = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inLen - 1, postorder, 0, postLen - 1);

    }


    public static TreeNode buildTree(int[] inorder, int inLeft, int inRight, int[] postOrder, int postLeft, int postRight) {
        if (postRight < postLeft) {
            return null;
        }

        int rootVale = postOrder[postRight];
        int inOrderRootIndex = inMap.get(rootVale);

        TreeNode root = new TreeNode(rootVale);


        root.left = buildTree(inorder, inLeft, inOrderRootIndex - 1, postOrder, postLeft, postLeft + inOrderRootIndex - inLeft - 1);
        root.right = buildTree(inorder, inOrderRootIndex + 1, inRight, postOrder, postLeft + inOrderRootIndex - inLeft , postRight-1);
        return root;
    }

    public static void main(String[] args) {
        int[] inOrder = {9, 3, 15, 20, 7};
        int[] postOrder = {9, 15, 7, 20, 3};
        中序后序构造二叉树_106.buildTree(inOrder, postOrder);
    }

}

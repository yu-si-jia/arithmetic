package leetcode.二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ysj
 * @date 2023/9/5
 * @desc
 */
public class 前序中序构造二叉树_105 {

    private Map<Integer, Integer> indexMap;


    /**
     * [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
     * [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
     */

    /**
     * @param preorder       前序
     * @param inorder        中序
     * @param preorder_left  前序的子区间开始
     * @param preorder_right 前序的子区间末尾
     * @param inorder_left   中序的子区间开始
     * @param inorder_right  中序的子区间末尾
     * @return
     */
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        int preOrder_root = preorder_left;
        int inOrder_root = indexMap.get(preorder[preOrder_root]);

        TreeNode root = new TreeNode(preorder[preOrder_root]);
        int left_size = inOrder_root - inorder_left;

        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + left_size, inorder_left, inOrder_root - 1);
        root.right = myBuildTree(preorder, inorder, preorder_left + left_size + 1, preorder_right, inOrder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preLen - 1, inorder, 0, inLen - 1);

    }

    public TreeNode buildTree(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preLeft]);
        int rootIndex = indexMap.get(preOrder[preLeft]);

        //rootIndex-inleft = 左子树长度  左区间结束=左区间开始+左子树长度
        root.left = buildTree(preOrder, preLeft + 1, preLeft + rootIndex - inLeft, inOrder, inLeft,rootIndex-1);
        root.right = buildTree(preOrder, preLeft + rootIndex - inLeft + 1, preRight, inOrder, rootIndex+1, inRight);
        return root;
    }

}

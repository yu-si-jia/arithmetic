package leetcode.二叉树;

/**
 * @author HeJiageng
 * @date 2023/10/26
 * @desc
 */
public class 删除二叉搜索树中的节点_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            // BST特性，当左右两边都不为空的话，右子树的最小节点变为root节点满足左边小，右边大
            TreeNode min = getMinNode(root.right);
            // 右子树删掉一个最小值，则整体对右边进行调整
            root.right = deleteNode(root.right, min.val);
            min.right = root.right;
            min.left = root.left;
            return min;
        }
        if (root.val > key ){
            // 右子树中寻找
             root.right = deleteNode(root.right,key);
             return root;
        }
        // 左子树寻求
        root.left = deleteNode(root.left, key);
        return root;
    }



    private TreeNode getMinNode(TreeNode node) {
        while (node.left!=null){
            node = node.left;
        }
        return node;
    }
}

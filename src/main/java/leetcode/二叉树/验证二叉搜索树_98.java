package leetcode.二叉树;

/**
 * @author HeJiageng
 * @date 2023/10/25
 * @desc
 */
public class 验证二叉搜索树_98 {
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root,null,null);
    }


    public boolean isValidBST(TreeNode root,TreeNode max, TreeNode min) {
        if (root == null){
            return true;
        }

        if (min !=null && root.val < min.val){
            return false;
        }

        if (max != null && root.val > max.val){
            return false;
        }

        return isValidBST(root.left,root,min) && isValidBST(root.right, max, root);

    }



}

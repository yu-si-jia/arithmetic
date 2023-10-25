package leetcode.二叉树;

/**
 * @author HeJiageng
 * @date 2023/10/24
 * @desc
 */
public class 寻找重复的子树_652 {
    int res;
    int count;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root,k);
        return res;
    }

    void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        traverse(root.left, k);
        count++;
        if (count == k){
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}

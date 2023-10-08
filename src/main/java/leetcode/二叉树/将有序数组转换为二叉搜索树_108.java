package leetcode.二叉树;

/**
 * @author ysj
 * @date 2023/10/8
 * @desc
 */
public class 将有序数组转换为二叉搜索树_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return def(nums, 0, nums.length - 1);
    }

    TreeNode def(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootIndex = (left + right) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = def(nums, left, rootIndex - 1);
        root.right = def(nums, rootIndex + 1, right);
        return root;
    }
}

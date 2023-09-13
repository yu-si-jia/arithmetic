package leetcode.二叉树;

import java.util.*;

/**
 * @author ysj
 * @date 2023/9/13
 * @desc
 */
public class 二叉树的层序遍历_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> ans = new ArrayList<>();
            for (int i = 0 ; i< size; i++){
                TreeNode cur = q.poll();
                ans.add(cur.val);
                if (cur.left != null){
                    q.offer(cur.left);
                }
                if (cur.right != null){
                    q.offer(cur.right);
                }
            }
            result.add(ans);
        }

        return result;
    }
}

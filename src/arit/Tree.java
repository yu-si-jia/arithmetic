package arit;

import java.util.*;


class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Tree {

    private TreeNode maxNode;
    private TreeNode minNode;

    private boolean stop = false;
    private int result;

    public int getDis(TreeNode root) {
        if(root == null) {
            return 0;
        }

        maxNode = root;
        minNode = root;

        getMaxAndMin(root);
        getLength(root);
        return result;
    }

    private int[] getLength(TreeNode root) {

        if(root == null)
            return new int[] {-1, -1};
        if(root == maxNode)
            return new int[] {0, -1};
        if(root == minNode)
            return new int[] {-1, 0};

        int[] left = getLength(root.left);
        int[] right = getLength(root.right);

        int[] curResult = new int[]{Math.max(left[0], right[0]), Math.max(left[1], right[1])};

        if(curResult[0] != -1)
            curResult[0]++;
        if(curResult[1] != -1)
            curResult[1]++;

        if(!stop && curResult[0] != -1 && curResult[1] != -1) {
            result = curResult[0] + curResult[1];
            stop = true;
        }

        return curResult;
    }

    private void getMaxAndMin(TreeNode root) {

        if(root == null)
            return;
        if(root.left == null && root.right == null) {
            if(root.val < minNode.val) {
                minNode = root;
            }
            if(root.val > maxNode.val) {
                maxNode = root;
            }
        }
        getMaxAndMin(root.left);
        getMaxAndMin(root.right);

    }


}

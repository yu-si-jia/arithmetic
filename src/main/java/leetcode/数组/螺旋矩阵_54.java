package leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ysj
 * @date 2023/6/26
 * @desc
 */
public class 螺旋矩阵_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;

        int up = 0;
        int down = row - 1;
        int left = 0;
        int right = col - 1;

        while (res.size() < row * col) {
            if (up <= down) {
                for (int j = left; j <= right; j++) {
                    res.add(matrix[up][j]);
                }
                up++;
            }

            if (left <= right) {
                for (int i = up; i <= down; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }

            if (up <= down) {
                for (int j = right; j >= left; j--) {
                    res.add(matrix[down][j]);
                }
                down--;
            }

            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}

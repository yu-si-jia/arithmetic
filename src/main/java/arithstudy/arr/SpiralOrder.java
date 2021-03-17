package arithstudy.arr;

import java.util.LinkedList;
import java.util.List;

/**
 * @author andor
 * @date 2021/3/16
 * @desc 54. 螺旋矩阵
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while (left <= right && bottom <= top) {
            for (int column = left; column <= right; column++) {
                result.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    result.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
                right--;
                top++;
                bottom--;
            }


        }

        return result;

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralOrder spiralOrder = new SpiralOrder();
        spiralOrder.spiralOrder(matrix);
    }
}

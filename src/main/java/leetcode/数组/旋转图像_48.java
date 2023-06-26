package leetcode.数组;

/**
 * @author ysj
 * @date 2023/6/26
 * @desc
 */
public class 旋转图像_48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] row : matrix) {
            int i = 0, j = row.length - 1;
            while (i<j){
                int temp = row[i];
                row[i] = row[j];
                row[j] = temp;
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        旋转图像_48 test = new 旋转图像_48();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        test.rotate(matrix);
    }
}

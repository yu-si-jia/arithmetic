package leetcode.数组;

/**
 * @author ysj
 * @date 2023/6/20
 * @desc
 */
public class 二维数组区域和检索_304 {
    int[][] count;
    public 二维数组区域和检索_304(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        count = new int[m+1][n+1];
        for(int i = 1; i<= m ; i++){
            for(int j = 1; j<= n; j++){
                count[i][j] = count[i-1][j] + count[i][j-1] + matrix[i-1][j-1] - count[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return count[row2+1][col2+1] - count[row1][col2+1] - count[row2+1][col1] +  count[row1][col1];
    }
}

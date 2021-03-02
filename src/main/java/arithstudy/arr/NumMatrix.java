package arithstudy.arr;

/**
 * @author andor
 * @date 2021/3/2
 * @desc 304. 二维区域和检索 - 矩阵不可变
 */
public class NumMatrix {

    private int[][] sums ;
    public NumMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return;
        int row = matrix.length;
        int col = matrix[0].length;
        sums = new int[row][col];
        for (int i=0;i<row;i++){
            sums[i][0] = matrix[i][0];
        }
        for (int j=1;j<col;j++){
            sums[0][j] += matrix[0][j]+sums[0][j-1];
        }

        for (int i=1;i<row;i++){
            for (int j=1;j<col;j++){
                sums[i][j] = matrix[i][j]+sums[i][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i=row1;i<=row2;i++){
            if (col1==0){
                result += sums[i][col2];
            }else {
                result += sums[i][col2] - sums[i][col1 - 1];
            }
        }
        return result;
    }
}
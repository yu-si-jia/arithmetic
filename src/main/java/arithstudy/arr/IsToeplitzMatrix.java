package arithstudy.arr;

/**
 * @author andor
 * @date 2021/2/22
 * @desc 766. 托普利茨矩阵
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 *
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。

 */
public class IsToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int i = matrix.length;
        int j = matrix[0].length;

        for (int x=0; x<i-1;x++){
            for (int y=0; y<j-1;y++){
                if (matrix[x][y]!=matrix[x+1][y+1]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsToeplitzMatrix isToeplitzMatrix = new IsToeplitzMatrix();
        int[][] ma = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(isToeplitzMatrix.isToeplitzMatrix(ma));
    }
}

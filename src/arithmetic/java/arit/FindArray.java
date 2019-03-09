package arit;

public class FindArray {
    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排列
     * 每一列都按照从上到下递增的顺序排序
     * 完成一个函数，输入这样的二维数组和一个整数
     * 判断数组是否含有整数
     */
    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        int col = array[0].length;

        for(int i=0; i<rows; i++){
            for (int j=0; j<col; j++){
                if (target==array[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

    //根据有序的特性进行查找
    /*从左下角开始查找，大于左下角删除一行，小于左下角删除一列*/
    public boolean Find2(int target, int[][] array){

        for (int i= array.length-1,j=0;i>=0&&j<array[0].length;){//控制循环
            if (target==array[i][j]){
                return true;
            }else if (target>array[i][j]){
                j++;
                continue;
            }else if (target<array[i][j]){
                i--;
                continue;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Integer A = 1;
        Integer B = 2;
        Integer C = 3;
        Integer D = 3;
        Integer E = 321;
        Integer F = 321;
        Long G = 3L;
        System.out.println(C==D);//T
        System.out.println(E==F);//F
        System.out.println(C==(A+B));//T
        System.out.println(C.equals(A+B));//T
        System.out.println(G==(A+B));//T
        System.out.println(G.equals(A+B));//F equals不处理自动转型
    }

}

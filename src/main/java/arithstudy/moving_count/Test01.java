package arithstudy.moving_count;

/**
 * @author YuSiJia
 * @date 2020/4/8
 * @desc 面试题13
 *
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 */
public class Test01 {
    int counts=0;
    public int movingCount(int m, int n, int k) {
        //辅助数组 用来标记是否统计过
        int[][] visited = new int[m][n];
        //从 0,0位置开始统计
        helper(visited,0,0,m-1,n-1,k);
        return counts;
    }

    /**
     *传入i,j两点 判断当前点是否符合规则 符合规则下继续对下右两个方向递归判断
     */
    private void helper(int[][] visited,int i,int j,int m,int n,int k){
        if(i<=m&&j<=n&&visited[i][j]!=1&&(indexSum(i)+indexSum(j))<=k){
            counts++;
            visited[i][j]=1;
            helper(visited,i+1,j,m,n,k);
            helper(visited,i,j+1,m,n,k);
        }
    }

    /**
     *根据传入的数 求出各位上的数字累加和
     */
    private int indexSum(int index){
        int sum = index%10;
        int tmp = index/10;
        while(tmp>0){
            sum+=tmp%10;
            tmp/=10;
        }
        return sum;
    }

}

package leetcode;

/**
 * @author YuSiJia 892
 * @date 2020/3/25
 * @desc 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * <p>
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * <p>
 * 请你返回最终形体的表面积。
 * <p>
 * 输入：[[2]]
 * 输出：10
 * 示例 2：
 * <p>
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 * <p>
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 * <p>
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 * <p>
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 */
public class SurfaceArea_892 {
    public int surfaceArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cur = 0;
        int surface = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==0){
                    continue;
                }
                cur = 4 * grid[i][j] + 2;
                if (i > 0) {
                    cur = cur - Math.min(grid[i - 1][j], grid[i][j]) * 2;
                }
                if (j > 0) {
                    cur = cur - Math.min(grid[i][j - 1], grid[i][j]) * 2;
                }
                surface += cur;
            }
        }
        return surface;
    }
}

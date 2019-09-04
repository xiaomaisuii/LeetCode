package DynamicProgramming;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-09-04 20:10
 * @ Description: 最小路径和
 **/
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int[][] f = new int[grid.length][grid[0].length];
        f[0][0] = grid[0][0];
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 ) {
                    // 初始化
                    if (j!=0){
                        f[i][j] = grid[i][j]+f[i][j-1];
                    }
                } else if (j == 0) {
                    // 初始化
                    if (i!=0){
                        f[i][j] = grid[i][j]+f[i-1][j];
                    }
                } else {
                    int a = grid[i][j] + f[i - 1][j];
                    int b = grid[i][j] + f[i][j - 1];
                    f[i][j] = Math.min(a, b);
                }
            }
        }
        return f[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        MinPathSum minPathSum = new MinPathSum();
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        int i = minPathSum.minPathSum(grid);
        System.out.println(i);
    }
}

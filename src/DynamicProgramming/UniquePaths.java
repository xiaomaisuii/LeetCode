package DynamicProgramming;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-31 20:28
 * @ Description: 不同的路径
 **/
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 这个地方是初始化。
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                }else {
                    //利用加法原则
                    f[i][j] = f[i - 1][j] + f[i][j-1];
                }
            }
        }
        return f[m - 1][n - 1];
    }



    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        int i = uniquePaths.uniquePaths(4, 4);
        System.out.println(i);
    }
}

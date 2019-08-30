package DynamicProgramming;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-29 20:39
 * @ Description: 一段数组中的数据会不会等于一个数,会就返回true
 **/
public class SubSet {
    public boolean subSet(int[] arr, int i, int s) {
        if (s==0){
            return true;
        } else if (i == 0) {
            return arr[0] == s;
        } else if (arr[i] > s) {
            return subSet(arr, i - 1, s);
        } else {
            // 还是选和不选的问题，选那么就需要减去一个数
            boolean a = subSet(arr, i - 1, s - arr[i]);
            boolean b = subSet(arr, i - 1, s);
            return (a || b);
        }
    }

    /**
     * 用动态规划实现
     * 动态规划就是解决递归计算的重复子序列。
     * @param arr
     * @param s
     * @return
     */
    public boolean subSet1(int[] arr, int s) {
        boolean[][] subset = new boolean[arr.length][s + 1];
        for (int j = 0; j < arr.length; j++) {
            subset[j][0] = true;
        }
        for (int j = 0; j < s+1; j++) {
            subset[0][j] = false;
        }
        subset[0][arr[0]] = true;
        for (int i = 1; i < arr.length ; i++) {
            for (int j = 1; j < s+1; j++) {
                if (arr[i] > j) {
                    subset[i][j] = subset[i - 1][j];
                }else {
                    boolean a = subset[i - 1][j - arr[i]];
                    boolean b = subset[i - 1][j];
                    subset[i][j] = a || b;
                }
            }
        }
        return subset[arr.length-1][s];
    }

    public static void main(String[] args) {
        SubSet subSet = new SubSet();
        int[] arr = {1, 3, 4, 5, 6, 7, 8, 1};
        boolean b = subSet.subSet(arr, arr.length-1, 10);
        boolean b1 = subSet.subSet1(arr, 10);
        if (b1) {
            System.out.println("可以");
        }else {
            System.out.println("不可以");
        }
    }
}

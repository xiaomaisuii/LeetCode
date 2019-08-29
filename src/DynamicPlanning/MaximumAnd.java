package DynamicPlanning;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-29 20:03
 * @ Description: 求不相邻的数之和的最大值
 * 1，3，4，1，6，7，3 这一串数组不相邻的最大值。
 **/
public class MaximumAnd {
    /**
     * 用递归的思想去解决
     * @param arr
     * @param i
     * @return
     */
    public int maximumAnd(int[] arr,int i){
        if (i == 0){
            return arr[0];
        } else if (i == 1) {
            return Math.max(arr[0], arr[1]);
        } else {
            // 这快的思想就是选和不选的问题
            int a = arr[i] + maximumAnd(arr, i-2);
            int b = maximumAnd(arr, i-1);
            return Math.max(a, b);
        }
    }

    public int maximumAnd1(int[] arr){
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i <arr.length ; i++) {
            int a = opt[i - 2] + arr[i];
            int b = opt[i - 1];
            opt[i] = Math.max(a, b);
        }
        return opt[arr.length - 1];
    }


    public static void main(String[] args) {
        MaximumAnd maximumAnd = new MaximumAnd();
        int[] arr = {1, 3, 5, 7, 8, 9};
        int i = maximumAnd.maximumAnd1(arr);
        System.out.println(i);
    }
}

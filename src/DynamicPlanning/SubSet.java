package DynamicPlanning;

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

    public static void main(String[] args) {
        SubSet subSet = new SubSet();
        int[] arr = {1, 3, 4, 5, 6, 7, 8, 1};
        boolean b = subSet.subSet(arr, arr.length-1, 10);
        if (b) {
            System.out.println("可以");
        }else {
            System.out.println("不可以");
        }
    }
}

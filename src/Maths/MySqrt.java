package Maths;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-28 20:21
 * @ Description: x 的平方根
 **/
public class MySqrt {
    /**
     * 利用二分法来求
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        int ans = 0;
        while (left<right){
            int mid = left + (left + right) / 2;
            if (mid <= x / 2) {
                left = mid + 1;
                ans = mid;
            }else {
                // 执行完了mid = x/2 这个之后把right赋值为mid-1
                // ,那么left就大于了right于是循环就结束了。
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MySqrt sqrt = new MySqrt();
        int i = sqrt.mySqrt(5);
        System.out.println(i);
    }
}

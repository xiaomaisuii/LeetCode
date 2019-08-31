package DynamicProgramming;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-31 20:43
 * @ Description: 跳跃游戏
 **/
public class CanJump {
    public boolean canJump(int[] A) {
        // write your code here
        int n = A.length;
        boolean[] f = new boolean[n];
        f[0] = true;
        // 这块一定要注意，第一个值是被赋值的。
        for (int j = 1; j < n; j++) {
            f[j] = false;
            for (int i = 0; i < j; i++) {
                if (f[i] && i + A[i] >= j) {
                    f[j] = true;
                    break;
                }
            }
        }
        return f[n - 1];
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        int[] A = {2,3,1,1,4};
        boolean b = canJump.canJump(A);
        if (b) {
            System.out.println("能");
        }else {
            System.out.println("不能");
        }
    }
}

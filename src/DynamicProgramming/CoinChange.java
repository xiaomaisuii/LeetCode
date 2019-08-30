package DynamicProgramming;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-30 20:40
 * @ Description:
 **/
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // 定义数组长度
        int[] F = new int[amount + 1];
        // 初始值 初始化
        F[0] = 0;
        for (int i = 1; i < amount+1 ; ++i) {
            F[i] = Integer.MAX_VALUE;
            // 转移方程
            for (int j = 0; j < coins.length; ++j) {
                // 看判断条件
                if (i >= coins[j] && F[i - coins[j]] != Integer.MAX_VALUE) {
                    F[i] = Math.min(F[i - coins[j]] + 1, F[i]);
                }
            }
        }
        if (F[amount] == Integer.MAX_VALUE) {
            F[amount] = -1;
            return F[amount];
        }
        return F[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {2, 5, 7};
        int amount = 27;
        int i = coinChange.coinChange(coins, amount);
        System.out.println(i);
    }
}

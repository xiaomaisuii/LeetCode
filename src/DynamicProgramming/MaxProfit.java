package DynamicProgramming;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-09-02 19:41
 * @ Description: 买卖股票的最佳时机
 **/
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length<=1){
            return 0;
        }
        // 初始化，dp思想；
        // 1. 记录今天之前买入的最小值
        // 2. 计算今天卖出的最大利润
        // 3. 计算每天的利益，取最大即可。()
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }



    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = {7,1,5,3,6,4};
        int i = maxProfit.maxProfit(prices);
        System.out.println(i);
    }
}

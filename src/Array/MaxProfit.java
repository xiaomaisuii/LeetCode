package Array;

import java.util.Arrays;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-06 21:48
 * @ Description: 买卖股票的最佳时机 II
 **/
public class MaxProfit {
    /**
     *
     * @param prices
     * @return
     * 首先注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     * 其次交易是有顺序的必须按照时间天的顺序交易，比如昨天已经过去了就不能在进行交易了。
     * 看题中给的样例是分为三种 ：
     * 1. 第一种就是有增加有减少的情况。其实第二和第三种情况就是第一种情况的最优解啊，只是把一个数组分成若干个第二和第三的情况。
     * 2. 第二就就是一天比一天增加的，那么这就就直接第一天买第最后一天卖就行了，收益prices[len-1]-prices[0]。
     * 3. 第三种就是一天比一天减少的，那么就不要买卖就行了，直接收益就是元。
     * 读题分析时间为：一个番茄时间。
     * 编写代码时间为：4个番茄时间。
     * 总结：代码时间复杂度为O(n) 有点高。 并且编写代码的时间过长。
     * 思考：在分析题目的时候要考虑到分几种情况，这个应该是第一次分析的时候这样考虑，但是也要考虑一个算法就能给其解决的思想。
     */
    public int maxProfit(int[] prices) {
        //1. 首先先判断是那种情况？ 这样貌似还不知道怎么判断 ?
        // 判断一个数组是否为递增 ?
        int sum = 0;
        if (prices.length == 0){
            //判断为递增的数组 收益为 prices[len-1]-prices[0]。
            return sum;
        }else if (isUpSequence(prices)) {
            return   sum += prices[prices.length-1]-prices[0];
        }else if (isDownSequence(prices)){
            //判断为递减的数组 收益为 0
            return sum;
        }else {
            // 下面这是第一种情况。
            // 默认手里是没有股票的。
            boolean flag = true;
            for (int i = 0 ;i < prices.length ; i++){
                // 加一个判断是否循环到最后一个数组了，如果到最后一个数组，要查看手里面是否有股票没有卖出去
                // 如果股票没有卖出去，那么就卖出去就好了。
                if(i==prices.length-1){
                    if (!flag){
                        sum += prices[i];
                    }
                }else {
                    // 先判断一下 如果第一天的钱少于第二天的话就要买入第一天买了第二天。
                    // 这里要注意看一下是不是第三天，和第四天的也是呈现递增的模式咋办 ？ 比如递增到到达第n天的话
                    // 应该是prices[n]-prices[i]
                    // 在一段递增的数组之上可以按照出现第一次的增长就把低价的买下。
                    // 然后等到出现第一次数组递减的时候就把股票卖了。
                    // 这里出现一个问题，我怎么判断买完了，不能在买呢  ?  可以加上一个判断条件
                    // flag = false 为买了股票，手里有股票。 false 为卖了股票，手里没有股票
                    if (prices[i] < prices[i+1] && flag ) {
                        sum +=  - prices[i] ;
                        // 标记为买了股票，false代表手里有股票不能在买了。
                        flag = false ;
//                    i++;
                    }else if (prices[i] >= prices[i+1] && !flag) {
                        // 这块逻辑必须在上一次买了股票的时候才能卖啊 ？ 如果没有股票怎么卖啊 ?
                        sum += prices[i];
                        // 标记为卖了股票，true代表手里没有股票，可以买新的股票了。
                        flag = true;
                    }
                }

            }
            return sum;
        }

    }
    // 判断是否为递增的数组 {1，2，3，4，5}
    public static boolean isUpSequence(int[] prices) {
        for (int i = 0 ;i<prices.length-1 ; i++ ){
            if (prices[i]>=prices[i+1]){
                return false ;
            }
        }
        return true;
    }
    // 判断是否为递减的数组 {5，4，3，2，1}
    public static boolean isDownSequence(int[] prices) {
        for (int i = 0 ;i<prices.length-1 ; i++ ){
            if (prices[i]<=prices[i+1]){
                return false ;
            }
        }
        return true;
    }

    /**
     * 上面的算法思考的有些复杂，代码时间复杂度虽然没有那么大，但是编码确实很复杂，并且代码思想有点复杂，不容易理解。
     * 下面这个比较简单。只要遇到明天比今天的大的就买了今天卖了明天，但是这个是考虑到只要满足这个就进行运算所以遇到连续涨的股票
     * 的时候就连续买入卖出，就ok了，这个确实在思考的时候没有想到。
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int max=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]){
                max+=prices[i+1]-prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProfit mp = new MaxProfit();
        int[] prices = {2,1,3,6,18};
        System.out.println(mp.maxProfit(prices));
        System.out.println(mp.maxProfit2(prices));
    }
}

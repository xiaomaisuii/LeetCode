package DynamicProgramming;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-09-01 12:47
 * @ Description: 最大子序和
 **/
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        // 这个变量用来保存和的结果。
        int ans = nums[0];
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 只要大于0 就一直加
            if (sum>0){
                sum += nums[i];
            }else {
                // 如果小于零就代表这个子序列不能在玩了
                sum = nums[i];
            }
            // 不管怎么加肯定是保存最大值的，一直把最大的子序列的和保存下来，
            // 所以上面这些都是尽管加。
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray.maxSubArray(nums);
        System.out.println(i);
    }
}

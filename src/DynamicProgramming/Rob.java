package DynamicProgramming;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-09-03 20:22
 * @ Description: 打家劫舍
 **/
public class Rob {
    /**
     * 这个是dp解法
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i>1){
                // 选和不选两种情况。
                // 思路是这样的我既然选择了第i个，那么就选之前i-2个用fl来代替
                int a = nums[i] + f[i - 2];
                int b = f[i - 1];
                f[i] = Math.max(a, b);
            }else {
                f[i] =  Math.max(nums[0],nums[1]);
            }
        }
        return f[nums.length - 1];
    }



    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] nums = {2,7,9,3,1};
        int rob1 = rob.rob(nums);
        System.out.println(rob1);
    }
}

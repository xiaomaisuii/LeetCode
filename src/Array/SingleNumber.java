package Array;

import java.util.Arrays;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-09 09:18
 * @ Description: 只出现一次的数字
 **/
public class SingleNumber {
    /**
     * 要求要有线性的时间复杂度那么就是O(n),不可以使用额外的空间，那么就是使用自身数组来保存数据。
     * @param nums
     * @return
     * 总结一下，这个是利用了数据排序，然后还利用了一个其他变量，不过时间复杂度控制在了O(n).
     * 不过总体来说执行效率还是不高的。而且算法实现比较复杂。
     * 时间：2个番茄时间。
     */
    public int singleNumber(int[] nums) {
        if(nums.length<=1){
            return nums[0];
        }
        // 先把数组排序
        Arrays.sort(nums);
        // 这样就算有相同的也都是挨着的了，只要判断相邻的两个数据不一样，那么就可以判断出唯一的数组。
        int tmep = nums[nums.length-1]+1;
        // 把第一个是唯一的数提前拿出去。
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        // 同样也要把最后一个去掉
        if(nums[nums.length-2]!=nums[nums.length-1]){
            return nums[nums.length-1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=nums[i+1]){
                if (nums[i]==tmep){
                    return tmep;
                }
                tmep = nums[i+1];
                continue;
            }
            tmep = nums[nums.length-1]+1;
        }
        return -1;
    }

    /**
     * 利用了java 的位异或运算（^）
     * 5 ^ 3 // 结果为6
     * 5转换为二进制：0000 0000 0000 0000 0000 0000 0000 0101
     * 3转换为二进制：0000 0000 0000 0000 0000 0000 0000 0011
     * 6转换为二进制：0000 0000 0000 0000 0000 0000 0000 0110
     * 位异或：第一个操作数的的第n位于第二个操作数的第n位 相反，那么结果的第n为也为1，否则为0
     * 只要有相同的就保存不下来，那个唯一的数据就能保存下来。
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        int result =nums[0];
        for(int i=0;i<nums.length;i++){
            result=result^nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {1,1,2,2,3};
        int i = singleNumber.singleNumber1(nums);
        System.out.println(i);
    }
}

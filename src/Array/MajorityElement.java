package Array;

import java.util.Arrays;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-26 17:40
 * @ Description: 求众数
 **/
public class MajorityElement {
    /**
     * 用双层for的话，实现起来时间复杂度为O(n^2)比较复杂了就。
     * 总结：总体上时间复杂度为0(n),但是执行效率也不高。
     * 优化方面把数组的排序给去掉，这样效率会提高很多。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums.length<=1) return nums[0];
        // 先对数组进行排序。
        Arrays.sort(nums);
        int i = 1;
        int a = nums[0];
        int y = 1;
        while (i < nums.length) {
            if (a == nums[i]) {
                y += 1;
            }else {
                a = nums[i];
                y = 1;
            }
            if (y > nums.length / 2) {
                return nums[i];
            }
            i++;
        }
        return -1;
    }



    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = {2,2,1,1,1,2,2};
        int i = majorityElement.majorityElement(nums);
        System.out.println(i);
    }
}

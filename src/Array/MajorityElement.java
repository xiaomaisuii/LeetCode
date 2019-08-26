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
        if (nums.length==1) return nums[0];
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

    /**
     * 思想就是遇到相同的就加一遇到不同的就减去一
     * 如果遇到两个数相等了，那么多的数就要换成第二个了
     * 这样算完看赋值给cur的就带表的最多了。
     * 因为题目中已经说了一定会有众数，所以只要最多的一定是众数。
     * 时间：2个番茄时间
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        if (nums.length==0) return 0;
        int cur = nums[0];
        int count = 1;
        int i = 1;
        while (i < nums.length) {
            if (count != 0) {
                if (nums[i] == cur) {
                    ++count;
                }else {
                    --count;
                }
            }else {
                cur =nums[i];
                ++count;
            }
            ++i;
        }
        return cur;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = {2,2,1,1,1,2,2};
        int i = majorityElement.majorityElement1(nums);
        System.out.println(i);
    }
}

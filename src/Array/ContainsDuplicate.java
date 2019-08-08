package Array;

import java.util.Arrays;
import java.util.HashSet;


/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-08 21:15
 * @ Description:  存在重复
 **/
public class ContainsDuplicate {
    /**
     * 只要存在重复的数组就返回true。
     * 如果使用双层for 循环的话，时间复杂度是不是有点大呢 ？
     * 肯定会有时间复杂度更低的算法至少控制在O(n)而不是O(n^2)。
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[i] == nums[j] ){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 要设计一个满足时间复杂度为O(n)的算法。不要用双层for循环。
     * 利用了其他数据结构（Set 里面没有重复值）的特性去保存数组，然后利用特性去判断长度，不一样就是有重复的。
     * 这样就使得时间复杂度降低了一个。
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {

        if(nums.length==1){
            return false;
        }
        // 利用其他数据结构保存数组数据，然后通过其他数据解决的方法来看有没有重复的 ?
        HashSet hashSet = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        if(nums.length!=hashSet.size()){
            return true;
        }
        return false;
    }

    /**
     * 这个是上面写的3秒通过样例的，时间复杂度是O(n^2) 但是执行的效率确实很高
     * 主要是利用倒叙的算法来找重复的。
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j])
                    break;
                else if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

    /**
     * 这个方法就是先对数组进行排序，这样如果相同的数就会挨着。
     * 这样判断相邻的两个数是不是一样就可以了，并且时间复杂度和空间复杂度都不高。
     * 效率很高。
     * @param nums
     * @return
     */
    public boolean containsDuplicate3(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        boolean a = containsDuplicate.containsDuplicate3(nums);
        System.out.println(a);

    }
}

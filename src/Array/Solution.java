package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-06 09:57
 * @ Description: 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 **/
public class Solution {
    // 这个性能不够好，不能用其他数据结构。
    public static int removeDuplicates(int[] nums) {
        // 创建一个list集合，用于保存nums 来进行删除元素。
        List list = new ArrayList();
        for (int i = 0 ; i < nums.length;i++){
            if (!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        for(int i = 0 ;i< list.size();i++){
            nums[i] = (int)list.get(i);
        }
        return list.size();
    }
    // 因为测试样例是排序的所以，可以使用以下方法
    // 这个是性能最好的代码样式。
    public static int removeDuplicates2(int[] nums) {
        if(nums.length<2)return nums.length;
        int i=0,n=0;
        while(i<nums.length-1){
            if(nums[n]!=nums[++i])
                nums[++n]=nums[i];
        }
        return n+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,4,5};
        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int len = removeDuplicates2(nums);
        System.out.println(len);
        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}

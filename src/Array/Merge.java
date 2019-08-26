package Array;

import java.util.Arrays;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-26 18:38
 * @ Description: 合并两个有序数组
 **/
public class Merge {
    /**
     * 时间：一个番茄时间
     * 总结：时间复杂度为O(n)，但是用到了数组的排序，所以优化的方向就是把数组排序给干掉
     * 直接在赋值的时候就进行排好顺序；
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i <m+n ; i++) {
            nums1[i] = nums2[j];
            j++;
        }
        // 这个也是一个优化的方向
        Arrays.sort(nums1);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int sum = n+m-1;
        int n1=m-1;
        n=n-1;
        while(n>=0&&n1>=0){
            if(nums1[n1]>=nums2[n]){
                nums1[sum--] = nums1[n1--];
            }
            else nums1[sum--] = nums2[n--];
        }
        while(n>=0){
            nums1[sum--] = nums2[n--];
        }
   }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        merge.merge1(nums1, m, nums2, n);
        for (int i = 0; i < m+n; i++) {
            System.out.println(nums1[i]);
        }
    }
}

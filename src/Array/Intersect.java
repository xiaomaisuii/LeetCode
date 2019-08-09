package Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-09 20:15
 * @ Description: 两个数组的交集 II
 * 这个问题有几个思考暂时没有解决（以后有时间的情况下，解决一下）：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 **/
public class Intersect {
    /**
     * 思路：先排序，然后双层for 遇到相同的写道list集合中去
     * 然后把第二个数组的相同的值给其赋予一个其他值，避免下次遇到的时候多算。
     * 总结：算法编码不算难，但是时间复杂度为O(n^2),并且利用了其他数据结构，还进行了排序，这些都会影响整体的性能。
     * 时间：2个番茄时间
     * @param nums1 第一个数组
     * @param nums2 第二个数组
     * @return 返回两个数组的交集。
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList list = new ArrayList();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i]==nums2[j]){
                    list.add(nums1[i]);
                    nums2[j] = nums1[0]-1;
                    break;
                }
            }
        }
        int[] t = new int[list.size()];
        for (int i = 0;i<list.size();i++){
            t[i] = (int)list.get(i);
        }
        return t ;
    }

    /**
     * 算法思想：排序，然后用数组较短的长度去创建一个临时数组，然后这个数组用来保存集合。
     * 然后用whlie 循环 条件就是两个数组都走完。
     * 因为数组是有序的，所以判断两个数组的大小即可，小的就进行++ 也就是走到下一个，然后相等就保存道临时数组中。
     * 并且在进行走到下一步，解决了集合中算过的又会重新算一次的事情。
     * 并且代码简单，时间复杂度低一个量级，而且空间复杂度也不高。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null) return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] arr = new int[l1>l2?l2:l1];

        int i=0;
        int j=0;
        int k = 0;
        while(i<l1 && j<l2){
            if(nums1[i] < nums2[j]){
                i++;
            } else if(nums1[i] > nums2[j]){
                j++;
            } else {
                arr[k] = nums1[i];
                k++;
                i++;
                j++;
            }
        }

        int[] temp = new int[k];
        for(int q=0;q<k;q++){
            temp[q] = arr[q];
        }

        return temp;
    }

    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        int[] nums1 = {-2147483648,1,2,3};
        int[] nums2 = {1,-2147483648,-2147483648};
        int[] ints = intersect.intersect2(nums1, nums2);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+",");
        }
    }
}

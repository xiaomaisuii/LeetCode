package Array;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-07 21:28
 * @ Description: 旋转数组
 *
 **/
public class Rotate {
    /**
     * 要求的空间复杂度必须为O(1)
     * 并且必须使用原地算法，所谓的原地算法就是不借助外地的数据结构进行运算的。
     * 思路：先把k当成1 然后去思考算法怎么写，这样就简单了很多。
     *      需要一个变量来保存其中的值要不怎么转换 ?
     *      看样例得到不管k是几一次旋转1 这么长的步长。
     * @param nums
     * @param k
     * 总结： 代码思路比较简单，但是时间复杂度为O(n^2) 时间复杂度有点大，需要优化一下。
     * 解题时间： 2个番茄时间。 总体上时间比之前有所进步，但是代码质量还是不行。
     */
    public void rotate(int[] nums, int k) {
        // 进行k次的向右移动
        for (int i = 0 ;i<k ;i++){
            int tmp = nums[ nums.length - 1];
            // 使用倒序的循环
            for (int j = nums.length - 1 ; j > 0;j--){
                nums[j] = nums[j-1];
            }
            nums[0] = tmp;
        }
        // 先进行一步的移动
        // 把最后一个给其拿出来

    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] nums = {1,2,3,4,5,6,7};
//        System.out.println(nums[nums.length]);
        rotate.rotate(nums, 2);
        for (int a :nums){
            System.out.print(a+",");
        }

    }
}

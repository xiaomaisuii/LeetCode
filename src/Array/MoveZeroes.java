package Array;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-10 20:12
 * @ Description: 移动零
 **/
public class MoveZeroes {
    /**
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * 思路：
     * 总结： 时间复杂度为O(n^2) 并且代码思想比较复杂，不容易想，且代码比较复杂，不容易实现。
     * 时间：2个半番茄时间。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums.length<=1) return;
        int i = 0;
        int b = 0;
        while (b<nums.length-1&&i<nums.length-1){
            if(nums[i]==0){
                for (int j = i; j < nums.length-1; j++) {
                    nums[j] = nums[j+1];
                }
                b++;
                nums[nums.length-1]=0;
            }else {
                i++;
            }
        }
    }

    /**
     * 想复杂了啊 ，之前一直在思考判断是不是为0 ，如果为零就放到数组后面，然后移动整个数组
     * 这种思想太笨了，我只要判断有多少不为0的不就行了，然后把不为零的数组元素从数组第一个位置开始存，
     * 最后遍历完了，记下多少个0，然后在for循环补位就行了。
     * 总结：在思考一种算法，不管怎么写算法思想都比较复杂的时候，要换一种方式去考虑，而且时间复杂度降到为：O(n)
     * 并且代码整个实现来说也比较简单，易懂。
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        // 还需要一个变量去保存不为0的数组下标
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                nums[a]=nums[i];
                a++;
                // nums[a++] = nums[i] ; 这个也是可以的。
            }
        }
        for (int i = nums.length-1; i > a - 1; i--) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {2,1};
        moveZeroes.moveZeroes2(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+",");
        }
    }
}

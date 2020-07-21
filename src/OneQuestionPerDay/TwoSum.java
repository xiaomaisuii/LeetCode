package OneQuestionPerDay;



/**
 *  每日一题之求两数之和
 */
public class TwoSum {
    /**
     * 这个双层for循环固然比较简单，但是时间复杂度为O(n^2) 时间复杂度太大了，不行，需要优化的。
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        if(numbers.length<1) return null;
        int[] tmp = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1 ; j < numbers.length; j++) {
                if (numbers[i]+numbers[j] == target){
                    tmp[0] = i + 1;
                    tmp[1] = j + 1;
                    return tmp;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(numbers,target).toString());
    }
}

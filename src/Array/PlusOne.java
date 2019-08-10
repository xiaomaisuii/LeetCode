package Array;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-10 09:25
 * @ Description: 加一
 **/
public class PlusOne {
    /**
     * 思路：利用倒叙for 循环 先加一下 如果大于10 就把十位的数据保存下来，然后下一次循环的时候进行加运算。
     * 最后如果遍历到了最高位的时候还是要进位的话，就应该把数组长度增加1了，这个时候使用其他数组保存一下即可。
     * 总结：时间复杂度为 0(n) 但是代码感觉有点繁琐，有些不简洁。
     * 时间：一个半的番茄时间。
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {


        int tmep = 0;
        for (int i = digits.length-1; i >=0 ; i--) {
            // 利用倒序遍历 这个可以提出去，然后在进行遍历。
            if (i==digits.length-1){
                digits[i] = digits[i]+1;
                tmep = digits[i] / 10;
                // 这个加1肯定不会出现0以上的数，也可以把这部简化一下。
                digits[i] = digits[i]%10;
                continue;
            }
            if (tmep>0){
                digits[i] = digits[i]+1;
                tmep = digits[i] / 10;
                digits[i] = digits[i]%10;
            }
        }

        // 如果数组要增加长度的话，就要执行下面的代码了。
        if(tmep>0){
            int[] d = new int[digits.length+1];
            d[0] = tmep;
            for (int i = 0; i < digits.length; i++) {
                d[i+1] = digits[i];
            }
            return d;
        }

        return digits;
    }

    /**
     * 这个代码整体上是优化了上面代码的缺陷，整体的时间复杂度没有提高，不过效率更高。
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        int re = digits[digits.length-1]+1;
        if (re > 9){
            digits[digits.length-1] = 0;
            int i = digits.length-2;
            while (i>=0 && digits[i]+1 > 9){
                digits[i] = 0;
                i--;
            }
            if (i<0){
                int[] ans = new int[digits.length+1];
                ans[0] = 1;
                for (int j = 0; j < digits.length; j++) {
                    ans[j+1] = digits[j];
                }
                return ans;
            }
            digits[i] = digits[i]+1;
        }else {
            digits[digits.length-1] = re;
        }

        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] digits = {9, 9, 9, 9};
        int[] one = plusOne.plusOne(digits);
        for (int o: one) {
            System.out.print(o+",");
        }
    }
}

package String;

import java.util.Arrays;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-12 22:13
 * @ Description: TODO
 **/
public class Reverse {
    /**
     * 思路，把每一位都拿出来，然后存放到一个数组中去就ok了 然后进行旋转数组，最后在转换回来。
     * 还要思考一下，是不是超过范围了，和int的取字范围相同即可。
     * 总结： 整体的思想还好（但是实现出来思路超级复杂），不过实现起来相对来说比较复杂，而且在数组转换成字符串的时候要自己写估计性能会好一些，
     * 但是这个代码执行起来太慢了。需要优化。
     * 时间：4个番茄时间。
     * @param x
     * @return
     */
    public int reverse(int x) {
        // 默认为正数
        char f = '+';
        long xx = (long) x;
        if (xx<0){
            xx = Math.abs(xx) ;
            f = '-';
        }
        // 如何判断一个整数有多少位 ？
        // 利用循环除以10 看需要除以多少次，才能完事。
        int i = 0; // 用于记录整数有几位的。
        long b = xx;
        while (b>=10){
            b = b /10;
            i++;
        }
        long[] a = new long[i+1];
        // 要把一个整数存放到字符数组中去了。
        while (i>=0) {
            // 利用取余啊 就可以把整数里面的数据拿出来了。
            a[i--] = xx%10;
            xx = xx/10;
        }
        // 转换
        reverseString(a);
        // 把数组转换成整数在就ok了
        // 那么如何将一个数组转换成整数呢 ？ 可以向把一个数组转换成字符串啊，然后在从字符串转换出来就可以了。
        String s = Arrays.toString(a); // 使用自带这个解析成字符串格式不是 "321" 而是[3, 2, 1] 所以需要更改一下格式。
        String s1 = s.replaceAll(",", "")
                .replaceAll("\\[", "").replaceAll("]","" )
                .replaceAll(" ", "");
        // 上面这个转换成字符串可以自己写应该是性能比这个好的。
        long v = Long.parseLong(s1);
        if (f=='-'){
            v = -v;
        }
        if (v>Integer.MAX_VALUE||v<Integer.MIN_VALUE){
            return 0;
        }
        return (int) v;
    }

    /**
     * 转换数组
     * @param s
     */
    public void reverseString(long[] s) {
        int i = 0;
        int j =s.length -1;
        while(i<j){
            long t = s[i];
            s[i++] = s[j];
            s[j--] = t;
        }
    }

    /**
     * 这个是效率最高的代码；并且思想超级简单。
     * (newResult - x%10) / 10 != result 为判断条件，这就是代表输入的数据没有益出，如果有就不相等了，那么也就不对了。
     * 这个如果让我想肯定是不好想的。
     * 而且在转换整数的时候也不需要转换成数组在转换，这样太复杂了，直接用一个其他的变量然后取余或者取整就ok了，下次在思考的时候
     * 如果感觉太复杂，就换一种思路取思考一下，也许这样会好很多。
     * @param x
     * @return
     */
    public int reverse1(int x) {
        int result = 0;

        while(x != 0) {
            int newResult = result*10 + x%10;
            if ((newResult - x%10) / 10 != result)
            {
                return 0;
            }
            result = newResult;
            x = x/10;
        }
        return result;
    }

    /**
     * 这个执行效率也特别高，而且思想也比较简单，容易想；
     * 整数转换可以用移动位置。然后通过取整和取余的方式就可以了。
     * @param x
     * @return
     */
    public int reverse2(int x){
        long y = 0;
        while (x!=0){
            y = y*10+x%10;
            x = x/10;
        }
        if (y>Integer.MAX_VALUE||y<Integer.MIN_VALUE){
            return 0;
        }
        return (int) y;
    }



    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        int x = -2147483648 ;

        int reverse1 = reverse.reverse2(x);
        System.out.println(reverse1);

    }
}

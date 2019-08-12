package String;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-12 20:43
 * @ Description: 反转字符串
 **/
public class ReverseString {
    /**
     * 思路：因为必须使用原地算法，所以不能使用额外的空间，第一个和最后一个对调 倒数第二个和第二个对调是不是就可以了。
     * 总结： 时间复杂度为O(n) 并且算法思想比较简单。但是不是效率最高的。
     * 时间：一个番茄时间
     * @param s
     */
    public void reverseString(char[] s) {
        if (s.length<=1) return;
        char a = '0';
        int i = 0;
        while (i<s.length/2){
            a = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = a;
            i++;
        }
    }

    /**
     * 代码更加简洁，并且实现的思想比较简单。
     * 总体上是对调一次然后一个向右一个向左运动一次，循环条件就是判断是否遇到了，大的比小的大了。
     * @param s
     */
    public void reverseString1(char[] s) {
        int i = 0;
        int j =s.length -1;
        while(i<j){
            char t = s[i];
            s[i++] = s[j];
            s[j--] = t;
        }
    }

    public static void main(String[] args) {
        ReverseString string = new ReverseString();
        char[] s = {'H','a','n','n','a','h'};
        string.reverseString(s);
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]+",");
        }
    }
}

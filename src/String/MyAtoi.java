package String;

import java.math.BigInteger;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-16 15:57
 * @ Description: 字符串转换整数 (atoi)
 **/
public class MyAtoi {
    /**
     * 总结：时间复杂度为O(n) 但是代码实现的过于复杂，不易读。
     * 可以优化一下代码逻辑，这样就能提高效率了。
     * 时间：4个番茄时间
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if (str.length()<1||str==null) return 0;
        char[] chars = str.toCharArray();
        if (chars.length==1){
            if (chars[0]>'9'||chars[0]<'0') return 0;
        }
        // 用来暂时保存数据
        String c = "";
        // 用来标记正负号；
        int b = 1;
        for (int i = 0; i < chars.length; i++) {
            if (c.length()<1){
                if (chars[i]==' '){
                    //如果是空字符的话，那么就结束本次循环就行了；
                    continue;
                }
                // 判断是不是满足第一个非空字符是数字或者字符
                if (chars[i]!='-'&&chars[i]!='+'&& chars[i]<'0'||chars[i]>'9'){
                    return 0;
                }
            }
            if (c.length()>=1){
                if (chars[i]<'0'||chars[i]>'9') {
                    break;
                }
            }
            if (chars[i]=='-'||chars[i]=='+') {
                if (chars[i]=='-') b = -1;
                if (chars[i+1]<'0'||chars[i+1]>'9') return 0;
                continue;
            }
            if(chars[i]>=0||chars[i]<=9){
                c = c + chars[i];
            }
        }
        if (c.length()<1) return 0;
        double l = Double.parseDouble(c)*b;
        if (l>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if (l<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)l;
    }

    public static void main(String[] args) {
        MyAtoi atoi = new MyAtoi();
        String str = "-";
        int i = atoi.myAtoi(str);
        System.out.println(i);
    }
}

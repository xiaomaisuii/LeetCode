package String;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-18 15:55
 * @ Description: 报数
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 其实也就是找规律
 **/
public class CountAndSay {
    /**
     * 总结：使用了递归调用，并且在递归中用了双重for循环，整体上效率比较低，可以在这方面优化一下；
     * 时间：2个番茄时间
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n==1) return "1";
        // 规律就是上次出现的然后咱们数一下，就是这次出现的结果，并且是递归调用。
        String str = countAndSay(n-1);
        char[] chars = str.toCharArray();
        String tmpStr = "";
        for (int i = 0; i < chars.length; i++) {
            int a = 1;
            for (int j = i ; j < chars.length-1; j++) {
                if (chars[i]==chars[j+1]){
                    a++;
                }else {
                    break;
                }
            }
            tmpStr = tmpStr + a + chars[i];
            i = i + a -1;
        }
        return tmpStr;
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        int n = 6;
        String s = countAndSay.countAndSay(n);
        System.out.println(s);
    }
}

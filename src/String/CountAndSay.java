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
        // 这个就是递归的出口
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

    /**
     * 优化一下算法把其中的双重for干掉。
     * 思想就是把第一个数拿出来，然后循环字符串一样的有多少个就记录下来，如果遇到不一样的,那么就带吧算出来之前有多少个一样的了
     * 然后就把第一个数字重新赋值,依此下去就代替双层for的作用了.
     * @param n
     * @return
     */
    public String countAndSay1(int n) {
        if (n==1) return "1";
        // 规律就是上次出现的然后咱们数一下，就是这次出现的结果，并且是递归调用。
        String str = countAndSay1(n-1);
//        String tmpStr = "";
        char c = str.charAt(0);
        // 这是个对象，必须低new才能创建啊；
        StringBuilder tmpStr = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (c== str.charAt(i)){
                count++;
            }else {
                tmpStr.append(count).append(c);
                count = 1;
                c = str.charAt(i);
            }
        }
        tmpStr.append(count).append(c);
        return String.valueOf(tmpStr);
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        int n = 6;
        String s = countAndSay.countAndSay(n);
        String s1 = countAndSay.countAndSay1(n);
        System.out.println(s1);
        System.out.println(s);
    }
}

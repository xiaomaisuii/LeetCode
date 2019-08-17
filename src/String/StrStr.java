package String;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-17 19:50
 * @ Description: 实现 strStr()
 **/
public class StrStr {

    /**
     * 总结：思路比较简单，用了String字符串中的方法就解决了
     * 时间：一个番茄时间
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        // 当needle为空的时候返回为0；
        if (needle.length()<1) return 0;
        // 如果不包含的话，就返回-1；
        boolean b = haystack.contains(needle);
        if (!b){
            return -1;
        } else {
            int i = haystack.indexOf(needle);
            return i;
        }
    }

    public static void main(String[] args) {
        StrStr str = new StrStr();
        String haystack  = "aaaaa";
        String needle = "bba";
        int i = str.strStr(haystack, needle);
        System.out.println("出现的位置为："+i);
    }
}

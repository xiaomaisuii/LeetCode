package String;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-14 14:27
 * @ Description: 有效的字母异位词
 * 什么是有效的字母异位词，就是s = "anagram", t = "nagaram" s和t除了字母的顺序都是一样的。
 **/
public class IsAnagram {
    /**
     * 这么实现是没有问题的但是超出时间限制了，也就是性能超级差的。
     * 所以这个不行，需要重新想一个方法去实现。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        byte[] sBytes = s.getBytes();
        byte[] tBytes = t.getBytes();
        Arrays.sort(sBytes);
        Arrays.sort(tBytes);
        String s1 = "";
        for (int i = 0; i < sBytes.length; i++) {
            s1 = s1 + sBytes[i]+",";
        }
        String t1 = "";
        for (int j = 0; j < tBytes.length; j++) {
            t1 = t1 + tBytes[j] + ",";
        }
        int compare = s1.compareTo(t1);
        if (compare==0){
            return true;
        }
        return false;
    }

    /**
     *
     * 这个思想和上面一样，就是更换了不用的数据结果。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        // 长度不一样的直接就不是有效的，下面的就不用比较了。
        if (s.length() != t.length()) return false;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        String sss = new String(ss);
        String ttt = new String(tt);
        int compare = sss.compareTo(ttt);
        if (compare==0){
            return true;
        }
        return false;
    }

    /**
     * 这种思想就是在思考字母是编码的时候的运行，如果字母都是一样的，
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        // 长度不一样的直接就不是有效的，下面的就不用比较了。
        if (s.length() != t.length()) return false;
        // 这里面为什么用26 因为英文字母就26个，所以只需要26个空间就行了,
        // 并且不管是谁减去a都比26小，所以不会数组越界
        int[] l = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // 如果他俩个字母有不同德那么一个增加另一个不会减少，所以就会判断出来了。
            l[s.charAt(i)-'a']++;
            l[t.charAt(i)-'a']--;
        }
        // 只要满足一个不等于零德，那么也就是不是有效的字母异位词
        for (int a : l){
            if (a!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        String s = "aab";
        String t = "bba";
        boolean anagram = isAnagram.isAnagram2(s, t);
        if (anagram){
            System.out.println("有效的字母异位词");
        }else {
            System.out.println("不是有效的字母异位词");
        }
    }


}

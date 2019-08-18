package String;

import java.util.Arrays;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-18 18:01
 * @ Description: 最长公共前缀
 **/
public class LongestCommonPrefix {
    /**
     * 总结:用了双层for 并且利用了数组的排序算法,估计这个会影响性能
     * 如果不用排序的话,估计也是可以解决的,所以这个地方是可以优化的,整体的时间复杂度为O(n^2)
     * 时间:2个番茄时间
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length<1) return "";
        if (strs.length==1) return strs[0];
        Arrays.sort(strs);
        String s0 = strs[0];
        for (int j = 0; j < s0.length(); j++) {
            for (int i = 1; i < strs.length; i++) {
                if (s0.charAt(j)!=strs[i].charAt(j))
                    return s0.substring(0, j);
            }
        }
        return s0;
    }

    /**
     * 这种思想就去除了排序,就拿第一个去对比看看是不是第二个第三个个子串,不是就减去一个在看,依此下去,然后找到了在比第三个
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length<1) return "";
        if (strs.length==1) return strs[0];
        String s0 = strs[0];
        int i = 1;
        while (i<strs.length){
            // 循环每个字符串是否包含第一个字符串
            while (strs[i].indexOf(s0) != 0){
                s0 = s0.substring(0, s0.length() - 1);
            }
            i++;
        }
      return s0;
    }



    public static void main(String[] args) {
        LongestCommonPrefix commonPrefix = new LongestCommonPrefix();
        String[] strs = {"cc","cc"};
        String longestCommonPrefix = commonPrefix.longestCommonPrefix1(strs);
        System.out.println(" 最长公共前缀为:"+longestCommonPrefix);
    }
}

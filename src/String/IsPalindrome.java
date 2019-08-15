package String;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-15 19:08
 * @ Description:  验证回文字符串\
 * 什么是回文字符串：正着读和反这读是一样的；
 **/
public class IsPalindrome {
    /**
     * 总结：算法总体的思想也是很简单的。实现也不难，但是要考虑空的字符串的情况；时间复杂度为O(n),但是算法的效率确实很低
     * 其中的原因估计是因为用了正则表达式和替换方法导致比较慢的原因；
     * 时间：1个番茄时间；
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        // 转换成小写的字母，把不是字母的其他字符都干掉
        String ss = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        if(ss=="") return true;
        // 既然回文字符串，那么就是第一个和倒数第一个是一样的。
        for (int i = 0; i < ss.length(); i++) {
            if (ss.charAt(i)!=ss.charAt(ss.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    /**
     * 这个是根据assia码
     * 这个效率极其高。而且不用其他方法；
     * @param s
     * @return
     */
    public boolean isPalindrome1(String s) {
        if("".equals(s)){
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        char[] cs = s.toCharArray();
        while(i < j){
            if(!((cs[i] >= '0' && cs[i] <= '9')
                    || (cs[i] >= 'A' && cs[i] <= 'Z')
                    || (cs[i] >= 'a' && cs[i] <= 'z'))){
                i++;
                continue;
            }
            if(!((cs[j] >= '0' && cs[j] <= '9')
                    || (cs[j] >= 'A' && cs[j] <= 'Z')
                    || (cs[j] >= 'a' && cs[j] <= 'z'))){
                j--;
                continue;
            }
            if(cs[i] == cs[j]){
                i++;
                j--;
                continue;
            }
            // 利用大小写字母assii码相差32 来判断是不是相同字母
            if((cs[i] - cs[j] == 32 || cs[i]-cs[j] == -32)
                    && cs[i] > '9' && cs[j] > '9'){
                i++;
                j--;
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome palindrome = new IsPalindrome();
        String s = " ";
        boolean b = palindrome.isPalindrome(s);
        if (b){
            System.out.println("是有效的回文字符串");
        }else {
            System.out.println("不是有效的回文字符串");
        }
    }
}

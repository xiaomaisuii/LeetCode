package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-27 18:47
 * @ Description: 单词拆分
 **/
public class WordBreak {
    /**
     * 总结：动态规划问题？
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 如果是空串,那么就是不包含单词了。
        if (s == null && s.length() == 0) {
            return false;
        }
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder str = new StringBuilder(s.substring(0, i+1));
            for (int j = 0; j <= i; j++) {
                if (res[j] && wordDict.contains(str.toString())) {
                    res[i + 1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");





        boolean b = wordBreak.wordBreak(s, wordDict);
        if (b){
            System.out.println("是");
        }else {
            System.out.println("否");
        }

    }
}

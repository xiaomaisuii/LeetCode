package Maths;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-28 21:01
 * @ Description: 最后一个单词的长度
 **/
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() < 0) {
            return 0;
        }
        String[] split = s.split(" ");
        return split[split.length - 1].length();
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        String s = "Hello World";
        int lastWord = lengthOfLastWord.lengthOfLastWord(s);
        System.out.println(lastWord);
    }
}

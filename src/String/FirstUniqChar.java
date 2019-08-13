package String;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-13 15:22
 * @ Description: 字符串中的第一个唯一字符
 **/
public class FirstUniqChar {
    /**
     * 思路：把字符串转换成数组，然后遍历
     * 总结：时间复杂度为 O(n^2) 但是算法整体实现思想还是比较简单的。但是判断条件不好写，并且算法代码不易读。
     * 并且空间复杂度也很高。
     * 时间：4个番茄时间
     * 额外说明一下，有的时候不在状态还是不要写算法题，不容易思考的。
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        // 这个转换会把字母转换成数字编码了.
        byte[] bytes = s.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            int b = 0;
            if (bytes[i]==0) continue;
            for (int j = i; j < bytes.length-1 ; j++) {
                if (bytes[i]==bytes[j+1]){
                    bytes[j+1] = 0;
                }else {
                    b++;
                }
            }
            if (bytes.length-1-i==b){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        String s = "cc";
        int i = firstUniqChar.firstUniqChar(s);
        System.out.println(i);
    }
}

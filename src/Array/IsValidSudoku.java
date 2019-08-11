package Array;

import java.util.Arrays;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-11 19:34
 * @ Description: 有效的数独
 **/
public class IsValidSudoku {
    /**
     * 思想： 先一行一行判读，在一列一列判断，然后在一个3*3方块去判断。
     *  总结：算法总体思想比较简单，但是时间复杂度比较高O(n^2) ,算法实现起来比较复杂，代码不宜读写。
     *  时间：4个番茄时间
     *  可优化部分：在算某一行中是否有重复的时候，这个时候可以写一些优化好的算法，比如利用倒叙比大小来看。还有就是遇到'.'
     *  的时候就结束本次循环就行了，为什么还要在对比下去呢  ？
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // 这个是一行一行的
        // board.length 代表一维数组的长度
        for (int i = 0; i < board.length; i++) {
            char[] a = new char[9];
            //  board[i].length 代表的是二维数组
            for (int j = 0; j < board[i].length; j++) {
                a[j] = board[i][j];
            }
            Arrays.sort(a);

            for (int j = 0; j < a.length-1; j++) {
                if (a[j]!='.'&&a[j]==a[j+1]  ){
                    return false;
                }
            }
        }

        // 怎么判断一列一列的呢？ board[0].length 代表这列数
        for (int i = 0; i < board[0].length; i++) {
            //  board[i].length 代表的是二维数组
            char[] a = new char[9];
            for (int j = 0; j < board.length; j++) {
                a[j] = board[j][i];
            }
            Arrays.sort(a);
            for (int j = 0; j < a.length-1; j++) {
                if (a[j]!='.' && a[j]==a[j+1]  ){
                        return false;
                }
            }
        }
        // 接下来判断3*3 这个怎么判断呢 ？
        // 先把他分成3*3 一个小块去算，然后在看有没有方法给他合并成一起。
        // 用一个一维数组去保存变量。
        int k = 0;
        int f = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isThree(board,k,f)) return false;
                k+=3;
            }
            f+=3;
            k=0;
        }
        return true;
    }

    private boolean isThree(char[][] board,int k,int f) {
        char[] a = new char[9];
        int t = 0;
        for (int i = k; i < k+3; i++) {
            for (int j = f; j < f+3; j++) {
                a[t] = board[i][j];
                t++;
            }
        }

        Arrays.sort(a);
        for (int i = 0; i < a.length-1; i++) {
            if (a[i]!='.' && a[i]==a[i+1]  ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsValidSudoku isValidSudoku = new IsValidSudoku();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
//        System.out.println(board[0][0]);
        boolean validSudoku = isValidSudoku.isValidSudoku(board);
        if (validSudoku){
            System.out.println("这是一个有效的数独");
        }else {
            System.out.println("这不是一个有效的数组");
        }
    }
}

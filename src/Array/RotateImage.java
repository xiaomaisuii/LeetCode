package Array;

/**
 * @ Author: Mr.Li
 * @ Date: 2019-08-12 13:05
 * @ Description: 旋转图像
 **/
public class RotateImage {
    /**
     * 思路：顺时针旋转90度，把第一行转换成最后一列，把第二行转换成第二列，把第三行转换成第一列。
     * 但是算法要用原地算法。不要使用另外一个矩阵来旋转。
     * 总结：时间复杂度为O(n^2) ,但是利用了其他数组保存了数据，这个不符合题目要求，但是代码思想还是比较简单的。
     * 时间：2个番茄时间
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int[] a = new int[matrix.length*matrix[0].length];
        int f = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                a[f] = matrix[i][j];
                f++;
            }
        }
        // 怎么转换一下啊 ？
        f = 0;
        for (int i = matrix[0].length -1; i >= 0; i--) {
            for (int j = 0; j < matrix.length ; j++) {
                matrix[j][i] = a[f];
                f++;
            }
        }
    }

    /**
     * 利用一个变量去保存其中一个数据，然后在旋转每一个角，一次一次的旋转，把他分成大圈。
     * @param matrix
     */
    public void rotate1(int[][] matrix) {
        int num=matrix.length/2;
        int flag=matrix.length%2;
        int lt=matrix.length-1;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num+flag; j++) {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[lt-j][i];
                matrix[lt-j][i]=matrix[lt-i][lt-j];
                matrix[lt-i][lt-j]=matrix[j][lt-i];
                matrix[j][lt-i]=tmp;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        rotateImage.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }

    }
}

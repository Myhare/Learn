package 算法练习.力扣练习.中等难度;

import java.util.LinkedList;
import java.util.Queue;

public class 矩阵 {

    /*
        给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
        两个相邻元素间的距离为 1 。
     */
    // 求出mat中下标为i，j的位置中距离最近的下标为0的距离
    public static int getN(int i,int j,int[][] mat){

        return 0;
    }

    public static int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int[][] nums = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j]==0){
                    nums[i][j] = 0;
                }else {

                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {

    }

}

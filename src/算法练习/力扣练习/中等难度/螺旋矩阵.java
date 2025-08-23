package 算法练习.力扣练习.中等难度;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {

    /**
     * 将螺旋矩阵加到列表中
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0){
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();

        // 上下左右边界
        int l = 0, r = matrix[0].length - 1;
        int t = 0, b = matrix.length - 1;

        while (true){
            // 从左往右
            for (int i = l; i <= r; i++){
                list.add(matrix[t][i]);
            }
            // 上边界向内收缩
            if (++t > b) break;

            // 从上往下
            for (int i = t; i <= b; i++){
                list.add(matrix[i][r]);
            }
            // 右边界向内收缩
            if (l > --r) break;

            // 从右往左
            for (int i = r; i >= l; i--){
                list.add(matrix[b][i]);
            }
            // 下边界向内收缩
            if (t > --b) break;

            // 从下往上
            for (int i = b; i >= t; i--){
                list.add(matrix[i][l]);
            }
            // 左边界向内收缩
            if (++l > r) break;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new 螺旋矩阵().spiralOrder(arr));
    }

}

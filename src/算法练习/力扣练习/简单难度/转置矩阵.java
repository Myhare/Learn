package 算法练习.力扣练习.简单难度;

public class 转置矩阵 {
    public static int[][] transpose(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        int[][] re = new int[y][x];

        int t = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                re[j][i] = matrix[i][j];
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] transpose = transpose(ints);
        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose[i].length; j++) {
                System.out.printf(transpose[i][j]+" ");
            }
            System.out.println();
        }
    }
}

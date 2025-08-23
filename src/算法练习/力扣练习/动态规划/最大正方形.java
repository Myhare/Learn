package 算法练习.力扣练习.动态规划;

public class 最大正方形 {

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // dp数组表示以i，j为右下角的正方形只包含1的最大边长
        int[][] dp = new int[n][m];
        // 维护递归方程的最大值
        int max = 0;

        // 初始化dp数组
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == '1'){
                dp[i][0] = 1;
            }else {
                dp[i][0] = 0;
            }
            max = Math.max(max,dp[i][0]);
        }
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == '1'){
                dp[0][j] = 1;
            }else {
                dp[0][j] = 0;
            }
            max = Math.max(max,dp[0][j]);
        }


        // 状态递归
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                // 如果当前位置是0，肯定不会是最大正方形
                if (matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else {
                    // dp[i][j]为左、上、左上三个位置的最小值再加一
                    int min = Integer.MAX_VALUE;
                    min = Math.min(min,dp[i-1][j]);
                    min = Math.min(min,dp[i][j-1]);
                    min = Math.min(min,dp[i-1][j-1]);
                    dp[i][j] = min + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        char[][] matrix2 = {{'0','1'},{'1','0'}};
        System.out.println(new 最大正方形().maximalSquare(matrix2));
    }

}

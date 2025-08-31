package 算法练习.力扣练习.剑指Offer;

public class 珠宝的最高价值 {

    /**
     * 1 3 1
     * 1 5 1
     * 4 2 1
     */
    public static int jewelleryValue(int[][] frame) {
        int m = frame.length;
        int n = frame[0].length;

        // 走到当前位置的最大价值
        int[][] dp = new int[m][n];

        // 这种特殊处理有点难看，可以单独初始化左侧和上侧的值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = frame[i][j];
                // 特殊情况处理
                if (i == 0 && j == 0){
                    dp[i][j] = frame[0][0];
                    continue;
                }
                if (i == 0){
                    dp[i][j] = dp[i][j-1] + value;
                    continue;
                }
                if (j == 0){
                    dp[i][j] = dp[i - 1][j] + value;
                    continue;
                }
                // 当前位置最大价值
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + value;
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(jewelleryValue(arr));
    }

}

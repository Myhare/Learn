package 算法练习.力扣练习.剑指Offer;

public class 不同路径 {

    static int count = 0;

    public static int uniquePaths(int m, int n) {
        // 表示走到当前格子的所有路径
        int[][] dp = new int[m][n];

        // 初始化dp
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    // dfs超时
    public static int uniquePathsDfs(int m, int n) {
        int[][] arr = new int[m][n];
        dfs(0,0, m, n);
        return count;
    }
    public static void dfs(int i, int j, int m, int n){
        // 边界判定
        if (i < 0 || j < 0 || i >= m || j >= n){
            return;
        }
        if (i == m - 1 && j == n - 1){
            count++;
            return;
        }
        dfs(i + 1, j, m, n);
        dfs(i, j + 1, m, n);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

}

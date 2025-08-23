package 算法练习.力扣练习.深度优先;

public class 矩阵中最长递增路径 {

    public static int n = 0;
    public static int m = 0;
    public static int maxCount = 0;

    public static int[][] memo;

    public static int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};

    public static int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        maxCount = 0;
        boolean[][] flags = new boolean[n][m];
        memo = new int[n][m];  // 记忆化路径
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                maxCount = Math.max(maxCount, memoBackTracking(i, j, matrix));
            }
        }
        return maxCount;
    }

    // 回溯解决
    public static void backTracking(int x, int y, int[][] matrix, boolean[][] flags, int nowCount){
        // 维持最大的计数
        maxCount = Math.max(maxCount, nowCount);
        // 终止条件
        if(x < 0 || x >= n || y < 0 || y >= m || flags[x][y]){
            return;
        }
        for(int i = 0; i < 4; i++){
            int nextX = x + move[i][0];
            int nextY = y + move[i][1];
            // 剪枝
            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m){
                continue;
            }
            if(matrix[nextX][nextY] <= matrix[x][y]){
                continue;
            }
            // 标记当前位置
            flags[x][y] = true;
            backTracking(nextX, nextY, matrix, flags, nowCount + 1);
        }
        flags[x][y] = false;
    }

    // 记忆化回溯
    public static int memoBackTracking(int x, int y, int[][] matrix){
        // 如果有缓存，直接返回
        if (memo[x][y] != 0){
            return memo[x][y];
        }
        memo[x][y]++;
        for(int i = 0; i < 4; i++){
            int nextX = x + move[i][0];
            int nextY = y + move[i][1];
            // 剪枝
            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m){
                continue;
            }
            if(matrix[nextX][nextY] <= matrix[x][y]){
                continue;
            }

            // 记忆当前的位置
            memo[x][y] = Math.max(memoBackTracking(nextX, nextY, matrix) + 1, memo[x][y]);
        }
        return memo[x][y];
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        int[][] arr2 = new int[][]{{1}};
        System.out.println(longestIncreasingPath(arr2));
    }
}

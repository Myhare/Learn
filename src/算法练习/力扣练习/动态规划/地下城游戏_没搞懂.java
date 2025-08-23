package 算法练习.力扣练习.动态规划;

public class 地下城游戏_没搞懂 {

    int n = 0;
    int m = 0;
    int minVal = Integer.MIN_VALUE;

    public int calculateMinimumHP(int[][] dungeon) {
        n = dungeon.length;
        m = dungeon[0].length;


        // 因为列表中有加血，所以不能使用传统的从上往下遍历
        // dp表示当前dp[i][j]到最后一个位置所需要的最少血量
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = Math.max(0 , -dungeon[n-1][m-1]);
        // 初始化最后一列
        for(int i = n - 2; i >= 0; i--){
            dp[i][m-1] = Math.max(dp[i+1][m-1] - dungeon[i][m - 1], 0);
        }
        // 初始化最后一行
        for(int j = m - 2; j >= 0; j--){
            dp[n-1][j] = Math.max(dp[n-1][j + 1] - dungeon[n-1][j], 0);
        }

        for(int i = n - 2; i >= 0; i--){
            for (int j = m - 2; j >= 0; j--){
                int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] =  Math.max(min,0);
            }
        }


        return dp[0][0] + 1;
    }


    public static void main(String[] args) {
        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(new 地下城游戏_没搞懂().calculateMinimumHP(dungeon));
    }

}

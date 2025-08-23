package 算法练习.力扣练习.动态规划;

public class 最小路径和 {

    // 创建一个dp数组，用来表示从开始到i,j位置的最小路径


    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i==0 && j==0){   // 到左上角第一个节点的路径为原本路径的长度
                    dp[i][j]=grid[i][j];
                    continue;
                }
                if (i - 1 < 0){  // 说明此时是最上边一排的元素
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                    continue;
                }
                if (j - 1 < 0){   // 说明此时是最左边一排的元素
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                    continue;
                }
                // 正常元素，从左边的最小路径和上方最小路径和相加的结果就是这个节点的最小路径和
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(new 最小路径和().minPathSum(grid));
    }

}

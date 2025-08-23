package 算法练习.力扣练习.动态规划;

public class 背包问题 {

    // 自己尝试解决背包问题
    // https://mp.weixin.qq.com/s/xmgK7SrTnFIM3Owpk-emmg

    /**
     * 获取可以放下得最大价值
     * @param n 物品数量
     * @param vArr 每个物品的价值
     * @param wArr 每个物品的数量
     * @param capacity 背包容量
     * @return         可以放入物品的最大价值
     */
    public static int getMaxValue(int n, int[] vArr, int[] wArr, int capacity){

        // 动态规划
        int[][] dp = new int[n+1][capacity+1];  // dp[i][j]表示前i个物品，j表示背包的当前容量

        // 填充dp数组
        for (int i = 1; i <= n; i++) {
            // 获取当前物品的重量
            int w = wArr[i - 1];
            int v = vArr[i - 1];
            for (int j = 1; j <= capacity; j++) {
                if (w > j){
                    // 当前物品重量大于剩余重量,不能放这个物品
                    dp[i][j] = dp[i-1][j];
                }else {
                    // 当前物品重量小于剩余重量，可以选择是否放入背包
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        // getMaxValue(3, 5, new int[]{4,2,3}, new int[]{})
    }

}

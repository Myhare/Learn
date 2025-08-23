package 算法练习.力扣练习.动态规划;

public class 买卖股票的最佳时机4 {

    /**
     * 股派哦哦
     * @param prices 每一天的金额
     * @param k 可以成交的次数
     */
    public static int maxProfit (int[] prices, int k) {
        /*
            使用三维dp解决
            当前第几天
            是否买入股票，1买入 0没买入
            当前是第几次买卖
         */
        int n = prices.length;
        int[][][] dp = new int[n][k+1][2]; // buy表示当前持有股票的最大利益 二维表示当前第j次交易 三维表示当前手上有没有股票
        // 初始化第一天交易k次的最大利益，不算交易多少次，只要手里有股票，最大利益就是-prices[0]，只要手里没有股票，最大利益就是0
        for(int i = 0; i < k + 1; i++){
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        // 初始化每一天交易0次的最大利益，因为后面状态转移需要使用
        for (int i = 1; i < n; i++){
            dp[i][0][0] = 0;  // 手上没有股票，价格都是0
            dp[i][0][1] = Math.max(dp[i-1][0][0]-prices[i],dp[i-1][0][1]);
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k + 1; j++){
                dp[i][j][0] = Math.max(dp[i-1][j-1][1]+prices[i],dp[i-1][j][0]); // i天没有股票的最大收益
                dp[i][j][1] = Math.max(dp[i-1][j][0]-prices[i],dp[i-1][j][1]); // i天手上有股票的最大收益
            }
        }
        return dp[n - 1][k][0];
    }

    public static void main(String[] args) {
        int[] arr = {3,2,6,5,0,3};
        System.out.println(maxProfit(arr, 2));
    }
}

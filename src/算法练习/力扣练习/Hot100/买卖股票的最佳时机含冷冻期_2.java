package 算法练习.力扣练习.Hot100;

public class 买卖股票的最佳时机含冷冻期_2 {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        /**
         * 三个状态
         * 0:手上有有股票
         * 1:手上没有股票，并且明天可以买股票
         * 2:手上没有股票，并且明天不可以买股票
         */
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 手上有股票,当天买，或者之前就持有股票
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            // 不在冷冻期，可以是前一天买的股票，或者前一天不买股票
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][2]);
            // 在冷冻期，说明今天卖出了股票
            dp[i][2] = dp[i - 1][0] + prices[i];
        }

        return Math.max(dp[n-1][1], dp[n-1][2]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(arr));
    }

}

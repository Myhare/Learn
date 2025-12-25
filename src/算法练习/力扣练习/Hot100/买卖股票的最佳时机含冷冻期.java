package 算法练习.力扣练习.Hot100;

public class 买卖股票的最佳时机含冷冻期 {

    public static int maxProfit(int[] prices) {
        int n = prices.length;

//        dp[i][0]: 第i天结束时，持有股票时的最大收益。
//        dp[i][1]: 第i天结束时，不持有股票且明天不可以购买股票时，最大收益。
//        dp[i][1]: 第i天结束时，不持有股票且明天可以购买股票时，最大收益。
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 今天持有个股票，可能是前一天已经持有\当前买入的两种情况
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            // 今天不持有股票，在冷冻期，说明当前卖出股票（冷冻期表示今天）
            dp[i][1] = dp[i-1][0] + prices[i];
            // 不持有股票，并且不在冷冻期。前一天可以卖可以不卖
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
        }
        return Math.max(dp[n-1][1], dp[n-1][2]);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

}

package 算法练习.力扣练习.动态规划;

public class 最佳买卖股票时机含冷冻期 {


    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][0][0]表示第i天手上没有股票的最大利润，dp[i][1][0]表示手上有股票的最大利润
        int[][][] dp = new int[n][2][2];  // dp[i][1][1]表示当前是否在冷冻期(0不在，1在)
        dp[0][0][0] = 0;
        dp[0][1][0] = -prices[0];

        for(int i = 1; i < n; i++){
            // 当前手上没有股票，判断前一天最大利润的时候有没有在冷冻期
            if (dp[i-1][1][0] + prices[i] > dp[i-1][0][0]){
                // 今天卖出股票,标记冷冻区
                dp[i][0][0] = dp[i-1][1][0] + prices[i];
                dp[i][0][1] = 1;
            }else {
                dp[i][0][0] = dp[i-1][0][0];
            }
            dp[i][0][0] = Math.max(dp[i-1][1][0] + prices[i], dp[i-1][0][0]);

            // 当前手上有股票
            if(dp[i-1][0][1] == 1){
                // 今天在冷却期，再往前判断一天
                dp[i][1][0] = Math.max(dp[i-2][0][0] - prices[i], dp[i-1][1][0]);
            }else {
                // 今天不在冷却期
                dp[i][1][0] = Math.max(dp[i-1][0][0] - prices[i], dp[i-1][1][0]);
            }
        }

        return dp[n-1][0][0];
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        int[] prices2 = {1};
        System.out.println(new 最佳买卖股票时机含冷冻期().maxProfit(prices2));
    }

}

package 算法练习.力扣练习.动态规划;

public class 买卖股票的最佳时机2 {


    // 动态规划解决
    public static int maxProfit1(int[] prices) {
        int n = prices.length;
        // dp[i][0] 表示当前持有股票的最大利益
        // dp[i][1] 表示当前不持有股票的最大利益
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i-1][1] - prices[i], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        // 最后肯定是不持有股票
        return dp[n-1][1];
    }


    public static int maxProfit2(int[] prices) {
        /*
            i到j想要赚钱，获得的利益相当于price[j]-price[i]
            其实就相当于每一天只要有利益就可以卖掉
            所以用贪心，只要有利益，就可以卖掉
         */
        int profit = 0; // 赚到的钱
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i+1] > prices[i]){
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit1(new int[]{7,1,5,3,6,4}));
    }

}

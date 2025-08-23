package 算法练习.力扣练习.动态规划;

public class 买卖股票的最佳时机3 {

    public int maxProfit(int[] prices) {

        // 3,3,5,0,0,3,1,4
        int n = prices.length;

        // dp表示当前的最大利益
        int[][][] dp = new int[n][3][2]; // 第i天 当前是第几次交易  手上有没有股票(0没有 1有)

        // 初始化dp数组
        for (int i = 0; i < 2; i++) {
            dp[0][i][1] = -prices[0];  // 第一天就买股票了，当前最大利益就是,不管第一天买卖多少次，最后结果都是-price[0]
        }

        // 初始化每一天第一次购买股票的时候的最大利润
        for(int i = 1; i < n; i++){
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i-1][0][1], dp[i-1][0][0] - prices[i]);
        }

        // 遍历第i天
        for(int i = 1; i < n; i++){
            // 遍历第k次交易
            for (int k = 1; k <= 2; k++) {
                // 只有将手上股票卖出去才算是一次完整的交易

                // 手上没有股票的时候
                dp[i][k][0] = Math.max(dp[i-1][k-1][1] + prices[i], dp[i-1][k][0]); // 前一天有股票然后今天卖了，或者今天也不卖
                // 手上有股票
                dp[i][k][1] = Math.max(dp[i-1][k][0] - prices[i], dp[i-1][k][1]);
            }
        }

        int max = Math.max(dp[n - 1][0][0], dp[n - 1][1][0]);
        max = Math.max(max,dp[n - 1][2][0]);
        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = {3,3,5,0,0,3,1,4};
        int[] arr2 = {1,2,3,4,5};
        int[] arr3 = {7,6,4,3,1};
        System.out.println(new 买卖股票的最佳时机3().maxProfit(arr2));
    }

}

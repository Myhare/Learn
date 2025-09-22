package 算法练习.力扣练习.动态规划;

import java.util.Arrays;

public class 零钱兑换 {

    public static void main(String[] args) {
        int[] arr = {2,3,5,5};
        System.out.println(coinChange(arr, 10));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        int n = coins.length;
        // dp：凑出金额为i的最少硬币个数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // 循环金额
        for (int i = 1; i <= amount ; i++) {
            // 循环硬币
            for (int j = 0; j < n; j++) {
                // 如果硬币金额比i要大，说明本来就不能使用这个硬币
                if (coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1: dp[amount];
    }
}

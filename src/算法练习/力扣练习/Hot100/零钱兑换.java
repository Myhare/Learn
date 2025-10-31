package 算法练习.力扣练习.Hot100;

import java.util.Arrays;

public class 零钱兑换 {

    /**
     * 零钱兑换
     * @param coins 不同面额的硬币
     * @param amount 总金额
     * @return
     */
    public static int coinChange(int[] coins, int amount) {

        // dp[i]表示凑到金额i所需要的最少硬币
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i){
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] arr = {2};
        System.out.println(coinChange(arr, 3));
    }

}

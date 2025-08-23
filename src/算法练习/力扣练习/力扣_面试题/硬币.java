package 算法练习.力扣练习.力扣_面试题;

public class 硬币 {

    // 1 5 10 25四个硬币面额，无限个数，求有多少种可以拼成n面额的方法

    public int waysToChange(int n) {
        int MOD = 1000000007;

        int[] dp = new int[n+1];
        dp[0] = 1;  // 没有硬币也算一种情况

        int[] coins = {1, 5, 10, 25};

        // 先遍历金额再遍历硬币，会有重复的情况
        // for (int i = 1; i <= n; i++) {
        //     for (int coin : coins) {
        //         // 遍历硬币
        //         if (i - coin < 0){
        //             break;
        //         }
        //         dp[i] = (dp[i] + dp[i - coin]) % MOD;
        //     }
        // }

        // 先循环硬币再循环金额
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }


        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new 硬币().waysToChange(6));
        // System.out.println(new 硬币().waysToChange(10));
    }

}

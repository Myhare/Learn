package 算法练习.牛客.a4399;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 凑硬币 {

    // 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

    public static int test(int[] coins, int[] counts, int n){

        // dp[i]表示拼凑到当前金额的最少硬币个数
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 金额i的硬币有多少个
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < coins.length; i++) {
            countMap.put(coins[i], counts[i]);
        }

        // 循环金额
        for (int i = 1; i < n + 1; i++) {
            // 循环硬币
            for (int coin : coins) {
                if (i >= coin) {
                    // 判断当前金额的硬币是否还存在
                    if (countMap.get(coin) > 0) {
                        dp[i] = Math.max(dp[i], dp[i - coin] + 1);
                        countMap.put(coin, countMap.get(coin) - 1);
                    }
                }
            }
        }

        return dp[n] == 0 ? -1 : dp[n];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int[] counts = new int[]{3,2,1};
        int n = 11;
        System.out.println(test(coins, counts, n));
    }

}

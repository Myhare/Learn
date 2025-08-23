package 算法练习.力扣练习.剑指Offer;

public class 剪绳子 {

    public int cuttingRope(int n) {

        // dp[i]表示长度为i的绳子剪下来后的最大乘积
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;

        // 绳子的长度
        for(int i = 2; i <= n; i++){
            // 看当前位置的绳子剪不剪
            for (int j = 1; j < i; j++) {
                // 剪当前长度，剩下的也可以看要不要剪
                dp[i] = Math.max(dp[i], Math.max(j * (i - j),  j * dp[i - j])); // 获取剪绳子的这些长度
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new 剪绳子().cuttingRope(10));
    }

}

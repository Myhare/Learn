package 算法练习.力扣练习.剑指Offer;

public class 剪绳子2 {

    // 正常动态规划，这里数据过大，不能使用传统dp
    public int cuttingRope(int n) {
        // dp[i]表示绳子长度为i时，乘积的最大长度
        int[] dp = new int[n+1];
        // 长度为1的绳子，子乘积就是1
        dp[1] = 1;

        for(int i = 2; i <= n; i++){

            for(int j = 1; j < i; j++){
                // 当前绳子的位置，看看剩下的要不要剪
                int tempInteger = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(dp[i], tempInteger);
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new 剪绳子2().cuttingRope(10));
    }

}

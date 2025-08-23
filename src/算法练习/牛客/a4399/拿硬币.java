package 算法练习.牛客.a4399;

public class 拿硬币 {

    // 有n个硬币，每次最多拿走一个或者两个，你有多少种不同的方法拿完全部的硬币？

    public static int get(int n){
        // dp表示剩下i个硬币的时候有多少的次数
        int[] dp = new int[n+1];
        dp[n] = 0;
        dp[n-1] = 1;
        for (int i = n - 2; i >= 0; i--){
            dp[i] = dp[i+1] + dp[i+2];
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(get(4));
    }

}

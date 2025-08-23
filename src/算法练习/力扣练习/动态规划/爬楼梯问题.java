package 算法练习.力扣练习.动态规划;

public class 爬楼梯问题 {

    // 递归解决
    public static int f1(int n){
        if (n==1){
            return 1;
        }else if (n==2){
            return 2;
        }
        return f1(n-1) + f1(n-2);
    }

    // 使用动态规划解决
    public static int f2(int n){

        int[] dp = new int[n+1];   // dp[i]代表到第i个阶梯需要多少步
        if (n==1){
            return 1;
        }else if (n==2){
            return 2;
        }
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3;i <= n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // System.out.println(f1(45));
        System.out.println(f2(3));
    }

}

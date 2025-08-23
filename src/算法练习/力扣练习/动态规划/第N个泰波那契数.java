package 算法练习.力扣练习.动态规划;

public class 第N个泰波那契数 {
//    泰波那契序列Tn定义如下：
//    T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
//    给你整数n，请返回第 n 个泰波那契数Tn 的值。

    // 递归求解
    public static int tribonacci(int n){
        if (n==0){
            return 0;
        }else if (n==1||n==2){
            return 1;
        }
        return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    }

    // 动态规划思想迭代
    public static int trivonacci2(int n){
        if (n==0){
            return 0;
        }else if (n==1||n==2){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1]=0;
        dp[1]=dp[2]=1;
        for (int i = 3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
    //    System.out.println(tribonacci(25));
        System.out.println(trivonacci2(25));
    }

}

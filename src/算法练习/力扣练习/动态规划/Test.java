package 算法练习.力扣练习.动态规划;

public class Test {

    // 0,1,1,2

    public static int fib(int a){
        int[] dp = new int[a+1];
        for (int i = 0; i <= a; i++) {
            if (i==0){
                dp[i] = 0;
            }else if (i==1){
                dp[i] = 1;
            }else {
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[a];
    }


    public static void main(String[] args) {
        System.out.println(fib(4));
    }

}

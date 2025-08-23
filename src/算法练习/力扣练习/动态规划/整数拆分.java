package 算法练习.力扣练习.动态规划;

public class 整数拆分 {

    int max = 0;

    // 动态规划解决
    public int integerBreak(int n) {
        // dp[i]表示i分割后数字的相加
        int[] dp = new int[n+1];

        for(int i = 2; i <= n; i++){
            for (int j = 1; j < i; j++){
                // 两种情况取最大值 将i分成j和i-j，i-j可以选择是否再分
                // 不再分
                int val1 = j * (i-j);
                // i-j再分
                int val2 = j * dp[i-j];
                int max = Math.max(val1,val2);
                dp[i] = Math.max(dp[i],max);
            }
        }

        return dp[n];
    }

    public int integerBreak1(int n) {
        dfs(1, n,1,0);
        return max;
    }

    // 暴力回溯(超时)
    public void dfs(int a, int n, int product, int count){
        if (a == n + 1){
            max = Math.max(max,product);
            return;
        }

        // 因为最少要分成两个数字，这里需要少一个
        for(int i = a; i <= n; i++){
            if (i != a && i == n && count == 0){
                continue;
            }
            int t = i - a + 1;
            product *= t;
            dfs(i+1, n, product,count+1);
            product /= t;
        }

    }

    public static void main(String[] args) {
        System.out.println(new 整数拆分().integerBreak(10));
    }

}

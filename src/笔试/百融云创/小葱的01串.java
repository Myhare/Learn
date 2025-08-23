package 笔试.百融云创;

import java.util.Scanner;

public class 小葱的01串 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        // 动态规划  dp[i]表示前i个字符区间0的数量
        int[] dp0 = new int[n + 1];
        // 动态规划  dp[i]表示前i个字符区间1的数量
        int[] dp1 = new int[n + 1];

        // 初始化化
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            if (Integer.parseInt(String.valueOf(c)) == 0){
                dp0[i] = dp0[i-1] + 1;
            }else {
                dp1[i] = dp1[i-1] + 1;
            }
        }
        int count0 = dp0[n]; // 总的0的数量
        int count1 = dp1[n];

        // 方案数量
        int count = 0;

        for (int i = 0; i < n; i++){
            // for (int )
        }

        System.out.println(count);

    }

}

package 算法练习.挑战赛初赛java赛题;

import java.util.Scanner;

public class 大富翁 {

    public static void main(String[] args) {

        // 初始化参数
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        /**
         * 动态规划
         */
        // // 初始化参数
        // int[] dp = new int[n];  // dp[i]表示当前i位置能跳到的最远的位置
        // dp[0] = arr[0];
        // if (dp[0]==0){
        //     System.out.println(0);
        //     return;
        // }
        //
        // for (int i = 1; i < n; i++) {
        //     dp[i] = Math.max(dp[i-1], arr[i]+i);
        //     // 如果当前位置能跳的最远位置是当前位置本身，说明不能跳到更远
        //     if (dp[i]==i){
        //         System.out.println(i+1);
        //         return;
        //     }
        // }
        // // 说明能走到最后
        // System.out.println(dp[n-1]+1);


        /**
         * 贪心
         */
        int maxR = 0;
        for (int i = 0; i < n; i++){
            // 维护能走到的最远的地方
            if (i <= maxR){
                maxR = Math.max(maxR,i+arr[i]);
            }
            // 说明当前已经跳到最远的地方了
            if (maxR==i){
                System.out.println(maxR+1);
                return;
            }
        }
        System.out.println(maxR+1);

    }

}

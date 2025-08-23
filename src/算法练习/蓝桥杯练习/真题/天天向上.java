package 算法练习.蓝桥杯练习.真题;

import java.util.Scanner;

public class 天天向上 {

//    A同学的学习成绩十分不稳定，于是老师对他说：“只要你连续4天成绩有进步，那我就奖励给你一朵小红花。”可是这对于A同学太困难了。于是，老师对他放宽了要求：“只要你有4天成绩是递增的，我就奖励你一朵小红花。”即只要对于第i、j、k、l四天，满足i<j<k<l并且对于成绩wi<wj<wk<wl，那么就可以得到一朵小红花的奖励。现让你求出，A同学可以得到多少朵小红花。
//    输入格式
//　　第一行一个整数n，表示总共有n天。第二行n个数，表示每天的成绩wi。
//    输出格式
//　　一个数，表示总共可以得到多少朵小红花。

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();   // 输入有多少天
        int[] scores = new int[n];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = scanner.nextInt();   // 输入每一天成绩是多少
        }
        int[][] dp = new int[n+1][n+1];  // 创建一个dp数组，dp[i][j]表示从i开始递增j次的数量



        scanner.close();
    }

}

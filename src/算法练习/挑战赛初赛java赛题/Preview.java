package 算法练习.挑战赛初赛java赛题;

import java.util.Scanner;

public class Preview {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 有n门学课
        int n = scanner.nextInt();
        // 需要预习的时间
        int[] ai = new int[n];
        // 学课的价值
        int[] bi = new int[n];

        for (int i = 0; i < n; i++) {
            ai[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bi[i] = scanner.nextInt();
        }

        // 复习学课的总价值
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = ai[i]*bi[i];
        }

        // 动态规划
        // dp表示到i门课程最打的价值
        int[] dp = new int[n];





    }

}

package 算法练习.挑战赛初赛java赛题.other;

import java.util.Scanner;

public class subject06 {
    // 统计1-N之间所有平方数的个数
    public static void main(String[] args) {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 1; i <= N; i++) {
            if (Math.sqrt(i)%1==0){
                count++;
            }
        }
        System.out.println(count);
    }
}

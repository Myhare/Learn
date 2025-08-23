package 算法练习.简单练习;

import java.util.Scanner;

public class 激光陷阱1 {

    public static void main(String[] args) {
        // 网格
        int[][] a = new int[100][100];
        // 安全位置数量
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        // 输入有多少个陷阱
        int n = scanner.nextInt();
        // 存n个陷阱的位置
        int[][] a2 = new int[n][2];
        for (int i = 0; i < n; i++) {
            a2[i][0] = scanner.nextInt();
            a2[i][1] = scanner.nextInt();
        }
        // 循环遍历
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                // 判断当前位置是不是安全位置
                int k = 0;
                for (; k < a2.length; k++) {
                    // 这一行全都不安全，直接进入到下一行
                    if (a2[k][0] == i || a2[k][1]==j){
                        break;
                    }
                }
                if (k == a2.length){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

}

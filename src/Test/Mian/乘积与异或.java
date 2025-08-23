package Test.Mian;

import java.util.Scanner;

public class 乘积与异或 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        int[][] dp1 = new int[n][n];  // 存储i到j的乘积
        int[][] dp2 = new int[n][n];  // 存储i到j的异或

        int count = 0;
        for (int i = 0; i < n; i++) {
            for(int j = i; j < n; j++){
                if (i == j){
                    dp1[i][j] = arr[i];
                    dp2[i][j] = arr[i];
                }else {
                    dp1[i][j] = dp1[i][j-1] * arr[j];
                    dp2[i][j] = dp2[i][j-1] ^ arr[j];
                }
                if (dp1[i][j] == dp2[i][j]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

}

package 学校算法比赛;

import java.util.Scanner;

public class 合数的双亲质数 {

    // 判断一个数是不是质数
    public static boolean isPrimeNum(int n){
        for (int i = 2; i < n; i++) {
            if (n%2==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();

        }

    }

}

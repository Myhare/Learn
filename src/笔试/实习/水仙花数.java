package 笔试.实习;

import java.util.Scanner;

public class 水仙花数 {


    public static void main(String[] args) {

        // 输入n、输出所有10-n的水仙花数
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        for(int i = n - 1; i > 10; i--){
            // 判断当前数字是不是水仙花数
            if (isShui(i)){
                System.out.println(i);
            }
        }


    }

    // 判断n是不是水仙花数
    public static boolean isShui(int n){
        int k = String.valueOf(n).length();
        int t = n;
        int sum = 0;
        while (t > 0){
            int a = t % 10;
            sum += Math.pow(a,k);
            t /= 10;
        }
        return sum == n;
    }


}

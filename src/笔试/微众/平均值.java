package 笔试.微众;

import java.util.HashMap;
import java.util.Scanner;

public class 平均值 {

    public static int u = 0;
    public static int v = 0;
    public static int count = 0;

    // 82%
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        u = scanner.nextInt();
        v = scanner.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }

        // 使用乘法解决相等的问题
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < n; j++){
                sum += nums[j];
                if (u * (j - i + 1) == v * sum){
                    count++;
                }
            }
        }
        System.out.println(count);
        scanner.close();
    }

}

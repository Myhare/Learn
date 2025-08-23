package 算法练习.蓝桥杯练习.真题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 特别数的和 {
    // 小明对数位中含有 2、0、1、9 的数字很感兴趣（不包括前导 0），在 1 到 40 中这样的数包括 1、2、9、10 至 32、39 和 40，共 28 个，他们的和是 574。
    // 请问，在 1 到 n 中，所有这样的数的和是多少？
    //    【输入格式】
    //    输入一行包含一个整数 n。
    //            【输出格式】
    //                输出一行，包含一个整数，表示满足条件的数的和。
    //            【样例输入】 40
    //            【样例输出】 574

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        List<Integer> list = new ArrayList<>();
        int sum = 0;

        int t = 0;
        for (int i = 1; i <= n; i++) {

            /*
            * 1 2 9 10
            * */

            t = i;
            while (t!=0){
                int t1 = t%10;
                // 说明数字中包含2 0 1 9
                if (t1 == 2 || t1 == 0 || t1 == 1 || t1 == 9){
                    list.add(i);
                    break;
                }
                t = t/10;
            }
        }

        for (Integer integer : list) {
            sum += integer;
        }
        System.out.println(sum);

    }
}

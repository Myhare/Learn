package 笔试.bilibili;

import java.util.Scanner;

public class 电梯 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[] times = new int[n]; // n个角色
        for (int i = 0; i < times.length; i++) {
            times[i] = in.nextInt();
        }

        int time1 = times[0];
        int time2 = times[1];

        for (int i = 2; i < n; i++) {
            // 直接往后循环
            if (time1 < time2){
                time1 += times[i];
            }else {
                time2 += times[i];
            }
        }
        System.out.println(Math.max(time1, time2));
    }

}

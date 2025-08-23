package 算法练习.比赛;

import java.util.Scanner;

public class MainJ {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();   // 有x个原石
        scanner.close();

        // 原石可以抽多少次
        int count = x / 160;    // count代表只用原石可以抽多少次
        int xNum = (count/10) * 3;   // 每10发可以得3星辉    xNum表示一共获得了多少个星辉
        int y = count % 10;        // y代表抽奖多出来的次数

        int count2 = 0;
        while (xNum >= 5){
            // 使用星辉抽奖
            int num = xNum / 5;   // 每5个星辉可以抽一次,num表示剩下的星辉可以抽的次数
            xNum = xNum % 5 + (num / 10)*3;    // 更新星辉的数量
            y = y + (num % 10);
            if (y >= 10){
                y = y % 10;
                xNum = xNum + 3;
            }
            count2 += num;
        }

        System.out.println(count+count2);

    }

}

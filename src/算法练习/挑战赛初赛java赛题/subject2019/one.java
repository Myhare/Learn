package 算法练习.挑战赛初赛java赛题.subject2019;

import java.util.Scanner;

public class one {
    /*
    /*某星球存在两种生物，A种生物有1个头6条腿，B种生物有3个头4条腿。来自地球的太空船刚刚在该星球降落，
    /*突然发现一大群这两种生物组成的队伍，由于时间紧，只数了头的数量和腿的数量，请帮助宇航员分析A、B两种生物各有多少个。
    /*输入说明：头的数量L腿的数量Z，（L，Z<=100000）；
    /*输出说明：A生物的数量B生物的数量（两个整数用一个空格隔开）；
    /*输入样例：10 32输出样例：4 2
    */
    public static void main(String[] args) {
        // 创建一个输入流
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入头的数量");
        int headerSum = scanner.nextInt();
        System.out.println("输入脚的数量");
        int footSum = scanner.nextInt();

        for (int a = 0; a < headerSum; a++) {
            for (int b = 0; b < headerSum; b++) {
                if (a*6+b*4==footSum && a+3*b==headerSum){
                    System.out.println(a + " " + b);
                }
            }
        }

    }

}

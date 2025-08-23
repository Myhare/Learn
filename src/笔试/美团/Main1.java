package 笔试.美团;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt(); // 浇水
        int y = in.nextInt(); // 施肥
        int z = in.nextInt(); // 需要达到的成长值

        int nowZ = 0; // 当前成长值
        int lastY = -2; // 上次施肥的时间
        int nowDay = 1; // 当前时间

        while (nowZ < z){
            if (nowDay > lastY + 2){
                // 施肥并浇水
                nowZ += (x + y);
                // 标记当前天数
                lastY = nowDay;
            }else {
                // 不能施肥，只能浇水
                nowZ += x;
            }
            nowDay++;
        }
        System.out.println(nowDay - 1);
    }

}

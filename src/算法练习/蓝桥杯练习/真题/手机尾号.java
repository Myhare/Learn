package 算法练习.蓝桥杯练习.真题;

import java.util.ArrayList;
import java.util.Scanner;

public class 手机尾号 {
    /*
        30年的改革开放，给中国带来了翻天覆地的变化。2011全年中国手机产量约为11.72亿部。手机已经成为百姓的基本日用品！ 给手机选个好听又好记的号码可能是许多人的心愿。
        但号源有限，只能辅以有偿选号的方法了。
        这个程序的目的就是：根据给定的手机尾号（4位），按照一定的规则来打分。其规则如下：
                1. 如果出现连号，不管升序还是降序，都加5分。例如：5678,4321都满足加分标准。
                2. 前三个数字相同，或后三个数字相同，都加3分。例如：4888,6665,7777都满足加分的标准。
        注意：7777因为满足这条标准两次，所以这条规则给它加了6分。
                3. 符合AABB或者ABAB模式的加1分。例如：2255,3939,7777都符合这个模式，所以都被加分。
        注意：7777因为满足这条标准两次，所以这条标准给它加了2分。
                4. 含有：6，8，9中任何一个数字，每出现一次加1分。例如4326,6875,9918都符合加分标准。其中，6875被加2分；9918被加3分。
        尾号最终得分就是每条标准的加分总和！
        要求程序从标准输入接收数据，在标准输出上输出结果。
        输入格式为：第一行是一个整数n（<100），表示下边有多少输入行，接下来是n行4位一组的数据，就是等待计算加分的手机尾号。
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        // 循环输入数据传入list中
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> resultList = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }

        for (String s : list) {

            // 判断是不是连号
            int i = 0;
            for (i = 0; i < 3; i++) {
                if (Math.abs(Integer.parseInt(s.charAt(i+1)+"") - Integer.parseInt(s.charAt(i)+"")) != 1){
                    break;
                }
            }
            if (i==3){   // 说明是连号,加五分
                result += 5;
            }

            // 判断前三个数字和后三个数字是不是相同的
            if (s.charAt(0)==s.charAt(1) && s.charAt(1)==s.charAt(2)){
                result+=3;
            }
            if (s.charAt(1)==s.charAt(2) && s.charAt(2)==s.charAt(3)){
                result+=3;
            }
            // 判断是不是ABAB模式
            if (s.charAt(0)==s.charAt(2) && s.charAt(1)==s.charAt(3)){
                result+=1;
            }
            // 判断是不是AABB模式
            if (s.charAt(0)==s.charAt(1) && s.charAt(2)==s.charAt(3) && s.charAt(0)!=s.charAt(2)){
                result+=1;
            }
            // 判断有没有含有6,8,9三个数字，每出现一次加一分
            for (int j = 0; j < 4; j++) {
                if (s.charAt(j)=='6' || s.charAt(j)=='8' || s.charAt(j)=='9'){
                    result+=1;
                }
            }
            resultList.add(Integer.toString(result));
            result=0;
        }

        for (String s : resultList) {
            System.out.println(s);
        }

    }

}

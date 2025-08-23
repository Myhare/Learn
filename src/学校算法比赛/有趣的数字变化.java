package 学校算法比赛;

import java.util.Scanner;

public class 有趣的数字变化 {

    /*
        给你两个正整数L，R，其中L<R，每一次我们都给L+1，一直加到L==R停止。我们注意到每次L执行加一操作时，会产生数位变化。
        例如：
        如果L=909，然后加一，将导致909的个位和十位数字将被更改；
        如果L=9，然后加一，将导致9的个位和十位数字将被更改；
        如果L=489999，结果将是490000，其中有五个位数数字发生更改。
        我们想你求出，从L一直加一直到等于R，的过程中，总共发生了多少次数位变化。
     */

    // 如果个位数不是9，+1的话位数变化为1
    // 如果个位数是9，位数加一，然后判断前一位的数是不是9，如果是9再+1，循环下去
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int n = scanner.nextInt();

        int re = 0;  // 位数的变化

        for (int i = l; i < n; i++){
            int t = i;
            int k = t%10;  // k代表个位数的值
            if (k==9){
                re++;
                // 进行循环
                while (k==9 && t!=0){
                    t = t/10;
                    k = t%10;
                    re++;
                }
            }else {
                re++;  // 位数加一
            }
        }
        System.out.println(re);

    }

}

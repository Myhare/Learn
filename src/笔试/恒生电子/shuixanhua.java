package 笔试.恒生电子;

import java.util.Scanner;

public class shuixanhua {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // // 找出所有的10到n的水仙花数
        for (int i = n; i > 10; i--){
            if (isS(i)){
                System.out.println(i);
            }
        }
        in.close();
    }

    /**
     * 判断n是不是水仙花数
     */
    public static boolean isS(int n){
        // 判断n是几位数
        int a = 0;  // a为当前n的位数
        int t = n;
        while(t > 0){
            t = t / 10;
            a++;
            if (t == 0){
                break;
            }
        }
        t = n;
        // 此时a为当前n的位数
        // 求n是不是水仙花数
        int aSum = 0;
        while (t > 0){
            // 获取当前n的个位数
            int g = t %10;
            aSum += getRe(g, a);
            t = t /10;
        }
        return aSum == n;
    }

    /**
     * 求a的b次方
     */
    public static int getRe(int a,int b){
        int re = a;
        // 因为re=a，这里少循环一次
        while (b > 1){
            re *= a;
            b--;
        }
        return re;
    }

}

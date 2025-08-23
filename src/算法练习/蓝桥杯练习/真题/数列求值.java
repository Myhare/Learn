package 算法练习.蓝桥杯练习.真题;

public class 数列求值 {
//    给定数列1, 1, 1, 3, 5, 9, 17, …，从第4 项开始，每项都是前3 项的和。求
//    第20190324 项的最后4 位数字。

    public static void main(String[] args) {

        // int a = 1, b = 1, c = 1;
        // int sum = 0;
        // for (int i = 4; i <= 20190324; i++) {
        //     // 因为这里只需要求最后四位数字，所以只需要对10000求模运算
        //     sum = a + b + c;
        //     sum = sum % 10000;
        //     a = b % 10000;
        //     b = c % 10000;
        //     c = sum;
        // }
        //
        // System.out.println(sum);
        int[] a = new int[20190324];
        a[0] = 1;
        a[1] = 1;
        a[2] = 1;
        for (int i = 3;i<=20190323;i++){
            a[i] = (a[i-1]+a[i-2]+a[i-3]) % 10000;
        }
        System.out.println(a[20190323]);

    }

}

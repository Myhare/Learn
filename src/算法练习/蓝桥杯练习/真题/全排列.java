package 算法练习.蓝桥杯练习.真题;

import java.util.Scanner;

public class 全排列 {

    // 给定N个不同的字符，将这N个字符全排列，返回能排列的数
    public static int getNum(String s,int N){

        if (N == 1){
            return 1;
        }
        return getNum(s,N-1) + N;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int num = getNum(s, s.length());
        System.out.println(num);
    }

}

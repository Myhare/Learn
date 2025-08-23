package 算法练习.挑战赛初赛java赛题.other;

import java.util.Scanner;

public class subject01 {
    // 给定字符数组，统计字母类型（a-z）、数字类型（0-9）和符号类型（除字母、数字及空格以外的其他字符）的字符出现次数。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int intNum=0;
        int letterNum = 0;
        int charNum = 0;
        String s = scanner.nextLine();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i)>=0 && s.charAt(i)<10 || s.charAt(i)>=65 && s.charAt(i)<=90){
                intNum++;
            }else if (s.charAt(i)>=97 && s.charAt(i)<=122){
                letterNum++;
            }else {
                charNum++;
            }
        }
        System.out.println(intNum);
        System.out.println(letterNum);
        System.out.println(charNum);
    }
}

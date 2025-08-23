package 笔试.数字马力;

import java.util.Arrays;
import java.util.Scanner;

public class 字符串内排序 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        String reS = new String(charArray);
        System.out.println(reS);
    }

}

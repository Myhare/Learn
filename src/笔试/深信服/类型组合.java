package 笔试.深信服;

import java.util.HashSet;
import java.util.Scanner;

public class 类型组合 {

    public static HashSet<String> set = new HashSet<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        // 求s的所有排列组合数量
        set = new HashSet<>();


        System.out.println(set.size());
    }

    public static void backTracking(String s, boolean[] flags ,String path){
        if (path.length() > 0){
            set.add(path);
        }
        for (int i = 0; i < s.length(); i++) {
            if (flags[i]){
                continue;
            }
            flags[i] = true;
            backTracking(s, flags, path + s.charAt(i));
        }
    }

}
